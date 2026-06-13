package javaoops;

public class ClassAndObjectExample {

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Sourabh";
        student.marks = 85;

        student.printDetails();
    }
}

class Student {
    String name;
    int marks;

    void printDetails() {
        System.out.println(name + " scored " + marks);
    }
}
