package a.a.a.a.a.a;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public abstract class k0 extends r {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f29b = Logger.getLogger(k0.class.getName());
    private static final boolean c = t3.c();
    public static final /* synthetic */ int d = 0;

    /* renamed from: a  reason: collision with root package name */
    l0 f30a;

    private k0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k0(j0 j0Var) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int a(int i, h2 h2Var, r2 r2Var) {
        int a2 = ((l) h2Var).a(r2Var);
        int e = e(i << 3);
        return e + e + a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(h2 h2Var, r2 r2Var) {
        int a2 = ((l) h2Var).a(r2Var);
        return e(a2) + a2;
    }

    public static int a(String str) {
        int length;
        try {
            length = y3.a(str);
        } catch (x3 unused) {
            length = str.getBytes(i1.f25a).length;
        }
        return e(length) + length;
    }

    public static k0 b(byte[] bArr, int i, int i2) {
        return new h0(bArr, 0, i2);
    }

    public static int c(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            j >>>= 14;
            i += 2;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int d(int i) {
        if (i >= 0) {
            return e(i);
        }
        return 10;
    }

    public static int e(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public final void a() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void a(byte b2);

    public abstract void a(int i);

    public abstract void a(int i, int i2);

    public abstract void a(int i, long j);

    public abstract void a(int i, c0 c0Var);

    public abstract void a(int i, String str);

    public abstract void a(int i, boolean z);

    public abstract void a(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, x3 x3Var) {
        f29b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) x3Var);
        byte[] bytes = str.getBytes(i1.f25a);
        try {
            int length = bytes.length;
            c(length);
            a(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new i0(e);
        }
    }

    public abstract void a(byte[] bArr, int i, int i2);

    public abstract int b();

    public abstract void b(int i);

    public abstract void b(int i, int i2);

    public abstract void b(int i, long j);

    public abstract void b(long j);

    public abstract void c(int i);

    public abstract void c(int i, int i2);

    public abstract void d(int i, int i2);
}
