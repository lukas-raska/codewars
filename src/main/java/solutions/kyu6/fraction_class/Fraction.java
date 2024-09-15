package solutions.kyu6.fraction_class;

public class Fraction  {
    private final long top;
    private final long bottom;

    public Fraction(long numerator,
                    long denominator) {
        long [] simplified = simplify(numerator, denominator);
        top = simplified[0];
        bottom = simplified[1];
    }

    //Add two fractions
    public Fraction add(Fraction added) {
        long denominator = this.bottom * added.bottom;
        long numerator = this.top * added.bottom + added.top * this.bottom;

        return new Fraction(numerator, denominator);
    }

    private long[] simplify(long top,
                            long bottom) {
        long maxDivider = Math.min(top, bottom)/2;
        for (long i = maxDivider; i > 1; i--) {
            while (top % i == 0 && bottom % i == 0) {
                top /= i;
                bottom /= i;
            }
        }
        return new long[]{top, bottom};
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction fraction)) return false;

        return top == fraction.top && bottom == fraction.bottom;
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(top);
        result = 31 * result + Long.hashCode(bottom);
        return result;
    }

    @Override
    public String toString() {
        return "%d/%d".formatted(this.top, this.bottom);
    }
}
