import org.example.marcheur.Carte;
import org.example.marcheur.Intinerance;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarcheurTest {


    @Test

    public void HEI_a_Esti() {
        Carte carte = new Carte(Arrays.asList("Marais", "Sekoly", "Hei", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Pullman", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Nexta"));
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Hei", "Sekoly", "Marais", "Sekoly", "Hei", "Balancoire", "Boulvard", "Esti");

        List<String> result = bjani.marche("Hei", "Esti", carte.getCarte());
        assertEquals(expected, result);

    }

    @Test
    public void HEI_a_Marais() {
        Carte carte = new Carte(Arrays.asList("Marais", "Sekoly", "Hei", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Pullman", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Nexta"));
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Hei", "Sekoly", "Marais");

        List<String> result = bjani.marche("Hei", "Marais", carte.getCarte());
        assertEquals(expected, result);

    }

    @Test
    public void HEI_a_HEI() {
        Carte carte = new Carte(Arrays.asList("Marais", "Sekoly", "Hei", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Pullman", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Nexta"));
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Hei");

        List<String> result = bjani.marche("Hei", "Hei", carte.getCarte());
        assertEquals(expected, result);

    }
    @Test
    public void Esti_a_Esti() {
        Carte carte = new Carte(Arrays.asList("Marais", "Sekoly", "Hei", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Pullman", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Nexta"));
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Esti");
        List<String> result = bjani.marche("Esti", "Esti", carte.getCarte());
        assertEquals(expected, result);

    }
    @Test
    public void Esti_a_Hei() {
        Carte carte = new Carte(Arrays.asList("Marais", "Sekoly", "Hei", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Pullman", Arrays.asList("Balancoire", "Esti", "Boulvard"), "Nexta"));
        Intinerance bjani = new Intinerance();
        List<String> expected = Arrays.asList("Esti","Balancoire","Hei");
        List<String> result = bjani.marche("Esti", "Hei", carte.getCarte());
        assertEquals(expected, result);

    }

}
