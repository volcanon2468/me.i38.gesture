package me.i38.gesture;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.i38.gesture.SettingActivity;
import me.i38.gesture.components.SeekBarPreference;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class SettingActivity extends Activity {
    private static Map<Integer, Integer> i = new a();
    private static Map<Integer, Integer> j = new b();
    private static Map<Integer, Integer> k = new c();
    private static Map<Integer, Integer> l = new d();

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f205a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f206b;
    private List<Map> c;
    private String d;
    private String e;
    private Handler f;
    private SharedPreferences g;
    private f h;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a extends HashMap<Integer, Integer> {
        a() {
            put(1, 2131296593);
            put(2, 2131296595);
            put(3, 2131296597);
            put(4, 2131296432);
            put(5, 2131296391);
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class b extends HashMap<Integer, Integer> {
        b() {
            put(1, 2131296377);
            put(2, 2131296378);
            put(3, 2131296574);
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class c extends HashMap<Integer, Integer> {
        c() {
            put(1, 2131296446);
            put(2, 2131296447);
            put(3, 2131296448);
            put(4, 2131296449);
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class d extends HashMap<Integer, Integer> {
        d() {
            put(-1, 2131296457);
            put(0, 2131296370);
            put(1, 2131296510);
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                SettingActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(SettingActivity.this.getString(2131296431))));
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public static class f extends PreferenceFragment implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

        /* renamed from: a  reason: collision with root package name */
        SeekBarPreference f208a;

        /* renamed from: b  reason: collision with root package name */
        ListPreference f209b;
        SwitchPreference c;
        SwitchPreference d;
        private Preference[] e = new Preference[12];
        private int f = 0;

        private String a(Map map) {
            return me.i38.gesture.o0.h.c(getActivity(), me.i38.gesture.o0.j.a(map.get("action"), "0"));
        }

        private String b(Map map) {
            String str;
            int i;
            int a2 = me.i38.gesture.o0.j.a(map.get("axis"), 1);
            String str2 = getString(((Integer) SettingActivity.i.get(Integer.valueOf(a2))).intValue()) + " ";
            if (a2 != 4) {
                if (a2 == 5) {
                    return str2;
                }
                return str2 + getString(((Integer) SettingActivity.l.get(Integer.valueOf(me.i38.gesture.o0.j.a(map.get("dir"), 0)))).intValue()) + " " + getString(((Integer) SettingActivity.j.get(Integer.valueOf(me.i38.gesture.o0.j.a(map.get("count"), 1)))).intValue()) + " " + getString(2131296570) + me.i38.gesture.o0.j.b(map.get("thresh"), 10);
            }
            int b2 = me.i38.gesture.o0.j.b(map.get("dir"));
            if (b2 == 24) {
                i = 2131296589;
            } else if (b2 != 25) {
                str = getString(2131296579) + b2;
                return str2 + str + " " + getString(((Integer) SettingActivity.k.get(Integer.valueOf(me.i38.gesture.o0.j.a(map.get("count"), 1)))).intValue());
            } else {
                i = 2131296588;
            }
            str = getString(i);
            return str2 + str + " " + getString(((Integer) SettingActivity.k.get(Integer.valueOf(me.i38.gesture.o0.j.a(map.get("count"), 1)))).intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            a().e();
            this.f208a.a(me.i38.gesture.o0.j.b(a().f206b.get("vibrate"), 10));
            this.f209b.setValue(me.i38.gesture.o0.j.b(a().f206b.get("landscape_mode"), "0"));
            this.c.setChecked(me.i38.gesture.o0.j.b(a().f206b.get("toast"), false));
            PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("cat_gesture");
            preferenceCategory.removeAll();
            for (int i = 0; i < 12; i++) {
                if (i < a().c.size()) {
                    this.e[i].setTitle(b((Map) a().c.get(i)));
                    this.e[i].setSummary(a((Map) a().c.get(i)));
                    preferenceCategory.addPreference(this.e[i]);
                }
            }
            boolean z = true;
            for (Map map : a().c) {
                String b2 = me.i38.gesture.o0.j.b(map.get("action"), "0");
                int b3 = me.i38.gesture.o0.j.b(map.get("axis"), 1);
                if (me.i38.gesture.o0.h.a(b2, a()) && me.i38.gesture.o0.h.b(b3, a())) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    break;
                }
            }
            if (z && GestureApplication.y()) {
                z = me.i38.gesture.o0.h.a(me.i38.gesture.o0.h.a("robot", getString(2131296516)), a());
            }
            if (Build.VERSION.SDK_INT < 21 || !z || a().f205a.size() <= 1 || !"default".equals(a().d) || ((AppOpsManager) a().getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), a().getPackageName()) == 0) {
                return;
            }
            me.i38.gesture.o0.h.c(2131296576, a());
        }

        public SettingActivity a() {
            return (SettingActivity) getActivity();
        }

        public /* synthetic */ void b() {
            me.i38.gesture.o0.h.a((Context) a(), "switch");
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(2131492868);
            a().e();
            SwitchPreference switchPreference = (SwitchPreference) findPreference("main_switch");
            this.d = switchPreference;
            switchPreference.setOnPreferenceChangeListener(this);
            SeekBarPreference seekBarPreference = (SeekBarPreference) findPreference("vibrate");
            this.f208a = seekBarPreference;
            seekBarPreference.setOnPreferenceChangeListener(this);
            ListPreference listPreference = (ListPreference) findPreference("landscape_mode");
            this.f209b = listPreference;
            listPreference.setOnPreferenceChangeListener(this);
            SwitchPreference switchPreference2 = (SwitchPreference) findPreference("toast");
            this.c = switchPreference2;
            switchPreference2.setOnPreferenceChangeListener(this);
            findPreference("panel_edit").setOnPreferenceClickListener(this);
            findPreference("lab").setOnPreferenceClickListener(this);
            findPreference("help_ack").setOnPreferenceClickListener(this);
            findPreference("app_custom").setOnPreferenceClickListener(this);
            findPreference("robot").setOnPreferenceClickListener(this);
            findPreference("hide_in_recents").setOnPreferenceChangeListener(this);
            for (int i = 0; i < 12; i++) {
                Preference[] preferenceArr = this.e;
                preferenceArr[i] = findPreference("gesture_" + i);
                this.e[i].setOnPreferenceClickListener(this);
            }
            if (a().d.equals("default")) {
                return;
            }
            PreferenceScreen preferenceScreen = (PreferenceScreen) findPreference("preferences");
            preferenceScreen.removePreference(findPreference("cat_other"));
            preferenceScreen.removePreference(findPreference("cat_about"));
            preferenceScreen.removePreference(findPreference("cat_main_switch"));
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            String key = preference.getKey();
            if (key.equals("main_switch")) {
                new Handler().post(new Runnable() { // from class: me.i38.gesture.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SettingActivity.f.this.b();
                    }
                });
                if (((Boolean) obj).booleanValue()) {
                    me.i38.gesture.o0.h.a(this.f == 0 ? 2131296547 : 2131296261, a());
                } else if (Build.VERSION.SDK_INT >= 24) {
                    Toast.makeText(a().getApplicationContext(), 2131296514, 1).show();
                }
            } else if ("hide_in_recents".equals(key)) {
                me.i38.gesture.o0.h.c(getActivity(), ((Boolean) obj).booleanValue());
            } else {
                a().e();
                a().f206b.put(key, obj);
                GestureApplication.a(a().f205a);
            }
            return true;
        }

        @Override // android.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference preference) {
            Intent intent;
            String key = preference.getKey();
            if (key.equals("panel_edit")) {
                intent = new Intent(getActivity(), PanelEditActivity.class);
                intent.putExtra("app", a().d);
                intent.putExtra("name", a().e);
            } else if (key.equals("lab")) {
                intent = new Intent(getActivity(), LabActivity.class);
            } else if (key.equals("help_ack")) {
                intent = new Intent(getActivity(), FaqActivity.class);
            } else if (key.equals("about")) {
                intent = new Intent(getActivity(), PayActivity.class);
            } else if (key.equals("robot")) {
                intent = new Intent(getActivity(), RobotConfigActivity.class);
            } else if (!key.equals("app_custom")) {
                Intent intent2 = new Intent(getActivity(), GestureEditActivity.class);
                int b2 = me.i38.gesture.o0.j.b(key.replaceAll("[^0-9]", ""));
                intent2.putExtra("app", a().d);
                intent2.putExtra("index", b2);
                startActivityForResult(intent2, 1);
                return false;
            } else {
                intent = new Intent(getActivity(), AppCustomActivity.class);
            }
            startActivity(intent);
            return false;
        }

        @Override // android.app.Fragment
        public void onResume() {
            SwitchPreference switchPreference;
            int i;
            super.onResume();
            int a2 = me.i38.gesture.o0.h.a((Context) a());
            this.f = a2;
            if (a2 == 0) {
                this.d.setTitle(2131296356);
            } else {
                if (a2 == 1) {
                    switchPreference = this.d;
                    i = 2131296548;
                } else if (a2 == 2) {
                    switchPreference = this.d;
                    i = 2131296551;
                } else if (a2 == 3) {
                    me.i38.gesture.o0.h.a(2131296257, a());
                } else if (a2 == -1) {
                    me.i38.gesture.o0.h.a(a(), 2131296258, new Object[0]);
                }
                switchPreference.setTitle(i);
            }
            if (a().d.equals("default")) {
                findPreference("about").setTitle(GestureApplication.c(true));
                Preference findPreference = findPreference("about");
                findPreference.setSummary(getString(2131296356) + " 5.7.7P");
                findPreference("about").setOnPreferenceClickListener(this);
            }
            c();
        }
    }

    private void a(boolean z, final Uri uri) {
        try {
            if (!z) {
                final HashMap hashMap = new HashMap();
                hashMap.put("apps", this.f205a);
                hashMap.put("robot", GestureApplication.r());
                this.f.postDelayed(new Runnable() { // from class: me.i38.gesture.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SettingActivity.this.a(uri, hashMap);
                    }
                }, uri.getHost().startsWith("nutstore") ? 1000L : 0L);
                return;
            }
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            Map<String, Object> a2 = me.i38.gesture.o0.h.a(me.i38.gesture.o0.i.a(openInputStream), new HashMap());
            if (a2.containsKey("default")) {
                GestureApplication.a(a2);
            } else if (a2.containsKey("apps")) {
                GestureApplication.a(me.i38.gesture.o0.j.f(a2.get("apps")));
                GestureApplication.a(me.i38.gesture.o0.j.d(a2.get("robot")));
            }
            if (openInputStream != null) {
                openInputStream.close();
            }
            me.i38.gesture.o0.h.a(this, 2131296427, new Object[0]);
        } catch (Throwable unused) {
            me.i38.gesture.o0.h.a(this, z ? 2131296426 : 2131296398, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Map<String, Object> a2 = me.i38.gesture.o0.h.a(this.g.getString("apps", ""), new HashMap());
        this.f205a = a2;
        Map<String, Object> map = (Map) me.i38.gesture.o0.j.a(a2, this.d, new HashMap());
        this.f206b = map;
        this.c = (List) me.i38.gesture.o0.j.a(map, "gestures", new ArrayList());
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        this.g.edit().putBoolean("policy_agree", true).commit();
    }

    public /* synthetic */ void a(Uri uri, Map map) {
        try {
            try {
                OutputStream openOutputStream = getContentResolver().openOutputStream(uri, "wt");
                openOutputStream.write(me.i38.gesture.o0.h.a(map, "{}").getBytes());
                if (openOutputStream != null) {
                    openOutputStream.close();
                }
            } catch (Exception unused) {
                me.i38.gesture.o0.h.a(this, 2131296398, new Object[0]);
                return;
            }
        } catch (Exception unused2) {
            OutputStream openOutputStream2 = getContentResolver().openOutputStream(uri, "w");
            openOutputStream2.write(me.i38.gesture.o0.h.a(map, "{}").getBytes());
            if (openOutputStream2 != null) {
                openOutputStream2.close();
            }
        }
        me.i38.gesture.o0.h.a(this, 2131296399, new Object[0]);
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1 || intent == null) {
            return;
        }
        if (me.i38.gesture.o0.k.a(Integer.valueOf(i2), 101, 100)) {
            a(i2 == 100, intent.getData());
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Bundle a2 = me.i38.gesture.o0.h.a((Activity) this);
        this.g = PreferenceManager.getDefaultSharedPreferences(this);
        String string = a2.getString("app", "default");
        this.d = string;
        this.e = a2.getString("name", string);
        super.onCreate(bundle);
        this.f = new Handler();
        this.h = new f();
        getFragmentManager().beginTransaction().replace(16908290, this.h).commit();
        if (!"default".equals(this.d)) {
            setTitle(this.e);
            getActionBar().setDisplayHomeAsUpEnabled(true);
            return;
        }
        setTitle(2131296356);
        me.i38.gesture.o0.h.c(this, this.g.getBoolean("hide_in_recents", false));
        if (!this.g.getBoolean("policy_agree", false)) {
            ((TextView) new AlertDialog.Builder(this).setMessage(Html.fromHtml(getString(2131296358))).setPositiveButton(2131296350, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.d0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SettingActivity.this.a(dialogInterface, i2);
                }
            }).setNegativeButton(2131296515, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.g0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SettingActivity.this.b(dialogInterface, i2);
                }
            }).setCancelable(false).show().findViewById(16908299)).setMovementMethod(LinkMovementMethod.getInstance());
        } else if (GestureApplication.a()) {
            new AlertDialog.Builder(this).setMessage(2131296430).setPositiveButton(2131296450, new e()).show();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131230724, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent a2;
        int i2;
        switch (menuItem.getItemId()) {
            case 2131099653:
                if (!"default".equals(this.d)) {
                    this.f206b.clear();
                    GestureApplication.a(this.f205a);
                    this.h.c();
                    break;
                }
                break;
            case 2131099654:
                if (!"default".equals(this.d)) {
                    this.f206b.put("gestures", me.i38.gesture.o0.j.f(this.f205a.get("default")).get("gestures"));
                    this.f206b.put("panel", me.i38.gesture.o0.j.f(this.f205a.get("default")).get("panel"));
                    GestureApplication.a(this.f205a);
                    this.h.c();
                    break;
                }
                break;
            case 2131099660:
                if (this.c.size() < 12) {
                    Intent intent = new Intent(this, GestureEditActivity.class);
                    intent.putExtra("app", this.d);
                    intent.putExtra("index", -1);
                    startActivityForResult(intent, 1);
                    break;
                } else {
                    me.i38.gesture.o0.h.a(this, 2131296396, new Object[0]);
                    break;
                }
            case 2131099694:
                a2 = me.i38.gesture.o0.h.a(getString(2131296356) + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".export");
                i2 = 101;
                startActivityForResult(a2, i2);
                break;
            case 2131099695:
                a2 = me.i38.gesture.o0.h.b("android.intent.action.GET_CONTENT", "*/*");
                i2 = 100;
                startActivityForResult(a2, i2);
                break;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        int i2;
        if ("default".equals(this.d)) {
            menu.findItem(2131099654).setVisible(false);
            i2 = 2131099653;
        } else {
            menu.findItem(2131099694).setVisible(false);
            i2 = 2131099695;
        }
        menu.findItem(i2).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }
}
