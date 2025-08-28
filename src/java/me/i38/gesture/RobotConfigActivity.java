package me.i38.gesture;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import com.mobeta.android.dslv.DragSortListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.i38.gesture.RobotConfigActivity;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class RobotConfigActivity extends Activity implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private List<Map> f167a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private PackageManager f168b;
    private SimpleAdapter c;
    private DragSortListView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class a extends SimpleAdapter {
        a(Context context, List list, int i, String[] strArr, int[] iArr) {
            super(context, list, i, strArr, iArr);
        }

        public /* synthetic */ void a(int i, View view) {
            RobotConfigActivity.this.a(i, ((Switch) view).isChecked());
        }

        @Override // android.widget.SimpleAdapter, android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            RelativeLayout relativeLayout = (RelativeLayout) super.getView(i, view, viewGroup);
            Map map = (Map) RobotConfigActivity.this.f167a.get(i);
            Map c = GestureApplication.c(i);
            boolean z = c != null && System.currentTimeMillis() - me.i38.gesture.o0.j.e(c.get("L")) < 60000;
            relativeLayout.findViewById(2131099692).setOnClickListener(new View.OnClickListener() { // from class: me.i38.gesture.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RobotConfigActivity.a.this.a(i, view2);
                }
            });
            TextView textView = (TextView) relativeLayout.findViewById(2131099691);
            String[] strArr = new String[3];
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "⚡" : "");
            sb.append(me.i38.gesture.o0.k.b(map.get("N")));
            strArr[0] = sb.toString();
            strArr[1] = "notification".equals(map.get("s")) ? RobotConfigActivity.this.getString(2131296462) : "";
            strArr[2] = me.i38.gesture.o0.k.b(map.get("m"));
            textView.setText(me.i38.gesture.o0.k.a(",", strArr));
            return relativeLayout;
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    private class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private List<Map> f170a;

        private b() {
        }

        /* synthetic */ b(RobotConfigActivity robotConfigActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            List<Map> r = GestureApplication.r();
            this.f170a = r;
            for (Map map : r) {
                RobotConfigActivity.this.a(map);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            RobotConfigActivity.this.f167a.clear();
            RobotConfigActivity.this.f167a.addAll(this.f170a);
            RobotConfigActivity.this.c.notifyDataSetChanged();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map map) {
        try {
            ApplicationInfo applicationInfo = this.f168b.getApplicationInfo(me.i38.gesture.o0.j.g(map.get("p")), 0);
            map.put("N", applicationInfo.loadLabel(this.f168b).toString());
            map.put("I", applicationInfo.loadIcon(this.f168b));
        } catch (Exception unused) {
            map.put("N", me.i38.gesture.o0.k.b(map.get("p")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(View view, Object obj, String str) {
        if (view.getId() == 2131099690) {
            ((ImageView) view).setImageDrawable((Drawable) obj);
            return true;
        }
        return false;
    }

    public /* synthetic */ void a(int i, int i2) {
        List<Map> list = this.f167a;
        list.add(i2, list.remove(i));
        if (i != i2) {
            GestureApplication.b(i, i2);
            this.c.notifyDataSetChanged();
        }
    }

    public void a(int i, boolean z) {
        if (i < 0 || i >= this.f167a.size()) {
            return;
        }
        Map map = this.f167a.get(i);
        map.put("e", Boolean.valueOf(z));
        GestureApplication.a(i, map);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 8) {
            new b(this, null).execute(new Void[0]);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(2131296516);
        this.f168b = getPackageManager();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(2131165184);
        a aVar = new a(this, this.f167a, 2131165197, new String[]{"I", "n", "e"}, new int[]{2131099690, 2131099693, 2131099692});
        this.c = aVar;
        aVar.setViewBinder(new SimpleAdapter.ViewBinder() { // from class: me.i38.gesture.o
            @Override // android.widget.SimpleAdapter.ViewBinder
            public final boolean setViewValue(View view, Object obj, String str) {
                return RobotConfigActivity.a(view, obj, str);
            }
        });
        DragSortListView dragSortListView = (DragSortListView) findViewById(2131099655);
        this.d = dragSortListView;
        dragSortListView.setDivider(new ColorDrawable(-3355444));
        this.d.setDividerHeight(1);
        this.d.setAdapter((ListAdapter) this.c);
        this.d.setOnItemClickListener(this);
        this.d.setDropListener(new DragSortListView.j() { // from class: me.i38.gesture.q
            @Override // com.mobeta.android.dslv.DragSortListView.j
            public final void b(int i, int i2) {
                RobotConfigActivity.this.a(i, i2);
            }
        });
        new b(this, null).execute(new Void[0]);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131230720, menu);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this, RobotEditActivity.class);
        intent.putExtra("index", i);
        intent.putExtra("action", me.i38.gesture.o0.h.a(this.f167a.get(i), "{}"));
        startActivityForResult(intent, 8);
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
        startActivityForResult(new Intent(this, RobotEditActivity.class), 8);
        return true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.c.notifyDataSetChanged();
    }
}
