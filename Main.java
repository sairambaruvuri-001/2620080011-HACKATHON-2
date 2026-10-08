import java.util.Scanner;

class Student {
    // Data members
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor to initialize student and course details
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Returns true if marks are 50 or above; otherwise false
    public boolean checkEligibility() {
        return this.marks >= 50;
    }

    // Calculates course fee assuming Rs. 1500 per credit
    public double calculateFee() {
        return this.courseCredits * 1500;
    }

    // Calculates scholarship amount based on marks criteria
    public double calculateScholarship(double totalFee) {
        if (this.marks >= 85) {
            return totalFee * 0.20; // 20% scholarship
        } else if (this.marks >= 70) {
            return totalFee * 0.10; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Calculates the final fee after deducting the scholarship amount
    public double calculateFinalFee(double totalFee, double scholarship) {
        return totalFee - scholarship;
    }

    // Displays all details if the student is eligible
    public void displayDetails() {
        double totalFee = calculateFee();
        double scholarship = calculateScholarship(totalFee);
        double finalFee = calculateFinalFee(totalFee, scholarship);

        System.out.println("\n--- Registration Successful ---");
        System.out.println("Student Name      : " + studentName);
        System.out.println("Roll Number       : " + rollNumber);
        System.out.println("Marks             : " + marks);
        System.out.println("Course Name       : " + courseName);
        System.out.println("Course Credits    : " + courseCredits);
        System.out.println("Status            : Eligible");
        System.out.println("Total Fee         : Rs. " + totalFee);
        System.out.println("Scholarship       : Rs. " + scholarship);
        System.out.println("Final Fee         : Rs. " + finalFee);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading inputs from user
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume leftover newline character

        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();

        // Create Student object using the parameterized constructor
        Student student = new Student(name, roll, marks, course, credits);

        // Check eligibility and process accordingly
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Denied: Student is not eligible for registration (Marks are below 50).");
        }

        scanner.close();
    }
}
