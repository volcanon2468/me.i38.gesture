package me.i38.gesture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class SelectDevtoolsActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private List<i0> f193a = null;

    private void a(int i) {
        i0 i0Var = this.f193a.get(i);
        a(i0Var.g(), i0Var.h());
    }

    private void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("action", str);
        intent.putExtra("name", str2);
        setResult(-1, intent);
        finish();
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        a(i);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(2131296545);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(2131165187);
        ListView listView = (ListView) findViewById(2131099663);
        ArrayList arrayList = new ArrayList();
        this.f193a = arrayList;
        arrayList.add(new i0("m:1", getString(2131296325), me.i38.gesture.o0.h.b(this, "m")));
        this.f193a.add(new i0("m:2", getString(2131296326), me.i38.gesture.o0.h.b(this, "m")));
        listView.setAdapter((ListAdapter) new j0(this, this.f193a));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: me.i38.gesture.s
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                SelectDevtoolsActivity.this.a(adapterView, view, i, j);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}
