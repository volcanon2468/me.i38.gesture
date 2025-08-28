package me.i38.gesture;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import java.util.HashMap;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class BeautifyActionService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Context g;
        int i3;
        String b2 = me.i38.gesture.o0.k.b(me.i38.gesture.o0.h.a(intent.getStringExtra("para"), new HashMap()).get("action"));
        if (me.i38.gesture.o0.k.a(b2)) {
            g = GestureApplication.g();
            i3 = 2131296364;
        } else if (me.i38.gesture.o0.h.a(GestureApplication.g()) > 0 && GestureApplication.l()) {
            GestureApplication.a(b2);
            return 2;
        } else {
            g = GestureApplication.g();
            i3 = 2131296550;
        }
        Toast.makeText(g, i3, 0).show();
        return 2;
    }
}
