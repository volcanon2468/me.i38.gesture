package a.a.a.a.a.a;

import a.a.a.a.a.a.k;
import a.a.a.a.a.a.l;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public abstract class l<MessageType extends l<MessageType, BuilderType>, BuilderType extends k<MessageType, BuilderType>> implements h2 {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(r2 r2Var) {
        throw null;
    }

    @Override // a.a.a.a.a.a.h2
    public final c0 a() {
        try {
            int e = e();
            c0 c0Var = c0.f9b;
            byte[] bArr = new byte[e];
            k0 b2 = k0.b(bArr, 0, e);
            a(b2);
            b2.a();
            return new y(bArr);
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e2);
        }
    }
}
