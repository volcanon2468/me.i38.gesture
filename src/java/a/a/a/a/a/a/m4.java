package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class m4 extends e1 implements i2 {
    private static final m4 zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        m4 m4Var = new m4();
        zzb = m4Var;
        e1.a(m4.class, m4Var);
    }

    private m4() {
    }

    public static /* synthetic */ void a(m4 m4Var, int i) {
        m4Var.zzd |= 1;
        m4Var.zze = i;
    }

    public static /* synthetic */ void a(m4 m4Var, String str) {
        str.getClass();
        m4Var.zzd |= 2;
        m4Var.zzf = str;
    }

    public static /* synthetic */ void b(m4 m4Var, int i) {
        m4Var.zzg = i - 1;
        m4Var.zzd |= 4;
    }

    public static k4 l() {
        return (k4) zzb.d();
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
                    return new k4(null);
                }
                return new m4();
            }
            return e1.a(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004ဌ\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", l4.f41a, "zzh"});
        }
        return (byte) 1;
    }
}
