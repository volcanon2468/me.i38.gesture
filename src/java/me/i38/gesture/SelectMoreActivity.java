package me.i38.gesture;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class SelectMoreActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private List<i0> f194a = null;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SelectMoreActivity.this.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        AlertDialog.Builder positiveButton;
        final i0 i0Var = this.f194a.get(i);
        if ("W".equals(i0Var.g())) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            final EditText editText = new EditText(this);
            editText.setHint(2131296578);
            final EditText editText2 = new EditText(this);
            editText2.setHint(2131296569);
            linearLayout.addView(editText);
            linearLayout.addView(editText2);
            positiveButton = new AlertDialog.Builder(this).setView(linearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.u
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SelectMoreActivity.this.a(i0Var, editText, editText2, dialogInterface, i2);
                }
            });
        } else if (!"Y".equals(i0Var.g())) {
            a(i0Var.g(), i0Var.h());
            return;
        } else {
            final EditText editText3 = new EditText(this);
            editText3.setText(RingtoneManager.getActualDefaultRingtoneUri(getApplicationContext(), 2).toString());
            positiveButton = new AlertDialog.Builder(this).setMessage(2131296308).setView(editText3).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: me.i38.gesture.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SelectMoreActivity.this.a(i0Var, editText3, dialogInterface, i2);
                }
            });
        }
        positiveButton.show();
    }

    private void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("action", str);
        intent.putExtra("name", str2);
        setResult(-1, intent);
        finish();
    }

    public /* synthetic */ void a(i0 i0Var, EditText editText, DialogInterface dialogInterface, int i) {
        a(i0Var.g() + ":" + editText.getText().toString(), i0Var.h());
    }

    public /* synthetic */ void a(i0 i0Var, EditText editText, EditText editText2, DialogInterface dialogInterface, int i) {
        a(i0Var.g() + ":" + editText.getText().toString() + ":" + editText2.getText().toString(), i0Var.h());
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(2131296339);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(2131165187);
        ListView listView = (ListView) findViewById(2131099663);
        this.f194a = new ArrayList();
        if (me.i38.gesture.o0.h.d(getApplicationContext(), "com.eg.android.AlipayGphone")) {
            this.f194a.add(new i0("b", getString(2131296310), me.i38.gesture.o0.h.b(this, "b")));
            this.f194a.add(new i0("c", getString(2131296311), me.i38.gesture.o0.h.b(this, "c")));
        }
        if (me.i38.gesture.o0.h.d(getApplicationContext(), "com.tencent.mm")) {
            this.f194a.add(new i0("d", getString(2131296312), me.i38.gesture.o0.h.b(this, "d")));
            this.f194a.add(new i0("P", getString(2131296296), me.i38.gesture.o0.h.b(this, "P")));
        }
        this.f194a.add(new i0("C", getString(2131296278), me.i38.gesture.o0.h.b(this, "C")));
        this.f194a.add(new i0("D", getString(2131296279), getString(2131296280), null, me.i38.gesture.o0.h.b(this, "D")));
        if (Build.VERSION.SDK_INT >= 29) {
            this.f194a.add(new i0("O", getString(2131296295), me.i38.gesture.o0.h.b(this, "O")));
            this.f194a.add(new i0("u", getString(2131296344), me.i38.gesture.o0.h.b(this, "u")));
        }
        this.f194a.add(new i0("E", getString(2131296281), me.i38.gesture.o0.h.b(this, "E")));
        this.f194a.add(new i0("U", getString(2131296303), me.i38.gesture.o0.h.b(this, "U")));
        this.f194a.add(new i0("L", getString(2131296291), me.i38.gesture.o0.h.b(this, "L")));
        if (Build.VERSION.SDK_INT >= 23) {
            this.f194a.add(new i0("F", getString(2131296282), me.i38.gesture.o0.h.b(this, "F")));
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.f194a.add(new i0("l", getString(2131296323), me.i38.gesture.o0.h.b(this, "l")));
            this.f194a.add(new i0("e", getString(2131296313), me.i38.gesture.o0.h.b(this, "e")));
        }
        this.f194a.add(new i0("6", getString(2131296271), getString(2131296272), null, me.i38.gesture.o0.h.b(this, "6")));
        this.f194a.add(new i0("a", getString(2131296309), me.i38.gesture.o0.h.b(this, "a")));
        this.f194a.add(new i0("n", getString(2131296328), me.i38.gesture.o0.h.b(this, "n")));
        this.f194a.add(new i0("r", getString(2131296334), me.i38.gesture.o0.h.b(this, "r")));
        this.f194a.add(new i0("o", getString(2131296329), me.i38.gesture.o0.h.b(this, "o")));
        this.f194a.add(new i0("q", getString(2131296333), me.i38.gesture.o0.h.b(this, "q")));
        this.f194a.add(new i0("S", getString(2131296300), me.i38.gesture.o0.h.b(this, "S")));
        this.f194a.add(new i0("J", getString(2131296288), getString(2131296289), null, me.i38.gesture.o0.h.b(this, "J")));
        this.f194a.add(new i0("v", getString(2131296345), me.i38.gesture.o0.h.b(this, "v")));
        this.f194a.add(new i0("w", getString(2131296346), me.i38.gesture.o0.h.b(this, "w")));
        this.f194a.add(new i0("x", getString(2131296347), me.i38.gesture.o0.h.b(this, "x")));
        this.f194a.add(new i0("Q", getString(2131296297), me.i38.gesture.o0.h.b(this, "Q")));
        this.f194a.add(new i0("A", getString(2131296276), me.i38.gesture.o0.h.b(this, "A")));
        this.f194a.add(new i0("B", getString(2131296277), me.i38.gesture.o0.h.b(this, "B")));
        this.f194a.add(new i0("t", getString(2131296343), me.i38.gesture.o0.h.b(this, "t")));
        this.f194a.add(new i0("K", getString(2131296290), me.i38.gesture.o0.h.b(this, "K")));
        this.f194a.add(new i0("R", getString(2131296298), getString(2131296299), null, me.i38.gesture.o0.h.b(this, "R")));
        this.f194a.add(new i0("y", getString(2131296348), me.i38.gesture.o0.h.b(this, "y")));
        this.f194a.add(new i0("7", getString(2131296273), me.i38.gesture.o0.h.b(this, "7")));
        this.f194a.add(new i0("8", getString(2131296274), getString(2131296591), null, me.i38.gesture.o0.h.b(this, "8")));
        this.f194a.add(new i0("9", getString(2131296275), me.i38.gesture.o0.h.b(this, "9")));
        this.f194a.add(new i0("k", getString(2131296321), getString(2131296322), null, me.i38.gesture.o0.h.b(this, "k")));
        this.f194a.add(new i0("W", getString(2131296306), me.i38.gesture.o0.h.b(this, "W")));
        this.f194a.add(new i0("Y", getString(2131296307), getString(2131296308), null, me.i38.gesture.o0.h.b(this, "Y")));
        this.f194a.add(new i0("p", getString(2131296330), getString(2131296331), null, me.i38.gesture.o0.h.b(this, "p")));
        this.f194a.add(new i0("s", getString(2131296335), getString(2131296336), null, me.i38.gesture.o0.h.b(this, "s")));
        listView.setAdapter((ListAdapter) new j0(this, this.f194a));
        listView.setOnItemClickListener(new a());
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}
