package a.a.a.a.a.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public abstract class k5 extends h5 implements List, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final j f35b = new i5(b.f, 0);
    public static final /* synthetic */ int c = 0;

    public static k5 a(Collection collection) {
        if (collection instanceof h5) {
            k5 b2 = ((h5) collection).b();
            if (b2.f()) {
                Object[] array = b2.toArray();
                return b(array, array.length);
            }
            return b2;
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            if (array2[i] == null) {
                throw new NullPointerException("at index " + i);
            }
        }
        return b(array2, length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k5 b(Object[] objArr, int i) {
        return i == 0 ? b.f : new b(objArr, i);
    }

    public static k5 h() {
        return b.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // java.util.List
    /* renamed from: a */
    public k5 subList(int i, int i2) {
        c5.a(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? b.f : new j5(this, i, i3);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // a.a.a.a.a.a.h5
    @Deprecated
    public final k5 b() {
        return this;
    }

    @Override // java.util.List
    /* renamed from: c */
    public final j listIterator(int i) {
        c5.b(i, size(), "index");
        return isEmpty() ? f35b : new i5(this, i);
    }

    @Override // a.a.a.a.a.a.h5, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // a.a.a.a.a.a.h5
    public final i d() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (b5.a(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!b5.a(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // a.a.a.a.a.a.h5, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }
}
