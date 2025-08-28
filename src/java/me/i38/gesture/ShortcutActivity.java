package me.i38.gesture;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class ShortcutActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String a2 = me.i38.gesture.o0.h.a((Activity) this, "id");
        if (!me.i38.gesture.o0.k.a(a2)) {
            GestureApplication.a(a2);
        }
        finish();
    }
}
