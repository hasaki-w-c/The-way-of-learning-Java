package duotai;

public class Test {

	public static void main(String[] args) {
		
		//以前编写的程序
		Animal a1 = new Animal();
		a1.move();
		
		Cat c1 = new Cat();
		c1.move();
		c1.catchMouse();
		
		Bird b1 = new Bird();
		b1.move();
		
		//使用多态语法机制
		/*
		 * 1.Animal和Cat之间存在继承关系。
		 * 2.Cat is belong to Animal
		 * 3.new Cat()创建的类型是Cat，a2这个引用的数据是Animal，可见它们进行了类型转换
		 *       子类型转换成父类型，称为向上转型/upcasting，或者称为自动类型转换。
		 * 4.Java中允许这种语法：父类型引用指向子类型对象
		 */
		Animal a2 = new Cat();
		//Bird b2 = new Cat();编译报错，因为两种类型之间不存在任何继承关系。无法转型。
		
		/*
		 *1.Java程序永远都分为编译阶段和运行阶段。
		 *2.先分析编译阶段，再分析运行阶段，编译无法通过，根本是无法运行的
		 *3.编译阶段编译器检查a2这个引用的数据类型为Animal,由于Animal.class 
		 *  字节码中有move()方法，所以编译通过了。这个过程我们称为静态绑定，编译阶段绑定
		 *   只有静态绑定成功成功之后才有后续的运行。
		 *4.再程序运行阶段，JVM堆内存当中真实创建的对象是Cat对象，那么以下程序在运行阶段
		 *    一定会调用Cat对象的move()方法，此时发生了程序的动态绑定，运行阶段绑定。
		 *5.无论是Cat类有没有重写move方法，运行阶段一定调用的是Cat对象的move方法，
		 *    因为底层真实对象就是Cat对象。
		 *6.父类型引用指向子类型对象这种机制导致程序存在编译阶段绑定和运行阶段绑定两种不同的形态/状态
		 *  这种机制可以称为一种多态语法机制。
		 */
		a2.move();
		//a2.catchMouse()    没有此方法，不可调用
		
		/*
		 * a2.catchMouse();    为什么不能被调用？
		 *     应为编译阶段编译器检查到a2的类型是Animal类型，
		 *     从Animal.class字节码文件中查找catchMouse()
		 *     方法，最终没有找到该方法，导致静态绑定失败，没有绑定
		 *     成功，也就是说编译失败了。
		 */
		
		/*
		 * 需求：假设想要以上Cat对象执行catchMouse（）方法，怎么办？
		 *     我们可以将a2强制类型转换为Cat类型。
		 *     a2的类型是Animal（父类），转换为Cat类型（子类），被称为向下转型。
		 *     
		 *   注：向下转型也需要两种类型之间必须有继承关系，不然编译报错。强制类型转换需要加强制类型转换符。
		 *   什么时候需要使用向下转型呢？
		 *   当调用的方法或者访问的属性是子类型中特有的，在父类型中不存在。必须进行向下转型。
		 */
		Cat c2 = (Cat)a2;
		c2.catchMouse();
		//对比以下，方便理解。
		//long x = 100L;
		//int i = (int)x
		
		//父类型引用指向子类型对象【多态】
		Animal a3 = new Bird();
		
		/*
		 * 1.以下程序编译是没有问题的，因为编译器检查到a3的数据类型是Animal。
		 * Animal和Cat之间存在继承关系，
		 * 父类型转换称子类型叫做向下转型。
		 * 
		 * 2.程序虽然编译通过了，但是程序在运行阶段会出现异常，因为JVM堆内存当中
		 * 真实存在的对象是BIrd类型，Bird对象无法转换成Cat对象，因为两种类型之间
		 * 不存在任何继承关系，此时出现了著名的异常：
		 *     java.lang.ClassCastException（类型转换异常）
		 *     总是在“向下转型”时发生。
		 */

		/*
		 * 1.以上异常只有在强制类型转换时会发生，也就说“向下转型”存在隐患（编译可以过，运行会出错）
		 * 2.向上转型只要编译通过，运行就不会有问题。
		 * 3.如何避免向下转型出现的运行报错呢？
		 *       使用instanceof运算符可以避免出现以上的异常。
		 * 4.instanceof运算符怎么用？
		 *     1>语法格式：（引用 instanceof 数据类型名）
		 *     2>以上运算符执行结果类型是布尔类型，结果可能是true或者false
		 *     3>关于晕眩结果true/false
		 *              假设：(a instanceof Animal)
		 *              true表示：a这个引用指向的对象是一个Animal类型
		 *              false表示，a这个引用指向的对象不是一个Animal类型
		 */
		if (a3 instanceof Cat) {
		Cat c3 = (Cat)a3;
		c3.catchMouse();
		}else if(a3 instanceof Bird) {
			Bird b2 = (Bird)a3;
			b2.fly();
		}
	}

}
