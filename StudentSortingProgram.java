import java.util.ArrayList;
import java.util.Scanner;

public class StudentSortingProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // creating ArrayList to store 10 student objects
        ArrayList<Student> students = new ArrayList<>();
        
        System.out.println("Enter details for 10 students:");
        System.out.println("=====================================");
        
        // get input for 10 students
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nStudent " + i + ":");
            System.out.print("Enter roll number: ");
            int rollno = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            
            students.add(new Student(rollno, name, address));
        }
        
        System.out.println("\n=====================================");
        System.out.println("Original list of students:");
        printStudents(students);
        
        // create comparator instance
        StudentRollnoComparator comparator = new StudentRollnoComparator();
        
        // sort using custom merge sort
        MergeSortUtil.mergeSort(students, comparator);
        
        System.out.println("\nStudents sorted by roll number using merge sort:");
        printStudents(students);
        
        // closing scanner
        scanner.close();
    }
    
    // helper method for output
    private static void printStudents(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }
}