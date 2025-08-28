package me.i38.gesture;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class SelectAppActivity extends Activity implements SearchView.OnQueryTextListener {
    private j0 c;
    private SearchView d;

    /* renamed from: a  reason: collision with root package name */
    private List<i0> f187a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<i0> f188b = new ArrayList();
    private String e = "";

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f189a;

        a(EditText editText) {
            this.f189a = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.putExtra("action", this.f189a.getText().toString());
            intent.putExtra("name", this.f189a.getText().toString());
            SelectAppActivity.this.setResult(-1, intent);
            SelectAppActivity.this.finish();
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    private class b extends AsyncTask<String, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        ProgressBar f191a;

        private b() {
            this.f191a = (ProgressBar) SelectAppActivity.this.findViewById(2131099664);
        }

        /* synthetic */ b(SelectAppActivity selectAppActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            SelectAppActivity selectAppActivity = SelectAppActivity.this;
            selectAppActivity.f187a = me.i38.gesture.o0.h.a((Context) selectAppActivity, false);
            Collections.sort(SelectAppActivity.this.f187a);
            if (strArr.length <= 0 || strArr[0] == null) {
                return null;
            }
            SelectAppActivity.this.f187a.add(0, new i0("", SelectAppActivity.this.getString(2131296265), SelectAppActivity.this.getResources().getDrawable(2131034141)));
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            SelectAppActivity.this.a();
            if (SelectAppActivity.this.isFinishing()) {
                return;
            }
            this.f191a.setVisibility(8);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f191a.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f188b.clear();
        for (i0 i0Var : this.f187a) {
            if (me.i38.gesture.o0.k.a(this.e) || me.i38.gesture.o0.k.a((Object) i0Var.h(), "").contains(this.e) || me.i38.gesture.o0.k.a((Object) i0Var.g(), "").contains(this.e)) {
                this.f188b.add(i0Var);
            }
        }
        this.c.notifyDataSetChanged();
    }

    private void a(int i) {
        i0 i0Var = this.f188b.get(i);
        Intent intent = new Intent();
        intent.putExtra("action", i0Var.g());
        intent.putExtra("name", i0Var.h());
        setResult(-1, intent);
        finish();
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        a(i);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle a2 = me.i38.gesture.o0.h.a((Activity) this);
        setTitle(2131296543);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(2131165187);
        ListView listView = (ListView) findViewById(2131099663);
        j0 j0Var = new j0(this, this.f188b);
        this.c = j0Var;
        listView.setAdapter((ListAdapter) j0Var);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: me.i38.gesture.r
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                SelectAppActivity.this.a(adapterView, view, i, j);
            }
        });
        new b(this, null).execute(a2.getString("action"));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131230721, menu);
        SearchView searchView = (SearchView) menu.findItem(2131099669).getActionView();
        this.d = searchView;
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131099668) {
            return super.onOptionsItemSelected(menuItem);
        }
        EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setMessage(2131296544).setView(editText).setPositiveButton(17039370, new a(editText)).show();
        return true;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        this.e = str;
        a();
        return true;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }
}
