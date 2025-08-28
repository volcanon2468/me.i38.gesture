package a.a.a.a.a.a;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class n3 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final Iterator f56a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ o3 f57b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n3(o3 o3Var) {
        o1 o1Var;
        this.f57b = o3Var;
        o1Var = this.f57b.f65a;
        this.f56a = o1Var.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f56a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f56a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
