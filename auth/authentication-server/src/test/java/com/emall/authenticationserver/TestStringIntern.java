package com.emall.authenticationserver;

public class TestStringIntern {

    public static void main(String[] args) {
        String a = new String("1");
        a.intern();
        String b = "1";
        System.out.println(a == b);

        //如果常量池中存在当前字符串, 就会直接返回当前字符串. 如果常量池中没有此字符串, 会将此字符串放入常量池中后, 再返回
        //jdk1.7以上去掉了perm区，这里s4显示创建，string常量池没有"11"故而创建s4为11的对象，然后s3.intern()发现常量池有11，那么就会直接返回，这时s4的引用与s3的不一致
        String s4 = "11";
        String s3 = new String("1") + new String("1");
        s3.intern();
        System.out.println(s3 == s4);

        //这里s1.intern()发现常量池没有11，故而会创建，但是jvm堆里面已经有s1对象了，此时不需要在创建对象，常量池只会存储堆的引用
        //s2发现常量池有11，故而直接返回堆的引用，即s1==s2
        String s1 = new String("1") + new String("1");
        s1.intern();
        String s2 = "11";
        System.out.println(s3 == s2);
    }

}
