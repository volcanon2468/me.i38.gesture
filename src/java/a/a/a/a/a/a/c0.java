package a.a.a.a.a.a;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public abstract class c0 implements Iterable, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f9b = new y(i1.f26b);

    /* renamed from: a  reason: collision with root package name */
    private int f10a = 0;

    static {
        int i = n.f52a;
        new a0(null);
        new t();
    }

    public static c0 a(byte[] bArr, int i, int i2) {
        b(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new y(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) < 0) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
            } else if (i2 < i) {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
            } else {
                throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
            }
        }
        return i4;
    }

    protected abstract int a(int i, int i2, int i3);

    public abstract c0 a(int i, int i2);

    protected abstract String a(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(r rVar);

    public abstract int b();

    public final String b(Charset charset) {
        return b() == 0 ? "" : a(charset);
    }

    public abstract byte c(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte d(int i);

    public abstract boolean equals(Object obj);

    public abstract boolean f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        return this.f10a;
    }

    public final int hashCode() {
        int i = this.f10a;
        if (i == 0) {
            int b2 = b();
            i = a(b2, 0, b2);
            if (i == 0) {
                i = 1;
            }
            this.f10a = i;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new s(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(b());
        objArr[2] = b() <= 50 ? h3.a(this) : h3.a(a(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
