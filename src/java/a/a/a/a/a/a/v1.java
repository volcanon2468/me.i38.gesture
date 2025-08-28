package a.a.a.a.a.a;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class v1 extends m implements RandomAccess, h1, o2 {

    /* renamed from: b  reason: collision with root package name */
    private long[] f92b;
    private int c;

    static {
        new v1(new long[0], 0, false);
    }

    v1() {
        this(new long[10], 0, true);
    }

    private v1(long[] jArr, int i, boolean z) {
        super(z);
        this.f92b = jArr;
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
            return new v1(Arrays.copyOf(this.f92b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void a(long j) {
        b();
        int i = this.c;
        long[] jArr = this.f92b;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f92b = jArr2;
        }
        long[] jArr3 = this.f92b;
        int i2 = this.c;
        this.c = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        b();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(d(i));
        }
        long[] jArr = this.f92b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f92b, i, jArr2, i + 1, this.c - i);
            this.f92b = jArr2;
        }
        this.f92b[i] = longValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        a(((Long) obj).longValue());
        return true;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        byte[] bArr = i1.f26b;
        if (collection != null) {
            if (collection instanceof v1) {
                v1 v1Var = (v1) collection;
                int i = v1Var.c;
                if (i == 0) {
                    return false;
                }
                int i2 = this.c;
                if (Integer.MAX_VALUE - i2 >= i) {
                    int i3 = i2 + i;
                    long[] jArr = this.f92b;
                    if (i3 > jArr.length) {
                        this.f92b = Arrays.copyOf(jArr, i3);
                    }
                    System.arraycopy(v1Var.f92b, 0, this.f92b, this.c, v1Var.c);
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

    public final long c(int i) {
        e(i);
        return this.f92b[i];
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
        if (obj instanceof v1) {
            v1 v1Var = (v1) obj;
            if (this.c != v1Var.c) {
                return false;
            }
            long[] jArr = v1Var.f92b;
            for (int i = 0; i < this.c; i++) {
                if (this.f92b[i] != jArr[i]) {
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
        return Long.valueOf(this.f92b[i]);
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            long j = this.f92b[i2];
            byte[] bArr = i1.f26b;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            int i = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f92b[i2] == longValue) {
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
        long[] jArr = this.f92b;
        long j = jArr[i];
        if (i < this.c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f92b;
        System.arraycopy(jArr, i2, jArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        e(i);
        long[] jArr = this.f92b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
