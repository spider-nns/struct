package dev.java.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lgc
 * @date 2021/2/26
 */
public class ComplexFunc {
    public static void main(String[] args) {
        List<Double> list = new ArrayList();
        Set<String> set = new HashSet();
        set.add("a");
        set.add("ab");
        set.add("ac");
        String collect = set.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
