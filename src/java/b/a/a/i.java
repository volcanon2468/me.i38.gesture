package b.a.a;

import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import sun.misc.Unsafe;

@RequiresApi(28)
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f112a;

    /* renamed from: b  reason: collision with root package name */
    private static final long f113b;
    private static final long c;
    private static final long d;
    private static final long e;
    private static final Set f;

    static {
        boolean z = !i.class.desiredAssertionStatus();
        f = new HashSet();
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
            f112a = unsafe;
            if (!z && unsafe == null) {
                throw new AssertionError();
            }
            f113b = unsafe.objectFieldOffset(c.class.getDeclaredField("artMethod"));
            unsafe.objectFieldOffset(c.class.getDeclaredField("declaringClass"));
            long objectFieldOffset = unsafe.objectFieldOffset(f.class.getDeclaredField("artFieldOrMethod"));
            unsafe.objectFieldOffset(g.class.getDeclaredField("info"));
            long objectFieldOffset2 = unsafe.objectFieldOffset(b.class.getDeclaredField("methods"));
            c = objectFieldOffset2;
            unsafe.objectFieldOffset(d.class.getDeclaredField("member"));
            MethodHandle unreflect = MethodHandles.lookup().unreflect(h.class.getDeclaredMethod("a", new Class[0]));
            MethodHandle unreflect2 = MethodHandles.lookup().unreflect(h.class.getDeclaredMethod("b", new Class[0]));
            long j = unsafe.getLong(unreflect, objectFieldOffset);
            long j2 = unsafe.getLong(unreflect2, objectFieldOffset);
            long j3 = unsafe.getLong(h.class, objectFieldOffset2);
            long j4 = j2 - j;
            d = j4;
            e = (j - j3) - j4;
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static Object a(Class cls, Object obj, String str, Object... objArr) {
        if (obj == null || cls.isInstance(obj)) {
            Method declaredMethod = e.class.getDeclaredMethod("invoke", Object[].class);
            declaredMethod.setAccessible(true);
            Unsafe unsafe = f112a;
            long j = unsafe.getLong(cls, c);
            int i = unsafe.getInt(j);
            for (int i2 = 0; i2 < i; i2++) {
                f112a.putLong(declaredMethod, f113b, (i2 * d) + j + e);
                if (str.equals(declaredMethod.getName()) && a(declaredMethod.getParameterTypes(), objArr)) {
                    return declaredMethod.invoke(obj, objArr);
                }
            }
            throw new NoSuchMethodException("Cannot find matching method");
        }
        throw new IllegalArgumentException("this object is not an instance of the given class");
    }

    @VisibleForTesting
    static boolean a(Class[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr[i].isPrimitive()) {
                if (clsArr[i] == Integer.TYPE && !(objArr[i] instanceof Integer)) {
                    return false;
                }
                if (clsArr[i] == Byte.TYPE && !(objArr[i] instanceof Byte)) {
                    return false;
                }
                if (clsArr[i] == Character.TYPE && !(objArr[i] instanceof Character)) {
                    return false;
                }
                if (clsArr[i] == Boolean.TYPE && !(objArr[i] instanceof Boolean)) {
                    return false;
                }
                if (clsArr[i] == Double.TYPE && !(objArr[i] instanceof Double)) {
                    return false;
                }
                if (clsArr[i] == Float.TYPE && !(objArr[i] instanceof Float)) {
                    return false;
                }
                if (clsArr[i] == Long.TYPE && !(objArr[i] instanceof Long)) {
                    return false;
                }
                if (clsArr[i] == Short.TYPE && !(objArr[i] instanceof Short)) {
                    return false;
                }
            } else if (objArr[i] != null && !clsArr[i].isInstance(objArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String... strArr) {
        Set set = f;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[((HashSet) set).size()];
        set.toArray(strArr2);
        return b(strArr2);
    }

    public static boolean b(String... strArr) {
        try {
            a(VMRuntime.class, a(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (Throwable th) {
            Log.w("HiddenApiBypass", "setHiddenApiExemptions", th);
            return false;
        }
    }
}
