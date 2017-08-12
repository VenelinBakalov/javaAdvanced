import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String line = "";

        while (!"END".equals(line = reader.readLine())) {

        }

        for (int i = 1; i < inputData.size(); i++) {
            String[] tokens = inputData.get(i).split("\\s+");

            String facultyNumber = tokens[0];
            String firstName = tokens[1];
            String lastName = tokens[2];
            String email = tokens[3];
            Integer age = Integer.parseInt(tokens[4]);
            Integer group = Integer.valueOf(tokens[5]);
            List<Integer> grades = new ArrayList<>();
            Stream.of(tokens).skip(6).limit(4).mapToInt(Integer::parseInt).forEach(grades::add);
            String phone = tokens[tokens.length - 1];

            Student student = new Student(facultyNumber, firstName, lastName, email, age, group, grades, phone);
            students.add(student);
        }

        /*
        1.	Students by Group
         students.stream()
                .filter(s -> s.getGroup() == 2)
                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
         */

        /*
        2.	Students by First and Last Name
               students.stream()
                .filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

        System.out.println("-------------Next task");
         */

        /*
        3.	Students by Age
          students.stream()
                .filter(s -> 18 <= s.getAge() && s.getAge() <= 24)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getAge()));
         */

        /*
        4.	Sort Students
        ---------My way :
        students.stream()
                .sorted((s1, s2) -> {
                    if (s1.getLastName().compareTo(s2.getLastName()) == 0) {
                        return s2.getFirstName().compareTo(s1.getFirstName());
                    }
                    return s1.getLastName().compareTo(s2.getLastName());
                })
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

        ----------From hints : WITH 2 COMPARATORS!
                Comparator<Student> lastAscending =
                (s1, s2) -> s1.getLastName().compareTo(s2.getLastName());

        Comparator<Student> studentComparator =
                lastAscending
                .thenComparing((s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName()));

        students.stream()
                .sorted(studentComparator)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
         */

        /*
        5.	Filter Students by Email Domain
        students.stream()
                .filter(s -> s.getEmail().endsWith("@gmail.com"))
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getEmail()));
         */

        /*
        6.	Filter Students by Phone
           students.stream()
                .filter(s -> s.getPhone().startsWith("02") || s.getPhone().startsWith("+3592"))
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getPhone()));
         */

        /*
        7.	Excellent Students
             students.stream()
                .filter(s -> s.getGrades().contains(6))
                .forEach(s -> {
                    System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
                    s.getGrades().stream()
                            .sorted((g1, g2) -> g2.compareTo(g1))
                            .forEach(g -> System.out.print(g + " "));
                    System.out.println();
                });
         */

        /*
        8.	Weak Students
              students.stream()
              .filter(s -> s.getGrades().stream.filter(g -> g <= 3).count() > 2)
                .filter(s -> {
                    List<Integer> grades = s.getGrades().stream()
                            .filter(g -> g <= 3)
                            .collect(Collectors.toList());

                    return grades.size() >= 2;
                })
                .sorted((s1, s2) ->
                        Integer.compare(s1.getGrades().stream().mapToInt(x -> x).sum(),
                                s2.getGrades().stream().mapToInt(x -> x).sum()))
                .forEach(s -> {
                    System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
                    s.getGrades().stream()
                            .sorted(Integer::compareTo) // (g1, g2) -> g1.compareTo(g2)
                            .forEach(g -> System.out.print(g + " "));
                    System.out.println();

                    gosho.getGrades().stream().sorter().map(String:vvalueOf).collect(Collectors.joining(" "))
                });
         */

        /*
        9.  Students by Enrollment Year
        Map<Integer, List<Student>> studentsByYear = students.stream()
                .collect(Collectors.groupingBy(
                        s -> Integer.valueOf(
                                s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2)
                        )
                ));

        studentsByYear.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e1.getKey(), e2.getKey()))
                .forEach(e -> {
                    System.out.println("20" + e.getKey() + ":");
                    e.getValue().stream()
                            .sorted((s1, s2) -> (s1.getFirstName() + s1.getLastName())
                                    .compareTo(s2.getFirstName() + s2.getLastName()))
                            .forEach(s -> System.out.println("-- " + s.getFirstName() + " " + s.getLastName()));
                });

        */

    }
}
