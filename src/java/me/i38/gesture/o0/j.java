package me.i38.gesture.o0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f280a = {"true", "t", "y", "on", "1"};

    public static float a(Object obj, float f) {
        try {
            return Float.parseFloat(a(obj.toString()));
        } catch (Exception unused) {
            return f;
        }
    }

    public static int a(Object obj, int i) {
        try {
            return Integer.parseInt(a(obj.toString()));
        } catch (Exception unused) {
            return i;
        }
    }

    public static long a(Object obj, long j) {
        try {
            return Long.parseLong(a(obj.toString()));
        } catch (Exception unused) {
            return j;
        }
    }

    public static <T> T a(Map map, String str, T t) {
        if (map.get(str) == null && t != null) {
            map.put(str, t);
        }
        return (T) map.get(str);
    }

    public static String a(Object obj, String str) {
        if (obj != null) {
            try {
                return obj.toString().trim();
            } catch (Exception unused) {
            }
        }
        return str;
    }

    private static String a(String str) {
        return str != null ? str.trim() : str;
    }

    public static boolean a(Object obj) {
        return b(obj, false);
    }

    public static boolean a(Object obj, boolean z) {
        if (obj != null) {
            try {
                String trim = obj.toString().trim();
                if (!trim.equalsIgnoreCase(f280a[0]) && !trim.equalsIgnoreCase(f280a[1]) && !trim.equalsIgnoreCase(f280a[2]) && !trim.equalsIgnoreCase(f280a[3])) {
                    if (!trim.equalsIgnoreCase(f280a[4])) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return z;
    }

    public static float b(Object obj, float f) {
        return a(obj, f);
    }

    public static int b(Object obj) {
        return b(obj, 0);
    }

    public static int b(Object obj, int i) {
        return a(obj, i);
    }

    public static long b(Object obj, long j) {
        return a(obj, j);
    }

    public static String b(Object obj, String str) {
        return a(obj, str);
    }

    public static boolean b(Object obj, boolean z) {
        return a(obj, z);
    }

    public static List c(Object obj) {
        return obj instanceof List ? (List) obj : new ArrayList();
    }

    public static List<Map> d(Object obj) {
        return c(obj);
    }

    public static long e(Object obj) {
        return b(obj, 0L);
    }

    public static Map<String, Object> f(Object obj) {
        return obj instanceof Map ? (Map) obj : new HashMap();
    }

    public static String g(Object obj) {
        return b(obj, "");
    }
}
