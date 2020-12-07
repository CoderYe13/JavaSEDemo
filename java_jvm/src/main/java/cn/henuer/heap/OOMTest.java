package cn.henuer.heap;

import java.util.ArrayList;

public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Person> list=new ArrayList<>();
        while (true){
            list.add(new Person());
        }
    }
}

class Person{
    int age=0;
    String name="hello";

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
