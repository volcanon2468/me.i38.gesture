package me.i38.gesture;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public class SelectActionActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private List<i0> f174a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f175b;
    private String c;

    /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
    private class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        ProgressBar f176a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        public class a implements AdapterView.OnItemClickListener {
            a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                i0 i0Var = (i0) SelectActionActivity.this.f174a.get(i);
                if ("IM".equals(i0Var.g())) {
                    SelectActionActivity.this.b();
                } else if ("IP".equals(i0Var.g())) {
                    SelectActionActivity.this.c();
                } else if ("IA".equals(i0Var.g())) {
                    SelectActionActivity.this.a();
                } else if ("IS".equals(i0Var.g())) {
                    SelectActionActivity.this.d();
                } else if ("IC".equals(i0Var.g())) {
                    b.this.a();
                } else if ("ID".equals(i0Var.g())) {
                    SelectActionActivity.this.startActivityForResult(new Intent(SelectActionActivity.this, SelectDevtoolsActivity.class), 7);
                } else {
                    SelectActionActivity.this.a(i0Var);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: me.i38.gesture.SelectActionActivity$b$b  reason: collision with other inner class name */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        public class View$OnClickListenerC0001b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f179a;

            View$OnClickListenerC0001b(EditText editText) {
                this.f179a = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    this.f179a.setText(((ClipboardManager) SelectActionActivity.this.getSystemService("clipboard")).getPrimaryClip().getItemAt(0).getText());
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        public class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectActionActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(SelectActionActivity.this.getString(2131296508))));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        public class d implements View.OnClickListener {
            d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectActionActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(SelectActionActivity.this.getString(2131296392))));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        public class e implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f183a;

            e(EditText editText) {
                this.f183a = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GestureApplication.a(SelectActionActivity.this.a(this.f183a.getText().toString()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
        public class f implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ EditText f185a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ EditText f186b;

            f(EditText editText, EditText editText2) {
                this.f185a = editText;
                this.f186b = editText2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String obj = this.f185a.getText().toString();
                String obj2 = this.f186b.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    Toast.makeText(GestureApplication.g(), 2131296502, 1).show();
                    return;
                }
                SelectActionActivity selectActionActivity = SelectActionActivity.this;
                String a2 = selectActionActivity.a(obj);
                if (TextUtils.isEmpty(obj2)) {
                    obj2 = SelectActionActivity.this.getString(2131296504);
                }
                selectActionActivity.a(new i0(a2, obj2, null));
            }
        }

        private b() {
            this.f176a = (ProgressBar) SelectActionActivity.this.findViewById(2131099664);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            View inflate = SelectActionActivity.this.getLayoutInflater().inflate(2131165188, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(2131099656);
            EditText editText2 = (EditText) inflate.findViewById(2131099657);
            editText.setText(me.i38.gesture.o0.k.a(SelectActionActivity.this.f175b, "\\|", 1, 2));
            editText2.setText(me.i38.gesture.o0.k.a(SelectActionActivity.this.f175b, "\\|", 0, 2));
            inflate.findViewById(2131099688).setOnClickListener(new View$OnClickListenerC0001b(editText2));
            inflate.findViewById(2131099686).setOnClickListener(new c());
            inflate.findViewById(2131099687).setOnClickListener(new d());
            inflate.findViewById(2131099689).setOnClickListener(new e(editText2));
            new AlertDialog.Builder(SelectActionActivity.this).setView(inflate).setPositiveButton(17039379, new f(editText2, editText)).show();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            SelectActionActivity.this.f174a = new ArrayList();
            for (int i = 0; i <= 5; i++) {
                SelectActionActivity.this.f174a.add(new i0("" + i, me.i38.gesture.o0.h.c(SelectActionActivity.this, "" + i), me.i38.gesture.o0.h.b(SelectActionActivity.this, "" + i)));
            }
            SelectActionActivity.this.f174a.add(new i0("f", SelectActionActivity.this.getString(2131296315), SelectActionActivity.this.getString(2131296316), null, me.i38.gesture.o0.h.b(SelectActionActivity.this, "f")));
            SelectActionActivity.this.f174a.add(new i0("IM", SelectActionActivity.this.getString(2131296339), me.i38.gesture.o0.h.b(SelectActionActivity.this, "IM")));
            SelectActionActivity.this.f174a.add(new i0("IA", SelectActionActivity.this.getString(2131296338), me.i38.gesture.o0.h.b(SelectActionActivity.this, "IA")));
            SelectActionActivity.this.f174a.add(new i0("IS", SelectActionActivity.this.getString(2131296341), SelectActionActivity.this.getString(2131296342), null, me.i38.gesture.o0.h.b(SelectActionActivity.this, "IS")));
            SelectActionActivity.this.f174a.add(new i0("IC", SelectActionActivity.this.getString(2131296332), me.i38.gesture.o0.h.b(SelectActionActivity.this, "IC")));
            SelectActionActivity.this.f174a.add(new i0("IP", SelectActionActivity.this.getString(2131296340), me.i38.gesture.o0.h.b(SelectActionActivity.this, "IP")));
            SelectActionActivity.this.f174a.add(new i0("ID", SelectActionActivity.this.getString(2131296545), me.i38.gesture.o0.h.b(SelectActionActivity.this, "ID")));
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r4) {
            super.onPostExecute(r4);
            ListView listView = (ListView) SelectActionActivity.this.findViewById(2131099663);
            SelectActionActivity selectActionActivity = SelectActionActivity.this;
            listView.setAdapter((ListAdapter) new j0(selectActionActivity, selectActionActivity.f174a));
            listView.setOnItemClickListener(new a());
            this.f176a.setVisibility(8);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.f176a.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("ss:") || lowerCase.startsWith("intent:") || lowerCase.startsWith("#intent") || lowerCase.startsWith("shortcut:") || lowerCase.startsWith("android-app:") || lowerCase.startsWith("view:") || me.i38.gesture.o0.h.b(str) != -1) {
            return str;
        }
        return "view:" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        startActivityForResult(new Intent(this, SelectAppActivity.class), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i0 i0Var) {
        Intent intent = new Intent();
        if ("android.intent.action.CREATE_SHORTCUT".equals(this.c)) {
            Intent intent2 = new Intent(this, ShortcutActivity.class);
            intent2.putExtra("id", i0Var.g());
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.NAME", i0Var.h());
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, 2131034167));
        } else {
            intent.putExtra("id", i0Var.g());
            intent.putExtra("name", i0Var.h());
        }
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        startActivityForResult(new Intent(this, SelectMoreActivity.class), 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        startActivityForResult(new Intent(this, SelectPlusActionActivity.class), 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        startActivityForResult(new Intent(this, SelectShortcutActivity.class), 4);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1 || i < 3 || i > 7) {
            return;
        }
        String string = intent.getExtras().getString("action", "");
        String string2 = intent.getExtras().getString("name", "");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return;
        }
        a(new i0(string, string2, null));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f175b = me.i38.gesture.o0.h.a((Activity) this).getString("action", "");
        this.c = getIntent().getAction();
        setTitle(2131296542);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(2131165187);
        new b().execute(new Void[0]);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}
