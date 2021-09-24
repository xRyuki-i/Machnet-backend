package Task3;

public class Task4 {
    public static void main (String[] args){
        Shape rectangle = (a, b) -> a * b;
        Shape triangle = (a, b) -> 0.5*a*b;

        System.out.println("Area of the given rectangle is "+rectangle.calculateArea(10, 12));
        System.out.println("Area of the given triangle is "+triangle.calculateArea(12,5));
    }
}
