package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class f5 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("null key in entry: null=");
            sb.append(obj2);
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        } else if (obj2 != null) {
        } else {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }
}
