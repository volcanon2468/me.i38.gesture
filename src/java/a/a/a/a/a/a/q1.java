package a.a.a.a.a.a;

import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class q1 extends u1 {
    private static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q1(p1 p1Var) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.u1
    public final void a(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) t3.e(obj, j);
        if (list instanceof o1) {
            unmodifiableList = ((o1) list).d();
        } else if (c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof o2) && (list instanceof h1)) {
                h1 h1Var = (h1) list;
                if (h1Var.c()) {
                    h1Var.a();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        t3.a(obj, j, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    @Override // a.a.a.a.a.a.u1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.lang.Object r6 = a.a.a.a.a.a.t3.e(r6, r7)
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            java.lang.Object r1 = a.a.a.a.a.a.t3.e(r5, r7)
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L39
            boolean r2 = r1 instanceof a.a.a.a.a.a.o1
            if (r2 == 0) goto L20
            a.a.a.a.a.a.n1 r1 = new a.a.a.a.a.a.n1
            r1.<init>(r0)
            goto L35
        L20:
            boolean r2 = r1 instanceof a.a.a.a.a.a.o2
            if (r2 == 0) goto L30
            boolean r2 = r1 instanceof a.a.a.a.a.a.h1
            if (r2 == 0) goto L30
            a.a.a.a.a.a.h1 r1 = (a.a.a.a.a.a.h1) r1
            a.a.a.a.a.a.h1 r0 = r1.a(r0)
            r1 = r0
            goto L35
        L30:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L35:
            a.a.a.a.a.a.t3.a(r5, r7, r1)
            goto L8a
        L39:
            java.lang.Class r2 = a.a.a.a.a.a.q1.c
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L57
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
        L52:
            a.a.a.a.a.a.t3.a(r5, r7, r2)
            r1 = r2
            goto L8a
        L57:
            boolean r2 = r1 instanceof a.a.a.a.a.a.o3
            if (r2 == 0) goto L6f
            a.a.a.a.a.a.n1 r2 = new a.a.a.a.a.a.n1
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            a.a.a.a.a.a.o3 r1 = (a.a.a.a.a.a.o3) r1
            int r0 = r2.size()
            r2.addAll(r0, r1)
            goto L52
        L6f:
            boolean r2 = r1 instanceof a.a.a.a.a.a.o2
            if (r2 == 0) goto L8a
            boolean r2 = r1 instanceof a.a.a.a.a.a.h1
            if (r2 == 0) goto L8a
            r2 = r1
            a.a.a.a.a.a.h1 r2 = (a.a.a.a.a.a.h1) r2
            boolean r3 = r2.c()
            if (r3 != 0) goto L8a
            int r1 = r1.size()
            int r1 = r1 + r0
            a.a.a.a.a.a.h1 r1 = r2.a(r1)
            goto L35
        L8a:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L99
            if (r2 <= 0) goto L99
            r1.addAll(r6)
        L99:
            if (r0 > 0) goto L9c
            goto L9d
        L9c:
            r6 = r1
        L9d:
            a.a.a.a.a.a.t3.a(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.q1.a(java.lang.Object, java.lang.Object, long):void");
    }
}
