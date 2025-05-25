package uk.co.lalev;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CubicSolverTest {
        @Test
        public void testCubicSolver() {
            CubicSolver cubicSolver = new CubicSolver();
            List<Double> result = cubicSolver.solveCubicForRealRoots(1, -6, 11, -6);
            // Проверка на корените
            assertEquals(3, result.size(), "Should have 3 real roots");
            result.sort(Double::compareTo);
            assertTrue(cubicSolver.withinEpsilonOf(1, result.get(0)));
            assertTrue(cubicSolver.withinEpsilonOf(2, result.get(1)));
            assertTrue(cubicSolver.withinEpsilonOf(3, result.get(2)));

            cubicSolver = new CubicSolver();
            result = cubicSolver.solveCubicForRealRoots(1, 0, 0, 6);
            // Проверка на корените
            assertEquals(1, result.size(), "Should have 1 real root");
            result.sort(Double::compareTo);
            assertTrue(cubicSolver.withinEpsilonOf(-1.81712059283213, result.get(0)));

            cubicSolver = new CubicSolver();
            result = cubicSolver.solveCubicForRealRoots(0, 1, 0, -6);
            // Проверка на корените
            assertEquals(2, result.size(), "Should have 2 real roots");
            result.sort(Double::compareTo);
            assertTrue(cubicSolver.withinEpsilonOf(-2.44948974278317, result.get(0)));
            assertTrue(cubicSolver.withinEpsilonOf(2.44948974278317, result.get(1)));

            cubicSolver = new CubicSolver();
            result = cubicSolver.solveCubicForRealRoots(0, 0, 0, -6);
            // Проверка на корените
            assertEquals(0, result.size(), "Should have no real roots");

            CubicSolver finalCubicSolver = cubicSolver;
            assertThrows(ArithmeticException.class, () -> {
                // Тест за изключение при всички числа като решения
                finalCubicSolver.solveCubicForRealRoots(0, 0, 0, 0);
            });

            cubicSolver = new CubicSolver();
            result = cubicSolver.solveCubicForRealRoots(1, 0, 1, -6);
            // Проверка на корените
            assertEquals(1, result.size(), "Should have 1 real roots");
            result.sort(Double::compareTo);
            assertTrue(cubicSolver.withinEpsilonOf(1.63436529301352, result.get(0)));

            cubicSolver = new CubicSolver();
            result = cubicSolver.solveCubicForRealRoots(1, 0, 0, 1);
            // Проверка на корените
            assertEquals(1, result.size(), "Should have 1 real roots");
            result.sort(Double::compareTo);
            assertTrue(cubicSolver.withinEpsilonOf(-1, result.get(0)));
        }
}
