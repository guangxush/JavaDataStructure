package chapterThree;

public class AbstractTest{
    public static void main(String args[]){
        Graph rectangle = new Rectangle("长方形",10,15);
        rectangle.print();
        Graph circle = new Circle("圆形",10);
        circle.print();
        Graph triangle = new Triangle("三角形",3 ,4 ,5);
        triangle.print();
    }
}
abstract class Graph{
    private String name;
    public Graph(String name){
        this.name = name;
    }
    public abstract double getArea();//计算面积
    public abstract double getPerimeter();//计算周长
    public void print(){//打印图形的面积和周长
        System.out.println(this.name+"的面积是："+getArea()+",周长是："+getPerimeter());
    }
}
//长方形
class Rectangle extends Graph {
    private String name;
    private double length;
    private double weight;
    public Rectangle(String name,double length,double weight){
        super(name);
        this.length = length;
        this.weight = weight;
    }
    public double getArea(){
        return length*weight;
    }
    public double getPerimeter(){
        return 2*(length+weight);
    }
}
//圆形
class Circle extends Graph {
    private String name;
    private double radius;
    public Circle(String name,double radius){
        super(name);
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter(){
        return Math.PI * 2.0 * radius;
    }
}
//三角形
class Triangle extends Graph {
    private String name;
    private double edge_1,edge_2,edge_3;
    public Triangle(String name,double edge_1,double edge_2,double edge_3){
        super(name);
        this.edge_1 = edge_1;
        this.edge_2 = edge_2;
        this.edge_3 = edge_3;
    }
    public double getArea(){
        double p = (edge_1+edge_2+edge_3)/2;
        return Math.sqrt(p*(p-edge_1)*(p-edge_2)*(p-edge_3));
    }
    public double getPerimeter(){
        return edge_1+edge_2+edge_3;
    }
}
