package StreamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodingWithVighnesh {

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;

		return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(i -> num % i == 0);
//		for (int i = 2; i <= Math.sqrt(num); i++) {
//			if (num % i == 0) {
//				return false;
//			}
//
//		}
//		return true;
	}

	public static int countVowel(String str) {
		return (int) str.chars().mapToObj(x -> (char) x).filter(x -> "aeiouAEIOU".indexOf(x) != -1).count();
	}

	public static void main(String[] args) {
		List<String> res = Arrays.asList("am", "pm", "cm", "am", "pm");

		res.stream().distinct().forEach(System.out::println);
		res.stream().collect(Collectors.toSet()).forEach(System.out::println);

		List<Integer> res2 = Arrays.asList(1, 2, 32, 12, 15, 45, 67, 19);
		res2.stream().filter(num -> num.toString().startsWith("1")).forEach(System.out::println);

		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = Arrays.asList(4, 5, 6);

		List<Integer> res3 = Stream.concat(l1.stream(), l2.stream()).sorted(Comparator.reverseOrder()).toList();

		List<Integer> res4 = Arrays.asList(4, 6, 8, 9, 11, 15, 16);

		res4.stream().map(x -> CodingWithVighnesh.isPrime(x)).forEach(System.out::println);

		List<String> res5 = Arrays.asList("1am", "pm", "2cm", "3am");

		res5.stream().filter(str -> !str.isEmpty() && Character.isDigit(str.charAt(0))).forEach(System.out::println);

		String res6 = "pranap";

		boolean op = IntStream.rangeClosed(0, res6.length() / 2)
				.allMatch(i -> res6.charAt(i) == res6.charAt(res6.length() - 1 - i));
		System.out.println(op);

		List<Integer> res7 = Arrays.asList(1, 2, 32, 12, 15, 45, 67, 19);

		res7.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		List<Integer> res8 = Arrays.asList(4, 5, 6, 3, 1, 2, 7);
		int n = 3;

		int op1 = res8.stream().sorted().skip(n - 1).findFirst().orElse(-1);
		System.out.println(op1);

		int[] res9 = { 4, 5, 6, 3, 1, 2, 7 };
		Arrays.stream(res9).sorted().skip(n - 1).findFirst().ifPresent(System.out::println);

		// Arrays.stream(res9).skip(arr.length -
		// 1).findFirst().ifPresent(System.out::println);

		List<String> res11 = Arrays.asList("am", "pm", "cm", "am");
		res11.stream().map(x -> "[" + x + "]").forEach(System.out::println);

		System.out.println(res11.stream().collect(Collectors.joining(",", "[", "]")));

		List<Integer> res13 = Arrays.asList(4, 5, 6, 3, 1, 2, 7);

		System.out.println(res13.stream().limit(2).mapToInt(Integer::intValue).sum());

		System.out.println(res13.stream().limit(2).mapToInt(Integer::intValue).reduce((x, y) -> x * y).orElse(-1));

		List<Integer> res15 = Arrays.asList(1, 2, 3, 1, 1, 1, 2, 2, 2, 3, 3, 3);

		System.out.println(res15.stream().distinct().mapToInt(Integer::intValue).sum());

		String res16 = "I am an apple and Orange on table";
		int k = 2;
		Arrays.stream(res16.split(" ")).filter(x -> CodingWithVighnesh.countVowel(x) >= k).forEach(System.out::println);

		String res17 = "soiss";
		res17.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(ma -> ma.getValue() == 1).map(ma -> ma.getKey()).findFirst().ifPresent(System.out::println);

		List<Integer> res18 = Arrays.asList(1, 2, 3, 1, 1, 1, 2, 2, 2, 3, 3, 3);
		res18.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

		res18.stream().min(Comparator.naturalOrder()).ifPresent(System.out::println);

		res18.stream().mapToInt(Integer::intValue).average().ifPresent(System.out::println);

		System.out.println(res18.stream().mapToInt(Integer::intValue).sum());

		System.out.println(res18.stream().mapToInt(Integer::intValue).count());

		IntSummaryStatistics stats = res18.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println("Max - " + stats.getMax());
		System.out.println("Min - " + stats.getMin());
		System.out.println("AVG - " + stats.getAverage());
		System.out.println("Count - " + stats.getCount());
		System.out.println("Sum - " + stats.getSum());

		List<String> res19 = Arrays.asList("a", "abcdefg", "ab", "abc", "abcde");
		res19.stream().sorted(Comparator.comparingInt(String::length).reversed()).skip(2).findFirst()
				.ifPresent(System.out::println);

		List<Integer> res20 = Arrays.asList(4, 5, 6, 3, 1, 2, 7);
		boolean opo = res20.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting())).entrySet()
				.stream().anyMatch(entry -> entry.getValue() == 2);
		System.out.println(opo);

		String res21 = "Pranav";
		res21.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(ch -> ch, Collectors.counting())).entrySet()
				.stream().forEach(System.out::println);

		List<Integer> res22 = Arrays.asList(4, 6, 3, 1, 2, 7);
		res22.stream().filter(num -> num % 2 != 0).findFirst().ifPresent(System.out::println);

		List<Integer> res23 = Arrays.asList(4, 6, 3, 1, 2, 7);
		List<Integer> res24 = Arrays.asList(42, 44, 3, 1, 22, 72);
		res23.stream().filter(num -> res24.contains(num)).forEach(System.out::println);

		Employee emp1 = new Employee(1701, "Alice", "HR", 5);
		Employee emp2 = new Employee(12, "Bob", "IT", 5);
		Employee emp3 = new Employee(1034, "Charlie", "Finance", 5);
		Employee emp4 = new Employee(1804, "Diana", "Marketing", 5);
		Employee emp5 = new Employee(105, "Ethan", "IT", 5);

		List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5);

		employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary,
						Collectors.mapping(Employee::getName, Collectors.toList())))
				.entrySet().stream().forEach(enty -> System.out.println(enty.getKey() + " " + enty.getValue()));

		List<Integer> res25 = Arrays.asList(4, 6, 3, 1, 2, 7);
		res25.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0)).entrySet().stream()
				.forEach(enty -> System.out.println(enty.getKey() + " " + enty.getValue()));

		DoubleSummaryStatistics summary = employees.stream().mapToDouble(Employee::getSalary).summaryStatistics();

		System.out.println(summary.getAverage());

		employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
		System.out.println();
		employees.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).forEach(System.out::println);

		List<String> res26 = Arrays.asList("am", "pm", "cm", "am", "pm");

		res26.stream().collect(Collectors.groupingBy(ch -> ch, Collectors.counting())).entrySet().stream()
				.forEach(System.out::println);

	}

}
