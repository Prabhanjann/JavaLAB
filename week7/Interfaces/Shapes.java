interface Shapes{
default public void getperi(int n, int l){
System.out.println("Perimeter of the regular polygon having " + n + " sides is "+(n*l));
}
public void getarea();
}
class Rect implements Shapes{
private int a;
private int b;
public Rect(int a, int b){
this.a=a;
this.b=b;
}
@Override
public void getarea(){
System.out.println("The area is "+(a*b));
}
}
class Square implements Shapes{
private int a;
private int b;
public Square(int a, int b){
this.a=a;
this.b=b;
}
@Override
public void getarea(){
System.out.println("The area is "+(a*b));
}
}
class Triangle implements Shapes{
private double l,b;
public Triangle(int l, int b){
this.l=l;
this.b=b;
}
@Override
public void getarea(){
System.out.println("The area is "+(0.5*l*b));
}
}
class Run{
public static void main(String args[]){
Shapes sq= new Square(4 ,4);
sq.getperi(4, 4);
sq.getarea();
Triangle tri= new Triangle(3, 6);
tri.getperi(3, 6);
tri.getarea();
Rect rectangle= new Rect(4,8);
rectangle.getperi(4, 8);
rectangle.getarea();
}
}
