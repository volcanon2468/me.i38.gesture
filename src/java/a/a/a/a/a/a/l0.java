package a.a.a.a.a.a;

import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class l0 implements b4 {

    /* renamed from: a  reason: collision with root package name */
    private final k0 f36a;

    private l0(k0 k0Var) {
        byte[] bArr = i1.f26b;
        this.f36a = k0Var;
        k0Var.f30a = this;
    }

    public static l0 a(k0 k0Var) {
        l0 l0Var = k0Var.f30a;
        return l0Var != null ? l0Var : new l0(k0Var);
    }

    @Override // a.a.a.a.a.a.b4
    @Deprecated
    public final void a(int i) {
        this.f36a.c(i, 3);
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, double d) {
        this.f36a.a(i, Double.doubleToRawLongBits(d));
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, float f) {
        this.f36a.a(i, Float.floatToRawIntBits(f));
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, int i2) {
        this.f36a.a(i, i2);
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, long j) {
        this.f36a.a(i, j);
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, c0 c0Var) {
        this.f36a.a(i, c0Var);
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, Object obj, r2 r2Var) {
        h2 h2Var = (h2) obj;
        h0 h0Var = (h0) this.f36a;
        h0Var.c((i << 3) | 2);
        h0Var.c(((l) h2Var).a(r2Var));
        r2Var.a((Object) h2Var, (b4) h0Var.f30a);
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, String str) {
        this.f36a.a(i, str);
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, List list) {
        int i2 = 0;
        if (!(list instanceof o1)) {
            while (i2 < list.size()) {
                this.f36a.a(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        o1 o1Var = (o1) list;
        while (i2 < list.size()) {
            Object b2 = o1Var.b(i2);
            if (b2 instanceof String) {
                this.f36a.a(i, (String) b2);
            } else {
                this.f36a.a(i, (c0) b2);
            }
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                k0 k0Var = this.f36a;
                int intValue = ((Integer) list.get(i2)).intValue();
                k0Var.d(i, (intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int intValue2 = ((Integer) list.get(i4)).intValue();
            i3 += k0.e((intValue2 >> 31) ^ (intValue2 + intValue2));
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            k0 k0Var2 = this.f36a;
            int intValue3 = ((Integer) list.get(i2)).intValue();
            k0Var2.c((intValue3 >> 31) ^ (intValue3 + intValue3));
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void a(int i, boolean z) {
        this.f36a.a(i, z);
    }

    @Override // a.a.a.a.a.a.b4
    @Deprecated
    public final void b(int i) {
        this.f36a.c(i, 4);
    }

    @Override // a.a.a.a.a.a.b4
    public final void b(int i, int i2) {
        this.f36a.b(i, i2);
    }

    @Override // a.a.a.a.a.a.b4
    public final void b(int i, long j) {
        this.f36a.a(i, j);
    }

    @Override // a.a.a.a.a.a.b4
    public final void b(int i, Object obj, r2 r2Var) {
        k0 k0Var = this.f36a;
        k0Var.c(i, 3);
        r2Var.a((Object) ((h2) obj), (b4) k0Var.f30a);
        k0Var.c(i, 4);
    }

    @Override // a.a.a.a.a.a.b4
    public final void b(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f36a.a(i, (c0) list.get(i2));
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void b(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.b(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += k0.d(((Integer) list.get(i4)).intValue());
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.b(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void c(int i, int i2) {
        this.f36a.d(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // a.a.a.a.a.a.b4
    public final void c(int i, long j) {
        this.f36a.b(i, (j >> 63) ^ (j + j));
    }

    @Override // a.a.a.a.a.a.b4
    public final void c(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.a(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.a(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void d(int i, int i2) {
        this.f36a.d(i, i2);
    }

    @Override // a.a.a.a.a.a.b4
    public final void d(int i, long j) {
        this.f36a.b(i, j);
    }

    @Override // a.a.a.a.a.a.b4
    public final void d(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.a(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.a(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void e(int i, int i2) {
        this.f36a.a(i, i2);
    }

    @Override // a.a.a.a.a.a.b4
    public final void e(int i, long j) {
        this.f36a.b(i, j);
    }

    @Override // a.a.a.a.a.a.b4
    public final void e(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.b(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += k0.c(((Long) list.get(i4)).longValue());
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.b(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void f(int i, int i2) {
        this.f36a.b(i, i2);
    }

    @Override // a.a.a.a.a.a.b4
    public final void f(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                k0 k0Var = this.f36a;
                long longValue = ((Long) list.get(i2)).longValue();
                k0Var.b(i, (longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            long longValue2 = ((Long) list.get(i4)).longValue();
            i3 += k0.c((longValue2 >> 63) ^ (longValue2 + longValue2));
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            k0 k0Var2 = this.f36a;
            long longValue3 = ((Long) list.get(i2)).longValue();
            k0Var2.b((longValue3 >> 63) ^ (longValue3 + longValue3));
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void g(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.b(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += k0.c(((Long) list.get(i4)).longValue());
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.b(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void h(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.a(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.a(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void i(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.a(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.a(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void j(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.a(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.a(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void k(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.a(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.a(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void l(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.a(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.a(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void m(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.b(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += k0.d(((Integer) list.get(i4)).intValue());
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.b(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // a.a.a.a.a.a.b4
    public final void n(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f36a.d(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f36a.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += k0.e(((Integer) list.get(i4)).intValue());
        }
        this.f36a.c(i3);
        while (i2 < list.size()) {
            this.f36a.c(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }
}
