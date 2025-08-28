package a.a.a.a.a.a;

import a.a.a.a.a.a.e1;
import a.a.a.a.a.a.z0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public abstract class e1<MessageType extends e1<MessageType, BuilderType>, BuilderType extends z0<MessageType, BuilderType>> extends l<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected k3 zzc = k3.e();

    private static e1 a(e1 e1Var, byte[] bArr, int i, int i2, p0 p0Var) {
        e1 g = e1Var.g();
        try {
            r2 a2 = p2.a().a(g.getClass());
            a2.a(g, bArr, 0, i2, new o(p0Var));
            a2.a(g);
            return g;
        } catch (i3 e) {
            k1 a3 = e.a();
            a3.a(g);
            throw a3;
        } catch (k1 e2) {
            e2.a(g);
            throw e2;
        } catch (IOException e3) {
            if (e3.getCause() instanceof k1) {
                throw ((k1) e3.getCause());
            }
            k1 k1Var = new k1(e3);
            k1Var.a(g);
            throw k1Var;
        } catch (IndexOutOfBoundsException unused) {
            k1 f = k1.f();
            f.a(g);
            throw f;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static e1 a(e1 e1Var, byte[] bArr, p0 p0Var) {
        e1 a2 = a(e1Var, bArr, 0, bArr.length, p0Var);
        if (a2 == null || a2.j()) {
            return a2;
        }
        k1 a3 = new i3(a2).a();
        a3.a(a2);
        throw a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e1 a(Class cls) {
        e1 e1Var = (e1) zzb.get(cls);
        if (e1Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                e1Var = (e1) zzb.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (e1Var == null) {
            e1Var = (e1) ((e1) t3.b(cls)).a(6, (Object) null, (Object) null);
            if (e1Var == null) {
                throw new IllegalStateException();
            }
            zzb.put(cls, e1Var);
        }
        return e1Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(h2 h2Var, String str, Object[] objArr) {
        return new q2(h2Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Class cls, e1 e1Var) {
        e1Var.i();
        zzb.put(cls, e1Var);
    }

    private final int b(r2 r2Var) {
        if (r2Var == null) {
            return p2.a().a(getClass()).b(this);
        }
        return r2Var.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.l
    public final int a(r2 r2Var) {
        if (k()) {
            int b2 = b(r2Var);
            if (b2 >= 0) {
                return b2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + b2);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int b3 = b(r2Var);
        if (b3 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | b3;
            return b3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + b3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(int i, Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // a.a.a.a.a.a.h2
    public final void a(k0 k0Var) {
        p2.a().a(getClass()).a((Object) this, (b4) l0.a(k0Var));
    }

    @Override // a.a.a.a.a.a.i2
    public final /* synthetic */ h2 b() {
        return (e1) a(6, (Object) null, (Object) null);
    }

    @Override // a.a.a.a.a.a.h2
    public final /* synthetic */ g2 c() {
        return (z0) a(5, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final z0 d() {
        return (z0) a(5, (Object) null, (Object) null);
    }

    @Override // a.a.a.a.a.a.h2
    public final int e() {
        int i;
        if (k()) {
            i = b(null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = b(null);
                if (i < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
            }
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return p2.a().a(getClass()).a(this, (e1) obj);
        }
        return false;
    }

    final int f() {
        return p2.a().a(getClass()).c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e1 g() {
        return (e1) a(4, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        p2.a().a(getClass()).a(this);
        i();
    }

    public final int hashCode() {
        if (k()) {
            return f();
        }
        int i = this.zza;
        if (i == 0) {
            int f = f();
            this.zza = f;
            return f;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final boolean j() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) a(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d = p2.a().a(getClass()).d(this);
        if (booleanValue) {
            a(2, true != d ? null : this, (Object) null);
            return d;
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final String toString() {
        return j2.a(this, super.toString());
    }
}
