package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f63a;

    /* renamed from: b  reason: collision with root package name */
    private final int f64b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(Object obj, int i) {
        this.f63a = obj;
        this.f64b = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o0) {
            o0 o0Var = (o0) obj;
            return this.f63a == o0Var.f63a && this.f64b == o0Var.f64b;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f63a) * 65535) + this.f64b;
    }
}
