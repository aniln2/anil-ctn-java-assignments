package com.emids.ctn.java8.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxOccuranceElement {

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * List<Integer> numList= Arrays.asList(11,22,33,11,44,11); Map<Integer,
	 * Integer> intMap= new HashMap<>();
	 * 
	 * for(int i=0; i< numList.size();i++) { if(intMap.containsKey(numList.get(i))){
	 * intMap.put(numList.get(i),i+1); }else { intMap.put(numList.get(i), 1); } }
	 * System.out.println(intMap); }
	 */
	/*
	 * public static <String> Map<String, Long> frequencyMap(Stream<String>
	 * elements) { return elements.collect( Collectors.groupingBy(
	 * Function.identity(), HashMap::new, // can be skipped Collectors.counting() )
	 * ); }
	 * 
	 * public static void frequencyMapInt(List<Integer> elements) {
	 * System.out.println(elements.stream().collect( Collectors.groupingBy(
	 * Function.identity(), HashMap::new, // can be skipped Collectors.counting() )
	 * )); }
	 * 
	 * public static void main( String args[] ) { List<String> words =
	 * Arrays.asList("hello", "hello", "mighty");
	 * System.out.println(frequencyMap(words.stream())); List<Integer> numList=
	 * Arrays.asList(11,22,33,11,44,11); frequencyMapInt(numList);
	 * //System.out.println(frequencyMapInt(numList.stream())); }
	 */
	  public static void MaxRepeatingElement(int [] arrA){
	        int maxCounter = 0;
	        int element=0;
	        for (int i = 0; i <arrA.length ; i++) {
	            int counter =1;
	            for (int j = i+1; j <arrA.length ; j++) {
	                if(arrA[i]==arrA[j]){
	                    counter++;
	                }
	            }
	            if(maxCounter<counter){
	                maxCounter=counter;
	                element = arrA[i];
	            }
	        }
	        System.out.println("Element repeating maximum no of times: " + element + ", maximum count: " + maxCounter);
	    }

	    public static void main(String[] args) {
	     int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
	     //MaxRepeatingBruteForce m = new MaxRepeatingBruteForce();
	     MaxRepeatingElement(arrA);
	    }

}
