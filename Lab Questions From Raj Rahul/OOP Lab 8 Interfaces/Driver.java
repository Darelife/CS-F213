import java.util.Arrays;

public class Driver {

    public static void processStudents(Student[] students) {

        /* Write your code here */

        int i = 1;
        for (Student student : students) {
            if (student != null) {
                System.out.print(i + ")Name: " + student.name);
                System.out.print(", Age: " + student.age);
                System.out.print(", CGPA: " + String.format("%.3f", student.cgpa));
                System.out.print("  ");
            }
            i++;
        }
    }
}
