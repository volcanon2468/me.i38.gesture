package me.i38.gesture;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class AppCustomActivity extends Activity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {
    private h0 c;
    private Map<String, Object> d;
    private SearchView e;
    private SharedPreferences g;

    /* renamed from: a  reason: collision with root package name */
    private List<i0> f133a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<i0> f134b = new ArrayList();
    private String f = "";

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    private class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        ProgressBar f135a;

        private b() {
            this.f135a = (ProgressBar) AppCustomActivity.this.findViewById(2131099664);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            AppCustomActivity appCustomActivity = AppCustomActivity.this;
            appCustomActivity.f133a = me.i38.gesture.o0.h.c(appCustomActivity);
            Collections.sort(AppCustomActivity.this.f133a);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            this.f135a.setVisibility(8);
            AppCustomActivity.this.b();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f135a.setVisibility(0);
        }
    }

    private void a() {
        this.f134b.clear();
        for (i0 i0Var : this.f133a) {
            if (me.i38.gesture.o0.k.a(this.f) || me.i38.gesture.o0.k.a((Object) i0Var.h(), "").contains(this.f) || me.i38.gesture.o0.k.a((Object) i0Var.g(), "").contains(this.f)) {
                this.f134b.add(i0Var);
            }
        }
        this.c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ArrayList arrayList = new ArrayList();
        if (this.f133a != null) {
            HashSet hashSet = new HashSet();
            this.d = me.i38.gesture.o0.h.a(this.g.getString("apps", ""), new HashMap());
            for (i0 i0Var : this.f133a) {
                hashSet.add(i0Var.g());
                Map map = (Map) this.d.get(i0Var.g());
                if (map != null && me.i38.gesture.o0.j.b(map.get("custom"), true)) {
                    i0Var.a("true");
                    arrayList.add(i0Var);
                }
            }
            Iterator<String> it = this.d.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!"default".equals(next) && !hashSet.contains(next)) {
                    it.remove();
                }
            }
            this.f133a.removeAll(arrayList);
            Collections.sort(arrayList);
            this.f133a.addAll(0, arrayList);
            a();
        }
    }

    public void a(int i, boolean z) {
        String str;
        if (i < 0 || i >= this.f134b.size()) {
            return;
        }
        i0 i0Var = this.f134b.get(i);
        String g = i0Var.g();
        if (z) {
            ((Map) me.i38.gesture.o0.j.a(this.d, g, new HashMap())).remove("custom");
            str = "true";
        } else {
            Map<String, Object> f = me.i38.gesture.o0.j.f(this.d.get(g));
            if (f.isEmpty()) {
                this.d.remove(g);
            } else {
                f.put("custom", false);
            }
            str = "";
        }
        i0Var.a(str);
        GestureApplication.a(this.d);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = PreferenceManager.getDefaultSharedPreferences(this);
        setTitle(2131296352);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(2131165187);
        ListView listView = (ListView) findViewById(2131099663);
        h0 h0Var = new h0(this, this.f134b);
        this.c = h0Var;
        listView.setAdapter((ListAdapter) h0Var);
        listView.setOnItemClickListener(this);
        new b().execute(new Void[0]);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131230723, menu);
        SearchView searchView = (SearchView) menu.findItem(2131099669).getActionView();
        this.e = searchView;
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (TextUtils.isEmpty(this.f134b.get(i).e())) {
            me.i38.gesture.o0.h.a(this, 2131296353, new Object[0]);
            return;
        }
        i0 i0Var = this.f134b.get(i);
        Intent intent = new Intent(this, SettingActivity.class);
        intent.putExtra("app", i0Var.g());
        intent.putExtra("name", i0Var.h());
        startActivity(intent);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        this.f = str;
        a();
        return true;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        b();
    }
}
