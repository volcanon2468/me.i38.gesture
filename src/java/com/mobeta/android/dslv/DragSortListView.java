package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import me.i38.gesture.m0;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class DragSortListView extends ListView {
    private float A;
    private float B;
    private int C;
    private int D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private e J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private k Q;
    private MotionEvent R;
    private int S;
    private float T;
    private float U;
    private c V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    private View f114a;
    private h a0;

    /* renamed from: b  reason: collision with root package name */
    private Point f115b;
    private boolean b0;
    private Point c;
    private boolean c0;
    private int d;
    private l d0;
    private boolean e;
    private n e0;
    private DataSetObserver f;
    private m f0;
    private float g;
    private i g0;
    private float h;
    private boolean h0;
    private int i;
    private float i0;
    private int j;
    private boolean j0;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private d p;
    private j q;
    private o r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private View[] y;
    private f z;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a implements e {
        a() {
        }

        @Override // com.mobeta.android.dslv.DragSortListView.e
        public float a(float f, long j) {
            return DragSortListView.this.I * f;
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class b extends DataSetObserver {
        b() {
        }

        private void a() {
            if (DragSortListView.this.t == 4) {
                DragSortListView.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class c extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private ListAdapter f118a;

        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        class a extends DataSetObserver {
            a(DragSortListView dragSortListView) {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                c.this.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                c.this.notifyDataSetInvalidated();
            }
        }

        public c(ListAdapter listAdapter) {
            this.f118a = listAdapter;
            listAdapter.registerDataSetObserver(new a(DragSortListView.this));
        }

        public ListAdapter a() {
            return this.f118a;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.f118a.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f118a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f118a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.f118a.getItemId(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.f118a.getItemViewType(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            com.mobeta.android.dslv.b bVar;
            if (view != null) {
                bVar = (com.mobeta.android.dslv.b) view;
                View childAt = bVar.getChildAt(0);
                View view2 = this.f118a.getView(i, childAt, DragSortListView.this);
                if (view2 != childAt) {
                    if (childAt != null) {
                        bVar.removeViewAt(0);
                    }
                    bVar.addView(view2);
                }
            } else {
                View view3 = this.f118a.getView(i, null, DragSortListView.this);
                com.mobeta.android.dslv.b cVar = view3 instanceof Checkable ? new com.mobeta.android.dslv.c(DragSortListView.this.getContext()) : new com.mobeta.android.dslv.b(DragSortListView.this.getContext());
                cVar.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                cVar.addView(view3);
                bVar = cVar;
            }
            DragSortListView dragSortListView = DragSortListView.this;
            dragSortListView.a(i + dragSortListView.getHeaderViewsCount(), (View) bVar, true);
            return bVar;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.f118a.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.f118a.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.f118a.isEmpty();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.f118a.isEnabled(i);
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public interface d {
        void a(int i, int i2);
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public interface e {
        float a(float f, long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f121a;

        /* renamed from: b  reason: collision with root package name */
        private long f122b;
        private long c;
        private int d;
        private float e;
        private long f;
        private int g;
        private float h;
        private boolean i = false;

        public f() {
        }

        public int a() {
            if (this.i) {
                return this.g;
            }
            return -1;
        }

        public void a(int i) {
            if (this.i) {
                return;
            }
            this.f121a = false;
            this.i = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f = uptimeMillis;
            this.f122b = uptimeMillis;
            this.g = i;
            DragSortListView.this.post(this);
        }

        public void a(boolean z) {
            if (!z) {
                this.f121a = true;
                return;
            }
            DragSortListView.this.removeCallbacks(this);
            this.i = false;
        }

        public boolean b() {
            return this.i;
        }

        @Override // java.lang.Runnable
        public void run() {
            float f;
            if (this.f121a) {
                this.i = false;
                return;
            }
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int min = Math.min(DragSortListView.this.L, DragSortListView.this.d + DragSortListView.this.w);
            int max = Math.max(DragSortListView.this.L, DragSortListView.this.d - DragSortListView.this.w);
            if (this.g == 0) {
                View childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.i = false;
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.i = false;
                    return;
                } else {
                    f = DragSortListView.this.J.a((DragSortListView.this.F - max) / DragSortListView.this.G, this.f122b);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.i = false;
                    return;
                } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                    this.i = false;
                    return;
                } else {
                    f = -DragSortListView.this.J.a((min - DragSortListView.this.E) / DragSortListView.this.H, this.f122b);
                }
            }
            this.h = f;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.c = uptimeMillis;
            float f2 = (float) (uptimeMillis - this.f122b);
            this.e = f2;
            int round = Math.round(this.h * f2);
            this.d = round;
            if (round >= 0) {
                this.d = Math.min(height, round);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.d = Math.max(-height, round);
            }
            View childAt3 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            int top = childAt3.getTop() + this.d;
            if (lastVisiblePosition == 0 && top > paddingTop) {
                top = paddingTop;
            }
            DragSortListView.this.b0 = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.b0 = false;
            DragSortListView.this.c(lastVisiblePosition, childAt3, false);
            this.f122b = this.c;
            DragSortListView.this.post(this);
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public interface g extends j, d, o {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class h {

        /* renamed from: b  reason: collision with root package name */
        File f124b;

        /* renamed from: a  reason: collision with root package name */
        StringBuilder f123a = new StringBuilder();
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        public h() {
            File file = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            this.f124b = file;
            if (file.exists()) {
                return;
            }
            try {
                this.f124b.createNewFile();
                Log.d("mobeta", "file created");
            } catch (IOException e) {
                Log.w("mobeta", "Could not create dslv_state.txt");
                Log.d("mobeta", e.getMessage());
            }
        }

        public void a() {
            if (this.e) {
                this.f123a.append("<DSLVState>\n");
                int childCount = DragSortListView.this.getChildCount();
                int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
                this.f123a.append("    <Positions>");
                for (int i = 0; i < childCount; i++) {
                    StringBuilder sb = this.f123a;
                    sb.append(firstVisiblePosition + i);
                    sb.append(",");
                }
                this.f123a.append("</Positions>\n");
                this.f123a.append("    <Tops>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    StringBuilder sb2 = this.f123a;
                    sb2.append(DragSortListView.this.getChildAt(i2).getTop());
                    sb2.append(",");
                }
                this.f123a.append("</Tops>\n");
                this.f123a.append("    <Bottoms>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    StringBuilder sb3 = this.f123a;
                    sb3.append(DragSortListView.this.getChildAt(i3).getBottom());
                    sb3.append(",");
                }
                this.f123a.append("</Bottoms>\n");
                StringBuilder sb4 = this.f123a;
                sb4.append("    <FirstExpPos>");
                sb4.append(DragSortListView.this.j);
                sb4.append("</FirstExpPos>\n");
                StringBuilder sb5 = this.f123a;
                sb5.append("    <FirstExpBlankHeight>");
                DragSortListView dragSortListView = DragSortListView.this;
                int d = dragSortListView.d(dragSortListView.j);
                DragSortListView dragSortListView2 = DragSortListView.this;
                sb5.append(d - dragSortListView2.c(dragSortListView2.j));
                sb5.append("</FirstExpBlankHeight>\n");
                StringBuilder sb6 = this.f123a;
                sb6.append("    <SecondExpPos>");
                sb6.append(DragSortListView.this.k);
                sb6.append("</SecondExpPos>\n");
                StringBuilder sb7 = this.f123a;
                sb7.append("    <SecondExpBlankHeight>");
                DragSortListView dragSortListView3 = DragSortListView.this;
                int d2 = dragSortListView3.d(dragSortListView3.k);
                DragSortListView dragSortListView4 = DragSortListView.this;
                sb7.append(d2 - dragSortListView4.c(dragSortListView4.k));
                sb7.append("</SecondExpBlankHeight>\n");
                StringBuilder sb8 = this.f123a;
                sb8.append("    <SrcPos>");
                sb8.append(DragSortListView.this.m);
                sb8.append("</SrcPos>\n");
                StringBuilder sb9 = this.f123a;
                sb9.append("    <SrcHeight>");
                sb9.append(DragSortListView.this.v + DragSortListView.this.getDividerHeight());
                sb9.append("</SrcHeight>\n");
                StringBuilder sb10 = this.f123a;
                sb10.append("    <ViewHeight>");
                sb10.append(DragSortListView.this.getHeight());
                sb10.append("</ViewHeight>\n");
                StringBuilder sb11 = this.f123a;
                sb11.append("    <LastY>");
                sb11.append(DragSortListView.this.M);
                sb11.append("</LastY>\n");
                StringBuilder sb12 = this.f123a;
                sb12.append("    <FloatY>");
                sb12.append(DragSortListView.this.d);
                sb12.append("</FloatY>\n");
                this.f123a.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    StringBuilder sb13 = this.f123a;
                    DragSortListView dragSortListView5 = DragSortListView.this;
                    sb13.append(dragSortListView5.c(firstVisiblePosition + i4, dragSortListView5.getChildAt(i4).getTop()));
                    sb13.append(",");
                }
                this.f123a.append("</ShuffleEdges>\n");
                this.f123a.append("</DSLVState>\n");
                int i5 = this.c + 1;
                this.c = i5;
                if (i5 > 1000) {
                    b();
                    this.c = 0;
                }
            }
        }

        public void b() {
            if (this.e) {
                try {
                    FileWriter fileWriter = new FileWriter(this.f124b, this.d != 0);
                    fileWriter.write(this.f123a.toString());
                    this.f123a.delete(0, this.f123a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.d++;
                } catch (IOException unused) {
                }
            }
        }

        public void c() {
            this.f123a.append("<DSLVStates>\n");
            this.d = 0;
            this.e = true;
        }

        public void d() {
            if (this.e) {
                this.f123a.append("</DSLVStates>\n");
                b();
                this.e = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class i extends p {
        private int j;
        private int k;
        private float l;
        private float m;

        public i(float f, int i) {
            super(f, i);
        }

        private int e() {
            int bottom;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int dividerHeight = (DragSortListView.this.u + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.j - firstVisiblePosition);
            if (childAt == null) {
                a();
                return -1;
            }
            int i = this.j;
            int i2 = this.k;
            if (i == i2) {
                return childAt.getTop();
            }
            if (i < i2) {
                bottom = childAt.getTop();
            } else {
                bottom = childAt.getBottom() + dividerHeight;
                dividerHeight = DragSortListView.this.v;
            }
            return bottom - dividerHeight;
        }

        @Override // com.mobeta.android.dslv.DragSortListView.p
        public void a(float f, float f2) {
            int e = e();
            float paddingLeft = DragSortListView.this.f115b.x - DragSortListView.this.getPaddingLeft();
            float f3 = 1.0f - f2;
            if (f3 < Math.abs((DragSortListView.this.f115b.y - e) / this.l) || f3 < Math.abs(paddingLeft / this.m)) {
                DragSortListView.this.f115b.y = e + ((int) (this.l * f3));
                DragSortListView.this.f115b.x = DragSortListView.this.getPaddingLeft() + ((int) (this.m * f3));
                DragSortListView.this.b(true);
            }
        }

        @Override // com.mobeta.android.dslv.DragSortListView.p
        public void b() {
            this.j = DragSortListView.this.i;
            this.k = DragSortListView.this.m;
            DragSortListView.this.t = 2;
            this.l = DragSortListView.this.f115b.y - e();
            this.m = DragSortListView.this.f115b.x - DragSortListView.this.getPaddingLeft();
        }

        @Override // com.mobeta.android.dslv.DragSortListView.p
        public void c() {
            DragSortListView.this.j();
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public interface j {
        void b(int i, int i2);
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public interface k {
        View a(int i);

        void a(View view);

        void a(View view, Point point, Point point2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class l {

        /* renamed from: a  reason: collision with root package name */
        private SparseIntArray f125a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<Integer> f126b;
        private int c;

        public l(DragSortListView dragSortListView, int i) {
            this.f125a = new SparseIntArray(i);
            this.f126b = new ArrayList<>(i);
            this.c = i;
        }

        public int a(int i) {
            return this.f125a.get(i, -1);
        }

        public void a() {
            this.f125a.clear();
            this.f126b.clear();
        }

        public void a(int i, int i2) {
            int i3 = this.f125a.get(i, -1);
            if (i3 != i2) {
                if (i3 != -1) {
                    this.f126b.remove(Integer.valueOf(i));
                } else if (this.f125a.size() == this.c) {
                    this.f125a.delete(this.f126b.remove(0).intValue());
                }
                this.f125a.put(i, i2);
                this.f126b.add(Integer.valueOf(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class m extends p {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class n extends p {
        private float j;
        private float k;
        private float l;
        private int m;
        private int n;
        private int o;
        private int p;

        public n(float f, int i) {
            super(f, i);
            this.m = -1;
            this.n = -1;
        }

        @Override // com.mobeta.android.dslv.DragSortListView.p
        public void a(float f, float f2) {
            View childAt;
            float f3 = 1.0f - f2;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt2 = DragSortListView.this.getChildAt(this.o - firstVisiblePosition);
            if (DragSortListView.this.h0) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f127a)) / 1000.0f;
                if (uptimeMillis == 0.0f) {
                    return;
                }
                float f4 = DragSortListView.this.i0 * uptimeMillis;
                int width = DragSortListView.this.getWidth();
                DragSortListView dragSortListView = DragSortListView.this;
                float f5 = (dragSortListView.i0 > 0.0f ? 1 : -1) * uptimeMillis;
                float f6 = width;
                DragSortListView.b(dragSortListView, f5 * f6);
                this.j += f4;
                Point point = DragSortListView.this.f115b;
                float f7 = this.j;
                point.x = (int) f7;
                if (f7 < f6 && f7 > (-width)) {
                    this.f127a = SystemClock.uptimeMillis();
                    DragSortListView.this.b(true);
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.m == -1) {
                    this.m = DragSortListView.this.d(this.o, childAt2, false);
                    this.k = childAt2.getHeight() - this.m;
                }
                int max = Math.max((int) (this.k * f3), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = this.m + max;
                childAt2.setLayoutParams(layoutParams);
            }
            int i = this.p;
            if (i == this.o || (childAt = DragSortListView.this.getChildAt(i - firstVisiblePosition)) == null) {
                return;
            }
            if (this.n == -1) {
                this.n = DragSortListView.this.d(this.p, childAt, false);
                this.l = childAt.getHeight() - this.n;
            }
            int max2 = Math.max((int) (f3 * this.l), 1);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            layoutParams2.height = this.n + max2;
            childAt.setLayoutParams(layoutParams2);
        }

        @Override // com.mobeta.android.dslv.DragSortListView.p
        public void b() {
            this.m = -1;
            this.n = -1;
            this.o = DragSortListView.this.j;
            this.p = DragSortListView.this.k;
            int unused = DragSortListView.this.m;
            DragSortListView.this.t = 1;
            this.j = DragSortListView.this.f115b.x;
            if (!DragSortListView.this.h0) {
                DragSortListView.this.g();
                return;
            }
            float width = DragSortListView.this.getWidth() * 2.0f;
            if (DragSortListView.this.i0 == 0.0f) {
                DragSortListView.this.i0 = (this.j >= 0.0f ? 1 : -1) * width;
                return;
            }
            float f = width * 2.0f;
            if (DragSortListView.this.i0 < 0.0f) {
                float f2 = -f;
                if (DragSortListView.this.i0 > f2) {
                    DragSortListView.this.i0 = f2;
                    return;
                }
            }
            if (DragSortListView.this.i0 <= 0.0f || DragSortListView.this.i0 >= f) {
                return;
            }
            DragSortListView.this.i0 = f;
        }

        @Override // com.mobeta.android.dslv.DragSortListView.p
        public void c() {
            DragSortListView.this.i();
        }
    }

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public interface o {
        void remove(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    public class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        protected long f127a;

        /* renamed from: b  reason: collision with root package name */
        private float f128b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private boolean h;

        public p(float f, int i) {
            this.c = f;
            this.f128b = i;
            float f2 = 1.0f / ((f * 2.0f) * (1.0f - f));
            this.g = f2;
            this.d = f2;
            this.e = f / ((f - 1.0f) * 2.0f);
            this.f = 1.0f / (1.0f - f);
        }

        public float a(float f) {
            float f2 = this.c;
            if (f < f2) {
                return this.d * f * f;
            }
            if (f < 1.0f - f2) {
                return this.e + (this.f * f);
            }
            float f3 = f - 1.0f;
            return 1.0f - ((this.g * f3) * f3);
        }

        public void a() {
            this.h = true;
        }

        public void a(float f, float f2) {
            throw null;
        }

        public void b() {
            throw null;
        }

        public void c() {
            throw null;
        }

        public void d() {
            this.f127a = SystemClock.uptimeMillis();
            this.h = false;
            b();
            DragSortListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f127a)) / this.f128b;
            if (uptimeMillis >= 1.0f) {
                a(1.0f, 1.0f);
                c();
                return;
            }
            a(uptimeMillis, a(uptimeMillis));
            DragSortListView.this.post(this);
        }
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.f115b = new Point();
        this.c = new Point();
        this.e = false;
        this.g = 1.0f;
        this.h = 1.0f;
        this.l = false;
        this.s = true;
        this.t = 0;
        this.u = 1;
        this.x = 0;
        this.y = new View[1];
        this.A = 0.33333334f;
        this.B = 0.33333334f;
        this.I = 0.5f;
        this.J = new a();
        this.N = 0;
        this.O = false;
        this.P = false;
        this.Q = null;
        this.S = 0;
        this.T = 0.25f;
        this.U = 0.0f;
        this.W = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = new l(this, 3);
        this.i0 = 0.0f;
        this.j0 = false;
        int i3 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m0.DragSortListView, 0, 0);
            this.u = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(1, 1));
            boolean z = obtainStyledAttributes.getBoolean(16, false);
            this.W = z;
            if (z) {
                this.a0 = new h();
            }
            float f2 = obtainStyledAttributes.getFloat(8, this.g);
            this.g = f2;
            this.h = f2;
            this.s = obtainStyledAttributes.getBoolean(2, this.s);
            float max = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(14, 0.75f)));
            this.T = max;
            this.l = max > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(4, this.A));
            this.I = obtainStyledAttributes.getFloat(10, this.I);
            int i4 = obtainStyledAttributes.getInt(11, 150);
            i2 = obtainStyledAttributes.getInt(6, 150);
            if (obtainStyledAttributes.getBoolean(17, true)) {
                boolean z2 = obtainStyledAttributes.getBoolean(12, false);
                int i5 = obtainStyledAttributes.getInt(13, 1);
                boolean z3 = obtainStyledAttributes.getBoolean(15, true);
                int i6 = obtainStyledAttributes.getInt(5, 0);
                int resourceId = obtainStyledAttributes.getResourceId(3, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(7, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(0, 0);
                int color = obtainStyledAttributes.getColor(9, -16777216);
                com.mobeta.android.dslv.a aVar = new com.mobeta.android.dslv.a(this, resourceId, i6, i5, resourceId3, resourceId2);
                aVar.a(z2);
                aVar.b(z3);
                aVar.b(color);
                this.Q = aVar;
                setOnTouchListener(aVar);
            }
            obtainStyledAttributes.recycle();
            i3 = i4;
        } else {
            i2 = 150;
        }
        this.z = new f();
        if (i3 > 0) {
            this.e0 = new n(0.5f, i3);
        }
        if (i2 > 0) {
            this.g0 = new i(0.5f, i2);
        }
        this.R = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f = new b();
    }

    private int a(int i2, int i3) {
        getDividerHeight();
        boolean z = this.l && this.j != this.k;
        int i4 = this.v;
        int i5 = this.u;
        int i6 = i4 - i5;
        int i7 = (int) (this.U * i6);
        int i8 = this.m;
        return i2 == i8 ? i8 == this.j ? z ? i7 + i5 : i4 : i8 == this.k ? i4 - i7 : i5 : i2 == this.j ? z ? i3 + i7 : i3 + i6 : i2 == this.k ? (i3 + i6) - i7 : i3;
    }

    private int a(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int c2 = c(i2);
        int height = view.getHeight();
        int a2 = a(i2, c2);
        if (i2 != this.m) {
            i5 = height - c2;
            i6 = a2 - c2;
        } else {
            i5 = height;
            i6 = a2;
        }
        int i7 = this.v;
        int i8 = this.m;
        if (i8 != this.j && i8 != this.k) {
            i7 -= this.u;
        }
        if (i2 <= i3) {
            if (i2 > this.j) {
                return 0 + (i7 - i6);
            }
            return 0;
        } else if (i2 == i4) {
            if (i2 <= this.j) {
                i5 -= i7;
            } else if (i2 == this.k) {
                return 0 + (height - a2);
            }
            return 0 + i5;
        } else if (i2 <= this.j) {
            return 0 - i7;
        } else {
            if (i2 == this.k) {
                return 0 - i6;
            }
            return 0;
        }
    }

    private void a(int i2, Canvas canvas) {
        ViewGroup viewGroup;
        int i3;
        int i4;
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider == null || dividerHeight == 0 || (viewGroup = (ViewGroup) getChildAt(i2 - getFirstVisiblePosition())) == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = viewGroup.getChildAt(0).getHeight();
        if (i2 > this.m) {
            i4 = viewGroup.getTop() + height;
            i3 = dividerHeight + i4;
        } else {
            int bottom = viewGroup.getBottom() - height;
            int i5 = bottom - dividerHeight;
            i3 = bottom;
            i4 = i5;
        }
        canvas.save();
        canvas.clipRect(paddingLeft, i4, width, i3);
        divider.setBounds(paddingLeft, i4, width, i3);
        divider.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, View view, boolean z) {
        com.mobeta.android.dslv.b bVar;
        int i3;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int b2 = (i2 == this.m || i2 == this.j || i2 == this.k) ? b(i2, view, z) : -2;
        if (b2 != layoutParams.height) {
            layoutParams.height = b2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.j || i2 == this.k) {
            int i4 = this.m;
            if (i2 < i4) {
                bVar = (com.mobeta.android.dslv.b) view;
                i3 = 80;
            } else if (i2 > i4) {
                bVar = (com.mobeta.android.dslv.b) view;
                i3 = 48;
            }
            bVar.setGravity(i3);
        }
        int visibility = view.getVisibility();
        int i5 = 0;
        if (i2 == this.m && this.f114a != null) {
            i5 = 4;
        }
        if (i5 != visibility) {
            view.setVisibility(i5);
        }
    }

    private void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.x, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        int i2 = layoutParams.height;
        view.measure(childMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    static /* synthetic */ float b(DragSortListView dragSortListView, float f2) {
        float f3 = dragSortListView.i0 + f2;
        dragSortListView.i0 = f3;
        return f3;
    }

    private int b(int i2, View view, boolean z) {
        return a(i2, d(i2, view, z));
    }

    private void b(int i2) {
        this.t = 1;
        o oVar = this.r;
        if (oVar != null) {
            oVar.remove(i2);
        }
        g();
        e();
        f();
        this.t = this.P ? 3 : 0;
    }

    private void b(int i2, int i3) {
        Point point = this.f115b;
        point.x = i2 - this.n;
        point.y = i3 - this.o;
        b(true);
        int min = Math.min(i3, this.d + this.w);
        int max = Math.max(i3, this.d - this.w);
        int a2 = this.z.a();
        if (min > this.M && min > this.D && a2 != 1) {
            if (a2 != -1) {
                this.z.a(true);
            }
            this.z.a(1);
        } else if (max < this.M && max < this.C && a2 != 0) {
            if (a2 != -1) {
                this.z.a(true);
            }
            this.z.a(0);
        } else if (max < this.C || min > this.D || !this.z.b()) {
        } else {
            this.z.a(true);
        }
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.M = this.L;
        }
        this.K = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.L = y;
        if (action == 0) {
            this.M = y;
        }
        motionEvent.getRawX();
        motionEvent.getRawY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt == null) {
            return;
        }
        c(firstVisiblePosition, childAt, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i2) {
        View view;
        if (i2 == this.m) {
            return 0;
        }
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        if (childAt != null) {
            return d(i2, childAt, false);
        }
        int a2 = this.d0.a(i2);
        if (a2 != -1) {
            return a2;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i2);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.y.length) {
            this.y = new View[viewTypeCount];
        }
        if (itemViewType >= 0) {
            View[] viewArr = this.y;
            if (viewArr[itemViewType] == null) {
                view = adapter.getView(i2, null, this);
                this.y[itemViewType] = view;
            } else {
                view = adapter.getView(i2, viewArr[itemViewType], this);
            }
        } else {
            view = adapter.getView(i2, null, this);
        }
        int d2 = d(i2, view, true);
        this.d0.a(i2, d2);
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r8 <= r7.m) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c(int r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.getHeaderViewsCount()
            int r1 = r7.getFooterViewsCount()
            if (r8 <= r0) goto L6d
            int r0 = r7.getCount()
            int r0 = r0 - r1
            if (r8 < r0) goto L12
            goto L6d
        L12:
            int r0 = r7.getDividerHeight()
            int r1 = r7.v
            int r2 = r7.u
            int r1 = r1 - r2
            int r2 = r7.c(r8)
            int r3 = r7.d(r8)
            int r4 = r7.k
            int r5 = r7.m
            if (r4 > r5) goto L42
            if (r8 != r4) goto L38
            int r6 = r7.j
            if (r6 == r4) goto L38
            if (r8 != r5) goto L35
            int r9 = r9 + r3
            int r1 = r7.v
            goto L40
        L35:
            int r3 = r3 - r2
            int r9 = r9 + r3
            goto L40
        L38:
            int r3 = r7.k
            if (r8 <= r3) goto L54
            int r3 = r7.m
            if (r8 > r3) goto L54
        L40:
            int r9 = r9 - r1
            goto L54
        L42:
            if (r8 <= r5) goto L4a
            int r4 = r7.j
            if (r8 > r4) goto L4a
            int r9 = r9 + r1
            goto L54
        L4a:
            int r1 = r7.k
            if (r8 != r1) goto L54
            int r4 = r7.j
            if (r4 == r1) goto L54
            int r3 = r3 - r2
            int r9 = r9 + r3
        L54:
            int r1 = r7.m
            if (r8 > r1) goto L66
            int r1 = r7.v
            int r1 = r1 - r0
            int r8 = r8 + (-1)
            int r8 = r7.c(r8)
            int r1 = r1 - r8
            int r1 = r1 / 2
            int r9 = r9 + r1
            goto L6d
        L66:
            int r2 = r2 - r0
            int r8 = r7.v
            int r2 = r2 - r8
            int r2 = r2 / 2
            int r9 = r9 + r2
        L6d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobeta.android.dslv.DragSortListView.c(int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2, View view, boolean z) {
        this.b0 = true;
        l();
        int i3 = this.j;
        int i4 = this.k;
        boolean m2 = m();
        if (m2) {
            d();
            setSelectionFromTop(i2, (view.getTop() + a(i2, view, i3, i4)) - getPaddingTop());
            layoutChildren();
        }
        if (m2 || z) {
            invalidate();
        }
        this.b0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i2) {
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        return childAt != null ? childAt.getHeight() : a(i2, c(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(int i2, View view, boolean z) {
        int i3;
        if (i2 == this.m) {
            return 0;
        }
        if (i2 >= getHeaderViewsCount() && i2 < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || (i3 = layoutParams.height) <= 0) {
            int height = view.getHeight();
            if (height == 0 || z) {
                a(view);
                return view.getMeasuredHeight();
            }
            return height;
        }
        return i3;
    }

    private void d() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    private void e() {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.m < firstVisiblePosition) {
            View childAt = getChildAt(0);
            setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - getPaddingTop());
        }
    }

    private void f() {
        this.m = -1;
        this.j = -1;
        this.k = -1;
        this.i = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        View view = this.f114a;
        if (view != null) {
            view.setVisibility(8);
            k kVar = this.Q;
            if (kVar != null) {
                kVar.a(this.f114a);
            }
            this.f114a = null;
            invalidate();
        }
    }

    private void h() {
        this.S = 0;
        this.P = false;
        if (this.t == 3) {
            this.t = 0;
        }
        this.h = this.g;
        this.j0 = false;
        this.d0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        b(this.m - getHeaderViewsCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int i2;
        this.t = 2;
        if (this.q != null && (i2 = this.i) >= 0 && i2 < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.q.b(this.m - headerViewsCount, this.i - headerViewsCount);
        }
        g();
        e();
        f();
        d();
        this.t = this.P ? 3 : 0;
    }

    private void k() {
        View view = this.f114a;
        if (view != null) {
            a(view);
            int measuredHeight = this.f114a.getMeasuredHeight();
            this.v = measuredHeight;
            this.w = measuredHeight / 2;
        }
    }

    private void l() {
        int i2;
        int i3;
        if (this.Q != null) {
            this.c.set(this.K, this.L);
            this.Q.a(this.f114a, this.f115b, this.c);
        }
        Point point = this.f115b;
        int i4 = point.x;
        int i5 = point.y;
        int paddingLeft = getPaddingLeft();
        if (((this.N & 1) == 0 && i4 > paddingLeft) || ((this.N & 2) == 0 && i4 < paddingLeft)) {
            this.f115b.x = paddingLeft;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int paddingTop = getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.N & 8) == 0 && firstVisiblePosition <= (i3 = this.m)) {
            paddingTop = Math.max(getChildAt(i3 - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            height = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.N & 4) == 0 && lastVisiblePosition >= (i2 = this.m)) {
            height = Math.min(getChildAt(i2 - firstVisiblePosition).getBottom(), height);
        }
        if (i5 < paddingTop) {
            this.f115b.y = paddingTop;
        } else {
            int i6 = this.v;
            if (i5 + i6 > height) {
                this.f115b.y = height - i6;
            }
        }
        this.d = this.f115b.y + this.w;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m() {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobeta.android.dslv.DragSortListView.m():boolean");
    }

    private void n() {
        int height;
        int paddingTop = getPaddingTop();
        float height2 = (getHeight() - paddingTop) - getPaddingBottom();
        float f2 = paddingTop;
        float f3 = (this.A * height2) + f2;
        this.F = f3;
        float f4 = ((1.0f - this.B) * height2) + f2;
        this.E = f4;
        this.C = (int) f3;
        this.D = (int) f4;
        this.G = f3 - f2;
        this.H = (paddingTop + height) - f4;
    }

    public void a() {
        if (this.t == 4) {
            this.z.a(true);
            g();
            f();
            d();
            this.t = this.P ? 3 : 0;
        }
    }

    public void a(float f2, float f3) {
        if (f3 > 0.5f) {
            this.B = 0.5f;
        } else {
            this.B = f3;
        }
        if (f2 > 0.5f) {
            this.A = 0.5f;
        } else {
            this.A = f2;
        }
        if (getHeight() != 0) {
            n();
        }
    }

    public void a(int i2) {
        this.h0 = false;
        a(i2, 0.0f);
    }

    public void a(int i2, float f2) {
        int i3 = this.t;
        if (i3 == 0 || i3 == 4) {
            if (this.t == 0) {
                int headerViewsCount = getHeaderViewsCount() + i2;
                this.m = headerViewsCount;
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                this.i = headerViewsCount;
                View childAt = getChildAt(headerViewsCount - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.t = 1;
            this.i0 = f2;
            if (this.P) {
                int i4 = this.S;
                if (i4 == 1) {
                    super.onTouchEvent(this.R);
                } else if (i4 == 2) {
                    super.onInterceptTouchEvent(this.R);
                }
            }
            n nVar = this.e0;
            if (nVar != null) {
                nVar.d();
            } else {
                b(i2);
            }
        }
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        k kVar;
        View a2;
        if (!this.P || (kVar = this.Q) == null || (a2 = kVar.a(i2)) == null) {
            return false;
        }
        return a(i2, a2, i3, i4, i5);
    }

    public boolean a(int i2, View view, int i3, int i4, int i5) {
        if (this.t == 0 && this.P && this.f114a == null && view != null && this.s) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = i2 + getHeaderViewsCount();
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            this.m = headerViewsCount;
            this.i = headerViewsCount;
            this.t = 4;
            this.N = 0;
            this.N = i3 | 0;
            this.f114a = view;
            k();
            this.n = i4;
            this.o = i5;
            int i6 = this.L;
            Point point = this.f115b;
            point.x = this.K - i4;
            point.y = i6 - i5;
            View childAt = getChildAt(this.m - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.W) {
                this.a0.c();
            }
            int i7 = this.S;
            if (i7 == 1) {
                super.onTouchEvent(this.R);
            } else if (i7 == 2) {
                super.onInterceptTouchEvent(this.R);
            }
            requestLayout();
            m mVar = this.f0;
            if (mVar != null) {
                mVar.d();
            }
            return true;
        }
        return false;
    }

    protected boolean a(MotionEvent motionEvent) {
        motionEvent.getAction();
        int action = motionEvent.getAction() & 255;
        if (action != 1) {
            if (action == 2) {
                b((int) motionEvent.getX(), (int) motionEvent.getY());
            } else if (action == 3) {
                if (this.t == 4) {
                    a();
                }
            }
            return true;
        } else if (this.t == 4) {
            a(false);
        }
        h();
        return true;
    }

    public boolean a(boolean z) {
        this.h0 = false;
        return a(z, 0.0f);
    }

    public boolean a(boolean z, float f2) {
        if (this.f114a != null) {
            this.z.a(true);
            if (z) {
                a(this.m - getHeaderViewsCount(), f2);
            } else {
                i iVar = this.g0;
                if (iVar != null) {
                    iVar.d();
                } else {
                    j();
                }
            }
            if (this.W) {
                this.a0.d();
            }
            return true;
        }
        return false;
    }

    public boolean b() {
        return this.s;
    }

    public boolean b(boolean z, float f2) {
        this.h0 = true;
        return a(z, f2);
    }

    public boolean c() {
        return this.j0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f2;
        super.dispatchDraw(canvas);
        if (this.t != 0) {
            int i2 = this.j;
            if (i2 != this.m) {
                a(i2, canvas);
            }
            int i3 = this.k;
            if (i3 != this.j && i3 != this.m) {
                a(i3, canvas);
            }
        }
        View view = this.f114a;
        if (view != null) {
            int width = view.getWidth();
            int height = this.f114a.getHeight();
            int i4 = this.f115b.x;
            int width2 = getWidth();
            if (i4 < 0) {
                i4 = -i4;
            }
            if (i4 < width2) {
                float f3 = (width2 - i4) / width2;
                f2 = f3 * f3;
            } else {
                f2 = 0.0f;
            }
            canvas.save();
            Point point = this.f115b;
            canvas.translate(point.x, point.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, (int) (this.h * 255.0f * f2), 31);
            this.f114a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    public float getFloatAlpha() {
        return this.h;
    }

    public ListAdapter getInputAdapter() {
        c cVar = this.V;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        View view = this.f114a;
        if (view != null) {
            if (view.isLayoutRequested() && !this.e) {
                k();
            }
            View view2 = this.f114a;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.f114a.getMeasuredHeight());
            this.e = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.W) {
            this.a0.a();
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.s) {
            b(motionEvent);
            this.O = true;
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                if (this.t != 0) {
                    this.c0 = true;
                    return true;
                }
                this.P = true;
            }
            if (this.f114a != null) {
                z = true;
            } else {
                if (super.onInterceptTouchEvent(motionEvent)) {
                    this.j0 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (action == 1 || action == 3) {
                    h();
                } else if (z) {
                    this.S = 1;
                } else {
                    this.S = 2;
                }
            }
            if (action == 1 || action == 3) {
                this.P = false;
            }
            return z;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.f114a;
        if (view != null) {
            if (view.isLayoutRequested()) {
                k();
            }
            this.e = true;
        }
        this.x = i2;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        n();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.c0) {
            this.c0 = false;
            return false;
        } else if (this.s) {
            boolean z2 = this.O;
            this.O = false;
            if (!z2) {
                b(motionEvent);
            }
            int i2 = this.t;
            if (i2 == 4) {
                a(motionEvent);
                return true;
            }
            if (i2 == 0 && super.onTouchEvent(motionEvent)) {
                z = true;
            }
            int action = motionEvent.getAction() & 255;
            if (action == 1 || action == 3) {
                h();
            } else if (z) {
                this.S = 1;
            }
            return z;
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.b0) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.V = new c(listAdapter);
            listAdapter.registerDataSetObserver(this.f);
            if (listAdapter instanceof j) {
                setDropListener((j) listAdapter);
            }
            if (listAdapter instanceof d) {
                setDragListener((d) listAdapter);
            }
            if (listAdapter instanceof o) {
                setRemoveListener((o) listAdapter);
            }
        } else {
            this.V = null;
        }
        super.setAdapter((ListAdapter) this.V);
    }

    public void setDragEnabled(boolean z) {
        this.s = z;
    }

    public void setDragListener(d dVar) {
        this.p = dVar;
    }

    public void setDragScrollProfile(e eVar) {
        if (eVar != null) {
            this.J = eVar;
        }
    }

    public void setDragScrollStart(float f2) {
        a(f2, f2);
    }

    public void setDragSortListener(g gVar) {
        setDropListener(gVar);
        setDragListener(gVar);
        setRemoveListener(gVar);
    }

    public void setDropListener(j jVar) {
        this.q = jVar;
    }

    public void setFloatAlpha(float f2) {
        this.h = f2;
    }

    public void setFloatViewManager(k kVar) {
        this.Q = kVar;
    }

    public void setMaxScrollSpeed(float f2) {
        this.I = f2;
    }

    public void setRemoveListener(o oVar) {
        this.r = oVar;
    }
}
