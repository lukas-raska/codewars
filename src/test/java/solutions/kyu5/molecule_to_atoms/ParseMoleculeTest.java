package solutions.kyu5.molecule_to_atoms;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(Parameterized.class)
class ParseMoleculeTest {


//    @Parameters

    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] { {Arrays.asList("H", "O"),
                Arrays.asList( 2,   1 ),
                "H2O",
                "water"},

                {Arrays.asList("Mg", "H", "O"),
                        Arrays.asList(  1,   2,   2 ),
                        "Mg(OH)2",
                        "magnesium hydroxide"},

                {Arrays.asList("K", "O", "N", "S"),
                        Arrays.asList( 4,   14,  2,   4 ),
                        "K4[ON(SO3)2]2",
                        "Fremy's salt"},
        });
    }

    private Map<String,Integer> expected;
    private String formula, name;

    public ParseMoleculeTest(List<String> atoms, List<Integer> nums, String formula, String name) {
        Map<String,Integer> exp = new HashMap<String,Integer>();
        for (int i = 0 ; i < atoms.size() ; i++) exp.put(atoms.get(i), nums.get(i));

        this.expected = exp;
        this.formula = formula;
        this.name = name;
    }

    @Test
    public void testMolecule() {
        System.out.println(expected);
        assertEquals( expected, ParseMolecule.getAtoms(formula),String.format("Should parse %s: %s", name, formula));
    }
}