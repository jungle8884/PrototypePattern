package com.PrototypePattern;

/*
* 由于 Java 提供了对象的 clone() 方法，所以用 Java 实现原型模式很简单。
* Object对象有个clone()方法，实现了对象中各个属性的复制，但它的可见范围是protected的，
* 所以实体类使用克隆的前提是：
*       实现Cloneable接口，这是一个标记接口，自身没有方法。
*       覆盖clone()方法，可见性提升为public。
* */

//具体原型类
public class Money implements Cloneable {

    // 面值
    private int faceValue;

    private Area area;

    public int getFaceValue(){
        return faceValue;
    }

    public void setFaceValue(int faceValue){
        this.faceValue = faceValue;
    }

    public Money(int faceValue, Area area){
        this.faceValue = faceValue;
        this.area = area;
    }

    public Area getArea(){
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    // 覆盖clone()方法，可见性提升为public
    // 浅克隆，即只是进行了值复制，对于只包含基本类型属性的类，这种克隆没有问题。
    // 但如果一个对象除了包含基本类型属性，还包含其它实体类对象的引用，
    // 这种浅克隆只是复制了对象的引用地址，被克隆的对象中的引用对象与原引用对象共享相同的引用。
    public Money clone() throws CloneNotSupportedException{
        //super.clone() 的调用就是沿着继承树不断往上递归调用直到Object 的clone方法
        //Object.clone()根据当前对象的类型创建一个新的同类型的空对象，
        //然后把当前对象的字段的值逐个拷贝到新对象上，然后返回给上一层clone() 调用
        //也就是说super.clone() 的浅复制效果是通过Object.clone()实现的
        return (Money)super.clone();
    }

//    // 要实现将克隆对象内容（包含其它实体类对象的引用）完全复制，就需进行深克隆，将各引用的对象也专门复制。
//    public  Money clone() throws CloneNotSupportedException{
//        //填加自身向money复制各引用对象的代码
//        Money money = (Money)super.clone();
//        return money;
//    }
}
