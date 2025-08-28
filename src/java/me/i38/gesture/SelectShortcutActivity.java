package me.i38.gesture;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class SelectShortcutActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private List<i0> f201a = null;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    private class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        ProgressBar f202a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        public class a implements AdapterView.OnItemClickListener {
            a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SelectShortcutActivity.this.a(i);
            }
        }

        private b() {
            this.f202a = (ProgressBar) SelectShortcutActivity.this.findViewById(2131099664);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            SelectShortcutActivity selectShortcutActivity = SelectShortcutActivity.this;
            selectShortcutActivity.f201a = selectShortcutActivity.a();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r4) {
            super.onPostExecute(r4);
            ListView listView = (ListView) SelectShortcutActivity.this.findViewById(2131099663);
            SelectShortcutActivity selectShortcutActivity = SelectShortcutActivity.this;
            listView.setAdapter((ListAdapter) new j0(selectShortcutActivity, selectShortcutActivity.f201a));
            listView.setOnItemClickListener(new a());
            this.f202a.setVisibility(8);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f202a.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<i0> a() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = getPackageManager();
        for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null) {
                String str = activityInfo.packageName;
                if (!TextUtils.isEmpty(str)) {
                    String charSequence = resolveInfo.loadLabel(packageManager).toString();
                    if (!TextUtils.isEmpty(charSequence)) {
                        arrayList.add(new i0(str, charSequence, "", resolveInfo.activityInfo.name, resolveInfo.loadIcon(packageManager)));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        i0 i0Var = this.f201a.get(i);
        Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
        intent.setComponent(new ComponentName(i0Var.g(), i0Var.e()));
        try {
            startActivityForResult(intent, i);
        } catch (Exception unused) {
            Toast.makeText(getApplicationContext(), 2131296546, 0).show();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String uri = ((Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT")).toUri(1);
            if (!uri.startsWith("intent:")) {
                uri = "shortcut:" + uri;
            }
            String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
            Intent intent2 = new Intent();
            intent2.putExtra("action", uri);
            intent2.putExtra("name", stringExtra);
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(2131296341);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(2131165187);
        new b().execute(new Void[0]);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}
