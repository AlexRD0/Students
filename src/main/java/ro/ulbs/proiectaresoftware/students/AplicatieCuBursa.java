package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

public class AplicatieCuBursa {
    static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentBursier> lista = instanta.genereaza();
        for (StudentBursier student : lista) {
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------");
        List<StudentBursier> sortata = instanta.sorteaza(lista);
        for (StudentBursier student : sortata) {
            System.out.println(student);
        }
    }
    public List<StudentBursier> genereaza() {
        List<StudentBursier> lista = new ArrayList<>();
        lista.add( new StudentBursier(1025,"Andrei","Popa","ISM141/2", 8.70, 725.50));
        lista.add( new StudentBursier(1024,"Ioan","Mihalcea","ISM141/1", 9.80, 801.10));
        lista.add( new StudentBursier(1029,"Bianca","Popescu","TI131/1,", 9.10, 780.80));
        lista.add( new StudentBursier(1026,"Anamaria","Prodan","TI131/1", 8.90, 745.50));
        lista.add( new StudentBursier(1029,"Bianca","Popescu","TI131/1,", 9.10, 100.00));
        return lista;
    }
    public List<StudentBursier> sorteaza(List<StudentBursier> lst) {
// aici implementati logica pentru sortare:
// Comparati formatia de studiu, apoi numele, apoi prenumele, apoi nota, apoi cuantumul bursei
// apoi returnati lista.
        for(int i=0;i<lst.size();i++) {
            for(int j=i+1;j<lst.size();j++) {
                if(lst.get(i).getFormatieDeStudiu().compareTo(lst.get(j).getFormatieDeStudiu())>0) {
                    swap(lst,i,j);
                }
                else if(lst.get(i).getFormatieDeStudiu().equals(lst.get(j).getFormatieDeStudiu())) {
                    if(lst.get(i).getNume().compareTo(lst.get(j).getNume())>0) {
                        swap(lst, i, j);
                    }
                    else if(lst.get(i).getNume().equals(lst.get(j).getNume())) {
                        if(lst.get(i).getPrenume().compareTo(lst.get(j).getPrenume())>0) {
                            swap(lst, i, j);
                        }
                        else if(lst.get(i).getPrenume().equals(lst.get(j).getPrenume())) {
                            if(lst.get(i).getNota()>(lst.get(j).getNota())){
                                swap(lst, i, j);
                        }
                            else if(lst.get(i).getNota()==(lst.get(j).getNota())) {
                                if(lst.get(i).getCuantumBursa()>lst.get(j).getCuantumBursa()) {
                                    swap(lst, i, j);
                                }
                            }
                    }
                }
                }
            }
        }
        return lst;
    }

    private void swap(List<StudentBursier> lst, int i, int j) {
        StudentBursier temp = lst.get(i);
        lst.set(i, lst.get(j));
        lst.set(j, temp);
    }
}
