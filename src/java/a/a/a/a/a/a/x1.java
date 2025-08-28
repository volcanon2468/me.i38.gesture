package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class x1 implements f2 {

    /* renamed from: a  reason: collision with root package name */
    private final f2[] f96a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1(f2... f2VarArr) {
        this.f96a = f2VarArr;
    }

    @Override // a.a.a.a.a.a.f2
    public final e2 a(Class cls) {
        f2[] f2VarArr = this.f96a;
        for (int i = 0; i < 2; i++) {
            f2 f2Var = f2VarArr[i];
            if (f2Var.b(cls)) {
                return f2Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // a.a.a.a.a.a.f2
    public final boolean b(Class cls) {
        f2[] f2VarArr = this.f96a;
        for (int i = 0; i < 2; i++) {
            if (f2VarArr[i].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
