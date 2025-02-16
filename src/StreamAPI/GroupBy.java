package StreamAPI;

import java.util.Arrays;
import java.util.List;

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

	}

}
