package com.hyif.plugin

import javassist.ClassPool
import javassist.CtClass
import javassist.CtConstructor

public class MyInject {

    private static ClassPool pool = ClassPool.getDefault()
    private static String injectStr = "System.out.println(\"I Love HuaChao\" ); ";

    public static void injectDir(String path, String packageName) {

        pool.appendClassPath(path)
        File dir = new File(path)
        if (dir.isDirectory()) {
            dir.eachFileRecurse { File file ->
                String filePath = file.absolutePath
                //确保当前文件是class文件，并且不是系统自动生成的class文件
                if (filePath.endsWith("MainActivity.class")) {

                    // 判断当前目录是否是在我们的应用包里面

                    String className = filePath.substring(filePath.lastIndexOf("\\")+1, filePath.length() - 6)
                    System.out.println("className:" + className)
//                    if (className=='MainActivity') {
                    System.out.println("111111111111111:")
                    //开始修改class文件
                    CtClass c = pool.getCtClass(className)

                    if (c.isFrozen()) {
                        c.defrost()
                    }

                    CtConstructor[] cts = c.getDeclaredConstructors()
                    if (cts == null || cts.length == 0) {
                        //手动创建一个构造函数
                        CtConstructor constructor = new CtConstructor(new CtClass[0], c)
                        constructor.insertBeforeBody(injectStr)
                        c.addConstructor(constructor)
                    } else {
                        cts[0].insertBeforeBody(injectStr)
                    }
                    c.writeFile(path)
                    c.detach()
                }
//                }
            }
        }
    }


}