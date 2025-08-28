package me.i38.gesture;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class h0 extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f234a;

    /* renamed from: b  reason: collision with root package name */
    private List<i0> f235b;
    private AppCustomActivity c;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f236a;

        /* renamed from: b  reason: collision with root package name */
        TextView f237b;
        TextView c;
        ImageView d;
        Switch e;
    }

    public h0(Activity activity, List<i0> list) {
        this.c = (AppCustomActivity) activity;
        this.f234a = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.f235b = list;
    }

    public /* synthetic */ void a(int i, View view) {
        this.c.a(i, ((Switch) view).isChecked());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f235b.size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (view == null) {
            aVar = new a();
            view2 = this.f234a.inflate(2131165189, viewGroup, false);
            aVar.f237b = (TextView) view2.findViewById(2131099650);
            aVar.c = (TextView) view2.findViewById(2131099649);
            aVar.d = (ImageView) view2.findViewById(2131099648);
            aVar.e = (Switch) view2.findViewById(2131099651);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        aVar.f236a = i;
        aVar.f237b.setText(this.f235b.get(i).h());
        aVar.c.setText(this.f235b.get(i).g());
        aVar.d.setImageDrawable(this.f235b.get(i).f());
        aVar.e.setChecked(!TextUtils.isEmpty(this.f235b.get(i).e()));
        aVar.e.setOnClickListener(new View.OnClickListener() { // from class: me.i38.gesture.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                h0.this.a(i, view3);
            }
        });
        return view2;
    }
}
