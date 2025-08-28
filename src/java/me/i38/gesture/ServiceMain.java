package me.i38.gesture;

import android.util.Log;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class ServiceMain extends n0 {
    public static n0 x;

    @Override // me.i38.gesture.n0
    public void a(n0 n0Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        sb.append(n0Var == null ? "stop" : "start");
        Log.d("gesturelog", sb.toString());
        x = n0Var;
    }
}
