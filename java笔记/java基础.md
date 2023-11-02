# 变量与运算符

## 数据类型介绍

### 整数类型：byte、short、int、long

| 类型  | 字节数                  |
| ----- | ----------------------- |
| byte  | 1(-128 ~ 127)           |
| short | 2                       |
| int   | 4（正负-2^31 ~ 2^31-1） |
| long  | 8 (-2^63 ~ 2^63)        |

long数据类型加’L‘

### 浮点类型：float、double

| 类型   | 字节数 | 表示范围                                |
| ------ | ------ | --------------------------------------- |
| float  | 4      | 保留8位有效数字，但是其可以取值的范围； |
| double | 8      | 保留16位有效数字                        |

```java
float x = 0.4f;
double y = 0.4;
//x中存储的就是0.40000000596044645；
//y中就是0.4000000000000000；
//所以x>y
```

默认使用double，使用float赋值时需要’F‘或者’f‘后缀

### BigDecimal类

涉及到精度问题

### 字符类型：char类

**占2个字节(无符号位：0-65535)** 

+ ’a‘
+ 使用Unicode值来表示字符类型常量’\u0023‘表示’#‘，**\ u 之后表示的是16进制，只能有四位。**
+ 转义字符’\n‘

因为有对应的Unicode码，所以可以参与运算

### 布尔类型：boolean

不可以使用0或非0的整数替代false和true，这一点与c语言不同

```java
boolean a = true;
int b = 1;
b += a;
//错误的，int不能连接boolean
```



## 基本数据类型变量间运算规则

### **当赋值号右边的表达中有变量时，编译只检查变量的类型，不检查变量中的值。**

``` 
int x = 1;
char b = 'a' + x; //编译错误
char b = 'a' + 1; //正确。
```



### 自动类型提升

![image-20240301183639235](.\src\基本数据类型转换规则.png)

#### 把存储了小范围的值赋值给存储大范围的变量时

```java
int i = 'A';//char自动升级为int型
double d = 10;//int自动升级为double型
long bigNum = 1234567890L;//右边的整数常量超过了int的范围，必须加L，显示表示long类型
```

#### 当范围小的数据类型与范围大的数据类型一起混合运算时会按照其中最大的类型运算

#### 当byte,short,char 进行算数运算时会按照int处理

```java
short s = 5;
s = s-2;
//错误，应为会按照int处理
```



### 强制类型转换

+ 大范围到小范围是可能会造成损失精度或溢出
+ int - > double
+ long可以省略L，float不行，因为会按照double处理

## 基本数据类型与String的运算

### String不是基本数据类型，属于引用数据类型

### 任意八种数据类型（boolean）与String只能’+‘连接，且结果一定是String

```java
int num = 10;
boolean b1 = true;
String s1 = "abc";
//String s3 = num + b1 + s1;
//错误，boolean不能来参与运算
String s4 = num + (b1 + s1);
```

### String 转换为其他类型

```java
String str = "123";
int num = Integre.parseInt(str);
```

parse: 作语法分析

### 运算符

![image-20240301192152445](.\src\一个两个.png)

异或 ： ^

```java
m = m^n;
n = m^n;
m = m^n;
//利用于数值，交换两值
```

（条件表达式）？表达式1：表达式2

---

# 流程控制语句

## 运算符的优先级

```text
　  1..[] ()

　　2.++ -- ～ ! (数据类型)

　　3.* / %

　　4.+ -

　　5.<< >> >>>

　　6.< > <= >=

　　7.== !=

　　8.&

　　9.^（异或 a^b^b = a） ~（取反） 

　　10.|

//&&和||的短路特性，即如果已经可以得出结论了就不计算后面的式子了。
　　11.&&

　　12.||

　　13.?:

　　14.= *= /= %= += -= <<= >>= >>>= &= ^= |=
```



## if-else-if

## switch-case-default

+ 表达式的值必须是：byte, short, char, int, 枚举，String
+ case子句中必须是常量，不能是变量名或者不确定的表达式的值或范围

## for(;;)

## for-each

```java
for(元素的数据类型 局部变量 ：collection 集合或数组){
    //操作局部变量
}
```



## while循环

## do-while

```java
do{
    
}while(循环条件部分);
```

## continue + 标签

```java
label:for(int i = 2; i <= 1000; i++){
    if(){
        continue label;
    }
}
```

## Scanner: 键盘输入功能的实现

```java
import java.util.Scanner;
Scanner scan = new Scanner(System.in);
int a = scan.nextInt();
scanner.close();
```

```text
nextBoolean(), nextDouble(), next()
```

## println

```java
//println不能换行
System.out.println("1232
                   你好");//错误
System.out.printf("%f", a);
```



## 如何获取一个随机数

```java
Math.random();//返回[0,1)的随机数
```



---

# 数组

**数组本身是引用数据类型，而数组中的元素可以是任何数据类型，包括基本数据类型和引用数据类型**
**数组一旦初始化完成，其数组的长度一旦确定就不能更改**

### 声明 + 初始化

```java
// 静态初始化
int[] a;
int a[];
int [] a, b[];//a是一维数组，b则是一个二维数组
int size = 12;
a = new int[size]; 
//和c语言不同的是允许使用int变量的值来指定数组元素的个数。
a = new int[3]{1,2,3};//静态初始化
int[] b = {1,2,3};
b = {1,2,3,4}//错误

int[][] c;
c = new int[][]{{1,2},{1,3}};
//规则，确定好行列数
c = new int[2][3];
//不规则，每一行的列数不相同
int[][] d = new int[3][];
d[0] = new int[12];
//int[][] d = new int[][3]; 非法；
//数组是引用数据类型，此时每一行中还是null
d[0] = new int[2];
d[1] = new int[3];
//此时第2行里还是null

//数组属于引用数据类型；
int a[]={1,2,3},b[]={4,5};
a = b;//引用数据类型，有了相同的引用
char[] v = {'a','b','b'};
System.out.println(a);//地址[I@1b6d3586
System.out.println(v);//abb
System.out.println(""+v);//地址与字符串做并置yun'suan[C@4554617c
```

**但是局部变量没有默认值，只有经过new的，像new int[]，实例变量，类变量会被默认属性为0**

**如何局部变量和成员变量名字相同，成员变量会被暂时隐藏**

<img src=".\src\默认值.png" alt="image-20240301200158634" style="zoom: 80%;" />

### java虚拟机的内存划分

数组只是在栈中一个变量存储了该数组实际在推中的首地址

![image-20240301200407104](.\src\内存划分.png)



![image-20240301200455520](.\src\内存划分_1.png)

![image-20240301200544579](.\src\内存划分_2.png)

## java.util.Arrays



---

# 面向对象编程（基础）

## 方法重载

**它们的参数列表（参数个数或参数类型）不同，与修饰符、返回值类型无关**

## 可变个数的形参

Varargs(variable number of arguments)机制

```java
public static void (int a, String...books)
books.length()
books[0]
```

可变个数形参的方法与同名的方法构成重载

必须放在最后，类似于数组

## 参数传递方式：值传递

形参是基本数据类型：将实参的“数据值”传递给形参
形参是引用数据类型：将实参的“地址值”传递给形参（堆中）

## UML图

+ （实线）关联关系：A类中的成员变量是B的对象
+ （虚线）依赖关系：A类的某个方法的参数使用B的对象

## package、 import

package 顶层包名.子包名

```text
对于顶级类(外部类)来说，只有两种修饰符：public和默认(default)。因为外部类的上一单元是包，所以外部类只有两个作用域：同包，任何位置。因此，只需要两种控制权限：包控制权限和公开访问权限，也就对应两种控制修饰符：public和默认(default)。

如果类使用了private修饰符，说明是个内部类。内部类的上一级是外部类，那么对应的有四种访问控制修饰符：本类(private)，同包(default)，父子类(protected)，任何位置(public)。当一个内部类使用了private修饰后，只能在该类的外部类内部使用。

上面这些都是平时使用司空见惯的，但是为什么是这种情况呢？

可以想一下，一个java项目是不可能在一个class里面完成的。mvc模式中，是把类分为三层，一层层调用类。如果定义为私有的和受保护的就无法调用。换句话说，对于一个java文件，要么就是自己单独运行，要么就是被其他程序作为库调用，如果一个java文件的类被private修饰，那么是不是其他的程序或是类是无法使用它的，那么他作为一个单独的文件就没啥用了。如果它作为单个文件运行，类加载怎么找到它呢，因为它对外不可见。同时，也失去了类的存在意义。因此，类只有public和默认修饰符。
```

```java
package pack1.pack2;//指定类属于包pack1.pack2
//class不能用protected 和 private修饰
public class test{   
}

import 包名.类名
```

## 封装public、protected、缺省、private

**其他包的子类，即：我这个类的protected和public可以被其他包继承我的子类访问继承。**
**其他包的非子类，就只能访问我的public属性的文件。**

缺省叫做友好变量。protected是受保护对象。

![image-20240303201117051](.\src\修饰符权限.png)

## JRE扩展和jar文件

**使用jar.exe命令把一些类的字节码文件压缩成jar文件，然后将这个jar文件存放到java运行环境jre中。**

## 构造器

构造器的修饰符只能是权限修饰符，不能被staic、final、synchronized、abstract、native

```java
[修饰符] class 类名{
    [修饰符] 构造器名（参数列表）{
        
    }
}
```

没有显示构造器，默认提供一个无参的构造器并且改构造器的修饰符默认与类的修饰符相同。

**类体中的赋值语句（句法不是变量的声明，只能出现在方法体中）**

---

# 面向对象编程（进阶）

## this

在方法（实例方法而非static方法）
filed、method、构造器

### this可以作为一个类中构造器相互调用的特殊格式

this():调用本类的无参构造器
this(实参列表)：调用本类的有参构造器
只能在构造器的首行且最多只能声明一个”this(参数列表)“

## 继承Inheritance

is-a关系，父类更通用、更一般，子类更具体

```java
class B extends A{
    
}
```

**java支持单继承，不支持多继承**

### 方法重写override

```java
@override
方法
```

