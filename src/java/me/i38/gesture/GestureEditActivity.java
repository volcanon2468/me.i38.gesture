package me.i38.gesture;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.i38.gesture.GestureEditActivity;
import me.i38.gesture.components.SeekBarPreference;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class GestureEditActivity extends PreferenceActivity {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f142a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f143b;
    private List<Map> c;
    private Map<String, Object> d;
    private String e;
    private int f;
    private SharedPreferences g;
    private a h;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public static class a extends PreferenceFragment implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private String f144a;

        /* renamed from: b  reason: collision with root package name */
        private String f145b;
        private int c;
        private PreferenceScreen d;
        private SeekBarPreference e;
        private ListPreference f;
        private ListPreference g;
        private ListPreference h;
        private ListPreference i;
        private Preference j;
        private Preference k;

        private void b(int i) {
            String str;
            int i2;
            ListPreference listPreference = this.g;
            if (i == 24) {
                i2 = 2131296589;
            } else if (i != 25) {
                str = getString(2131296579) + i;
                listPreference.setSummary(str);
            } else {
                i2 = 2131296588;
            }
            str = getString(i2);
            listPreference.setSummary(str);
        }

        private void h() {
            if (this.c == 4) {
                this.d.removePreference(this.e);
                this.d.removePreference(this.f);
                this.d.removePreference(this.h);
                this.d.addPreference(this.g);
                this.d.addPreference(this.i);
                return;
            }
            this.d.addPreference(this.f);
            this.d.addPreference(this.e);
            this.d.addPreference(this.h);
            this.d.removePreference(this.g);
            this.d.removePreference(this.i);
        }

        public String a() {
            return me.i38.gesture.o0.h.a(this.f144a, this.f145b);
        }

        public void a(int i) {
            if (this.c == 4) {
                ListPreference listPreference = this.g;
                listPreference.setValue("" + i);
                b(i);
            }
        }

        public Object b() {
            return (this.c == 4 ? this.i : this.h).getValue();
        }

        public Object c() {
            return (this.c == 4 ? this.g : this.f).getValue();
        }

        public Map<String, Object> d() {
            return e().d;
        }

        public GestureEditActivity e() {
            return (GestureEditActivity) getActivity();
        }

        public int f() {
            return this.e.d();
        }

        public /* synthetic */ void g() {
            int j = GestureApplication.j();
            if (!n0.f(j) || e() == null) {
                return;
            }
            a(j);
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                if (i == 2) {
                    this.f145b = intent.getStringExtra("name");
                    this.f144a = intent.getStringExtra("id");
                    this.j.setSummary(this.f145b);
                    me.i38.gesture.o0.h.a(this.f144a + "|" + this.f145b, e());
                } else if (i == 10) {
                    int intExtra = intent.getIntExtra("id", 1);
                    this.c = intExtra;
                    this.k.setSummary(GestureApplication.a(intExtra));
                    h();
                    me.i38.gesture.o0.h.b(this.c, e());
                    if (this.c == 4) {
                        Toast.makeText(getActivity().getApplicationContext(), 2131296581, 1).show();
                        GestureApplication.f(-1);
                        new Handler().postDelayed(new Runnable() { // from class: me.i38.gesture.j
                            @Override // java.lang.Runnable
                            public final void run() {
                                GestureEditActivity.a.this.g();
                            }
                        }, 3000L);
                    }
                }
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(2131492865);
            e().a();
            this.d = (PreferenceScreen) findPreference("gesture_edit");
            this.c = me.i38.gesture.o0.j.b(d().get("axis"), 1);
            Preference findPreference = findPreference("axis");
            this.k = findPreference;
            findPreference.setSummary(GestureApplication.a(this.c));
            this.k.setOnPreferenceClickListener(this);
            SeekBarPreference seekBarPreference = (SeekBarPreference) findPreference("thresh");
            this.e = seekBarPreference;
            seekBarPreference.a(me.i38.gesture.o0.j.b(d().get("thresh"), 10));
            this.f = (ListPreference) findPreference("dir");
            ListPreference listPreference = (ListPreference) findPreference("key");
            this.g = listPreference;
            listPreference.setOnPreferenceChangeListener(this);
            ListPreference listPreference2 = (ListPreference) findPreference("count");
            this.h = listPreference2;
            listPreference2.setOnPreferenceChangeListener(this);
            List a2 = me.i38.gesture.o0.k.a((Object[]) new String[]{getString(2131296446), getString(2131296447), getString(2131296448), getString(2131296449)});
            List a3 = me.i38.gesture.o0.k.a((Object[]) new String[]{"1", "2", "3", "4"});
            if (!e().g.getBoolean("off_scr_long_press", false)) {
                a2.remove(3);
                a3.remove(3);
            }
            ListPreference listPreference3 = (ListPreference) findPreference("mode");
            this.i = listPreference3;
            listPreference3.setEntries((CharSequence[]) a2.toArray(new String[0]));
            this.i.setEntryValues((CharSequence[]) a3.toArray(new String[0]));
            String b2 = me.i38.gesture.o0.j.b(d().get("count"), "1");
            if (this.c == 4) {
                this.i.setValue(b2);
                this.h.setValue("1");
                this.f.setValue("0");
                int b3 = me.i38.gesture.o0.j.b(d().get("dir"), 24);
                ListPreference listPreference4 = this.g;
                listPreference4.setValue("" + b3);
                b(b3);
            } else {
                this.h.setValue(b2);
                this.i.setValue("1");
                this.f.setValue(me.i38.gesture.o0.j.b(d().get("dir"), "0"));
                this.g.setValue("24");
                b(24);
            }
            this.d.removePreference(this.g);
            this.d.removePreference(this.i);
            h();
            String b4 = me.i38.gesture.o0.j.b(d().get("action"), "0");
            this.f145b = me.i38.gesture.o0.h.c(getActivity(), b4);
            this.f144a = me.i38.gesture.o0.h.c(b4);
            Preference findPreference2 = findPreference("action");
            this.j = findPreference2;
            findPreference2.setSummary(this.f145b);
            this.j.setOnPreferenceClickListener(this);
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            String key = preference.getKey();
            if ("count".equals(key)) {
                if ("2".equals(obj)) {
                    Toast.makeText(getActivity().getApplicationContext(), 2131296413, 1).show();
                }
            } else if ("key".equals(key)) {
                b(me.i38.gesture.o0.j.b(obj));
            }
            return true;
        }

        @Override // android.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference preference) {
            Intent intent;
            int i;
            String key = preference.getKey();
            if ("action".equals(key)) {
                intent = new Intent(getActivity(), SelectActionActivity.class);
                intent.putExtra("action", this.f144a + "|" + this.f145b);
                i = 2;
            } else if (!"axis".equals(key)) {
                return false;
            } else {
                intent = new Intent(getActivity(), GestureAxisActivity.class);
                i = 10;
            }
            startActivityForResult(intent, i);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Map<String, Object> a2 = me.i38.gesture.o0.h.a(this.g.getString("apps", ""), new HashMap());
        this.f142a = a2;
        Map<String, Object> map = (Map) me.i38.gesture.o0.j.a(a2, this.e, new HashMap());
        this.f143b = map;
        this.c = (List) me.i38.gesture.o0.j.a(map, "gestures", new ArrayList());
        HashMap hashMap = new HashMap();
        this.d = hashMap;
        int i = this.f;
        if (i < 0) {
            this.c.add(hashMap);
        } else if (i < this.c.size()) {
            this.d = this.c.get(this.f);
        }
    }

    private void b() {
        GestureApplication.a(this.f142a);
        finish();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Bundle a2 = me.i38.gesture.o0.h.a((Activity) this);
        this.e = a2.getString("app", "default");
        this.f = a2.getInt("index", 0);
        this.g = PreferenceManager.getDefaultSharedPreferences(this);
        super.onCreate(bundle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.h = new a();
        getFragmentManager().beginTransaction().replace(16908290, this.h).commit();
        setTitle(getString(this.f < 0 ? 2131296410 : 2131296415));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131230722, menu);
        if (this.f < 0) {
            menu.getItem(1).setVisible(false);
        }
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
                int i = this.f;
                if (i >= 0) {
                    this.c.remove(i);
                    break;
                } else {
                    return true;
                }
            case 2131099662:
                Map<String, Object> map = this.d;
                map.put("axis", "" + this.h.c);
                this.d.put("count", this.h.b());
                this.d.put("dir", this.h.c());
                this.d.put("thresh", Integer.valueOf(this.h.f()));
                this.d.put("action", this.h.a());
                break;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
        b();
        return true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
