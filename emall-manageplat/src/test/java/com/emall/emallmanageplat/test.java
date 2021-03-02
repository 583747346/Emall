package com.emall.emallmanageplat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {

        System.out.println(new Random().nextInt());
        System.out.println(System.getProperty("user.dir"));
        String[] tables = {"pms_aaa_bbb", "oms_ccc_ddd", "ums_eee_rrr"};
        List<String> collect = Arrays.stream(tables).map(table -> table.substring(table.indexOf('_') + 1, table.length())).collect(Collectors.toList());
        System.out.println(collect.toArray(new String[collect.size()]));
        System.out.println(String.format("%02d", 4654));
    }
}
