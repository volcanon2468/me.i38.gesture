package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public enum v0 {
    DOUBLE(0, 1, l1.DOUBLE),
    FLOAT(1, 1, l1.FLOAT),
    INT64(2, 1, l1.LONG),
    UINT64(3, 1, l1.LONG),
    INT32(4, 1, l1.INT),
    FIXED64(5, 1, l1.LONG),
    FIXED32(6, 1, l1.INT),
    BOOL(7, 1, l1.BOOLEAN),
    STRING(8, 1, l1.STRING),
    MESSAGE(9, 1, l1.MESSAGE),
    BYTES(10, 1, l1.BYTE_STRING),
    UINT32(11, 1, l1.INT),
    ENUM(12, 1, l1.ENUM),
    SFIXED32(13, 1, l1.INT),
    SFIXED64(14, 1, l1.LONG),
    SINT32(15, 1, l1.INT),
    SINT64(16, 1, l1.LONG),
    GROUP(17, 1, l1.MESSAGE),
    DOUBLE_LIST(18, 2, l1.DOUBLE),
    FLOAT_LIST(19, 2, l1.FLOAT),
    INT64_LIST(20, 2, l1.LONG),
    UINT64_LIST(21, 2, l1.LONG),
    INT32_LIST(22, 2, l1.INT),
    FIXED64_LIST(23, 2, l1.LONG),
    FIXED32_LIST(24, 2, l1.INT),
    BOOL_LIST(25, 2, l1.BOOLEAN),
    STRING_LIST(26, 2, l1.STRING),
    MESSAGE_LIST(27, 2, l1.MESSAGE),
    BYTES_LIST(28, 2, l1.BYTE_STRING),
    UINT32_LIST(29, 2, l1.INT),
    ENUM_LIST(30, 2, l1.ENUM),
    SFIXED32_LIST(31, 2, l1.INT),
    SFIXED64_LIST(32, 2, l1.LONG),
    SINT32_LIST(33, 2, l1.INT),
    SINT64_LIST(34, 2, l1.LONG),
    DOUBLE_LIST_PACKED(35, 3, l1.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, l1.FLOAT),
    INT64_LIST_PACKED(37, 3, l1.LONG),
    UINT64_LIST_PACKED(38, 3, l1.LONG),
    INT32_LIST_PACKED(39, 3, l1.INT),
    FIXED64_LIST_PACKED(40, 3, l1.LONG),
    FIXED32_LIST_PACKED(41, 3, l1.INT),
    BOOL_LIST_PACKED(42, 3, l1.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, l1.INT),
    ENUM_LIST_PACKED(44, 3, l1.ENUM),
    SFIXED32_LIST_PACKED(45, 3, l1.INT),
    SFIXED64_LIST_PACKED(46, 3, l1.LONG),
    SINT32_LIST_PACKED(47, 3, l1.INT),
    SINT64_LIST_PACKED(48, 3, l1.LONG),
    GROUP_LIST(49, 2, l1.MESSAGE),
    MAP(50, 4, l1.VOID);
    
    private static final v0[] a0;

    /* renamed from: a  reason: collision with root package name */
    private final int f91a;

    static {
        v0[] values = values();
        a0 = new v0[values.length];
        for (v0 v0Var : values) {
            a0[v0Var.f91a] = v0Var;
        }
    }

    v0(int i, int i2, l1 l1Var) {
        this.f91a = i;
        l1 l1Var2 = l1.VOID;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            l1Var.b();
        }
        if (i2 == 1) {
            l1Var.ordinal();
        }
    }

    public final int b() {
        return this.f91a;
    }
}
