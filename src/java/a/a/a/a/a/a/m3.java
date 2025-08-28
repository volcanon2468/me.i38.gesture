package a.a.a.a.a.a;

import java.util.ListIterator;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class m3 implements ListIterator {

    /* renamed from: a  reason: collision with root package name */
    final ListIterator f48a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f49b;
    final /* synthetic */ o3 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m3(o3 o3Var, int i) {
        o1 o1Var;
        this.c = o3Var;
        this.f49b = i;
        o1Var = this.c.f65a;
        this.f48a = o1Var.listIterator(this.f49b);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f48a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f48a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f48a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f48a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f48a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f48a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
