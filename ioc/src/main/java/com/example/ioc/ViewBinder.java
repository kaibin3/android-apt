package com.example.ioc;

/*
*创建 ViewBinder，它的作用是调用生成类，完成 bind() 方法传入对象的字段初始化。
* */
 /* Description:
 * <br> 从生成类中为当前 Activity/View 中的 View findViewById
 * <p>
 * <br> Created by shixinzhang on 17/6/22.
 * <p>
 * <br> Email: shixinzhang2016@gmail.com
 * <p>
 * <br> https://about.me/shixinzhang
 */

public class ViewBinder {
   /* private static final String SUFFIX = "$$ViewInjector";

    ***
     * Activity 中调用的方法
     *
     * @param activity
     *//*
    public static void bind(Object activity) {
        bind(activity, activity);
    }

    ***
     * 1.寻找对应的代理类
     * 2.调用接口提供的绑定方法
     *
     * @param host
     * @param root
     *//*
    @SuppressWarnings("unchecked")
    private static void bind(final Object host, final Object root) {
        if (host == null || root == null) {
            return;
        }
        Class<?> aClass = host.getClass();
        //拼接生成类的名称
        String proxyClassFullName = aClass.getName() + SUFFIX;
        try {
            Class<?> proxyClass = Class.forName(proxyClassFullName);
            ViewInjector viewInjector = (ViewInjector) proxyClass.newInstance();
            if (viewInjector != null) {
                viewInjector.inject(host, root);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/







    public static void bind(Object activity) {
        bind(activity, activity);
    }

    public static void bind(Object host, Object root) {
        Class<?> clazz = host.getClass();
        //拼接生成类的名称
        String proxyClassFullName = clazz.getName() + "ViewInjector";
        try {
            Class<?> proxyClazz = Class.forName(proxyClassFullName);
            ViewInjector viewInjector = (ViewInjector) proxyClazz.newInstance();
            viewInjector.inject(host, root);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}