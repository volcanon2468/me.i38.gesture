package a.a.a.a.a.a;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class o3 extends AbstractList implements RandomAccess, o1 {

    /* renamed from: a  reason: collision with root package name */
    private final o1 f65a;

    public o3(o1 o1Var) {
        this.f65a = o1Var;
    }

    @Override // a.a.a.a.a.a.o1
    public final Object b(int i) {
        return this.f65a.b(i);
    }

    @Override // a.a.a.a.a.a.o1
    public final o1 d() {
        return this;
    }

    @Override // a.a.a.a.a.a.o1
    public final List e() {
        return this.f65a.e();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((n1) this.f65a).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new n3(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new m3(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f65a.size();
    }
}
