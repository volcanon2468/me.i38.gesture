package me.i38.gesture;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.i38.gesture.components.EditPreference;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class RobotEditActivity extends PreferenceActivity implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f172a;

    /* renamed from: b  reason: collision with root package name */
    private int f173b;
    private PreferenceScreen c;
    private EditPreference d;
    private EditPreference e;
    private EditPreference f;
    private EditPreference g;
    private EditPreference h;
    private Preference i;
    private Preference j;
    private Preference k;
    private ListPreference l;
    private ListPreference m;

    private EditPreference a(String str, String str2) {
        EditPreference editPreference = (EditPreference) findPreference("robot_" + str);
        editPreference.setText(str2);
        return editPreference;
    }

    private void a(String str) {
        EditPreference editPreference;
        int i;
        if ("ui".equals(str)) {
            this.c.addPreference(this.g);
            this.c.addPreference(this.e);
            this.c.addPreference(this.f);
            this.c.removePreference(this.m);
            editPreference = this.d;
            i = 2131296534;
        } else {
            this.c.removePreference(this.g);
            this.c.removePreference(this.e);
            this.c.removePreference(this.f);
            this.c.addPreference(this.m);
            editPreference = this.d;
            i = 2131296533;
        }
        editPreference.setDialogMessage(i);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Preference preference;
        String a2;
        if (i2 == -1) {
            if (i == 3) {
                this.f172a.put("p", intent.getStringExtra("action"));
                preference = this.i;
                a2 = intent.getStringExtra("name");
            } else if (i != 2) {
                return;
            } else {
                String a3 = me.i38.gesture.o0.k.a((Object) intent.getStringExtra("id"), "");
                String str = a3.equals("0") ? "" : a3;
                this.f172a.put("a", str);
                preference = this.k;
                a2 = me.i38.gesture.o0.k.a(str, getString(2131296518));
            }
            preference.setSummary(a2);
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Bundle a2 = me.i38.gesture.o0.h.a((Activity) this);
        this.f172a = me.i38.gesture.o0.h.a(a2.getString("action", ""), new HashMap());
        int i = a2.getInt("index", -1);
        this.f173b = i;
        if (i < 0) {
            this.f172a.put("e", true);
            this.f172a.put("t", "1000");
            this.f172a.put("o", "once");
        }
        super.onCreate(bundle);
        setTitle(2131296516);
        addPreferencesFromResource(2131492869);
        setContentView(2131165186);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.c = (PreferenceScreen) findPreference("robot_edit");
        this.l = (ListPreference) findPreference("robot_s");
        String a3 = me.i38.gesture.o0.k.a(this.f172a.get("s"), "ui");
        this.l.setValue(a3);
        this.l.setOnPreferenceChangeListener(this);
        Preference findPreference = findPreference("robot_name");
        this.i = findPreference;
        findPreference.setSummary(me.i38.gesture.o0.k.a(me.i38.gesture.o0.k.b(this.f172a.get("N")), me.i38.gesture.o0.k.b(this.f172a.get("p"))));
        this.i.setOnPreferenceClickListener(this);
        Preference findPreference2 = findPreference("robot_a");
        this.k = findPreference2;
        findPreference2.setSummary(me.i38.gesture.o0.k.a(me.i38.gesture.o0.k.b(this.f172a.get("a")), getString(2131296518)));
        this.k.setOnPreferenceClickListener(this);
        Preference findPreference3 = findPreference("robot_history");
        this.j = findPreference3;
        findPreference3.setOnPreferenceClickListener(this);
        this.e = a("c", me.i38.gesture.o0.k.a(this.f172a.get("c"), ""));
        this.g = a("f", me.i38.gesture.o0.k.a(this.f172a.get("f"), ""));
        this.h = a("m", me.i38.gesture.o0.k.a(this.f172a.get("m"), ""));
        this.d = a("n", me.i38.gesture.o0.k.a(this.f172a.get("n"), ""));
        this.f = a("t", me.i38.gesture.o0.j.b(this.f172a.get("t")) + "");
        ListPreference listPreference = (ListPreference) findPreference("robot_o");
        this.m = listPreference;
        listPreference.setValue(me.i38.gesture.o0.k.a(this.f172a.get("o"), "now"));
        a(a3);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131230722, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131099661:
                GestureApplication.a(this.f173b, (Map<String, Object>) null);
                break;
            case 2131099662:
                GestureApplication.a(this.f173b, GestureApplication.a(this.l.getValue(), this.f172a.get("p"), this.e.getSummary(), this.d.getSummary(), this.f.getSummary(), this.g.getSummary(), this.m.getValue(), this.h.getSummary(), this.f172a.get("a"), this.f172a.get("e")));
                break;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
        setResult(-1, null);
        finish();
        return true;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if ("robot_s".equals(preference.getKey())) {
            a(me.i38.gesture.o0.k.b(obj));
            return true;
        }
        return true;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        Intent intent;
        int i;
        if ("robot_name".equals(preference.getKey())) {
            intent = new Intent(this, SelectAppActivity.class);
            i = 3;
        } else if (!"robot_a".equals(preference.getKey())) {
            if ("robot_history".equals(preference.getKey())) {
                Map<String, Object> f = me.i38.gesture.o0.j.f(GestureApplication.c(this.f173b));
                EditText editText = new EditText(this);
                editText.setText(me.i38.gesture.o0.h.a((List) f.get("H"), ""));
                new AlertDialog.Builder(this).setView(editText).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
                return false;
            }
            return false;
        } else {
            intent = new Intent(this, SelectActionActivity.class);
            intent.putExtra("action", me.i38.gesture.o0.k.a(this.f172a.get("a"), ""));
            i = 2;
        }
        startActivityForResult(intent, i);
        return false;
    }
}
