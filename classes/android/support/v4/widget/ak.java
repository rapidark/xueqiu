package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class ak
  extends ViewGroup.MarginLayoutParams
{
  private static final int[] e = { 16843137 };
  public float a = 0.0F;
  boolean b;
  boolean c;
  Paint d;
  
  public ak()
  {
    super(-1, -1);
  }
  
  public ak(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e);
    this.a = paramContext.getFloat(0, 0.0F);
    paramContext.recycle();
  }
  
  public ak(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public ak(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\android\support\v4\widget\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */