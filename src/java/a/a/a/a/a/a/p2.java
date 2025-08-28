package a.a.a.a.a.a;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class p2 {
    private static final p2 c = new p2();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f70b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final s2 f69a = new y1();

    private p2() {
    }

    public static p2 a() {
        return c;
    }

    public final r2 a(Class cls) {
        i1.a(cls, "messageType");
        r2 r2Var = (r2) this.f70b.get(cls);
        if (r2Var == null) {
            r2Var = this.f69a.a(cls);
            i1.a(cls, "messageType");
            i1.a(r2Var, "schema");
            r2 r2Var2 = (r2) this.f70b.putIfAbsent(cls, r2Var);
            if (r2Var2 != null) {
                return r2Var2;
            }
        }
        return r2Var;
    }
}
