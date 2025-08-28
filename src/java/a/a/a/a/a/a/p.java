package a.a.a.a.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/me.i38.gesture/dex-files/0.dex */
public final class p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, h1 h1Var, o oVar) {
        f1 f1Var = (f1) h1Var;
        int d = d(bArr, i2, oVar);
        while (true) {
            f1Var.b(oVar.f61a);
            if (d >= i3) {
                break;
            }
            int d2 = d(bArr, d, oVar);
            if (i != oVar.f61a) {
                break;
            }
            d = d(bArr, d2, oVar);
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3, k3 k3Var, o oVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int e = e(bArr, i2, oVar);
                k3Var.a(i, Long.valueOf(oVar.f62b));
                return e;
            } else if (i4 == 1) {
                k3Var.a(i, Long.valueOf(b(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int d = d(bArr, i2, oVar);
                int i5 = oVar.f61a;
                if (i5 >= 0) {
                    if (i5 <= bArr.length - d) {
                        k3Var.a(i, i5 == 0 ? c0.f9b : c0.a(bArr, d, i5));
                        return d + i5;
                    }
                    throw k1.f();
                }
                throw k1.d();
            } else if (i4 != 3) {
                if (i4 == 5) {
                    k3Var.a(i, Integer.valueOf(a(bArr, i2)));
                    return i2 + 4;
                }
                throw k1.b();
            } else {
                int i6 = (i & (-8)) | 4;
                k3 f = k3.f();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int d2 = d(bArr, i2, oVar);
                    int i8 = oVar.f61a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = d2;
                        break;
                    }
                    int a2 = a(i7, bArr, d2, i3, f, oVar);
                    i7 = i8;
                    i2 = a2;
                }
                if (i2 > i3 || i7 != i6) {
                    throw k1.e();
                }
                k3Var.a(i, f);
                return i2;
            }
        }
        throw k1.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, o oVar) {
        int i3;
        int i4;
        byte b2 = bArr[i2];
        int i5 = i2 + 1;
        int i6 = i & 127;
        if (b2 < 0) {
            int i7 = i6 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i5 + 1;
            byte b3 = bArr[i5];
            if (b3 >= 0) {
                i3 = b3 << 14;
            } else {
                i6 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
                i5 = i8 + 1;
                byte b4 = bArr[i8];
                if (b4 >= 0) {
                    i4 = b4 << 21;
                } else {
                    i7 = i6 | ((b4 & Byte.MAX_VALUE) << 21);
                    i8 = i5 + 1;
                    byte b5 = bArr[i5];
                    if (b5 >= 0) {
                        i3 = b5 << 28;
                    } else {
                        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] >= 0) {
                                oVar.f61a = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            oVar.f61a = i7 | i3;
            return i8;
        }
        i4 = b2 << 7;
        oVar.f61a = i6 | i4;
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(r2 r2Var, int i, byte[] bArr, int i2, int i3, h1 h1Var, o oVar) {
        int a2 = a(r2Var, bArr, i2, i3, oVar);
        while (true) {
            h1Var.add(oVar.c);
            if (a2 >= i3) {
                break;
            }
            int d = d(bArr, a2, oVar);
            if (i != oVar.f61a) {
                break;
            }
            a2 = a(r2Var, bArr, d, i3, oVar);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(r2 r2Var, byte[] bArr, int i, int i2, int i3, o oVar) {
        Object d = r2Var.d();
        int a2 = a(d, r2Var, bArr, i, i2, i3, oVar);
        r2Var.a(d);
        oVar.c = d;
        return a2;
    }

    static int a(r2 r2Var, byte[] bArr, int i, int i2, o oVar) {
        Object d = r2Var.d();
        int a2 = a(d, r2Var, bArr, i, i2, oVar);
        r2Var.a(d);
        oVar.c = d;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Object obj, r2 r2Var, byte[] bArr, int i, int i2, int i3, o oVar) {
        int a2 = ((k2) r2Var).a(obj, bArr, i, i2, i3, oVar);
        oVar.c = obj;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Object obj, r2 r2Var, byte[] bArr, int i, int i2, o oVar) {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = a(i4, bArr, i3, oVar);
            i4 = oVar.f61a;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw k1.f();
        }
        int i6 = i4 + i5;
        r2Var.a(obj, bArr, i5, i6, oVar);
        oVar.c = obj;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << 24) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, h1 h1Var, o oVar) {
        f1 f1Var = (f1) h1Var;
        int d = d(bArr, i, oVar);
        int i2 = oVar.f61a + d;
        while (d < i2) {
            d = d(bArr, d, oVar);
            f1Var.b(oVar.f61a);
        }
        if (d == i2) {
            return d;
        }
        throw k1.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(byte[] bArr, int i, o oVar) {
        int d = d(bArr, i, oVar);
        int i2 = oVar.f61a;
        if (i2 >= 0) {
            if (i2 <= bArr.length - d) {
                if (i2 == 0) {
                    oVar.c = c0.f9b;
                    return d;
                }
                oVar.c = c0.a(bArr, d, i2);
                return d + i2;
            }
            throw k1.f();
        }
        throw k1.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i, o oVar) {
        int d = d(bArr, i, oVar);
        int i2 = oVar.f61a;
        if (i2 >= 0) {
            if (i2 == 0) {
                oVar.c = "";
                return d;
            }
            oVar.c = new String(bArr, d, i2, i1.f25a);
            return d + i2;
        }
        throw k1.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(byte[] bArr, int i, o oVar) {
        int d = d(bArr, i, oVar);
        int i2 = oVar.f61a;
        if (i2 >= 0) {
            if (i2 == 0) {
                oVar.c = "";
                return d;
            }
            int i3 = y3.f107b;
            int length = bArr.length;
            if ((((length - d) - i2) | d | i2) >= 0) {
                int i4 = d + i2;
                char[] cArr = new char[i2];
                int i5 = 0;
                while (d < i4) {
                    byte b2 = bArr[d];
                    if (!u3.a(b2)) {
                        break;
                    }
                    d++;
                    cArr[i5] = (char) b2;
                    i5++;
                }
                while (d < i4) {
                    int i6 = d + 1;
                    byte b3 = bArr[d];
                    if (u3.a(b3)) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) b3;
                        d = i6;
                        while (true) {
                            i5 = i7;
                            if (d < i4) {
                                byte b4 = bArr[d];
                                if (u3.a(b4)) {
                                    d++;
                                    i7 = i5 + 1;
                                    cArr[i5] = (char) b4;
                                }
                            }
                        }
                    } else if (b3 < -32) {
                        if (i6 >= i4) {
                            throw k1.c();
                        }
                        u3.a(b3, bArr[i6], cArr, i5);
                        d = i6 + 1;
                        i5++;
                    } else if (b3 < -16) {
                        if (i6 >= i4 - 1) {
                            throw k1.c();
                        }
                        int i8 = i6 + 1;
                        u3.a(b3, bArr[i6], bArr[i8], cArr, i5);
                        d = i8 + 1;
                        i5++;
                    } else if (i6 >= i4 - 2) {
                        throw k1.c();
                    } else {
                        int i9 = i6 + 1;
                        byte b5 = bArr[i6];
                        int i10 = i9 + 1;
                        u3.a(b3, b5, bArr[i9], bArr[i10], cArr, i5);
                        i5 += 2;
                        d = i10 + 1;
                    }
                }
                oVar.c = new String(cArr, 0, i5);
                return i4;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(d), Integer.valueOf(i2)));
        }
        throw k1.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(byte[] bArr, int i, o oVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 >= 0) {
            oVar.f61a = b2;
            return i2;
        }
        return a(b2, bArr, i2, oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(byte[] bArr, int i, o oVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            oVar.f62b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= (b3 & Byte.MAX_VALUE) << i4;
            i3 = i5;
            b2 = b3;
        }
        oVar.f62b = j2;
        return i3;
    }
}
