package view.stream.demo;

import java.util.List;

public class Ex04FindingAndMatching {
    public static void main(String[] args) {
        // Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
        List<Integer> numbers = List.of(1, 2, 1, 4, 5, 8, 10, 4, 12);

        // 1st: is there any element that is divisible by 10
        boolean anyDivisibleBy10 = numbers.stream()
                                          .anyMatch(n -> n % 10 == 0);
        System.out.println("1st: Is there any element divisible by 10? " + anyDivisibleBy10);

        // 2nd: find the first element that is divisible by 4
        Integer firstDivisibleBy4 = numbers.stream()
                                           .filter(n -> n % 4 == 0)
                                           .findFirst()
                                           .orElse(null);
        System.out.println("2nd: First element divisible by 4: " + firstDivisibleBy4);

        // 3rd: find the elements that are divisible by 5 in the list
        List<Integer> divisibleBy5 = numbers.stream()
                                            .filter(n -> n % 5 == 0)
                                            .toList();
        System.out.println("3rd: Elements divisible by 5: " + divisibleBy5);

        // 4th: does all elements less than 100
        boolean allLessThan100 = numbers.stream()
                                        .allMatch(n -> n < 100);
        System.out.println("4th: Do all elements less than 100? " + allLessThan100);

        // 5th: does no elements greater than 0
        boolean noElementsGreaterThan0 = numbers.stream()
                                                .noneMatch(n -> n > 0);
        System.out.println("5th: Does no element greater than 0? " + noElementsGreaterThan0);
    }
}