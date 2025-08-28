package a.a.a.a.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class v extends y {
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(byte[] bArr, int i, int i2) {
        super(bArr);
        c0.b(0, i2, bArr.length);
        this.d = i2;
    }

    @Override // a.a.a.a.a.a.y, a.a.a.a.a.a.c0
    public final int b() {
        return this.d;
    }

    @Override // a.a.a.a.a.a.y, a.a.a.a.a.a.c0
    public final byte c(int i) {
        int i2 = this.d;
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
        return this.c[i];
    }

    @Override // a.a.a.a.a.a.y
    protected final int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.y, a.a.a.a.a.a.c0
    public final byte d(int i) {
        return this.c[i];
    }
}
