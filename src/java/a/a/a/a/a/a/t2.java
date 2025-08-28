package a.a.a.a.a.a;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class t2 {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f81a;

    /* renamed from: b  reason: collision with root package name */
    private static final j3 f82b;
    private static final j3 c;
    private static final j3 d;
    public static final /* synthetic */ int e = 0;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f81a = cls;
        f82b = a(false);
        c = a(true);
        d = new l3();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, Object obj, r2 r2Var) {
        if (!(obj instanceof m1)) {
            return k0.e(i << 3) + k0.a((h2) obj, r2Var);
        }
        int i2 = k0.d;
        int a2 = ((m1) obj).a();
        return k0.e(i << 3) + k0.e(a2) + a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = size * k0.e(i << 3);
        for (int i2 = 0; i2 < list.size(); i2++) {
            int b2 = ((c0) list.get(i2)).b();
            e2 += k0.e(b2) + b2;
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List list, r2 r2Var) {
        int size = list.size();
        if (size != 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i2 += k0.a(i, (h2) list.get(i3), r2Var);
            }
            return i2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (k0.e(i << 3) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f1) {
            f1 f1Var = (f1) list;
            i = 0;
            while (i2 < size) {
                i += k0.d(f1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += k0.d(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static j3 a() {
        return d;
    }

    private static j3 a(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (j3) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, int i, int i2, Object obj2, j3 j3Var) {
        if (obj2 == null) {
            obj2 = j3Var.c(obj);
        }
        j3Var.a(obj2, i, i2);
        return obj2;
    }

    public static void a(int i, List list, b4 b4Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.b(i, list);
    }

    public static void a(int i, List list, b4 b4Var, r2 r2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((l0) b4Var).b(i, list.get(i2), r2Var);
        }
    }

    public static void a(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.d(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j3 j3Var, Object obj, Object obj2) {
        j3Var.b(obj, j3Var.a(j3Var.d(obj), j3Var.d(obj2)));
    }

    public static void a(Class cls) {
        Class cls2;
        if (!e1.class.isAssignableFrom(cls) && (cls2 = f81a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int i3 = k0.d;
        boolean z = list instanceof o1;
        int e2 = k0.e(i << 3) * size;
        if (z) {
            o1 o1Var = (o1) list;
            while (i2 < size) {
                Object b2 = o1Var.b(i2);
                if (b2 instanceof c0) {
                    int b3 = ((c0) b2).b();
                    e2 += k0.e(b3) + b3;
                } else {
                    e2 += k0.a((String) b2);
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof c0) {
                    int b4 = ((c0) obj).b();
                    e2 += k0.e(b4) + b4;
                } else {
                    e2 += k0.a((String) obj);
                }
                i2++;
            }
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List list, r2 r2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = k0.e(i << 3) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof m1) {
                int a2 = ((m1) obj).a();
                e2 += k0.e(a2) + a2;
            } else {
                e2 += k0.a((h2) obj, r2Var);
            }
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return a(list) + (size * k0.e(i << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List list) {
        return list.size() * 4;
    }

    public static j3 b() {
        return f82b;
    }

    public static void b(int i, List list, b4 b4Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.a(i, list);
    }

    public static void b(int i, List list, b4 b4Var, r2 r2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((l0) b4Var).a(i, list.get(i2), r2Var);
        }
    }

    public static void b(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.k(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (k0.e(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List list) {
        return list.size() * 8;
    }

    public static j3 c() {
        return c;
    }

    public static void c(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.m(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (k0.e(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f1) {
            f1 f1Var = (f1) list;
            i = 0;
            while (i2 < size) {
                i += k0.d(f1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += k0.d(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void d(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.c(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * k0.e(i << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v1) {
            v1 v1Var = (v1) list;
            i = 0;
            while (i2 < size) {
                i += k0.c(v1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += k0.c(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void e(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.h(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return e(list) + (list.size() * k0.e(i << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f1) {
            f1 f1Var = (f1) list;
            i = 0;
            while (i2 < size) {
                int c2 = f1Var.c(i2);
                i += k0.e((c2 >> 31) ^ (c2 + c2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += k0.e((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    public static void f(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.j(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * k0.e(i << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v1) {
            v1 v1Var = (v1) list;
            i = 0;
            while (i2 < size) {
                long c2 = v1Var.c(i2);
                i += k0.c((c2 >> 63) ^ (c2 + c2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += k0.c((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    public static void g(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.b(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * k0.e(i << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f1) {
            f1 f1Var = (f1) list;
            i = 0;
            while (i2 < size) {
                i += k0.e(f1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += k0.e(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void h(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.g(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return h(list) + (size * k0.e(i << 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v1) {
            v1 v1Var = (v1) list;
            i = 0;
            while (i2 < size) {
                i += k0.c(v1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += k0.c(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void i(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.i(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i(list) + (size * k0.e(i << 3));
    }

    public static void j(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.l(i, list, z);
    }

    public static void k(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.a(i, list, z);
    }

    public static void l(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.f(i, list, z);
    }

    public static void m(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.n(i, list, z);
    }

    public static void n(int i, List list, b4 b4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b4Var.e(i, list, z);
    }
}
