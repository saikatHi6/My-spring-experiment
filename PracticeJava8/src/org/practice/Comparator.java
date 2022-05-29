package org.practice;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

	public int compare(T t1,T t2);
	
	static <U> Comparator<U> comparing(Function<U, Comparable> f){
		return (s1,s2)-> f.apply(s1).compareTo(s2);
	}

	public default Comparator<T> thenComparing(Comparator<T> comLastName) {
		return (s1,s2) -> compare(s1, s2) ==0 ? comLastName.compare(s1, s2):compare(s1, s2); 
	}

	public default  Comparator<T> thenComparing(Function<T, Comparable> f){
		Comparator<T> comp = comparing(f);
		return thenComparing(comp); 
	}
}
