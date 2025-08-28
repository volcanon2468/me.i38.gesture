package a.a.a.a.a.a;

import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class y extends x {
    protected final byte[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(byte[] bArr) {
        if (bArr == null) {
            throw null;
        }
        this.c = bArr;
    }

    @Override // a.a.a.a.a.a.c0
    protected final int a(int i, int i2, int i3) {
        return i1.a(i, this.c, 0, i3);
    }

    @Override // a.a.a.a.a.a.c0
    public final c0 a(int i, int i2) {
        int b2 = c0.b(0, i2, b());
        return b2 == 0 ? c0.f9b : new v(this.c, 0, b2);
    }

    @Override // a.a.a.a.a.a.c0
    protected final String a(Charset charset) {
        return new String(this.c, 0, b(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.c0
    public final void a(r rVar) {
        ((h0) rVar).c(this.c, 0, b());
    }

    @Override // a.a.a.a.a.a.c0
    public int b() {
        return this.c.length;
    }

    @Override // a.a.a.a.a.a.c0
    public byte c(int i) {
        return this.c[i];
    }

    protected int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.a.a.a.a.a.c0
    public byte d(int i) {
        return this.c[i];
    }

    @Override // a.a.a.a.a.a.c0
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof c0) && b() == ((c0) obj).b()) {
            if (b() == 0) {
                return true;
            }
            if (obj instanceof y) {
                y yVar = (y) obj;
                int g = g();
                int g2 = yVar.g();
                if (g == 0 || g2 == 0 || g == g2) {
                    int b2 = b();
                    if (b2 > yVar.b()) {
                        int b3 = b();
                        throw new IllegalArgumentException("Length too large: " + b2 + b3);
                    } else if (b2 > yVar.b()) {
                        int b4 = yVar.b();
                        throw new IllegalArgumentException("Ran off end of other: 0, " + b2 + ", " + b4);
                    } else if (yVar instanceof y) {
                        byte[] bArr = this.c;
                        byte[] bArr2 = yVar.c;
                        yVar.c();
                        int i = 0;
                        int i2 = 0;
                        while (i < b2) {
                            if (bArr[i] != bArr2[i2]) {
                                return false;
                            }
                            i++;
                            i2++;
                        }
                        return true;
                    } else {
                        return yVar.a(0, b2).equals(a(0, b2));
                    }
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // a.a.a.a.a.a.c0
    public final boolean f() {
        return y3.b(this.c, 0, b());
    }
}
