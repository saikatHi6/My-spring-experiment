package org.practice;

import java.util.function.Function;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Comparator.comparing(s->s.getAge());
		//Comparator.comparing(s->s.getfName());
		
		
		Function<Student, Integer> fn = s -> s.getAge();
		Comparator<Student> comLastName = Comparator.comparing(Student::getlName);
		Comparator<Student> comAge = Comparator.comparing(Student::getAge);
		comAge.thenComparing(comLastName);
		Comparator.comparing(Student::getAge).thenComparing(Student::getfName).thenComparing(Student::getlName);
	
		System.out.println("==============================================");
		
		Predicate<String> p1 = s -> s.length()<20;
		Predicate<String> p2 = s -> s.length()>5;
		
		System.out.print(p1.test("Hello world I am not under your observation"));
	
		Predicate<String> p3 = p1.add(p2);
		
		System.out.println(p3.test("I am in test class"));
		
		Predicate<String> p4 = Predicate.isEqualTo("Yes");
	}

}
