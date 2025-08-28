package a.a.a.a.a.a;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class k2<T> implements r2<T> {
    private static final int[] n = new int[0];
    private static final Unsafe o = t3.b();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f31a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f32b;
    private final int c;
    private final int d;
    private final h2 e;
    private final boolean f;
    private final boolean g;
    private final int[] h;
    private final int i;
    private final int j;
    private final u1 k;
    private final j3 l;
    private final q0 m;

    private k2(int[] iArr, Object[] objArr, int i, int i2, h2 h2Var, boolean z, boolean z2, int[] iArr2, int i3, int i4, m2 m2Var, u1 u1Var, j3 j3Var, q0 q0Var, c2 c2Var) {
        this.f31a = iArr;
        this.f32b = objArr;
        this.c = i;
        this.d = i2;
        this.g = z;
        boolean z3 = false;
        if (q0Var != null && q0Var.a(h2Var)) {
            z3 = true;
        }
        this.f = z3;
        this.h = iArr2;
        this.i = i3;
        this.j = i4;
        this.k = u1Var;
        this.l = j3Var;
        this.m = q0Var;
        this.e = h2Var;
    }

    private final int a(int i, int i2) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return b(i, i2);
    }

    private final int a(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, o oVar) {
        Unsafe unsafe = o;
        long j2 = this.f31a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(p.b(bArr, i))));
                    int i9 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i9;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(p.a(bArr, i))));
                    int i10 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i10;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int e = p.e(bArr, i, oVar);
                    unsafe.putObject(obj, j, Long.valueOf(oVar.f62b));
                    unsafe.putInt(obj, j2, i4);
                    return e;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int d = p.d(bArr, i, oVar);
                    unsafe.putObject(obj, j, Integer.valueOf(oVar.f61a));
                    unsafe.putInt(obj, j2, i4);
                    return d;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(obj, j, Long.valueOf(p.b(bArr, i)));
                    int i11 = i + 8;
                    unsafe.putInt(obj, j2, i4);
                    return i11;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(obj, j, Integer.valueOf(p.a(bArr, i)));
                    int i12 = i + 4;
                    unsafe.putInt(obj, j2, i4);
                    return i12;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int e2 = p.e(bArr, i, oVar);
                    unsafe.putObject(obj, j, Boolean.valueOf(oVar.f62b != 0));
                    unsafe.putInt(obj, j2, i4);
                    return e2;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int d2 = p.d(bArr, i, oVar);
                    int i13 = oVar.f61a;
                    if (i13 == 0) {
                        unsafe.putObject(obj, j, "");
                    } else if ((i6 & 536870912) != 0 && !y3.b(bArr, d2, d2 + i13)) {
                        throw k1.c();
                    } else {
                        unsafe.putObject(obj, j, new String(bArr, d2, i13, i1.f25a));
                        d2 += i13;
                    }
                    unsafe.putInt(obj, j2, i4);
                    return d2;
                }
                break;
            case 60:
                if (i5 == 2) {
                    Object a2 = a(obj, i4, i8);
                    int a3 = p.a(a2, b(i8), bArr, i, i2, oVar);
                    a(obj, i4, i8, a2);
                    return a3;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int a4 = p.a(bArr, i, oVar);
                    unsafe.putObject(obj, j, oVar.c);
                    unsafe.putInt(obj, j2, i4);
                    return a4;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int d3 = p.d(bArr, i, oVar);
                    int i14 = oVar.f61a;
                    g1 a5 = a(i8);
                    if (a5 == null || a5.a(i14)) {
                        unsafe.putObject(obj, j, Integer.valueOf(i14));
                        unsafe.putInt(obj, j2, i4);
                    } else {
                        g(obj).a(i3, Long.valueOf(i14));
                    }
                    return d3;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int d4 = p.d(bArr, i, oVar);
                    unsafe.putObject(obj, j, Integer.valueOf(g0.a(oVar.f61a)));
                    unsafe.putInt(obj, j2, i4);
                    return d4;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int e3 = p.e(bArr, i, oVar);
                    unsafe.putObject(obj, j, Long.valueOf(g0.a(oVar.f62b)));
                    unsafe.putInt(obj, j2, i4);
                    return e3;
                }
                break;
            case 68:
                if (i5 == 3) {
                    Object a6 = a(obj, i4, i8);
                    int a7 = p.a(a6, b(i8), bArr, i, i2, (i3 & (-8)) | 4, oVar);
                    a(obj, i4, i8, a6);
                    return a7;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x029e, code lost:
        if (r30.f62b != 0) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02a0, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02a2, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02a3, code lost:
        r12.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02a6, code lost:
        if (r1 >= r20) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02a8, code lost:
        r4 = a.a.a.a.a.a.p.d(r18, r1, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02ae, code lost:
        if (r21 == r30.f61a) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02b1, code lost:
        r1 = a.a.a.a.a.a.p.e(r18, r4, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02b9, code lost:
        if (r30.f62b == 0) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02bc, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0170, code lost:
        if (r4 == 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0172, code lost:
        r12.add(a.a.a.a.a.a.c0.f9b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0178, code lost:
        r12.add(a.a.a.a.a.a.c0.a(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0180, code lost:
        if (r1 >= r20) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0182, code lost:
        r4 = a.a.a.a.a.a.p.d(r18, r1, r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0188, code lost:
        if (r21 == r30.f61a) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x018b, code lost:
        r1 = a.a.a.a.a.a.p.d(r18, r4, r30);
        r4 = r30.f61a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0191, code lost:
        if (r4 < 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0195, code lost:
        if (r4 > (r18.length - r1)) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0197, code lost:
        if (r4 != 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x019e, code lost:
        throw a.a.a.a.a.a.k1.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a3, code lost:
        throw a.a.a.a.a.a.k1.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01a4, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0234  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x01ea -> B:111:0x01ee). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x0200 -> B:108:0x01df). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x022e -> B:131:0x0232). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x0244 -> B:126:0x021b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:165:0x02a2 -> B:166:0x02a3). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x02b9 -> B:164:0x02a0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0178 -> B:80:0x0180). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0197 -> B:78:0x0172). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int a(java.lang.Object r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, a.a.a.a.a.a.o r30) {
        /*
            Method dump skipped, instructions count: 1144
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.k2.a(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, a.a.a.a.a.a.o):int");
    }

    private final int a(Object obj, byte[] bArr, int i, int i2, int i3, long j, o oVar) {
        Unsafe unsafe = o;
        Object c = c(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((a2) object).d()) {
            a2 a2 = a2.c().a();
            c2.a(a2, object);
            unsafe.putObject(obj, j, a2);
        }
        z1 z1Var = (z1) c;
        throw null;
    }

    private final g1 a(int i) {
        int i2 = i / 3;
        return (g1) this.f32b[i2 + i2 + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0287  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static a.a.a.a.a.a.k2 a(java.lang.Class r31, a.a.a.a.a.a.e2 r32, a.a.a.a.a.a.m2 r33, a.a.a.a.a.a.u1 r34, a.a.a.a.a.a.j3 r35, a.a.a.a.a.a.q0 r36, a.a.a.a.a.a.c2 r37) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.k2.a(java.lang.Class, a.a.a.a.a.a.e2, a.a.a.a.a.a.m2, a.a.a.a.a.a.u1, a.a.a.a.a.a.j3, a.a.a.a.a.a.q0, a.a.a.a.a.a.c2):a.a.a.a.a.a.k2");
    }

    private final Object a(Object obj, int i) {
        r2 b2 = b(i);
        int g = g(i) & 1048575;
        if (c(obj, i)) {
            Object object = o.getObject(obj, g);
            if (f(object)) {
                return object;
            }
            Object d = b2.d();
            if (object != null) {
                b2.b(d, object);
            }
            return d;
        }
        return b2.d();
    }

    private final Object a(Object obj, int i, int i2) {
        r2 b2 = b(i2);
        if (c(obj, i, i2)) {
            Object object = o.getObject(obj, g(i2) & 1048575);
            if (f(object)) {
                return object;
            }
            Object d = b2.d();
            if (object != null) {
                b2.b(d, object);
            }
            return d;
        }
        return b2.d();
    }

    private static Field a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static final void a(int i, Object obj, b4 b4Var) {
        if (obj instanceof String) {
            b4Var.a(i, (String) obj);
        } else {
            b4Var.a(i, (c0) obj);
        }
    }

    private final void a(b4 b4Var, int i, Object obj, int i2) {
        if (obj == null) {
            return;
        }
        z1 z1Var = (z1) c(i2);
        throw null;
    }

    private final void a(Object obj, int i, int i2, Object obj2) {
        o.putObject(obj, g(i2) & 1048575, obj2);
        b(obj, i, i2);
    }

    private final void a(Object obj, int i, Object obj2) {
        o.putObject(obj, g(i) & 1048575, obj2);
        b(obj, i);
    }

    private final void a(Object obj, Object obj2, int i) {
        if (c(obj2, i)) {
            long g = g(i) & 1048575;
            Object object = o.getObject(obj2, g);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f31a[i] + " is present but null: " + obj2.toString());
            }
            r2 b2 = b(i);
            if (!c(obj, i)) {
                if (f(object)) {
                    Object d = b2.d();
                    b2.b(d, object);
                    o.putObject(obj, g, d);
                } else {
                    o.putObject(obj, g, object);
                }
                b(obj, i);
                return;
            }
            Object object2 = o.getObject(obj, g);
            if (!f(object2)) {
                Object d2 = b2.d();
                b2.b(d2, object2);
                o.putObject(obj, g, d2);
                object2 = d2;
            }
            b2.b(object2, object);
        }
    }

    private final boolean a(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? c(obj, i) : (i3 & i4) != 0;
    }

    private static boolean a(Object obj, int i, r2 r2Var) {
        return r2Var.d(t3.e(obj, i & 1048575));
    }

    private static boolean a(Object obj, long j) {
        return ((Boolean) t3.e(obj, j)).booleanValue();
    }

    private static double b(Object obj, long j) {
        return ((Double) t3.e(obj, j)).doubleValue();
    }

    private final int b(int i, int i2) {
        int length = (this.f31a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f31a[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final r2 b(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        r2 r2Var = (r2) this.f32b[i3];
        if (r2Var != null) {
            return r2Var;
        }
        r2 a2 = p2.a().a((Class) this.f32b[i3 + 1]);
        this.f32b[i3] = a2;
        return a2;
    }

    private final void b(Object obj, int i) {
        int e = e(i);
        long j = 1048575 & e;
        if (j == 1048575) {
            return;
        }
        t3.a(obj, j, (1 << (e >>> 20)) | t3.c(obj, j));
    }

    private final void b(Object obj, int i, int i2) {
        t3.a(obj, e(i2) & 1048575, i);
    }

    private final void b(Object obj, Object obj2, int i) {
        int i2 = this.f31a[i];
        if (c(obj2, i2, i)) {
            long g = g(i) & 1048575;
            Object object = o.getObject(obj2, g);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f31a[i] + " is present but null: " + obj2.toString());
            }
            r2 b2 = b(i);
            if (!c(obj, i2, i)) {
                if (f(object)) {
                    Object d = b2.d();
                    b2.b(d, object);
                    o.putObject(obj, g, d);
                } else {
                    o.putObject(obj, g, object);
                }
                b(obj, i2, i);
                return;
            }
            Object object2 = o.getObject(obj, g);
            if (!f(object2)) {
                Object d2 = b2.d();
                b2.b(d2, object2);
                o.putObject(obj, g, d2);
                object2 = d2;
            }
            b2.b(object2, object);
        }
    }

    private static float c(Object obj, long j) {
        return ((Float) t3.e(obj, j)).floatValue();
    }

    private final Object c(int i) {
        int i2 = i / 3;
        return this.f32b[i2 + i2];
    }

    private final boolean c(Object obj, int i) {
        int e = e(i);
        long j = e & 1048575;
        if (j != 1048575) {
            return (t3.c(obj, j) & (1 << (e >>> 20))) != 0;
        }
        int g = g(i);
        long j2 = g & 1048575;
        switch (f(g)) {
            case me.i38.gesture.m0.DragSortListView_click_remove_id /* 0 */:
                return Double.doubleToRawLongBits(t3.a(obj, j2)) != 0;
            case me.i38.gesture.m0.DragSortListView_collapsed_height /* 1 */:
                return Float.floatToRawIntBits(t3.b(obj, j2)) != 0;
            case me.i38.gesture.m0.DragSortListView_drag_enabled /* 2 */:
                return t3.d(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_drag_handle_id /* 3 */:
                return t3.d(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_drag_scroll_start /* 4 */:
                return t3.c(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_drag_start_mode /* 5 */:
                return t3.d(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_drop_animation_duration /* 6 */:
                return t3.c(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_fling_handle_id /* 7 */:
                return t3.h(obj, j2);
            case me.i38.gesture.m0.DragSortListView_float_alpha /* 8 */:
                Object e2 = t3.e(obj, j2);
                if (e2 instanceof String) {
                    return !((String) e2).isEmpty();
                } else if (e2 instanceof c0) {
                    return !c0.f9b.equals(e2);
                } else {
                    throw new IllegalArgumentException();
                }
            case me.i38.gesture.m0.DragSortListView_float_background_color /* 9 */:
                return t3.e(obj, j2) != null;
            case me.i38.gesture.m0.DragSortListView_max_drag_scroll_speed /* 10 */:
                return !c0.f9b.equals(t3.e(obj, j2));
            case me.i38.gesture.m0.DragSortListView_remove_animation_duration /* 11 */:
                return t3.c(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_remove_enabled /* 12 */:
                return t3.c(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_remove_mode /* 13 */:
                return t3.c(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_slide_shuffle_speed /* 14 */:
                return t3.d(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_sort_enabled /* 15 */:
                return t3.c(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_track_drag_sort /* 16 */:
                return t3.d(obj, j2) != 0;
            case me.i38.gesture.m0.DragSortListView_use_default_controller /* 17 */:
                return t3.e(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean c(Object obj, int i, int i2) {
        return t3.c(obj, (long) (e(i2) & 1048575)) == i;
    }

    private final boolean c(Object obj, Object obj2, int i) {
        return c(obj, i) == c(obj2, i);
    }

    private final int d(int i) {
        if (i < this.c || i > this.d) {
            return -1;
        }
        return b(i, 0);
    }

    private static int d(Object obj, long j) {
        return ((Integer) t3.e(obj, j)).intValue();
    }

    private final int e(int i) {
        return this.f31a[i + 2];
    }

    private static long e(Object obj, long j) {
        return ((Long) t3.e(obj, j)).longValue();
    }

    private static void e(Object obj) {
        if (!f(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private static int f(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean f(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof e1) {
            return ((e1) obj).k();
        }
        return true;
    }

    private final int g(int i) {
        return this.f31a[i + 1];
    }

    static k3 g(Object obj) {
        e1 e1Var = (e1) obj;
        k3 k3Var = e1Var.zzc;
        if (k3Var == k3.e()) {
            k3 f = k3.f();
            e1Var.zzc = f;
            return f;
        }
        return k3Var;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x020c, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0219, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0226, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0233, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0240, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x024d, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x024f, code lost:
        r4 = a.a.a.a.a.a.k0.e(r11 << 3) + a.a.a.a.a.a.k0.e(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0093, code lost:
        if (c(r17, r11, r5) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009b, code lost:
        if (c(r17, r11, r5) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
        if (c(r17, r11, r5) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0118, code lost:
        if (c(r17, r11, r5) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011f, code lost:
        if (c(r17, r11, r5) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0126, code lost:
        if (c(r17, r11, r5) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0128, code lost:
        r4 = r11 << 3;
        r3 = a.a.a.a.a.a.k0.d(d(r17, r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013c, code lost:
        if (c(r17, r11, r5) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0143, code lost:
        if (c(r17, r11, r5) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0145, code lost:
        r3 = a.a.a.a.a.a.k0.c(e(r17, r3));
        r4 = a.a.a.a.a.a.k0.e(r11 << 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0159, code lost:
        if (c(r17, r11, r5) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x015b, code lost:
        r3 = a.a.a.a.a.a.k0.e(r11 << 3) + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0169, code lost:
        if (c(r17, r11, r5) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x016b, code lost:
        r3 = a.a.a.a.a.a.k0.e(r11 << 3) + 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x019c, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01aa, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c6, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01d4, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e2, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f2, code lost:
        if (r3 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ff, code lost:
        if (r3 > 0) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int h(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 1252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.k2.h(java.lang.Object):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x03f8, code lost:
        if (r6 == 1048575) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x03fa, code lost:
        r27.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0400, code lost:
        r2 = r8.i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0404, code lost:
        if (r2 >= r8.j) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0406, code lost:
        r4 = r8.h[r2];
        r5 = r8.f31a[r4];
        r5 = a.a.a.a.a.a.t3.e(r12, r8.g(r4) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0418, code lost:
        if (r5 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x041f, code lost:
        if (r8.a(r4) != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0421, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0424, code lost:
        r5 = (a.a.a.a.a.a.a2) r5;
        r0 = (a.a.a.a.a.a.z1) r8.c(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x042c, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x042f, code lost:
        if (r9 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0431, code lost:
        if (r0 != r32) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0438, code lost:
        throw a.a.a.a.a.a.k1.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0439, code lost:
        if (r0 > r32) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x043b, code lost:
        if (r3 != r9) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x043d, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0442, code lost:
        throw a.a.a.a.a.a.k1.e();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.Object r29, byte[] r30, int r31, int r32, int r33, a.a.a.a.a.a.o r34) {
        /*
            Method dump skipped, instructions count: 1130
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.k2.a(java.lang.Object, byte[], int, int, int, a.a.a.a.a.a.o):int");
    }

    @Override // a.a.a.a.a.a.r2
    public final void a(Object obj) {
        int i;
        if (f(obj)) {
            if (obj instanceof e1) {
                e1 e1Var = (e1) obj;
                e1Var.a(Integer.MAX_VALUE);
                e1Var.zza = 0;
                e1Var.i();
            }
            int length = this.f31a.length;
            while (i < length) {
                int g = g(i);
                int i2 = 1048575 & g;
                int f = f(g);
                long j = i2;
                if (f != 9) {
                    if (f != 60 && f != 68) {
                        switch (f) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.k.a(obj, j);
                                break;
                            case 50:
                                Object object = o.getObject(obj, j);
                                if (object == null) {
                                    break;
                                } else {
                                    Unsafe unsafe = o;
                                    ((a2) object).b();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                }
                        }
                    } else {
                        if (!c(obj, this.f31a[i], i)) {
                        }
                        b(i).a(o.getObject(obj, j));
                    }
                }
                i = c(obj, i) ? 0 : i + 3;
                b(i).a(o.getObject(obj, j));
            }
            this.l.e(obj);
            if (this.f) {
                this.m.b(obj);
                throw null;
            }
        }
    }

    @Override // a.a.a.a.a.a.r2
    public final void a(Object obj, b4 b4Var) {
        int i;
        double a2;
        float b2;
        long d;
        long d2;
        int c;
        long d3;
        int c2;
        boolean h;
        int c3;
        int c4;
        int c5;
        long d4;
        int c6;
        long d5;
        int i2 = 1048575;
        if (this.g) {
            if (this.f) {
                this.m.a(obj);
                throw null;
            }
            int length = this.f31a.length;
            for (int i3 = 0; i3 < length; i3 += 3) {
                int g = g(i3);
                int i4 = this.f31a[i3];
                switch (f(g)) {
                    case me.i38.gesture.m0.DragSortListView_click_remove_id /* 0 */:
                        if (c(obj, i3)) {
                            a2 = t3.a(obj, g & 1048575);
                            b4Var.a(i4, a2);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_collapsed_height /* 1 */:
                        if (c(obj, i3)) {
                            b2 = t3.b(obj, g & 1048575);
                            b4Var.a(i4, b2);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_drag_enabled /* 2 */:
                        if (c(obj, i3)) {
                            d = t3.d(obj, g & 1048575);
                            b4Var.d(i4, d);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_drag_handle_id /* 3 */:
                        if (c(obj, i3)) {
                            d2 = t3.d(obj, g & 1048575);
                            b4Var.e(i4, d2);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_drag_scroll_start /* 4 */:
                        if (c(obj, i3)) {
                            c = t3.c(obj, g & 1048575);
                            b4Var.f(i4, c);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_drag_start_mode /* 5 */:
                        if (c(obj, i3)) {
                            d3 = t3.d(obj, g & 1048575);
                            b4Var.a(i4, d3);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_drop_animation_duration /* 6 */:
                        if (c(obj, i3)) {
                            c2 = t3.c(obj, g & 1048575);
                            b4Var.e(i4, c2);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_fling_handle_id /* 7 */:
                        if (c(obj, i3)) {
                            h = t3.h(obj, g & 1048575);
                            b4Var.a(i4, h);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_float_alpha /* 8 */:
                        if (!c(obj, i3)) {
                            break;
                        }
                        a(i4, t3.e(obj, g & 1048575), b4Var);
                        break;
                    case me.i38.gesture.m0.DragSortListView_float_background_color /* 9 */:
                        if (!c(obj, i3)) {
                            break;
                        }
                        b4Var.a(i4, t3.e(obj, g & 1048575), b(i3));
                        break;
                    case me.i38.gesture.m0.DragSortListView_max_drag_scroll_speed /* 10 */:
                        if (!c(obj, i3)) {
                            break;
                        }
                        b4Var.a(i4, (c0) t3.e(obj, g & 1048575));
                        break;
                    case me.i38.gesture.m0.DragSortListView_remove_animation_duration /* 11 */:
                        if (c(obj, i3)) {
                            c3 = t3.c(obj, g & 1048575);
                            b4Var.d(i4, c3);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_remove_enabled /* 12 */:
                        if (c(obj, i3)) {
                            c4 = t3.c(obj, g & 1048575);
                            b4Var.b(i4, c4);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_remove_mode /* 13 */:
                        if (c(obj, i3)) {
                            c5 = t3.c(obj, g & 1048575);
                            b4Var.a(i4, c5);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_slide_shuffle_speed /* 14 */:
                        if (c(obj, i3)) {
                            d4 = t3.d(obj, g & 1048575);
                            b4Var.b(i4, d4);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_sort_enabled /* 15 */:
                        if (c(obj, i3)) {
                            c6 = t3.c(obj, g & 1048575);
                            b4Var.c(i4, c6);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_track_drag_sort /* 16 */:
                        if (c(obj, i3)) {
                            d5 = t3.d(obj, g & 1048575);
                            b4Var.c(i4, d5);
                            break;
                        } else {
                            break;
                        }
                    case me.i38.gesture.m0.DragSortListView_use_default_controller /* 17 */:
                        if (!c(obj, i3)) {
                            break;
                        }
                        b4Var.b(i4, t3.e(obj, g & 1048575), b(i3));
                        break;
                    case 18:
                        t2.b(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 19:
                        t2.f(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 20:
                        t2.h(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 21:
                        t2.n(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 22:
                        t2.g(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 23:
                        t2.e(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 24:
                        t2.d(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 25:
                        t2.a(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 26:
                        t2.b(i4, (List) t3.e(obj, g & 1048575), b4Var);
                        break;
                    case 27:
                        t2.b(i4, (List) t3.e(obj, g & 1048575), b4Var, b(i3));
                        break;
                    case 28:
                        t2.a(i4, (List) t3.e(obj, g & 1048575), b4Var);
                        break;
                    case 29:
                        t2.m(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 30:
                        t2.c(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 31:
                        t2.i(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 32:
                        t2.j(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 33:
                        t2.k(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 34:
                        t2.l(i4, (List) t3.e(obj, g & 1048575), b4Var, false);
                        break;
                    case 35:
                        t2.b(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 36:
                        t2.f(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 37:
                        t2.h(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 38:
                        t2.n(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 39:
                        t2.g(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 40:
                        t2.e(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 41:
                        t2.d(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 42:
                        t2.a(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 43:
                        t2.m(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 44:
                        t2.c(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 45:
                        t2.i(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 46:
                        t2.j(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 47:
                        t2.k(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 48:
                        t2.l(i4, (List) t3.e(obj, g & 1048575), b4Var, true);
                        break;
                    case 49:
                        t2.a(i4, (List) t3.e(obj, g & 1048575), b4Var, b(i3));
                        break;
                    case 50:
                        a(b4Var, i4, t3.e(obj, g & 1048575), i3);
                        break;
                    case 51:
                        if (c(obj, i4, i3)) {
                            a2 = b(obj, g & 1048575);
                            b4Var.a(i4, a2);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (c(obj, i4, i3)) {
                            b2 = c(obj, g & 1048575);
                            b4Var.a(i4, b2);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (c(obj, i4, i3)) {
                            d = e(obj, g & 1048575);
                            b4Var.d(i4, d);
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (c(obj, i4, i3)) {
                            d2 = e(obj, g & 1048575);
                            b4Var.e(i4, d2);
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (c(obj, i4, i3)) {
                            c = d(obj, g & 1048575);
                            b4Var.f(i4, c);
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (c(obj, i4, i3)) {
                            d3 = e(obj, g & 1048575);
                            b4Var.a(i4, d3);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (c(obj, i4, i3)) {
                            c2 = d(obj, g & 1048575);
                            b4Var.e(i4, c2);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (c(obj, i4, i3)) {
                            h = a(obj, g & 1048575);
                            b4Var.a(i4, h);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!c(obj, i4, i3)) {
                            break;
                        }
                        a(i4, t3.e(obj, g & 1048575), b4Var);
                        break;
                    case 60:
                        if (!c(obj, i4, i3)) {
                            break;
                        }
                        b4Var.a(i4, t3.e(obj, g & 1048575), b(i3));
                        break;
                    case 61:
                        if (!c(obj, i4, i3)) {
                            break;
                        }
                        b4Var.a(i4, (c0) t3.e(obj, g & 1048575));
                        break;
                    case 62:
                        if (c(obj, i4, i3)) {
                            c3 = d(obj, g & 1048575);
                            b4Var.d(i4, c3);
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (c(obj, i4, i3)) {
                            c4 = d(obj, g & 1048575);
                            b4Var.b(i4, c4);
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (c(obj, i4, i3)) {
                            c5 = d(obj, g & 1048575);
                            b4Var.a(i4, c5);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (c(obj, i4, i3)) {
                            d4 = e(obj, g & 1048575);
                            b4Var.b(i4, d4);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (c(obj, i4, i3)) {
                            c6 = d(obj, g & 1048575);
                            b4Var.c(i4, c6);
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (c(obj, i4, i3)) {
                            d5 = e(obj, g & 1048575);
                            b4Var.c(i4, d5);
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (!c(obj, i4, i3)) {
                            break;
                        }
                        b4Var.b(i4, t3.e(obj, g & 1048575), b(i3));
                        break;
                }
            }
        } else if (this.f) {
            this.m.a(obj);
            throw null;
        } else {
            int length2 = this.f31a.length;
            Unsafe unsafe = o;
            int i5 = 0;
            int i6 = 1048575;
            int i7 = 0;
            while (i5 < length2) {
                int g2 = g(i5);
                int[] iArr = this.f31a;
                int i8 = iArr[i5];
                int f = f(g2);
                if (f <= 17) {
                    int i9 = iArr[i5 + 2];
                    int i10 = i9 & i2;
                    if (i10 != i6) {
                        i7 = unsafe.getInt(obj, i10);
                        i6 = i10;
                    }
                    i = 1 << (i9 >>> 20);
                } else {
                    i = 0;
                }
                long j = g2 & i2;
                switch (f) {
                    case me.i38.gesture.m0.DragSortListView_click_remove_id /* 0 */:
                        if ((i7 & i) != 0) {
                            b4Var.a(i8, t3.a(obj, j));
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_collapsed_height /* 1 */:
                        if ((i7 & i) != 0) {
                            b4Var.a(i8, t3.b(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_drag_enabled /* 2 */:
                        if ((i7 & i) != 0) {
                            b4Var.d(i8, unsafe.getLong(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_drag_handle_id /* 3 */:
                        if ((i7 & i) != 0) {
                            b4Var.e(i8, unsafe.getLong(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_drag_scroll_start /* 4 */:
                        if ((i7 & i) != 0) {
                            b4Var.f(i8, unsafe.getInt(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_drag_start_mode /* 5 */:
                        if ((i7 & i) != 0) {
                            b4Var.a(i8, unsafe.getLong(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_drop_animation_duration /* 6 */:
                        if ((i7 & i) != 0) {
                            b4Var.e(i8, unsafe.getInt(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_fling_handle_id /* 7 */:
                        if ((i7 & i) != 0) {
                            b4Var.a(i8, t3.h(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_float_alpha /* 8 */:
                        if ((i7 & i) != 0) {
                            a(i8, unsafe.getObject(obj, j), b4Var);
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_float_background_color /* 9 */:
                        if ((i7 & i) != 0) {
                            b4Var.a(i8, unsafe.getObject(obj, j), b(i5));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_max_drag_scroll_speed /* 10 */:
                        if ((i7 & i) != 0) {
                            b4Var.a(i8, (c0) unsafe.getObject(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_remove_animation_duration /* 11 */:
                        if ((i7 & i) != 0) {
                            b4Var.d(i8, unsafe.getInt(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_remove_enabled /* 12 */:
                        if ((i7 & i) != 0) {
                            b4Var.b(i8, unsafe.getInt(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_remove_mode /* 13 */:
                        if ((i7 & i) != 0) {
                            b4Var.a(i8, unsafe.getInt(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_slide_shuffle_speed /* 14 */:
                        if ((i7 & i) != 0) {
                            b4Var.b(i8, unsafe.getLong(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_sort_enabled /* 15 */:
                        if ((i7 & i) != 0) {
                            b4Var.c(i8, unsafe.getInt(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_track_drag_sort /* 16 */:
                        if ((i7 & i) != 0) {
                            b4Var.c(i8, unsafe.getLong(obj, j));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case me.i38.gesture.m0.DragSortListView_use_default_controller /* 17 */:
                        if ((i7 & i) != 0) {
                            b4Var.b(i8, unsafe.getObject(obj, j), b(i5));
                        } else {
                            continue;
                        }
                        i5 += 3;
                        i2 = 1048575;
                    case 18:
                        t2.b(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        continue;
                        i5 += 3;
                        i2 = 1048575;
                    case 19:
                        t2.f(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        continue;
                        i5 += 3;
                        i2 = 1048575;
                    case 20:
                        t2.h(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        continue;
                        i5 += 3;
                        i2 = 1048575;
                    case 21:
                        t2.n(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        continue;
                        i5 += 3;
                        i2 = 1048575;
                    case 22:
                        t2.g(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        continue;
                        i5 += 3;
                        i2 = 1048575;
                    case 23:
                        t2.e(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        continue;
                        i5 += 3;
                        i2 = 1048575;
                    case 24:
                        t2.d(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        continue;
                        i5 += 3;
                        i2 = 1048575;
                    case 25:
                        t2.a(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        continue;
                        i5 += 3;
                        i2 = 1048575;
                    case 26:
                        t2.b(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var);
                        break;
                    case 27:
                        t2.b(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, b(i5));
                        break;
                    case 28:
                        t2.a(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var);
                        break;
                    case 29:
                        t2.m(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        break;
                    case 30:
                        t2.c(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        break;
                    case 31:
                        t2.i(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        break;
                    case 32:
                        t2.j(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        break;
                    case 33:
                        t2.k(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        break;
                    case 34:
                        t2.l(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, false);
                        break;
                    case 35:
                        t2.b(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 36:
                        t2.f(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 37:
                        t2.h(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 38:
                        t2.n(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 39:
                        t2.g(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 40:
                        t2.e(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 41:
                        t2.d(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 42:
                        t2.a(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 43:
                        t2.m(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 44:
                        t2.c(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 45:
                        t2.i(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 46:
                        t2.j(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 47:
                        t2.k(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 48:
                        t2.l(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, true);
                        break;
                    case 49:
                        t2.a(this.f31a[i5], (List) unsafe.getObject(obj, j), b4Var, b(i5));
                        break;
                    case 50:
                        a(b4Var, i8, unsafe.getObject(obj, j), i5);
                        break;
                    case 51:
                        if (c(obj, i8, i5)) {
                            b4Var.a(i8, b(obj, j));
                            break;
                        }
                        break;
                    case 52:
                        if (c(obj, i8, i5)) {
                            b4Var.a(i8, c(obj, j));
                            break;
                        }
                        break;
                    case 53:
                        if (c(obj, i8, i5)) {
                            b4Var.d(i8, e(obj, j));
                            break;
                        }
                        break;
                    case 54:
                        if (c(obj, i8, i5)) {
                            b4Var.e(i8, e(obj, j));
                            break;
                        }
                        break;
                    case 55:
                        if (c(obj, i8, i5)) {
                            b4Var.f(i8, d(obj, j));
                            break;
                        }
                        break;
                    case 56:
                        if (c(obj, i8, i5)) {
                            b4Var.a(i8, e(obj, j));
                            break;
                        }
                        break;
                    case 57:
                        if (c(obj, i8, i5)) {
                            b4Var.e(i8, d(obj, j));
                            break;
                        }
                        break;
                    case 58:
                        if (c(obj, i8, i5)) {
                            b4Var.a(i8, a(obj, j));
                            break;
                        }
                        break;
                    case 59:
                        if (c(obj, i8, i5)) {
                            a(i8, unsafe.getObject(obj, j), b4Var);
                            break;
                        }
                        break;
                    case 60:
                        if (c(obj, i8, i5)) {
                            b4Var.a(i8, unsafe.getObject(obj, j), b(i5));
                            break;
                        }
                        break;
                    case 61:
                        if (c(obj, i8, i5)) {
                            b4Var.a(i8, (c0) unsafe.getObject(obj, j));
                            break;
                        }
                        break;
                    case 62:
                        if (c(obj, i8, i5)) {
                            b4Var.d(i8, d(obj, j));
                            break;
                        }
                        break;
                    case 63:
                        if (c(obj, i8, i5)) {
                            b4Var.b(i8, d(obj, j));
                            break;
                        }
                        break;
                    case 64:
                        if (c(obj, i8, i5)) {
                            b4Var.a(i8, d(obj, j));
                            break;
                        }
                        break;
                    case 65:
                        if (c(obj, i8, i5)) {
                            b4Var.b(i8, e(obj, j));
                            break;
                        }
                        break;
                    case 66:
                        if (c(obj, i8, i5)) {
                            b4Var.c(i8, d(obj, j));
                            break;
                        }
                        break;
                    case 67:
                        if (c(obj, i8, i5)) {
                            b4Var.c(i8, e(obj, j));
                            break;
                        }
                        break;
                    case 68:
                        if (c(obj, i8, i5)) {
                            b4Var.b(i8, unsafe.getObject(obj, j), b(i5));
                            break;
                        }
                        break;
                }
                i5 += 3;
                i2 = 1048575;
            }
        }
        j3 j3Var = this.l;
        j3Var.a(j3Var.d(obj), b4Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x02ea, code lost:
        if (r0 != r24) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02ec, code lost:
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r15;
        r1 = r23;
        r6 = r25;
        r7 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02fd, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0348, code lost:
        if (r0 != r14) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    @Override // a.a.a.a.a.a.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r31, byte[] r32, int r33, int r34, a.a.a.a.a.a.o r35) {
        /*
            Method dump skipped, instructions count: 966
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.k2.a(java.lang.Object, byte[], int, int, a.a.a.a.a.a.o):void");
    }

    @Override // a.a.a.a.a.a.r2
    public final boolean a(Object obj, Object obj2) {
        int length = this.f31a.length;
        for (int i = 0; i < length; i += 3) {
            int g = g(i);
            long j = g & 1048575;
            switch (f(g)) {
                case me.i38.gesture.m0.DragSortListView_click_remove_id /* 0 */:
                    if (c(obj, obj2, i) && Double.doubleToLongBits(t3.a(obj, j)) == Double.doubleToLongBits(t3.a(obj2, j))) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_collapsed_height /* 1 */:
                    if (c(obj, obj2, i) && Float.floatToIntBits(t3.b(obj, j)) == Float.floatToIntBits(t3.b(obj2, j))) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_drag_enabled /* 2 */:
                    if (c(obj, obj2, i) && t3.d(obj, j) == t3.d(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_drag_handle_id /* 3 */:
                    if (c(obj, obj2, i) && t3.d(obj, j) == t3.d(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_drag_scroll_start /* 4 */:
                    if (c(obj, obj2, i) && t3.c(obj, j) == t3.c(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_drag_start_mode /* 5 */:
                    if (c(obj, obj2, i) && t3.d(obj, j) == t3.d(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_drop_animation_duration /* 6 */:
                    if (c(obj, obj2, i) && t3.c(obj, j) == t3.c(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_fling_handle_id /* 7 */:
                    if (c(obj, obj2, i) && t3.h(obj, j) == t3.h(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_float_alpha /* 8 */:
                    if (c(obj, obj2, i) && t2.a(t3.e(obj, j), t3.e(obj2, j))) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_float_background_color /* 9 */:
                    if (c(obj, obj2, i) && t2.a(t3.e(obj, j), t3.e(obj2, j))) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_max_drag_scroll_speed /* 10 */:
                    if (c(obj, obj2, i) && t2.a(t3.e(obj, j), t3.e(obj2, j))) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_remove_animation_duration /* 11 */:
                    if (c(obj, obj2, i) && t3.c(obj, j) == t3.c(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_remove_enabled /* 12 */:
                    if (c(obj, obj2, i) && t3.c(obj, j) == t3.c(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_remove_mode /* 13 */:
                    if (c(obj, obj2, i) && t3.c(obj, j) == t3.c(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_slide_shuffle_speed /* 14 */:
                    if (c(obj, obj2, i) && t3.d(obj, j) == t3.d(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_sort_enabled /* 15 */:
                    if (c(obj, obj2, i) && t3.c(obj, j) == t3.c(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_track_drag_sort /* 16 */:
                    if (c(obj, obj2, i) && t3.d(obj, j) == t3.d(obj2, j)) {
                        break;
                    }
                    return false;
                case me.i38.gesture.m0.DragSortListView_use_default_controller /* 17 */:
                    if (c(obj, obj2, i) && t2.a(t3.e(obj, j), t3.e(obj2, j))) {
                        break;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    if (t2.a(t3.e(obj, j), t3.e(obj2, j))) {
                        break;
                    } else {
                        return false;
                    }
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long e = e(i) & 1048575;
                    if (t3.c(obj, e) == t3.c(obj2, e) && t2.a(t3.e(obj, j), t3.e(obj2, j))) {
                        break;
                    }
                    return false;
            }
        }
        if (this.l.d(obj).equals(this.l.d(obj2))) {
            if (this.f) {
                this.m.a(obj);
                throw null;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x031b, code lost:
        if ((r4 instanceof a.a.a.a.a.a.c0) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x031e, code lost:
        r5 = r6 << 3;
        r4 = a.a.a.a.a.a.k0.a((java.lang.String) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        if ((r4 instanceof a.a.a.a.a.a.c0) != false) goto L54;
     */
    @Override // a.a.a.a.a.a.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 1084
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.k2.b(java.lang.Object):int");
    }

    @Override // a.a.a.a.a.a.r2
    public final void b(Object obj, Object obj2) {
        e(obj);
        if (obj2 == null) {
            throw null;
        }
        for (int i = 0; i < this.f31a.length; i += 3) {
            int g = g(i);
            int i2 = this.f31a[i];
            long j = 1048575 & g;
            switch (f(g)) {
                case me.i38.gesture.m0.DragSortListView_click_remove_id /* 0 */:
                    if (c(obj2, i)) {
                        t3.a(obj, j, t3.a(obj2, j));
                        b(obj, i);
                        break;
                    } else {
                        break;
                    }
                case me.i38.gesture.m0.DragSortListView_collapsed_height /* 1 */:
                    if (c(obj2, i)) {
                        t3.a(obj, j, t3.b(obj2, j));
                        b(obj, i);
                        break;
                    } else {
                        break;
                    }
                case me.i38.gesture.m0.DragSortListView_drag_enabled /* 2 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.d(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_drag_handle_id /* 3 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.d(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_drag_scroll_start /* 4 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.c(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_drag_start_mode /* 5 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.d(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_drop_animation_duration /* 6 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.c(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_fling_handle_id /* 7 */:
                    if (c(obj2, i)) {
                        t3.c(obj, j, t3.h(obj2, j));
                        b(obj, i);
                        break;
                    } else {
                        break;
                    }
                case me.i38.gesture.m0.DragSortListView_float_alpha /* 8 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.e(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_float_background_color /* 9 */:
                case me.i38.gesture.m0.DragSortListView_use_default_controller /* 17 */:
                    a(obj, obj2, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_max_drag_scroll_speed /* 10 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.e(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_remove_animation_duration /* 11 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.c(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_remove_enabled /* 12 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.c(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_remove_mode /* 13 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.c(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_slide_shuffle_speed /* 14 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.d(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_sort_enabled /* 15 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.c(obj2, j));
                    b(obj, i);
                    break;
                case me.i38.gesture.m0.DragSortListView_track_drag_sort /* 16 */:
                    if (!c(obj2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.d(obj2, j));
                    b(obj, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.k.a(obj, obj2, j);
                    break;
                case 50:
                    int i3 = t2.e;
                    t3.a(obj, j, c2.a(t3.e(obj, j), t3.e(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!c(obj2, i2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.e(obj2, j));
                    b(obj, i2, i);
                    break;
                case 60:
                case 68:
                    b(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!c(obj2, i2, i)) {
                        break;
                    }
                    t3.a(obj, j, t3.e(obj2, j));
                    b(obj, i2, i);
                    break;
            }
        }
        t2.a(this.l, obj, obj2);
        if (this.f) {
            this.m.a(obj2);
            throw null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cf, code lost:
        if (r3 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e1, code lost:
        if (r3 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e3, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e7, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // a.a.a.a.a.a.r2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int c(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.k2.c(java.lang.Object):int");
    }

    @Override // a.a.a.a.a.a.r2
    public final Object d() {
        return ((e1) this.e).g();
    }

    @Override // a.a.a.a.a.a.r2
    public final boolean d(Object obj) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.i) {
            int i6 = this.h[i5];
            int i7 = this.f31a[i6];
            int g = g(i6);
            int i8 = this.f31a[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = o.getInt(obj, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if ((268435456 & g) != 0 && !a(obj, i6, i, i2, i10)) {
                return false;
            }
            int f = f(g);
            if (f != 9 && f != 17) {
                if (f != 27) {
                    if (f == 60 || f == 68) {
                        if (c(obj, i7, i6) && !a(obj, g, b(i6))) {
                            return false;
                        }
                    } else if (f != 49) {
                        if (f == 50 && !((a2) t3.e(obj, g & 1048575)).isEmpty()) {
                            z1 z1Var = (z1) c(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) t3.e(obj, g & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    r2 b2 = b(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!b2.d(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (a(obj, i6, i, i2, i10) && !a(obj, g, b(i6))) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        if (this.f) {
            this.m.a(obj);
            throw null;
        }
        return true;
    }
}
