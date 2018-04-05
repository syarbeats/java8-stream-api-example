package com.cdc.mitrais.java.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		/***********************************************************************************
		 * STREAM API JAVA 8 #Filter#
		 ***********************************************************************************/
		
		List<String> strings = Arrays.asList("ABC","","DD","BC","EFG","","JKL");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		
		List<String> filtered2 = strings.stream().filter(string -> string.equals("JKL")).collect(Collectors.toList());
		
		
		for(String data : filtered) {
			logger.info("Data:"+data);
		}
		
		System.out.println("-----------------------------------------");
		
		for(String data : filtered2) {
			logger.info("Data:"+data);
		}
		
		/***********************************************************************************
		 * STREAM API JAVA 8 #ForEach# & #Limit# & #Sorted#
		 ***********************************************************************************/
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		random.ints().limit(10).forEach(Processor::displayData);
		System.out.println("Sorted............");
		random.ints().limit(5).sorted().forEach(Processor::displayData);
		
		/***********************************************************************************
		 * STREAM API JAVA 8 #Map#
		 ***********************************************************************************/
		List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
		List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
		
		for(Integer data : squaresList) {
			logger.info("Data:"+data);
		}
		
		/***********************************************************************************
		 * STREAM API JAVA 8 #Paralel Stream#
		 ***********************************************************************************/
		int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
		System.out.println("The number of empty string is:"+count);
		System.out.println("Filtered Data:"+filtered);
		
		String filteredData = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String:"+filteredData);
		
		/***********************************************************************************
		 * STREAM API JAVA 8 #Statistic#
		 ***********************************************************************************/
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest number in List: "+ stats.getMax());
		System.out.println("Lowest number in List:"+stats.getMin());
		System.out.println("Sum of all numbers:"+ stats.getSum());
		System.out.println("Average of all numbers:"+ stats.getAverage());
		
		Optional<String> data = strings.stream().findAny();
		
		if(data.isPresent()) {
			logger.info("Data is exist...");
		}
		
		logger.info("Data is:"+data.get());
	
		Optional<String> firstData = strings.stream().findFirst();
		logger.info("The first data we have is:"+firstData.get());
	}

}