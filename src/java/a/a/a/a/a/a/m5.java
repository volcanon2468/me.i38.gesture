package a.a.a.a.a.a;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class m5 {

    /* renamed from: a  reason: collision with root package name */
    Object[] f50a = new Object[8];

    /* renamed from: b  reason: collision with root package name */
    int f51b = 0;
    l5 c;

    public final m5 a(Object obj, Object obj2) {
        int i = this.f51b + 1;
        Object[] objArr = this.f50a;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int highestOneBit = Integer.highestOneBit(i2 - 1);
                i3 = highestOneBit + highestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.f50a = Arrays.copyOf(objArr, i3);
        }
        f5.a(obj, obj2);
        Object[] objArr2 = this.f50a;
        int i4 = this.f51b;
        int i5 = i4 + i4;
        objArr2[i5] = obj;
        objArr2[i5 + 1] = obj2;
        this.f51b = i4 + 1;
        return this;
    }

    public final n5 a() {
        l5 l5Var = this.c;
        if (l5Var == null) {
            g a2 = g.a(this.f51b, this.f50a, this);
            l5 l5Var2 = this.c;
            if (l5Var2 == null) {
                return a2;
            }
            throw l5Var2.a();
        }
        throw l5Var.a();
    }
}
