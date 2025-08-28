package a.a.a.a.a.a;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
abstract class e5 extends j {

    /* renamed from: a  reason: collision with root package name */
    private final int f16a;

    /* renamed from: b  reason: collision with root package name */
    private int f17b;

    /* JADX INFO: Access modifiers changed from: protected */
    public e5(int i, int i2) {
        c5.b(i2, i, "index");
        this.f16a = i;
        this.f17b = i2;
    }

    protected abstract Object a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f17b < this.f16a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f17b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int i = this.f17b;
            this.f17b = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i = this.f17b - 1;
            this.f17b = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f17b - 1;
    }
}
