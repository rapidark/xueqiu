package it.sephiroth.android.library.imagezoom.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public final class a
  extends Drawable
{
  protected Bitmap a;
  protected Paint b;
  protected int c;
  protected int d;
  
  public a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    if (this.a != null) {
      this.c = this.a.getWidth();
    }
    for (this.d = this.a.getHeight();; this.d = 0)
    {
      this.b = new Paint();
      this.b.setDither(true);
      this.b.setFilterBitmap(true);
      return;
      this.c = 0;
    }
  }
  
  public final Bitmap a()
  {
    return this.a;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if ((this.a != null) && (!this.a.isRecycled())) {
      paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, this.b);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.d;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.c;
  }
  
  public final int getMinimumHeight()
  {
    return this.d;
  }
  
  public final int getMinimumWidth()
  {
    return this.c;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.b.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.b.setColorFilter(paramColorFilter);
  }
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\it\sephiroth\android\library\imagezoom\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */