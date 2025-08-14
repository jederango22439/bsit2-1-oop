public class Student {
    private String name;
    private int age;
    private String course;
    private double grade1, grade2, grade3;

    public Student(String name, int age, String course, double grade1, double grade2, double grade3) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public void displayInfo() {
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
    }

    public double calculateAverage() {
        return (grade1 + grade2 + grade3) / 3;
    }

    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public boolean isPassing() {
        return calculateAverage() >= 70;
    }
}
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Miguel Angelo", 20, "Computer Science", 85, 90, 87);
        Student s2 = new Student("France Audrey", 22, "Mathematics", 65, 70, 68);
        Student s3 = new Student("Iniego Suarez", 21, "Engineering", 55, 60, 58);

        Student[] students = {s1, s2, s3};
        int passingCount = 0;

        for (Student s : students) {
            s.displayInfo();
            double avg = s.calculateAverage();
            System.out.printf("Average Grade : %.2f\n", avg);
            System.out.println("Letter Grade  : " + s.getLetterGrade());
            System.out.println("Status        : " + (s.isPassing() ? "PASSING" : "FAILING"));
            System.out.println("----------------------------------");

            if (s.isPassing()) {
                passingCount++;
            }
        }

        System.out.println("Total Number of Students Passing: " + passingCount);
    }
}
