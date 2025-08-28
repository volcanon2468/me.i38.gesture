package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class i4 extends e1 implements i2 {
    private static final i4 zzb;
    private int zzd;
    private int zze;

    static {
        i4 i4Var = new i4();
        zzb = i4Var;
        e1.a(i4.class, i4Var);
    }

    private i4() {
    }

    public static /* synthetic */ void a(i4 i4Var, int i) {
        i4Var.zze = i - 1;
        i4Var.zzd |= 1;
    }

    public static h4 l() {
        return (h4) zzb.d();
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
                    return new h4(null);
                }
                return new i4();
            }
            return e1.a(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzd", "zze", f4.f21a});
        }
        return (byte) 1;
    }
}