+ 被重写的方法必须和父类有相同的方法名称、**参数列表**
+ **返回值类型**不能大于父类被重写的方法的返回值类型（Student<Person）,**引用数据类型**
+ 如果返回的是**基本数据类型和void**，那么必须相同
+ 子类重写方法的权限不能小于父类被重写方法的**权限**（public > protected > 缺省 >private）
  + 父类的私有方法不能重写，跨包的父类缺省方法也不能重写
+ 子类抛出的**编译时异常**<=父**类重写方法的编译异常**，**对于throws 运行时异常“没有要求。
+ 同名同参数的方法必须同时为staic或者非staic，因为static是属于类的，子类无法覆盖父类的方法
+ 不能是static、final修饰的方法
+ **子类继承的方法又没有被重写，单纯的从父类哪里继承过来的，当然只能调用子类继承和隐藏的成员变量（就是父类的。）**

### 关键字：super

+ 子类和父类相同名字的属性或者方法被隐藏了（即：子类调用该属性的时候调用的是子类自己的），所以需要调用super。
+ super可以访问**父类的属性和成员方法**
+ **可以在子类构造器中调用父类构造器super（形参列表）调用父类的指定构造器**
  + 但是和this（形参列表）**只能二选一**
  + 子类中的构造器要么调用本类的重载构造器**this**要么调用了父类构造器**super**
  + 默认调用父类的无参构造器，**但是如果父类有一个有参构造器则不会默认生成无参构造器**，*那么在子类构造器中默认调用父类的无参构造器就会出错*
+ 当子父类出现同名成员时，可以用super标明调用的是父类的成员
+ super的追溯不仅是**直接父类**

1. 子类没有重写父类方法，**只要权限允许**，子类中可以直接调用父类方法
2. 子类重写了父类方法，在子类中可以通过**super**才能调用父类被重写的方法

```java
public class A {
	public void method_1(){
        
    }
}
public class B extends A{
    @override
    public void method_1(){
        super.method_1()
    }
}
```

## 多态性Polymorphism

**对象的多态性：父类的引用指向子类的对象**

```text
父类类型 变量名 = 子类对象
父类类型：指子类继承的父类类型，或者实现的接口类型
```

```java
Person p = new Student();
object o = new Person();
o = new Student();
//引用类型变量可能指向多种不同类型的对象
```

### 多态的理解

**编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给改变类的对象决定**
**编译时看左边，运行时看右边**

```java
Person s = new Student();
s.静态方法； 执行的是person中的静态方法。
```

*多态性：* **此时只能调用person中的方法，调用Student中的方法会编译不通过，因为编译时看左边**，编译都不通过了就不说其他的了
**运行时如果Student重写了Person的实例方法时，调用Student中的重写实例方法**。

**静态方法不允许被重写，如果重写了之后，多态性的调用静态方法会执行父类的。**

**好处：**变量引用的子类对象不同，执行的方法就不同，实现**动态绑定。**
**弊端：**一个引用类型变量如果声明为父类的类型，但是实际引用的是子类对象，**那么该变量就不能再访问子类中添加的方法和属性了**

### 虚方法调用 Virtual Method Invocation

*虚方法指在编译阶段不能确定方法的调用入口，在运行阶段才能确定的方法，即可能被重写的方法*

### 成员变量没有多态性

方法：子类重写了父类的方法，意味着子类里定义的方法彻底覆盖了父类里的同名方法
**实例变量**：即使子类定义与父类完全相同的实例变量，这个实例变量依然不可能覆盖父类中定义的实例变量

### 向上转型与向下转型

<img src=".\src\转型.png" alt="image-20240304155951045" style="zoom: 80%;" />

上转型对象**不能操作子类新增的成员变量**，**不能调用子类新增的方法**。上转型对象可以**访问子类继承或隐藏的成员变量**，可以调用**子类继承的方法或子类重写的实例方法。**

**ClassCastException:**类型转换异常



### insatanceof 

**检验对象a是否是数据类型A得对象，返回值为boolean型**
**对象a instanceof 数据类型A**

```java
if (a instanceof A){
    //a是否是A类或者是A类的子类的对象
}
```

## Object类

类java.lang.Object是类层次结构的根类，即所有其他类的父类。**超类**

1. **==:**基本数据类型：变量的值相等即可。引用数据类型：只有指向同一个对象时，==才返回true，**比较的是内存地址**
2. **equals():**所有类继承自Object，重写equals()方法，根据每个类中自己的equals来比较
3. **toString()**:在String与其他数据类型连接操作时，自动调用toString方法
4. **clone()**:在堆中重新开辟了一份空间，**A  implements Cloneable**{}
5. **finalize():**当对象被回收时，系统自动调用该对象的finalize()方法（不是垃圾回收器调用，是本类对象自己调用）
6. **getClass():**因为多态，所以一个引用数据类型的变量的编译时类型运行时类型不一致，因此如果需要查看这个变量实际指向的对象的类型，需要getClass方法
7. **hashCode():**返回每个对象的hash值

## native关键字

使用native关键字说明这个方法是原生函数，也就是这个方法用c/c++等非java语言实现，并且编译成了DLL，由java去调用。

---

# 面向对象编程（高级）

## static关键字

static可以修饰**属性，方法，代码块，内部类**

```java
public class A{
    public static int a;
    public static int method_1(){
        
    }
}
```

**静态变量**jdk6之前在方法区，jdk7之后在堆空间

+ **在static方法内部只能访问类的static修饰属性或方法，不能访问类的非静态的结构**
+ **静态方法可以被子类重写**，**但是被子类重写（子类对象的向上转型（多态的动态绑定）只能调用父类的静态方法，成员变量调用的是被子类隐藏的。）**

## 单例（Singleton）设计模式

**饿汉式**

```java
class Singleton{
    //1.私有化构造器,就不能用new操作符在类的外部产生类的对象，但是类的内部仍可以产生该类对象
    private Singleton(){}
    //2.内部提供一个当前类的实例
    //4.此实例也必须静态化
    private static Singleton single = new Singleton)();
    //3.提供公共的静态方法返回当前类的对象
    public static Singleton getInstance(){
        return single;
    }
}
```

**懒汉式**(会有线程安全的问题)

```java
class Singleton{
    private Singleton(){}
    private static Singleton single;
    public static Singleton getInstance(){
        if(single == null){
            single = new Singleton();
        }
        return single;
    }
}
```

## main方法的语句理解

+ JVM调用main方法，所以是public
+ 调用时不必创建对象，所以是static
+ main方法接收一个String类型的数组参数，保存了执行java命令时传递给运行的类的参数
+ 又因为是静态的，不能访问非静态的成员，所以必须创建一个类的实例对象后，才能通过这个对象访问类中的非静态成员

```java
public class CommandPara{
    public static void main(String[] args){
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i])
        }
    }
}

java CommandPara "Tom" "Jerry"
```

## 代码块

**静态代码块**

```java
public class A{
    static{
        静态代码块
    }
    {
        非静态代码块
    }
}
```

+ 随着类的加载而执行，只执行一次
+ 可以有输出语句
+ 可以对类的属性、类的声明进行初始化（static），不可以调用非静态的属性和方法
+ 多个静态代码块，从上到下依次执行，且静态代码先于非静态代码块(因为要先加载类的嘛)

**非静态代码块**

多个构造器的公共代码，并且这些代码先于构造器其他代码执行，那么可以将这部分代码抽取到非静态代码块中。

+ 可以对类的属性、类的声明进行初始化（static）
+ 可以有输出语句
+ 只执行一次且先于构造器执行

**由父及子，静态先行：实例变量赋值顺序**

## final关键字

final：最终的、不可更改的

**final修饰类**

**表示这个类不能被继承，没有子类。**

eg. String,System,StringBuffer

```java
final class Eunuch{//太监类
    //不能被继承
}
```

**final修饰方法**

**表示这个方法不能被子类重写**(老老实实继承，不允许做任何篡改)

```java
class Father{
    public final void method_1(){
        
    }
}
class son extends Father{
    public void method_1(){
        //错误，不能被子类重写
    }
}
```

**final修饰成员变量**

修饰成员变量或局部变量，一旦赋值，它的值就不能更改，一般使用大写字母

**可以显式赋值、或在初始化块赋值、实例变量还可以在构造器中赋值**

引用数据类型时是**地址不能变了**

## abstract关键字

父类声明方法时，就只有方法签名，没有方法体，称为**抽象方法**。包含抽象方法的类必须是**抽象类**，但是也可以没有abstract方法，可以有的方法有方法实体。

```java
public abstract class A extends B{
   	//public修饰符可以省略
    public abstract void method_1(形参);
    int max(int x, int y){
        return x>y?x:y;
    }
}
```

+ 抽象类不能创建对象
+ 抽象类的子类必须重写父类的所有抽象方法（或者也可以再抽象一手，子类也是abstract抽象的。）
+ 抽象类中也有**构造方法**，是子类创建对象时，初始化父类成员变量使用的，**只是（不能abstarct修饰变量、代码块、构造器；没有括号等于没用。）**
+ 不能abstract修饰私有方法（私有方法我又继承不了，你不写哪个给你写，你还抽象。）、静态方法（静态方法是类有的，如果你静态方法抽象化了，我子类又继承不了你的静态方法，那不是你这个抽象方法等于没有）、fianl方法、fianl的类。

**自洽**

## 接口Interface

interface会被编译成.class文件，但是他不是类，而是另外一种引用数据类型

