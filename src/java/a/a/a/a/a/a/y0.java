package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class y0 implements f2 {

    /* renamed from: a  reason: collision with root package name */
    private static final y0 f101a = new y0();

    private y0() {
    }

    public static y0 a() {
        return f101a;
    }

    @Override // a.a.a.a.a.a.f2
    public final e2 a(Class cls) {
        if (e1.class.isAssignableFrom(cls)) {
            try {
                return (e2) e1.a(cls.asSubclass(e1.class)).a(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // a.a.a.a.a.a.f2
    public final boolean b(Class cls) {
        return e1.class.isAssignableFrom(cls);
    }
}
