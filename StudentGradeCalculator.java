//STUDENT GRADE CALCULATOR
//        Input: Take marks obtained (out of 100) in each subject.
//        Calculate Total Marks: Sum up the marks obtained in all subjects.
//        Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
//        average percentage.
//        Grade Calculation: Assign grades based on the average percentage achieved.
//        Display Results: Show the total marks, average percentage, and the corresponding grade to the user
//


import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            // Input Student Name
            System.out.print("\nEnter Student Name: ");
            scanner.nextLine(); // consume leftover newline
            String studentName = scanner.nextLine();

            // Input number of subjects
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            String[] subjectNames = new String[numSubjects];
            int[] marks = new int[numSubjects];
            int totalMarks = 0;
            int highest = Integer.MIN_VALUE;
            int lowest = Integer.MAX_VALUE;

            // Input marks and subject names
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter name of subject " + (i + 1) + ": ");
                scanner.nextLine(); // consume newline
                subjectNames[i] = scanner.nextLine();

                System.out.print("Enter marks for " + subjectNames[i] + " (out of 100): ");
                int mark = scanner.nextInt();

                // Validate marks input
                while (mark < 0 || mark > 100) {
                    System.out.print("Invalid marks. Enter again (0–100): ");
                    mark = scanner.nextInt();
                }

                marks[i] = mark;
                totalMarks += mark;

                // Track highest and lowest
                if (mark > highest) highest = mark;
                if (mark < lowest) lowest = mark;
            }

            // Calculate average
            double average = (double) totalMarks / numSubjects;

            // Grade Calculation
            String grade;
            String remark;
            if (average >= 90) {
                grade = "A+";
                remark = "Excellent! Keep it up.";
            } else if (average >= 80) {
                grade = "A";
                remark = "Very Good!";
            } else if (average >= 70) {
                grade = "B";
                remark = "Good job!";
            } else if (average >= 60) {
                grade = "C";
                remark = "Can improve.";
            } else if (average >= 50) {
                grade = "D";
                remark = "Needs Improvement.";
            } else {
                grade = "F";
                remark = "Fail. Try harder next time.";
            }

            // Display result
            System.out.println("\n--- Student Report ---");
            System.out.println("Name: " + studentName);
            System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
            System.out.printf("Average Percentage: %.2f%%\n", average);
            System.out.println("Grade: " + grade);
            System.out.println("Highest Marks: " + highest);
            System.out.println("Lowest Marks: " + lowest);
            System.out.println("Remarks: " + remark);

            // Option to continue
            System.out.print("\nDo you want to calculate grades for another student? (yes/no): ");
            scanner.nextLine(); // consume newline
            String choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("yes")) {
                continueProgram = false;
                System.out.println("Thank you for using the Student Grade Calculator!");
            }
        }

        scanner.close();
    }
}
