public class Fraction {

    double numerator;
    double denominator;

    public Fraction(double numerator, double denominator) {

        this.numerator = numerator;
        this.denominator = denominator;

    }

    public static void main(String[] args) {

        // The number behind "fraction" is the numerator and denominator put together.
        Fraction fraction13 = new Fraction(1, 3);

        System.out.println("To Decimal Notation: " + fraction13.toDecimalNotation(fraction13)); // Decimal Notation

        System.out.println("To String: " + fraction13.toString()); // To String

        Fraction fraction43 = fraction13.add(1, fraction13); // New object to use add(1) on
        System.out.println("Add 1 to 1/3: " + fraction43.toString()); // add 1

        Fraction fraction16 = new Fraction(1, 6);
        Fraction fraction12 = fraction13.add(fraction13, fraction16);
        System.out.println("Add 1/3 to 1/6: " + fraction12.toString());

        Fraction fraction13Sub = fraction43.subtract(1, fraction43);
        System.out.println("Subtract 1 from 4/3: " + fraction13Sub.toString());

        Fraction fraction13FractionSub = fraction12.subtract(fraction12, fraction16);
        System.out.println("Subtract 1/6 from 4/3: " + fraction13FractionSub.toString());

        Fraction fraction34 = new Fraction(3, 4);
        Fraction fraction32 = fraction34.multiply(2);
        System.out.println("3/4 times 2: " + fraction32.toString());

        Fraction fraction25 = new Fraction(2, 5);
        Fraction fraction310 = fraction25.multiply(fraction34, fraction25);
        System.out.println("3/4 times 2/5: " + fraction310.toString());

        Fraction fraction34Divided = fraction32.divide(2);
        System.out.println("3/2 divided by 2: " + fraction34Divided.toString());

        Fraction fraction34FractionDiv = fraction310.divide(fraction310, fraction25);
        System.out.println("3/10 divided by 2/5: " + fraction34FractionDiv.toString());

    }

    private Fraction divide(Fraction fraction1, Fraction fraction2) {
        Fraction fractionNew = new Fraction((fraction1.numerator * fraction2.denominator),
                (fraction1.denominator * fraction2.numerator));
        int LCD = fractionNew.getLCD(); // Get the LCD for this fraction.
        fractionNew = fractionNew.useLCD(LCD, fractionNew); // Modify the fraction in it's new LCD.
        return fractionNew;
    }

    private Fraction divide(int i) {
        Fraction fractionNew = new Fraction((numerator * 1), (denominator * i));
        int LCD = fractionNew.getLCD(); // Get the LCD for this fraction.
        fractionNew = fractionNew.useLCD(LCD, fractionNew); // Modify the fraction in it's new LCD.
        return fractionNew;
    }

    private Fraction multiply(Fraction fraction1, Fraction fraction2) {
        Fraction fractionNew = new Fraction((fraction1.numerator * fraction2.numerator),
                (fraction1.denominator * fraction2.denominator));
        int LCD = fractionNew.getLCD(); // Get the LCD for this fraction.
        fractionNew = fractionNew.useLCD(LCD, fractionNew); // Modify the fraction in it's new LCD.
        return fractionNew;
    }

    private Fraction multiply(int x) {
        Fraction fractionNew = new Fraction((numerator * x), (denominator));
        int LCD = fractionNew.getLCD(); // Get the LCD for this fraction.
        fractionNew = fractionNew.useLCD(LCD, fractionNew); // Modify the fraction in it's new LCD.
        return fractionNew;
    }

    private Fraction subtract(Fraction fraction1, Fraction fraction2) {
        Fraction fractionNew = new Fraction(
                (fraction1.numerator * fraction2.denominator) - (fraction1.denominator * fraction2.numerator),
                (fraction1.denominator * fraction2.denominator));
        int LCD = fractionNew.getLCD(); // Get the LCD for this fraction.
        fractionNew = fractionNew.useLCD(LCD, fractionNew); // Modify the fraction in it's new LCD.

        return fractionNew;
    }

    private Fraction subtract(int i, Fraction fraction) {
        Fraction fractionNew = new Fraction(fraction.numerator - (i * fraction.denominator), fraction.denominator);
        return fractionNew;
    }

    private Fraction useLCD(int lCD, Fraction fraction) {
        Fraction fractionLCD = new Fraction(numerator, denominator);
        fractionLCD.numerator = (fraction.numerator / lCD);
        fractionLCD.denominator = (fraction.denominator / lCD);

        return fractionLCD;
    }

    private int getLCD() {
        if (numerator > denominator) {
            for (int i = (int) denominator; i > 0; i--) {
                if (((int) numerator % i == 0) && ((int) denominator % i == 0)) {
                    return i;
                }
            }
        } else {
            for (int i = (int) numerator; i > 0; i--) {
                if (((int) numerator % i == 0) && ((int) denominator % i == 0)) {
                    return i;
                }
            }
        }
        return 1;
    }

    private Fraction add(Fraction fraction1, Fraction fraction2) {
        Fraction fractionNew = new Fraction(
                (fraction1.numerator * fraction2.denominator) + (fraction1.denominator * fraction2.numerator),
                (fraction1.denominator * fraction2.denominator));
        int LCD = fractionNew.getLCD(); // Get the LCD for this fraction.
        fractionNew = fractionNew.useLCD(LCD, fractionNew); // Modify the fraction in it's new LCD.

        return fractionNew;
    }

    private Fraction add(int i, Fraction fraction) {
        Fraction fractionNew = new Fraction(fraction.numerator + (i * fraction.denominator), fraction.denominator);
        return fractionNew;
    }

    public String toString() {
        int numer = (int) numerator;
        int denom = (int) denominator;
        String toString = "\"" + numer + "/" + denom + "\"";
        return toString;
    }

    private double toDecimalNotation(Fraction fraction) {
        double decimalNotation = fraction.numerator / fraction.denominator;
        return decimalNotation;
    }

}