```java
public interface interface_1{
    //接口没有成员变量
    
    //只能是public; 如果不是public，那么只能在同个包下被实现，可访问权限就降低很多了
    //公共的静态常量， 可以通过interface_1.PI调用(多个接口出现相同命名的常量)
    public static final double PI = 3.14159246L;
    //公共的抽象方法
    public abstract void in();
    //其中public可以省略，但是当类实现接口时需要显示的表达出来。
    
   	//JDK8.0上
    //公共的默认方法, 类继承接口时可以直接调用也可以重写(省略default)
    public default void start(){
        System.out.println("输出")
    }
    //公共的静态方法, 只能由接口调用，不能由其他实现类进行
    public static void show(){
        System.out.println("公共的静态方法")
    }
    //私用方法, 主要就接口自己调用， 在默认方法和静态方法中的共同代码进行抽取
    private static void end(){
        
    }
}

//接口不能创建对象，但是可以被实现implements， 可以实现多个接口 
//如果出现父类中和接口中的方法重名时，就近选择父类中的方法执行
public class A extends B implements interface_1, interface_2{
    //必须重写接口中的抽象类，如果实现类是抽象类，那么可以不重写. 如果抽象方法有重名的，只需要重写一次
    //可选重写接口中的默认方法， 重写则省略default
    //接口中的静态方法不能被继承也不能被重写
    
    //当一个类实现多个接口，而多个接口中包含方法签名相同的默认方时必须重写其方法签名相同的方法
    @override
    public void date(){
        //保留一个父接口的， 接口名.super.方法
        Fridend.super.date();
        BoyFriend.super.date();
        //完全重写。
        System.out.println("完全重写")
    }
}

//接口的继承，可以继承一个或多个接口
public interface_3 extends interface_1, interface_2{
    //默认方法重写时可以保留default
}

//接口的多态
interface_1 x = new A();
//编译时只能调用interface_1的方法，但是运行时调用的是类A中的重写方法

//（接口回调）把实现某一个接口的类创建的对象的引用赋给该接口声明的接口变量中，那么该接口变量就可以调用被类重写的接口方法。当接口变量调用被类重写的接口方法时，就是通知相应的对象调用这个方法。
public class C{
    A a;
    public void set(A a){
        this.a = a;
    }
    public interface A{
    	public void onEnsure();
	}
    if(a != null){
        a.onEnsure;
        //我的理解，如果直接在C中写这个方法，可能需要很多B中的实例，很不方便。
    }
}

public class B{
    C c = new C();
    c.set(new A(){
        @override
        public void onEnsure{
       		     
        }
    });
}
```

## 内部类InnerClass

当一个事务A的内部，还有一个部分需要一个完整的结构B来进行描述，而这个内部的完整的结B又只为外部事物A提供服务，不在其他地方单独使用，那么内部的完整结构B最好是内部类。遵循高类聚，低耦合的面向对象开发原则。

![](.\src\内部类.jpg)

### 成员内部类

如果**成员内部不使用外部类的非静态成员**，那么通常将内部类声明为**静态内部类**，否则声明为**非静态内部类**

```java
public class OuterClass{
    private String s = "nihao";
    private static class static_InnerClass{
        
    }
    private class no_static_InnerClass{
        private String s = "world";
        OuterClass.super.s;
        //发生重名时调用外部类的s,内部就是this.s
    }
    //实例化静态内部类（静态内部类在外部类加载的时候已经加载好了，所以可以直接new）
    OuterClass.InnerClass inner = new OuterClass.InnerClass();
    //实例化非静态内部类(非静态内部类，你外部类没有声明一个对象，我这个内部类就还没有加载，外部对象.new 内部)
    OuterClass outer = new OuterClass();
    outer.no_static_InnerClass no = outer.new no_static_innerClass();
    no.非静态方法();
}
```

+ 成员内部类作为**类的成员**的角色
  + **和外部类不同，innerclass还可以声明为private，protected，public，缺省**
  + 可以调用外部类的结构（注意：在**static静态内部类**中不能使用**外部类的非静态成员**）
+ 成员内部类作为**类**的角色
  + 可以在内部定义**属性、方法、构造器等结构**
  + 可以继承自己的想要继承的父类的，实现自己想要实现的接口们，和**外部类的父类和父接口无关**
  + 可以声明为**abstract**类，因此可以被其他的内部类继承
  + 可以声明为**final**，表示不能被继承
  + 编译以后生成OuterClass$InnerClass.class字节码文件
+ 访问：内部类.成员 ， 内部类对象.成员
+ 成员内部类可以放为外部类的所有成员，包括私有的数据
+ 在外部类的静态成员部分使用内部类可以考虑将内部类声明为**静态内部类**

### 非匿名局部内部类

```java
public class outer{
    public void method_1(形参){
        [final/abstract] class 内部类{
            
        }
    }
}
```

+ 有自己的独立的字节码文件，只不过在内部类名前面冠以**外部类名、$、编号（因为在同一个外部类中，不同的方法存在相同名称的局部内部类）**。
+ **和成员内部类不同的是，他的前面不能有权限修饰符。**
+ 局部内部类同局部变量一样，有作用域
+ 局部内部类中能否访问外部类的非静态成员，取决于所在的方法。

### 匿名内部类

```java
new 父类（形参列表）{
    重写方法...
}.方法

new 父接口(){
    重写方法
}.方法
//匿名内部类没有名字这个特殊性质，所以我们无从给它指定构造方法
    
//通过父类或父接口的变量多态引用匿名内部类的对象
interface_1 obj = new interface_1(){
    @override
    重写方法...
}
```

## 枚举enum

本质上也是一种类。只不过这个类的对象有限、固定几个、不能让用户随意创建。

### 定义枚举类（jdk5.0之前）

```java
class Season{
    //实例变量在构造器中初始化
    private final String seasonName;//季节的名称
    //私有化构造器，保证不能在类的外部创建其对象
    private Season(String season){
        this.seasonName = season;
    }
    //在类的内部创建枚举类的实例， 对外暴露这些常量并且不可更改
    public static final Season SPRING = new Season("春天")	
}
```

### enum关键字（jdk5.0之后）

```java
//默认继承java.lang.Enum
public enum enum_1{
    //常量对象列表; 会自动添加public static final修饰； 且必须写在第一行
    SUMMER,
    SPRING("春天");
    
    private final String seasonName;
    //会默认提供一个private的无参构造器
    private enum_1(String seasonName){
        this.seasonName = seasonName;
    }
    //对象的实例化列表;
    SUMMER = new enum_1("夏天");
    
    //常用方法
    String toString(){
        //默认返回常量名，可以重写该方法
    }
    public static 枚举类型[] values(){
        //返回枚举类型的对象数组。
    }
    public static 枚举类型 valueOf(String name){
        //可以把一个字符串转化为对应的枚举类型对象， 但是要求字符串必须是枚举对象的“名字”
    }
    String name(): 得到当前枚举常量的名称;
    int ordinal():返回当前枚举常量的次序号，默认从0开始。
}
```

```java
//jdk5.0之后可以在switch中使用enum
switch(enum_1){
    case SPRING:
        System.out.println("你哈");break;
    case SUMMER:
        break;
}
```

### 实现接口的枚举类

```java
//枚举类和普通的方法一样，可以实现多个接口，但是必须实现里面所有的抽象方法
enum A implements interface_1, interface_2{
    //抽象方法的实现
    常量1（参数）{
        @override
        //抽象方法的实现或重写
    }
}
```

## 注解（Annotation）

**框架 = 注解 + 反射 + 设计模式**

+ @override
+ @Deprecated:表示所修饰的元素（类、方法）已过时
+ @SupperessWarnings('all'):抑制编译器警告

## JUnit测试-白盒测试



## 包装类(封装类)

| 基本数据类型 | 包装类    |
| ------------ | --------- |
| byte         | Byte      |
| short        | Short     |
| int          | Integer   |
| long         | Long      |
| float        | Float     |
| double       | Double    |
| boolean      | Boolean   |
| char         | Character |

基本数据类型在栈中，**封装之后在堆中。**

### 装箱-基本数据类型->包装类对象

```java
Integer obj1 = new Integer(4);//构造函数
Float float = new Float("4.56");//Float(String )
Long l = new Long("asfd"); //NumberFormatException
Integer obj2 = Integer.valueOf(4);//使用包装类的valueOf方法
```

### 拆箱-包装类对象->基本数据类型

```java
Integer obj = new Integer(4);
int num1 = obj.intValue();
```

### 自动装箱拆箱

```java
Integer i = 4;//自动装箱，相当于Integer i = Integer.valueOf(4);
i = i+5;//等号右边自动拆箱。i.intValue() + 5; 加法完成后再次装箱；

Double d = 4; //错误，4是int型；
```

### 基本数据类型、包装类、字符串之间的转换

```java
//1.基本数据类型->字符串
int a = 10;
String str = String.ValueOf(a);
String str = a + '';

//2.字符串->基本数据类型
//除Character外，parsexxx()静态方法将字符串转换为对应的基本类型
public static int parseInt(String s);
int a = Integer.parseInt("4")
//字符串->包装类->自动拆箱->基本数据类型
public static Integer valueOf(String s);
int a = Integer.valueOf("4")
//通过包装类的构造器实现
int a = new Integer("4")
```

![image-20240305155940830](.\src\String转换.png)

### 包装类的其他API

```java
//数据类型的最大值和最小值
Integer.MAX_VALUE, Integer.MIN_VALUE;
//字符转大小写
Character.toUpperCase('x'), Character.toLowerCase('X');
//整数转进制
Integer.toBinaryString(int i);
Integer.toHexString(int i);
Integer.toOctalString(int i);
//比较方法
Double.compare(double d1, double d2);
Integer.compare(int x, int y);
```

****

---

# 异常处理

异常并不是语法错误或逻辑错误（编译根本过不了，运行不起来）

### Throwable接口：

public void printStackTrace():打印异常的详细信息。
public String getMessage():获取发生异常的原因。

### java.lang.Error和java.lang.Exception

error:java虚拟机无法解决的严重问题；stackOverflowError（栈溢出）OutOfMemoryError（堆内存溢出，OOM）

Exception:空指针访问、试图读取不存在的文件、网络连接中断、数组角标越界
ArrayIndexOutOfBoundsException:数组下标越界异常；ClassCastException:类型转换异常；

![image-20240305193201206](.\src\异常.png)

受检：编译时；非受检：运行时；

### try-catch-finally

```java
//捕获机制（try-catch-finally）
try{
    //抛
    //局部作用域
}
catch(异常类型1 e){
    //当产生异常类型1的处置措施
}
catch(异常类型2 e){
    //如果多个catch分支语句，并且多个异常类型有父子关系，必须保证小的异常类型在上，大的异常类型在下（子类在上）
}
finally{
    //无论是否发生异常，都无条件执行的语句
    //System.exit()来终止当前运行的java虚拟机就不用finally了
}
```

### 声明抛出异常类型（throws）

当找不到合适的方法处理异常时，则此方法显示的声明抛出异常，表明该方法不对这些异常进行处理，而由该方法的调用者负责处理。

```java
public void method_1 throws 异常_1,异常_2{
    
}
```

## 手动抛出异常对象：throw

