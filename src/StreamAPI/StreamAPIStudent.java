package StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPIStudent {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

		// Find list of students whose first name starts with alphabet A
		list.stream().filter(student -> student.getFirstName().startsWith("A")).forEach(System.out::println);

		// Above Question Just stored name on List
		list.stream().filter(s -> s.getFirstName().startsWith("A")).map(s -> s.getFirstName())
				.forEach(System.out::println);

		// Group The Student By Department Names
		Map<String, List<Student>> groupByDep = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName));
		System.out.println(groupByDep);

		// Group The Student Name By Department Names
		Map<String, List<String>> groupStudentNameByDep = list.stream().collect(Collectors.groupingBy(
				Student::getDepartmantName, Collectors.mapping(Student::getFirstName, Collectors.toList())));
		System.out.println(groupStudentNameByDep);

		// Find the total count of student using stream
		System.out.println(list.stream().collect(Collectors.counting()));

		// Find the max age of student
		list.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge))).ifPresent(System.out::println);

		// Find all departments names
		list.stream().map(student -> student.getDepartmantName()).forEach(System.out::println);

		// Find the count of student in each department
		Map<String, Long> countByDep = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
		System.out.println(countByDep);

		// Find the list of students whose age is less than 30
		list.stream().filter(student -> student.getAge() < 30).forEach(System.out::println);

		// Find the list of students whose rank is in between 50 and 100
		list.stream().filter(student -> student.getRank() >= 50).filter(student -> student.getRank() <= 100)
				.forEach(System.out::println);

		// Find the average age of male and female students
		Map<String, Double> avgAge = list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge)));
		System.out.println(avgAge);

		// Find the department who is having maximum number of students
		list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet()
				.stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

		// Find the Students who stays in Delhi and sort
		list.stream().filter(student -> student.getCity().equals("Delhi")).sorted().forEach(System.out::println);

		// Find the Students who stays in Delhi and sort them by their names
		list.stream().filter(student -> student.getCity().equals("Delhi"))
				.sorted(Comparator.comparing(Student::getFirstName)).forEach(System.out::println);

		// Find the average rank in all departments
		Map<String, Double> avgByDep = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
		System.out.println(avgByDep);

		// Find the highest rank in each department
		Map<String, Optional<Student>> higRankDep = list.stream().collect(Collectors
				.groupingBy(Student::getDepartmantName, Collectors.maxBy(Comparator.comparing(Student::getRank))));
		System.out.println(higRankDep);

		// Find the list of students and sort them by their rank
		list.stream().sorted(Comparator.comparing(Student::getRank)).forEach(System.out::println);

		// Descending Order
		list.stream().sorted(Comparator.comparing(Student::getRank).reversed()).forEach(System.out::println);

		// Find the student who has second rank
		Student student = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
		System.out.println(student);
	}

}
