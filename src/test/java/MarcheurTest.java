import org.example.carte.Carte;
import org.example.marcheur.Intinerance;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarcheurTest {


    @Test

    public void HEI_a_Esti() {
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Hei", "Sekoly", "Marais", "Sekoly", "Hei", "Balancoire", "Boulvard", "Esti");

        List<String> result = bjani.marche("Hei", "Esti");
        assertEquals(expected, result);

    }

    @Test
    public void HEI_a_Marais() {
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Hei", "Sekoly", "Balancoire", "Esti", "Boulvard",
                "Balancoire", "Pullman", "Hei", "Sekoly", "Marais");

        List<String> result = bjani.marche("Hei", "Marais");
        assertEquals(expected, result);

    }

    @Test
    public void HEI_a_HEI() {
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Hei");

        List<String> result = bjani.marche("Hei", "Hei");
        assertEquals(expected, result);

    }

    @Test
    public void Esti_a_Esti() {
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Esti");
        List<String> result = bjani.marche("Esti", "Esti");
        assertEquals(expected, result);

    }

    @Test
    public void Esti_a_Hei() {
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Esti", "Balancoire", "Hei");
        List<String> result = bjani.marche("Esti", "Hei");
        assertEquals(expected, result);

    }
    @Test
    public void Marais_Pullman() {
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Marais","Sekoly","Hei","Balancoire","Esti","Boulvard","Balancoire","Hei","Pullman");
        List<String> result = bjani.marche("Marais", "Pullman");
        assertEquals(expected, result);

    }

}
