import java.util.*;

public class SubjectGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> allGrades = new ArrayList<>();
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter grade for Subject " + i + " (maximum 100): ");
            double grade = scanner.nextDouble();
            scanner.nextLine();
            // Ensure grade does not exceed 100
            if (grade > 100.0) {
                grade = 100.0;
                System.out.println("Grade adjusted to 100.0 for Subject " + i);
            }
            allGrades.add(grade);
        }
        // Calculate overall average grade
        double overallAverage = calculateOverallAverage(allGrades);
        // Display results
        System.out.println("Overall Average Grade: " + overallAverage);
        System.out.println("Overall Letter Grade: " + calculateLetterGrade(overallAverage));
        System.out.println("Overall GPA: " + calculateGPA(overallAverage));
        scanner.close();
    }

    public static double calculateOverallAverage(List<Double> grades) {
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return (grades.size() > 0) ? sum / grades.size() : 0.0;
    }

    public static String calculateLetterGrade(double average) {
        double maxGrade = 100.0;
        double normalizedAverage = (average / maxGrade) * 100.0;
        if (normalizedAverage >= 90) {
            return "A";
        } else if (normalizedAverage >= 80) {
            return "B";
        } else if (normalizedAverage >= 70) {
            return "C";
        } else if (normalizedAverage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static double calculateGPA(double average) {
        double maxGrade = 100.0;
        double normalizedAverage = (average / maxGrade) * 100.0;
        if (normalizedAverage >= 90) {
            return 4.0;
        } else if (normalizedAverage >= 80) {
            return 3.0;
        } else if (normalizedAverage >= 70) {
            return 2.0;
        } else if (normalizedAverage >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}
