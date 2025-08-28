package me.i38.gesture.o0;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.i38.gesture.GestureApplication;
import me.i38.gesture.ServiceMain;
import me.i38.gesture.ServicePlus;
import me.i38.gesture.i0;
import me.i38.gesture.k0;
import me.i38.gesture.n0;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            GestureApplication.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f277a;

        b(Context context) {
            this.f277a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.f277a.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f278a;

        c(Context context) {
            this.f278a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            h.f(this.f278a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f279a;

        d(Context context) {
            this.f279a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            h.g(this.f279a);
        }
    }

    public static int a(Context context) {
        String str = "";
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled") == 1) {
                str = k.b(Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services"));
            }
        } catch (Exception unused) {
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append("/");
        boolean z = str.contains(sb.toString()) && str.contains("ServicePlus");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getPackageName());
        sb2.append("/");
        boolean z2 = str.contains(sb2.toString()) && str.contains("ServiceMain");
        boolean z3 = ServicePlus.x != null;
        boolean z4 = ServiceMain.x != null;
        Log.d("gesturelog", "getAccessibilityState:" + z2 + "," + z4 + "," + z + "," + z3);
        if (z && z2 && z3 && z4) {
            return 3;
        }
        if (z && z3) {
            return 2;
        }
        if (z2 && z4) {
            return 1;
        }
        return (z || z2 || z3 || z4) ? -1 : 0;
    }

    @SuppressLint({"NewApi"})
    public static ActivityOptions a() {
        ActivityOptions makeBasic = ActivityOptions.makeBasic();
        if (c() || b()) {
            ActivityOptions.class.getMethod("setLaunchWindowingMode", Integer.TYPE).invoke(makeBasic, 102);
            ActivityOptions.class.getMethod("setLaunchStackId", Integer.TYPE).invoke(makeBasic, 2);
        } else {
            ActivityOptions.class.getMethod("setLaunchWindowingMode", Integer.TYPE).invoke(makeBasic, 5);
        }
        return makeBasic;
    }

    public static ProgressDialog a(Context context, boolean z, int i) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(z);
        progressDialog.setCanceledOnTouchOutside(z);
        progressDialog.setMessage(context.getString(i));
        return progressDialog;
    }

    public static Intent a(Context context, Class<?> cls, int i, String... strArr) {
        Intent intent = new Intent(context, cls);
        if (i > 0) {
            intent.addFlags(i);
        }
        for (int i2 = 0; i2 < strArr.length / 2; i2++) {
            int i3 = i2 * 2;
            if (!k.a(strArr[i3])) {
                intent.putExtra(strArr[i3], strArr[i3 + 1]);
            }
        }
        return intent;
    }

    public static Intent a(String str) {
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.TITLE", str);
        return intent;
    }

    public static Bundle a(Activity activity) {
        Intent intent = activity.getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        return extras == null ? new Bundle() : extras;
    }

    public static String a(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra(str);
    }

    public static String a(String str, String str2) {
        if (str.length() >= 2) {
            return str + "|" + str2;
        }
        return str;
    }

    public static String a(String str, boolean z, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (z) {
                str = str.toLowerCase();
            }
            String bigInteger = new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0" + bigInteger;
            }
            return bigInteger;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String a(List list, String str) {
        try {
            return new JSONArray((Collection) list).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String a(Map map, String str) {
        try {
            return new JSONObject(map).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static List<i0> a(Context context, boolean z) {
        Set<String> b2 = b(context, z);
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (String str : b2) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                arrayList.add(new i0(str, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager)));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static List<Object> a(String str, List<Object> list) {
        try {
            return a(new JSONArray(str));
        } catch (Exception unused) {
            return list;
        }
    }

    private static List<Object> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, String> a(AccessibilityNodeInfo accessibilityNodeInfo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (accessibilityNodeInfo != null) {
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            String a2 = k.a(k.b(accessibilityNodeInfo.getText()), k.b(accessibilityNodeInfo.getContentDescription()));
            StringBuilder sb = new StringBuilder();
            sb.append(rect.left);
            sb.append(",");
            sb.append(rect.top);
            sb.append(",");
            sb.append(rect.right);
            sb.append(",");
            sb.append(rect.bottom);
            sb.append(",");
            sb.append(accessibilityNodeInfo.isVisibleToUser() ? "v" : "");
            sb.append(accessibilityNodeInfo.isClickable() ? "c" : "");
            sb.append(accessibilityNodeInfo.isLongClickable() ? "l" : "");
            sb.append(accessibilityNodeInfo.isEditable() ? "e" : "");
            sb.append(accessibilityNodeInfo.isEnabled() ? "n" : "");
            sb.append(accessibilityNodeInfo.isChecked() ? "k" : "");
            linkedHashMap.put("props", sb.toString());
            linkedHashMap.put("class", k.a(accessibilityNodeInfo.getClassName(), ""));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            if (a2.length() > 16) {
                a2 = a2.substring(0, 14) + "...";
            }
            sb2.append(a2);
            sb2.append("]");
            linkedHashMap.put("text", sb2.toString());
            linkedHashMap.put("id", "#" + k.a((Object) accessibilityNodeInfo.getViewIdResourceName(), ""));
        }
        return linkedHashMap;
    }

    public static Map<String, Object> a(String str, Map<String, Object> map) {
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return map;
        }
    }

    private static Map<String, Object> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = a((JSONObject) obj);
            } else if (obj == JSONObject.NULL) {
                obj = null;
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static void a(int i, final Context context) {
        new AlertDialog.Builder(context).setTitle(2131296260).setMessage(i).setPositiveButton(2131296421, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.o0.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                h.a(context, dialogInterface, i2);
            }
        }).setNegativeButton(2131296460, (DialogInterface.OnClickListener) null).show();
    }

    public static void a(Context context, int i, Object... objArr) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        new AlertDialog.Builder(context).setMessage(context.getString(i, objArr)).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, DialogInterface dialogInterface, int i) {
        f(context);
        Toast.makeText(GestureApplication.g(), 2131296262, 1).show();
    }

    public static void a(Context context, String str) {
        Log.d("gesturelog", "Call service:" + str);
        a(ServicePlus.x, str);
        a(ServiceMain.x, str);
    }

    public static void a(Context context, String str, String str2) {
        if (context instanceof Activity) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(1, 20.0f);
            EditText editText = new EditText(context);
            editText.setText(str2);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            new AlertDialog.Builder(context).setView(linearLayout).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
        }
    }

    public static void a(Vibrator vibrator, int i) {
        if (vibrator != null) {
            try {
                vibrator.vibrate(new long[]{0, i}, -1);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(n0 n0Var, String str) {
        if (n0Var != null) {
            if ("switch".equals(str)) {
                n0Var.d();
            } else if ("load".equals(str)) {
                n0Var.c();
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a(AccessibilityService accessibilityService) {
        if (Build.VERSION.SDK_INT >= 31) {
            return accessibilityService.performGlobalAction(15);
        }
        accessibilityService.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        return true;
    }

    public static boolean a(String str, final Activity activity) {
        String c2 = c(str);
        String c3 = c(activity, str);
        if (!GestureApplication.w() && ("m".equals(c2) || "f".equals(c2) || "Q".equals(c2) || "R".equals(c2) || "t".equals(c2) || "K".equals(c2))) {
            new AlertDialog.Builder(activity).setMessage(activity.getString(2131296473, new Object[]{c3})).setPositiveButton(2131296421, new a()).show();
            return false;
        } else if (!GestureApplication.A() && ("v".equals(c2) || "w".equals(c2) || "x".equals(c2) || "A".equals(c2) || "B".equals(c2))) {
            new AlertDialog.Builder(activity).setMessage(activity.getString(2131296592, new Object[]{c3})).setPositiveButton(2131296421, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.o0.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    GestureApplication.d();
                }
            }).show();
            return false;
        } else if (!GestureApplication.z() && (k.b(c2, "U") || k.b(c2, "L"))) {
            a(activity, activity.getString(2131296349, new Object[]{c3}), "adb shell pm grant me.i38.gesture android.permission.WRITE_SECURE_SETTINGS");
            return false;
        } else {
            if (!GestureApplication.x() && (Arrays.asList(k0.f249a).contains(str) || k.b(c2, "W"))) {
                activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12);
            } else if (!GestureApplication.u() && (Arrays.asList(k0.f249a).contains(str) || k.b(c2, "W"))) {
                new AlertDialog.Builder(activity).setMessage(activity.getString(2131296463, new Object[]{c3})).setPositiveButton(2131296421, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.o0.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        GestureApplication.b();
                    }
                }).show();
                return false;
            }
            if (Build.VERSION.SDK_INT >= 23 && !GestureApplication.h.isNotificationPolicyAccessGranted() && "J".equals(c2)) {
                new AlertDialog.Builder(activity).setMessage(activity.getString(2131296592, new Object[]{c3})).setPositiveButton(2131296421, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.o0.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        activity.startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
                    }
                }).show();
                return false;
            } else if (a((Context) activity) == 1 && ("m".equals(c2) || "V".equals(c2) || "G".equals(c2) || "H".equals(c2) || "I".equals(c2) || "M".equals(c2) || f(c2) || c2.startsWith("click:") || "robot".equals(c2) || c2.startsWith("ss:") || c2.startsWith("N:") || c2.startsWith("T:"))) {
                new AlertDialog.Builder(activity).setMessage(activity.getString(2131296259, new Object[]{c3})).setPositiveButton(2131296421, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.o0.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        h.f(activity);
                    }
                }).show();
                return false;
            } else if (!GestureApplication.b("android:audio_media_volume") && k.a(c2, "u", "o", "q")) {
                new AlertDialog.Builder(activity).setMessage(activity.getString(2131296445)).setPositiveButton(2131296421, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.o0.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        h.g(activity);
                    }
                }).show();
                return false;
            } else if ((k.a(c2, "c", "b", "d", "android-app://com.tencent.mm/#Intent;action=com.tencent.mm.action.BIZSHORTCUT;launchFlags=0x4000000;S.LauncherUI.Shortcut.LaunchType=launch_type_offline_wallet;end", "y") || c2.length() > 2) && !GestureApplication.b(10021)) {
                new AlertDialog.Builder(activity).setMessage(activity.getString(2131296443)).setPositiveButton(2131296421, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.o0.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        h.g(activity);
                    }
                }).show();
                return false;
            } else {
                return true;
            }
        }
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 2131034114;
        }
        String str2 = str.split("\\|")[0];
        if (str2.equals("p") || str2.equals("s")) {
            return 2131034167;
        }
        if (str2.equals("b") || str2.equals("c")) {
            return 2131034113;
        }
        if (str2.equals("d") || str2.equals("P")) {
            return 2131034165;
        }
        if (k.a(str2, "IM", "IA", "IP", "IS", "IC", "ID")) {
            return 2131034127;
        }
        if (str2.equals("0")) {
            return 2131034141;
        }
        if (str2.equals("1")) {
            return 2131034117;
        }
        if (str2.equals("2")) {
            return 2131034130;
        }
        if (str2.equals("3")) {
            return 2131034149;
        }
        if (k.a(str2, "4", "C") || k.b(str2, "W")) {
            return 2131034142;
        }
        if (str2.equals("5")) {
            return 2131034148;
        }
        if (k.b(str2, "D")) {
            return 2131034166;
        }
        if (str2.equals("O")) {
            return 2131034169;
        }
        if (k.b(str2, "E")) {
            return 2131034118;
        }
        if (k.b(str2, "U")) {
            return 2131034133;
        }
        if (k.b(str2, "L")) {
            return 2131034140;
        }
        if (k.b(str2, "F")) {
            return 2131034126;
        }
        if (str2.equals("6")) {
            return 2131034132;
        }
        if (str2.equals("7")) {
            return 2131034146;
        }
        if (str2.equals("8")) {
            return 2131034116;
        }
        if (str2.equals("9")) {
            return 2131034157;
        }
        if (str2.equals("l")) {
            return 2131034134;
        }
        if (str2.equals("e")) {
            return 2131034154;
        }
        if (k.b(str2, "f")) {
            return 2131034144;
        }
        if (str2.equals("a")) {
            return 2131034145;
        }
        if (str2.equals("n")) {
            return 2131034139;
        }
        if (str2.equals("r")) {
            return 2131034147;
        }
        if (k.b(str2, "m")) {
            return 2131034136;
        }
        if (str2.equals("I") || str2.equals("M")) {
            return 2131034143;
        }
        if (k.b(str2, "N")) {
            return 2131034158;
        }
        if (k.b(str2, "T")) {
            return 2131034137;
        }
        if (f(str2)) {
            String substring = str2.substring(0, 1);
            if (substring.equals("g")) {
                return 2131034162;
            }
            if (substring.equals("h")) {
                return 2131034159;
            }
            return substring.equals("i") ? 2131034160 : 2131034161;
        } else if (k.b(str2, "G")) {
            return 2131034156;
        } else {
            if (k.b(str2, "H")) {
                return 2131034155;
            }
            if (k.b(str2, "V")) {
                return 2131034125;
            }
            if (str2.startsWith("click:") || k.b(str2, "k")) {
                return 2131034122;
            }
            if (str2.equals("o")) {
                return 2131034164;
            }
            if (str2.equals("u")) {
                return 2131034177;
            }
            if (str2.equals("S")) {
                return 2131034176;
            }
            if (str2.equals("q")) {
                return 2131034163;
            }
            if (str2.equals("J")) {
                return 2131034150;
            }
            if (k.b(str2, "Y")) {
                return 2131034138;
            }
            if (str2.equals("v")) {
                return 2131034121;
            }
            if (str2.equals("w")) {
                return 2131034120;
            }
            if (str2.equals("x")) {
                return 2131034119;
            }
            if (str2.equals("Q")) {
                return 2131034115;
            }
            if (str2.equals("R")) {
                return 2131034175;
            }
            if (str2.equals("y")) {
                return 2131034131;
            }
            if (k.b(str2, "X")) {
                return 2131034123;
            }
            if (str2.equals("A")) {
                return 2131034151;
            }
            if (str2.equals("B")) {
                return 2131034152;
            }
            if (str2.equals("t")) {
                return 2131034128;
            }
            if (str2.equals("K")) {
                return 2131034129;
            }
            return k.b(str2, "re") ? 2131034114 : -1;
        }
    }

    public static Intent b(String str, String str2) {
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str2);
        return intent;
    }

    public static Drawable b(Context context, String str) {
        Resources resources = context.getResources();
        int b2 = b(str);
        if (b2 == -1) {
            try {
                return context.getPackageManager().getApplicationIcon(k.a(str, "[A-Za-z0-9_]+\\.[A-Za-z0-9_.]+", 0));
            } catch (Exception unused) {
                return resources.getDrawable(2131034114);
            }
        }
        return resources.getDrawable(b2);
    }

    public static List<Map> b(String str, List<Map> list) {
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : a(str, new ArrayList())) {
                if (obj instanceof Map) {
                    arrayList.add((Map) obj);
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return list;
        }
    }

    private static Set<String> b(Context context) {
        HashSet hashSet = new HashSet();
        for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(128)) {
            if (!TextUtils.isEmpty(applicationInfo.packageName)) {
                hashSet.add(applicationInfo.packageName);
            }
        }
        return hashSet;
    }

    public static Set<String> b(Context context, boolean z) {
        ActivityInfo activityInfo;
        HashSet hashSet = new HashSet();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            ActivityInfo activityInfo2 = resolveInfo.activityInfo;
            if (activityInfo2 != null) {
                String str = activityInfo2.packageName;
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
        }
        if (z) {
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent2, 65536);
            if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null) {
                String str2 = activityInfo.packageName;
                if (!TextUtils.isEmpty(str2) && !hashSet.contains(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    public static boolean b() {
        return "Honor".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean b(int i, Context context) {
        if (i >= 4 && a(context) == 1) {
            new AlertDialog.Builder(context).setMessage(context.getString(2131296259, context.getString(2131296432))).setPositiveButton(2131296421, new c(context)).show();
            return false;
        } else if (i == 4 && !GestureApplication.b("android:audio_media_volume")) {
            new AlertDialog.Builder(context).setMessage(context.getString(2131296445)).setPositiveButton(2131296421, new d(context)).show();
            return false;
        } else if (i >= 4 || GestureApplication.D()) {
            return true;
        } else {
            a(context, 2131296422, new Object[0]);
            return false;
        }
    }

    public static String c(Context context, String str) {
        try {
            String[] split = str.split("\\|");
            if (split.length > 1) {
                return split[1];
            }
            Resources resources = context.getResources();
            return context.getResources().getString(resources.getIdentifier("action_" + k.b(split[0], ":", 0), "string", context.getPackageName()));
        } catch (Exception unused) {
            if (str == null) {
                return "";
            }
            if (str.length() > 5) {
                return str.substring(0, 5) + "...";
            }
            return str;
        }
    }

    public static String c(String str) {
        return str.split("\\|")[0];
    }

    public static List<i0> c(Context context) {
        Set<String> b2 = b(context);
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (String str : b2) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                arrayList.add(new i0(str, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager)));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static void c(int i, Context context) {
        new AlertDialog.Builder(context).setMessage(i).setPositiveButton(2131296421, new b(context)).show();
    }

    public static void c(Context context, boolean z) {
        List<ActivityManager.AppTask> appTasks;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || Build.VERSION.SDK_INT < 21 || (appTasks = activityManager.getAppTasks()) == null || appTasks.size() <= 0) {
            return;
        }
        appTasks.get(0).setExcludeFromRecents(z);
    }

    public static boolean c() {
        return "Huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static Intent d(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        return intent;
    }

    public static synchronized String d(Context context) {
        String str;
        synchronized (h.class) {
            if (f276a == null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                long j = memoryInfo.totalMem / 1073741824;
                StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                long blockCountLong = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1073741824;
                int i = 1;
                while (i < blockCountLong && i < 1048576) {
                    i *= 2;
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
                int max = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
                int min = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
                StringBuilder sb = new StringBuilder();
                sb.append("g");
                sb.append(a(Build.BOARD, true, "x").substring(0, 1));
                sb.append(a(Build.MANUFACTURER, true, "x").substring(0, 1));
                sb.append(a(Build.MODEL, true, "x").substring(0, 1));
                sb.append(a(min == 0 ? "x" : String.format("%.2f", Double.valueOf((max * 1.0d) / min)), false, "x").substring(0, 1));
                sb.append(a("" + j, false, "x").substring(0, 1));
                sb.append(a("" + i, false, "x").substring(0, 1));
                f276a = sb.toString();
            }
            str = f276a;
        }
        return str;
    }

    public static boolean d() {
        return "Vivo".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean d(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Intent e(String str) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        return intent;
    }

    public static boolean e() {
        return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean e(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels <= displayMetrics.heightPixels;
    }

    public static void f(Context context) {
        context.startActivity(e("android.settings.ACCESSIBILITY_SETTINGS"));
    }

    public static boolean f(String str) {
        return k.b(str, "g") || k.b(str, "h") || k.b(str, "i") || k.b(str, "j");
    }

    public static void g(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
    }
}
