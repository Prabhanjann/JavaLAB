import java.util.Scanner;

public class Student {
    private String name;
    private String usn;
    private int[] credits;
    private int[] marks;
    private int n;

    public void acceptDetails() {
        Scanner student = new Scanner(System.in);

        System.out.println("Enter your name:");
        name = student.nextLine(); 

        System.out.println("Enter USN:");
        usn = student.nextLine();

        System.out.println("Enter no of subjects:");
        n = student.nextInt();

        credits = new int[n];
        marks = new int[n];

        System.out.println("Enter no of credits in each sub:");
        for (int i = 0; i < n; i++) {
            credits[i] = student.nextInt();
        }

        System.out.println("Enter no of marks in each sub:");
        for (int i = 0; i < n; i++) {
            marks[i] = student.nextInt();
        }

        student.close();
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.println("Credits and Marks:");

        for (int i = 0; i < n; i++) {
            System.out.println(credits[i] + " " + marks[i]);
        }
    }

    public void calcSGPA() {
        int total = 0;
        int cred = 0;

        for (int i = 0; i < n; i++) {
            total += credits[i] * marks[i];
            cred += credits[i];
        }

        double sgpa = (double) total / cred;
        System.out.println("SGPA: " + sgpa);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.acceptDetails();
        student.displayDetails();
        student.calcSGPA();
    }
}
