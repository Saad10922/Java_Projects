import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        boolean isRunning = true;

        System.out.println("=== Student Grade Tracker ===");

        while (isRunning) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a Grade");
            System.out.println("2. View All Grades");
            System.out.println("3. Calculate Average, Highest, and Lowest Scores");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the student's grade (0-100): ");
                    double grade = scanner.nextDouble();
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                    }
                }
                case 2 -> {
                    System.out.println("\n=== All Grades ===");
                    if (grades.isEmpty()) {
                        System.out.println("No grades recorded yet.");
                    } else {
                        for (int i = 0; i < grades.size(); i++) {
                            System.out.println("Student " + (i + 1) + ": " + grades.get(i));
                        }
                    }
                }
                case 3 -> {
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to calculate statistics.");
                    } else {
                        double sum = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;

                        for (double grade : grades) {
                            sum += grade;
                            if (grade > highest) highest = grade;
                            if (grade < lowest) lowest = grade;
                        }

                        double average = sum / grades.size();
                        System.out.println("\n=== Grade Statistics ===");
                        System.out.printf("Average Grade: %.2f%n", average);
                        System.out.printf("Highest Grade: %.2f%n", highest);
                        System.out.printf("Lowest Grade: %.2f%n", lowest);
                    }
                }
                case 4 -> {
                    isRunning = false;
                    System.out.println("Exiting the program. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
