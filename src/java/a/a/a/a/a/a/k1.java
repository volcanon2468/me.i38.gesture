package a.a.a.a.a.a;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class k1 extends IOException {
    public k1(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public k1(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j1 a() {
        return new j1("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k1 b() {
        return new k1("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k1 c() {
        return new k1("Protocol message had invalid UTF-8.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k1 d() {
        return new k1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k1 e() {
        return new k1("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k1 f() {
        return new k1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final k1 a(h2 h2Var) {
        return this;
    }
}
