package a.a.a.a.a.a;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
final class h3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(c0 c0Var) {
        String str;
        StringBuilder sb = new StringBuilder(c0Var.b());
        for (int i = 0; i < c0Var.b(); i++) {
            int c = c0Var.c(i);
            if (c == 34) {
                str = "\\\"";
            } else if (c == 39) {
                str = "\\'";
            } else if (c != 92) {
                switch (c) {
                    case me.i38.gesture.m0.DragSortListView_fling_handle_id /* 7 */:
                        str = "\\a";
                        break;
                    case me.i38.gesture.m0.DragSortListView_float_alpha /* 8 */:
                        str = "\\b";
                        break;
                    case me.i38.gesture.m0.DragSortListView_float_background_color /* 9 */:
                        str = "\\t";
                        break;
                    case me.i38.gesture.m0.DragSortListView_max_drag_scroll_speed /* 10 */:
                        str = "\\n";
                        break;
                    case me.i38.gesture.m0.DragSortListView_remove_animation_duration /* 11 */:
                        str = "\\v";
                        break;
                    case me.i38.gesture.m0.DragSortListView_remove_enabled /* 12 */:
                        str = "\\f";
                        break;
                    case me.i38.gesture.m0.DragSortListView_remove_mode /* 13 */:
                        str = "\\r";
                        break;
                    default:
                        if (c < 32 || c > 126) {
                            sb.append('\\');
                            sb.append((char) (((c >>> 6) & 3) + 48));
                            sb.append((char) (((c >>> 3) & 7) + 48));
                            c = (c & 7) + 48;
                        }
                        sb.append((char) c);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
