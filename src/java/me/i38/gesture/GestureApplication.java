package me.i38.gesture;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.media.session.MediaSessionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class GestureApplication extends Application {
    private static String E;

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f138a;

    /* renamed from: b  reason: collision with root package name */
    private static GestureApplication f139b;
    private static SensorManager c;
    private static WindowManager d;
    private static DisplayManager e;
    private static ClipboardManager f;
    private static KeyguardManager g;
    public static NotificationManager h;
    private static MediaSessionManager i;
    private static CameraManager j;
    private static Handler k = new Handler(Looper.getMainLooper());
    private static boolean l = false;
    private static Sensor m = null;
    private static boolean n = false;
    public static Map<String, Object> o = new HashMap();
    public static Queue<String> p = new ConcurrentLinkedQueue();
    public static Queue<String> q = new ConcurrentLinkedQueue();
    public static Map<String, Object> r = null;
    public static Notification s = null;
    public static Map<String, String> t = new ConcurrentHashMap();
    public static long u = 0;
    public static int v = -1;
    public static boolean w = false;
    public static boolean x = false;
    public static List<Map> y = null;
    public static int z = 0;
    private static Map<String, List> A = null;
    private static boolean B = true;
    private static int C = 0;
    private static long D = System.currentTimeMillis();
    private static int F = -1;
    private static long G = 0;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a implements DisplayManager.DisplayListener {
        a() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            try {
                GestureApplication.this.H();
                l0.v().e();
            } catch (Exception e) {
                Log.e("gesturelog", "orientation:", e);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class b extends CameraManager.TorchCallback {
        b(GestureApplication gestureApplication) {
        }

        @Override // android.hardware.camera2.CameraManager.TorchCallback
        public void onTorchModeChanged(String str, boolean z) {
            boolean unused = GestureApplication.l = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GestureApplication.g((Activity) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class d implements com.android.billingclient.api.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f141a;

        d(Activity activity) {
            this.f141a = activity;
        }

        public void a() {
        }

        public void a(com.android.billingclient.api.i iVar) {
            if (iVar.b() == 0) {
                GestureApplication.h(this.f141a);
            } else {
                GestureApplication.f(this.f141a);
            }
        }
    }

    public static boolean A() {
        return Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(f139b);
    }

    public static boolean B() {
        return l;
    }

    public static boolean C() {
        KeyguardManager keyguardManager = g;
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean D() {
        return n;
    }

    public static synchronized int E() {
        synchronized (GestureApplication.class) {
            String trim = f138a.getString("pay_key", "").trim();
            if (trim.length() > 0) {
                e(trim);
            }
            e(-1);
            Log.d("gesturelog", "pay unbind[" + trim + "]:" + F);
        }
        return 0;
    }

    public static synchronized Map F() {
        Map map;
        synchronized (GestureApplication.class) {
            map = (y == null || y.size() <= 0) ? null : y.get(0);
            if (map != null && me.i38.gesture.o0.k.a(map.get("i")) == 0) {
                if (me.i38.gesture.o0.k.a(map.get("n"), "").startsWith("@")) {
                    GestureExtraService.e();
                }
                map.put("i", 1);
            }
        }
        return map;
    }

    public static void G() {
        if (f138a.getString("apps", "").length() == 0) {
            SharedPreferences.Editor edit = f138a.edit();
            edit.putString("apps", "{\"default\":{\"gestures\":[{\"axis\":\"1\",\"action\":\"4\"},{\"axis\":\"2\",\"action\":\"1\"},{\"axis\":\"3\",\"action\":\"3\"}]}}");
            edit.commit();
        }
        if (f138a.getLong("install_ts", 0L) == 0) {
            SharedPreferences.Editor edit2 = f138a.edit();
            edit2.putLong("install_ts", System.currentTimeMillis());
            edit2.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        try {
            C = d.getDefaultDisplay().getRotation();
            boolean e2 = me.i38.gesture.o0.h.e(this);
            Log.d("gesturelog", "LastRotation:" + C + ",portrait:" + e2);
            if (e2 && C != 0 && C != 2) {
                C = 0;
            } else if (!e2 && C != 1 && C != 3) {
                C = 1;
            }
        } catch (Exception e3) {
            Log.d("gesturelog", "refreshLastRotation:", e3);
        }
    }

    public static void I() {
        List<Map> r2 = r();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < r2.size(); i2++) {
            Map map = r2.get(i2);
            if (me.i38.gesture.o0.j.a(map.get("e"))) {
                String g2 = me.i38.gesture.o0.j.g(map.get("p"));
                map.put("D", Integer.valueOf(i2));
                ((ArrayList) me.i38.gesture.o0.j.a(hashMap, g2, new ArrayList())).add(map);
            }
        }
        A = hashMap;
    }

    public static void J() {
        u = System.currentTimeMillis();
    }

    public static int a(float f2) {
        return Math.round(f2 * m().density);
    }

    public static Notification a(Context context, int i2, String str, PendingIntent pendingIntent) {
        String str2;
        Notification.Builder contentText = new Notification.Builder(context).setSmallIcon(2131034167).setContentText(str);
        if (Build.VERSION.SDK_INT >= 26) {
            if (i2 <= 0 || i2 > 4) {
                str2 = "general";
            } else {
                str2 = "user" + i2;
            }
            contentText.setChannelId(str2);
        }
        if (pendingIntent != null) {
            contentText.setContentIntent(pendingIntent);
        }
        return contentText.build();
    }

    public static String a(int i2) {
        GestureApplication gestureApplication;
        int i3;
        if (i2 == 1) {
            gestureApplication = f139b;
            i3 = 2131296593;
        } else if (i2 == 2) {
            gestureApplication = f139b;
            i3 = 2131296595;
        } else if (i2 == 3) {
            gestureApplication = f139b;
            i3 = 2131296597;
        } else {
            gestureApplication = f139b;
            i3 = 2131296432;
        }
        return gestureApplication.getString(i3);
    }

    public static Map<String, Object> a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return me.i38.gesture.o0.k.b("s", obj, "p", obj2, "c", obj3, "n", obj4, "t", obj5, "f", obj6, "o", obj7, "m", obj8, "a", obj9, "e", obj10);
    }

    public static void a(int i2, int i3, int i4) {
        HashMap hashMap = new HashMap();
        r = hashMap;
        hashMap.put("x", Integer.valueOf(i2));
        r.put("y", Integer.valueOf(i3));
        r.put("d", Integer.valueOf(Math.max(i4, 1)));
    }

    public static void a(int i2, Map<String, Object> map) {
        List<Map> r2 = r();
        if (map != null) {
            Map<String, Object> a2 = a(map.get("s"), map.get("p"), map.get("c"), map.get("n"), map.get("t"), map.get("f"), map.get("o"), map.get("m"), map.get("a"), map.get("e"));
            if (i2 < 0) {
                r2.add(a2);
            } else if (i2 < r2.size()) {
                r2.set(i2, a2);
            }
        } else if (i2 >= 0 && i2 < r2.size()) {
            r2.remove(i2);
        }
        a(r2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(final Activity activity, com.android.billingclient.api.i iVar, List list) {
        if (iVar.b() != 0 || list.size() <= 0) {
            k.post(new Runnable() { // from class: me.i38.gesture.b
                @Override // java.lang.Runnable
                public final void run() {
                    me.i38.gesture.o0.h.a(activity, 2131296512, new Object[0]);
                }
            });
            return;
        }
        com.android.billingclient.api.e eVar = H;
        h.a j2 = com.android.billingclient.api.h.j();
        j2.a((com.android.billingclient.api.n) list.get(0));
        eVar.a(activity, j2.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(com.android.billingclient.api.i iVar, List list) {
        if (iVar.b() != 0 || list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.android.billingclient.api.k kVar = (com.android.billingclient.api.k) it.next();
            if (kVar.b() == 1 && !kVar.f()) {
                com.android.billingclient.api.e eVar = H;
                a.a b2 = com.android.billingclient.api.a.b();
                b2.a(kVar.c());
                eVar.a(b2.a(), new com.android.billingclient.api.b() { // from class: me.i38.gesture.e
                    public final void a(com.android.billingclient.api.i iVar2) {
                        GestureApplication.e(2);
                    }
                });
            }
        }
    }

    public static void a(String str) {
        a(str, "now");
    }

    public static void a(String str, Object obj) {
        t.clear();
        t.put("trigger", str);
        s = obj instanceof Notification ? (Notification) obj : null;
    }

    public static void a(String str, String str2) {
        Queue<String> queue;
        if (!C() || "now".equals(str2)) {
            queue = p;
        } else if (!"later".equals(str2) && q.contains(str)) {
            return;
        } else {
            queue = q;
        }
        queue.add(str);
    }

    public static void a(List<Map> list) {
        f138a.edit().putString("robots", me.i38.gesture.o0.h.a(list, "[]")).commit();
        I();
    }

    public static void a(Map<String, Object> map) {
        g(me.i38.gesture.o0.h.a(map, "{}"));
    }

    public static void a(n0 n0Var) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("", Boolean.valueOf(d(k0.f249a[0])));
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 23) {
                for (StatusBarNotification statusBarNotification : h.getActiveNotifications()) {
                    arrayList.add(Integer.valueOf(statusBarNotification.getId()));
                }
            }
            for (int i2 = 0; i2 < k0.f249a.length; i2++) {
                String str = k0.f249a[i2];
                boolean d2 = d(str);
                hashMap.put(str, Boolean.valueOf(d2));
                if (d2) {
                    int i3 = i2 + 200;
                    if (!arrayList.contains(Integer.valueOf(i3))) {
                        Intent intent = new Intent(g(), n0Var.getClass());
                        intent.putExtra("id", i3);
                        a(n0Var, 0, g().getString(2131296461, me.i38.gesture.o0.h.c(g(), str)), PendingIntent.getService(n0Var, i3, intent, 201326592), i3);
                    }
                }
                if (!d2) {
                    h.cancel(i2 + 200);
                }
            }
            Intent intent2 = new Intent("me.i38.gesture.BeautifySwitchService");
            intent2.putExtra("state", me.i38.gesture.o0.h.a(hashMap, ""));
            g().sendStickyBroadcast(intent2);
        } catch (Exception e2) {
            Log.d("gesturelog", "refreshActionState:", e2);
        }
    }

    public static boolean a() {
        boolean z2 = B && System.currentTimeMillis() - D < 100;
        B = false;
        return z2;
    }

    public static synchronized boolean a(int i2, int i3) {
        synchronized (GestureApplication.class) {
            GestureExtraService.g();
            z = i3;
            if (y == null || i2 <= 0 || y.size() <= i2) {
                y = null;
                return true;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                y.remove(0);
            }
            y.get(0).put("s", Long.valueOf(System.currentTimeMillis()));
            return false;
        }
    }

    public static boolean a(Context context, int i2, String str, PendingIntent pendingIntent, int i3) {
        h.notify(i3, a(context, i2, str, pendingIntent));
        return true;
    }

    public static boolean a(InvocationHandler invocationHandler, Handler handler) {
        try {
            if (i != null && v()) {
                Class<?> cls = Class.forName("android.media.session.MediaSessionManager$OnVolumeKeyLongPressListener");
                Method declaredMethod = MediaSessionManager.class.getDeclaredMethod("setOnVolumeKeyLongPressListener", cls, Handler.class);
                if (!f138a.getBoolean("off_scr_long_press", false) || invocationHandler == null) {
                    declaredMethod.invoke(i, null, null);
                } else {
                    declaredMethod.invoke(i, Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), new Class[]{cls}, invocationHandler), handler);
                }
                return true;
            }
        } catch (Throwable th) {
            Log.e("gesturelog", "setOnVolumeKeyLongPressListener", th);
        }
        return false;
    }

    public static synchronized int b(boolean z2) {
        // Always return premium status (2) without verification
        return 2;
    }

    public static void b(int i2, int i3) {
        List<Map> r2 = r();
        r2.add(i3, r2.remove(i2));
        a(r2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(final Activity activity, com.android.billingclient.api.i iVar, List list) {
        if (iVar.b() != 0) {
            f(activity);
            return;
        }
        boolean z2 = false;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.android.billingclient.api.k kVar = (com.android.billingclient.api.k) it.next();
                if (kVar.e().contains("gesture.activation") && kVar.b() == 1) {
                    if (!kVar.f()) {
                        com.android.billingclient.api.e eVar = H;
                        a.a b2 = com.android.billingclient.api.a.b();
                        b2.a(kVar.c());
                        eVar.a(b2.a(), new com.android.billingclient.api.b() { // from class: me.i38.gesture.d
                            public final void a(com.android.billingclient.api.i iVar2) {
                                GestureApplication.b(iVar2);
                            }
                        });
                    }
                    z2 = true;
                }
            }
        }
        e(z2 ? 2 : -1);
        if (activity != null) {
            if (z2) {
                k.post(new Runnable() { // from class: me.i38.gesture.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        me.i38.gesture.o0.h.a(activity, 2131296513, new Object[0]);
                    }
                });
                return;
            }
            com.android.billingclient.api.e eVar2 = H;
            o.a c2 = com.android.billingclient.api.o.c();
            c2.a(me.i38.gesture.o0.k.a((Object[]) new String[]{"gesture.activation"}));
            c2.a("inapp");
            eVar2.a(c2.a(), new com.android.billingclient.api.p() { // from class: me.i38.gesture.h
                public final void a(com.android.billingclient.api.i iVar2, List list2) {
                    GestureApplication.a(activity, iVar2, list2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(com.android.billingclient.api.i iVar) {
    }

    public static boolean b() {
        if (u()) {
            return true;
        }
        Intent e2 = me.i38.gesture.o0.h.e("android.settings.APP_NOTIFICATION_SETTINGS");
        if (Build.VERSION.SDK_INT >= 26) {
            e2.putExtra("android.provider.extra.APP_PACKAGE", f139b.getPackageName());
        } else {
            e2.putExtra("app_package", f139b.getPackageName());
            e2.putExtra("app_uid", f139b.getApplicationInfo().uid);
        }
        try {
            f139b.startActivity(e2);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(int i2) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                AppOpsManager appOpsManager = (AppOpsManager) f139b.getSystemService("appops");
                return me.i38.gesture.o0.j.b(appOpsManager.getClass().getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(i2), Integer.valueOf(Process.myUid()), f139b.getPackageName())) == 0;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r1.checkOpNoThrow(r5, android.os.Process.myUid(), me.i38.gesture.GestureApplication.f139b.getPackageName()) == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.lang.String r5) {
        /*
            r0 = 1
            me.i38.gesture.GestureApplication r1 = me.i38.gesture.GestureApplication.f139b     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "appops"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L35
            android.app.AppOpsManager r1 = (android.app.AppOpsManager) r1     // Catch: java.lang.Throwable -> L35
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L35
            r3 = 29
            r4 = 0
            if (r2 < r3) goto L25
            int r2 = android.os.Process.myUid()     // Catch: java.lang.Throwable -> L35
            me.i38.gesture.GestureApplication r3 = me.i38.gesture.GestureApplication.f139b     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Throwable -> L35
            int r5 = r1.unsafeCheckOpRaw(r5, r2, r3)     // Catch: java.lang.Throwable -> L35
            if (r5 != 0) goto L23
            goto L35
        L23:
            r0 = 0
            goto L35
        L25:
            int r2 = android.os.Process.myUid()     // Catch: java.lang.Throwable -> L35
            me.i38.gesture.GestureApplication r3 = me.i38.gesture.GestureApplication.f139b     // Catch: java.lang.Throwable -> L35
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Throwable -> L35
            int r5 = r1.checkOpNoThrow(r5, r2, r3)     // Catch: java.lang.Throwable -> L35
            if (r5 != 0) goto L23
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: me.i38.gesture.GestureApplication.b(java.lang.String):boolean");
    }

    public static String c(boolean z2) {
        // Always return premium status message
        Context g2 = g();
        String string2 = g2.getString(2131296356);
        StringBuilder sb = new StringBuilder();
        sb.append(string2);
        sb.append(" ");
        sb.append(g2.getString(2131296583)); // Premium status message
        return sb.toString();
    }

    public static List<Map> c(String str) {
        Map<String, List> map;
        if (TextUtils.isEmpty(str) || (map = A) == null) {
            return null;
        }
        return map.get(str);
    }

    public static Map c(int i2) {
        Map<String, List> map = A;
        if (map != null) {
            for (List<Map> list : map.values()) {
                for (Map map2 : list) {
                    if (me.i38.gesture.o0.j.b(map2.get("D"), -1) == i2) {
                        return map2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static boolean c() {
        if (w()) {
            return true;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + f139b.getPackageName()));
        intent.addFlags(268435456);
        if (me.i38.gesture.o0.h.c()) {
            Intent intent2 = new Intent();
            intent2.addFlags(268435456);
            intent2.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            try {
                f139b.startActivity(intent2);
                return false;
            } catch (Exception unused) {
            }
        }
        f139b.startActivity(intent);
        return false;
    }

    public static float d(int i2) {
        return i2 / m().density;
    }

    public static void d(boolean z2) {
        Log.d("gesturelog", "set mainSwitch:" + z2);
        SharedPreferences.Editor edit = f138a.edit();
        edit.putBoolean("main_switch", z2);
        edit.commit();
    }

    public static boolean d() {
        if (A()) {
            return true;
        }
        Intent e2 = me.i38.gesture.o0.h.e("android.settings.action.MANAGE_WRITE_SETTINGS");
        e2.setData(Uri.parse("package:" + f139b.getPackageName()));
        try {
            f139b.startActivity(e2);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(String str) {
        try {
            if (me.i38.gesture.o0.k.a(str)) {
                return false;
            }
            String c2 = me.i38.gesture.o0.h.c(str);
            if (c2.equals("t")) {
                return "t".equals(l0.v().h());
            }
            if (c2.equals("K")) {
                return "K".equals(l0.v().h());
            }
            if (c2.equals("p")) {
                return x;
            }
            if (c2.equals("Q")) {
                return l0.v().l();
            }
            if (c2.equals("R")) {
                return l0.v().n();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void e() {
        u = 0L;
    }

    public static void e(int i2) {
        // Always set to premium status (2) regardless of input
        F = 2;
        f138a.edit().putInt("verify_result", 2).putLong("verify_ts", System.currentTimeMillis()).commit();
    }

    private static boolean e(String str) {
        return str != null && str.length() > 64;
    }

    public static CameraManager f() {
        return j;
    }

    public static String f(String str) {
        if (str != null && str.indexOf("{") != -1) {
            Date date = new Date();
            Map<String, Object> b2 = me.i38.gesture.o0.k.b("date", DateFormat.getDateInstance(2, Locale.getDefault()).format(date), "time", DateFormat.getTimeInstance(2, Locale.getDefault()).format(date), "datetime", DateFormat.getDateTimeInstance(2, 2, Locale.getDefault()).format(date));
            b2.putAll(t);
            for (String str2 : b2.keySet()) {
                str = str.replace("{" + str2 + "}", me.i38.gesture.o0.k.b((String) b2.get(str2)));
            }
        }
        return str;
    }

    public static void f(int i2) {
        v = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(final Activity activity) {
        // Always set premium status without verification
        e(2); // Set premium status (2)
        Log.d("gesturelog", "Premium features enabled for all users");
    }

    public static Context g() {
        return f139b;
    }

    public static void g(Activity activity) {
        // Always set premium status without verification
        e(2); // Set premium status (2)
    }

    public static void g(String str) {
        SharedPreferences.Editor edit = f138a.edit();
        edit.putString("apps", str);
        edit.commit();
        me.i38.gesture.o0.h.a(f139b, "load");
    }

    public static Sensor h() {
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(final Activity activity) {
        // Always set premium status without verification
        e(2); // Set premium status (2)
    }

    public static boolean h(String str) {
        try {
            f.setPrimaryClip(ClipData.newPlainText("gesturelog", str));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long i() {
        long currentTimeMillis = System.currentTimeMillis();
        return Math.abs((currentTimeMillis - f138a.getLong("install_ts", currentTimeMillis)) / 86400000);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
        r3 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean i(java.lang.String r8) {
        /*
            java.lang.Class<me.i38.gesture.GestureApplication> r0 = me.i38.gesture.GestureApplication.class
            monitor-enter(r0)
            r1 = 0
            if (r8 != 0) goto Le
            r8 = 2147483647(0x7fffffff, float:NaN)
            a(r8, r1)     // Catch: java.lang.Throwable -> L96
            goto L83
        Le:
            java.lang.String r2 = "ss:"
            boolean r2 = r8.startsWith(r2)     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L1b
            r2 = 3
            java.lang.String r8 = r8.substring(r2)     // Catch: java.lang.Throwable -> L96
        L1b:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            r2.<init>()     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            r3 = 0
            java.util.List r8 = me.i38.gesture.o0.h.a(r8, r3)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
        L29:
            boolean r4 = r8.hasNext()     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            if (r4 == 0) goto L7b
            java.lang.Object r4 = r8.next()     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            java.util.Map r4 = (java.util.Map) r4     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            r2.add(r4)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            java.lang.String r5 = "p"
            java.lang.Object r5 = r4.get(r5)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            java.lang.String r6 = "n"
            java.lang.Object r6 = r4.get(r6)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            java.lang.String r7 = "a"
            java.lang.Object r7 = r4.get(r7)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            if (r5 != 0) goto L5b
            if (r6 == 0) goto L5b
            if (r3 == 0) goto L5b
            java.lang.String r6 = "p"
            r4.put(r6, r3)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
        L5b:
            if (r7 == 0) goto L77
            int r4 = r7.length()     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            r6 = 2
            if (r4 < r6) goto L77
            java.lang.String r4 = ":"
            int r4 = r7.indexOf(r4)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            r6 = -1
            if (r4 != r6) goto L77
            java.lang.String r4 = ";"
            int r4 = r7.indexOf(r4)     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            if (r4 != r6) goto L77
            r3 = r7
            goto L29
        L77:
            if (r5 == 0) goto L29
            r3 = r5
            goto L29
        L7b:
            int r8 = r2.size()     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
            if (r8 <= 0) goto L83
            me.i38.gesture.GestureApplication.y = r2     // Catch: java.lang.Exception -> L86 java.lang.Throwable -> L96
        L83:
            r8 = 1
            monitor-exit(r0)
            return r8
        L86:
            android.content.Context r8 = g()     // Catch: java.lang.Throwable -> L96
            r2 = 2131296561(0x7f090131, float:1.8211042E38)
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r2, r1)     // Catch: java.lang.Throwable -> L96
            r8.show()     // Catch: java.lang.Throwable -> L96
            monitor-exit(r0)
            return r1
        L96:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: me.i38.gesture.GestureApplication.i(java.lang.String):boolean");
    }

    public static int j() {
        return v;
    }

    public static int k() {
        return C;
    }

    public static boolean l() {
        return f138a.getBoolean("main_switch", false);
    }

    public static DisplayMetrics m() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        d.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static Map<String, Object> n() {
        Map<String, Object> map = r;
        r = null;
        return map;
    }

    public static long o() {
        return u;
    }

    public static int p() {
        // Always return premium status (2)
        return 2;
    }

    public static String q() {
        String poll = p.poll();
        return (poll != null || C()) ? poll : q.poll();
    }

    public static List<Map> r() {
        return me.i38.gesture.o0.h.b(f138a.getString("robots", ""), new ArrayList());
    }

    public static SensorManager s() {
        return c;
    }

    private void t() {
        PackageManager packageManager = getPackageManager();
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        c = sensorManager;
        m = sensorManager == null ? null : sensorManager.getDefaultSensor(4);
        if (!packageManager.hasSystemFeature("android.hardware.sensor.gyroscope") || m == null) {
            return;
        }
        String lowerCase = (m.getVendor() + " " + m.getName()).toLowerCase();
        n = (lowerCase.contains("virtual") || lowerCase.contains("pseudo") || lowerCase.contains("goldfish") || lowerCase.contains("softgyro")) ? false : true;
    }

    public static boolean u() {
        return Build.VERSION.SDK_INT < 24 || h.areNotificationsEnabled();
    }

    public static boolean v() {
        return Build.VERSION.SDK_INT >= 26 && f139b.checkSelfPermission("android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER") == 0;
    }

    public static boolean w() {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(f139b);
    }

    public static boolean x() {
        return Build.VERSION.SDK_INT < 33 || f139b.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0;
    }

    public static boolean y() {
        Map<String, List> map = A;
        return map != null && map.size() > 0;
    }

    public static boolean z() {
        return Build.VERSION.SDK_INT < 23 || f139b.checkSelfPermission("android.permission.WRITE_SECURE_SETTINGS") == 0;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f139b = this;
        Log.d("gesturelog", "App start");
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                b.a.a.i.a("");
            } catch (Throwable unused) {
            }
        }
        PreferenceManager.setDefaultValues(this, 2131492868, false);
        f138a = PreferenceManager.getDefaultSharedPreferences(this);
        h = (NotificationManager) getSystemService("notification");
        f = (ClipboardManager) getSystemService("clipboard");
        g = (KeyguardManager) getSystemService("keyguard");
        d = (WindowManager) getSystemService("window");
        DisplayManager displayManager = (DisplayManager) getSystemService("display");
        e = displayManager;
        displayManager.registerDisplayListener(new a(), null);
        if (Build.VERSION.SDK_INT >= 26) {
            h.createNotificationChannel(new NotificationChannel("general", getString(2131296356), 3));
            for (int i2 = 1; i2 <= 4; i2++) {
                h.createNotificationChannel(new NotificationChannel("user" + i2, getString(2131296577) + i2, 3));
            }
        }
        j = (CameraManager) getSystemService("camera");
        i = (MediaSessionManager) getSystemService("media_session");
        if (j != null && Build.VERSION.SDK_INT > 22) {
            j.registerTorchCallback(new b(this), (Handler) null);
        }
        H();
        G();
        t();
        I();
        E = me.i38.gesture.o0.h.d(this);
        
        // Set premium status at startup
        e(2);
        Log.d("gesturelog", "Premium features enabled for all users");
    }
}
