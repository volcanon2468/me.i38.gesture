package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public enum z3 {
    DOUBLE(a4.DOUBLE, 1),
    FLOAT(a4.FLOAT, 5),
    INT64(a4.LONG, 0),
    UINT64(a4.LONG, 0),
    INT32(a4.INT, 0),
    FIXED64(a4.LONG, 1),
    FIXED32(a4.INT, 5),
    BOOL(a4.BOOLEAN, 0),
    STRING(a4.STRING, 2),
    GROUP(a4.MESSAGE, 3),
    MESSAGE(a4.MESSAGE, 2),
    BYTES(a4.BYTE_STRING, 2),
    UINT32(a4.INT, 0),
    ENUM(a4.ENUM, 0),
    SFIXED32(a4.INT, 5),
    SFIXED64(a4.LONG, 1),
    SINT32(a4.INT, 0),
    SINT64(a4.LONG, 0);
    

    /* renamed from: a  reason: collision with root package name */
    private final a4 f111a;

    z3(a4 a4Var, int i) {
        this.f111a = a4Var;
    }

    public final a4 b() {
        return this.f111a;
    }
}
