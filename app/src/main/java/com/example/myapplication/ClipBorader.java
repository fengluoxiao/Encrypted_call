package com.example.myapplication;

import android.content.ClipboardManager;
import android.content.Context;

public class ClipBorader {
    public static void ClipBorader(Context context,String text) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(text);
    }
}
