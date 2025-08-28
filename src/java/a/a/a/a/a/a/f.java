package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class f extends k5 {
    private final transient Object[] d;
    private final transient int e;
    private final transient int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Object[] objArr, int i, int i2) {
        this.d = objArr;
        this.e = i;
        this.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        c5.a(i, this.f, "index");
        Object obj = this.d[i + i + this.e];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f;
    }
}
