package a.a.a.a.a.a;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class d extends o5 {
    private final transient n5 c;
    private final transient Object[] d;
    private final transient int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(n5 n5Var, Object[] objArr, int i, int i2) {
        this.c = n5Var;
        this.d = objArr;
        this.e = i2;
    }

    @Override // a.a.a.a.a.a.h5
    final int a(Object[] objArr, int i) {
        return b().a(objArr, 0);
    }

    @Override // a.a.a.a.a.a.h5, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.c.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // a.a.a.a.a.a.h5
    public final i d() {
        return b().listIterator(0);
    }

    @Override // a.a.a.a.a.a.o5
    final k5 e() {
        return new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.h5
    public final boolean f() {
        throw null;
    }

    @Override // a.a.a.a.a.a.h5, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return b().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }
}
