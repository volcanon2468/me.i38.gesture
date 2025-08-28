package me.i38.gesture;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class IMEActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f148a;

    public /* synthetic */ void a() {
        InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showInputMethodPicker();
        }
        this.f148a = true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f148a = false;
        new Handler().postDelayed(new Runnable() { // from class: me.i38.gesture.l
            @Override // java.lang.Runnable
            public final void run() {
                IMEActivity.this.a();
            }
        }, 500L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f148a && z) {
            this.f148a = false;
            finish();
        }
    }
}
