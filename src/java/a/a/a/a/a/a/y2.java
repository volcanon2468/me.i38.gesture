package a.a.a.a.a.a;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class y2 implements Map.Entry, Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final Comparable f104a;

    /* renamed from: b  reason: collision with root package name */
    private Object f105b;
    final /* synthetic */ f3 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y2(f3 f3Var, Comparable comparable, Object obj) {
        this.c = f3Var;
        this.f104a = comparable;
        this.f105b = obj;
    }

    private static final boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final Comparable b() {
        return this.f104a;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f104a.compareTo(((y2) obj).f104a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return a(this.f104a, entry.getKey()) && a(this.f105b, entry.getValue());
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f104a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f105b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f104a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f105b;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.c.f();
        Object obj2 = this.f105b;
        this.f105b = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f104a);
        String valueOf2 = String.valueOf(this.f105b);
        return valueOf + "=" + valueOf2;
    }
}
