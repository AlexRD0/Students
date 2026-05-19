package ro.ulbs.proiectaresoftware.students;

//import jdk.internal.org.jline.utils.InfoCmp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static javax.swing.UIManager.get;
//import static jdk.internal.org.jline.utils.InfoCmp.Capability.lines;
import static ro.ulbs.proiectaresoftware.students.Student.check;


public class Application {


    public static void main(String[] args) {
        List<Student> s = new ArrayList<Student>();
        s.add(new Student(112, "Ioan", "Popa", "TI21/1"));
        s.add(new Student(112, "Maria", "Oprea", "TI21/1"));
        s.add(new Student(120, "Alis", "Popa", "TI21/2"));
        s.add(new Student(122, "Mihai", "Vecerdea", "TI22/1"));
        s.add(new Student(122, "Eugen", "Uritescu", "TI22/2"));


        System.out.println("Numar matricol   prenume     nume  formatie de studiu");
        for (Object element : s) {
            System.out.println(element);
        }

        int mijloc = (s.size() + 1) / 2;
        for (int i = 0; i < s.size(); i++) {
            if (i < mijloc) {
                mutaStudent(s, s.get(i), "TI21/1");
            } else {
                mutaStudent(s, s.get(i), "TI21/2");
            }
        }

        System.out.println("Dupa impartirea in doua formatii:");
        for (Student student : s) {
            System.out.println(student);
        }

        Set<Student> ss = new HashSet<>(s);
        if (ss.contains(new Student(120, "Alis", "Popa", "TI21/2"))) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        if (ss.contains(new Student(112, "Maria", "Popa", "TI21/1"))) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        try{
            printTextTerminal("studenti_in.txt");
        } catch(IOException e){
            e.printStackTrace();
        }
        try {
            printLargerTextFile("studenti_in.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<Integer, Student> studenti = new HashMap<>();
        try{
            printToHashMap("studenti_in.txt", studenti);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try{
            addNota("note_anon.txt", studenti);
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Numar matricol   prenume     nume  formatie de studiu    nota");
        for (Student student : studenti.values()) {
            System.out.println(student);
        }

        HashMap<String, Student> tineri = new HashMap<>();
        for (Student student : studenti.values()) {
            String key = student.getPrenume() + " " + student.getNume();
            tineri.put(key, student);
        }

        double notaM = gasesteNota("Bianca", "Popescu", tineri);
        double notaN = gasesteNota("Ioan", "Popa", tineri);

        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Popa: " + notaN);

        //laborator 5

        List<Student> bursieri = new ArrayList<>();
        bursieri.add( new StudentBursier(1025,"Andrei","Popa","ISM141/2", 8.70, 725.50));
        bursieri.add( new StudentBursier(1024,"Ioan","Mihalcea","ISM141/1", 9.80, 801.10));
        bursieri.add( new StudentBursier(1026,"Anamaria","Prodan","TI131/1", 8.90, 745.50));
        bursieri.add( new StudentBursier(1029,"Bianca","Popescu","TI131/1,", 9.10, 780.80));

        try{
            writeLargerTextFile(bursieri, "bursieri_out.txt");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    static void printLargerTextFile(String fileName) throws IOException {
        System.out.println("Using Scanner:");
        Path path = Paths.get(fileName);
        try (Scanner scanner = new Scanner(path)){
            List<Student> lista = new ArrayList<>();
            while (scanner.hasNextLine()){
//process each line in some way
//                System.out.println(": " + scanner.nextLine());
                String line = scanner.nextLine();

                String[] parts = line.split(",");

                int nrMatricol = Integer.parseInt(parts[0]);
                String prenume = parts[1];
                String nume = parts[2];
                String grupa = parts[3];

                lista.add(new Student(nrMatricol, prenume, nume, grupa));
            }
            lista.sort(Comparator.comparing(Student::getNume));
            try {
                System.out.print("Writing outfile1.txt ... ");
                writeLargerTextFile(lista, "studenti_out.txt");
                System.out.println("done");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //tema de casa lab3
            lista.sort(Comparator.comparing(Student::getFormatieDeStudiu));
            lista.sort(Comparator.comparing(Student::getNume));
            try {
                System.out.print("Writing outfile1.txt ... ");
                writeLargerTextFile(lista, "studenti_out_sorted.txt");
                System.out.println("done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void printTextTerminal(String fileName) throws IOException {
        System.out.println("Using Scanner:");
        Path path = Paths.get(fileName);
        try (Scanner scanner = new Scanner(path)){
            while (scanner.hasNextLine()){
//process each line in some way
                System.out.println(": " + scanner.nextLine());
            }
        }
    }

    static void printToHashMap(String fileName, HashMap<Integer, Student> map) throws IOException {
        System.out.println("Lista HashMap:");
        Path path = Paths.get(fileName);
        try (Scanner scanner = new Scanner(path)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                int nrMatricol = Integer.parseInt(parts[0]);
                String prenume = parts[1];
                String nume = parts[2];
                String grupa = parts[3];

                Student student = new Student(nrMatricol, prenume, nume, grupa);
                map.put(nrMatricol, student);
            }
        }
    }

    static void addNota(String fileName, HashMap<Integer, Student> map) throws IOException {
        System.out.println("Adauga note:");
        Path path = Paths.get(fileName);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                int nrMatricol = Integer.parseInt(parts[0]);
                double nota = Double.parseDouble(parts[1]);

                Student student = map.get(nrMatricol);
                if (student != null) {
                    Student studentCuNota = new Student(
                            student.getNumarMatricol(),
                            student.getPrenume(),
                            student.getNume(),
                            student.getFormatieDeStudiu(),
                            nota
                    );
                    map.put(nrMatricol, studentCuNota);
                }
            }
        }
    }

    static double gasesteNota(String prenume, String nume, Map<String, Student> map) {
        String key = prenume + " " + nume;
        Student student = map.get(key);

        if (student == null) {
            return 0.0;
        }

        return student.getNota();
    }

    static void writeLargerTextFile(List<Student> lines, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            for(Student line : lines){
                writer.write(String.valueOf(line));
                writer.newLine();
            }
        }
    }

    static void mutaStudent(List<Student> s, Student student, String grupa) {
        int poz = -1;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == student) {
                poz = i;
                break;
            }
        }

        if (poz == -1) {
            return;
        }

        Student nou = new Student(
                student.getNumarMatricol(),
                student.getPrenume(),
                student.getNume(),
                grupa,
                student.getNota()
        );

        s.set(poz, nou);
    }
}
