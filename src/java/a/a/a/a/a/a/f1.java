package a.a.a.a.a.a;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class f1 extends m implements RandomAccess, h1, o2 {

    /* renamed from: b  reason: collision with root package name */
    private int[] f18b;
    private int c;

    static {
        new f1(new int[0], 0, false);
    }

    f1() {
        this(new int[10], 0, true);
    }

    private f1(int[] iArr, int i, boolean z) {
        super(z);
        this.f18b = iArr;
        this.c = i;
    }

    private final String d(int i) {
        int i2 = this.c;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void e(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    @Override // a.a.a.a.a.a.h1
    public final /* bridge */ /* synthetic */ h1 a(int i) {
        if (i >= this.c) {
            return new f1(Arrays.copyOf(this.f18b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        b();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(d(i));
        }
        int[] iArr = this.f18b;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f18b, i, iArr2, i + 1, this.c - i);
            this.f18b = iArr2;
        }
        this.f18b[i] = intValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        b(((Integer) obj).intValue());
        return true;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        byte[] bArr = i1.f26b;
        if (collection != null) {
            if (collection instanceof f1) {
                f1 f1Var = (f1) collection;
                int i = f1Var.c;
                if (i == 0) {
                    return false;
                }
                int i2 = this.c;
                if (Integer.MAX_VALUE - i2 >= i) {
                    int i3 = i2 + i;
                    int[] iArr = this.f18b;
                    if (i3 > iArr.length) {
                        this.f18b = Arrays.copyOf(iArr, i3);
                    }
                    System.arraycopy(f1Var.f18b, 0, this.f18b, this.c, f1Var.c);
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

    public final void b(int i) {
        b();
        int i2 = this.c;
        int[] iArr = this.f18b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f18b = iArr2;
        }
        int[] iArr3 = this.f18b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr3[i3] = i;
    }

    public final int c(int i) {
        e(i);
        return this.f18b[i];
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
        if (obj instanceof f1) {
            f1 f1Var = (f1) obj;
            if (this.c != f1Var.c) {
                return false;
            }
            int[] iArr = f1Var.f18b;
            for (int i = 0; i < this.c; i++) {
                if (this.f18b[i] != iArr[i]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Integer.valueOf(this.f18b[i]);
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.f18b[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            int i = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f18b[i2] == intValue) {
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
        e(i);
        int[] iArr = this.f18b;
        int i3 = iArr[i];
        if (i < this.c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f18b;
        System.arraycopy(iArr, i2, iArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        b();
        e(i);
        int[] iArr = this.f18b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