+ 虚拟机自动生成，自动创建并抛出
+ 手动创建：**new 异常类型([实参列表])**

```java
throw new 异常类型名（参数）;
//抛出的异常必须是Throwable或其他子类的实例，
throw new String("错误"); //❌
```

### 自定义异常-手动抛出

+ 编译时异常：自定义类继承java.lang.Exception
+ 运行时异常：自定义类继承java.lang.RuntimeException
+ 至少两个构造器：无参构造器、（String message）构造器
+ 自定义异常需要提供（serialVersionUID）

```java
class MyException extends Exception{
    static final long serialVersionUID = 23456789L;
    private int idnumber;
    public MyException(String message, int id){
        super(message);
        this.idnumber = id;
    }
    public int getId(){
        return idnumber;
    }
}
public class MyClass{
    public void regist(num) throws MyException{
        if(num < 0){
            throw new MyException("人数为负数")
        }
    }
}
```



---

# 多线程（java.lang.Thread）

程序（programme）-> 进程（process）-> 线程（thread）

**进程：**作为操作系统调度和分配资源的最小单位
**线程**：进程可进一步细化为线程，是程序内部的一条执行路径，一个进程至少有一个线程。
	一个进程中的多个线程共享相同的内存单元，访问同一个堆中。但是多线程操作共享资源可能会带来安全隐患。
	不同进程之间是不能共享内存的，进程之间的数据交换和通信的成本很高。

**并行（paraller）:**指两个或多个事件**同一时刻发生（同时发生）**；即同一时刻，有多条指令在多个CPU上同时执行。
**并发（concurrency）:**指两个或多个事件**同一个时间段内发生**。即在一段时间内，有多个指令在单个CPU上快速轮换、交替执行，使得宏观上多个进程同时执行的效果。

**Thread:**

+ **run()**称为线程执行体
+ 通过Thread对象的**start()**来启动线程
+ 实现多线程，必须在主线程中创建新的线程对象

```java
//自定义线程类
public class MyThread extends Thread{
    //定义指定线程名称的构造方法
    public MyThread(String name){
        //调用父类的String参数的构造方法，指定线程的名称
        super(name);
    }
    //重写run方法，完成该线程的执行逻辑
    @override
    public void run(){
        System.out.println(getName()+"正在执行");
    }
}
public class TestMyThread{
    public static void main(String[] args){
        MyThread mt = new MyThread("线程1");
        //调用start启动线程，如果单纯的调用run()只是一个普通的方法
        mt1.start();
        //一个线程只能调用一次start方法，如果重复调用将抛出”IllegalThreadStateException“
    }
}
```

```java
//实现Runnable接口 -> 重写run方法 -> 再通过Thread类的对象代理启动和执行我们的线程run方法
public class MyRunnable implements Runnable{
    @override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "执行了MyRunnable")
    }
}
public class TestMyRunnable{
    public static void main(String[] args){
        //创建自定义类，线程任务对象
        MyRunnable mr = new MyRunnable();
        //创建线程对象， new Thread(Runnable traget, String name);
        Thread t = new Thread(mr, "长江");
        t.start();
    }
}
```

```java
//使用匿名内部类对象来实现线程的创建和启动
new Thread("新线程"){
    @override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(getName()+"正在执行"+i);
        }
    }
}.start();
//实现Runnable接口的匿名实现类的匿名对象
new Thread(new Runnable(){
    @override
    public void run(){
        System.out.println(Thread.current().getName()+":")
    }
}).start();
```

**使用Runnable的优势**

+ 避免了单继承的局限性
+ 多个相同的线程可以共享一个接口的实现类的对象，非常适合多个线程来处理同一份资源。
+ 实现解耦操作

```java
//Thread 常用结构
public class Thread extends Object implements Runnable
public Thread();
public Thread(String name);
public Thread(Runnable target);
public Thread(Runnable target, String name);//分配一个带有指定目标新的线程对象并指定名字

public String getName();//获取当前线程的名称
public void setName();//设置该线程的名称
public static Thread currentThread();//返回当前只在执行的线程对象的引用。
public static void sleep(long mills);//使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）
public static void yield();//让当前线程暂停一下，让系统的调度器重新调度一次
public void interrupt();//

public final boolean isAlive();//测试线程是否处于活动状态，如果线程已经启动且尚未终止，则为活动状态。
void join();//等待该线程终止 在main中调用b.join(),则只有b执行完之后才执行main
void join(long mills);//让b先执行mills毫秒，如果还没执行完就不再等待
void join(long mills, int nanos);//mills毫秒+nanos纳秒
public final void stop();//过时，不再使用，强制结束一个线程的执行，直接进入死亡状态
void suspend()/void resume();//好比暂停和恢复。二者必须成对出现，否则非常容易发生死锁。suspend()使线程暂停但是不会释放任何锁资源，知道调用resume（）；已过时。

//优先级常量
MAX_PRIORITY(10):最高优先级;
MIN_PRIORITY(1):最低优先级;
NORM_PRIORITY(5):普通优先级，默认情况下main就是普通优先级;
public final int getPriority();//返回线程优先级
public final void setPriority(int newPriority);//改变线程优先级，范围在[1,10]之间

```

![image-20240306151151787](.\src\线程五种状态之间的转换.png)

**jDK1.5之后的六种装态**

![六种状态](.\src\六种状态.png)

## 线程安全问题及解决

？当使用多个线程访问**统一资源**（同一个变量，用一个文件、同一条记录等）

**Thread子类中的局部变量是独立的，不是共享数据**，public static int ticket静态变量是共享的。

### **同步机制（synchronized）**

```java
//同步代码块：synchronized关键字可以用于某个区块前面，表示只对这个区块的资源实行互斥访问。
//同步锁：多个线程必须共用一个同步监视器（同一个类）=> this或类名.class
synchronized(同步锁){
    //需要同步的代码
}

//同步方法：synchronized关键字直接修饰方法，表示同一时刻只能有一个线程能进入这个方法，其他线程在外面等着
//默认：静态方法：当前类的class对象（类名.class）, 非静态方法：this
public synchronized void method(){
    //可能会产生线程安全问题的代码
}

```

```java
示例一：静态方法加锁
class TicketSaleThread extends Thread{
    private static int ticket = 100;
    public void run(){//直接锁这里，肯定不行，会导致，只有一个窗口卖票
        while (ticket > 0) {
            saleOneTicket();
        }
    }

    public synchronized static void saleOneTicket(){//锁对象是TicketSaleThread类的Class对象，而一个类的Class对象在内存中肯定只有一个
        if(ticket > 0) {//不加条件，相当于条件判断没有进入锁管控，线程安全问题就没有解决
            System.out.println(Thread.currentThread().getName() + "卖出一张票，票号:" + ticket);
            ticket--;
        }
    }
}
public class SaleTicketDemo3 {
    public static void main(String[] args) {
        TicketSaleThread t1 = new TicketSaleThread();
        TicketSaleThread t2 = new TicketSaleThread();
        TicketSaleThread t3 = new TicketSaleThread();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

示例二：非静态方法加锁
public class SaleTicketDemo4 {
    public static void main(String[] args) {
        TicketSaleRunnable tr = new TicketSaleRunnable();
        Thread t1 = new Thread(tr, "窗口一");
        Thread t2 = new Thread(tr, "窗口二");
        Thread t3 = new Thread(tr, "窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketSaleRunnable implements Runnable {
    private int ticket = 100;

    public void run() {//直接锁这里，肯定不行，会导致，只有一个窗口卖票
        while (ticket > 0) {
            saleOneTicket();
        }
    }

    public synchronized void saleOneTicket() {//锁对象是this，这里就是TicketSaleRunnable对象，因为上面3个线程使用同一个TicketSaleRunnable对象，所以可以
        if (ticket > 0) {//不加条件，相当于条件判断没有进入锁管控，线程安全问题就没有解决
            System.out.println(Thread.currentThread().getName() + "卖出一张票，票号:" + ticket);
            ticket--;
        }
    }
}

示例三：同步代码块
public class SaleTicketDemo5 {
    public static void main(String[] args) {
        //2、创建资源对象
        Ticket ticket = new Ticket();

        //3、启动多个线程操作资源类的对象
        Thread t1 = new Thread("窗口一") {
            public void run() {//不能给run()直接加锁，因为t1,t2,t3的三个run方法分别属于三个Thread类对象，
                // run方法是非静态方法，那么锁对象默认选this，那么锁对象根本不是同一个
                while (true) {
                    synchronized (ticket) {
                        ticket.sale();
                    }
                }
            }
        };
        Thread t2 = new Thread("窗口二") {
            public void run() {
                while (true) {
                    synchronized (ticket) {
                        ticket.sale();
                    }
                }
            }
        };
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    synchronized (ticket) {
                        ticket.sale();
                    }
                }
            }
        }, "窗口三");


        t1.start();
        t2.start();
        t3.start();
    }
}

//1、编写资源类
class Ticket {
    private int ticket = 1000;

    public void sale() {//也可以直接给这个方法加锁，锁对象是this，这里就是Ticket对象
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出一张票，票号:" + ticket);
            ticket--;
        } else {
            throw new RuntimeException("没有票了");
        }
    }

    public int getTicket() {
        return ticket;
    }
}
```

### 懒汉式线程安全问题

**饿汉式没有线程安全问题，在初始时就直接创建了单例对象**
懒汉式：延迟创建对象，在第一次调用getInstance方法时候才创建对象

```java
public class LazyOne {
    private static LazyOne instance;

    private LazyOne(){}

    //方式1：static同步方法，默认锁为类名.class
    public static synchronized LazyOne getInstance1(){
        if(instance == null){
            instance = new LazyOne();
        }
        return instance;
    }
    //方式2：同步代码块，手动指明监视器 this或者类名.class
    public static LazyOne getInstance2(){
        synchronized(LazyOne.class) {
            if (instance == null) {
                instance = new LazyOne();
            }
            return instance;
        }
    }
    //方式3：
    public static LazyOne getInstance3(){
        //可以减少后续代码进入同步部分。
        if(instance == null){
            synchronized (LazyOne.class) {
                try {
                    Thread.sleep(10);//加这个代码，暴露问题
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(instance == null){
                    instance = new LazyOne();
                }
            }
        }

        return instance;
    }
    /*
    注意：上述方式3中，有指令重排问题
    mem = allocate(); 为单例对象分配内存空间
    instance = mem;   instance引用现在非空，但还未初始化
    ctorSingleton(instance); 为单例对象通过instance调用构造器
    从JDK2开始，分配空间、初始化、调用构造器会在线程的工作存储区一次性完成，然后复制到主存储区。但是需要   
    volatile关键字，避免指令重排。
    */
    
}
形式二：使用内部类， 内部类只有在外部类调用时才加载，产生INSTANCE实例，又不用加锁。
public class LazySingle {
    private LazySingle(){}
    
    public static LazySingle getInstance(){
        return Inner.INSTANCE;
    }
    
    private static class Inner{
        static final LazySingle INSTANCE = new LazySingle();
    }
    
}

```

