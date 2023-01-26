package org.sagar.java8.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainPersonApp {
    public static void main(String[] args) {

        String abc = "My String";
        String pqr = "My String";

        if (abc == pqr) System.out.println("Same object");
        else System.out.println("Different object");

        List<Person> personList = new ArrayList<>();

        personList.add(new Person(1, "Person 1", 35));
        personList.add(new Person(2, "Person 2", 40));
        personList.add(new Person(3, "Person 3", 42));

        personList.stream()
                .map(person -> person.getAge())
                .filter(age -> age >= 40)
                .forEach(System.out::println);

        Map<Integer, String> collect = personList.stream()
                .filter(person -> person.getAge() >= 40)
                .collect(Collectors.toMap(Person::getAge, Person::getName));

        collect.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
