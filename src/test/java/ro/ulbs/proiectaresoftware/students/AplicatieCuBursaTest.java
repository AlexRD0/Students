package ro.ulbs.proiectaresoftware.students;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AplicatieCuBursaTest {
    private AplicatieCuBursa bursa;

    @BeforeEach
    public void setup() {bursa = new AplicatieCuBursa();}

    @Test
    public void sorteazaLista() {
        List<StudentBursier> lista = bursa.genereaza();
        List<StudentBursier> sortat = bursa.sorteaza(lista);

        assertEquals(5, sortat.size());

        assertEquals(1024, sortat.get(0).getNumarMatricol());
        assertEquals(1025, sortat.get(1).getNumarMatricol());
        assertEquals(1026, sortat.get(2).getNumarMatricol());

        assertEquals(1029, sortat.get(3).getNumarMatricol());
        assertEquals(100.00, sortat.get(3).getCuantumBursa(), 0.001);

        assertEquals(1029, sortat.get(4).getNumarMatricol());
        assertEquals(780.80, sortat.get(4).getCuantumBursa(), 0.001);
    }

    @Test
    public void sorteazaListaGoala() {
        List<StudentBursier> lista = new ArrayList<>();
        List<StudentBursier> sortat = bursa.sorteaza(lista);

        assertEquals(0, sortat.size());
    }

    @AfterEach
    public void tearDown() {bursa = null;}
}
