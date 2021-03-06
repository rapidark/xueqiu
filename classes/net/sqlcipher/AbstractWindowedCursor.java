package net.sqlcipher;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor
  extends AbstractCursor
{
  public CursorWindow mWindow;
  
  public void checkPosition()
  {
    super.checkPosition();
    if (this.mWindow == null) {
      throw new StaleDataException("Access closed cursor");
    }
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt)) {
        super.copyStringToBuffer(paramInt, paramCharArrayBuffer);
      }
      this.mWindow.copyStringToBuffer(this.mPos, paramInt, paramCharArrayBuffer);
      return;
    }
  }
  
  public byte[] getBlob(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        byte[] arrayOfByte = (byte[])getUpdatedField(paramInt);
        return arrayOfByte;
      }
      return this.mWindow.getBlob(this.mPos, paramInt);
    }
  }
  
  public double getDouble(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        double d = ((Number)getUpdatedField(paramInt)).doubleValue();
        return d;
      }
      return this.mWindow.getDouble(this.mPos, paramInt);
    }
  }
  
  public float getFloat(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        float f = ((Number)getUpdatedField(paramInt)).floatValue();
        return f;
      }
      return this.mWindow.getFloat(this.mPos, paramInt);
    }
  }
  
  public int getInt(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        paramInt = ((Number)getUpdatedField(paramInt)).intValue();
        return paramInt;
      }
      return this.mWindow.getInt(this.mPos, paramInt);
    }
  }
  
  public long getLong(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        long l = ((Number)getUpdatedField(paramInt)).longValue();
        return l;
      }
      return this.mWindow.getLong(this.mPos, paramInt);
    }
  }
  
  public short getShort(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        short s = ((Number)getUpdatedField(paramInt)).shortValue();
        return s;
      }
      return this.mWindow.getShort(this.mPos, paramInt);
    }
  }
  
  public String getString(int paramInt)
  {
    checkPosition();
    synchronized (this.mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        String str = (String)getUpdatedField(paramInt);
        return str;
      }
      return this.mWindow.getString(this.mPos, paramInt);
    }
  }
  
  public int getType(int paramInt)
  {
    checkPosition();
    return this.mWindow.getType(this.mPos, paramInt);
  }
  
  public CursorWindow getWindow()
  {
    return this.mWindow;
  }
  
  public boolean hasWindow()
  {
    return this.mWindow != null;
  }
  
  public boolean isBlob(int paramInt)
  {
    checkPosition();
    for (;;)
    {
      synchronized (this.mUpdatedRows)
      {
        if (isFieldUpdated(paramInt))
        {
          Object localObject1 = getUpdatedField(paramInt);
          if (localObject1 != null)
          {
            if (!(localObject1 instanceof byte[])) {
              break label70;
            }
            break label64;
            return bool;
          }
        }
        else
        {
          return this.mWindow.isBlob(this.mPos, paramInt);
        }
      }
      label64:
      boolean bool = true;
      continue;
      label70:
      bool = false;
    }
  }
  
  public boolean isFloat(int paramInt)
  {
    checkPosition();
    for (;;)
    {
      synchronized (this.mUpdatedRows)
      {
        if (isFieldUpdated(paramInt))
        {
          Object localObject1 = getUpdatedField(paramInt);
          if (localObject1 == null) {
            break label77;
          }
          if (!(localObject1 instanceof Float))
          {
            if (!(localObject1 instanceof Double)) {
              break label77;
            }
            break label71;
            return bool;
          }
        }
        else
        {
          return this.mWindow.isFloat(this.mPos, paramInt);
        }
      }
      label71:
      boolean bool = true;
      continue;
      label77:
      bool = false;
    }
  }
  
  public boolean isLong(int paramInt)
  {
    checkPosition();
    for (;;)
    {
      synchronized (this.mUpdatedRows)
      {
        if (isFieldUpdated(paramInt))
        {
          Object localObject1 = getUpdatedField(paramInt);
          if (localObject1 == null) {
            break label77;
          }
          if (!(localObject1 instanceof Integer))
          {
            if (!(localObject1 instanceof Long)) {
              break label77;
            }
            break label71;
            return bool;
          }
        }
        else
        {
          return this.mWindow.isLong(this.mPos, paramInt);
        }
      }
      label71:
      boolean bool = true;
      continue;
      label77:
      bool = false;
    }
  }
  
  public boolean isNull(int paramInt)
  {
    checkPosition();
    for (;;)
    {
      synchronized (this.mUpdatedRows)
      {
        if (isFieldUpdated(paramInt))
        {
          if (getUpdatedField(paramInt) == null)
          {
            bool = true;
            return bool;
          }
        }
        else {
          return this.mWindow.isNull(this.mPos, paramInt);
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isString(int paramInt)
  {
    checkPosition();
    for (;;)
    {
      synchronized (this.mUpdatedRows)
      {
        if (isFieldUpdated(paramInt))
        {
          Object localObject1 = getUpdatedField(paramInt);
          if (localObject1 != null)
          {
            if (!(localObject1 instanceof String)) {
              break label70;
            }
            break label64;
            return bool;
          }
        }
        else
        {
          return this.mWindow.isString(this.mPos, paramInt);
        }
      }
      label64:
      boolean bool = true;
      continue;
      label70:
      bool = false;
    }
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    if (this.mWindow != null) {
      this.mWindow.close();
    }
    this.mWindow = paramCursorWindow;
  }
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\net\sqlcipher\AbstractWindowedCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */