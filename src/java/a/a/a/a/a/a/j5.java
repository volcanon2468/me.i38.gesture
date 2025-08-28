package a.a.a.a.a.a;

import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class j5 extends k5 {
    final transient int d;
    final transient int e;
    final /* synthetic */ k5 f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j5(k5 k5Var, int i, int i2) {
        this.f = k5Var;
        this.d = i;
        this.e = i2;
    }

    @Override // a.a.a.a.a.a.h5
    final int a() {
        return this.f.c() + this.d + this.e;
    }

    @Override // a.a.a.a.a.a.k5, java.util.List
    /* renamed from: a */
    public final k5 subList(int i, int i2) {
        c5.a(i, i2, this.e);
        k5 k5Var = this.f;
        int i3 = this.d;
        return k5Var.subList(i + i3, i2 + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public final int c() {
        return this.f.c() + this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public final boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    @CheckForNull
    public final Object[] g() {
        return this.f.g();
    }

    @Override // java.util.List
    public final Object get(int i) {
        c5.a(i, this.e, "index");
        return this.f.get(i + this.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
