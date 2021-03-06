package com.squareup.okhttp.internal.http;

import c.d;
import c.e;
import c.f;
import c.k;
import c.m;
import c.r;
import c.s;
import c.t;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class HttpEngine
{
  private static final ResponseBody EMPTY_BODY = new ResponseBody()
  {
    public final long contentLength()
    {
      return 0L;
    }
    
    public final MediaType contentType()
    {
      return null;
    }
    
    public final f source()
    {
      return new d();
    }
  };
  public static final int MAX_FOLLOW_UPS = 20;
  private Address address;
  public final boolean bufferRequestBody;
  private e bufferedRequestBody;
  private Response cacheResponse;
  private CacheStrategy cacheStrategy;
  private final boolean callerWritesRequestBody;
  final OkHttpClient client;
  private Connection connection;
  private final boolean forWebSocket;
  private Request networkRequest;
  private final Response priorResponse;
  private r requestBodyOut;
  private Route route;
  private RouteSelector routeSelector;
  long sentRequestMillis = -1L;
  private CacheRequest storeRequest;
  private boolean transparentGzip;
  private Transport transport;
  private final Request userRequest;
  private Response userResponse;
  
  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Connection paramConnection, RouteSelector paramRouteSelector, RetryableSink paramRetryableSink, Response paramResponse)
  {
    this.client = paramOkHttpClient;
    this.userRequest = paramRequest;
    this.bufferRequestBody = paramBoolean1;
    this.callerWritesRequestBody = paramBoolean2;
    this.forWebSocket = paramBoolean3;
    this.connection = paramConnection;
    this.routeSelector = paramRouteSelector;
    this.requestBodyOut = paramRetryableSink;
    this.priorResponse = paramResponse;
    if (paramConnection != null)
    {
      Internal.instance.setOwner(paramConnection, this);
      this.route = paramConnection.getRoute();
      return;
    }
    this.route = null;
  }
  
  private Response cacheWritingResponse(final CacheRequest paramCacheRequest, Response paramResponse)
  {
    if (paramCacheRequest == null) {}
    r localr;
    do
    {
      return paramResponse;
      localr = paramCacheRequest.body();
    } while (localr == null);
    paramCacheRequest = new s()
    {
      boolean cacheRequestClosed;
      
      public void close()
      {
        if ((!this.cacheRequestClosed) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.cacheRequestClosed = true;
          paramCacheRequest.abort();
        }
        this.val$source.close();
      }
      
      public long read(d paramAnonymousd, long paramAnonymousLong)
      {
        try
        {
          paramAnonymousLong = this.val$source.read(paramAnonymousd, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!this.cacheRequestClosed)
            {
              this.cacheRequestClosed = true;
              this.val$cacheBody.close();
            }
            return -1L;
          }
        }
        catch (IOException paramAnonymousd)
        {
          if (!this.cacheRequestClosed)
          {
            this.cacheRequestClosed = true;
            paramCacheRequest.abort();
          }
          throw paramAnonymousd;
        }
        paramAnonymousd.a(this.val$cacheBody.a(), paramAnonymousd.b - paramAnonymousLong, paramAnonymousLong);
        this.val$cacheBody.q();
        return paramAnonymousLong;
      }
      
      public t timeout()
      {
        return this.val$source.timeout();
      }
    };
    return paramResponse.newBuilder().body(new RealResponseBody(paramResponse.headers(), m.a(paramCacheRequest))).build();
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
  {
    int j = 0;
    Headers.Builder localBuilder = new Headers.Builder();
    int k = paramHeaders1.size();
    int i = 0;
    while (i < k)
    {
      String str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((!OkHeaders.isEndToEnd(str1)) || (paramHeaders2.get(str1) == null))) {
        localBuilder.add(str1, str2);
      }
      i += 1;
    }
    k = paramHeaders2.size();
    i = j;
    while (i < k)
    {
      paramHeaders1 = paramHeaders2.name(i);
      if ((!"Content-Length".equalsIgnoreCase(paramHeaders1)) && (OkHeaders.isEndToEnd(paramHeaders1))) {
        localBuilder.add(paramHeaders1, paramHeaders2.value(i));
      }
      i += 1;
    }
    return localBuilder.build();
  }
  
  private void connect()
  {
    if (this.connection != null) {
      throw new IllegalStateException();
    }
    if (this.routeSelector == null)
    {
      this.address = createAddress(this.client, this.networkRequest);
      this.routeSelector = RouteSelector.get(this.address, this.networkRequest, this.client);
    }
    this.connection = nextConnection();
    this.route = this.connection.getRoute();
  }
  
  private void connectFailed(RouteSelector paramRouteSelector, IOException paramIOException)
  {
    if (Internal.instance.recycleCount(this.connection) > 0) {
      return;
    }
    paramRouteSelector.connectFailed(this.connection.getRoute(), paramIOException);
  }
  
  private static Address createAddress(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    CertificatePinner localCertificatePinner = null;
    String str = paramRequest.url().getHost();
    if ((str == null) || (str.length() == 0)) {
      throw new UnknownHostException(paramRequest.url().toString());
    }
    SSLSocketFactory localSSLSocketFactory;
    HostnameVerifier localHostnameVerifier;
    if (paramRequest.isHttps())
    {
      localSSLSocketFactory = paramOkHttpClient.getSslSocketFactory();
      localHostnameVerifier = paramOkHttpClient.getHostnameVerifier();
      localCertificatePinner = paramOkHttpClient.getCertificatePinner();
    }
    for (;;)
    {
      return new Address(str, Util.getEffectivePort(paramRequest.url()), paramOkHttpClient.getSocketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, paramOkHttpClient.getAuthenticator(), paramOkHttpClient.getProxy(), paramOkHttpClient.getProtocols(), paramOkHttpClient.getConnectionSpecs(), paramOkHttpClient.getProxySelector());
      localHostnameVerifier = null;
      localSSLSocketFactory = null;
    }
  }
  
  private Connection createNextConnection()
  {
    ConnectionPool localConnectionPool = this.client.getConnectionPool();
    for (;;)
    {
      Connection localConnection = localConnectionPool.get(this.address);
      if (localConnection == null) {
        break;
      }
      if ((this.networkRequest.method().equals("GET")) || (Internal.instance.isReadable(localConnection))) {
        return localConnection;
      }
      localConnection.getSocket().close();
    }
    return new Connection(localConnectionPool, this.routeSelector.next());
  }
  
  public static boolean hasBody(Response paramResponse)
  {
    if (paramResponse.request().method().equals("HEAD")) {}
    do
    {
      return false;
      int i = paramResponse.code();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
        return true;
      }
    } while ((OkHeaders.contentLength(paramResponse) == -1L) && (!"chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))));
    return true;
  }
  
  public static String hostHeader(URL paramURL)
  {
    if (Util.getEffectivePort(paramURL) != Util.getDefaultPort(paramURL.getProtocol())) {
      return paramURL.getHost() + ":" + paramURL.getPort();
    }
    return paramURL.getHost();
  }
  
  private boolean isRecoverable(IOException paramIOException)
  {
    if (!this.client.getRetryOnConnectionFailure()) {}
    while (((paramIOException instanceof SSLPeerUnverifiedException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof InterruptedIOException))) {
      return false;
    }
    return true;
  }
  
  private void maybeCache()
  {
    InternalCache localInternalCache = Internal.instance.internalCache(this.client);
    if (localInternalCache == null) {}
    do
    {
      return;
      if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
        break;
      }
    } while (!HttpMethod.invalidatesCache(this.networkRequest.method()));
    try
    {
      localInternalCache.remove(this.networkRequest);
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    this.storeRequest = localIOException.put(stripBody(this.userResponse));
  }
  
  private Request networkRequest(Request paramRequest)
  {
    Request.Builder localBuilder = paramRequest.newBuilder();
    if (paramRequest.header("Host") == null) {
      localBuilder.header("Host", hostHeader(paramRequest.url()));
    }
    if (((this.connection == null) || (this.connection.getProtocol() != Protocol.HTTP_1_0)) && (paramRequest.header("Connection") == null)) {
      localBuilder.header("Connection", "Keep-Alive");
    }
    if (paramRequest.header("Accept-Encoding") == null)
    {
      this.transparentGzip = true;
      localBuilder.header("Accept-Encoding", "gzip");
    }
    CookieHandler localCookieHandler = this.client.getCookieHandler();
    if (localCookieHandler != null)
    {
      Map localMap = OkHeaders.toMultimap(localBuilder.build().headers(), null);
      OkHeaders.addCookies(localBuilder, localCookieHandler.get(paramRequest.uri(), localMap));
    }
    if (paramRequest.header("User-Agent") == null) {
      localBuilder.header("User-Agent", Version.userAgent());
    }
    return localBuilder.build();
  }
  
  private Connection nextConnection()
  {
    Connection localConnection = createNextConnection();
    Internal.instance.connectAndSetOwner(this.client, localConnection, this, this.networkRequest);
    return localConnection;
  }
  
  private Response readNetworkResponse()
  {
    this.transport.finishRequest();
    Response localResponse2 = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
    Response localResponse1 = localResponse2;
    if (!this.forWebSocket) {
      localResponse1 = localResponse2.newBuilder().body(this.transport.openResponseBody(localResponse2)).build();
    }
    Internal.instance.setProtocol(this.connection, localResponse1.protocol());
    return localResponse1;
  }
  
  private static Response stripBody(Response paramResponse)
  {
    Response localResponse = paramResponse;
    if (paramResponse != null)
    {
      localResponse = paramResponse;
      if (paramResponse.body() != null) {
        localResponse = paramResponse.newBuilder().body(null).build();
      }
    }
    return localResponse;
  }
  
  private Response unzip(Response paramResponse)
  {
    if ((!this.transparentGzip) || (!"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")))) {}
    while (paramResponse.body() == null) {
      return paramResponse;
    }
    k localk = new k(paramResponse.body().source());
    Headers localHeaders = paramResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
    return paramResponse.newBuilder().headers(localHeaders).body(new RealResponseBody(localHeaders, m.a(localk))).build();
  }
  
  private static boolean validate(Response paramResponse1, Response paramResponse2)
  {
    if (paramResponse2.code() == 304) {}
    do
    {
      return true;
      paramResponse1 = paramResponse1.headers().getDate("Last-Modified");
      if (paramResponse1 == null) {
        break;
      }
      paramResponse2 = paramResponse2.headers().getDate("Last-Modified");
    } while ((paramResponse2 != null) && (paramResponse2.getTime() < paramResponse1.getTime()));
    return false;
  }
  
  public final Connection close()
  {
    if (this.bufferedRequestBody != null) {
      Util.closeQuietly(this.bufferedRequestBody);
    }
    while (this.userResponse == null)
    {
      if (this.connection != null) {
        Util.closeQuietly(this.connection.getSocket());
      }
      this.connection = null;
      return null;
      if (this.requestBodyOut != null) {
        Util.closeQuietly(this.requestBodyOut);
      }
    }
    Util.closeQuietly(this.userResponse.body());
    if ((this.transport != null) && (this.connection != null) && (!this.transport.canReuseConnection()))
    {
      Util.closeQuietly(this.connection.getSocket());
      this.connection = null;
      return null;
    }
    if ((this.connection != null) && (!Internal.instance.clearOwner(this.connection))) {
      this.connection = null;
    }
    Connection localConnection = this.connection;
    this.connection = null;
    return localConnection;
  }
  
  public final void disconnect()
  {
    if (this.transport != null) {}
    try
    {
      this.transport.disconnect(this);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final Request followUpRequest()
  {
    if (this.userResponse == null) {
      throw new IllegalStateException();
    }
    if (getRoute() != null) {}
    for (Object localObject = getRoute().getProxy();; localObject = this.client.getProxy()) {
      switch (this.userResponse.code())
      {
      default: 
        return null;
      }
    }
    if (((Proxy)localObject).type() != Proxy.Type.HTTP) {
      throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    }
    return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, (Proxy)localObject);
    if ((!this.userRequest.method().equals("GET")) && (!this.userRequest.method().equals("HEAD"))) {
      return null;
    }
    if (!this.client.getFollowRedirects()) {
      return null;
    }
    localObject = this.userResponse.header("Location");
    if (localObject == null) {
      return null;
    }
    localObject = new URL(this.userRequest.url(), (String)localObject);
    if ((!((URL)localObject).getProtocol().equals("https")) && (!((URL)localObject).getProtocol().equals("http"))) {
      return null;
    }
    if ((!((URL)localObject).getProtocol().equals(this.userRequest.url().getProtocol())) && (!this.client.getFollowSslRedirects())) {
      return null;
    }
    Request.Builder localBuilder = this.userRequest.newBuilder();
    if (HttpMethod.permitsRequestBody(this.userRequest.method()))
    {
      localBuilder.method("GET", null);
      localBuilder.removeHeader("Transfer-Encoding");
      localBuilder.removeHeader("Content-Length");
      localBuilder.removeHeader("Content-Type");
    }
    if (!sameConnection((URL)localObject)) {
      localBuilder.removeHeader("Authorization");
    }
    return localBuilder.url((URL)localObject).build();
  }
  
  public final e getBufferedRequestBody()
  {
    Object localObject = this.bufferedRequestBody;
    if (localObject != null) {
      return (e)localObject;
    }
    localObject = getRequestBody();
    if (localObject != null)
    {
      localObject = m.a((r)localObject);
      this.bufferedRequestBody = ((e)localObject);
      return (e)localObject;
    }
    return null;
  }
  
  public final Connection getConnection()
  {
    return this.connection;
  }
  
  public final Request getRequest()
  {
    return this.userRequest;
  }
  
  public final r getRequestBody()
  {
    if (this.cacheStrategy == null) {
      throw new IllegalStateException();
    }
    return this.requestBodyOut;
  }
  
  public final Response getResponse()
  {
    if (this.userResponse == null) {
      throw new IllegalStateException();
    }
    return this.userResponse;
  }
  
  public final Route getRoute()
  {
    return this.route;
  }
  
  public final boolean hasResponse()
  {
    return this.userResponse != null;
  }
  
  final boolean permitsRequestBody()
  {
    return HttpMethod.permitsRequestBody(this.userRequest.method());
  }
  
  public final void readResponse()
  {
    if (this.userResponse != null) {}
    label423:
    label425:
    label435:
    do
    {
      do
      {
        return;
        if ((this.networkRequest == null) && (this.cacheResponse == null)) {
          throw new IllegalStateException("call sendRequest() first!");
        }
      } while (this.networkRequest == null);
      if (this.forWebSocket) {
        this.transport.writeRequestHeaders(this.networkRequest);
      }
      Object localObject;
      for (;;)
      {
        for (localObject = readNetworkResponse();; localObject = new HttpEngine.NetworkInterceptorChain(this, 0, this.networkRequest).proceed(this.networkRequest))
        {
          receiveHeaders(((Response)localObject).headers());
          if (this.cacheResponse == null) {
            break label435;
          }
          if (!validate(this.cacheResponse, (Response)localObject)) {
            break label425;
          }
          this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), ((Response)localObject).headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody((Response)localObject)).build();
          ((Response)localObject).body().close();
          releaseConnection();
          localObject = Internal.instance.internalCache(this.client);
          ((InternalCache)localObject).trackConditionalCacheHit();
          ((InternalCache)localObject).update(this.cacheResponse, stripBody(this.userResponse));
          this.userResponse = unzip(this.userResponse);
          return;
          if (this.callerWritesRequestBody) {
            break;
          }
        }
        if ((this.bufferedRequestBody != null) && (this.bufferedRequestBody.a().b > 0L)) {
          this.bufferedRequestBody.c();
        }
        if (this.sentRequestMillis == -1L)
        {
          if ((OkHeaders.contentLength(this.networkRequest) == -1L) && ((this.requestBodyOut instanceof RetryableSink)))
          {
            long l = ((RetryableSink)this.requestBodyOut).contentLength();
            this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(l)).build();
          }
          this.transport.writeRequestHeaders(this.networkRequest);
        }
        if (this.requestBodyOut != null)
        {
          if (this.bufferedRequestBody != null) {
            this.bufferedRequestBody.close();
          }
          for (;;)
          {
            if (!(this.requestBodyOut instanceof RetryableSink)) {
              break label423;
            }
            this.transport.writeRequestBody((RetryableSink)this.requestBodyOut);
            break;
            this.requestBodyOut.close();
          }
        }
      }
      Util.closeQuietly(this.cacheResponse.body());
      this.userResponse = ((Response)localObject).newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody((Response)localObject)).build();
    } while (!hasBody(this.userResponse));
    maybeCache();
    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
  }
  
  public final void receiveHeaders(Headers paramHeaders)
  {
    CookieHandler localCookieHandler = this.client.getCookieHandler();
    if (localCookieHandler != null) {
      localCookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(paramHeaders, null));
    }
  }
  
  public final HttpEngine recover(IOException paramIOException)
  {
    return recover(paramIOException, this.requestBodyOut);
  }
  
  public final HttpEngine recover(IOException paramIOException, r paramr)
  {
    if ((this.routeSelector != null) && (this.connection != null)) {
      connectFailed(this.routeSelector, paramIOException);
    }
    if ((paramr == null) || ((paramr instanceof RetryableSink))) {}
    for (int i = 1; ((this.routeSelector == null) && (this.connection == null)) || ((this.routeSelector != null) && (!this.routeSelector.hasNext())) || (!isRecoverable(paramIOException)) || (i == 0); i = 0) {
      return null;
    }
    paramIOException = close();
    return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, paramIOException, this.routeSelector, (RetryableSink)paramr, this.priorResponse);
  }
  
  public final void releaseConnection()
  {
    if ((this.transport != null) && (this.connection != null)) {
      this.transport.releaseConnectionOnIdle();
    }
    this.connection = null;
  }
  
  public final boolean sameConnection(URL paramURL)
  {
    URL localURL = this.userRequest.url();
    return (localURL.getHost().equals(paramURL.getHost())) && (Util.getEffectivePort(localURL) == Util.getEffectivePort(paramURL)) && (localURL.getProtocol().equals(paramURL.getProtocol()));
  }
  
  public final void sendRequest()
  {
    if (this.cacheStrategy != null) {
      return;
    }
    if (this.transport != null) {
      throw new IllegalStateException();
    }
    Request localRequest = networkRequest(this.userRequest);
    InternalCache localInternalCache = Internal.instance.internalCache(this.client);
    if (localInternalCache != null) {}
    long l;
    for (Response localResponse = localInternalCache.get(localRequest);; localResponse = null)
    {
      this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), localRequest, localResponse).get();
      this.networkRequest = this.cacheStrategy.networkRequest;
      this.cacheResponse = this.cacheStrategy.cacheResponse;
      if (localInternalCache != null) {
        localInternalCache.trackResponse(this.cacheStrategy);
      }
      if ((localResponse != null) && (this.cacheResponse == null)) {
        Util.closeQuietly(localResponse.body());
      }
      if (this.networkRequest == null) {
        break label302;
      }
      if (this.connection == null) {
        connect();
      }
      this.transport = Internal.instance.newTransport(this.connection, this);
      if ((!this.callerWritesRequestBody) || (!permitsRequestBody()) || (this.requestBodyOut != null)) {
        break;
      }
      l = OkHeaders.contentLength(localRequest);
      if (!this.bufferRequestBody) {
        break label269;
      }
      if (l <= 2147483647L) {
        break label220;
      }
      throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
    }
    label220:
    if (l != -1L)
    {
      this.transport.writeRequestHeaders(this.networkRequest);
      this.requestBodyOut = new RetryableSink((int)l);
      return;
    }
    this.requestBodyOut = new RetryableSink();
    return;
    label269:
    this.transport.writeRequestHeaders(this.networkRequest);
    this.requestBodyOut = this.transport.createRequestBody(this.networkRequest, l);
    return;
    label302:
    if (this.connection != null)
    {
      Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
      this.connection = null;
    }
    if (this.cacheResponse != null) {}
    for (this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();; this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build())
    {
      this.userResponse = unzip(this.userResponse);
      return;
    }
  }
  
  public final void writingRequestHeaders()
  {
    if (this.sentRequestMillis != -1L) {
      throw new IllegalStateException();
    }
    this.sentRequestMillis = System.currentTimeMillis();
  }
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\com\squareup\okhttp\internal\http\HttpEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */