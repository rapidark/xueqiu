package org.apache.http.client;

import java.util.Date;
import java.util.List;
import org.apache.http.cookie.Cookie;

public abstract interface CookieStore
{
  public abstract void addCookie(Cookie paramCookie);
  
  public abstract void clear();
  
  public abstract boolean clearExpired(Date paramDate);
  
  public abstract List<Cookie> getCookies();
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\org\apache\http\client\CookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */