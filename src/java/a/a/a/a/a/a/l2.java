package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class l2 implements r2 {

    /* renamed from: a  reason: collision with root package name */
    private final h2 f39a;

    /* renamed from: b  reason: collision with root package name */
    private final j3 f40b;
    private final boolean c;
    private final q0 d;

    private l2(j3 j3Var, q0 q0Var, h2 h2Var) {
        this.f40b = j3Var;
        this.c = q0Var.a(h2Var);
        this.d = q0Var;
        this.f39a = h2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l2 a(j3 j3Var, q0 q0Var, h2 h2Var) {
        return new l2(j3Var, q0Var, h2Var);
    }

    @Override // a.a.a.a.a.a.r2
    public final void a(Object obj) {
        this.f40b.e(obj);
        this.d.b(obj);
        throw null;
    }

    @Override // a.a.a.a.a.a.r2
    public final void a(Object obj, b4 b4Var) {
        this.d.a(obj);
        throw null;
    }

    @Override // a.a.a.a.a.a.r2
    public final void a(Object obj, byte[] bArr, int i, int i2, o oVar) {
        e1 e1Var = (e1) obj;
        if (e1Var.zzc == k3.e()) {
            e1Var.zzc = k3.f();
        }
        a1 a1Var = (a1) obj;
        throw null;
    }

    @Override // a.a.a.a.a.a.r2
    public final boolean a(Object obj, Object obj2) {
        if (this.f40b.d(obj).equals(this.f40b.d(obj2))) {
            if (this.c) {
                this.d.a(obj);
                throw null;
            }
            return true;
        }
        return false;
    }

    @Override // a.a.a.a.a.a.r2
    public final int b(Object obj) {
        j3 j3Var = this.f40b;
        int b2 = j3Var.b(j3Var.d(obj));
        if (this.c) {
            this.d.a(obj);
            throw null;
        }
        return b2;
    }

    @Override // a.a.a.a.a.a.r2
    public final void b(Object obj, Object obj2) {
        t2.a(this.f40b, obj, obj2);
        if (this.c) {
            this.d.a(obj2);
            throw null;
        }
    }

    @Override // a.a.a.a.a.a.r2
    public final int c(Object obj) {
        int hashCode = this.f40b.d(obj).hashCode();
        if (this.c) {
            this.d.a(obj);
            throw null;
        }
        return hashCode;
    }

    @Override // a.a.a.a.a.a.r2
    public final Object d() {
        h2 h2Var = this.f39a;
        return h2Var instanceof e1 ? ((e1) h2Var).g() : h2Var.c().d();
    }

    @Override // a.a.a.a.a.a.r2
    public final boolean d(Object obj) {
        this.d.a(obj);
        throw null;
    }
}
