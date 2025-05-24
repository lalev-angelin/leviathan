package uk.co.lalev;

import org.apache.commons.numbers.complex.Complex;

import java.util.ArrayList;
import java.util.List;

public class CubicSolver {
    public List<Double> solveCubic(double A, double B, double C, double D) {
        double Delta0 = B * B - 3 * A * C;
        double Delta1 = 2 * B * B * B - 9 * A * B * C + 27 * A * A * D;
        Complex discriminant = Complex.ofCartesian(Delta1*Delta1 - 4 * Delta0 * Delta0 * Delta0, 0);

        Complex discriminantRoot = discriminant.sqrt();

        if (Delta0==0 && Delta1==0) {
            // All roots are real and equal
            double root = -B / (3 * A);
            System.out.println("Root: " + root);
            return List.of(root, root, root);
        } else if (Delta0 == 0) {
            // Two roots are real and equal, one is complex
            double root1 = -B / (3 * A);
            double root2 = -B / (3 * A) + discriminantRoot.getReal() / (3 * A);
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
            return List.of(root1, root2);
        }

        Complex C1 = Complex.ofCartesian(Delta1, 0).add(discriminantRoot).divide(2.0);
        Complex C2 = Complex.ofCartesian(Delta1, 0).subtract(discriminantRoot).divide(2.0);

        List<Complex> C1Roots = C1.nthRoot(3);
        List<Complex> C2Roots = C2.nthRoot(3);
        C1Roots.addAll(C2Roots);

        List<Double> results = new ArrayList<>();
        // Convert complex roots to real roots, ignoring the imaginary part if it's negligible
        for (Complex root : C1Roots) {
            if (root.imag() < 0.0001 && root.imag() > -0.0001) {
                root = Complex.ofCartesian(root.real(), 0);
            }
            results.add(root.getReal());
        }
        for (Complex root : C1Roots) {
            if (root.imag()<0.0001 && root.imag()>-0.0001) {
                root = Complex.ofCartesian(root.real(), 0);
            }
            results.add(root.getReal());
        }

      return results;
    }
}
