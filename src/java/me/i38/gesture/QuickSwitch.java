package me.i38.gesture;

import android.annotation.TargetApi;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

@TargetApi(24)
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class QuickSwitch extends TileService {
    private void a(boolean z) {
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setState(z ? 2 : 1);
            qsTile.updateTile();
        }
    }

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        int a2 = me.i38.gesture.o0.h.a(this);
        boolean z = a2 != 0 && GestureApplication.l();
        if (a2 == 0) {
            me.i38.gesture.o0.h.f(this);
            Toast.makeText(getApplicationContext(), 2131296262, 1).show();
        }
        GestureApplication.d(!z);
        a(!z);
        me.i38.gesture.o0.h.a(this, "switch");
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        super.onStartListening();
        a(GestureApplication.l() && me.i38.gesture.o0.h.a(this) > 0);
    }
}
