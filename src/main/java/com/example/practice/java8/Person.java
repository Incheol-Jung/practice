package com.example.practice.java8;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

/**
 * @author Incheol Jung
 */
@Getter
@Setter
public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int ageDifference(final Person other) {
        return age - other.age;
    }

    public static void main(String[] args) throws IOException {
        // 단순 정렬
        List<Person> people = new ArrayList<>();
        people.stream().sorted((person1, person2) -> person1.ageDifference(person2)).collect(toList());

        // 메서드 레퍼런스 정렬
        people.stream().sorted(Person::ageDifference).collect(toList());

        // 내림 차순 정렬
        people.stream().sorted((person1, person2) -> person2.ageDifference(person1)).collect(toList());

        // 내림 차순 코드 재사용
        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        people.stream().sorted(compareDescending).collect(toList());

        // 이름 순으로 정렬
        people.stream().sorted((person1, person2) -> person1.getName().compareTo(person2.getName())).collect(toList());

        // 이름 순으로 정렬 메소드 레퍼런스
        people.stream().sorted(comparing(Person::getName)).collect(toList());

        // 리스트에서 가장 젊은 사람을 선택한다
        people.stream().min(Person::ageDifference).ifPresent(youngest -> System.out.println("youngest: " + youngest));

        // comparing 메서드 사용
        final Function<Person, String> byName = person -> person.getName();
        people.stream().sorted(comparing(byName));

        // comparing 다중 메서드 사용
        final Function<Person, Integer> byAge = person -> person.getAge();
        people.stream().sorted(comparing(byAge).thenComparing(byName));

        // 20살 이상의 사람들을 추려내자
        List<Person> olderThan20 = new ArrayList<>();
        people.stream().filter(person -> person.getAge() > 20).forEach(person -> olderThan20.add(person));

        // 20살 이상의 사람들을 추려내자(리팩토링)
        people.stream()
              .filter(person -> person.getAge() > 20)
              .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // 20살 이상의 사람들을 추려내자(리팩토링2)
        people.stream().filter(person -> person.getAge() > 20).collect(Collectors.toList());

        // 사람들을 나이를 값으로 사용해서 그룹으로 묶는 groupingBy()
        people.stream().collect(groupingBy(Person::getAge));

        // 그룹핑 예제 2
        people.stream().collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));

        // 첫 번째 문자로 이름을 그룹핑하고 나서 각 그룹에서 가장 나이가 많은 사람
        Comparator<Person> byAgeGroup = Comparator.comparing(Person::getAge);
        people.stream()
              .collect(groupingBy(person -> person.getName().charAt(0), reducing(BinaryOperator.maxBy(byAgeGroup))));

        // 현재 디렉터리에 있는 모든 파일의 이름 출력
        Files.list(Paths.get(".")).forEach(System.out::println);

        // 현재 디렉터리에 있는 모든 파일의 이름 출력
        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

        // 선택한 파일들 출력
        final String[] files = new File("fpij").list((dir, name) -> name.endsWith(".java"));

        List<File> finalFiles = new ArrayList<>();
        File[] filesInCurrectDir = new File(".").listFiles();
        for (File file : filesInCurrectDir) {
            File[] filesInSubDir = file.listFiles();
            if (filesInSubDir != null) {
                finalFiles.addAll(Arrays.asList(filesInSubDir));
            } else {
                finalFiles.add(file);
            }
        }

        Stream.of(new File(".").listFiles())
              .flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
              .collect(toList());
    }
}
