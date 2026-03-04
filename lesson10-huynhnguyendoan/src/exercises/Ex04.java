package exercises;

import java.util.*;

public class Ex04 {

    static void bubbleSortIntAsc(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    static void bubbleSortStringAsc(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {

        String[] strings = {"-2", "-6", "10", null, "4", "8", null,
                "Special", "a", "c", "b", "xx"};

        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        List<String> words = new ArrayList<>();
        int specialCount = 0;
        int nullCount = 0;

        for (String s : strings) {

            if (s == null) {
                nullCount++;
            } else if (s.equals("Special")) {
                specialCount++;
            } else {
                try {
                    int num = Integer.parseInt(s);
                    if (num < 0) negative.add(num);
                    else positive.add(num);
                } catch (NumberFormatException e) {
                    words.add(s);
                }
            }
        }

        bubbleSortIntAsc(negative);
        bubbleSortIntAsc(positive);
        bubbleSortStringAsc(words);

        List<String> resultAsc = new ArrayList<>();

        for (int i = 0; i < specialCount; i++)
            resultAsc.add("Special");

        for (int num : negative)
            resultAsc.add(String.valueOf(num));

        for (int num : positive)
            resultAsc.add(String.valueOf(num));

        resultAsc.addAll(words);

        for (int i = 0; i < nullCount; i++)
            resultAsc.add(null);

        System.out.println("Tang dan:");
        System.out.println(resultAsc);

        // ================= GIẢM DẦN =================
        List<String> resultDesc = new ArrayList<>();

        for (int i = 0; i < nullCount; i++)
            resultDesc.add(null);

        // chuỗi giảm
        for (int i = words.size() - 1; i >= 0; i--)
            resultDesc.add(words.get(i));

        // dương giảm
        for (int i = positive.size() - 1; i >= 0; i--)
            resultDesc.add(String.valueOf(positive.get(i)));

        // âm giảm
        for (int i = negative.size() - 1; i >= 0; i--)
            resultDesc.add(String.valueOf(negative.get(i)));

        for (int i = 0; i < specialCount; i++)
            resultDesc.add("Special");

        System.out.println("Giam dan:");
        System.out.println(resultDesc);
    }
}