package a.a.a.a.a.a;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class t3 {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f83a = b();

    /* renamed from: b  reason: collision with root package name */
    private static final Class f84b;
    private static final boolean c;
    private static final s3 d;
    private static final boolean e;
    private static final boolean f;
    static final long g;
    static final boolean h;

    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0148  */
    static {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.t3.<clinit>():void");
    }

    private t3() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a(Object obj, long j) {
        return d.a(obj, j);
    }

    private static int a(Class cls) {
        if (f) {
            return d.f80a.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field a() {
        int i = n.f52a;
        Field a2 = a(Buffer.class, "effectiveDirectAddress");
        if (a2 == null) {
            Field a3 = a(Buffer.class, "address");
            if (a3 == null || a3.getType() != Long.TYPE) {
                return null;
            }
            return a3;
        }
        return a2;
    }

    private static Field a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = d.f80a.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        d.f80a.putInt(obj, j2, ((255 & b2) << i2) | (i & (~(255 << i2))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, double d2) {
        d.a(obj, j, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, float f2) {
        d.a(obj, j, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, int i) {
        d.f80a.putInt(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, long j2) {
        d.f80a.putLong(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, Object obj2) {
        d.f80a.putObject(obj, j, obj2);
    }

    static /* bridge */ /* synthetic */ void a(Throwable th) {
        Logger.getLogger(t3.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j, byte b2) {
        d.a((Object) bArr, g + j, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(Object obj, long j) {
        return d.b(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object b(Class cls) {
        try {
            return f83a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe b() {
        try {
            return (Unsafe) AccessController.doPrivileged(new p3());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        d.f80a.putInt(obj, j2, ((255 & b2) << i) | (d.f80a.getInt(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(Object obj, long j) {
        return d.f80a.getInt(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Object obj, long j, boolean z) {
        d.a(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean c(Class cls) {
        int i = n.f52a;
        try {
            Class cls2 = f84b;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int d(Class cls) {
        if (f) {
            return d.f80a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long d(Object obj, long j) {
        return d.f80a.getLong(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object e(Object obj, long j) {
        return d.f80a.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean f(Object obj, long j) {
        return ((byte) ((d.f80a.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean g(Object obj, long j) {
        return ((byte) ((d.f80a.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Object obj, long j) {
        return d.c(obj, j);
    }
}
