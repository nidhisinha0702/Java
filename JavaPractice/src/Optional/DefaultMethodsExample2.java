package Optional;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodsExample2 {

    static Consumer<Student> studentConsumer = (student -> System.out.println(student));

    public static void sortByName(List<Student> studentList){
        System.out.println("After Sort:");
        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        studentList.sort(nameComparator);
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {

       List<Student> studentList = StudentDataBase.getAllStudents();
        //System.out.println(studentList);
        studentList.forEach(studentConsumer);
        System.out.println("Before Sort:");
        sortByName(studentList);

    }
}
