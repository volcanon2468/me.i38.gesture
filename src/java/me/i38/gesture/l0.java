package me.i38.gesture;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class l0 implements View.OnTouchListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, View.OnKeyListener {
    private static l0 S;
    private int B;
    private int K;
    private int L;
    private int M;
    private int N;
    private long O;
    private int P;

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f251a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f252b;
    private Vibrator c;
    private SharedPreferences d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private WindowManager.LayoutParams m;
    private WindowManager.LayoutParams n;
    private WindowManager.LayoutParams o;
    private WindowManager.LayoutParams p;
    private WindowManager.LayoutParams q;
    private WindowManager.LayoutParams r;
    private WindowManager.LayoutParams s;
    private WindowManager.LayoutParams t;
    private ScaleGestureDetector u;
    private Handler v;
    private SimpleAdapter x;
    private List<Map<String, Object>> w = new ArrayList();
    private boolean y = false;
    private boolean z = false;
    private int A = 0;
    private boolean C = false;
    private String D = "";
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = false;
    private Map<Integer, String> Q = new HashMap();
    private Runnable R = new a();

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l0.this.I) {
                return;
            }
            l0.this.J = true;
            me.i38.gesture.o0.h.a(l0.this.c, 50);
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class b implements ScaleGestureDetector.OnScaleGestureListener {
        b() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            int i = (int) (l0.this.d.getInt("pad_size", 150) * scaleGestureDetector.getScaleFactor());
            l0 l0Var = l0.this;
            if (i > l0Var.B) {
                i = l0.this.B;
            } else if (i < 30) {
                i = 30;
            }
            l0Var.a(i);
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class c implements SimpleAdapter.ViewBinder {
        c(l0 l0Var) {
        }

        @Override // android.widget.SimpleAdapter.ViewBinder
        public boolean setViewValue(View view, Object obj, String str) {
            if (view.getId() == 2131099675) {
                ((ImageView) view).setImageDrawable((Drawable) obj);
                return true;
            }
            return false;
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f255a;

        d(l0 l0Var, String str) {
            this.f255a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            GestureApplication.a(this.f255a);
        }
    }

    @SuppressLint({"InflateParams"})
    private l0(Context context) {
        this.B = 0;
        this.P = 1000;
        DisplayMetrics m = GestureApplication.m();
        this.d = PreferenceManager.getDefaultSharedPreferences(GestureApplication.g());
        this.f252b = LayoutInflater.from(context);
        this.f251a = (WindowManager) context.getSystemService("window");
        this.c = (Vibrator) context.getSystemService("vibrator");
        this.v = new Handler();
        this.P = ViewConfiguration.getLongPressTimeout() + 1;
        this.B = (int) (Math.min(m.heightPixels, m.widthPixels) / m.density);
        this.u = new ScaleGestureDetector(context, new b());
        this.g = this.f252b.inflate(2131165190, (ViewGroup) null);
        this.o = a(17, 0, 0, 792, 1.0f);
        this.j = this.f252b.inflate(2131165199, (ViewGroup) null);
        this.r = new WindowManager.LayoutParams(Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, 1032, -3);
        this.j.setAlpha(0.5f);
        this.j.setOnTouchListener(this);
        this.h = this.f252b.inflate(2131165190, (ViewGroup) null);
        WindowManager.LayoutParams a2 = a(17, 0, 0, 792, 1.0f);
        this.p = a2;
        a2.height = 1;
        a2.width = 1;
        this.e = this.f252b.inflate(2131165193, (ViewGroup) null);
        WindowManager.LayoutParams a3 = a(17, this.d.getInt("mouse_pad_x", 0), this.d.getInt("mouse_pad_y", m.heightPixels / 4), 8, 1.0f);
        this.m = a3;
        try {
            this.m.getClass().getField("privateFlags").set(this.m, Integer.valueOf(((Integer) a3.getClass().getField("privateFlags").get(this.m)).intValue() | 64));
        } catch (Exception unused) {
        }
        this.e.setOnTouchListener(this);
        this.f = this.f252b.inflate(2131165194, (ViewGroup) null);
        this.n = a(51, m.widthPixels / 2, m.heightPixels / 3, 792, 0.7f);
        this.i = this.f252b.inflate(2131165195, (ViewGroup) null);
        this.q = new WindowManager.LayoutParams(Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, 1280, -3);
        this.i.setFocusableInTouchMode(true);
        this.i.setOnKeyListener(this);
        this.i.setOnTouchListener(this);
        SimpleAdapter simpleAdapter = new SimpleAdapter(GestureApplication.g(), this.w, 2131165196, new String[]{"image", "text"}, new int[]{2131099675, 2131099676});
        this.x = simpleAdapter;
        simpleAdapter.setViewBinder(new c(this));
        GridView gridView = (GridView) this.i.findViewById(2131099674);
        gridView.setAdapter((ListAdapter) this.x);
        gridView.setOnItemClickListener(this);
        gridView.setOnItemLongClickListener(this);
    }

    private int a(int i, int i2, int i3) {
        return i >= i3 ? i3 - 1 : i < i2 ? i2 : i;
    }

    private WindowManager.LayoutParams a(int i, int i2, int i3, int i4, float f) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, i4, -3);
        layoutParams.alpha = f;
        layoutParams.gravity = i;
        layoutParams.x = i2;
        layoutParams.y = i3;
        return layoutParams;
    }

    private Map<String, Object> a(Drawable drawable, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("image", drawable);
        hashMap.put("text", str);
        hashMap.put("action", str2);
        return hashMap;
    }

    private void a(MotionEvent motionEvent, boolean z) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        Map<Integer, String> map = this.Q;
        Integer valueOf = Integer.valueOf(pointerId);
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (z) {
            str = me.i38.gesture.o0.k.a((Object) this.Q.get(Integer.valueOf(pointerId)), "") + ":";
        }
        sb.append(str);
        sb.append((int) (motionEvent.getX(actionIndex) + rawX));
        sb.append(":");
        sb.append((int) (motionEvent.getY(actionIndex) + rawY));
        map.put(valueOf, sb.toString());
    }

    private void b(String str) {
        Context g = GestureApplication.g();
        if (GestureApplication.w()) {
            return;
        }
        Toast.makeText(g, g.getString(2131296473, str), 0).show();
    }

    private void u() {
        DisplayMetrics m = GestureApplication.m();
        WindowManager.LayoutParams layoutParams = this.n;
        layoutParams.x = a(layoutParams.x, 0, m.widthPixels);
        WindowManager.LayoutParams layoutParams2 = this.n;
        layoutParams2.y = a(layoutParams2.y, 0, m.heightPixels);
    }

    public static synchronized l0 v() {
        l0 l0Var;
        synchronized (l0.class) {
            if (S == null) {
                S = new l0(GestureApplication.g());
            }
            l0Var = S;
        }
        return l0Var;
    }

    private void w() {
        List<i0> a2 = me.i38.gesture.o0.h.a(GestureApplication.g(), false);
        Collections.sort(a2);
        this.w.clear();
        this.w.add(a(GestureApplication.g().getResources().getDrawable(2131034117), GestureApplication.g().getString(2131296266), "0"));
        for (int i = 0; i < a2.size(); i++) {
            this.w.add(a(a2.get(i).f(), a2.get(i).h(), me.i38.gesture.o0.h.a(a2.get(i).g(), a2.get(i).h())));
        }
        this.x.notifyDataSetChanged();
        this.i.findViewById(2131099674).requestLayout();
    }

    private void x() {
        if (this.y) {
            w();
        } else {
            y();
        }
    }

    private void y() {
        ArrayList arrayList = new ArrayList();
        Map<String, Object> map = GestureApplication.o;
        if (map != null) {
            arrayList.addAll(me.i38.gesture.o0.j.c(map.get("panel")));
        }
        List<Object> a2 = me.i38.gesture.o0.h.a(this.d.getString("panel_apps", ""), new ArrayList());
        for (int i = 0; i < Math.min(a2.size(), this.d.getInt("panel_apps_num", 5)); i++) {
            String g = me.i38.gesture.o0.j.g(a2.get(i));
            if (!arrayList.contains(g)) {
                arrayList.add(g);
            }
        }
        arrayList.add(me.i38.gesture.o0.h.a("f:1", GestureApplication.g().getString(2131296439)));
        this.w.clear();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.w.add(a(me.i38.gesture.o0.h.b(GestureApplication.g(), (String) arrayList.get(i2)), me.i38.gesture.o0.h.c(GestureApplication.g(), (String) arrayList.get(i2)), (String) arrayList.get(i2)));
        }
        this.x.notifyDataSetChanged();
        this.i.findViewById(2131099674).requestLayout();
    }

    public void a() {
        if (l()) {
            r();
        }
    }

    public void a(int i) {
        if (this.z) {
            this.m.height = GestureApplication.a(i);
            WindowManager.LayoutParams layoutParams = this.m;
            layoutParams.width = layoutParams.height;
            try {
                this.f251a.updateViewLayout(this.e, layoutParams);
            } catch (Exception unused) {
            }
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        String join = TextUtils.join("\n", me.i38.gesture.o0.h.a(accessibilityNodeInfo).values());
        ((TextView) this.e.findViewById(2131099673)).setText(join);
        GestureApplication.h(join);
    }

    public void a(boolean z) {
        if (this.z) {
            if (!z && this.A == 0) {
                this.f.setAlpha(0.0f);
                this.e.setAlpha(0.2f);
                a(30);
                return;
            }
            this.f.setAlpha(0.9f);
            this.e.setAlpha(this.A == 0 ? 0.4f : 0.9f);
            a(this.d.getInt("pad_size", 150));
            GestureApplication.J();
        }
    }

    public synchronized boolean a(String str) {
        if (TextUtils.isEmpty(this.D)) {
            if (!GestureApplication.w()) {
                b(GestureApplication.g().getString(2131296343));
                return false;
            }
            this.p.screenOrientation = "K".equals(str) ? 1 : 0;
            this.f251a.addView(this.h, this.p);
            this.f251a.updateViewLayout(this.h, this.p);
        } else if (this.D.equals(str)) {
            b();
            return true;
        } else {
            this.p.screenOrientation = "K".equals(str) ? 1 : 0;
            this.f251a.updateViewLayout(this.h, this.p);
        }
        this.D = str;
        return true;
    }

    public synchronized void b() {
        this.D = "";
        try {
            this.f251a.removeViewImmediate(this.h);
        } catch (Exception unused) {
        }
    }

    public void b(int i) {
        this.A = i;
        if (this.z && i == 2) {
            GestureExtraService.d();
        } else {
            GestureExtraService.f();
        }
        TextView textView = (TextView) this.e.findViewById(2131099673);
        textView.setText(GestureApplication.g().getString(2131296393));
        textView.setVisibility(this.A == 0 ? 8 : 0);
        a(true);
    }

    public synchronized void c() {
        if (this.C) {
            this.C = false;
            try {
                this.f251a.removeViewImmediate(this.g);
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized boolean c(int i) {
        Toast makeText;
        if (this.z) {
            d();
        } else {
            if (i == 2 && !GestureExtraService.c()) {
                makeText = Toast.makeText(GestureApplication.g(), 2131296498, 0);
            } else if (GestureApplication.w()) {
                this.z = true;
                u();
                try {
                    this.f251a.addView(this.e, this.m);
                    this.f251a.addView(this.f, this.n);
                } catch (Exception unused) {
                }
                b(i);
            } else {
                Context g = GestureApplication.g();
                makeText = Toast.makeText(g, g.getString(2131296473, ""), 0);
            }
            makeText.show();
        }
        return true;
    }

    public synchronized void d() {
        if (this.z) {
            this.z = false;
            try {
                this.f251a.removeViewImmediate(this.e);
                this.f251a.removeViewImmediate(this.f);
            } catch (Exception unused) {
            }
            b(this.A);
        }
    }

    public synchronized void e() {
        if (this.E) {
            this.E = false;
            try {
                this.f251a.removeViewImmediate(this.i);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void f() {
        if (this.F) {
            this.F = false;
            try {
                this.f251a.removeViewImmediate(this.j);
            } catch (Throwable unused) {
            }
        }
    }

    public void g() {
        if (n()) {
            t();
        }
    }

    public String h() {
        return this.D;
    }

    public synchronized View i() {
        if (!this.C) {
            try {
                this.f251a.removeViewImmediate(this.g);
            } catch (Throwable unused) {
            }
            this.f251a.addView(this.g, this.o);
            this.C = true;
        }
        return this.g;
    }

    public int j() {
        return this.A;
    }

    public int[] k() {
        int[] iArr = new int[2];
        if (this.z) {
            this.f.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public boolean l() {
        return this.G;
    }

    public boolean m() {
        return this.z;
    }

    public boolean n() {
        return this.H;
    }

    public void o() {
        int[] k = k();
        int max = Math.max(0, k[0] - 1);
        int max2 = Math.max(0, k[1] - 1);
        String a2 = GestureExtraService.a(max, max2);
        ((TextView) this.e.findViewById(2131099673)).setText(max + "," + max2 + "," + a2);
        GestureApplication.h(max + "," + max2 + "," + a2);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String g = me.i38.gesture.o0.j.g(this.w.get(i).get("action"));
        if (me.i38.gesture.o0.k.b(g, "f")) {
            this.y = true;
            w();
        } else if ("0".equals(g)) {
            this.y = false;
            y();
        } else {
            if (me.i38.gesture.o0.h.f(g) || "e".equals(g) || g.startsWith("click:") || g.startsWith("N") || g.startsWith("T")) {
                new Handler().postDelayed(new d(this, g), 500L);
            } else {
                Intent launchIntentForPackage = GestureApplication.g().getPackageManager().getLaunchIntentForPackage(me.i38.gesture.o0.h.c(g));
                if (this.y && launchIntentForPackage != null) {
                    List<Object> a2 = me.i38.gesture.o0.h.a(this.d.getString("panel_apps", ""), new ArrayList());
                    if (a2.contains(g)) {
                        a2.remove(g);
                    }
                    a2.add(0, g);
                    int i2 = this.d.getInt("panel_apps_num", 5);
                    if (a2.size() > i2) {
                        a2 = a2.subList(0, i2);
                    }
                    this.d.edit().putString("panel_apps", me.i38.gesture.o0.h.a(a2, "")).commit();
                }
                GestureApplication.a(g);
            }
            s();
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent launchIntentForPackage = GestureApplication.g().getPackageManager().getLaunchIntentForPackage(me.i38.gesture.o0.h.c(me.i38.gesture.o0.j.g(this.w.get(i).get("action"))));
        if (launchIntentForPackage == null || Build.VERSION.SDK_INT < 24) {
            Toast.makeText(GestureApplication.g(), 2131296406, 0).show();
            return true;
        }
        try {
            ActivityOptions a2 = me.i38.gesture.o0.h.a();
            launchIntentForPackage.addFlags(805306368);
            GestureApplication.g().startActivity(launchIntentForPackage, a2.toBundle());
        } catch (Throwable th) {
            Log.d("gesturelog", "freeform error:", th);
        }
        s();
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 || !this.E || keyEvent.getAction() != 1) {
            return i == 4 && n();
        }
        if (this.y) {
            this.y = false;
            x();
        } else {
            s();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
        if ("T".equals(me.i38.gesture.SelectPlusActionActivity.b()) != false) goto L28;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: me.i38.gesture.l0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void p() {
        this.d.edit().putInt("pad_size", (int) GestureApplication.d(this.m.width)).apply();
    }

    public synchronized void q() {
        if (!this.F) {
            try {
                this.f251a.removeViewImmediate(this.j);
            } catch (Throwable unused) {
            }
            this.f251a.addView(this.j, this.r);
            this.F = true;
        }
    }

    public synchronized boolean r() {
        if (this.G) {
            try {
                this.f251a.removeViewImmediate(this.k);
            } catch (Throwable unused) {
            }
            this.G = false;
        } else if (!GestureApplication.w()) {
            b(GestureApplication.g().getString(2131296297));
            return false;
        } else {
            if (this.k == null) {
                this.k = this.f252b.inflate(2131165190, (ViewGroup) null);
                this.s = a(17, 0, 0, 152, 1.0f);
            }
            try {
                this.f251a.addView(this.k, this.s);
            } catch (Exception unused2) {
            }
            this.G = true;
        }
        return true;
    }

    public synchronized boolean s() {
        if (this.E) {
            e();
        } else if (!GestureApplication.w()) {
            b(GestureApplication.g().getString(2131296315));
            return false;
        } else {
            try {
                this.f251a.addView(this.i, this.q);
                DisplayMetrics m = GestureApplication.m();
                LinearLayout linearLayout = (LinearLayout) this.i.findViewById(2131099677);
                int i = GestureApplication.k() == 0 ? this.d.getInt("panel_padding_bottom", 50) : 5;
                int a2 = GestureApplication.a(this.d.getInt("panel_padding_left", 50));
                linearLayout.setPadding(a2, 0, a2, GestureApplication.a(i));
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                layoutParams.height = GestureApplication.a(this.d.getInt("panel_height", 300) + i);
                linearLayout.setLayoutParams(layoutParams);
                ((GridView) this.i.findViewById(2131099674)).setNumColumns(Math.max((int) (((m.widthPixels / m.density) - (this.d.getInt("panel_padding_left", 50) * 2)) / 75.0f), 1));
                this.i.requestFocus();
                this.E = true;
                x();
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public synchronized boolean t() {
        if (this.H) {
            try {
                this.f251a.removeViewImmediate(this.l);
            } catch (Throwable unused) {
            }
            this.H = false;
        } else if (!GestureApplication.w()) {
            b(GestureApplication.g().getString(2131296298));
            return false;
        } else {
            if (this.l == null) {
                View inflate = this.f252b.inflate(2131165199, (ViewGroup) null);
                this.l = inflate;
                inflate.setAlpha(0.0f);
                this.l.setFocusableInTouchMode(true);
                this.l.setOnKeyListener(this);
                this.t = new WindowManager.LayoutParams(Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, 1280, -3);
            }
            try {
                this.f251a.addView(this.l, this.t);
                this.l.requestFocus();
            } catch (Exception unused2) {
            }
            this.H = true;
        }
        return true;
    }
}
