package a.a.a.a.a.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class a2 extends LinkedHashMap {

    /* renamed from: b  reason: collision with root package name */
    private static final a2 f2b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f3a;

    static {
        a2 a2Var = new a2();
        f2b = a2Var;
        a2Var.f3a = false;
    }

    private a2() {
        this.f3a = true;
    }

    private a2(Map map) {
        super(map);
        this.f3a = true;
    }

    private static int a(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = i1.f26b;
            int length = bArr.length;
            int a2 = i1.a(length, bArr, 0, length);
            if (a2 == 0) {
                return 1;
            }
            return a2;
        }
        return obj.hashCode();
    }

    public static a2 c() {
        return f2b;
    }

    private final void e() {
        if (!this.f3a) {
            throw new UnsupportedOperationException();
        }
    }

    public final a2 a() {
        return isEmpty() ? new a2() : new a2(this);
    }

    public final void a(a2 a2Var) {
        e();
        if (a2Var.isEmpty()) {
            return;
        }
        putAll(a2Var);
    }

    public final void b() {
        this.f3a = false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        e();
        super.clear();
    }

    public final boolean d() {
        return this.f3a;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this == map) {
                return true;
            }
            if (size() != map.size()) {
                return false;
            }
            Iterator it = entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!map.containsKey(entry.getKey())) {
                    return false;
                }
                Object value = entry.getValue();
                Object obj2 = map.get(entry.getKey());
                if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                    equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                    continue;
                } else {
                    equals = value.equals(obj2);
                    continue;
                }
                if (!equals) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i += a(entry.getValue()) ^ a(entry.getKey());
        }
        return i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        e();
        byte[] bArr = i1.f26b;
        if (obj != null) {
            if (obj2 != null) {
                return super.put(obj, obj2);
            }
            throw null;
        }
        throw null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        e();
        for (Object obj : map.keySet()) {
            byte[] bArr = i1.f26b;
            if (obj == null) {
                throw null;
            }
            if (map.get(obj) == null) {
                throw null;
            }
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        e();
        return super.remove(obj);
    }
}
