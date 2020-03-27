package com.hyif.customplugin;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect  //①
public class MethodAspect {
    private static final String TAG = "MethodAspect";
    @Pointcut("call(* com.hyif.customplugin.Animal.fly(..))")//②
    public void callMethod() {
    }

    @Before("callMethod()")//③
    public void beforeMethodCall(JoinPoint joinPoint) {
        Log.e(TAG, "before->" + joinPoint.getTarget().toString()); //④
    }
}