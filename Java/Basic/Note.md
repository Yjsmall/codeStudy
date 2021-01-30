##反射
###什么是反射机制
反射机制：可以操作字节码文件
作用：可以让程序更加灵活
###反射机制相关类
java.lang.Class

在这个包下java.lang.reflect.*

java.lang.reflect.Method

java.lang.reflect.Constructor

java.lang.reflect.Field
####无参构造方法实例化对象
~~~
Class.forName("完整包名+类名").newInstance 
~~~
一定要无参构造，newInstance要调用无参构造方法
###执行一个类中的"static code"
~~~
Class.forName("");
~~~
###关于路径
~~~
String path = Thread.currentThread.getContextClassLoder().getResource("相对路径，但是从src下面开始找，跨平台").getPath();
~~~
获取一个文件的绝对路径
该文件(要写后缀名字）应该放在类路径下，就是src下面.
src是类的跟路径,跨平台可以使用code
---
直接以流的形式放回
~~~
InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("路径");
~~~
###绑定资源文件
ResourceBundle bundle = ResourceBundle.getBundle("文件路径");
String value = bundle.getString(key);
##注解
###介绍
注解：Annotation
注解是一直用引用数据类型，编译之后是xxx.class文件
语法：[修饰符列表] @interface 注解类型名{}
---
位置：class,field,method,annotation,....(AnnoTest01)

###注解的作用


###内置注解
java.lang

**Override**(AnnoTest02)
表示一个方法声明打算重写超类的另一方法声明
1. 只能重写方法
2. 这个注解是给编译器参考，和运行阶段没有关系
3. java中带有这个注解，编译器会编译检查，如果没有重写父类方法，编译器就会报错(给编译器看的)

**Deprecated**
表示x已经过时

**SuppressWarnings**

###元注解
解释：用来注解的注解是元注解
类型：
* Target
* Retention

> Target

Target修饰的注解可以出现的位置
~~~
@Target(ElementType.METHOD)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
~~~
表示Target所修饰的注解只能作用在方法上
作用范围

Target里面只有个一个 ElementType[] value（）；
ElementType[]是一个枚举类型的数组

>Retention

表示这个注解存在的位置,最终存在哪里
~~~
@Retention(RetentionPolicy.SOURCE):保留java源文件
@Retention(RetentionPolicy.CLASS):保存class文件
@Retention(RetentionPolicy.RUNTIME):保存class，可以反射机制读取
~~~
###自定义注解
属性类型：int String
###


