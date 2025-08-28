package a.a.a.a.a.a;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class e extends o5 {
    private final transient n5 c;
    private final transient k5 d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(n5 n5Var, k5 k5Var) {
        this.c = n5Var;
        this.d = k5Var;
    }

    @Override // a.a.a.a.a.a.h5
    final int a(Object[] objArr, int i) {
        return this.d.a(objArr, 0);
    }

    @Override // a.a.a.a.a.a.o5, a.a.a.a.a.a.h5
    public final k5 b() {
        return this.d;
    }

    @Override // a.a.a.a.a.a.h5, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return this.c.get(obj) != null;
    }

    @Override // a.a.a.a.a.a.h5
    public final i d() {
        return this.d.listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public final boolean f() {
        throw null;
    }

    @Override // a.a.a.a.a.a.h5, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.c.size();
    }
}
