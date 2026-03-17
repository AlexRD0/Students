package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.swing.UIManager.get;
import static ro.ulbs.proiectaresoftware.students.Student.check;


public class Application {


    public static void main() {
        List<Student> s = new ArrayList<Student>();
        s.add(new Student(112, "Ioan", "Popa", "TI21/1"));
        s.add(new Student(112, "Maria", "Oprea", "TI21/1"));
        s.add(new Student(120, "Alis", "Popa", "TI21/2"));
        s.add(new Student(122, "Mihai", "Vecerdea", "TI22/1"));
        s.add(new Student(122, "Eugen", "Uritescu", "TI22/2"));


        System.out.println("Numar matricol   prenume     nume  formatie de studiu");
        for(Object element : s){
            System.out.println(element);
        }
        Set<Student> ss = new HashSet<>(s);
        if(ss.contains(new Student(120, "Alis", "Popa", "TI21/2"))) {
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
        if(ss.contains(new Student(112, "Maria", "Popa", "TI21/1"))) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}