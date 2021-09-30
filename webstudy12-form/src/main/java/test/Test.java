package test;

class Person{
String name="아이유";
Person(String name){
this.name=name;
}
}
public class Test {
public static void main(String[] args) {
Person p1=new Person("장기하");
Person p2=new Person("옹성우");
p1=p2;
System.out.println(p1.name);
}
}