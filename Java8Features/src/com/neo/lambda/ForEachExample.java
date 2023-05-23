package com.neo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachExample {
	public static void main(String[] args) {

		
		List<String> strList = Arrays.asList("wew","sdsdsdsd","achdadhj","asdasda","wew","asdasda","asdasda","asdasda");
		System.out.println(strList);
		
		strList.stream().filter(s->s.equalsIgnoreCase("wew"))
		.forEach(System.out::println);
		
		strList.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()))
		.entrySet().forEach(System.out::println);
		

		List<String> of = List.of("aaa","bbbb","ccc","yyyyy");
		of.stream().filter(f->f.length()>3).forEach(System.out::println);
		
	}
}
