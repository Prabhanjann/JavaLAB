import java.util.Scanner;

abstract class Shape {
    int dim1, dim2;

    Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) 
	{
        super(length, breadth);
    }

    @Override
    void printArea() {
        int area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);
    }

    @Override
    void printArea() 
	{
        	double area = Math.PI * dim1 * dim1;
       		System.out.println("Area of Circle: " + area);
   	 }
}

public class Shapes 
{
    public static void main(String[] args) 
	{
     	   Scanner scanner = new Scanner(System.in);

     	   System.out.print("Enter length and breadth of the rectangle: ");
     	   int rectLength = scanner.nextInt();
     	   int rectBreadth = scanner.nextInt();
     	   Shape rectangle = new Rectangle(rectLength, rectBreadth);
        
    	    System.out.print("Enter base and height of the triangle: ");
     	   int triBase = scanner.nextInt();
     	   int triHeight = scanner.nextInt();
    	    Shape triangle = new Triangle(triBase, triHeight);
        
     	   System.out.print("Enter radius of the circle: ");
     	   int circleRadius = scanner.nextInt();
     	   Shape circle = new Circle(circleRadius);

     	   rectangle.printArea();
    	   triangle.printArea();
     	   circle.printArea();

       	   scanner.close();
   	}
}