### 死锁

不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁。

```java
public class DeadLockTest {
	public static void main(String[] args) {

		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();

		new Thread() {
			public void run() {
				synchronized (s1) {
					s1.append("a");
					s2.append("1");
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (s2) {
						s1.append("b");
						s2.append("2");

						System.out.println(s1);
						System.out.println(s2);

					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				synchronized (s2) {
					s1.append("c");
					s2.append("3");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized (s1) {
						s1.append("d");
						s2.append("4");

						System.out.println(s1);
						System.out.println(s2);

					}

				}
			}
		}.start();

	}
}
```



+ 互斥条件
+ 占用且等待
+ 不可抢夺（或不可抢占）
+ 循环等待

以上4个条件，同时出现就会触发死锁。

**死锁一旦出现**，基本很难人为干预，只能尽量规避。可以考虑打破上面的诱发条件。

+ 针对条件1：互斥条件基本上无法被破坏。因为线程需要通过互斥解决安全问题。

+ 针对条件2：可以考虑一次性申请所有所需的资源，这样就不存在等待的问题。

+ 针对条件3：占用部分资源的线程在进一步申请其他资源时，如果申请不到，就主动释放掉已经占用的资源。

+ 针对条件4：可以将资源改为线性顺序。申请资源时，先申请序号较小的，这样避免循环等待问题。

### lock-jdk5.0新特性

```java
//java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前应先获得Lock对象。
    
//–	ReentrantLock类实现了 Lock 接口，它拥有与 synchronized 相同的并发性和内存语义，但是添加了类似锁投票、定时锁等候和可中断锁等候的一些特性。此外，它还提供了在激烈争用情况下更佳的性能。

class A{
    //1. 创建Lock的实例，必须确保多个线程共享同一个Lock实例
	private final ReentrantLock lock = new ReenTrantLock();
	public void m(){
        //2. 调动lock()，实现需共享的代码的锁定
		lock.lock();
		try{
			//保证线程安全的代码;
		}
		finally{
            //3. 调用unlock()，释放共享代码的锁定，手动关闭
			lock.unlock();  
		}
	}
}
//注意：如果同步代码有异常，要将unlock()写入finally语句块。

```

lock > 同步代码块 > 同步方法

## 线程间的通信-等待唤醒机制

+ wait：**线程不再活动，不再参与调度，进入 wait set 中，因此不会浪费 CPU 资源，也不会去竞争锁了，这时的线程状态是 WAITING 或 TIMED_WAITING。**它还要等着别的线程执行一个特别的动作，也即**“通知（notify）”或者等待时间到**，在这个对象上等待的线程从wait set 中释放出来，重新进入到调度队列（ready queue）中
+ notify：则选取所通知对象的 wait set 中的一个线程释放；
+ notifyAll：则释放所通知对象的 wait set 上的全部线程。



---

# 常用类和基础API

## String

```java
//finale声明，不可继承String
public final class String{
    //字符串创建后不可更改
    private final char[] value;
    //构造器
    public String();
    public String(String original);
    public String(char value[]);
    public String(char value[], int offset, int count);
    public String(int[] codePoints, int offset, int count);
    public String(byte bytes[], int offset, int length, String charsetName);
    public String(byte bytes[], int offset, int length, Charset charset);
    public String(byte bytes[], String charsetName);
    public String(byte bytes[], Charset charset);
    public String(byte bytes[], int offset, int length);
    public String(byte bytes[]);
    public String(StringBuffer buffer);
    public String(StringBuilder builder);
    
    //String 和其他结构的转换， 想要变成什么就去那里面找API
    
    //使用指定的字符集将此String编码到byte序列，并将结果存储到新的byte数组
    public byte[] getBytes(String charsetName);
    //提供了将指定索引范围内的字符串存放到数组中的方法
    public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin);
    //字符串是否为空
    public boolean isEmpty();
    //return value.length
    public int length();
    //堆空间的s1对象调用后会返回常量池中的字符串, 所以一个字符串常量和这个拼接之后的字符串变量有相同的地址。
    public native String intern();
    //返回String对象，哪怕是两个常量拼接，结果也在堆中。
    public String concat(String str);
    //比较字符串是否相等,区分大小写
    public boolean equals(Object anObject);
    //比较字符串是否相等，不区分大小写
    public boolean equalsIgnoreCase(String anotherString);
 	//逐位比较,区分大小写
    public int compareTo(String anotherString);
    //不区分大小写
    public int compareToIgnoreCase(String str);
    //去掉字符串前后的空白符;
    public String trim();
    
    //是否包含CharSequence是一个接口，String就实现了这个接口。
    public boolean contains(CharSequence s);
    //从前往后找str，当有匹配时返回第一次出现的下标，没有返回-1；
    public int indexOf(String str);
    public int indexOf(String str, int fromIndex);
    //从后向前找
    public int lastIndexOf(String str);
    public int lastIndexOf(String str, int fromIndex);
    //此字符串对象从beginIndex开始到最后一个字符串
    public String substring(int beginIndex);
    public String substring(int beginIndex, int endIndex);
    //返回[index]位置的字符
    public char charAt(int index);
    //将此字符串转化为一个新的字符数组返回
    public char[] toCharArray();
    //返回指定数组中表示该字符序列的String
    public static String valueOf(char data[]);
    public static String valueOf(char data[], int offset, int count);
    //返回指定数组中表示该字符序列的String
    public static String copyValueOf(char data[]);
    public static String copyValueOf(char data[], int offset, int count);
    //测定该字符串是否以指定的前缀开始
    public boolean startsWith(String prefix);
    //测定此字符串从指定位置开始的子字符串是否以指定前缀开始
    public boolean startsWith(String prefix, int toffset);
    //字符串是否以指定后缀结束
    public boolean endsWith(String suffix);
    //得到一个新的字符串，其中所有的oldChar用newChar替换
    public String replace(char oldChar, char newChar);
    //使用指定的替换序列replacement替换此字符串所有的匹配target
    public String replace(CharSequence target, CharSequence replacement);
    //使用指定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
     public String replaceAll(String regex, String replacement);
    //使用指定的replacement替换此字符串所有匹配给定的正则表达式的子字符串
    public String replaceFirst(String regex, String replacement);
    //依据正则表达式分裂字符串。
    public String[] split(String regex, int limit);
}


public static void main(String[] args){
    String s1 = "hello";
    String S2 = "hello";
    String s3 = new String("hello");
    s1 == S2;//指向相同的内存空间
    s1 == s3;//flase;s3构造方法指向堆空间中value的地址，而s1则是直接指向方法区，所以他们两个的地址不相同
    
    String s1 = "hello";
    String s2 = "world";
    String s3 = "hello" + "world";
    String s4 = s1 + "world";
    String s5 = s1 + s2;
    String s6 = (s1 + s2).intern();

    System.out.println(s3 == s4);
    System.out.println(s3 == s5);
    System.out.println(s4 == s5);
    System.out.println(s3 == s6);
	//false, false, false, true;
    //常量与常量 -> 常量池中
    //常量与变量或变量与变量：结果在堆中
    //拼接后调用intern,返回的值在常量池中
	//堆中的意思是：str这个变量指向堆，堆在指向常量池。
}

public class StringTest {

    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        System.out.println(System.identityHashCode(str));
        //"test ok"的地址给了str，所以此时str的地址已经和this.str的地址不一样了
        str = "test ok";
        ch[0] = 'b';
        System.out.println(System.identityHashCode(this.str));
        System.out.println(System.identityHashCode(str));
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");//
        System.out.println(ex.ch);
    }
}
//460141958	460141958	1163157884	good and best
//值传递
```

![image-20240306200243056](.\src\String.png)

字符串常量池jdk6在**方法区**，jdk7开始就移到**堆空间**

## 可变字符序列：StringBuffer、StringBuilder

因为字符串是不可变对象，虽然可以共享常量对象，但是频繁对字符串进行修改和拼接操作，效率低而且空间消耗也多。

```java
public final class StringBuilder extends AbstractStringBuilder implements Serializable, CharSequence{
    //内部数据存储
    public StringBuilder() {
        super(16);
    }
    AbstractStringBuilder(int capacity) {
        value = new char[capacity];
    }
    char[] value;//底层缓冲，没有final声明
    int count;
    //线程不安全
    //用于字符串追加方式的拼接, 非常多的append方法
    public StringBuilder append(String str);
    public StringBuilder append(StringBuffer sb);
    public StringBuilder append(CharSequence s);
    public StringBuilder append(CharSequence s, int start, int end);
    //删除操作
    public StringBuilder delete(int start, int end);
    public StringBuilder deleteCharAt(int index);
    //原字符串[start,end)的子字符串用str替换
    public StringBuilder replace(int start, int end, String str);
    public int length();
    //反转
    public AbstractStringBuilder reverse();
    //设置当前字符串的长度为newLength
    public void setLength(int newLength);
}
 public final class StringBuffer extends AbstractStringBuilder implements Serializable, CharSequence{
     //同StringBuilder
     //有synchronized修饰，线程安全
     
 }
```

## StringTokenizer

```text
The string tokenizer class allows an application to break a
* string into tokens. The tokenization method is much simpler than
* the one used by the {@code StreamTokenizer} class. The
* {@code StringTokenizer} methods do not distinguish among
* identifiers, numbers, and quoted strings, nor do they recognize
* and skip comments.
```

