package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class e4 extends e1 implements i2 {
    private static final e4 zzb;
    private int zzd;
    private int zze;
    private m4 zzf;
    private t4 zzg;

    static {
        e4 e4Var = new e4();
        zzb = e4Var;
        e1.a(e4.class, e4Var);
    }

    private e4() {
    }

    public static e4 a(byte[] bArr, p0 p0Var) {
        return (e4) e1.a(zzb, bArr, p0Var);
    }

    public static /* synthetic */ void a(e4 e4Var, int i) {
        e4Var.zze = i - 1;
        e4Var.zzd |= 1;
    }

    public static /* synthetic */ void a(e4 e4Var, m4 m4Var) {
        m4Var.getClass();
        e4Var.zzf = m4Var;
        e4Var.zzd |= 2;
    }

    public static d4 l() {
        return (d4) zzb.d();
    }

    @Override // a.a.a.a.a.a.e1
    public final Object a(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zzb;
                    }
                    return new d4(null);
                }
                return new e4();
            }
            return e1.a(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", f4.f21a, "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
