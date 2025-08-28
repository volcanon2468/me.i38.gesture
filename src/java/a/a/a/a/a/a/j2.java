package a.a.a.a.a.a;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class j2 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f27a;

    static {
        char[] cArr = new char[80];
        f27a = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(h2 h2Var, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(h2Var, sb, 0);
        return sb.toString();
    }

    private static void a(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(f27a, 0, i2);
            i -= i2;
        }
    }

    private static void a(h2 h2Var, StringBuilder sb, int i) {
        int i2;
        Object obj;
        Method method;
        String substring;
        Object a2;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = h2Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring2 = ((String) entry.getKey()).substring(i2);
            if (substring2.endsWith("List") && !substring2.endsWith("OrBuilderList") && !substring2.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                substring = substring2.substring(0, substring2.length() - 4);
                a2 = e1.a(method2, h2Var, new Object[0]);
            } else if (!substring2.endsWith("Map") || substring2.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                if (hashSet.contains("set".concat(String.valueOf(substring2))) && (!substring2.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring2.substring(0, substring2.length() - 5)))))) {
                    Method method4 = (Method) entry.getValue();
                    Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring2)));
                    if (method4 != null) {
                        Object a3 = e1.a(method4, h2Var, new Object[0]);
                        if (method5 != null) {
                            if (!((Boolean) e1.a(method5, h2Var, new Object[0])).booleanValue()) {
                            }
                            a(sb, i, substring2, a3);
                        } else if (a3 instanceof Boolean) {
                            if (!((Boolean) a3).booleanValue()) {
                            }
                            a(sb, i, substring2, a3);
                        } else if (a3 instanceof Integer) {
                            if (((Integer) a3).intValue() == 0) {
                            }
                            a(sb, i, substring2, a3);
                        } else if (a3 instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) a3).floatValue()) == 0) {
                            }
                            a(sb, i, substring2, a3);
                        } else if (a3 instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) a3).doubleValue()) == 0) {
                            }
                            a(sb, i, substring2, a3);
                        } else {
                            if (a3 instanceof String) {
                                obj = "";
                            } else if (a3 instanceof c0) {
                                obj = c0.f9b;
                            } else if (a3 instanceof h2) {
                                if (a3 == ((h2) a3).b()) {
                                }
                                a(sb, i, substring2, a3);
                            } else {
                                if ((a3 instanceof Enum) && ((Enum) a3).ordinal() == 0) {
                                }
                                a(sb, i, substring2, a3);
                            }
                            if (a3.equals(obj)) {
                            }
                            a(sb, i, substring2, a3);
                        }
                    }
                }
                i2 = 3;
            } else {
                substring = substring2.substring(0, substring2.length() - 3);
                a2 = e1.a(method, h2Var, new Object[0]);
            }
            a(sb, i, substring, a2);
            i2 = 3;
        }
        if (h2Var instanceof a1) {
            u0 u0Var = ((a1) h2Var).zzb;
            throw null;
        }
        k3 k3Var = ((e1) h2Var).zzc;
        if (k3Var != null) {
            k3Var.a(sb, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                a(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                a(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            a(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(h3.a(new y(((String) obj).getBytes(i1.f25a))));
                sb.append('\"');
            } else if (obj instanceof c0) {
                sb.append(": \"");
                sb.append(h3.a((c0) obj));
                sb.append('\"');
            } else if (obj instanceof e1) {
                sb.append(" {");
                a((e1) obj, sb, i + 2);
                sb.append("\n");
                a(i, sb);
                sb.append("}");
            } else if (!(obj instanceof Map.Entry)) {
                sb.append(": ");
                sb.append(obj);
            } else {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i3 = i + 2;
                a(sb, i3, "key", entry2.getKey());
                a(sb, i3, "value", entry2.getValue());
                sb.append("\n");
                a(i, sb);
                sb.append("}");
            }
        }
    }
}
