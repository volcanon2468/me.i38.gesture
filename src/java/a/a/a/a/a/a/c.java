package a.a.a.a.a.a;

import java.util.AbstractMap;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class c extends k5 {
    final /* synthetic */ d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.d = dVar;
    }

    @Override // a.a.a.a.a.a.h5
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.d.e;
        c5.a(i, i2, "index");
        d dVar = this.d;
        objArr = dVar.d;
        int i3 = i + i;
        Object obj = objArr[i3];
        obj.getClass();
        objArr2 = dVar.d;
        Object obj2 = objArr2[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.d.e;
        return i;
    }
}
