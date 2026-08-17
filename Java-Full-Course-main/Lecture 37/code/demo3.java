import java.util.*;

public class demo3{

    public static void main(String[] args) {
        // List<Student> list = new ArrayList<>();
        // list.add(new Student("Aditya", 101, 85));
        // list.add(new Student("Rohit", 102, 89));
        // list.add(new Student("Rohan", 103, 93));
        // list.add(new Student("Sonu", 104, 98));

        // Comparator<Student> c1 = new SortByName();

        // // Collections.sort(list, c1);

        // //anonymous class
        // Collections.sort(list, new Comparator<Student>(){
        //     @Override
        //     public int compare(Student s1, Student s2){
        //         return s1.name.compareTo(s2.name);
        //     }
        // });

        // Calculator c = new Addition();
        // c.calculate(5,4);

        print(5,4, (a,b)->a+b);

    }

    public static void print(int a, int b, Calculator c){
        System.out.println(c.calculate(a,b));
    }
}

@FunctionalInterface
Interface Calculator{
    int calculate(int a, int b);
}

// class Addition implements Calculator{
//     @Override
//     public int calculate(int a, int b) return a+b;
// }

// class SortByName implements Comparator<Student> {
//     @Override
//     public int compare(Student s1, Student s2){
//         return s1.name.compareTo(s2.name);
//     }
// }

// class SortByMarks implements Comparator<Student> {
//     @Override
//     public int compare(Student s1, Student s2){
//         return s1.marks - s2.marks;
//     }
// }






class Student {
    String name;
    int rollNo;
    int marks;

    public Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }
}
