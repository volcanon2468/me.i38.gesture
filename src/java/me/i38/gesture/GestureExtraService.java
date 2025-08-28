package me.i38.gesture;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class GestureExtraService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static GestureExtraService f146a;

    /* renamed from: b  reason: collision with root package name */
    public static Intent f147b;
    private static MediaProjectionManager c;
    private static MediaProjection d;
    private static ImageReader e;
    private static VirtualDisplay f;
    private static byte[] g;
    private static int h;
    private static int i;
    private static boolean j;
    private static boolean k;

    public static String a(int i2, int i3) {
        Log.d("gesturelog", "pick" + i2 + "," + i3);
        byte[] bArr = g;
        if (bArr != null) {
            int length = bArr.length;
            int i4 = i;
            int i5 = h;
            return length > ((i3 * i4) + (i2 * i5)) + 3 ? me.i38.gesture.o0.k.a(bArr, (i3 * i4) + (i2 * i5), 3) : "";
        }
        return "";
    }

    public static void a() {
        f147b = null;
    }

    public static void a(boolean z) {
        Context g2 = GestureApplication.g();
        if (!z || f146a != null) {
            if (z || f146a == null) {
                return;
            }
            g2.stopService(new Intent(g2, GestureExtraService.class));
        } else if (!c()) {
            Toast.makeText(GestureApplication.g(), 2131296498, 0).show();
        } else if (Build.VERSION.SDK_INT >= 26) {
            g2.startForegroundService(new Intent(g2, GestureExtraService.class));
        } else {
            g2.startService(new Intent(g2, GestureExtraService.class));
        }
    }

    private void a(boolean z, String str) {
        if (Build.VERSION.SDK_INT < 26 || !z) {
            GestureApplication.a(this, 0, str, null, 199);
        } else {
            startForeground(199, GestureApplication.a(this, 0, str, null));
        }
    }

    public static boolean a(String str) {
        boolean z = false;
        if (g != null && !me.i38.gesture.o0.k.a(str)) {
            String[] split = str.split(",");
            boolean z2 = split.length / 3 > 0;
            int i2 = 0;
            while (true) {
                if (i2 >= split.length / 3) {
                    z = z2;
                    break;
                }
                int i3 = i2 * 3;
                int a2 = (me.i38.gesture.o0.k.a((Object) split[i3 + 1]) * i) + (me.i38.gesture.o0.k.a((Object) split[i3]) * h);
                byte[] bArr = g;
                if (bArr.length > a2 + 3 && !me.i38.gesture.o0.k.a(bArr, a2, 3).equalsIgnoreCase(split[i3 + 2])) {
                    break;
                }
                i2++;
            }
            if (me.i38.gesture.o0.k.f281a > 0) {
                Log.d("gesturelog", "pixel[" + str + "]:" + z);
            }
        }
        return z;
    }

    public static MediaProjectionManager b() {
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) me.i38.gesture.o0.k.c(c, (MediaProjectionManager) GestureApplication.g().getSystemService("media_projection"));
        c = mediaProjectionManager;
        return mediaProjectionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ImageReader imageReader) {
        try {
            Image acquireLatestImage = imageReader.acquireLatestImage();
            if (acquireLatestImage == null || acquireLatestImage.getFormat() != 1) {
                return;
            }
            Image.Plane[] planes = acquireLatestImage.getPlanes();
            if (planes.length > 0 && f != null) {
                h = planes[0].getPixelStride();
                i = planes[0].getRowStride();
                g = new byte[planes[0].getBuffer().remaining()];
                if (me.i38.gesture.o0.k.f281a > 1) {
                    Log.d("gesturelog", "image:" + h + "," + i + "," + planes.length + "," + g.length);
                }
                planes[0].getBuffer().get(g);
            }
            acquireLatestImage.close();
        } catch (Exception e2) {
            Log.d("gesturelog", "onScreenFrame", e2);
        }
    }

    public static boolean c() {
        return f147b != null;
    }

    public static void d() {
        k = true;
        a(true);
    }

    public static void e() {
        j = true;
        a(true);
    }

    public static void f() {
        k = false;
        if (j) {
            return;
        }
        a(false);
    }

    public static void g() {
        j = false;
        if (k) {
            return;
        }
        a(false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    @SuppressLint({"WrongConstant"})
    public void onCreate() {
        super.onCreate();
        f146a = this;
        Log.d("gesturelog", "GestureExtraService create");
        a(true, getString(2131296497));
        try {
            d = (MediaProjection) me.i38.gesture.o0.k.c(d, b().getMediaProjection(-1, f147b));
            DisplayMetrics m = GestureApplication.m();
            if (e == null || e.getHeight() != m.heightPixels || e.getWidth() != m.widthPixels) {
                ImageReader newInstance = ImageReader.newInstance(m.widthPixels, m.heightPixels, 1, 2);
                e = newInstance;
                newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: me.i38.gesture.k
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader) {
                        GestureExtraService.b(imageReader);
                    }
                }, null);
            }
            if (f == null) {
                f = d.createVirtualDisplay("gestureprj", m.widthPixels, m.heightPixels, m.densityDpi, 8, e.getSurface(), null, null);
            } else {
                f.setSurface(e.getSurface());
            }
        } catch (Exception e2) {
            Log.d("gesturelog", "GestureExtraService:", e2);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("gesturelog", "GestureExtraService destroy");
        try {
            if (f != null) {
                f.setSurface(null);
                f.release();
                f = null;
            }
            if (d != null) {
                d.stop();
                d = null;
            }
        } catch (Exception unused) {
        }
        g = null;
        f146a = null;
        super.onDestroy();
    }
}
