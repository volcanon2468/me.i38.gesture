package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class p4 extends e1 implements i2 {
    private static final p4 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        p4 p4Var = new p4();
        zzb = p4Var;
        e1.a(p4.class, p4Var);
    }

    private p4() {
    }

    public static /* synthetic */ void a(p4 p4Var, String str) {
        str.getClass();
        p4Var.zzd |= 1;
        p4Var.zze = str;
    }

    public static /* synthetic */ void b(p4 p4Var, String str) {
        str.getClass();
        p4Var.zzd |= 2;
        p4Var.zzf = str;
    }

    public static o4 l() {
        return (o4) zzb.d();
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
                    return new o4(null);
                }
                return new p4();
            }
            return e1.a(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
