package Bai4;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Person {
    private String name;
    private String gender;
    private String address;
    private List<String> hobbies;
    private LocalDate birthDate;

    public Person(String name, String gender, String address, List<String> hobbies, LocalDate birthDate) {
        this.name = name;
        this.gender = gender.toLowerCase();
        this.address = address;
        this.hobbies = normalizeHobbies(hobbies);
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public int getAgeDifference(Person other) {
        return Math.abs(Period.between(this.birthDate, other.birthDate).getYears());
    }

    public List<String> getCommonHobbies(Person other) {
        Set<String> set1 = new HashSet<>(this.hobbies);
        Set<String> set2 = new HashSet<>(other.hobbies);
        set1.retainAll(set2);
        return new ArrayList<>(set1);
    }

    private List<String> normalizeHobbies(List<String> rawHobbies) {
        List<String> normalized = new ArrayList<>();
        for (String hobby : rawHobbies) {
            String h = hobby.trim().toLowerCase();
            if (h.equals("múa hát") || h.equals("mua hat")) {
                h = "múa hát";
            }
            normalized.add(h);
        }
        return normalized;
    }

    public void printInfo() {
        System.out.println("Họ tên: " + name);
        System.out.println("Giới tính: " + gender);
        System.out.println("Địa chỉ: " + address);
        System.out.println("Ngày sinh: " + birthDate);
        System.out.println("Sở thích: " + String.join(", ", hobbies));
    }

}