```java
public class StringTokenizer implements Enumeration<Object> {
    //构建一个分析器，参数delim的字符序列的字符的任意排列被作为分割标记。
    public StringTokenizer(String str, String delim);
    //构建一个分析器，默认的分割标记，即：空格、换行符、回车、Tab
    public StringTokenizer(String str);
    //是否还有下一个token
    public boolean hasMoreTokens();
    //下一个token
    public String nextToken();
}
```



## java.util.Date

```java
//使用无参构造器创建的对象可以获取本地当前的时间
public Date() {
    this(System.currentTimeMillis());
}
//把毫秒值换算成日期时间对象
public Date(long date);
//返回此Date对象自1970年表示的毫秒数
public long getTime();
//EEE MMM dd HH:mm:ss zzz yyyy
public String toString();
```

## java.text.SimpleDateFormat

```java
//不与语言环境有关的方式来格式化和解析日期的具体类
//格式化：日期->文本； 解析：文本->日期
public class SimpleDateFormat extends DateFormat{
    //默认的模式和语言环境创建对象
	public SimpleDateFormat();
    //该构造方法可以用参数pattern指定的格式创建一个对象
    public SimpleDateFormat(String pattern);
    //方法格式化事件对象date
    public final String format(Date date);
    //从给定字符串的开始解析文本，以生成一个日期
    public Date parse(String source) throws ParseException;
}
```

![image-20240308155356253](.\src\SimpleDateFormat.png)

## java.util.Calendar

```java
//主要用于完成日期字段之间相互操作的功能
public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar>{
    //获取Calendar实例的方法，Calendar.getInstance()方法或者调用子类GregorianCalendar的构造器
    public static Calendar getInstance();
    /* java.util.GregorianCalendar[time=1709885777723,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=31,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2024,MONTH=2,WEEK_OF_YEAR=10,WEEK_OF_MONTH=2,DAY_OF_MONTH=8,DAY_OF_YEAR=68,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=16,SECOND=17,MILLISECOND=723,ZONE_OFFSET=28800000,DST_OFFSET=0]
    */
    //返回给定日历字段的值
    public int get(int field);
    //将给定的日历字段设置为指定的值
    public void set(int field, int value);
    //根据日历的规则，为给定的日历字段添加或者减去指定的时间量
    abstract public void add(int field, int amount);
    //将Calendar转化为Date类
    public final Date getTime() {
        return new Date(getTimeInMillis());
    }
    //使用指定的Date对象重置Calendar的时间
    public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }
}
//GregorianCalendar公历
public class GregorianCalendar extends Calendar{
     public GregorianCalendar();
}
```

## 本地日期时间：LocalDate、LocalTime、LocalDateTime



## 瞬时Instant



## 日期时间格式化：DateTimeFormatter



## 自然排序：java.lang.Comparable

comparable接口强行对实现它的每个类的对象进行整体排序。

```java
public interface Comparable<T>{
    
    public int compareTo(T o);
}
```



## 定制排序：java.util.Comparator

```java
public interface Comparator<T> {
    int compare(T o1, T o2);
    //将Comparator传递给sort方法（Collections.sort或者Arrays.sort）
    public static <T> void sort(T[] a, Comparator<? super T> c){
        Arrays.sort(arr, [实现了comparator接口的类])
    }
}
```



## 系统类：java.lang.System

```java
public final class System {
    private System() {
        //Don't let anyone instantiate this class
    }
    //标准输入流、标准输出流、标准错误输出流
    public final static InputStream in = null;
    public final static PrintStream out = null;
    public final static PrintStream err = null;
    //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
	//适用于计算时间差
    public static native long currentTimeMillis();
    //推出程序的状态
    public static void exit(int status) {
        Runtime.getRuntime().exit(status);
    }
    //请求系统进行垃圾回收
    public static void gc() {
        Runtime.getRuntime().gc();
    }
    //获得系统中属性名为key的属性对应的值。
    public static String getProperty(String key);
}
```

![image-20240309084216396](F:\typora笔记\java\src\属性名key.png)

## java.lang.Runtime类

```java
//每个java应用程序都有一个Runtime类实例，使应用程序能够与其运行的环境相连接。
public class Runtime {
	private static Runtime currentRuntime = new Runtime();
    //返回当前java应用程序相关的运行时对象
    public static Runtime getRuntime() {
        return currentRuntime;
    }
    //返回java虚拟机初始化时内存总量
    public native long totalMemory();
    //返回java虚拟机中最大程度能使用的内存总量
    public native long maxMemory();
    //返回java虚拟机中空闲内存量
    public native long freeMemory();
}
```



## java.lang.Math

```java
public final class Math {
    private Math() {}
    //返回a的绝对值
    public static double abs(double a);
    //返回大于等于参数的最小的整数
    public static double ceil(double a);
    //返回小于等于参数最大的整数
    public static double floor(double a);
    //四舍五入
    public static long round(double a);
    //返回a的b次幂
    public static double pow(double a, double b);
    //返回a的平方根
    public static double sqrt(double a);
    //返回[0,1)的随机数
    public static double random();
    public static int max(int a, int b);
}
```

## java.math.BigInteger

```java
public abstract class Number implements java.io.Serializable {
    
}
public class BigInteger extends Number implements Comparable<BigInteger>{
    //把字符串指定进制转化成数
    public BigInteger(String val, int radix) {
        
    }
    public BigInteger(String val) {
        this(val, 10);
    }
    public BigInteger abs();
    public BigInteger add(BigInteger val);
    public BigInteger subtract(BigInteger val);//减法
    public BigInteger multiply(BigInteger val);
    public BigInteger divide(BigInteger val);
    public BigInteger remainder(BigInteger val);//this%val
    //返回包含(this/val)后跟(this%val)的两个BigInteger数组
    public BigInteger[] divideAndRemainder(BigInteger val);
    public BigInteger pow(int exponent);
}
```

## java.math.BigDecimal

```java
public class BigDecimal extends Number implements Comparable<BigDecimal>{
    public BigDecimal(double val); 
    public BigDecimal(String val);
    //divisor是除数，scale是保留几位小数，roundingMode指明舍入模式
    #ROUND_UP
    #ROUND_DOWN
    #ROUND_CEILING
    #ROUND_FLOOR
    #ROUND_HALF_UP
    #ROUND_HALF_DOWN
    #ROUND_HALF_EVEN
    #ROUND_UNNECESSARY
    public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode);
}
```

## java.util.Random

```java
class Random implements java.io.Serializable{
    public Random() {
        this(seedUniquifier() ^ System.nanoTime());
    }
    
    public boolean nextBoolean();
    //生成随机字节并将其置于用户提供的byte数组中
    public void nextBytes(byte[] bytes);
    public double nextDouble();
    public float nextFloat();
    //他是取自随机数生成序列、呈高斯分布，平均值0.0、标准差1.0
    synchronized public double nextGaussian();
    //返回[0,bound)之间均匀分布的值
    public int nextInt(int bound);
}
```



---

# 集合框架

![image-20240309094645443](.\src\集合框架.png)

![image-20240309094948674](.\src\collection.png)

![image-20240309095023158](.\src\map.png)

```java
public interface Collection<E> extends Iterable<E>{
    
    boolean add(E e);//可能是把整个集合看成一个整体的
    boolean addAll(Collection<? extends E> c);//集合中的所有元素都装入。
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    //集合c中的元素是否在该集合中全部存在，即证明是不是该集合的子集
    boolean containsAll(Collection<?> c);
    //判断两个集合是否相等
    boolean equals(Object o);
    
    void clear();
    //删除集合中第一个找到的与obj对象equals返回true的元素
    boolean remove(Object o);
    //从当前集合对象中删除所有与c集合中相同的元素
    boolean removeAll(Collection<?> c);
    //this = this ∩ c
    boolean retainAll(Collection<?> c);
    
    //返回当前集合中所有元素的数组
    Object[] toArray();
    //获取对象的哈希值
    int hashCode();
    //返回迭代器对象，用于集合遍历
    Iterator<E> iterator();
}
```

```java
//迭代器本身不具有存储数据的能力，主要用于便利Collection中的元素
public interface Iterator<E> {
    //返回迭代的下一个元素； 必须调用hasNext进行检测，否则抛出NoSuchElementException异常
	E next();
    //如果仍有元素可以迭代，则返回true
    boolean hasNext();
    //迭代器的remove按照指定位置删除元素，相当于指针，如果还未调用next或者next之后没有值则会报IllegalStateException
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
```

```java
public interface List<E> extends Collection<E> {
    void add(int index, E element);
    //从index开始把c中的全部元素添加过来
    boolean addAll(int index, Collection<? extends E> c);
    E get(int index);
    List<E> subList(int fromIndex, int toIndex);//子集合
    int indexOf(Object o);//返回o在集合中首次出现的位置
    int lastIndexOf(Object o);//返回o在集合中最后一次出现的位置
    E remove(int index);
    E set(int index, E element);//设置指定index位置的元素为element
    
}
```

```java
//Arrays.asList(...), 返回值是一个固定长度的List集合
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{
    
}

//对于频繁的插入或删除元素的操作，使用LinkedList类，效率更高，（双向列表）
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable{
    public void addFirst(E e) {
        linkFirst(e);
    }
    public void addLast(E e) {
        linkLast(e);
    }
    public E getFirst();
    public E getLast();
    public E removeFirst();
    public E removeLast();
}

//线程安全
public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{
    public synchronized void addElement(E obj);
    public synchronized void insertElementAt(E obj, int index);
    public synchronized void setElementAt(E obj, int index);
    public synchronized boolean removeElement(Object obj);
    public synchronized void removeAllElements() ;
}
```

```java
public interface Set<E> extends Collection<E>{
    
}
//按照hash算法(hash值)来存储集合中的元素，具有很好的存储、查找、删除
//判断两元素相等的标准1.hashcode()方法得到的哈希值相同，2.并且两个对象的equals()方法返回值为true
//对于存放在set容器中的对象，对应的类一定要重写hashcode()和equals(Object obj)方法
public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable{
    
}

//使用hashcode值来确定元素的存储位置，但它同时使用双向链表维护元素的顺序。
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable {
    
}

//TreeSet是SortedSet接口的实现类，TreeSet可以按照添加的元素的指定的属性的大小顺序进行便利
//底层使用了红黑树结构
//TreeSet两个元素是否相等，compareTo, compare。且必须为同类型，否则报ClassCastException的异常
//不允许重复、实现排序（自然排序或定制排序）
//1.自然排序，调用compareTo(Object obj)来比较元素之间的大小，默认升序排序， comparable接口
public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, java.io.Serializable{
    //2.定制排序，希望按照其他属性大小进行排序，int compare(T o1, To2);将实现Comparator接口实例作为形参传递给TreeSet
    public TreeSet(Comparator<? super E> comparator) {
        this(new TreeMap<>(comparator));
    }
}
```

