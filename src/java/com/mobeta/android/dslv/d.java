package com.mobeta.android.dslv;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.mobeta.android.dslv.DragSortListView;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class d implements DragSortListView.k {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f131a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f132b;
    private int c = -16777216;
    private ListView d;

    public d(ListView listView) {
        this.d = listView;
    }

    @Override // com.mobeta.android.dslv.DragSortListView.k
    public View a(int i) {
        ListView listView = this.d;
        View childAt = listView.getChildAt((i + listView.getHeaderViewsCount()) - this.d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f131a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f132b == null) {
            this.f132b = new ImageView(this.d.getContext());
        }
        this.f132b.setBackgroundColor(this.c);
        this.f132b.setPadding(0, 0, 0, 0);
        this.f132b.setImageBitmap(this.f131a);
        this.f132b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f132b;
    }

    @Override // com.mobeta.android.dslv.DragSortListView.k
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f131a.recycle();
        this.f131a = null;
    }

    public void b(int i) {
        this.c = i;
    }
}
