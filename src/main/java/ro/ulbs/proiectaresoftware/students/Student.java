package ro.ulbs.proiectaresoftware.students;

import java.util.List;
import java.util.Map;

public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;
    private double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public void setNota(double nota) {
        this.nota = nota;
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
    public double getNota() {
        return nota;
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

    public static double gasesteNota(String prenume, String nume, Map<String, Student> tineri){
        String key = prenume + nume;
        Student student = tineri.get(key);

        if(student == null){
            return 0.0;
        }

        return student.getNota();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%7d %14s %12s %12s %12.2f", numarMatricol, prenume, nume, formatieDeStudiu, nota);
    }
}
