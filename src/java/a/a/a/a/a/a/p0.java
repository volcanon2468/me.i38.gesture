package a.a.a.a.a.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class p0 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile p0 f67b;
    static final p0 c = new p0(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map f68a;

    p0() {
        this.f68a = new HashMap();
    }

    p0(boolean z) {
        this.f68a = Collections.emptyMap();
    }

    public static p0 a() {
        p0 p0Var = f67b;
        if (p0Var != null) {
            return p0Var;
        }
        synchronized (p0.class) {
            p0 p0Var2 = f67b;
            if (p0Var2 != null) {
                return p0Var2;
            }
            p0 a2 = x0.a(p0.class);
            f67b = a2;
            return a2;
        }
    }

    public final b1 a(h2 h2Var, int i) {
        return (b1) this.f68a.get(new o0(h2Var, i));
    }
}
