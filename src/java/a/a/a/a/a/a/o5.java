package a.a.a.a.a.a;

import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public abstract class o5 extends h5 implements Set {
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private transient k5 f66b;

    @Override // a.a.a.a.a.a.h5
    public k5 b() {
        k5 k5Var = this.f66b;
        if (k5Var == null) {
            k5 e = e();
            this.f66b = e;
            return e;
        }
        return k5Var;
    }

    k5 e() {
        Object[] array = toArray();
        int i = k5.c;
        return k5.b(array, array.length);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return h.a(this);
    }
}
