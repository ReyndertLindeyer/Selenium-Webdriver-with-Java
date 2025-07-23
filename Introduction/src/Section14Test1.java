import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.*;

public class Section14Test1 {
	
	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");

		int count = 0;
		
		for(int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			
			if(actual.startsWith("A")) {
				count++;
			}
		}
		
		System.out.println(count);
	}

	@Test
	public void streamFilter() {
		//Taking an arraylist and turning it into a Stream
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		
		//long count = names.stream().filter(s->s.startsWith("A")).count();
		
		
		/*
		 * There is no life for intermediate operation if there is no terminal operation
		 * Terminal operation will execute only if intermediate operation (filter) returns true
		 * We can create a stream with streampackage
		 * How to use filter in Stream API
		 */
		
		//long count = Stream.of("Abhijeet", "Don","Alekhya","Adam","Ram").filter(s->s.startsWith("A")).count();
		
		//Expressions can also happen over multiple lines
		long count = Stream.of("Abhijeet", "Don","Alekhya","Adam","Ram").filter(s->
			{
				s.startsWith("A");
				//Operation should return true, but we can force a true or false with the following line
				return true;
			}
		).count();
		
		System.out.println(count);
		
		//Print all the names of ArrayList
		
		//Print only ones where the length of the string is greater than 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//Only get first item in the list of strings with a length greater than 4
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}

	@Test
	public void streamMap() {
		//Print the names which have their last number as 'a' with upper case
		Stream.of("Abhijeet", "Don","Alekhya","Adam","Ram").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Print names that start with 'A' as an upper case and sorted
		Stream.of("Abhijeet", "Don","Alekhya","Adam","Ram").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		//Concatination
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Abhijeet");
		names1.add("Don");
		names1.add("Alekhya");
		names1.add("Adam");
		names1.add("Ram");
		
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Abhijeet");
		names2.add("Don");
		names2.add("Alekhya");
		names2.add("Adam");
		names2.add("Ram");
		
		Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
		
		//Removing this since if you ever do anything with a stream you can't use it again
		//newStream.forEach(s->System.out.println(s));
		
		Boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("adam"));
		
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Abhijeet", "Don","Alekhya","Adam","Ram").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());

		System.out.println("First person who's name ends with an A:");
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3, 2, 2, 7, 4, 1, 9, 7);
		//print unique number from this array
		//sort the array - 3rd index 1,2,3,5,7,9

		System.out.println("Unique numbers:");
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());

		System.out.println("Sorted array 3rd index:");
		System.out.println(li.get(2));
		
		
	}
	
}
