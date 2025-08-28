package me.i38.gesture.components;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class MsgPreference extends Preference implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f219a;

    /* renamed from: b  reason: collision with root package name */
    private String f220b;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (TextUtils.isEmpty(MsgPreference.this.f220b)) {
                return;
            }
            try {
                MsgPreference.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(MsgPreference.this.f220b)));
            } catch (Exception unused) {
            }
        }
    }

    public MsgPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MsgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private String a(AttributeSet attributeSet, String str, String str2, String str3) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue(str, str2, 0);
        if (attributeResourceValue == 0) {
            String attributeValue = attributeSet.getAttributeValue(str, str2);
            return attributeValue == null ? str3 : attributeValue;
        }
        return getContext().getResources().getString(attributeResourceValue);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f219a = a(attributeSet, null, "tip", "");
        this.f220b = a(attributeSet, null, "url", "");
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        view.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setSingleLine(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TextUtils.isEmpty(this.f219a)) {
            if (TextUtils.isEmpty(this.f220b)) {
                return;
            }
            try {
                getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f220b)));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        boolean z = this.f219a.indexOf("<a href") != -1;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String str = this.f219a;
        Spanned spanned = str;
        if (z) {
            spanned = Html.fromHtml(str);
        }
        AlertDialog show = builder.setMessage(spanned).setPositiveButton(17039379, new a()).show();
        if (z) {
            ((TextView) show.findViewById(16908299)).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
