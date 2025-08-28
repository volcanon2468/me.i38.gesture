package a.a.a.a.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class h0 extends k0 {
    private final byte[] e;
    private final int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(byte[] bArr, int i, int i2) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.e = bArr;
        this.g = 0;
        this.f = i2;
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(byte b2) {
        try {
            byte[] bArr = this.e;
            int i = this.g;
            this.g = i + 1;
            bArr[i] = b2;
        } catch (IndexOutOfBoundsException e) {
            throw new i0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
        }
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(int i) {
        try {
            byte[] bArr = this.e;
            int i2 = this.g;
            int i3 = i2 + 1;
            this.g = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            this.g = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            this.g = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.g = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new i0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
        }
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(int i, int i2) {
        c((i << 3) | 5);
        a(i2);
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(int i, long j) {
        c((i << 3) | 1);
        a(j);
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(int i, c0 c0Var) {
        c((i << 3) | 2);
        c(c0Var.b());
        c0Var.a(this);
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(int i, String str) {
        c((i << 3) | 2);
        b(str);
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(int i, boolean z) {
        c(i << 3);
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(long j) {
        try {
            byte[] bArr = this.e;
            int i = this.g;
            int i2 = i + 1;
            this.g = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i2 + 1;
            this.g = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i3 + 1;
            this.g = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i4 + 1;
            this.g = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i5 + 1;
            this.g = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            this.g = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            this.g = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.g = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new i0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
        }
    }

    @Override // a.a.a.a.a.a.k0
    public final void a(byte[] bArr, int i, int i2) {
        c(bArr, 0, i2);
    }

    @Override // a.a.a.a.a.a.k0
    public final int b() {
        return this.f - this.g;
    }

    @Override // a.a.a.a.a.a.k0
    public final void b(int i) {
        if (i >= 0) {
            c(i);
        } else {
            b(i);
        }
    }

    @Override // a.a.a.a.a.a.k0
    public final void b(int i, int i2) {
        c(i << 3);
        b(i2);
    }

    @Override // a.a.a.a.a.a.k0
    public final void b(int i, long j) {
        c(i << 3);
        b(j);
    }

    @Override // a.a.a.a.a.a.k0
    public final void b(long j) {
        boolean z;
        z = k0.c;
        if (z && this.f - this.g >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.e;
                int i = this.g;
                this.g = i + 1;
                t3.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.e;
            int i2 = this.g;
            this.g = i2 + 1;
            t3.a(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.e;
                int i3 = this.g;
                this.g = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new i0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
            }
        }
        byte[] bArr4 = this.e;
        int i4 = this.g;
        this.g = i4 + 1;
        bArr4[i4] = (byte) j;
    }

    public final void b(String str) {
        int i = this.g;
        try {
            int e = k0.e(str.length() * 3);
            int e2 = k0.e(str.length());
            if (e2 != e) {
                c(y3.a(str));
                byte[] bArr = this.e;
                int i2 = this.g;
                this.g = y3.a(str, bArr, i2, this.f - i2);
                return;
            }
            int i3 = i + e2;
            this.g = i3;
            int a2 = y3.a(str, this.e, i3, this.f - i3);
            this.g = i;
            c((a2 - i) - e2);
            this.g = a2;
        } catch (x3 e3) {
            this.g = i;
            a(str, e3);
        } catch (IndexOutOfBoundsException e4) {
            throw new i0(e4);
        }
    }

    @Override // a.a.a.a.a.a.k0
    public final void c(int i) {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.e;
                int i2 = this.g;
                this.g = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new i0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
            }
        }
        byte[] bArr2 = this.e;
        int i3 = this.g;
        this.g = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // a.a.a.a.a.a.k0
    public final void c(int i, int i2) {
        c((i << 3) | i2);
    }

    public final void c(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, 0, this.e, this.g, i2);
            this.g += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new i0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), Integer.valueOf(i2)), e);
        }
    }

    @Override // a.a.a.a.a.a.k0
    public final void d(int i, int i2) {
        c(i << 3);
        c(i2);
    }
}
