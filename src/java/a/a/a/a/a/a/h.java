package a.a.a.a.a.a;

import java.util.Iterator;
import java.util.Set;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }
}
