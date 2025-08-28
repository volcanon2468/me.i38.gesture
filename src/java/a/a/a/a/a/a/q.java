package a.a.a.a.a.a;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class q extends m implements RandomAccess, h1, o2 {

    /* renamed from: b  reason: collision with root package name */
    private boolean[] f71b;
    private int c;

    static {
        new q(new boolean[0], 0, false);
    }

    q() {
        this(new boolean[10], 0, true);
    }

    private q(boolean[] zArr, int i, boolean z) {
        super(z);
        this.f71b = zArr;
        this.c = i;
    }

    private final String b(int i) {
        int i2 = this.c;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void c(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    @Override // a.a.a.a.a.a.h1
    public final /* bridge */ /* synthetic */ h1 a(int i) {
        if (i >= this.c) {
            return new q(Arrays.copyOf(this.f71b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void a(boolean z) {
        b();
        int i = this.c;
        boolean[] zArr = this.f71b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f71b = zArr2;
        }
        boolean[] zArr3 = this.f71b;
        int i2 = this.c;
        this.c = i2 + 1;
        zArr3[i2] = z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        boolean[] zArr = this.f71b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f71b, i, zArr2, i + 1, this.c - i);
            this.f71b = zArr2;
        }
        this.f71b[i] = booleanValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        a(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        byte[] bArr = i1.f26b;
        if (collection != null) {
            if (collection instanceof q) {
                q qVar = (q) collection;
                int i = qVar.c;
                if (i == 0) {
                    return false;
                }
                int i2 = this.c;
                if (Integer.MAX_VALUE - i2 >= i) {
                    int i3 = i2 + i;
                    boolean[] zArr = this.f71b;
                    if (i3 > zArr.length) {
                        this.f71b = Arrays.copyOf(zArr, i3);
                    }
                    System.arraycopy(qVar.f71b, 0, this.f71b, this.c, qVar.c);
                    this.c = i3;
                    ((AbstractList) this).modCount++;
                    return true;
                }
                throw new OutOfMemoryError();
            }
            return super.addAll(collection);
        }
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.c != qVar.c) {
                return false;
            }
            boolean[] zArr = qVar.f71b;
            for (int i = 0; i < this.c; i++) {
                if (this.f71b[i] != zArr[i]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        c(i);
        return Boolean.valueOf(this.f71b[i]);
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + i1.a(this.f71b[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            int i = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f71b[i2] == booleanValue) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        int i2;
        b();
        c(i);
        boolean[] zArr = this.f71b;
        boolean z = zArr[i];
        if (i < this.c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f71b;
        System.arraycopy(zArr, i2, zArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        c(i);
        boolean[] zArr = this.f71b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
