package a.a.a.a.a.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class u2 extends f3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u2(int i) {
        super(i, null);
    }

    @Override // a.a.a.a.a.a.f3
    public final void a() {
        if (!d()) {
            for (int i = 0; i < b(); i++) {
                Map.Entry a2 = a(i);
                if (((t0) a2.getKey()).c()) {
                    a2.setValue(Collections.unmodifiableList((List) a2.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((t0) entry.getKey()).c()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
