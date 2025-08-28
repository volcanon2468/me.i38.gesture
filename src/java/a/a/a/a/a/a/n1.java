package a.a.a.a.a.a;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class n1 extends m implements RandomAccess, o1 {
    private static final n1 c = new n1(false);

    /* renamed from: b  reason: collision with root package name */
    private final List f53b;

    public n1() {
        this(10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(int i) {
        super(true);
        ArrayList arrayList = new ArrayList(i);
        this.f53b = arrayList;
    }

    private n1(ArrayList arrayList) {
        super(true);
        this.f53b = arrayList;
    }

    private n1(boolean z) {
        super(false);
        this.f53b = Collections.emptyList();
    }

    private static String a(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof c0 ? ((c0) obj).b(i1.f25a) : i1.a((byte[]) obj);
    }

    @Override // a.a.a.a.a.a.h1
    public final /* bridge */ /* synthetic */ h1 a(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f53b);
            return new n1(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        b();
        this.f53b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        b();
        if (collection instanceof o1) {
            collection = ((o1) collection).e();
        }
        boolean addAll = this.f53b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // a.a.a.a.a.a.o1
    public final Object b(int i) {
        return this.f53b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c */
    public final String get(int i) {
        Object obj = this.f53b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            String b2 = c0Var.b(i1.f25a);
            if (c0Var.f()) {
                this.f53b.set(i, b2);
            }
            return b2;
        }
        byte[] bArr = (byte[]) obj;
        String a2 = i1.a(bArr);
        if (y3.a(bArr)) {
            this.f53b.set(i, a2);
        }
        return a2;
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        this.f53b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // a.a.a.a.a.a.o1
    public final o1 d() {
        return c() ? new o3(this) : this;
    }

    @Override // a.a.a.a.a.a.o1
    public final List e() {
        return Collections.unmodifiableList(this.f53b);
    }

    @Override // a.a.a.a.a.a.m, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        b();
        Object remove = this.f53b.remove(i);
        ((AbstractList) this).modCount++;
        return a(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        b();
        return a(this.f53b.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f53b.size();
    }
}
