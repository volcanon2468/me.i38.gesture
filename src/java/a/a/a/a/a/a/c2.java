package a.a.a.a.a.a;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class c2 {
    public static final int a(int i, Object obj, Object obj2) {
        a2 a2Var = (a2) obj;
        z1 z1Var = (z1) obj2;
        if (a2Var.isEmpty()) {
            return 0;
        }
        Iterator it = a2Var.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
        return 0;
    }

    public static final Object a(Object obj, Object obj2) {
        a2 a2Var = (a2) obj;
        a2 a2Var2 = (a2) obj2;
        if (!a2Var2.isEmpty()) {
            if (!a2Var.d()) {
                a2Var = a2Var.a();
            }
            a2Var.a(a2Var2);
        }
        return a2Var;
    }
}
