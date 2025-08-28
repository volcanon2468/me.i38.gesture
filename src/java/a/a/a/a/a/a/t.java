package a.a.a.a.a.a;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class t implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        c0 c0Var = (c0) obj;
        c0 c0Var2 = (c0) obj2;
        s sVar = new s(c0Var);
        s sVar2 = new s(c0Var2);
        while (sVar.hasNext() && sVar2.hasNext()) {
            int compareTo = Integer.valueOf(sVar.b() & 255).compareTo(Integer.valueOf(sVar2.b() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(c0Var.b()).compareTo(Integer.valueOf(c0Var2.b()));
    }
}
