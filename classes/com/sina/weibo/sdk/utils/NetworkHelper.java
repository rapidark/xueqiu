package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.List;

public class NetworkHelper
{
  public static void clearCookies(Context paramContext, String paramString)
  {
    CookieSyncManager.createInstance(paramContext);
    paramContext = CookieManager.getInstance();
    paramContext.setAcceptCookie(true);
    paramContext.removeSessionCookie();
    paramContext.removeAllCookie();
    CookieSyncManager.getInstance().sync();
  }
  
  public static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext, int paramInt)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(paramInt);
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = getActiveNetworkInfo(paramContext);
      if (paramContext != null) {}
    }
    else
    {
      return -1;
    }
    return paramContext.getType();
  }
  
  public static NetworkInfo.DetailedState getWifiConnectivityState(Context paramContext)
  {
    paramContext = getNetworkInfo(paramContext, 1);
    if (paramContext == null) {
      return NetworkInfo.DetailedState.FAILED;
    }
    return paramContext.getDetailedState();
  }
  
  public static int getWifiState(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {
      return 4;
    }
    return paramContext.getWifiState();
  }
  
  public static boolean hasInternetPermission(Context paramContext)
  {
    return (paramContext == null) || (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0);
  }
  
  public static boolean isMobileNetwork(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = getActiveNetworkInfo(paramContext);
      if (paramContext != null) {
        break label15;
      }
    }
    label15:
    while ((paramContext == null) || (paramContext.getType() != 0) || (!paramContext.isConnected())) {
      return false;
    }
    return true;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      paramContext = getActiveNetworkInfo(paramContext);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.isConnected()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isWifiValid(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = getActiveNetworkInfo(paramContext);
      return (paramContext != null) && (1 == paramContext.getType()) && (paramContext.isConnected());
    }
    return false;
  }
  
  public static boolean wifiConnection(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    String str1 = "\"" + paramString1 + "\"";
    Object localObject = paramContext.getConnectionInfo();
    if ((localObject != null) && ((paramString1.equals(((WifiInfo)localObject).getSSID())) || (str1.equals(((WifiInfo)localObject).getSSID())))) {
      return true;
    }
    localObject = paramContext.getScanResults();
    int i;
    if ((localObject != null) && (((List)localObject).size() != 0)) {
      i = ((List)localObject).size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        return false;
      }
      String str2 = ((ScanResult)((List)localObject).get(i)).SSID;
      if ((paramString1.equals(str2)) || (str1.equals(str2)))
      {
        paramString1 = new WifiConfiguration();
        paramString1.SSID = str1;
        paramString1.preSharedKey = ("\"" + paramString2 + "\"");
        paramString1.status = 2;
        return paramContext.enableNetwork(paramContext.addNetwork(paramString1), false);
      }
      i -= 1;
    }
  }
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\com\sina\weibo\sdk\utils\NetworkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */