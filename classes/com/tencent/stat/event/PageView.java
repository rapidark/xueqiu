package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONObject;

public class PageView
  extends Event
{
  Long duration = null;
  String pageId;
  String referPageId;
  
  public PageView(Context paramContext, String paramString, int paramInt, Long paramLong)
  {
    super(paramContext, paramInt);
    this.referPageId = paramString;
    this.pageId = StatCommonHelper.getActivityName(paramContext);
    this.duration = paramLong;
  }
  
  public String getPageId()
  {
    return this.pageId;
  }
  
  public EventType getType()
  {
    return EventType.PAGE_VIEW;
  }
  
  public boolean onEncode(JSONObject paramJSONObject)
  {
    paramJSONObject.put("pi", this.pageId);
    StatCommonHelper.jsonPut(paramJSONObject, "rf", this.referPageId);
    if (this.duration != null) {
      paramJSONObject.put("du", this.duration);
    }
    return true;
  }
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\com\tencent\stat\event\PageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */