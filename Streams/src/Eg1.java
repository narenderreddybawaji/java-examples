import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Eg1 {

	public static void main(String[] args) {
		System.out.println("=============== For Each(Final) ===================");
		List<Employee> employeeList = getEmpList();
		Consumer<Employee> consumer = res -> System.out.println(res);
		employeeList.stream().forEach(consumer);
		System.out.println("\n=============== Filter(Intermediary/lazy) ===================");
		Predicate<Employee> predicate = employee -> employee.getAge() > 30;
		employeeList.stream().filter(predicate).forEach(consumer);
		System.out.println("\n=============== Map(Intermediary/lazy) ===================");
		employeeList.stream().map(Employee::getSalary).forEach(System.out::println);
		// employee -> employee.getSalary() and Employee::getSalary are same
		System.out.println("\n=============== Map(Intermediary/lazy) and Reduce(Final) ===================");
		Integer ageSum = employeeList.stream().map(employee -> employee.getAge()).reduce(0,
				(age1, age2) -> age1 + age2);

		//List<String> list = employeeList.stream().map(res -> fetchName(res.getEmpName())).collect(Collectors.toList());

		String name = "kapil bhatnagar";
		long count = name.chars().filter(res -> res == 'a').count();

		Map<String, Double> map = employeeList.stream()
				.collect(Collectors.toMap(Employee::getEmpName, Employee::getSalary));
		Map<String, Employee> map2 = employeeList.stream()
				.collect(Collectors.toMap(res -> res.getEmpName(), res -> res, (o, n) -> n));
		// If don't provide third param, then exception will occur in case of
		// duplicate key.
		// This can be resolve by either (o, n) -> n or (o, n) -> o. (o, n) -> n
		// means to consider new value and vice versa for (o, n) -> o

		System.out.println(ageSum);
		
		
		System.out.println("*********************************");
		List<String> list = employeeList.stream().map(res -> fetchSalHigher(res.getEmpName()))
				.collect(Collectors.toList());
		list.forEach(System.out::println);
	}

	private static List<Employee> getEmpList() {
		Employee emp1 = new Employee(1, "ABC1", 50000, 25);
		Employee emp2 = new Employee(2, "ABC2", 10000, 27);
		Employee emp3 = new Employee(3, "ABC3", 40000, 40);
		Employee emp4 = new Employee(4, "ABC4", 70000, 35);

		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);

		return empList;
	}
	
	private static String fetchSalHigher(String v){
		return v;
	}

}
