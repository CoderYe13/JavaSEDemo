package cn.henuer.javase_base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author CoderYe
 * @version 2020年2月5日 下午5:35:59
 */

//使用Comparable<T>进行对象数组排序,例如Integer和Sring等类也都是实现了这个接口
class Person implements Comparable<Person>,Serializable{
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person per) {
		
		return this.age - per.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

//使用Comparator实现对象比较，此时原有对象不需要实现排序接口
class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getAge() - p2.getAge();
	}
}

public class JavaDemo8 {

	public static void main(String[] args) {
		Person[] pers = new Person[] { new Person("xiao1", 100), new Person("xiao1", 20), new Person("xiao1", 120) };
		//person对象实现Comparable接口排序
		Arrays.sort(pers);
		for (Person person : pers) {
			System.out.println(person.toString());
		}
		//使用Comparator排序
		Arrays.sort(pers,new PersonComparator());
		
		for (Person person : pers) {
			System.out.println(person.toString());
		}
	}
}
