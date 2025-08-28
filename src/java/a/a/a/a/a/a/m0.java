package a.a.a.a.a.a;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class m0 extends m implements RandomAccess, h1, o2 {

    /* renamed from: b  reason: collision with root package name */
    private double[] f45b;
    private int c;

    static {
        new m0(new double[0], 0, false);
    }

    m0() {
        this(new double[10], 0, true);
    }

    private m0(double[] dArr, int i, boolean z) {
        super(z);
        this.f45b = dArr;
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
            return new m0(Arrays.copyOf(this.f45b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void a(double d) {
        b();
        int i = this.c;
        double[] dArr = this.f45b;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f45b = dArr2;
        }
        double[] dArr3 = this.f45b;
        int i2 = this.c;
        this.c = i2 + 1;
        dArr3[i2] = d;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        b();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        double[] dArr = this.f45b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f45b, i, dArr2, i + 1, this.c - i);
            this.f45b = dArr2;
        }
        this.f45b[i] = doubleValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        byte[] bArr = i1.f26b;
        if (collection != null) {
            if (collection instanceof m0) {
                m0 m0Var = (m0) collection;
                int i = m0Var.c;
                if (i == 0) {
                    return false;
                }
                int i2 = this.c;
                if (Integer.MAX_VALUE - i2 >= i) {
                    int i3 = i2 + i;
                    double[] dArr = this.f45b;
                    if (i3 > dArr.length) {
                        this.f45b = Arrays.copyOf(dArr, i3);
                    }
                    System.arraycopy(m0Var.f45b, 0, this.f45b, this.c, m0Var.c);
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
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            if (this.c != m0Var.c) {
                return false;
            }
            double[] dArr = m0Var.f45b;
            for (int i = 0; i < this.c; i++) {
                if (Double.doubleToLongBits(this.f45b[i]) != Double.doubleToLongBits(dArr[i])) {
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
        return Double.valueOf(this.f45b[i]);
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            long doubleToLongBits = Double.doubleToLongBits(this.f45b[i2]);
            byte[] bArr = i1.f26b;
            i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            int i = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f45b[i2] == doubleValue) {
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
        double[] dArr = this.f45b;
        double d = dArr[i];
        if (i < this.c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f45b;
        System.arraycopy(dArr, i2, dArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        b();
        c(i);
        double[] dArr = this.f45b;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
