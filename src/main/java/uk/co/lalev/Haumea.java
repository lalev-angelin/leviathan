package uk.co.lalev;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import org.apache.commons.math4.legacy.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math4.legacy.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math4.legacy.analysis.solvers.BisectionSolver;
import org.apache.commons.numbers.complex.Complex;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Haumea extends Ellipsoid {
    // Радиус на еллипсоида по главната ос
    public static final double c = 1350 * 1000;
    // Радиус на еллипсоида по второстепената ос
    public static final double b = 850 * 1000;
    // Радиус на еллипсоида по третата ос
    public static final double a = 500 * 1000;

    // Маса на еллипсоида
    public static final double mass  = 4.01*Math.pow(10, 21);

    // Плътност на еллипсоида
    public static final double density = mass / (4.0 / 3.0 * Math.PI * a * b * c);

    // Ъглова скорост на въртене на еллипсоида
    public static final double angularVelocity = 2 * Math.PI / 	3.915341 * 60 * 60;




    public double solveGravEquationForU(double x, double y, double z) {
        // Уравнение на гравитационното поле на еллипсоида
        double D = -b*b*c*c*x*x - a*a*c*c*y*y - a*a*b*b*z*z + a*a*b*b*c*c;
        double C = -(b*b*x*x + c*c*x*x + a*a*y*y +c*c*y*y +a*a*z*z + b*b*z*z - a*a*b*b - a*a*c*c - b*b*c*c);
        double B = -(x*x + y*y + z*z - a*a - b*b - c*c);
        double A = 1;

        return 0;
    }


    public void drawHaumea() throws PythonExecutionException, IOException {
        Plot plt = Plot.create();
        plt.plot()
                .add(Arrays.asList(0, 0))
                .label("Haumea")
                .color("blue")
                .linestyle("solid")
                .linewidth(2);
        plt.show();
    }

    public Haumea() {
        super(a, b, c);
    }
}
