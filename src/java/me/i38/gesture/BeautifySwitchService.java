package me.i38.gesture;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class BeautifySwitchService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String a2 = me.i38.gesture.o0.k.a(me.i38.gesture.o0.h.a(intent.getStringExtra("para"), new HashMap()).get("action"), "");
        if (!Arrays.asList(k0.f249a).contains(a2)) {
            a2 = k0.f249a[0];
        }
        if (me.i38.gesture.o0.h.a(GestureApplication.g()) <= 0 || !GestureApplication.l()) {
            Toast.makeText(GestureApplication.g(), 2131296550, 0).show();
            return 2;
        }
        GestureApplication.a(a2);
        return 2;
    }
}
