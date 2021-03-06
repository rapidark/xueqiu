package org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public class NTUserPrincipal
  implements Serializable, Principal
{
  private static final long serialVersionUID = -6870169797924406894L;
  private final String domain;
  private final String ntname;
  private final String username;
  
  public NTUserPrincipal(String paramString1, String paramString2)
  {
    Args.notNull(paramString2, "User name");
    this.username = paramString2;
    if (paramString1 != null) {}
    for (this.domain = paramString1.toUpperCase(Locale.ROOT); (this.domain != null) && (!this.domain.isEmpty()); this.domain = null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(this.domain);
      paramString1.append('\\');
      paramString1.append(this.username);
      this.ntname = paramString1.toString();
      return;
    }
    this.ntname = this.username;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NTUserPrincipal)) {
        break;
      }
      paramObject = (NTUserPrincipal)paramObject;
    } while ((LangUtils.equals(this.username, ((NTUserPrincipal)paramObject).username)) && (LangUtils.equals(this.domain, ((NTUserPrincipal)paramObject).domain)));
    return false;
  }
  
  public String getDomain()
  {
    return this.domain;
  }
  
  public String getName()
  {
    return this.ntname;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public int hashCode()
  {
    return LangUtils.hashCode(LangUtils.hashCode(17, this.username), this.domain);
  }
  
  public String toString()
  {
    return this.ntname;
  }
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\org\apache\http\auth\NTUserPrincipal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */