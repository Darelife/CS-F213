
/*Student can implement the necessary Interface */
public class Student implements Comparable<Student> {
    public String name;
    public int age;
    public Degree degree;
    public int[] marks;
    public double cgpa;

    public Student (String name, int age, Degree degree, int[] marks) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.marks = marks;
        this.cgpa = degree.getCGPACalculation(marks);
    }

    public double getCGPA() {
        return cgpa;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getDegreeName() {
        return degree.getDegreeName();
    }

    @Override
    public int compareTo(Student o) {
        if (this.cgpa > o.cgpa) {
            return -1;
        } else if (this.cgpa < o.cgpa) {
            return 1;
        } else {
            if (this.age < o.age) {
                return -1;
            } else if (this.age> o.age) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
