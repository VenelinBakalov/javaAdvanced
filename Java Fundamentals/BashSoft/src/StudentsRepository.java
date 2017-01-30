import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentsRepository {
    public static boolean isDataInitialized = false;
    public static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void initializeData() {
        if (isDataInitialized) {
            System.out.println(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        studentsByCourse = new HashMap<String, HashMap<String, ArrayList<Integer>>>();
        readData();
    }

    public static void readData() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("")) {
            String[] tokens = input.split("\\s+");
            String course = tokens[0];
            String student = tokens[1];
            Integer mark = Integer.parseInt(tokens[2]);

            if (!studentsByCourse.containsKey(course)) {
                studentsByCourse.put(course, new HashMap<>());
            }
            if (!studentsByCourse.get(course).containsKey(student)) {
                studentsByCourse.get(course).put(student, new ArrayList<>());
            }

            studentsByCourse.get(course).get(student).add(mark);
            input = scanner.nextLine();
        }

        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read.");
    }
}
