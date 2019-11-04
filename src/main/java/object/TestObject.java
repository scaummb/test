package object;

import java.util.Objects;

/**
 * REMARK
 * 1) ==以及Object类的equals方法默认都是根据对象的哈希值判断两个对象是否相等。
 *          equals:可通过覆盖Object的equals方法来重写比较规则。
 *          ==：比较两个对象的首地址
 *
 * 2)  Object类的toString方法默认返回的内容是“对象所属的类名+@+对象的哈希值(十六进制)。
 *
 *
 * @author: mmb
 * @date: 19-11-4
 */
public class TestObject {
    public static void main(String[] args) {
        Person	p1	=	new	Person(20);
        Person	p2	=	new	Person(20);
        Person	p3	=	p1;

        Demo d = new Demo();

        System.	out.println(p1	==	p2);//false
        System.	out.println(p1.equals(p2));//false
        System.	out.println(p1.equals(p3));//true
        System.	out.println(p1.equals(d));//false


        Objects.equals(p1,p3);

    }

}
class Person{
    private	int	age	;
    Person(int	age){
        this.age	=	age;
    }

    //比较Person的年龄,是否是同龄人
    //一般都会覆盖此方法,根据对象的特有内容,建立判断对象是否相同的依据。
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Person))
            throw new ClassCastException("类型错误");
        Person p = (Person)obj;
        return	this.age ==	p.age;
    }

}

class Demo{
}