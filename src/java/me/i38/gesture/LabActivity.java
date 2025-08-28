package me.i38.gesture;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class LabActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private a f149a;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public static class a extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private SwitchPreference f150a;

        /* renamed from: b  reason: collision with root package name */
        private SwitchPreference f151b;
        private SwitchPreference c;
        private SwitchPreference d;

        public LabActivity a() {
            return (LabActivity) getActivity();
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(2131492867);
            SwitchPreference switchPreference = (SwitchPreference) findPreference("system_vibrate");
            this.f150a = switchPreference;
            switchPreference.setOnPreferenceChangeListener(this);
            SwitchPreference switchPreference2 = (SwitchPreference) findPreference("mouse_always_on");
            this.f151b = switchPreference2;
            switchPreference2.setOnPreferenceChangeListener(this);
            SwitchPreference switchPreference3 = (SwitchPreference) findPreference("off_scr_long_press");
            this.c = switchPreference3;
            switchPreference3.setOnPreferenceChangeListener(this);
            SwitchPreference switchPreference4 = (SwitchPreference) findPreference("pixel_match");
            this.d = switchPreference4;
            switchPreference4.setChecked(GestureExtraService.c());
            this.d.setOnPreferenceChangeListener(this);
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            String key = preference.getKey();
            if ("system_vibrate".equals(key)) {
                if (((Boolean) obj).booleanValue()) {
                    l0.v().i();
                } else {
                    l0.v().c();
                }
            } else if ("off_scr_long_press".equals(key)) {
                if (((Boolean) obj).booleanValue()) {
                    if (Build.VERSION.SDK_INT < 26) {
                        me.i38.gesture.o0.h.a(a(), 2131296351, "8.0");
                        return false;
                    } else if (!GestureApplication.v()) {
                        me.i38.gesture.o0.h.a(a(), getString(2131296349, getString(2131296464)), "adb shell pm grant me.i38.gesture android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER");
                        return false;
                    }
                }
            } else if ("pixel_match".equals(key)) {
                if (!((Boolean) obj).booleanValue()) {
                    GestureExtraService.a();
                } else if (!GestureExtraService.c()) {
                    a().startActivityForResult(GestureExtraService.b().createScreenCaptureIntent(), 9);
                }
            }
            return true;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 9) {
            GestureExtraService.f147b = intent;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(2131296435);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.f149a = new a();
        getFragmentManager().beginTransaction().replace(16908290, this.f149a).commit();
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}
