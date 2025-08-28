package a.a.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class u0 {
    private static final u0 d = new u0(true);

    /* renamed from: a  reason: collision with root package name */
    final f3 f85a = new u2(16);

    /* renamed from: b  reason: collision with root package name */
    private boolean f86b;
    private boolean c;

    private u0() {
    }

    private u0(boolean z) {
        a();
        a();
    }

    public static u0 b() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void b(a.a.a.a.a.a.t0 r4, java.lang.Object r5) {
        /*
            a.a.a.a.a.a.z3 r0 = r4.a()
            byte[] r1 = a.a.a.a.a.a.i1.f26b
            if (r5 == 0) goto L6f
            a.a.a.a.a.a.z3 r1 = a.a.a.a.a.a.z3.DOUBLE
            a.a.a.a.a.a.a4 r1 = a.a.a.a.a.a.a4.INT
            a.a.a.a.a.a.a4 r0 = r0.b()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L3a;
                case 1: goto L37;
                case 2: goto L34;
                case 3: goto L31;
                case 4: goto L2e;
                case 5: goto L2b;
                case 6: goto L22;
                case 7: goto L1d;
                case 8: goto L18;
                default: goto L17;
            }
        L17:
            goto L3f
        L18:
            boolean r0 = r5 instanceof a.a.a.a.a.a.h2
            if (r0 != 0) goto L3e
            goto L3f
        L1d:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L3e
            goto L3f
        L22:
            boolean r0 = r5 instanceof a.a.a.a.a.a.c0
            if (r0 != 0) goto L3e
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L3f
            goto L3e
        L2b:
            boolean r0 = r5 instanceof java.lang.String
            goto L3c
        L2e:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L3c
        L31:
            boolean r0 = r5 instanceof java.lang.Double
            goto L3c
        L34:
            boolean r0 = r5 instanceof java.lang.Float
            goto L3c
        L37:
            boolean r0 = r5 instanceof java.lang.Long
            goto L3c
        L3a:
            boolean r0 = r5 instanceof java.lang.Integer
        L3c:
            if (r0 == 0) goto L3f
        L3e:
            return
        L3f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.b()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            r2 = 1
            a.a.a.a.a.a.z3 r4 = r4.a()
            a.a.a.a.a.a.a4 r4 = r4.b()
            r1[r2] = r4
            r4 = 2
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r1[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        L6f:
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.u0.b(a.a.a.a.a.a.t0, java.lang.Object):void");
    }

    public final void a() {
        if (this.f86b) {
            return;
        }
        for (int i = 0; i < this.f85a.b(); i++) {
            Map.Entry a2 = this.f85a.a(i);
            if (a2.getValue() instanceof e1) {
                ((e1) a2.getValue()).h();
            }
        }
        this.f85a.a();
        this.f86b = true;
    }

    public final void a(t0 t0Var, Object obj) {
        if (!t0Var.c()) {
            b(t0Var, obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                b(t0Var, arrayList.get(i));
            }
            obj = arrayList;
        }
        this.f85a.put(t0Var, obj);
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        u0 u0Var = new u0();
        for (int i = 0; i < this.f85a.b(); i++) {
            Map.Entry a2 = this.f85a.a(i);
            u0Var.a((t0) a2.getKey(), a2.getValue());
        }
        for (Map.Entry entry : this.f85a.c()) {
            u0Var.a((t0) entry.getKey(), entry.getValue());
        }
        u0Var.c = this.c;
        return u0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u0) {
            return this.f85a.equals(((u0) obj).f85a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f85a.hashCode();
    }
}
