package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class LinkedHashTreeMap<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> NATURAL_ORDER;
  Comparator<? super K> comparator;
  private LinkedHashTreeMap<K, V>.EntrySet entrySet;
  final LinkedHashTreeMap.Node<K, V> header;
  private LinkedHashTreeMap<K, V>.KeySet keySet;
  int modCount = 0;
  int size = 0;
  LinkedHashTreeMap.Node<K, V>[] table;
  int threshold;
  
  static
  {
    if (!LinkedHashTreeMap.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      NATURAL_ORDER = new Comparator()
      {
        public final int compare(Comparable paramAnonymousComparable1, Comparable paramAnonymousComparable2)
        {
          return paramAnonymousComparable1.compareTo(paramAnonymousComparable2);
        }
      };
      return;
    }
  }
  
  public LinkedHashTreeMap()
  {
    this(NATURAL_ORDER);
  }
  
  public LinkedHashTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null) {}
    for (;;)
    {
      this.comparator = paramComparator;
      this.header = new LinkedHashTreeMap.Node();
      this.table = new LinkedHashTreeMap.Node[16];
      this.threshold = (this.table.length / 2 + this.table.length / 4);
      return;
      paramComparator = NATURAL_ORDER;
    }
  }
  
  private void doubleCapacity()
  {
    this.table = doubleCapacity(this.table);
    this.threshold = (this.table.length / 2 + this.table.length / 4);
  }
  
  static <K, V> LinkedHashTreeMap.Node<K, V>[] doubleCapacity(LinkedHashTreeMap.Node<K, V>[] paramArrayOfNode)
  {
    int m = paramArrayOfNode.length;
    LinkedHashTreeMap.Node[] arrayOfNode = new LinkedHashTreeMap.Node[m * 2];
    LinkedHashTreeMap.AvlIterator localAvlIterator = new LinkedHashTreeMap.AvlIterator();
    LinkedHashTreeMap.AvlBuilder localAvlBuilder1 = new LinkedHashTreeMap.AvlBuilder();
    LinkedHashTreeMap.AvlBuilder localAvlBuilder2 = new LinkedHashTreeMap.AvlBuilder();
    int i = 0;
    if (i < m)
    {
      Object localObject = paramArrayOfNode[i];
      if (localObject != null)
      {
        localAvlIterator.reset((LinkedHashTreeMap.Node)localObject);
        int k = 0;
        int j = 0;
        for (;;)
        {
          LinkedHashTreeMap.Node localNode = localAvlIterator.next();
          if (localNode == null) {
            break;
          }
          if ((localNode.hash & m) == 0) {
            j += 1;
          } else {
            k += 1;
          }
        }
        localAvlBuilder1.reset(j);
        localAvlBuilder2.reset(k);
        localAvlIterator.reset((LinkedHashTreeMap.Node)localObject);
        for (;;)
        {
          localObject = localAvlIterator.next();
          if (localObject == null) {
            break;
          }
          if ((((LinkedHashTreeMap.Node)localObject).hash & m) == 0) {
            localAvlBuilder1.add((LinkedHashTreeMap.Node)localObject);
          } else {
            localAvlBuilder2.add((LinkedHashTreeMap.Node)localObject);
          }
        }
        if (j <= 0) {
          break label208;
        }
        localObject = localAvlBuilder1.root();
        label175:
        arrayOfNode[i] = localObject;
        if (k <= 0) {
          break label213;
        }
      }
      label208:
      label213:
      for (localObject = localAvlBuilder2.root();; localObject = null)
      {
        arrayOfNode[(i + m)] = localObject;
        i += 1;
        break;
        localObject = null;
        break label175;
      }
    }
    return arrayOfNode;
  }
  
  private boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private void rebalance(LinkedHashTreeMap.Node<K, V> paramNode, boolean paramBoolean)
  {
    LinkedHashTreeMap.Node localNode1;
    LinkedHashTreeMap.Node localNode2;
    int i;
    label25:
    int j;
    label37:
    int k;
    LinkedHashTreeMap.Node localNode3;
    if (paramNode != null)
    {
      localNode1 = paramNode.left;
      localNode2 = paramNode.right;
      if (localNode1 != null)
      {
        i = localNode1.height;
        if (localNode2 == null) {
          break label131;
        }
        j = localNode2.height;
        k = i - j;
        if (k != -2) {
          break label183;
        }
        localNode1 = localNode2.left;
        localNode3 = localNode2.right;
        if (localNode3 == null) {
          break label137;
        }
        i = localNode3.height;
        label76:
        if (localNode1 == null) {
          break label143;
        }
        j = localNode1.height;
        label86:
        i = j - i;
        if ((i != -1) && ((i != 0) || (paramBoolean))) {
          break label149;
        }
        rotateLeft(paramNode);
        label113:
        if (paramBoolean) {
          break label256;
        }
      }
    }
    for (;;)
    {
      paramNode = paramNode.parent;
      break;
      i = 0;
      break label25;
      label131:
      j = 0;
      break label37;
      label137:
      i = 0;
      break label76;
      label143:
      j = 0;
      break label86;
      label149:
      assert (i == 1);
      rotateRight(localNode2);
      rotateLeft(paramNode);
      break label113;
      label183:
      if (k == 2)
      {
        localNode2 = localNode1.left;
        localNode3 = localNode1.right;
        if (localNode3 != null)
        {
          i = localNode3.height;
          label213:
          if (localNode2 == null) {
            break label263;
          }
          j = localNode2.height;
          label225:
          i = j - i;
          if ((i != 1) && ((i != 0) || (paramBoolean))) {
            break label269;
          }
          rotateRight(paramNode);
          label252:
          if (!paramBoolean) {
            break label300;
          }
        }
      }
      label256:
      label263:
      label269:
      label300:
      do
      {
        return;
        i = 0;
        break label213;
        j = 0;
        break label225;
        assert (i == -1);
        rotateLeft(localNode1);
        rotateRight(paramNode);
        break label252;
        break;
        if (k == 0)
        {
          paramNode.height = (i + 1);
          if (!paramBoolean) {
            break;
          }
          return;
        }
        assert ((k == -1) || (k == 1));
        paramNode.height = (Math.max(i, j) + 1);
      } while (!paramBoolean);
    }
  }
  
  private void replaceInParent(LinkedHashTreeMap.Node<K, V> paramNode1, LinkedHashTreeMap.Node<K, V> paramNode2)
  {
    LinkedHashTreeMap.Node localNode = paramNode1.parent;
    paramNode1.parent = null;
    if (paramNode2 != null) {
      paramNode2.parent = localNode;
    }
    if (localNode != null)
    {
      if (localNode.left == paramNode1)
      {
        localNode.left = paramNode2;
        return;
      }
      assert (localNode.right == paramNode1);
      localNode.right = paramNode2;
      return;
    }
    int i = paramNode1.hash;
    int j = this.table.length;
    this.table[(i & j - 1)] = paramNode2;
  }
  
  private void rotateLeft(LinkedHashTreeMap.Node<K, V> paramNode)
  {
    int k = 0;
    LinkedHashTreeMap.Node localNode1 = paramNode.left;
    LinkedHashTreeMap.Node localNode2 = paramNode.right;
    LinkedHashTreeMap.Node localNode3 = localNode2.left;
    LinkedHashTreeMap.Node localNode4 = localNode2.right;
    paramNode.right = localNode3;
    if (localNode3 != null) {
      localNode3.parent = paramNode;
    }
    replaceInParent(paramNode, localNode2);
    localNode2.left = paramNode;
    paramNode.parent = localNode2;
    int i;
    if (localNode1 != null)
    {
      i = localNode1.height;
      if (localNode3 == null) {
        break label135;
      }
    }
    label135:
    for (int j = localNode3.height;; j = 0)
    {
      paramNode.height = (Math.max(i, j) + 1);
      j = paramNode.height;
      i = k;
      if (localNode4 != null) {
        i = localNode4.height;
      }
      localNode2.height = (Math.max(j, i) + 1);
      return;
      i = 0;
      break;
    }
  }
  
  private void rotateRight(LinkedHashTreeMap.Node<K, V> paramNode)
  {
    int k = 0;
    LinkedHashTreeMap.Node localNode1 = paramNode.left;
    LinkedHashTreeMap.Node localNode2 = paramNode.right;
    LinkedHashTreeMap.Node localNode3 = localNode1.left;
    LinkedHashTreeMap.Node localNode4 = localNode1.right;
    paramNode.left = localNode4;
    if (localNode4 != null) {
      localNode4.parent = paramNode;
    }
    replaceInParent(paramNode, localNode1);
    localNode1.right = paramNode;
    paramNode.parent = localNode1;
    int i;
    if (localNode2 != null)
    {
      i = localNode2.height;
      if (localNode4 == null) {
        break label135;
      }
    }
    label135:
    for (int j = localNode4.height;; j = 0)
    {
      paramNode.height = (Math.max(i, j) + 1);
      j = paramNode.height;
      i = k;
      if (localNode3 != null) {
        i = localNode3.height;
      }
      localNode1.height = (Math.max(j, i) + 1);
      return;
      i = 0;
      break;
    }
  }
  
  private static int secondaryHash(int paramInt)
  {
    paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private Object writeReplace()
  {
    return new LinkedHashMap(this);
  }
  
  public final void clear()
  {
    Arrays.fill(this.table, null);
    this.size = 0;
    this.modCount += 1;
    LinkedHashTreeMap.Node localNode2 = this.header;
    LinkedHashTreeMap.Node localNode1;
    for (Object localObject = localNode2.next; localObject != localNode2; localObject = localNode1)
    {
      localNode1 = ((LinkedHashTreeMap.Node)localObject).next;
      ((LinkedHashTreeMap.Node)localObject).prev = null;
      ((LinkedHashTreeMap.Node)localObject).next = null;
    }
    localNode2.prev = localNode2;
    localNode2.next = localNode2;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return findByObject(paramObject) != null;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    LinkedHashTreeMap.EntrySet localEntrySet = this.entrySet;
    if (localEntrySet != null) {
      return localEntrySet;
    }
    localEntrySet = new LinkedHashTreeMap.EntrySet(this);
    this.entrySet = localEntrySet;
    return localEntrySet;
  }
  
  final LinkedHashTreeMap.Node<K, V> find(K paramK, boolean paramBoolean)
  {
    Object localObject3 = null;
    Comparator localComparator = this.comparator;
    LinkedHashTreeMap.Node[] arrayOfNode = this.table;
    int j = secondaryHash(paramK.hashCode());
    int k = j & arrayOfNode.length - 1;
    Object localObject1 = arrayOfNode[k];
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      Comparable localComparable;
      if (localComparator == NATURAL_ORDER)
      {
        localComparable = (Comparable)paramK;
        if (localComparable == null) {
          break label93;
        }
      }
      label93:
      for (i = localComparable.compareTo(((LinkedHashTreeMap.Node)localObject1).key);; i = localComparator.compare(paramK, ((LinkedHashTreeMap.Node)localObject1).key))
      {
        if (i != 0) {
          break label110;
        }
        localObject2 = localObject1;
        return (LinkedHashTreeMap.Node<K, V>)localObject2;
        localComparable = null;
        break;
      }
      label110:
      if (i < 0) {}
      for (localObject2 = ((LinkedHashTreeMap.Node)localObject1).left;; localObject2 = ((LinkedHashTreeMap.Node)localObject1).right)
      {
        if (localObject2 == null) {
          break label141;
        }
        localObject1 = localObject2;
        break;
      }
    }
    for (;;)
    {
      label141:
      localObject2 = localObject3;
      if (!paramBoolean) {
        break;
      }
      localObject2 = this.header;
      if (localObject1 == null)
      {
        if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable))) {
          throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
        }
        paramK = new LinkedHashTreeMap.Node((LinkedHashTreeMap.Node)localObject1, paramK, j, (LinkedHashTreeMap.Node)localObject2, ((LinkedHashTreeMap.Node)localObject2).prev);
        arrayOfNode[k] = paramK;
        i = this.size;
        this.size = (i + 1);
        if (i > this.threshold) {
          doubleCapacity();
        }
        this.modCount += 1;
        return paramK;
      }
      paramK = new LinkedHashTreeMap.Node((LinkedHashTreeMap.Node)localObject1, paramK, j, (LinkedHashTreeMap.Node)localObject2, ((LinkedHashTreeMap.Node)localObject2).prev);
      if (i < 0) {
        ((LinkedHashTreeMap.Node)localObject1).left = paramK;
      }
      for (;;)
      {
        rebalance((LinkedHashTreeMap.Node)localObject1, true);
        break;
        ((LinkedHashTreeMap.Node)localObject1).right = paramK;
      }
      i = 0;
    }
  }
  
  final LinkedHashTreeMap.Node<K, V> findByEntry(Map.Entry<?, ?> paramEntry)
  {
    LinkedHashTreeMap.Node localNode = findByObject(paramEntry.getKey());
    if ((localNode != null) && (equal(localNode.value, paramEntry.getValue()))) {}
    for (int i = 1; i != 0; i = 0) {
      return localNode;
    }
    return null;
  }
  
  final LinkedHashTreeMap.Node<K, V> findByObject(Object paramObject)
  {
    LinkedHashTreeMap.Node localNode = null;
    if (paramObject != null) {}
    try
    {
      localNode = find(paramObject, false);
      return localNode;
    }
    catch (ClassCastException paramObject) {}
    return null;
  }
  
  public final V get(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      return (V)((LinkedHashTreeMap.Node)paramObject).value;
    }
    return null;
  }
  
  public final Set<K> keySet()
  {
    LinkedHashTreeMap.KeySet localKeySet = this.keySet;
    if (localKeySet != null) {
      return localKeySet;
    }
    localKeySet = new LinkedHashTreeMap.KeySet(this);
    this.keySet = localKeySet;
    return localKeySet;
  }
  
  public final V put(K paramK, V paramV)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    paramK = find(paramK, true);
    Object localObject = paramK.value;
    paramK.value = paramV;
    return (V)localObject;
  }
  
  public final V remove(Object paramObject)
  {
    paramObject = removeInternalByKey(paramObject);
    if (paramObject != null) {
      return (V)((LinkedHashTreeMap.Node)paramObject).value;
    }
    return null;
  }
  
  final void removeInternal(LinkedHashTreeMap.Node<K, V> paramNode, boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      paramNode.prev.next = paramNode.next;
      paramNode.next.prev = paramNode.prev;
      paramNode.prev = null;
      paramNode.next = null;
    }
    LinkedHashTreeMap.Node localNode1 = paramNode.left;
    LinkedHashTreeMap.Node localNode2 = paramNode.right;
    LinkedHashTreeMap.Node localNode3 = paramNode.parent;
    int i;
    if ((localNode1 != null) && (localNode2 != null)) {
      if (localNode1.height > localNode2.height)
      {
        localNode1 = localNode1.last();
        removeInternal(localNode1, false);
        localNode2 = paramNode.left;
        if (localNode2 == null) {
          break label259;
        }
        i = localNode2.height;
        localNode1.left = localNode2;
        localNode2.parent = localNode1;
        paramNode.left = null;
      }
    }
    for (;;)
    {
      localNode2 = paramNode.right;
      if (localNode2 != null)
      {
        j = localNode2.height;
        localNode1.right = localNode2;
        localNode2.parent = localNode1;
        paramNode.right = null;
      }
      localNode1.height = (Math.max(i, j) + 1);
      replaceInParent(paramNode, localNode1);
      return;
      localNode1 = localNode2.first();
      break;
      if (localNode1 != null)
      {
        replaceInParent(paramNode, localNode1);
        paramNode.left = null;
      }
      for (;;)
      {
        rebalance(localNode3, false);
        this.size -= 1;
        this.modCount += 1;
        return;
        if (localNode2 != null)
        {
          replaceInParent(paramNode, localNode2);
          paramNode.right = null;
        }
        else
        {
          replaceInParent(paramNode, null);
        }
      }
      label259:
      i = 0;
    }
  }
  
  final LinkedHashTreeMap.Node<K, V> removeInternalByKey(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      removeInternal((LinkedHashTreeMap.Node)paramObject, true);
    }
    return (LinkedHashTreeMap.Node<K, V>)paramObject;
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:              E:\apk\xueqiu2\classes-dex2jar.jar!\com\google\gson\internal\LinkedHashTreeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */