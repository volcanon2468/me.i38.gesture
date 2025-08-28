package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class s0 {

    /* renamed from: a  reason: collision with root package name */
    private static final q0 f78a = new r0();

    /* renamed from: b  reason: collision with root package name */
    private static final q0 f79b;

    static {
        q0 q0Var;
        try {
            q0Var = (q0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            q0Var = null;
        }
        f79b = q0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0 a() {
        q0 q0Var = f79b;
        if (q0Var != null) {
            return q0Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0 b() {
        return f78a;
    }
}
