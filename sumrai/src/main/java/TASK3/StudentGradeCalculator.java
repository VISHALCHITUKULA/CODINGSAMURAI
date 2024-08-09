
package TASK3;
import java.util.*;
public class StudentGradeCalculator {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double assignmentGrade = getValidGrade("Enter your assignment grade: ");
        double quizGrade = getValidGrade("Enter your quiz grade: ");
        double midtermGrade = getValidGrade("Enter your midterm exam grade: ");
        double finalExamGrade = getValidGrade("Enter your final exam grade: ");

        double finalGrade = calculateFinalGrade(assignmentGrade, quizGrade, midtermGrade, finalExamGrade);
        char letterGrade = getLetterGrade(finalGrade);

        System.out.printf("Your final grade is: %.2f\n", finalGrade);
        System.out.println("Your letter grade is: " + letterGrade);
    }
    private static double getValidGrade(String prompt) {
        double grade = -1;
        while (grade < 0 || grade > 100) {
            System.out.print(prompt);
            try {
                grade = Double.parseDouble(scanner.nextLine());
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return grade;
    }
    private static double calculateFinalGrade(double assignmentGrade, double quizGrade, double midtermGrade, double finalExamGrade) 
    {
        double finalGrade = (assignmentGrade * 0.3) + (quizGrade * 0.2) + (midtermGrade * 0.2) + (finalExamGrade * 0.3);
        return finalGrade;
    }
    private static char getLetterGrade(double finalGrade) {
        if (finalGrade >= 90) {
            return 'A';
        } else if (finalGrade >= 80) {
            return 'B';
        } else if (finalGrade >= 70) {
            return 'C';
        } else if (finalGrade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