```java
//映射关系key-value = entry。所有entry彼此之间是无无序的、不可重复的
//map中的key用Set来存放，不允许重复，即同一个Map对象所对应的类，需重写hashCode()和equals()方法
public interface Map<K,V>{
    V put(K key, V value);//将指定的key-value添加到到当前map对象中
    void putAll(Map<? extends K, ? extends V> m);//将m中的所有Map对象存储到当前Map对象中
    V remove(Object key);//溢出key-value对，并返回value
    void clear();//清空map中的所有数据
    V get(Object key);//获取key对应的value值
    boolean containsKey(Object key);//是否包含值得key
    boolean containsValue(Object value);//是否包含值得value
    int size();//返回当前map中的entry数目
    boolean isEmpty();
    boolean equals(Object o);//当前map和参数obj是否相等
    Set<K> keySet();//返回key构成的set集合
    Collection<V> values();//返回value构成的collection集合
    Set<Map.Entry<K, V>> entrySet();//返回所有key-value对构成的Set集合
    interface Entry<K,V>{
        //内部接口
    }
}

//hashMap是线程不安全的。允许添加null键和null值
//底层使用一维数组+单向链表+红黑树进行key-value数据的存储。元素的存储数据不能保证一致
//判断两个key相等的标准：两个key的hashcode值相等，通过equals()方法返回true
//判断两个value相等的标准：两个value通过equals()方法返回为true
public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {
    
}

//哈希表结构+链表结构，使用了一对双向链表来记录添加元素的先后顺序
//键所在的类重写hashcode()和equals()方法
public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>{
    
}

//保证entry有序状态，底层使用红黑树结构存储数据
//1.自然排序：key必须实现Comparable接口，而且所有的key应该是一个类，否则会抛出ClassCastException
//2.定制排序：创建TreeMap是，构造器传入一个Comparator对象，该对象负责对TreeMap中的所有key进行排序，此时不需要Map的key实现Comparable接口。
//两个key通过compareTo()方法或者compare()方法返回0
public class TreeMap<K,V> extends AbstractMap<K,V> implements NavigableMap<K,V>, Cloneable, java.io.Serializable{
    private final Comparator<? super K> comparator;
    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }
}

//线程安全。同HashMap想同，但不允许使用null作为key或value
public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>, Cloneable, java.io.Serializable{
    
}

//peoperties集合是唯一一个和IO流相结合的集合
//属于处理属性文件。key和value都是字符串类型
//存取数据：setProperty(String key, String value)和getProperty(String key)
public class Properties extends Hashtable<Object,Object>{
    
}
```

**Arrays,Collections是一个操作Set、List和Map等集合的工具类**

```java
public class Collections {
    public static void reverse(List<?> list);//反转list中元素的顺序
    public static void shuffle(List<?> list);//对list集合元素进行随机排序
    //根据元素的自然排序对指定List集合元素按升序排序
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
    //根据指定的Comparator产生的顺序对list集合元素进行排序
    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        list.sort(c);
    }
    //将list的i和j位置元素进行交换
    public static void swap(List<?> list, int i, int j);
    //根据元素的自然排序，返回给定集合中的最大元素
    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll);
    //根据comparator指定的排序，返回给定集合中的最大元素
    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp);
    //min
    int binarySearch(List<? extends Comparable<? super T>> list, T key);//在list集合中查找某个元素的下标
    //集合必须事先按照c比较器规则进行排序过的，否则结果不确定
    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c);
    public static int frequency(Collection<?> c, Object o);//返回指定集合中指定元素出现的次数
    public static <T> void copy(List<? super T> dest, List<? extends T> src);//将src中的内容复制到dest中
    public static <T> boolean replaceAll(List<T> list, T oldVal, T newVal);//使用新值替换list对象的所有旧值
    //unmodifiableXXX()方法，该方法返回指定XXX不可修改的试图
    public static <T> boolean addAll(Collection<? super T> c, T... elements);//将所有指定元素添加到指定的collection中
    //同步，提供多个synchronizedXXX()方法，该方法可使指定集合包装成线程同步集合，从而可以解决多线程并发访问集合时的线程安全问题。
}
```



# 泛型Generic

**把一个集合中的内容限制为一个特定的数据类型**

```java
public class ArrayList<E> extends A immplents B{
    
}
public interface Map<K,V>{
    
}

//这时使用的是泛型方法的泛型变量。
//与其所在类是否是泛型类没有关系。 泛型方法中的泛型参数在方法调用时确定。泛型方法可以根据需要声明为static的
修饰符 <类型变量列表> 返回值类型 方法名（[泛型标识 参数名称]）throws 异常;
public static <T> List<T> asList(T...a)
```

+ 泛型必须使用**引用数据类型**，不能使用基本数据类型，用包装类替换。
+ 在创建自定义泛型类的对象时，必须指明泛型参数列表
+ 除创建泛型类对象外，**子类继承泛型类时、实现类实现泛型接口时，也可以确定泛型结构中的泛型参数**
+ **类型推断**，ArrayList list = new ArrayList<>()
+ 如果泛型结构是一个**接口（interface）或抽象类（abstract）**，则不可创建泛型类的对象
+ **不可以使用new E[], 但是可以E[] elements = (E[])new Object[capacity]**
+ 在类/接口上声明的泛型，在本类或本接口中即代表某种类型。**但不可以在静态方法中使用类的泛型（但是可以使用方法形参的泛型），类加载时就加载静态方法，而泛型类型在对象时才加载，则该静态方法编译不通过**
+ **异常类不能是带泛型的**

## 通配符？

**List<?>是List<String>、List<Object>等各种泛型List的父类**

```java
//写操作
Collection<?> c = new ArrayList<String>();
c.add(new Object());//编译时错误
//add方法有类型参数e作为集合的元素类型。我们传给add的任何参数都必须是一个未知类型的子类。因为我们都不知道那是什么类型，所以我们无法传任何东西进去。唯一可以插入的元素是null，他是所有引用类型的默认值
//读操作,读取List<?>的对象list中的元素时，永远都是安全的，因为不管list的真实类型是什么，他包含的都是Object
method(Collection<?> coll){
    for(Object o : coll){
        System.out.println(o);
    }
}
```

```java
//有限制的通配符

<?>允许所有泛型的引用调用;
通配符指定上限<? extends 类/接口>,使用时指定的类型必须是继承某个类，或实现某个接口，即<=;
通配符指定下限<? super 类/接口>，使用时指定的类型必须是操作的类或接口，或者是操作的类的父类或接口的父接口。即>=;
  
```

---

# 数据结构与集合源码

## 二叉树

### 遍历

+ 前序遍历：根左右
+ 中序遍历：左根右
+ 后序便利：左右根

### 满二叉树

除最后一层无任何子节点外，每一层上的所有节点都有两个子节点的二叉树

<img src=".\src\满二叉树.md" alt="image-20240311213009623" style="zoom:50%;" />



---

# File类与IO流

**File类实际就是磁盘文件中的一个文件或者文件路径**

```java
public class File implements Serializable, Comparable<File> {
    //绝对路径：包括盘符；”D:\\io\\hello.txt“
    //相对路径：相较于某一个文件夹的路径 ==> 相对于module， 相对于project
    public File(URI uri);
    //parent:文件目录; child可以是一个文件也可以是路径
    public File(String parent, String child);
    public File(File parent, String child);
    
	public String getName() ：获取名称	
    public String getPath() ：获取路径
	public String getAbsolutePath()：获取绝对路径
	public File getAbsoluteFile()：获取绝对路径表示的文件
	public String getParent()：获取上层文件目录路径。若无，返回null
	public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
	public long lastModified() ;获取最后一次的修改时间，毫秒值
        
        

}
```



---

# 网络编程

2

---

# 反射机制

3

---

# 新的特性

4

# MySql

## Windows 上安装 MySQL



