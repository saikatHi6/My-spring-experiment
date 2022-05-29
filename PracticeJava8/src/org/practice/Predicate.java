package org.practice;

@FunctionalInterface
public interface Predicate<T> {

	public boolean test(T t);

	public default Predicate<T> add(Predicate<T> p2){
		return t->test(t) && p2.test(t);
		
	}

	public static <T> Predicate<T> isEqualTo(T t) {
		// TODO Auto-generated method stub
		return s -> s.equals(t);
	}
	
}
