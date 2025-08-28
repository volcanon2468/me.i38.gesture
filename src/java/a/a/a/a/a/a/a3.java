package a.a.a.a.a.a;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class a3 implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f4a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5b;
    private Iterator c;
    final /* synthetic */ f3 d;

    private final Iterator b() {
        Map map;
        if (this.c == null) {
            map = this.d.c;
            this.c = map.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f4a + 1;
        list = this.d.f20b;
        if (i >= list.size()) {
            map = this.d.c;
            return !map.isEmpty() && b().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        List list;
        Object next;
        List list2;
        this.f5b = true;
        int i = this.f4a + 1;
        this.f4a = i;
        list = this.d.f20b;
        if (i < list.size()) {
            list2 = this.d.f20b;
            next = list2.get(this.f4a);
        } else {
            next = b().next();
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.f5b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f5b = false;
        this.d.f();
        int i = this.f4a;
        list = this.d.f20b;
        if (i >= list.size()) {
            b().remove();
            return;
        }
        f3 f3Var = this.d;
        int i2 = this.f4a;
        this.f4a = i2 - 1;
        f3Var.b(i2);
    }
}
