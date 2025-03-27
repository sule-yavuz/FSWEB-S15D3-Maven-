
package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("After Removing Duplicates: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Integer> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee emp : employees) {
            if (emp != null && !seen.add(emp.getId())) {
                duplicates.add(emp);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        for (Employee emp : employees) {
            if (emp != null) {
                if (!seen.add(emp.getId())) {
                    uniqueMap.remove(emp.getId());
                } else {
                    uniqueMap.put(emp.getId(), emp);
                }
            }
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> uniqueList = new LinkedList<>();

        for (Employee emp : employees) {
            if (emp != null) {
                countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
            }
        }

        for (Employee emp : employees) {
            if (emp != null && countMap.get(emp.getId()) == 1) {
                uniqueList.add(emp);
            }
        }
        return uniqueList;
    }
}
