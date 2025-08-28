package a.a.a.a.a.a;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class w0 extends m implements RandomAccess, h1, o2 {

    /* renamed from: b  reason: collision with root package name */
    private float[] f93b;
    private int c;

    static {
        new w0(new float[0], 0, false);
    }

    w0() {
        this(new float[10], 0, true);
    }

    private w0(float[] fArr, int i, boolean z) {
        super(z);
        this.f93b = fArr;
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
            return new w0(Arrays.copyOf(this.f93b, i), this.c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void a(float f) {
        b();
        int i = this.c;
        float[] fArr = this.f93b;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f93b = fArr2;
        }
        float[] fArr3 = this.f93b;
        int i2 = this.c;
        this.c = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        b();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        float[] fArr = this.f93b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f93b, i, fArr2, i + 1, this.c - i);
            this.f93b = fArr2;
        }
        this.f93b[i] = floatValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        a(((Float) obj).floatValue());
        return true;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        byte[] bArr = i1.f26b;
        if (collection != null) {
            if (collection instanceof w0) {
                w0 w0Var = (w0) collection;
                int i = w0Var.c;
                if (i == 0) {
                    return false;
                }
                int i2 = this.c;
                if (Integer.MAX_VALUE - i2 >= i) {
                    int i3 = i2 + i;
                    float[] fArr = this.f93b;
                    if (i3 > fArr.length) {
                        this.f93b = Arrays.copyOf(fArr, i3);
                    }
                    System.arraycopy(w0Var.f93b, 0, this.f93b, this.c, w0Var.c);
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
        if (obj instanceof w0) {
            w0 w0Var = (w0) obj;
            if (this.c != w0Var.c) {
                return false;
            }
            float[] fArr = w0Var.f93b;
            for (int i = 0; i < this.c; i++) {
                if (Float.floatToIntBits(this.f93b[i]) != Float.floatToIntBits(fArr[i])) {
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
        return Float.valueOf(this.f93b[i]);
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f93b[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            int i = this.c;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.f93b[i2] == floatValue) {
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
        float[] fArr = this.f93b;
        float f = fArr[i];
        if (i < this.c - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f93b;
        System.arraycopy(fArr, i2, fArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        b();
        c(i);
        float[] fArr = this.f93b;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
