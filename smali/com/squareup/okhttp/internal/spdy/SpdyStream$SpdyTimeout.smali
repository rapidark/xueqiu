.class Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;
.super Lc/a;
.source "SpdyStream.java"


# instance fields
.field final synthetic this$0:Lcom/squareup/okhttp/internal/spdy/SpdyStream;


# direct methods
.method constructor <init>(Lcom/squareup/okhttp/internal/spdy/SpdyStream;)V
    .locals 0

    .prologue
    .line 593
    iput-object p1, p0, Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;->this$0:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    invoke-direct {p0}, Lc/a;-><init>()V

    return-void
.end method


# virtual methods
.method public exitAndThrowIfTimedOut()V
    .locals 2

    .prologue
    .line 599
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;->exit()Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/io/InterruptedIOException;

    const-string v1, "timeout"

    invoke-direct {v0, v1}, Ljava/io/InterruptedIOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 600
    :cond_0
    return-void
.end method

.method protected timedOut()V
    .locals 2

    .prologue
    .line 595
    iget-object v0, p0, Lcom/squareup/okhttp/internal/spdy/SpdyStream$SpdyTimeout;->this$0:Lcom/squareup/okhttp/internal/spdy/SpdyStream;

    sget-object v1, Lcom/squareup/okhttp/internal/spdy/ErrorCode;->CANCEL:Lcom/squareup/okhttp/internal/spdy/ErrorCode;

    invoke-virtual {v0, v1}, Lcom/squareup/okhttp/internal/spdy/SpdyStream;->closeLater(Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V

    .line 596
    return-void
.end method
