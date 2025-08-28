package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class e0 extends g0 {

    /* renamed from: b  reason: collision with root package name */
    private int f15b;
    private int c;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e0(byte[] bArr, int i, int i2, boolean z, d0 d0Var) {
        super(null);
        this.d = Integer.MAX_VALUE;
        this.f15b = 0;
    }

    public final int b(int i) {
        int i2 = this.d;
        this.d = 0;
        int i3 = this.f15b + this.c;
        this.f15b = i3;
        if (i3 > 0) {
            this.c = i3;
            this.f15b = i3 - i3;
        } else {
            this.c = 0;
        }
        return i2;
    }
}
