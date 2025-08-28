package me.i38.gesture;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import com.mobeta.android.dslv.DragSortListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class PanelEditActivity extends Activity implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f152a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f153b;
    private DragSortListView c;
    private List<String> d;
    private List<Map<String, Object>> e = new ArrayList();
    private SimpleAdapter f;
    private SharedPreferences g;
    private String h;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a implements SimpleAdapter.ViewBinder {
        a(PanelEditActivity panelEditActivity) {
        }

        @Override // android.widget.SimpleAdapter.ViewBinder
        public boolean setViewValue(View view, Object obj, String str) {
            if (view.getId() == 2131099666) {
                ((ImageView) view).setImageDrawable((Drawable) obj);
                return true;
            }
            return false;
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f154a;

        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f156a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ EditText f157b;

            a(EditText editText, EditText editText2) {
                this.f156a = editText;
                this.f157b = editText2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                List list = PanelEditActivity.this.d;
                int i2 = b.this.f154a;
                list.set(i2, this.f156a.getText().toString() + "|" + this.f157b.getText().toString());
                GestureApplication.a(PanelEditActivity.this.f152a);
                PanelEditActivity.this.a();
                PanelEditActivity.this.f.notifyDataSetChanged();
            }
        }

        b(int i) {
            this.f154a = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String str = (String) PanelEditActivity.this.d.get(this.f154a);
            LinearLayout linearLayout = new LinearLayout(PanelEditActivity.this);
            linearLayout.setOrientation(1);
            EditText editText = new EditText(PanelEditActivity.this);
            editText.setText(me.i38.gesture.o0.h.c(PanelEditActivity.this, str));
            EditText editText2 = new EditText(PanelEditActivity.this);
            editText2.setText(me.i38.gesture.o0.h.c(str));
            linearLayout.addView(editText);
            linearLayout.addView(editText2);
            new AlertDialog.Builder(PanelEditActivity.this).setMessage(2131296314).setView(linearLayout).setPositiveButton(17039370, new a(editText2, editText)).show();
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f158a;

        c(int i) {
            this.f158a = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ((ClipboardManager) PanelEditActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("gesturelog", me.i38.gesture.o0.h.c((String) PanelEditActivity.this.d.get(this.f158a))));
            } catch (Exception unused) {
            }
            me.i38.gesture.o0.h.a(PanelEditActivity.this, 2131296363, new Object[0]);
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f160a;

        d(int i) {
            this.f160a = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f160a >= PanelEditActivity.this.d.size() || this.f160a < 0) {
                return;
            }
            PanelEditActivity.this.d.remove(this.f160a);
            GestureApplication.a(PanelEditActivity.this.f152a);
            PanelEditActivity.this.a();
            PanelEditActivity.this.f.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.e.clear();
        for (String str : this.d) {
            HashMap hashMap = new HashMap();
            hashMap.put("image", me.i38.gesture.o0.h.b(GestureApplication.g(), str));
            hashMap.put("text", me.i38.gesture.o0.h.c(GestureApplication.g(), str));
            hashMap.put("action", str);
            this.e.add(hashMap);
        }
        Iterator<String> it = this.d.iterator();
        while (it.hasNext() && me.i38.gesture.o0.h.a(it.next(), this)) {
        }
    }

    public /* synthetic */ void a(int i, int i2) {
        List<String> list = this.d;
        list.add(i2, list.remove(i));
        List<Map<String, Object>> list2 = this.e;
        list2.add(i2, list2.remove(i));
        GestureApplication.a(this.f152a);
        this.f.notifyDataSetChanged();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 2) {
            this.d.add(me.i38.gesture.o0.h.a(intent.getStringExtra("id"), intent.getStringExtra("name")));
            GestureApplication.a(this.f152a);
            a();
            this.f.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle a2 = me.i38.gesture.o0.h.a((Activity) this);
        this.g = PreferenceManager.getDefaultSharedPreferences(this);
        String string = a2.getString("app", "default");
        this.h = string;
        if ("default".equals(string)) {
            setTitle(2131296475);
        } else {
            setTitle(getString(2131296475) + ":" + a2.getString("name", this.h));
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(2131165184);
        Map<String, Object> a3 = me.i38.gesture.o0.h.a(this.g.getString("apps", ""), new HashMap());
        this.f152a = a3;
        Map<String, Object> map = (Map) me.i38.gesture.o0.j.a(a3, this.h, new HashMap());
        this.f153b = map;
        this.d = (List) me.i38.gesture.o0.j.a(map, "panel", new ArrayList());
        a();
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, this.e, 2131165192, new String[]{"image", "text"}, new int[]{2131099666, 2131099667});
        this.f = simpleAdapter;
        simpleAdapter.setViewBinder(new a(this));
        DragSortListView dragSortListView = (DragSortListView) findViewById(2131099655);
        this.c = dragSortListView;
        dragSortListView.setDivider(new ColorDrawable(-3355444));
        this.c.setDividerHeight(1);
        this.c.setAdapter((ListAdapter) this.f);
        this.c.setOnItemClickListener(this);
        this.c.setDropListener(new DragSortListView.j() { // from class: me.i38.gesture.m
            @Override // com.mobeta.android.dslv.DragSortListView.j
            public final void b(int i, int i2) {
                PanelEditActivity.this.a(i, i2);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131230720, menu);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        new AlertDialog.Builder(this).setMessage(me.i38.gesture.o0.h.c(this, this.d.get(i))).setPositiveButton(2131296379, new d(i)).setNegativeButton(2131296376, new c(i)).setNeutralButton(2131296395, new b(i)).show();
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
        startActivityForResult(new Intent(this, SelectActionActivity.class), 2);
        return true;
    }
}
