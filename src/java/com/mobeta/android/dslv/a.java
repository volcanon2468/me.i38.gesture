package com.mobeta.android.dslv;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class a extends d implements View.OnTouchListener, GestureDetector.OnGestureListener {
    private DragSortListView A;
    private int B;
    private GestureDetector.OnGestureListener C;
    private int e;
    private boolean f;
    private int g;
    private boolean h;
    private boolean i;
    private GestureDetector j;
    private GestureDetector k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int[] p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private float v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    /* renamed from: com.mobeta.android.dslv.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class C0000a extends GestureDetector.SimpleOnGestureListener {
        C0000a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (a.this.h && a.this.i) {
                int width = a.this.A.getWidth() / 5;
                if (f <= a.this.v ? !(f >= (-a.this.v) || a.this.B >= width) : a.this.B > (-width)) {
                    a.this.A.b(true, f);
                }
                a.this.i = false;
            }
            return false;
        }
    }

    public a(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.e = 0;
        this.f = true;
        this.h = false;
        this.i = false;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = new int[2];
        this.u = false;
        this.v = 500.0f;
        this.C = new C0000a();
        this.A = dragSortListView;
        this.j = new GestureDetector(dragSortListView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(dragSortListView.getContext(), this.C);
        this.k = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.l = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.w = i;
        this.x = i4;
        this.y = i5;
        d(i3);
        c(i2);
    }

    public int a(MotionEvent motionEvent) {
        return a(motionEvent, this.w);
    }

    public int a(MotionEvent motionEvent, int i) {
        int pointToPosition = this.A.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.A.getHeaderViewsCount();
        int footerViewsCount = this.A.getFooterViewsCount();
        int count = this.A.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            DragSortListView dragSortListView = this.A;
            View childAt = dragSortListView.getChildAt(pointToPosition - dragSortListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.p);
                int[] iArr = this.p;
                if (rawX > iArr[0] && rawY > iArr[1] && rawX < iArr[0] + findViewById.getWidth() && rawY < this.p[1] + findViewById.getHeight()) {
                    this.q = childAt.getLeft();
                    this.r = childAt.getTop();
                    return pointToPosition;
                }
            }
        }
        return -1;
    }

    @Override // com.mobeta.android.dslv.DragSortListView.k
    public void a(View view, Point point, Point point2) {
        if (this.h && this.i) {
            this.B = point.x;
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean a(int i, int i2, int i3) {
        int i4 = (!this.f || this.i) ? 0 : 12;
        if (this.h && this.i) {
            i4 = i4 | 1 | 2;
        }
        DragSortListView dragSortListView = this.A;
        boolean a2 = dragSortListView.a(i - dragSortListView.getHeaderViewsCount(), i4, i2, i3);
        this.u = a2;
        return a2;
    }

    public int b(MotionEvent motionEvent) {
        return a(motionEvent, this.y);
    }

    public void b(boolean z) {
        this.f = z;
    }

    public int c(MotionEvent motionEvent) {
        return a(motionEvent);
    }

    public void c(int i) {
        this.e = i;
    }

    public int d(MotionEvent motionEvent) {
        if (this.g == 1) {
            return b(motionEvent);
        }
        return -1;
    }

    public void d(int i) {
        this.g = i;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.h && this.g == 0) {
            this.o = a(motionEvent, this.x);
        }
        int c = c(motionEvent);
        this.m = c;
        if (c != -1 && this.e == 0) {
            a(c, ((int) motionEvent.getX()) - this.q, ((int) motionEvent.getY()) - this.r);
        }
        this.i = false;
        this.z = true;
        this.B = 0;
        this.n = d(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.m == -1 || this.e != 2) {
            return;
        }
        this.A.performHapticFeedback(0);
        a(this.m, this.s - this.q, this.t - this.r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        if (r6.h != false) goto L25;
     */
    @Override // android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onScroll(android.view.MotionEvent r7, android.view.MotionEvent r8, float r9, float r10) {
        /*
            r6 = this;
            float r9 = r7.getX()
            int r9 = (int) r9
            float r7 = r7.getY()
            int r7 = (int) r7
            float r10 = r8.getX()
            int r10 = (int) r10
            float r8 = r8.getY()
            int r8 = (int) r8
            int r0 = r6.q
            int r0 = r10 - r0
            int r1 = r6.r
            int r1 = r8 - r1
            boolean r2 = r6.z
            r3 = 0
            if (r2 == 0) goto L7d
            boolean r2 = r6.u
            if (r2 != 0) goto L7d
            int r2 = r6.m
            r4 = -1
            if (r2 != r4) goto L2e
            int r2 = r6.n
            if (r2 == r4) goto L7d
        L2e:
            int r2 = r6.m
            r5 = 1
            if (r2 == r4) goto L59
            int r2 = r6.e
            if (r2 != r5) goto L47
            int r8 = r8 - r7
            int r7 = java.lang.Math.abs(r8)
            int r8 = r6.l
            if (r7 <= r8) goto L47
            boolean r7 = r6.f
            if (r7 == 0) goto L47
            int r7 = r6.m
            goto L6e
        L47:
            int r7 = r6.e
            if (r7 == 0) goto L7d
            int r10 = r10 - r9
            int r7 = java.lang.Math.abs(r10)
            int r8 = r6.l
            if (r7 <= r8) goto L7d
            boolean r7 = r6.h
            if (r7 == 0) goto L7d
            goto L6a
        L59:
            int r2 = r6.n
            if (r2 == r4) goto L7d
            int r10 = r10 - r9
            int r9 = java.lang.Math.abs(r10)
            int r10 = r6.l
            if (r9 <= r10) goto L72
            boolean r9 = r6.h
            if (r9 == 0) goto L72
        L6a:
            r6.i = r5
            int r7 = r6.n
        L6e:
            r6.a(r7, r0, r1)
            goto L7d
        L72:
            int r8 = r8 - r7
            int r7 = java.lang.Math.abs(r8)
            int r8 = r6.l
            if (r7 <= r8) goto L7d
            r6.z = r3
        L7d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobeta.android.dslv.a.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i;
        if (this.h && this.g == 0 && (i = this.o) != -1) {
            DragSortListView dragSortListView = this.A;
            dragSortListView.a(i - dragSortListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r3 != 3) goto L29;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r3, android.view.MotionEvent r4) {
        /*
            r2 = this;
            com.mobeta.android.dslv.DragSortListView r3 = r2.A
            boolean r3 = r3.b()
            r0 = 0
            if (r3 == 0) goto L68
            com.mobeta.android.dslv.DragSortListView r3 = r2.A
            boolean r3 = r3.c()
            if (r3 == 0) goto L12
            goto L68
        L12:
            android.view.GestureDetector r3 = r2.j
            r3.onTouchEvent(r4)
            boolean r3 = r2.h
            r1 = 1
            if (r3 == 0) goto L29
            boolean r3 = r2.u
            if (r3 == 0) goto L29
            int r3 = r2.g
            if (r3 != r1) goto L29
            android.view.GestureDetector r3 = r2.k
            r3.onTouchEvent(r4)
        L29:
            int r3 = r4.getAction()
            r3 = r3 & 255(0xff, float:3.57E-43)
            if (r3 == 0) goto L5a
            if (r3 == r1) goto L37
            r4 = 3
            if (r3 == r4) goto L55
            goto L68
        L37:
            boolean r3 = r2.h
            if (r3 == 0) goto L55
            boolean r3 = r2.i
            if (r3 == 0) goto L55
            int r3 = r2.B
            if (r3 < 0) goto L44
            goto L45
        L44:
            int r3 = -r3
        L45:
            com.mobeta.android.dslv.DragSortListView r4 = r2.A
            int r4 = r4.getWidth()
            int r4 = r4 / 2
            if (r3 <= r4) goto L55
            com.mobeta.android.dslv.DragSortListView r3 = r2.A
            r4 = 0
            r3.b(r1, r4)
        L55:
            r2.i = r0
            r2.u = r0
            goto L68
        L5a:
            float r3 = r4.getX()
            int r3 = (int) r3
            r2.s = r3
            float r3 = r4.getY()
            int r3 = (int) r3
            r2.t = r3
        L68:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobeta.android.dslv.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
