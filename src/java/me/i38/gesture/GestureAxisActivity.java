package me.i38.gesture;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class GestureAxisActivity extends PreferenceActivity implements Preference.OnPreferenceClickListener {
    private void a(int i) {
        Intent intent = new Intent();
        intent.putExtra("id", i);
        setResult(-1, intent);
        finish();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(2131296411);
        addPreferencesFromResource(2131492866);
        setContentView(2131165186);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        findPreference("x_axis").setOnPreferenceClickListener(this);
        findPreference("y_axis").setOnPreferenceClickListener(this);
        findPreference("z_axis").setOnPreferenceClickListener(this);
        findPreference("key_axis").setOnPreferenceClickListener(this);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        int i;
        if ("x_axis".equals(preference.getKey())) {
            i = 1;
        } else if ("y_axis".equals(preference.getKey())) {
            i = 2;
        } else if ("z_axis".equals(preference.getKey())) {
            i = 3;
        } else if (!"key_axis".equals(preference.getKey())) {
            return false;
        } else {
            i = 4;
        }
        a(i);
        return false;
    }
}
