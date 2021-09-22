package com.company;

public class RootQuadraticEquation {
    public static void main(String[] args) {
        double a = 1;
        double b = -4;
        double c = 4;

        double determinant = (b*b)-(4*a*c);
        double sqrt = Math.sqrt(determinant);

        if (determinant > 0 ) {
            double firstRoot = (-b + sqrt)/(2*a);
            double secondRoot = (-b - sqrt)/(2*a);
            System.out.println("Roots are : "+ firstRoot +" and "+ secondRoot);
        }else if (determinant == 0){
            double root = (-b + sqrt)/(2*a);
            System.out.println("Root is : "+ root);
        }else {
            System.out.println("The solution are imaginary");
        }
    }
}
