package a.a.a.a.a.a;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
abstract class x0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f94a = Logger.getLogger(k0.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final String f95b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    x0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p0 a(Class cls) {
        String format;
        ClassLoader classLoader = x0.class.getClassLoader();
        if (cls.equals(p0.class)) {
            format = f95b;
        } else if (!cls.getPackage().equals(x0.class.getPackage())) {
            throw new IllegalArgumentException(cls.getName());
        } else {
            format = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        try {
                            return (p0) cls.cast(((x0) Class.forName(format, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).a());
                        } catch (NoSuchMethodException e) {
                            throw new IllegalStateException(e);
                        }
                    } catch (InstantiationException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (IllegalAccessException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(x0.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((p0) cls.cast(((x0) it.next()).a()));
                } catch (ServiceConfigurationError e5) {
                    f94a.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(String.valueOf(cls.getSimpleName())), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (p0) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (p0) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    protected abstract p0 a();
}
