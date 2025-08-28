package com.mobeta.android.dslv;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class c extends b implements Checkable {
    public c(Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            return ((Checkable) childAt).isChecked();
        }
        return false;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).setChecked(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        View childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).toggle();
        }
    }
}
