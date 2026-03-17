package ro.ulbs.proiectaresoftware.students;

import java.util.List;

public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }
    public String getPrenume() {
        return prenume;
    }
    public String getNume() {
        return nume;
    }
    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public static boolean check(List<Student> s, Student S){
        for(int i=0; i < s.size(); i++) {
            Object element = s.get(i);
            if (element == S) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%7d %14s %12s %8s", numarMatricol, prenume, nume, formatieDeStudiu);
    }
}
