public class Task4 {
    public static void main (String[] args) {
        Circle circle = new Circle();
        circle.draw();
        circle.erase();

        Triangle triangle = new Triangle();
        triangle.draw();
        triangle.erase();

        Square square = new Square();
        square.draw();
        square.erase();
    }

    public static class Shape {
        public void draw() {}
        public void erase() {}
    }

    public static class Circle extends  Shape {
        @Override
        public void draw() {
            System.out.println("A circle is drawn");
        }

        @Override
        public void erase() {
            System.out.println("The circle was erased");
        }
    }

    public static class Triangle extends Shape {
        @Override
        public void draw() {
            System.out.println("A triangle is drawn");
        }

        public void erase() {
            System.out.println("The triangle was erased.");
        }
    }

    public static class Square extends Shape {
        @Override
        public void draw() {
            System.out.println("A square is drawn.");
        }

        @Override
        public void erase() {
            System.out.println("The square was erased.");
        }
    }
}
