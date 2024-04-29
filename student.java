public class GradeCalculator {
    public static void main(String[] args) {
        int[] marks = {85, 92, 78, 89, 95}; // Example marks for 5 subjects
        
        // Calculate Total Marks
        int totalMarks = calculateTotalMarks(marks);
        System.out.println("Total Marks: " + totalMarks);
        
        // Calculate Average Percentage
        double averagePercentage = calculateAveragePercentage(marks);
        System.out.println("Average Percentage: " + averagePercentage);
        
        // Grade Calculation: Assign grades based on the average percentage achieved.
        char grade = calculateGrade(averagePercentage);
        
        // Display Results: Show the total marks, average percentage, and the corresponding grade to the user
        System.out.println("Grade: " + grade);
    }
    
    public static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }
    
    public static double calculateAveragePercentage(int[] marks) {
        int totalMarks = calculateTotalMarks(marks);
        return (double) totalMarks / marks.length;
    }
    
    public static char calculateGrade(double averagePercentage) {
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        return grade;
    }
}
