package me.i38.gesture;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class j0 extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f242a;

    /* renamed from: b  reason: collision with root package name */
    private List<i0> f243b;
    private me.i38.gesture.components.a c;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f244a;

        a(int i) {
            this.f244a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            j0.this.c.a(this.f244a);
            return false;
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        TextView f246a;

        /* renamed from: b  reason: collision with root package name */
        TextView f247b;
        ImageView c;

        b() {
        }
    }

    public j0(Context context, List<i0> list) {
        this(context, list, null);
    }

    public j0(Context context, List<i0> list, me.i38.gesture.components.a aVar) {
        this.f242a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f243b = list;
        this.c = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f243b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b();
            view2 = this.f242a.inflate(2131165192, viewGroup, false);
            bVar.f246a = (TextView) view2.findViewById(2131099667);
            bVar.f247b = (TextView) view2.findViewById(2131099665);
            bVar.c = (ImageView) view2.findViewById(2131099666);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        bVar.f246a.setText(this.f243b.get(i).h());
        String d = this.f243b.get(i).d();
        bVar.f247b.setVisibility(TextUtils.isEmpty(d) ? 8 : 0);
        bVar.f247b.setText(d);
        bVar.c.setImageDrawable(this.f243b.get(i).f());
        if (this.c != null) {
            bVar.c.setOnLongClickListener(new a(i));
        }
        return view2;
    }
}
