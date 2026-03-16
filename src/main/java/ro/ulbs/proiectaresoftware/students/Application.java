package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

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
        System.out.println(get(new Student(120, "Alis", "Popa", "TI21/2")));
        System.out.println(get(new Student(112, "Maria", "Popa", "TI21/1")));
    }
}