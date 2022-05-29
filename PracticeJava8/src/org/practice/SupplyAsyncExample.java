package org.practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SupplyAsyncExample {

	public static void main(String[] args) {
		
		String bkplist = "$list[0]";
		List<String> cities = Arrays.asList(
                "Milan.com", 
                "London.com", 
                "New York.com", 
                "San Francisco.com");
		String citiesCommaSeparated = cities.stream()
                .map(c->c.substring(0, c.indexOf(".")))
                .collect(Collectors.joining(","));
		System.out.println(citiesCommaSeparated);
		
		for (int i = 0; i < 2; ) {
			System.out.println(bkplist);
			++i;
			bkplist = "$list["+i+"]";
			System.out.println("=================================================");
		}
		System.out.println("=================================================");
		
		
		String user = "ExchDag1DB1User2";
		
		System.out.println(user.lastIndexOf("User"));
		
		System.out.println(user.substring(0,user.lastIndexOf("User")+4));
		
		
		IntStream.range(0, 10).parallel().forEach(element->{
			CompletableFuture.supplyAsync(()-> getDataById(element)).thenApplyAsync(data -> sendData(data))
			
			.join();
		});
		
		
		
        
        
        System.out.println("=================================================");
    }
    private static String getDataById(int id) {
	System.out.println("getDataById: "+ Thread.currentThread().getName());
	
	return "Data:"+ id;
    }
    private static String sendData(String data) {
	System.out.println("sendData: "+ Thread.currentThread().getName());
	/*
	 * if(data.contains("5") || data.contains("8")) throw new
	 * RuntimeException("Not Handale");
	 */
	try {
		System.out.println(data);
		throw new RuntimeException();
	} catch (Exception e) {
		e.printStackTrace();
		return data;
	}
	finally {
		System.out.println("Garbage");
	}
    }    
	
	
}
