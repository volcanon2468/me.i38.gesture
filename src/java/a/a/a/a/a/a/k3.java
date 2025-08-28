package a.a.a.a.a.a;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class k3 {
    private static final k3 f = new k3(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f33a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f34b;
    private Object[] c;
    private int d;
    private boolean e;

    private k3() {
        this(0, new int[8], new Object[8], true);
    }

    private k3(int i, int[] iArr, Object[] objArr, boolean z) {
        this.d = -1;
        this.f33a = i;
        this.f34b = iArr;
        this.c = objArr;
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k3 a(k3 k3Var, k3 k3Var2) {
        int i = k3Var.f33a + k3Var2.f33a;
        int[] copyOf = Arrays.copyOf(k3Var.f34b, i);
        System.arraycopy(k3Var2.f34b, 0, copyOf, k3Var.f33a, k3Var2.f33a);
        Object[] copyOf2 = Arrays.copyOf(k3Var.c, i);
        System.arraycopy(k3Var2.c, 0, copyOf2, k3Var.f33a, k3Var2.f33a);
        return new k3(i, copyOf, copyOf2, true);
    }

    private final void a(int i) {
        int[] iArr = this.f34b;
        if (i > iArr.length) {
            int i2 = this.f33a;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.f34b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public static k3 e() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k3 f() {
        return new k3(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int c;
        int e;
        int i;
        int i2 = this.d;
        if (i2 == -1) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.f33a; i4++) {
                int i5 = this.f34b[i4];
                int i6 = i5 >>> 3;
                int i7 = i5 & 7;
                if (i7 != 0) {
                    if (i7 == 1) {
                        ((Long) this.c[i4]).longValue();
                        i = k0.e(i6 << 3) + 8;
                    } else if (i7 == 2) {
                        int i8 = k0.d;
                        int b2 = ((c0) this.c[i4]).b();
                        i = k0.e(i6 << 3) + k0.e(b2) + b2;
                    } else if (i7 == 3) {
                        int i9 = i6 << 3;
                        int i10 = k0.d;
                        c = ((k3) this.c[i4]).a();
                        int e2 = k0.e(i9);
                        e = e2 + e2;
                    } else if (i7 != 5) {
                        throw new IllegalStateException(k1.a());
                    } else {
                        ((Integer) this.c[i4]).intValue();
                        i = k0.e(i6 << 3) + 4;
                    }
                    i3 += i;
                } else {
                    int i11 = i6 << 3;
                    c = k0.c(((Long) this.c[i4]).longValue());
                    e = k0.e(i11);
                }
                i = e + c;
                i3 += i;
            }
            this.d = i3;
            return i3;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final k3 a(k3 k3Var) {
        if (k3Var.equals(f)) {
            return this;
        }
        c();
        int i = this.f33a + k3Var.f33a;
        a(i);
        System.arraycopy(k3Var.f34b, 0, this.f34b, this.f33a, k3Var.f33a);
        System.arraycopy(k3Var.c, 0, this.c, this.f33a, k3Var.f33a);
        this.f33a = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i, Object obj) {
        c();
        a(this.f33a + 1);
        int[] iArr = this.f34b;
        int i2 = this.f33a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.f33a = i2 + 1;
    }

    public final void a(b4 b4Var) {
        if (this.f33a != 0) {
            for (int i = 0; i < this.f33a; i++) {
                int i2 = this.f34b[i];
                Object obj = this.c[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    b4Var.d(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    b4Var.a(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    b4Var.a(i4, (c0) obj);
                } else if (i3 == 3) {
                    b4Var.a(i4);
                    ((k3) obj).a(b4Var);
                    b4Var.b(i4);
                } else if (i3 != 5) {
                    throw new RuntimeException(k1.a());
                } else {
                    b4Var.e(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f33a; i2++) {
            j2.a(sb, i, String.valueOf(this.f34b[i2] >>> 3), this.c[i2]);
        }
    }

    public final int b() {
        int i = this.d;
        if (i == -1) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f33a; i3++) {
                int i4 = k0.d;
                int b2 = ((c0) this.c[i3]).b();
                int e = k0.e(b2) + b2;
                int e2 = k0.e(16);
                int e3 = k0.e(this.f34b[i3] >>> 3);
                int e4 = k0.e(8);
                i2 += e4 + e4 + e2 + e3 + k0.e(24) + e;
            }
            this.d = i2;
            return i2;
        }
        return i;
    }

    final void c() {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void d() {
        this.e = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof k3)) {
            k3 k3Var = (k3) obj;
            int i = this.f33a;
            if (i == k3Var.f33a) {
                int[] iArr = this.f34b;
                int[] iArr2 = k3Var.f34b;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        Object[] objArr = this.c;
                        Object[] objArr2 = k3Var.c;
                        int i3 = this.f33a;
                        for (int i4 = 0; i4 < i3; i4++) {
                            if (objArr[i4].equals(objArr2[i4])) {
                            }
                        }
                        return true;
                    } else if (iArr[i2] != iArr2[i2]) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f33a;
        int i2 = i + 527;
        int[] iArr = this.f34b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 * 31) + i4;
        Object[] objArr = this.c;
        int i7 = this.f33a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return (i6 * 31) + i3;
    }
}
