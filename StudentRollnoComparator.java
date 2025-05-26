import java.util.Comparator;

public class StudentRollnoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // compare students by roll number
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}