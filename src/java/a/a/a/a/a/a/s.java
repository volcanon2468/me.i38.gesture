package a.a.a.a.a.a;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class s extends u {

    /* renamed from: a  reason: collision with root package name */
    private int f76a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f77b;
    final /* synthetic */ c0 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(c0 c0Var) {
        this.c = c0Var;
        this.f77b = this.c.b();
    }

    @Override // a.a.a.a.a.a.w
    public final byte b() {
        int i = this.f76a;
        if (i < this.f77b) {
            this.f76a = i + 1;
            return this.c.d(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f76a < this.f77b;
    }
}
