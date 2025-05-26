public class Student {
    private int rollno;
    private String name;
    private String address;
    
    // constructor
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    
    // getter methods
    public int getRollno() {
        return rollno;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    // setter methods
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    // better display method
    @Override
    public String toString() {
        return "Student{rollno=" + rollno + ", name='" + name + "', address='" + address + "'}";
    }
}