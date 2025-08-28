package a.a.a.a.a.a;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f25a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f26b;

    static {
        Charset.forName("US-ASCII");
        f25a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f26b = bArr;
        ByteBuffer.wrap(bArr);
        byte[] bArr2 = f26b;
        int i = g0.f22a;
        int length = bArr2.length;
        try {
            new e0(bArr2, 0, 0, false, null).b(0);
        } catch (k1 e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static String a(byte[] bArr) {
        return new String(bArr, f25a);
    }
}
