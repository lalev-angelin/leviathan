package uk.co.lalev;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CubicSolverTest {
        @Test
        public void testCubicSolver() {
            CubicSolver cubicSolver = new CubicSolver();
            double A = 1;
            double B = -6;
            double C = 11;
            double D = -6;

            List<Double> result = cubicSolver.solveCubic(A, B, C, D);

        }
     @Test
        public void testComputeRadiusVectorLengthFromSphericalCoordinates() {
            Ellipsoid ellipsoid = new Ellipsoid(1, 1, 1);
            double phi = Math.PI / 4;
            double lambda = Math.PI / 4;
            double expected = 1.0; // Replace with the expected value
            double result = ellipsoid.computeRadiusVectorLengthFromSphericalCoordinates(phi, lambda);
            assertEquals(expected, result, 0.01);
        }
}
