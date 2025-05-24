package uk.co.lalev;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Haumea class
        Haumea haumea = new Haumea();
        // Call the drawHaumea method to plot the ellipsoid
        try {
            haumea.drawHaumea();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}