package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class s1 extends u1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s1(r1 r1Var) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.u1
    public final void a(Object obj, long j) {
        ((h1) t3.e(obj, j)).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.u1
    public final void a(Object obj, Object obj2, long j) {
        h1 h1Var = (h1) t3.e(obj, j);
        h1 h1Var2 = (h1) t3.e(obj2, j);
        int size = h1Var.size();
        int size2 = h1Var2.size();
        if (size > 0 && size2 > 0) {
            if (!h1Var.c()) {
                h1Var = h1Var.a(size2 + size);
            }
            h1Var.addAll(h1Var2);
        }
        if (size > 0) {
            h1Var2 = h1Var;
        }
        t3.a(obj, j, h1Var2);
    }
}
