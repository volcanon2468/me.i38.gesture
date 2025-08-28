package a.a.a.a.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class b extends k5 {
    static final k5 f = new b(new Object[0], 0);
    final transient Object[] d;
    private final transient int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Object[] objArr, int i) {
        this.d = objArr;
        this.e = i;
    }

    @Override // a.a.a.a.a.a.h5
    final int a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.k5, a.a.a.a.a.a.h5
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.d, 0, objArr, 0, this.e);
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public final int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public final boolean f() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public final Object[] g() {
        return this.d;
    }

    @Override // java.util.List
    public final Object get(int i) {
        c5.a(i, this.e, "index");
        Object obj = this.d[i];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
