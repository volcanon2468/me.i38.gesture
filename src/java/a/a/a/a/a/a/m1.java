package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class m1 {

    /* renamed from: a  reason: collision with root package name */
    protected volatile h2 f46a;

    /* renamed from: b  reason: collision with root package name */
    private volatile c0 f47b;

    static {
        p0 p0Var = p0.c;
    }

    public final int a() {
        if (this.f47b != null) {
            return ((y) this.f47b).c.length;
        }
        if (this.f46a != null) {
            return this.f46a.e();
        }
        return 0;
    }

    protected final void a(h2 h2Var) {
        if (this.f46a != null) {
            return;
        }
        synchronized (this) {
            if (this.f46a == null) {
                try {
                    this.f46a = h2Var;
                    this.f47b = c0.f9b;
                } catch (k1 unused) {
                    this.f46a = h2Var;
                    this.f47b = c0.f9b;
                }
            }
        }
    }

    public final c0 b() {
        if (this.f47b != null) {
            return this.f47b;
        }
        synchronized (this) {
            if (this.f47b != null) {
                return this.f47b;
            }
            this.f47b = this.f46a == null ? c0.f9b : this.f46a.a();
            return this.f47b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m1) {
            m1 m1Var = (m1) obj;
            h2 h2Var = this.f46a;
            h2 h2Var2 = m1Var.f46a;
            if (h2Var == null && h2Var2 == null) {
                return b().equals(m1Var.b());
            }
            if (h2Var == null || h2Var2 == null) {
                if (h2Var != null) {
                    m1Var.a(h2Var.b());
                    return h2Var.equals(m1Var.f46a);
                }
                a(h2Var2.b());
                return this.f46a.equals(h2Var2);
            }
            return h2Var.equals(h2Var2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }
}
