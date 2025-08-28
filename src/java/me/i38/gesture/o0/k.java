package me.i38.gesture.o0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static int f281a;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f282b = "0123456789ABCDEF".toCharArray();

    public static int a(Object obj) {
        return a(obj, 0);
    }

    public static int a(Object obj, int i) {
        try {
            return Integer.parseInt(obj.toString().trim());
        } catch (Exception unused) {
            return i;
        }
    }

    public static int a(int... iArr) {
        int i = iArr[0];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static String a(Object obj, String str) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String a(String str, String str2, int i) {
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            if (matcher.find()) {
                return matcher.group(i);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str, String str2, int i, int i2) {
        if (a(str) || a(str2) || i < 0) {
            return "";
        }
        String[] split = str.split(str2, i2);
        return split.length > i ? split[i] : "";
    }

    public static String a(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : strArr) {
            if (!a(str2)) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(str2);
                z = false;
            }
        }
        return sb.toString();
    }

    public static String a(byte[] bArr, int i, int i2) {
        if (bArr == null || i + i2 > bArr.length || i < 0 || i2 < 0) {
            return null;
        }
        char[] cArr = new char[i2 * 2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & 255;
            int i5 = i3 * 2;
            char[] cArr2 = f282b;
            cArr[i5] = cArr2[i4 >>> 4];
            cArr[i5 + 1] = cArr2[i4 & 15];
        }
        return new String(cArr);
    }

    public static String a(String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (!a(strArr[i])) {
                return strArr[i];
            }
        }
        return "";
    }

    public static <T> List<T> a(List<T> list) {
        return list == null ? new ArrayList() : list;
    }

    public static <T> List<T> a(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public static <T> boolean a(T t, T... tArr) {
        if (t != null) {
            for (T t2 : tArr) {
                if (t.equals(t2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(String str, int i, int i2) {
        return ("=".equals(str) && i == i2) || (">".equals(str) && i > i2) || (("<".equals(str) && i < i2) || ((">=".equals(str) && i >= i2) || ("<=".equals(str) && i <= i2)));
    }

    public static boolean a(String str, String str2) {
        if (a(str)) {
            return a(str2) || str2.equals("^") || str2.equals("!");
        } else if (a(str2)) {
            return true;
        } else {
            return str2.startsWith("!") ? !a(a(str, str2.substring(1), 0)) : str2.startsWith("^") ? str.equals(str2.substring(1)) : str.contains(str2);
        }
    }

    public static boolean a(String str, boolean z) {
        if (a(str.toLowerCase(), "1", "on")) {
            return true;
        }
        if (a(str.toLowerCase(), "0", "off")) {
            return false;
        }
        return !z;
    }

    public static String b(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        return str == null ? "" : str;
    }

    public static String b(String str, String str2, int i) {
        return a(str, str2, i, 0);
    }

    public static Map<String, Object> b(Object... objArr) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < objArr.length / 2; i++) {
            int i2 = i * 2;
            hashMap.put(objArr[i2].toString(), objArr[i2 + 1]);
        }
        return hashMap;
    }

    public static boolean b(String str, String str2) {
        if (str != null) {
            if (!str.equals(str2)) {
                if (str.startsWith(str2 + ":")) {
                }
            }
            return true;
        }
        return false;
    }

    public static <T> T c(T... tArr) {
        for (T t : tArr) {
            if (t != null) {
                return t;
            }
        }
        return null;
    }
}
