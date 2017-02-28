package bg.companyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class test {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, TreeSet<Employee>> map = new HashMap<>();
		HashMap<String, Double> departmentWithSalary = new HashMap<>();

		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			String[] params = reader.readLine().split(" ");
			String name = params[0];
			double salary = Double.parseDouble(params[1]);
			String position = params[2];
			String department = params[3];
			Employee empl = null;
			if (params.length == 4) {
				empl = new Employee(name, salary, position, department);
			} else if (params.length == 5) {
				if (isNumber(params[4])) {
					empl = new Employee(name, salary, position, department, params[4]);
				} else {
					empl = new Employee(name, salary, position, department, params[4]);
				}
			} else {
				empl = new Employee(name, salary, position, department, params[4], Integer.parseInt(params[5]));
			}
			if (!map.containsKey(department)) {
				map.put(department, new TreeSet<>());
				departmentWithSalary.put(department, 0.0);
			}
			map.get(department).add(empl);
			departmentWithSalary.put(department, departmentWithSalary.get(department) + salary);

		}

		Map.Entry<String, TreeSet<Employee>> best = map.entrySet().stream().sorted((e1, e2) -> Double
				.compare(departmentWithSalary.get(e2.getKey()), departmentWithSalary.get(e1.getKey()))).findFirst().get();
		System.out.printf("Highest Average Salary: %s \n",best.getKey());
		for(Employee s:best.getValue()){
			System.out.println(s);
			
		}
	}

	private static boolean isNumber(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
