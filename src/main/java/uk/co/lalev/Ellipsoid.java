package uk.co.lalev;

public class Ellipsoid {
    // Радиус на еллипсоида по главната ос
    private final double a;
    // Радиус на еллипсоида по второстепената ос
    private final double b;
    // Радиус на еллипсоида по третата ос
    private final double c;

    // Изчислява радиус-вектора от сферични координати на повърхността на еллипсоида
    public double computeRadiusVectorLengthFromSphericalCoordinates(double phi, double lambda) {
        double sinPhi = Math.sin(phi);
        double cosPhi = Math.cos(phi);
        double sinLambda = Math.sin(lambda);
        double cosLambda = Math.cos(lambda);

        double numerator = a * b * c;
        double denominator = Math.sqrt(
                (b*b*c*c*cosPhi*cosPhi*cosLambda*cosLambda +
                 a*a*c*c*cosPhi*cosPhi*sinLambda*sinLambda +
                 a*a*b*b*sinPhi*sinPhi));

        return numerator / denominator;
    }

    public double getC() {
        return c;
    }

    public double getB() {
        return b;
    }

    public double getA() {
        return a;
    }

    public Ellipsoid(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
