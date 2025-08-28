package a.a.a.a.a.a;

import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class q3 extends s3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q3(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // a.a.a.a.a.a.s3
    public final double a(Object obj, long j) {
        return Double.longBitsToDouble(this.f80a.getLong(obj, j));
    }

    @Override // a.a.a.a.a.a.s3
    public final void a(Object obj, long j, byte b2) {
        if (t3.h) {
            t3.a(obj, j, b2);
        } else {
            t3.b(obj, j, b2);
        }
    }

    @Override // a.a.a.a.a.a.s3
    public final void a(Object obj, long j, double d) {
        this.f80a.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // a.a.a.a.a.a.s3
    public final void a(Object obj, long j, float f) {
        this.f80a.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // a.a.a.a.a.a.s3
    public final void a(Object obj, long j, boolean z) {
        if (t3.h) {
            t3.a(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            t3.b(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // a.a.a.a.a.a.s3
    public final float b(Object obj, long j) {
        return Float.intBitsToFloat(this.f80a.getInt(obj, j));
    }

    @Override // a.a.a.a.a.a.s3
    public final boolean c(Object obj, long j) {
        return t3.h ? t3.f(obj, j) : t3.g(obj, j);
    }
}
