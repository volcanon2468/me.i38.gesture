package a.a.a.a.a.a;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class f3 extends AbstractMap {

    /* renamed from: a  reason: collision with root package name */
    private final int f19a;
    private boolean d;
    private volatile d3 e;

    /* renamed from: b  reason: collision with root package name */
    private List f20b = Collections.emptyList();
    private Map c = Collections.emptyMap();
    private Map f = Collections.emptyMap();

    private final int a(Comparable comparable) {
        int size = this.f20b.size() - 1;
        int i = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((y2) this.f20b.get(size)).b());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = comparable.compareTo(((y2) this.f20b.get(i2)).b());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(int i) {
        f();
        Object value = ((y2) this.f20b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f20b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new y2(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap e() {
        f();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public final Object put(Comparable comparable, Object obj) {
        f();
        int a2 = a(comparable);
        if (a2 >= 0) {
            return ((y2) this.f20b.get(a2)).setValue(obj);
        }
        f();
        if (this.f20b.isEmpty() && !(this.f20b instanceof ArrayList)) {
            this.f20b = new ArrayList(this.f19a);
        }
        int i = -(a2 + 1);
        if (i >= this.f19a) {
            return e().put(comparable, obj);
        }
        int size = this.f20b.size();
        int i2 = this.f19a;
        if (size == i2) {
            y2 y2Var = (y2) this.f20b.remove(i2 - 1);
            e().put(y2Var.b(), y2Var.getValue());
        }
        this.f20b.add(i, new y2(this, comparable, obj));
        return null;
    }

    public final Map.Entry a(int i) {
        return (Map.Entry) this.f20b.get(i);
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
        this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
        this.d = true;
    }

    public final int b() {
        return this.f20b.size();
    }

    public final Iterable c() {
        return this.c.isEmpty() ? x2.a() : this.c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        f();
        if (!this.f20b.isEmpty()) {
            this.f20b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public final boolean d() {
        return this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new d3(this, null);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        Object entrySet;
        Object entrySet2;
        if (this == obj) {
            return true;
        }
        if (obj instanceof f3) {
            f3 f3Var = (f3) obj;
            int size = size();
            if (size != f3Var.size()) {
                return false;
            }
            int b2 = b();
            if (b2 == f3Var.b()) {
                for (int i = 0; i < b2; i++) {
                    if (!a(i).equals(f3Var.a(i))) {
                        return false;
                    }
                }
                if (b2 == size) {
                    return true;
                }
                entrySet = this.c;
                entrySet2 = f3Var.c;
            } else {
                entrySet = entrySet();
                entrySet2 = f3Var.entrySet();
            }
            return entrySet.equals(entrySet2);
        }
        return super.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        return a2 >= 0 ? ((y2) this.f20b.get(a2)).getValue() : this.c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int b2 = b();
        int i = 0;
        for (int i2 = 0; i2 < b2; i2++) {
            i += ((y2) this.f20b.get(i2)).hashCode();
        }
        return this.c.size() > 0 ? i + this.c.hashCode() : i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return b(a2);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f20b.size() + this.c.size();
    }
}
