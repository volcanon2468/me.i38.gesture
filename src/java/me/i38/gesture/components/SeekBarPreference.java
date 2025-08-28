package me.i38.gesture.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class SeekBarPreference extends Preference implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f222a;

    /* renamed from: b  reason: collision with root package name */
    private int f223b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private SeekBar h;
    private View i;
    private TextView j;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f222a = SeekBarPreference.class.getName();
        this.f223b = 100;
        this.c = 0;
        this.d = 1;
        this.f = "";
        this.g = "";
        a(context, attributeSet);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f222a = SeekBarPreference.class.getName();
        this.f223b = 100;
        this.c = 0;
        this.d = 1;
        this.f = "";
        this.g = "";
        a(context, attributeSet);
    }

    private String a(AttributeSet attributeSet, String str, String str2, String str3) {
        String attributeValue = attributeSet.getAttributeValue(str, str2);
        return attributeValue == null ? str3 : attributeValue;
    }

    private void a(Context context, AttributeSet attributeSet) {
        a(attributeSet);
        SeekBar seekBar = new SeekBar(context, attributeSet);
        this.h = seekBar;
        seekBar.setMax(this.f223b - this.c);
        this.h.setOnSeekBarChangeListener(this);
        setWidgetLayoutResource(2131165198);
    }

    private void a(AttributeSet attributeSet) {
        this.f223b = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "max", 100);
        this.c = attributeSet.getAttributeIntValue("http://robobunny.com", "min", 0);
        this.f = a(attributeSet, "http://robobunny.com", "unitsLeft", "");
        this.g = a(attributeSet, "http://robobunny.com", "unitsRight", a(attributeSet, "http://robobunny.com", "units", ""));
        try {
            String attributeValue = attributeSet.getAttributeValue("http://robobunny.com", "interval");
            if (attributeValue != null) {
                this.d = Integer.parseInt(attributeValue);
            }
        } catch (Exception e) {
            Log.e(this.f222a, "Invalid interval value", e);
        }
    }

    public void a(int i) {
        this.e = i;
    }

    public int d() {
        return this.e;
    }

    protected void e() {
        try {
            TextView textView = (TextView) this.i.findViewById(2131099700);
            this.j = textView;
            textView.setText(String.valueOf(this.e));
            this.j.setMinimumWidth(30);
            this.h.setProgress(this.e - this.c);
            ((TextView) this.i.findViewById(2131099699)).setText(this.g);
            ((TextView) this.i.findViewById(2131099698)).setText(this.f);
        } catch (Exception e) {
            Log.e(this.f222a, "Error updating seek bar preference", e);
        }
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        try {
            ViewParent parent = this.h.getParent();
            ViewGroup viewGroup = (ViewGroup) view.findViewById(2131099696);
            if (parent != viewGroup) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.h);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(this.h, -1, -2);
            }
        } catch (Exception e) {
            String str = this.f222a;
            Log.e(str, "Error binding view: " + e.toString());
        }
        if (view != null && !view.isEnabled()) {
            this.h.setEnabled(false);
        }
        this.i = view;
        e();
    }

    @Override // android.preference.Preference
    protected View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ((LinearLayout) onCreateView).setOrientation(1);
        return onCreateView;
    }

    @Override // android.preference.Preference
    public void onDependencyChanged(Preference preference, boolean z) {
        super.onDependencyChanged(preference, z);
        SeekBar seekBar = this.h;
        if (seekBar != null) {
            seekBar.setEnabled(!z);
        }
    }

    @Override // android.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 50));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int i2 = this.c;
        int i3 = i + i2;
        int i4 = this.f223b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= i2) {
            int i5 = this.d;
            if (i5 == 1 || i3 % i5 == 0) {
                i2 = i3;
            } else {
                i2 = this.d * Math.round(i3 / i5);
            }
        }
        if (i2 != this.e) {
            if (!callChangeListener(Integer.valueOf(i2))) {
                seekBar.setProgress(this.e - this.c);
                return;
            }
            this.e = i2;
            this.j.setText(String.valueOf(i2));
            persistInt(i2);
        }
    }

    @Override // android.preference.Preference
    protected void onSetInitialValue(boolean z, Object obj) {
        int i;
        if (z) {
            i = getPersistedInt(this.e);
        } else {
            i = 0;
            try {
                i = ((Integer) obj).intValue();
            } catch (Exception unused) {
                String str = this.f222a;
                Log.e(str, "Invalid default value: " + obj.toString());
            }
            persistInt(i);
        }
        this.e = i;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        notifyChanged();
    }

    @Override // android.preference.Preference
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.h.setEnabled(z);
    }
}
