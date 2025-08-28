package a.a.a.a.a.a;

import a.a.a.a.a.a.e1;
import a.a.a.a.a.a.z0;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class z0<MessageType extends e1<MessageType, BuilderType>, BuilderType extends z0<MessageType, BuilderType>> extends k<MessageType, BuilderType> {

    /* renamed from: a  reason: collision with root package name */
    private final e1 f108a;

    /* renamed from: b  reason: collision with root package name */
    protected e1 f109b;

    /* JADX INFO: Access modifiers changed from: protected */
    public z0(MessageType messagetype) {
        this.f108a = messagetype;
        if (messagetype.k()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f109b = this.f108a.g();
    }

    /* renamed from: a */
    public final z0 clone() {
        z0 z0Var = (z0) this.f108a.a(5, (Object) null, (Object) null);
        z0Var.f109b = d();
        return z0Var;
    }

    @Override // a.a.a.a.a.a.i2
    public final /* bridge */ /* synthetic */ h2 b() {
        throw null;
    }

    @Override // a.a.a.a.a.a.g2
    /* renamed from: e */
    public MessageType d() {
        if (this.f109b.k()) {
            this.f109b.h();
            return (MessageType) this.f109b;
        }
        return (MessageType) this.f109b;
    }

    public final MessageType f() {
        MessageType d = d();
        if (d.j()) {
            return d;
        }
        throw new i3(d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g() {
        if (this.f109b.k()) {
            return;
        }
        h();
    }

    protected void h() {
        e1 g = this.f108a.g();
        p2.a().a(g.getClass()).b(g, this.f109b);
        this.f109b = g;
    }
}
