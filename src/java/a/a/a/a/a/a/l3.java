package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class l3 extends j3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final /* synthetic */ int a(Object obj) {
        return ((k3) obj).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        if (k3.e().equals(obj2)) {
            return obj;
        }
        k3 k3Var = (k3) obj2;
        if (k3.e().equals(obj)) {
            return k3.a((k3) obj, k3Var);
        }
        ((k3) obj).a(k3Var);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final /* bridge */ /* synthetic */ void a(Object obj, int i, long j) {
        ((k3) obj).a(i << 3, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final /* synthetic */ void a(Object obj, b4 b4Var) {
        ((k3) obj).a(b4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final /* synthetic */ int b(Object obj) {
        return ((k3) obj).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final /* synthetic */ void b(Object obj, Object obj2) {
        ((e1) obj).zzc = (k3) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final /* bridge */ /* synthetic */ Object c(Object obj) {
        e1 e1Var = (e1) obj;
        k3 k3Var = e1Var.zzc;
        if (k3Var == k3.e()) {
            k3 f = k3.f();
            e1Var.zzc = f;
            return f;
        }
        return k3Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final /* synthetic */ Object d(Object obj) {
        return ((e1) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.j3
    public final void e(Object obj) {
        ((e1) obj).zzc.d();
    }
}
