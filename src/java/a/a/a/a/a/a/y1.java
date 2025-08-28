package a.a.a.a.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class y1 implements s2 {

    /* renamed from: b  reason: collision with root package name */
    private static final f2 f102b = new w1();

    /* renamed from: a  reason: collision with root package name */
    private final f2 f103a;

    public y1() {
        f2 f2Var;
        f2[] f2VarArr = new f2[2];
        f2VarArr[0] = y0.a();
        try {
            f2Var = (f2) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            f2Var = f102b;
        }
        f2VarArr[1] = f2Var;
        x1 x1Var = new x1(f2VarArr);
        byte[] bArr = i1.f26b;
        this.f103a = x1Var;
    }

    private static boolean a(e2 e2Var) {
        return e2Var.c() == 1;
    }

    @Override // a.a.a.a.a.a.s2
    public final r2 a(Class cls) {
        m2 a2;
        u1 a3;
        j3 c;
        q0 q0Var;
        c2 a4;
        j3 b2;
        q0 a5;
        t2.a(cls);
        e2 a6 = this.f103a.a(cls);
        if (a6.a()) {
            if (e1.class.isAssignableFrom(cls)) {
                b2 = t2.a();
                a5 = s0.b();
            } else {
                b2 = t2.b();
                a5 = s0.a();
            }
            return l2.a(b2, a5, a6.b());
        }
        if (e1.class.isAssignableFrom(cls)) {
            boolean a7 = a(a6);
            a2 = n2.b();
            a3 = u1.b();
            c = t2.a();
            q0Var = a7 ? s0.b() : null;
            a4 = d2.b();
        } else {
            boolean a8 = a(a6);
            a2 = n2.a();
            a3 = u1.a();
            if (a8) {
                c = t2.b();
                q0Var = s0.a();
            } else {
                c = t2.c();
                q0Var = null;
            }
            a4 = d2.a();
        }
        return k2.a(cls, a6, a2, a3, c, q0Var, a4);
    }
}
