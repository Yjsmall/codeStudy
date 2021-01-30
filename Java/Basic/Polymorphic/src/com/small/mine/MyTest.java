package com.small.mine;

/**
 * @author small
 * <ol>
 *     <li>This is a HTML doc.</li>
 *     <li>u could insert html.</li>
 * </ol>
 */
public class MyTest {
    static void doSomething(Shape shape){
        //Only base class methods can be used.
        //Upcast,export class's own methods will be lost.
        shape.draw();
        shape.erase();
    }

    public static void main(String[] args) {
        //这些都算是向上转型(cast)
        Shape shape = new Shape();
        doSomething(shape);
        System.out.println("--------");

        Square square = new Square();
        doSomething(square);
        square.move();
    }

}

class Shape {
    void draw() {
        System.out.println("这是基础类的draw");
    }

    void erase() {
        System.out.println("这是基类的erase");
    }

}

class Square extends Shape{
    @Override
    void draw() {
        System.out.println("我是正方形的draw");
    }

    @Override
    void erase() {
        super.erase();
        System.out.println("我是正方形的erase");
    }

    void move() {
        System.out.println("我是正方形的move");
    }
}
