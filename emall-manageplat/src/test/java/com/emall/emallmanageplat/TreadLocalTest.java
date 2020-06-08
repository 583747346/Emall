package com.emall.emallmanageplat;

/**
 * 父子线程变量供共用
 */
public class TreadLocalTest {

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    private static ThreadLocal<String> treadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        inheritableThreadLocal.set("inheritableThreadLocal");
        treadLocal.set("treadLocal");
        Thread tread = new Thread(()->{
            System.out.println("子线程inheritableThreadLocal——>" + inheritableThreadLocal.get());
            System.out.println("子线程treadLocal——>"+treadLocal.get());
        });
        tread.start();
        System.out.println("主线程inheritableThreadLocal——>"+inheritableThreadLocal.get());
        System.out.println("主线程treadLocal——>"+treadLocal.get());
    }

}
