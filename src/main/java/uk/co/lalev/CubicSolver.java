package uk.co.lalev;

import org.apache.commons.numbers.complex.Complex;

import java.util.ArrayList;
import java.util.List;

public class CubicSolver {

    public static final double EPSILON = 1e-10;

    public boolean withinEpsilonOf(double value1, double value2) {
        return Math.abs(value1-value2) < EPSILON;
    }

    public List<Double> solveQuadraticForForRealRoots(double A, double B, double C) {
        if (A == 0) {
            if (B == 0) {
                /* Линейно уравнение */
                if (C==0) {
                    /* Всички числа са решения */
                    throw new ArithmeticException("All numbers are solutions");
                } else {
                    /* Няма решение */
                    return new ArrayList<>();
                }
            } else {
                /* Едно решение */
                ArrayList<Double> result = new ArrayList<>();
                result.add(-C / B);
                return result;
            }
        }

        double discriminant = B * B - 4 * A * C;
        if (discriminant < 0) {
            /* Няма реални корени */
            return new ArrayList<>();
        } else if (discriminant == 0) {
            /* Eдно Двойно решение */
            ArrayList<Double> results = new ArrayList<>();
            results.add(-B / (2 * A));
            return results;
        } else {
            /* Две различни решения */
            double sqrtDiscriminant = Math.sqrt(discriminant);
            ArrayList<Double> results = new ArrayList<>();
            results.add((-B + sqrtDiscriminant) / (2 * A));
            results.add((-B - sqrtDiscriminant) / (2 * A));
            results.sort(Double::compareTo);
            return results;
        }
    }

    public List<Double> solveCubicForRealRoots(double A, double B, double C, double D) {
        if (A == 0) {
            // Линейно или квадратно уравнение
            return solveQuadraticForForRealRoots(B, C, D);
        }

        Complex Delta0 = Complex.ofCartesian(B * B - 3 * A * C, 0);
        Complex Delta1 = Complex.ofCartesian(2 * B * B * B - 9 * A * B * C + 27 * A * A * D, 0);
        Complex discriminant = Delta1.multiply(Delta1)
                   .subtract(Delta0.multiply(Delta0)
                        .multiply(Delta0)
                        .multiply(4)
                   );
        Complex discriminantRoot = discriminant.sqrt();

        if (Delta0.getReal()==0 &&
                Delta1.getReal()==0) {
            /* Всички корени са равни и реални*/
            double root = -B / (3 * A);
            return List.of(root);
        } else {
            Complex C1 = Delta1.add(discriminantRoot).divide(2.0);
            Complex C2 = Delta1.subtract(discriminantRoot).divide(2.0);
            Complex CBest = C1;

            if (withinEpsilonOf(C1.getReal(), 0) && withinEpsilonOf(C1.getImaginary(),0)) {
                CBest= C2;
            }

            List<Complex> CRoots  = CBest.nthRoot(3);

            // Извличаме само реалните корени
            List<Double> results = new ArrayList<>();
            for (Complex cRoot : CRoots) {
                Complex newRoot =
                cRoot.add(Delta0.divide(cRoot))
                        .add(B)
                        .divide(-3* A);
                if (withinEpsilonOf(newRoot.getImaginary(), 0)) {
                    results.add(newRoot.getReal());
                }
            }
            results.sort(Double::compareTo);
            return results;
        }
    }
}
