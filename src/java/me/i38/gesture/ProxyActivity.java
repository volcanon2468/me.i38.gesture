package me.i38.gesture;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.util.Log;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class ProxyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private String f166a;

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String a2 = me.i38.gesture.o0.h.a((Activity) this, "action");
        this.f166a = a2;
        if (me.i38.gesture.o0.k.b(a2, "E")) {
            requestPermissions(new String[]{"android.permission.BLUETOOTH_CONNECT"}, 11);
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean isEnabled;
        boolean a2;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length > 0 && iArr[0] == 0 && i == 11) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null && isEnabled != (a2 = me.i38.gesture.o0.k.a(me.i38.gesture.o0.k.b(this.f166a, ":", 1), (isEnabled = defaultAdapter.isEnabled())))) {
                    if (a2) {
                        defaultAdapter.enable();
                    } else {
                        defaultAdapter.disable();
                    }
                }
            } catch (Exception e) {
                Log.e("gesturelog", "proxyAction", e);
            }
        }
        finish();
    }
}
