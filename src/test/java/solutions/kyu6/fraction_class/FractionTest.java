package solutions.kyu6.fraction_class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    public void T1_GeneralTests() {

        assertEquals(new Fraction(37, 40), new Fraction(1, 8).add(new Fraction(4, 5)));
        assertEquals(new Fraction(1, 1), new Fraction(1, 4).add(new Fraction(3, 4)));
        assertEquals(new Fraction(863483, 416760), new Fraction(911, 920).add(new Fraction(980, 906)));
        assertEquals(new Fraction(838923, 926885), new Fraction(610, 941).add(new Fraction(253, 985)));
        assertEquals(new Fraction(16880, 3591), new Fraction(956, 798).add(new Fraction(662, 189)));
        assertEquals(new Fraction(1011239, 417585), new Fraction(694, 485).add(new Fraction(853, 861)));
        assertEquals(new Fraction(191737, 20757), new Fraction(982, 111).add(new Fraction(219, 561)));
        assertEquals(new Fraction(41201, 23571), new Fraction(344, 873).add(new Fraction(658, 486)));
        assertEquals(new Fraction(184563, 68951), new Fraction(662, 361).add(new Fraction(322, 382)));
        assertEquals(new Fraction(33926, 23577), new Fraction(740, 813).add(new Fraction(184, 348)));
        assertEquals(new Fraction(78524, 39543), new Fraction(579, 441).add(new Fraction(543, 807)));
        assertEquals(new Fraction(83997, 283910), new Fraction(212, 979).add(new Fraction(46, 580)));
    }

    @Test
    public void T2_ReductionTests() {

        assertEquals(new Fraction(1, 2), new Fraction(4, 8));
        assertEquals(new Fraction(2, 3), new Fraction(10, 15));
        assertEquals(new Fraction(4, 9), new Fraction(24, 54));
    }

    @Test
    public void T3_ToStringTests() {

        assertEquals("4/5", (new Fraction(2, 5).add(new Fraction(2, 5))).toString());
        assertEquals("5/6", (new Fraction(2, 4).add(new Fraction(1, 3))).toString());
        assertEquals("13/15", (new Fraction(1, 5).add(new Fraction(4, 6))).toString());
    }
}