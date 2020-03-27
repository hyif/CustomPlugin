package com.hyif.customplugin;

import android.util.Log;

public class Animal {
    public void fly() {
        Log.e("MethodAspect", "animal fly method:" + this.toString() + "#fly");
    }
}