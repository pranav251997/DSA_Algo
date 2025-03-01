package StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(1, "Alice", "HR", 60000);
		Employee e2 = new Employee(2, "Bob", "IT", 75000);
		Employee e3 = new Employee(3, "Charlie", "Finance", 80000);
		Employee e4 = new Employee(4, "David", "IT", 72000);
		Employee e5 = new Employee(5, "Eve", "HR", 65000);
		Employee e6 = new Employee(6, "Frank", "Finance", 82000);
		List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

		employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);

		System.out.println(employees.stream().filter(x -> x.getSalary() > 65000)
				.sorted(Comparator.comparing(Employee::getName)).map(Employee::getName));

		// How do you group a list of objects by an attribute in Java using streams?
		Map<String, List<Employee>> groupByDep = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(groupByDep);

		// Count the number of employees in each department.
		Map<String, Long> countPerDep = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(countPerDep);

		// Find the total salary expense per department.
		Map<String, Double> totalSalPerDep = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		System.out.println(totalSalPerDep);

		// Group employees name by department.
		Map<String, List<String>> groupByEmpNameDep = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(groupByEmpNameDep);

		// Find the average salary per department.
		Map<String, Double> avgPayPerDep = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgPayPerDep);

		// Get the highest-paid employee per department.
		Map<String, String> highestPaidEmpByDep = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
								emp -> emp.map(Employee::getName).orElse(null))));
		System.out.println(highestPaidEmpByDep);
	}

}
