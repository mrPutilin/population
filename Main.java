package core.hw2.population;

import java.util.*;


public class Main  {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Conor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(names.get(new Random().nextInt(names.size())), families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100), Sex.values()[new Random().nextInt(Sex.values().length)], Education.values()
            [new Random().nextInt(Education.values().length)]));
        }
        long count = persons.stream()
                .filter(age -> age.getAge() < 18)
                .count();
        System.out.println(count);

        List<String> recruit = persons.stream()
                .filter(age -> age.getAge() >= 18 && age.getAge() <= 27)
                .map(Person::getFamily).toList();
        System.out.println(recruit);

        List<Person> worker = persons.stream()
                .filter(age -> age.getAge() >= 18 && age.getAge() <= 65 && age.getSex() == Sex.MAN ||
                        age.getAge() >= 18 && age.getAge() <= 60 && age.getSex() == Sex.WOMAN)
                .filter(education -> education.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily)).toList();
        for (Person s : worker) {
            System.out.println(s);
        }


    }
}
