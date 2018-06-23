package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

        /**
         *      Collections
         * List<String>     Set<String>     Map<String, String>
         *
         * Map: key - value
         *
         * key - unique
         * value - non-unique
         */


        Map<Integer, String> map = new HashMap<>();
        map.putIfAbsent(1, "a");
        map.putIfAbsent(2, "b");
        map.putIfAbsent(3, "c");
        map.putIfAbsent(4, "d");
        map.putIfAbsent(5, "e");
        map.putIfAbsent(6, "f");

        System.out.println(map);
        System.out.println("Contains key (existing): " + map.containsKey(1));
        System.out.println("Contains key (non-existing): " + map.containsKey(-100));

        System.out.println("Contains (existing): " + map.containsValue("a"));
        System.out.println("Contains (non-existing): " + map.containsValue("abcdef"));

        System.out.println("Map before: ");
        System.out.println(map);

        //Для того, чтобы for'ить (итерировать) мапу - нужно использовать Entry/entrySet

        //.entrySet() возвращает объект, который содержит ссылку на текущий ключ и значение
        for (Map.Entry<Integer, String> mapUnit : map.entrySet()) {

            if (mapUnit.getKey().equals(1)) {
                String newValue = "aaaaa";
                System.out.printf("Replacing by key [%s], value [%s] onto [%s]\n",
                        mapUnit.getKey(),
                        mapUnit.getValue(),
                        newValue);
                String oldValue = mapUnit.setValue(newValue);

            }
        }

        System.out.println("Map after: ");
        System.out.println(map);

        //compute if present =
        // 1. найти
        // 2. если значение не null
        // 3. put if present

        String computedSuffix = " computed";
        map.computeIfPresent(6, (t, u) -> u = u + computedSuffix);
        map.computeIfAbsent(26, (value) -> "z" + computedSuffix);

//        map.computeIfPresent(6, new BiFunction<Integer, String, String>() {
//            @Override
//            public String apply(Integer integer, String s) {
//                return s = s + " computed";
//            }
//        });


        System.out.println(map);

        Map<String, Integer> words = new HashMap<>(); // -> Set<WordOccurrence>
        //WordOccurrence implements Comparator
        //private Integer occurrences;
        //private String word
        //List.sort(listOfWordOccurrences);
        //sout(listOfWordOccurrences)


    }

    public static void mapMethods_1() {
        Map<String, String> map = new HashMap<>();
//        Map<String>

        System.out.println(map);

        //если по такому ключу ничего раньше не было - .put() вернет null
        //если такой ключ уже существует, то Map перезапишет старое значение новым по ключу
        //если .put() "обновил" значение - вернет старое
        String nullValue = map.put("edward@site.com", "Edward Kats");//list.add(), set.add() -> true/false

        System.out.println(nullValue);
        //null

        String newValue = map.put("edward@site.com", "Moshe Yuvani");
        //.put() возвращает старое значение, которое он заменил на новое
        System.out.println(newValue);

        String value = map.putIfAbsent("edward@site.com", "Edward Kats");
        map.putIfAbsent("peter@site.com", "Peter Davidson");
        System.out.println(value);
        System.out.println(map);

        String name = map.get("edward@site.com");
        System.out.println("Name: " + name);

        System.out.println("Size: " + map.size());
        System.out.println("Values: " + map.values());

        System.out.println("Keys: " + map.keySet());
//        map.getOrDefault()

        String nonExistingValue = map.get("123123123141sdasc$124");

//        if (nonExistingValue == null) {
//            nonExistingValue = "default value";
//        }

        System.out.println("Name: " + map.getOrDefault("какая-то ерунда", "default value"));

        String someValue = map.replace("edward@site.com", "Edward Kats!!!");
        System.out.println("Replace (for edward@site.com): " + someValue);
        System.out.println("Map (after returning the account to Edward Kats: " + map);

        String key = "edward@site.com";
        String removedValue = map.remove(key);
        System.out.println("Removed: " + removedValue);

        map.clear();
        System.out.println(map);
    }
}