Windows 上安装 MySQL 相对来说会较为简单，最新版本可以在 [MySQL 下载](https://dev.mysql.com/downloads/mysql/) 中下载中查看(**更详细安装：[Windows 上安装 MySQL](https://www.runoob.com/w3cnote/windows10-mysql-installer.html)**)。

![img](https://www.runoob.com/wp-content/uploads/2014/03/330405-20160709174318905-664331194.png)

![img](https://www.runoob.com/wp-content/uploads/2014/03/20DBD7BA-A653-4AE3-887E-2A16E6EBB2E3.png)

点击 **Download** 按钮进入下载页面，点击下图中的 **No thanks, just start my download.** 就可立即下载：



![img](https://www.runoob.com/wp-content/uploads/2014/03/330405-20160709174941374-1821908969.png)

下载完后，我们将 zip 包解压到相应的目录，这里我将解压后的文件夹放在 **C:\web\mysql-8.0.11** 下。

**接下来我们需要配置下 MySQL 的配置文件**

打开刚刚解压的文件夹 **C:\web\mysql-8.0.11** ，在该文件夹下创建 **my.ini** 配置文件，编辑 **my.ini** 配置以下基本信息：

```
[client]
# 设置mysql客户端默认字符集
default-character-set=utf8
 
[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录
basedir=C:\\web\\mysql-8.0.11
# 设置 mysql数据库的数据的存放目录，MySQL 8+ 不需要以下配置，系统自己生成即可，否则有可能报错
# datadir=C:\\web\\sqldata
# 允许最大连接数
max_connections=20
# 服务端使用的字符集默认为8比特编码的latin1字符集
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
```

**接下来我们来启动下 MySQL 数据库：**

以管理员身份打开 cmd 命令行工具，切换目录：

```
cd C:\web\mysql-8.0.11\bin
```

初始化数据库：

```
mysqld --initialize --console
```

执行完成后，会输出 root 用户的初始默认密码，如：

```
...
2018-04-20T02:35:05.464644Z 5 [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: APWCY5ws&hjQ
...
```

**APWCY5ws&hjQ** 就是初始密码，后续登录需要用到，你也可以在登陆后修改密码。

输入以下安装命令：

```
mysqld install
```

启动输入以下命令即可：

```
net start mysql
```

> 注意: 在 5.7 需要初始化 data 目录：
>
> ```
> cd C:\web\mysql-8.0.11\bin 
> mysqld --initialize-insecure 
> ```
>
> 初始化后再运行 net start mysql 即可启动 mysql。

------

## 登录 MySQL

当 MySQL 服务已经运行时, 我们可以通过 MySQL 自带的客户端工具登录到 MySQL 数据库中, 首先打开命令提示符, 输入以下格式的命名:

```
mysql -h 主机名 -u 用户名 -p
```

参数说明：

- **-h** : 指定客户端所要登录的 MySQL 主机名, 登录本机(localhost 或 127.0.0.1)该参数可以省略;
- **-u** : 登录的用户名;
- **-p** : 告诉服务器将会使用一个密码来登录, 如果所要登录的用户名密码为空, 可以忽略此选项。

如果我们要登录本机的 MySQL 数据库，只需要输入以下命令即可：

```
mysql -u root -p
```

按回车确认, 如果安装正确且 MySQL 正在运行, 会得到以下响应:

```
Enter password:
```

若密码存在, 输入密码登录, 不存在则直接按回车登录。登录成功后你将会看到 Welcome to the MySQL monitor... 的提示语。

然后命令提示符会一直以 **mysql>** 加一个闪烁的光标等待命令的输入, 输入 **exit** 或 **quit** 退出登录。

## MySql操作

```mysql
mysqld --initialize-insecure; #进行安全初始化
mysqld -u root -p password # 修改所有用户的密码
mysql -u root -p #输入密码进入root用户
SHOW DATABASES; # 展现出所有数据库
EXIT;
QUIT;
USE MYDAtABASE; # 使用哪一个数据库
CREATE DATABASE 数据库名; # 创建数据库
DROP DATABASE <database_name>;        # 直接删除数据库，不检查是否存在
USE database_name; #选择某一个数据库
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    ...
); # 创建数据表
AUTO_INCREMENT,
NOT NULL
DROP TABLE table_name ;    -- 直接删除表，不检查是否存在
DROP TABLE [IF EXISTS] table_name;
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...); # 插入数据

#查询语句
SELECT column1, column2, ...
FROM table_name
[WHERE condition]
[ORDER BY column_name [ASC | DESC]]
[LIMIT number];

```

## MySQL 数据类型

MySQL 中定义数据字段的类型对你数据库的优化是非常重要的。

MySQL 支持多种类型，大致可以分为三类：数值、日期/时间和字符串(字符)类型。

------

### 数值类型

MySQL 支持所有标准 SQL 数值数据类型。

这些类型包括严格数值数据类型(INTEGER、SMALLINT、DECIMAL 和 NUMERIC)，以及近似数值数据类型(FLOAT、REAL 和 DOUBLE PRECISION)。

关键字INT是INTEGER的同义词，关键字DEC是DECIMAL的同义词。

BIT数据类型保存位字段值，并且支持 MyISAM、MEMORY、InnoDB 和 BDB表。

作为 SQL 标准的扩展，MySQL 也支持整数类型 TINYINT、MEDIUMINT 和 BIGINT。下面的表显示了需要的每个整数类型的存储和范围。

| 类型         | 大小                                     | 范围（有符号）                                               | 范围（无符号）                                               | 用途            |
| :----------- | :--------------------------------------- | :----------------------------------------------------------- | :----------------------------------------------------------- | :-------------- |
| TINYINT      | 1 Bytes                                  | (-128，127)                                                  | (0，255)                                                     | 小整数值        |
| SMALLINT     | 2 Bytes                                  | (-32 768，32 767)                                            | (0，65 535)                                                  | 大整数值        |
| MEDIUMINT    | 3 Bytes                                  | (-8 388 608，8 388 607)                                      | (0，16 777 215)                                              | 大整数值        |
| INT或INTEGER | 4 Bytes                                  | (-2 147 483 648，2 147 483 647)                              | (0，4 294 967 295)                                           | 大整数值        |
| BIGINT       | 8 Bytes                                  | (-9,223,372,036,854,775,808，9 223 372 036 854 775 807)      | (0，18 446 744 073 709 551 615)                              | 极大整数值      |
| FLOAT        | 4 Bytes                                  | (-3.402 823 466 E+38，-1.175 494 351 E-38)，0，(1.175 494 351 E-38，3.402 823 466 351 E+38) | 0，(1.175 494 351 E-38，3.402 823 466 E+38)                  | 单精度 浮点数值 |
| DOUBLE       | 8 Bytes                                  | (-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308) | 双精度 浮点数值 |
| DECIMAL      | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 | 依赖于M和D的值                                               | 依赖于M和D的值                                               | 小数值          |

------

### 日期和时间类型

表示时间值的日期和时间类型为DATETIME、DATE、TIMESTAMP、TIME和YEAR。

每个时间类型有一个有效值范围和一个"零"值，当指定不合法的MySQL不能表示的值时使用"零"值。

TIMESTAMP类型有专有的自动更新特性，将在后面描述。

| 类型      | 大小 ( bytes) | 范围                                                         | 格式                | 用途                     |
| :-------- | :------------ | :----------------------------------------------------------- | :------------------ | :----------------------- |
| DATE      | 3             | 1000-01-01/9999-12-31                                        | YYYY-MM-DD          | 日期值                   |
| TIME      | 3             | '-838:59:59'/'838:59:59'                                     | HH:MM:SS            | 时间值或持续时间         |
| YEAR      | 1             | 1901/2155                                                    | YYYY                | 年份值                   |
| DATETIME  | 8             | '1000-01-01 00:00:00' 到 '9999-12-31 23:59:59'               | YYYY-MM-DD hh:mm:ss | 混合日期和时间值         |
| TIMESTAMP | 4             | '1970-01-01 00:00:01' UTC 到 '2038-01-19 03:14:07' UTC结束时间是第 **2147483647** 秒，北京时间 **2038-1-19 11:14:07**，格林尼治时间 2038年1月19日 凌晨 03:14:07 | YYYY-MM-DD hh:mm:ss | 混合日期和时间值，时间戳 |

------

### 字符串类型

字符串类型指CHAR、VARCHAR、BINARY、VARBINARY、BLOB、TEXT、ENUM和SET。该节描述了这些类型如何工作以及如何在查询中使用这些类型。

| 类型       | 大小                  | 用途                            |
| :--------- | :-------------------- | :------------------------------ |
| CHAR       | 0-255 bytes           | 定长字符串                      |
| VARCHAR    | 0-65535 bytes         | 变长字符串                      |
| TINYBLOB   | 0-255 bytes           | 不超过 255 个字符的二进制字符串 |
| TINYTEXT   | 0-255 bytes           | 短文本字符串                    |
| BLOB       | 0-65 535 bytes        | 二进制形式的长文本数据          |
| TEXT       | 0-65 535 bytes        | 长文本数据                      |
| MEDIUMBLOB | 0-16 777 215 bytes    | 二进制形式的中等长度文本数据    |
| MEDIUMTEXT | 0-16 777 215 bytes    | 中等长度文本数据                |
| LONGBLOB   | 0-4 294 967 295 bytes | 二进制形式的极大文本数据        |
| LONGTEXT   | 0-4 294 967 295 bytes | 极大文本数据                    |

**注意**：char(n) 和 varchar(n) 中括号中 n 代表字符的个数，并不代表字节个数，比如 CHAR(30) 就可以存储 30 个字符。

CHAR 和 VARCHAR 类型类似，但它们保存和检索的方式不同。它们的最大长度和是否尾部空格被保留等方面也不同。在存储或检索过程中不进行大小写转换。

BINARY 和 VARBINARY 类似于 CHAR 和 VARCHAR，不同的是它们包含二进制字符串而不要非二进制字符串。也就是说，它们包含字节字符串而不是字符字符串。这说明它们没有字符集，并且排序和比较基于列值字节的数值值。

BLOB 是一个二进制大对象，可以容纳可变数量的数据。有 4 种 BLOB 类型：TINYBLOB、BLOB、MEDIUMBLOB 和 LONGBLOB。它们区别在于可容纳存储范围不同。

有 4 种 TEXT 类型：TINYTEXT、TEXT、MEDIUMTEXT 和 LONGTEXT。对应的这 4 种 BLOB 类型，可存储的最大长度不同，可根据实际情况选择。

------

### 枚举与集合类型（Enumeration and Set Types）

- **ENUM**: 枚举类型，用于存储单一值，可以选择一个预定义的集合。
- **SET**: 集合类型，用于存储多个值，可以选择多个预定义的集合。

------

### 空间数据类型（Spatial Data Types）

GEOMETRY, POINT, LINESTRING, POLYGON, MULTIPOINT, MULTILINESTRING, MULTIPOLYGON, GEOMETRYCOLLECTION: 用于存储空间数据（地理信息、几何图形等）。

## JDBC

[JDBC数据库驱动的下载、安装与连接_sqlserverjdbc驱动下载教程-CSDN博客](https://blog.csdn.net/pan_junbiao/article/details/86626741)

```java
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        //java.sql包中的DriverManager类有两个建立连接的类的方法（static）
        //Connection getConnection(String, string)
        //Connection getCOnnection(String)
        Connection con;
//        useSSL,有汉字：characterEncoding
        String uri = "jdbc:mysql://127.0.0.1:3306/students?user=root&password=1006&useSSL=true&characterEncoding=utf-8";
        try{
            con = DriverManager.getConnection(uri);
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            使用Statement声明一个SQL语句对象
            Statement sql = con.createStatement();
//            sql执行sql语句，并且将查询结果放在一个ResultSet类的对象中。
            ResultSet rs = sql.executeQuery("SELECT * FROM student");
            System.out.println("id"+"\t"+"name"+"\t"+"cardid"+"\t"+"classs");
            while(rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String cardid = rs.getString(3);
                String classs = rs.getString(4);
                System.out.println(id+"\t"+name+"\t"+cardid+"\t\t"+classs);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

```

