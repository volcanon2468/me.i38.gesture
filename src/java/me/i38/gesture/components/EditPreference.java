package me.i38.gesture.components;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class EditPreference extends EditTextPreference {
    public EditPreference(Context context) {
        super(context);
    }

    public EditPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.preference.Preference
    public CharSequence getSummary() {
        return getText();
    }
}
