package me.i38.gesture.o0;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class i {
    public static String a(InputStream inputStream) {
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        while (true) {
            int read = inputStreamReader.read(cArr, 0, 1024);
            if (read <= 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }
}
