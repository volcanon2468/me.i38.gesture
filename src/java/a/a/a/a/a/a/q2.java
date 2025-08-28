package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class q2 implements e2 {

    /* renamed from: a  reason: collision with root package name */
    private final h2 f72a;

    /* renamed from: b  reason: collision with root package name */
    private final String f73b;
    private final Object[] c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q2(h2 h2Var, String str, Object[] objArr) {
        this.f72a = h2Var;
        this.f73b = str;
        this.c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 < 55296) {
                this.d = i | (charAt2 << i3);
                return;
            }
            i |= (charAt2 & 8191) << i3;
            i3 += 13;
            i2 = i4;
        }
    }

    @Override // a.a.a.a.a.a.e2
    public final boolean a() {
        return (this.d & 2) == 2;
    }

    @Override // a.a.a.a.a.a.e2
    public final h2 b() {
        return this.f72a;
    }

    @Override // a.a.a.a.a.a.e2
    public final int c() {
        return (this.d & 1) == 1 ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f73b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.c;
    }
}
