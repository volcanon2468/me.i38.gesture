package me.i38.gesture;

import android.graphics.drawable.Drawable;
import java.text.Collator;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class i0 implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    private String f239a;

    /* renamed from: b  reason: collision with root package name */
    private String f240b;
    private String c;
    private String d;
    private Drawable e;

    public i0(String str, String str2, Drawable drawable) {
        this(str, str2, "", null, drawable);
    }

    public i0(String str, String str2, String str3, String str4, Drawable drawable) {
        this.c = str;
        this.f239a = str2;
        this.f240b = str3;
        this.d = str4;
        this.e = drawable;
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Collator.getInstance(Locale.CHINESE).compare(this.f239a, ((i0) obj).f239a);
    }

    public String d() {
        return this.f240b;
    }

    public String e() {
        return this.d;
    }

    public Drawable f() {
        return this.e;
    }

    public String g() {
        return this.c;
    }

    public String h() {
        return this.f239a;
    }
}
