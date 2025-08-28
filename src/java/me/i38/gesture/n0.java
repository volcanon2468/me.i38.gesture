package me.i38.gesture;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Path;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class n0 extends AccessibilityService implements SensorEventListener, InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private boolean f258a = true;

    /* renamed from: b  reason: collision with root package name */
    private Vibrator f259b = null;
    private BroadcastReceiver c = null;
    private AudioManager d = null;
    private PowerManager e = null;
    private SharedPreferences f = null;
    private ActivityManager g = null;
    private UsageStatsManager h = null;
    private Handler i = null;
    private String j = "";
    private boolean k = false;
    private boolean[] l = new boolean[4];
    private float[] m = new float[4];
    private boolean n = false;
    private boolean o = false;
    private int p = 0;
    private long q = 0;
    private int r = 0;
    private long s = 0;
    private Map<Integer, Long> t = new HashMap();
    private Map<Integer, Boolean> u = new HashMap();
    private long v = 0;
    private long w = 297;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!action.equals("android.intent.action.SCREEN_OFF")) {
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    GestureApplication.a((InvocationHandler) null, (Handler) null);
                    n0.this.a(GestureApplication.l(), true);
                    return;
                }
                return;
            }
            n0 n0Var = n0.this;
            GestureApplication.a(n0Var, n0Var.i);
            l0.v().a();
            if (!n0.this.f.getBoolean("force_touch_prt", false)) {
                l0.v().g();
            }
            n0.this.a(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f261a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f262b;
        final /* synthetic */ String c;

        b(int i, String str, String str2) {
            this.f261a = i;
            this.f262b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis() - me.i38.gesture.o0.j.e(n0.this.t.get(Integer.valueOf(this.f261a)));
            if (me.i38.gesture.o0.j.a(n0.this.u.get(Integer.valueOf(this.f261a)))) {
                return;
            }
            if (this.f262b == null || currentTimeMillis >= 300) {
                n0.this.a(this.f261a, this.c, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f263a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f264b;
        final /* synthetic */ String c;

        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (me.i38.gesture.o0.j.a(n0.this.u.get(Integer.valueOf(c.this.f263a)))) {
                    c cVar = c.this;
                    n0.this.a(cVar.f263a, (String) null, 2);
                    n0.this.i.postDelayed(this, 50L);
                }
            }
        }

        c(int i, String str, String str2) {
            this.f263a = i;
            this.f264b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis() - me.i38.gesture.o0.j.e(n0.this.t.get(Integer.valueOf(this.f263a)));
            if (!me.i38.gesture.o0.j.a(n0.this.u.get(Integer.valueOf(this.f263a))) || currentTimeMillis < 500) {
                return;
            }
            n0.this.a(this.f263a, this.f264b, 0);
            if (this.f264b == null && this.c == null) {
                n0.this.i.postDelayed(new a(), 50L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class d extends AccessibilityService.GestureResultCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GestureDescription.StrokeDescription f266a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f267b;
        final /* synthetic */ int c;

        d(GestureDescription.StrokeDescription strokeDescription, int i, int i2) {
            this.f266a = strokeDescription;
            this.f267b = i;
            this.c = i2;
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
            n0 n0Var = n0.this;
            GestureDescription.Builder builder = new GestureDescription.Builder();
            GestureDescription.StrokeDescription strokeDescription = this.f266a;
            n0 n0Var2 = n0.this;
            int i = this.f267b;
            int i2 = this.c;
            n0Var.dispatchGesture(builder.addStroke(strokeDescription.continueStroke(n0Var2.a(i / 2, i2 - 10, i / 2, i2 - 20), 0L, 800L, false)).build(), null, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00fd, code lost:
        if (r24.r == 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0152, code lost:
        if (r24.r == 3) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(long r25, float r27, float r28, float r29) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: me.i38.gesture.n0.a(long, float, float, float):int");
    }

    private Path a(int i, int i2) {
        return a(i, i2, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Path a(int i, int i2, int i3, int i4) {
        Path path = new Path();
        path.moveTo(i, i2);
        if (i3 >= 0 && i4 >= 0) {
            path.lineTo(i3, i4);
        }
        return path;
    }

    private Path a(String str, float f) {
        DisplayMetrics m = GestureApplication.m();
        int i = m.widthPixels;
        int i2 = m.heightPixels;
        float f2 = f / 2.0f;
        float f3 = 0.5f - f2;
        float f4 = f2 + 0.5f;
        if ("g".equals(str)) {
            int i3 = i / 2;
            float f5 = i2;
            return a(i3, (int) (f4 * f5), i3, (int) (f5 * f3));
        } else if ("h".equals(str)) {
            int i4 = i / 2;
            float f6 = i2;
            return a(i4, (int) (f3 * f6), i4, (int) (f6 * f4));
        } else if ("i".equals(str)) {
            float f7 = i;
            int i5 = i2 / 2;
            return a((int) (f4 * f7), i5, (int) (f7 * f3), i5);
        } else if ("j".equals(str)) {
            float f8 = i;
            int i6 = i2 / 2;
            return a((int) (f3 * f8), i6, (int) (f8 * f4), i6);
        } else {
            return null;
        }
    }

    private AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
        if (accessibilityNodeInfo != null) {
            ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList();
            arrayList.add(accessibilityNodeInfo);
            AccessibilityNodeInfo accessibilityNodeInfo2 = null;
            int i3 = 0;
            int i4 = 0;
            while (i3 < 100) {
                ArrayList arrayList2 = new ArrayList();
                for (AccessibilityNodeInfo accessibilityNodeInfo3 : arrayList) {
                    for (int i5 = 0; i5 < accessibilityNodeInfo3.getChildCount(); i5++) {
                        if (accessibilityNodeInfo3.getChild(i5) != null) {
                            arrayList2.add(accessibilityNodeInfo3.getChild(i5));
                        }
                    }
                    Rect rect = new Rect();
                    accessibilityNodeInfo3.getBoundsInScreen(rect);
                    if (me.i38.gesture.o0.k.f281a > 0) {
                        a("nodeFind " + i + "," + i2 + "," + rect.contains(i, i2), accessibilityNodeInfo3);
                    }
                    if (rect.contains(i, i2) && (accessibilityNodeInfo2 == null || rect.width() * rect.height() <= i4)) {
                        if (me.i38.gesture.o0.k.f281a > 0) {
                            Log.d("gesturelog", "found.............................");
                        }
                        a(accessibilityNodeInfo2, (AccessibilityNodeInfo) null);
                        i4 = rect.width() * rect.height();
                        accessibilityNodeInfo2 = accessibilityNodeInfo3;
                    }
                    a(accessibilityNodeInfo3, accessibilityNodeInfo2);
                }
                i3++;
                arrayList = arrayList2;
            }
            return accessibilityNodeInfo2;
        }
        return null;
    }

    private AccessibilityNodeInfo a(String str, AccessibilityNodeInfo accessibilityNodeInfo, String str2, String str3) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null) {
            if (me.i38.gesture.o0.k.f281a > 0) {
                Log.d("gesturelog", "search... " + str2 + "," + str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                boolean z = true;
                if (str2.startsWith("^") || str2.startsWith("!")) {
                    ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList();
                    arrayList.add(accessibilityNodeInfo);
                    for (int i = 0; i < 100; i++) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) it.next();
                            if (me.i38.gesture.o0.k.f281a > 1) {
                                a("child[" + i + "]", accessibilityNodeInfo3);
                            }
                            String viewIdResourceName = accessibilityNodeInfo3.getViewIdResourceName();
                            String substring = (viewIdResourceName == null || !viewIdResourceName.contains("/")) ? viewIdResourceName : viewIdResourceName.substring(viewIdResourceName.indexOf("/") + 1);
                            if (me.i38.gesture.o0.k.a(me.i38.gesture.o0.k.b(accessibilityNodeInfo3.getText()), str2) || me.i38.gesture.o0.k.a(me.i38.gesture.o0.k.b(accessibilityNodeInfo3.getContentDescription()), str2) || me.i38.gesture.o0.k.a(viewIdResourceName, str2) || me.i38.gesture.o0.k.a(substring, str2)) {
                                if (a(accessibilityNodeInfo3, i, str3)) {
                                    accessibilityNodeInfo2 = accessibilityNodeInfo3;
                                    break;
                                }
                            }
                        }
                        if (accessibilityNodeInfo2 != null || arrayList.size() == 0) {
                            for (AccessibilityNodeInfo accessibilityNodeInfo4 : arrayList) {
                                a(accessibilityNodeInfo4, accessibilityNodeInfo2);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (AccessibilityNodeInfo accessibilityNodeInfo5 : arrayList) {
                                for (int i2 = 0; i2 < accessibilityNodeInfo5.getChildCount(); i2++) {
                                    if (accessibilityNodeInfo5.getChild(i2) != null) {
                                        arrayList2.add(accessibilityNodeInfo5.getChild(i2));
                                    }
                                }
                                a(accessibilityNodeInfo5, accessibilityNodeInfo2);
                            }
                            arrayList.clear();
                            arrayList.addAll(arrayList2);
                            if (me.i38.gesture.o0.k.f281a > 1) {
                                Log.d("gesturelog", "expand " + arrayList.size());
                            }
                        }
                    }
                } else {
                    if (str2.startsWith("#")) {
                        findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str2.contains("/") ? str2.substring(1) : str + ":id/" + str2.substring(1));
                    } else {
                        findAccessibilityNodeInfosByText = str2.startsWith("~") ? accessibilityNodeInfo.findAccessibilityNodeInfosByText(str2.substring(1)) : accessibilityNodeInfo.findAccessibilityNodeInfosByText(str2);
                    }
                    z = (str2.startsWith("#") || str2.startsWith("~")) ? false : false;
                    if (me.i38.gesture.o0.k.f281a > 0) {
                        Log.d("gesturelog", "result " + findAccessibilityNodeInfosByText.size());
                    }
                    for (int i3 = 0; i3 < findAccessibilityNodeInfosByText.size(); i3++) {
                        AccessibilityNodeInfo accessibilityNodeInfo6 = findAccessibilityNodeInfosByText.get(i3);
                        String a2 = me.i38.gesture.o0.k.a(accessibilityNodeInfo6.getText(), me.i38.gesture.o0.k.b(accessibilityNodeInfo6.getContentDescription()));
                        if (me.i38.gesture.o0.k.f281a > 0) {
                            a("check[" + i3 + "]", accessibilityNodeInfo6);
                        }
                        if (accessibilityNodeInfo2 == null && ((!z || str2.equals(a2)) && a(accessibilityNodeInfo6, i3, str3))) {
                            accessibilityNodeInfo2 = accessibilityNodeInfo6;
                        }
                        a(accessibilityNodeInfo6, accessibilityNodeInfo2);
                    }
                }
            }
            a(accessibilityNodeInfo, accessibilityNodeInfo2);
        }
        if (me.i38.gesture.o0.k.f281a > 0) {
            a("sarch result", accessibilityNodeInfo2);
        }
        return accessibilityNodeInfo2;
    }

    private String a(long j, int i) {
        int i2;
        int i3 = this.p;
        if (i == 0) {
            if (i3 != 0 && j - this.q > this.w) {
                this.p = 0;
                i = i3;
            }
            i2 = 1;
        } else {
            if (i == i3) {
                i2 = 2;
                this.p = 0;
            } else {
                if (this.l[b(i)]) {
                    this.p = i;
                    i = 0;
                }
                i2 = 1;
            }
            this.q = j;
        }
        if (i != 0) {
            int b2 = b(i);
            for (Map map : me.i38.gesture.o0.j.d(GestureApplication.o.get("gestures"))) {
                String b3 = me.i38.gesture.o0.j.b(map.get("action"), "0");
                int b4 = me.i38.gesture.o0.j.b(map.get("axis"), 1);
                int b5 = me.i38.gesture.o0.j.b(map.get("dir"), 0);
                int b6 = me.i38.gesture.o0.j.b(map.get("count"), 1);
                if (b4 == b2 && b6 == i2 && (b5 == 0 || b5 == c(i))) {
                    return b3;
                }
            }
            return "";
        }
        return "";
    }

    private String a(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getParcelableData() instanceof Notification) {
            Notification notification = (Notification) accessibilityEvent.getParcelableData();
            return me.i38.gesture.o0.k.a((Object) notification.extras.getString("android.title"), "") + me.i38.gesture.o0.k.a((Object) notification.extras.getString("android.text"), "");
        }
        return TextUtils.join("", me.i38.gesture.o0.k.a((List) accessibilityEvent.getText()));
    }

    private void a(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo == accessibilityNodeInfo2) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:219:0x04a6, code lost:
        if (r0 == 1) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x04a8, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x04aa, code lost:
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0524, code lost:
        if (r0 == 0) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x05b0, code lost:
        if (me.i38.gesture.l0.v().l() != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x05b2, code lost:
        r1 = getString(2131296560);
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x05b7, code lost:
        r1 = getString(2131296559);
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x05e4, code lost:
        if (me.i38.gesture.l0.v().n() != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x0945, code lost:
        if (me.i38.gesture.o0.k.a(me.i38.gesture.l0.v().h()) == false) goto L255;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x099f  */
    /* JADX WARN: Removed duplicated region for block: B:464:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r19, int r20) {
        /*
            Method dump skipped, instructions count: 2521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: me.i38.gesture.n0.a(java.lang.String, int):void");
    }

    private void a(String str, AccessibilityNodeInfo accessibilityNodeInfo) {
        Log.d("gesturelog", str + ":" + me.i38.gesture.o0.h.a(me.i38.gesture.o0.h.a(accessibilityNodeInfo), ""));
    }

    private void a(Map map, AccessibilityEvent accessibilityEvent, AccessibilityNodeInfo accessibilityNodeInfo) {
        List<Map> d2 = me.i38.gesture.o0.j.d(map.get("H"));
        Map<String, Object> b2 = me.i38.gesture.o0.k.b("time", new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
        if (accessibilityNodeInfo != null) {
            String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            Object[] objArr = new Object[12];
            objArr[0] = "time";
            objArr[1] = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
            objArr[2] = "class";
            objArr[3] = me.i38.gesture.o0.k.a(accessibilityEvent.getClassName(), "");
            objArr[4] = "event";
            objArr[5] = accessibilityEvent.getEventType() + "," + accessibilityEvent.getContentChangeTypes();
            objArr[6] = "id";
            String b3 = me.i38.gesture.o0.k.b(viewIdResourceName);
            objArr[7] = b3.replace(map.get("p") + ":id/", "");
            objArr[8] = "filter";
            StringBuilder sb = new StringBuilder();
            sb.append(accessibilityNodeInfo.isVisibleToUser() ? "v" : "");
            sb.append(accessibilityNodeInfo.isClickable() ? "c" : "");
            sb.append(accessibilityNodeInfo.isEditable() ? "e" : "");
            objArr[9] = sb.toString();
            objArr[10] = "position";
            objArr[11] = rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom;
            b2.putAll(me.i38.gesture.o0.k.b(objArr));
        }
        d2.add(b2);
        if (d2.size() > 5) {
            d2.remove(0);
        }
        map.put("H", d2);
        map.put("L", Long.valueOf(System.currentTimeMillis()));
    }

    private void a(boolean z, String str, boolean z2) {
        String str2;
        int a2 = me.i38.gesture.o0.j.a(GestureApplication.o.get("vibrate"), 10);
        if (z && a2 > 0) {
            if (this.f.getBoolean("system_vibrate", false)) {
                try {
                    l0.v().i().performHapticFeedback(1, 2);
                } catch (Exception unused) {
                }
            } else {
                me.i38.gesture.o0.h.a(this.f259b, a2 * a2);
            }
        }
        if ((me.i38.gesture.o0.j.b(GestureApplication.o.get("toast"), false) || z2) && !TextUtils.isEmpty(str)) {
            Context applicationContext = getApplicationContext();
            StringBuilder sb = new StringBuilder();
            if (this.f258a) {
                str2 = getString(2131296356) + "-";
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(str);
            Toast.makeText(applicationContext, sb.toString(), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        Log.d("gesturelog", "Control" + a() + z);
        Sensor h = GestureApplication.h();
        if (h != null) {
            if (z && !this.n) {
                try {
                    this.n = GestureApplication.s().registerListener(this, h, 2);
                } catch (Exception e) {
                    Log.e("gesturelog", a() + "register sensor error", e);
                }
                GestureApplication.x = false;
            } else if (!z && this.n) {
                try {
                    GestureApplication.s().unregisterListener(this, h);
                } catch (Exception unused) {
                }
                if (z2) {
                    l0.v().e();
                    l0.v().d();
                    l0.v().g();
                    l0.v().a();
                    GestureApplication.w = true;
                }
                this.n = false;
            }
            GestureApplication.a(this);
        }
    }

    private boolean a(int i) {
        AudioManager audioManager;
        int i2;
        if (this.f.getBoolean("volume_ring", false)) {
            audioManager = this.d;
            i2 = 2;
        } else {
            audioManager = this.d;
            i2 = 3;
        }
        audioManager.adjustStreamVolume(i2, i, 1);
        return true;
    }

    private boolean a(int i, int i2, String str, String str2, String str3) {
        Map<Integer, Boolean> map;
        Integer valueOf;
        boolean z;
        boolean postDelayed;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 == 1) {
                map = this.u;
                valueOf = Integer.valueOf(i);
                z = false;
            }
            return z2;
        }
        if (str2 == null && str3 == null && str != null) {
            postDelayed = a(i, str, 0);
        } else {
            long currentTimeMillis2 = System.currentTimeMillis() - me.i38.gesture.o0.j.b(this.t.get(Integer.valueOf(i)), currentTimeMillis);
            if (str2 == null || currentTimeMillis2 <= 0 || currentTimeMillis2 > 300) {
                if (str != null || e(i) != null) {
                    z2 = this.i.postDelayed(new b(i, str2, str), 301L);
                }
                if (str3 != null || d(i) != null) {
                    postDelayed = this.i.postDelayed(new c(i, str3, str), 501L);
                }
                this.t.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                map = this.u;
                valueOf = Integer.valueOf(i);
                z = true;
            } else {
                postDelayed = a(i, str2, 0);
            }
        }
        z2 = postDelayed;
        this.t.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        map = this.u;
        valueOf = Integer.valueOf(i);
        z = true;
        map.put(valueOf, z);
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str, int i2) {
        int i3 = 3;
        try {
            if (i2 > 0 && str == null) {
                str = i2 == 1 ? e(i) : d(i);
                i3 = 4;
            }
            a(str, i3);
        } catch (Exception e) {
            Log.e("gesturelog", "key " + i + " action " + str + " error:", e);
        }
        return true;
    }

    private boolean a(Intent intent, boolean z, int i) {
        intent.addFlags(i | 268435456);
        if (z) {
            PendingIntent.getActivity(this, 0, intent, 1275068416).send();
            return true;
        }
        startActivity(intent);
        return true;
    }

    private boolean a(final Path path, final int i, final int i2, final int i3, final int i4) {
        if (i3 < 1 || i2 <= 0) {
            return false;
        }
        boolean a2 = a(path, 0L, i2);
        if (!a2 || i3 <= 1) {
            return a2;
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: me.i38.gesture.a0
            @Override // java.lang.Runnable
            public final void run() {
                n0.this.a(i3, i4, i, i2, path);
            }
        });
        return a2;
    }

    private boolean a(Path path, long j, long j2) {
        if (Build.VERSION.SDK_INT < 24 || path == null) {
            return false;
        }
        return dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, j, j2)).build(), null, null);
    }

    private boolean a(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        GestureApplication.w = true;
        if (accessibilityNodeInfo.isClickable() && i >= 0) {
            if (me.i38.gesture.o0.k.f281a > 0) {
                Log.d("gesturelog", "self click");
            }
            return accessibilityNodeInfo.performAction(16);
        } else if (Build.VERSION.SDK_INT >= 24 && i <= 0) {
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            int i2 = (rect.left + rect.right) / 2;
            int i3 = (rect.top + rect.bottom) / 2;
            int a2 = GestureApplication.a(25.0f);
            if (me.i38.gesture.o0.k.f281a > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("bound click:");
                sb.append(i2);
                sb.append(",");
                sb.append(i3 > a2 ? i3 : rect.bottom - 1);
                Log.d("gesturelog", sb.toString());
            }
            if (i3 <= a2) {
                i3 = rect.bottom - 1;
            }
            a(a(i2, i3), 0L, 1L);
            return true;
        } else {
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            int i4 = 0;
            while (i4 < i && parent != null) {
                if (parent.isClickable()) {
                    boolean performAction = parent.performAction(16);
                    if (me.i38.gesture.o0.k.f281a > 0) {
                        Log.d("gesturelog", "parent click:" + i4 + "," + performAction);
                    }
                    a(parent, (AccessibilityNodeInfo) null);
                    return performAction;
                }
                AccessibilityNodeInfo parent2 = parent.getParent();
                a(parent, (AccessibilityNodeInfo) null);
                i4++;
                parent = parent2;
            }
            a(parent, (AccessibilityNodeInfo) null);
            if (me.i38.gesture.o0.k.f281a > 0) {
                Log.d("gesturelog", "can not click!");
            }
            return false;
        }
    }

    private boolean a(final AccessibilityNodeInfo accessibilityNodeInfo, final int i, final int i2, final int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        boolean performAction = accessibilityNodeInfo.performAction(i);
        if (performAction) {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: me.i38.gesture.z
                @Override // java.lang.Runnable
                public final void run() {
                    n0.this.a(i2, i3, accessibilityNodeInfo, i);
                }
            });
            return performAction;
        }
        return performAction;
    }

    private boolean a(AccessibilityNodeInfo accessibilityNodeInfo, int i, String str) {
        if (!me.i38.gesture.o0.k.a(str) && accessibilityNodeInfo != null) {
            String[] split = str.split(";");
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            for (String str2 : split) {
                int a2 = me.i38.gesture.o0.k.a(str2.indexOf(">"), str2.indexOf("="), str2.indexOf("<"));
                String trim = a2 >= 0 ? str2.substring(0, a2).trim() : str2.trim();
                String trim2 = a2 >= 0 ? str2.substring(a2, a2 + 1).trim() : "=";
                int a3 = a2 >= 0 ? me.i38.gesture.o0.k.a((Object) str2.substring(a2 + 1)) : 1;
                if ("v".equals(trim) && !me.i38.gesture.o0.k.a(trim2, accessibilityNodeInfo.isVisibleToUser() ? 1 : 0, a3)) {
                    return false;
                }
                if ("c".equals(trim) && !me.i38.gesture.o0.k.a(trim2, accessibilityNodeInfo.isClickable() ? 1 : 0, a3)) {
                    return false;
                }
                if ("l".equals(trim) && !me.i38.gesture.o0.k.a(trim2, accessibilityNodeInfo.isLongClickable() ? 1 : 0, a3)) {
                    return false;
                }
                if ("e".equals(trim) && !me.i38.gesture.o0.k.a(trim2, accessibilityNodeInfo.isEditable() ? 1 : 0, a3)) {
                    return false;
                }
                if ("n".equals(trim) && !me.i38.gesture.o0.k.a(trim2, accessibilityNodeInfo.isEnabled() ? 1 : 0, a3)) {
                    return false;
                }
                if ("k".equals(trim) && !me.i38.gesture.o0.k.a(trim2, accessibilityNodeInfo.isChecked() ? 1 : 0, a3)) {
                    return false;
                }
                if ("f".equals(trim) && !me.i38.gesture.o0.k.a(trim2, accessibilityNodeInfo.isFocused() ? 1 : 0, a3)) {
                    return false;
                }
                if ("s".equals(trim) && !me.i38.gesture.o0.k.a(trim2, i, a3)) {
                    return false;
                }
                if ("w".equals(trim) && !me.i38.gesture.o0.k.a(trim2, rect.width(), a3)) {
                    return false;
                }
                if ("h".equals(trim) && !me.i38.gesture.o0.k.a(trim2, rect.height(), a3)) {
                    return false;
                }
                if ("x".equals(trim) && !me.i38.gesture.o0.k.a(trim2, rect.centerX(), a3)) {
                    return false;
                }
                if ("y".equals(trim) && !me.i38.gesture.o0.k.a(trim2, rect.centerY(), a3)) {
                    return false;
                }
                if ("x1".equals(trim) && !me.i38.gesture.o0.k.a(trim2, rect.left, a3)) {
                    return false;
                }
                if ("x2".equals(trim) && !me.i38.gesture.o0.k.a(trim2, rect.right, a3)) {
                    return false;
                }
                if ("y1".equals(trim) && !me.i38.gesture.o0.k.a(trim2, rect.top, a3)) {
                    return false;
                }
                if ("y2".equals(trim) && !me.i38.gesture.o0.k.a(trim2, rect.bottom, a3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean a(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
        if (str == null || str.split(":").length <= 2) {
            return a(accessibilityNodeInfo, me.i38.gesture.o0.k.a(me.i38.gesture.o0.k.b(str, ":", 1), z ? 0 : 9));
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int a2 = ((rect.left + rect.right) / 2) + me.i38.gesture.o0.k.a((Object) me.i38.gesture.o0.k.b(str, ":", 1));
        int a3 = ((rect.top + rect.bottom) / 2) + me.i38.gesture.o0.k.a((Object) me.i38.gesture.o0.k.b(str, ":", 2));
        long a4 = me.i38.gesture.o0.k.a(me.i38.gesture.o0.k.b(str, ":", 3), 1);
        if (me.i38.gesture.o0.k.f281a > 0) {
            Log.d("gesturelog", "offset click:" + a2 + "," + a3);
        }
        a(a(a2, a3), 0L, a4);
        return true;
    }

    private boolean a(String str) {
        boolean z;
        Path a2;
        int a3 = me.i38.gesture.o0.k.a((Object) this.f.getString("one_hand_mode", ""));
        DisplayMetrics m = GestureApplication.m();
        int i = m.widthPixels;
        int i2 = m.heightPixels;
        try {
            Class.forName("ohos.app.Application");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if ((a3 == 0 && me.i38.gesture.o0.h.e()) || a3 == 1) {
            Intent intent = new Intent("miui.action.handymode.changemode");
            intent.putExtra("mode", str.equals("I") ? 1 : 2);
            sendBroadcast(intent);
            return true;
        }
        if (a3 != 2) {
            if (((a3 == 0 && z) || a3 == 3) && Build.VERSION.SDK_INT >= 26) {
                int i3 = i2 - 10;
                GestureDescription.StrokeDescription strokeDescription = new GestureDescription.StrokeDescription(a(str.equals("I") ? 100 : i - 100, i3, i / 2, i3), 0L, 200L, true);
                return dispatchGesture(new GestureDescription.Builder().addStroke(strokeDescription).build(), new d(strokeDescription, i, i2), null);
            } else if (a3 == 4) {
                if (str.equals("I")) {
                    int i4 = i2 - 1;
                    a2 = a(100, i4, i / 2, i4);
                } else {
                    int i5 = i2 - 1;
                    a2 = a(i - 100, i5, i / 2, i5);
                }
                return a(a2, 15L, 30L);
            } else if ((a3 == 0 && me.i38.gesture.o0.h.c()) || a3 == 5) {
                return a(str.equals("I") ? a(1, i2 - 1, i / 3, (int) (i2 * 0.8d)) : a(i - 1, i2 - 1, (i * 2) / 3, (int) (i2 * 0.8d)), 0L, 100L);
            }
        }
        return false;
    }

    private boolean a(String str, String str2) {
        if (me.i38.gesture.o0.h.d(getApplicationContext(), str)) {
            return a(new Intent("android.intent.action.VIEW", Uri.parse(str2)), true, 0);
        }
        Toast.makeText(getApplicationContext(), 2131296357, 0).show();
        return false;
    }

    private boolean a(String... strArr) {
        if (Build.VERSION.SDK_INT < 24 || strArr.length < 6) {
            return false;
        }
        GestureDescription.Builder builder = new GestureDescription.Builder();
        for (int i = 0; i < (strArr.length - 2) / 4; i++) {
            Path path = new Path();
            int i2 = i * 4;
            path.moveTo(me.i38.gesture.o0.k.a((Object) strArr[i2 + 1]), me.i38.gesture.o0.k.a((Object) strArr[i2 + 2]));
            path.lineTo(me.i38.gesture.o0.k.a((Object) strArr[i2 + 3]), me.i38.gesture.o0.k.a((Object) strArr[i2 + 4]));
            builder.addStroke(new GestureDescription.StrokeDescription(path, 0L, me.i38.gesture.o0.k.a((Object) strArr[strArr.length - 1])));
        }
        return dispatchGesture(builder.build(), null, null);
    }

    private int b(int i) {
        return Math.abs(i);
    }

    @SuppressLint({"NewApi"})
    private boolean b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        boolean a2;
        boolean z;
        int i = 0;
        if (accessibilityNodeInfo != null) {
            String[] split = str.split(":");
            boolean b2 = me.i38.gesture.o0.k.b(str, "G");
            if (b2 || me.i38.gesture.o0.k.b(str, "H")) {
                int id = (b2 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN).getId();
                if (accessibilityNodeInfo.isScrollable() && accessibilityNodeInfo.isVisibleToUser()) {
                    a2 = a(accessibilityNodeInfo, id, split.length >= 2 ? me.i38.gesture.o0.k.a(split[1], 1) : 1, split.length >= 3 ? me.i38.gesture.o0.k.a(split[2], 300) : 300);
                }
                a2 = false;
            } else {
                if (me.i38.gesture.o0.k.b(str, "V") && accessibilityNodeInfo.isEditable()) {
                    Bundle bundle = new Bundle();
                    String charSequence = (accessibilityNodeInfo.getText() == null || accessibilityNodeInfo.isShowingHintText()) ? "" : accessibilityNodeInfo.getText().toString();
                    StringBuilder sb = new StringBuilder();
                    sb.append(charSequence);
                    sb.append(GestureApplication.f(split.length > 1 ? split[1] : ""));
                    bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", sb.toString());
                    a2 = accessibilityNodeInfo.performAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_TEXT.getId(), bundle);
                    if (a2) {
                        a(accessibilityNodeInfo, (AccessibilityNodeInfo) null);
                    }
                }
                a2 = false;
            }
            if (a2) {
                return a2;
            }
            while (true) {
                if (i >= accessibilityNodeInfo.getChildCount()) {
                    z = a2;
                    break;
                } else if (b(accessibilityNodeInfo.getChild(i), str)) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            a(accessibilityNodeInfo, (AccessibilityNodeInfo) null);
            return z;
        }
        return false;
    }

    private int c(int i) {
        return i > 0 ? 1 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        try {
            a(this.f.getBoolean("vibrate_on_robot", true), getString(2131296516), false);
        } finally {
            try {
            } finally {
            }
        }
        if (!me.i38.gesture.o0.k.a(str) && !me.i38.gesture.o0.k.b(str, "k")) {
            a(str, 7);
        }
        a(accessibilityNodeInfo, str, true);
    }

    private String d(int i) {
        if (i == 24) {
            return "o";
        }
        if (i == 25) {
            return "q";
        }
        return null;
    }

    private boolean d(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        try {
        } finally {
            try {
                return true;
            } finally {
            }
        }
        if (!me.i38.gesture.o0.k.b(str, "k") || accessibilityNodeInfo == null) {
            a(str, 6);
            return true;
        }
        return a(accessibilityNodeInfo, str, false);
    }

    private String e() {
        if (Build.VERSION.SDK_INT < 21 || this.h == null) {
            return this.g.getRunningTasks(1).get(0).topActivity.getPackageName();
        }
        long currentTimeMillis = System.currentTimeMillis();
        UsageEvents queryEvents = this.h.queryEvents(currentTimeMillis - 2000, currentTimeMillis);
        while (true) {
            String str = null;
            while (queryEvents.hasNextEvent()) {
                UsageEvents.Event event = new UsageEvents.Event();
                queryEvents.getNextEvent(event);
                if (event.getEventType() != 1) {
                    if (event.getEventType() == 2 && event.getPackageName().equals(str)) {
                        break;
                    }
                } else {
                    str = event.getPackageName();
                }
            }
            return str;
        }
    }

    private String e(int i) {
        if (i == 24) {
            return "o";
        }
        if (i == 25) {
            return "q";
        }
        if (i == 3) {
            return "2";
        }
        if (i == 4) {
            return "1";
        }
        return null;
    }

    private boolean f() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
        if (launchIntentForPackage == null) {
            return false;
        }
        launchIntentForPackage.addFlags(32768);
        launchIntentForPackage.putExtra("LauncherUI.From.Scaner.Shortcut", true);
        return a(launchIntentForPackage, true, 0);
    }

    public static boolean f(int i) {
        return !me.i38.gesture.o0.k.a(Integer.valueOf(i), -1, 4, 3);
    }

    private boolean g(int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - 1;
        this.d.dispatchMediaKeyEvent(new KeyEvent(j, j, 0, i, 0));
        this.d.dispatchMediaKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 1, i, 0));
        return true;
    }

    public String a() {
        return " " + toString() + " ";
    }

    public /* synthetic */ void a(int i, int i2, int i3, int i4, Path path) {
        GestureApplication.w = false;
        for (int i5 = 1; i5 < i; i5++) {
            try {
                Thread.sleep(i2 + i3 + i4);
            } catch (Exception unused) {
            }
            if (GestureApplication.w) {
                return;
            }
            a(path, i3, i4);
        }
    }

    public /* synthetic */ void a(int i, int i2, AccessibilityNodeInfo accessibilityNodeInfo, int i3) {
        GestureApplication.w = false;
        for (int i4 = 1; i4 < i; i4++) {
            try {
                Thread.sleep(i2);
            } catch (Exception unused) {
            }
            if (GestureApplication.w || !accessibilityNodeInfo.performAction(i3)) {
                break;
            }
        }
        a(accessibilityNodeInfo, (AccessibilityNodeInfo) null);
    }

    public void a(n0 n0Var) {
        throw null;
    }

    public /* synthetic */ void b() {
        try {
            performGlobalAction(3);
        } catch (Throwable unused) {
        }
    }

    public void c() {
        Map<String, Object> a2 = me.i38.gesture.o0.h.a(this.f.getString("apps", ""), new HashMap());
        this.k = a2.size() > 1;
        Map map = (Map) a2.get(this.j);
        GestureApplication.o = me.i38.gesture.o0.j.f(a2.get((TextUtils.isEmpty(this.j) || map == null || !me.i38.gesture.o0.j.b(map.get("custom"), true)) ? "default" : this.j));
        List<Map> d2 = me.i38.gesture.o0.j.d(GestureApplication.o.get("gestures"));
        boolean[] zArr = this.l;
        zArr[1] = false;
        zArr[2] = false;
        zArr[3] = false;
        float[] fArr = this.m;
        fArr[1] = 99.9f;
        fArr[2] = 99.9f;
        fArr[3] = 99.9f;
        for (Map map2 : d2) {
            int b2 = me.i38.gesture.o0.j.b(map2.get("axis"), 1);
            if (b2 < 4) {
                if (me.i38.gesture.o0.j.b(map2.get("count"), 1) == 2) {
                    this.l[b2] = true;
                }
                float[] fArr2 = this.m;
                fArr2[b2] = Math.min(fArr2[b2], (float) (((me.i38.gesture.o0.j.b(map2.get("thresh"), 10) / 30.0d) * 5.0d) + 0.9d));
            }
        }
        float[] fArr3 = this.m;
        fArr3[0] = Math.min(fArr3[1], Math.min(fArr3[2], fArr3[3]));
    }

    public void d() {
        boolean l = GestureApplication.l();
        Log.d("gesturelog", "Switch" + a() + l);
        a(GestureApplication.l(), true);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if ("onVolumeKeyLongPress".equals(method.getName()) && objArr != null && objArr.length == 1 && (objArr[0] instanceof KeyEvent) && GestureApplication.l()) {
            KeyEvent keyEvent = (KeyEvent) objArr[0];
            int keyCode = keyEvent.getKeyCode();
            if (keyEvent.getAction() != 0 || this.e.isInteractive()) {
                return null;
            }
            for (Map map : me.i38.gesture.o0.j.d(GestureApplication.o.get("gestures"))) {
                if (me.i38.gesture.o0.k.a(map.get("axis")) == 4 && me.i38.gesture.o0.k.a(map.get("dir")) == keyCode && me.i38.gesture.o0.k.a(map.get("count")) == 4) {
                    a(keyCode, me.i38.gesture.o0.k.a(map.get("action"), "0"), 0);
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        String str;
        final AccessibilityNodeInfo a2;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (GestureApplication.l()) {
                String a3 = me.i38.gesture.o0.k.a(accessibilityEvent.getPackageName(), "undefined pkg");
                String str2 = "s";
                if (accessibilityEvent.getEventType() == 64) {
                    String a4 = a(accessibilityEvent);
                    if (me.i38.gesture.o0.k.f281a > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("notification event[");
                        sb.append(a3);
                        sb.append("][");
                        sb.append((Object) accessibilityEvent.getClassName());
                        sb.append("][data:");
                        sb.append(accessibilityEvent.getParcelableData() != null);
                        sb.append("]:");
                        sb.append(a4);
                        Log.d("gesturelog", sb.toString());
                    }
                    for (Map map : me.i38.gesture.o0.k.a((List) GestureApplication.c(a3))) {
                        if ("notification".equals(me.i38.gesture.o0.k.b(map.get("s"))) && me.i38.gesture.o0.k.a(a4, me.i38.gesture.o0.k.b(map.get("n")))) {
                            GestureApplication.a(a4, accessibilityEvent.getParcelableData());
                            a(map, accessibilityEvent, (AccessibilityNodeInfo) null);
                            GestureApplication.a(me.i38.gesture.o0.k.a(me.i38.gesture.o0.k.b(map.get("a")), "k"), me.i38.gesture.o0.k.a(map.get("o"), "now"));
                        }
                    }
                } else {
                    for (Map map2 : me.i38.gesture.o0.k.a((List) GestureApplication.c(a3))) {
                        String b2 = me.i38.gesture.o0.k.b(map2.get("c"));
                        String b3 = me.i38.gesture.o0.k.b(map2.get("n"));
                        String a5 = me.i38.gesture.o0.k.a(map2.get(str2), "ui");
                        if ((me.i38.gesture.o0.k.a(b2) || b2.equals(accessibilityEvent.getClassName())) && !me.i38.gesture.o0.k.a(b3) && "ui".equals(a5)) {
                            int a6 = me.i38.gesture.o0.k.a(map2.get("t"));
                            str = str2;
                            if (System.currentTimeMillis() - me.i38.gesture.o0.j.e(map2.get("L")) > Math.abs(a6) && (a2 = a(a3, getRootInActiveWindow(), b3, me.i38.gesture.o0.k.b(map2.get("f")))) != null) {
                                GestureApplication.a(me.i38.gesture.o0.k.a(a2.getText(), ""), (Object) null);
                                final String b4 = me.i38.gesture.o0.k.b(map2.get("a"));
                                a(map2, accessibilityEvent, a2);
                                if (a6 < 0) {
                                    this.i.postDelayed(new Runnable() { // from class: me.i38.gesture.b0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            n0.this.a(a2, b4);
                                        }
                                    }, Math.abs(a6));
                                } else {
                                    a(a2, b4);
                                }
                            }
                        } else {
                            str = str2;
                        }
                        str2 = str;
                    }
                }
            }
            if (me.i38.gesture.o0.k.f281a > 1) {
                Log.d("gesturelog", "event " + accessibilityEvent.getEventType() + " [" + (System.currentTimeMillis() - currentTimeMillis) + "ms]");
            }
        } catch (Exception e) {
            Log.e("gesturelog", "event", e);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("gesturelog", a() + "destroy");
        super.onDestroy();
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public boolean onKeyEvent(KeyEvent keyEvent) {
        int action;
        int keyCode;
        String[] strArr;
        boolean a2;
        if (GestureApplication.l()) {
            try {
                action = keyEvent.getAction();
                keyCode = keyEvent.getKeyCode();
                GestureApplication.f(keyCode);
                strArr = new String[3];
            } catch (Exception e) {
                Log.e("gesturelog", "key", e);
            }
            if (f(keyCode)) {
                for (Map map : me.i38.gesture.o0.j.d(GestureApplication.o.get("gestures"))) {
                    int b2 = me.i38.gesture.o0.j.b(map.get("count"));
                    if (me.i38.gesture.o0.j.b(map.get("axis")) == 4 && me.i38.gesture.o0.j.b(map.get("dir")) == keyCode && b2 >= 1 && b2 < 4) {
                        strArr[b2 - 1] = me.i38.gesture.o0.j.b(map.get("action"), "0");
                    }
                }
                if (strArr[0] != null || strArr[1] != null || strArr[2] != null) {
                    a2 = a(keyCode, action, strArr[0], strArr[1], strArr[2]);
                    return !a2 || super.onKeyEvent(keyEvent);
                }
            }
        }
        a2 = false;
        if (a2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r6 > r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e8 A[Catch: Exception -> 0x023b, TryCatch #0 {Exception -> 0x023b, blocks: (B:3:0x0006, B:5:0x000f, B:7:0x0017, B:28:0x0065, B:21:0x004b, B:23:0x0055, B:27:0x005e, B:29:0x006c, B:31:0x007c, B:34:0x008c, B:36:0x00aa, B:37:0x00bd, B:39:0x00c7, B:41:0x00e2, B:43:0x00e8, B:45:0x0118, B:46:0x012e, B:48:0x0134, B:51:0x013d, B:53:0x0161, B:56:0x0167, B:57:0x016b, B:59:0x0175, B:58:0x0170, B:60:0x0179, B:63:0x0181, B:65:0x0187, B:67:0x019b, B:77:0x01bb, B:81:0x01c8, B:83:0x01d2, B:70:0x01a3, B:73:0x01ab, B:75:0x01b1, B:84:0x01d5, B:86:0x01e0, B:88:0x01e8, B:90:0x01ef, B:92:0x01f9, B:94:0x0203, B:96:0x020d, B:98:0x021c, B:97:0x0215, B:99:0x021f, B:101:0x0223, B:103:0x022d, B:105:0x0235), top: B:110:0x0006 }] */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r19) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: me.i38.gesture.n0.onSensorChanged(android.hardware.SensorEvent):void");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
        a(this);
        this.f258a = (me.i38.gesture.o0.h.e() || me.i38.gesture.o0.h.d()) ? false : true;
        this.f259b = (Vibrator) getSystemService("vibrator");
        this.d = (AudioManager) getSystemService("audio");
        this.e = (PowerManager) getSystemService("power");
        this.g = (ActivityManager) getSystemService("activity");
        this.f = PreferenceManager.getDefaultSharedPreferences(this);
        this.i = new Handler();
        if (Build.VERSION.SDK_INT >= 21) {
            this.h = (UsageStatsManager) getSystemService("usagestats");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.c = new a();
        getApplicationContext().registerReceiver(this.c, intentFilter);
        c();
        a(GestureApplication.l(), true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int intExtra;
        if (intent == null || intent.getIntExtra("id", -1) - 200 < 0) {
            return 1;
        }
        String[] strArr = k0.f249a;
        if (intExtra < strArr.length) {
            if (GestureApplication.d(strArr[intExtra])) {
                GestureApplication.a(k0.f249a[intExtra]);
                return 1;
            }
            GestureApplication.h.cancel(intExtra + 200);
            return 1;
        }
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.d("gesturelog", a() + "unbind");
        a((n0) null);
        try {
            try {
                a(false, true);
                getApplicationContext().unregisterReceiver(this.c);
                GestureApplication.a((InvocationHandler) null, (Handler) null);
                return super.onUnbind(intent);
            } catch (Exception e) {
                Log.e("gesturelog", "unbind", e);
                return super.onUnbind(intent);
            }
        } catch (Throwable unused) {
            return super.onUnbind(intent);
        }
    }
}
