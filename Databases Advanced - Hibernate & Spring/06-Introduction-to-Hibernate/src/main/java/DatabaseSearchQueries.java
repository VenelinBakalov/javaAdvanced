import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class DatabaseSearchQueries {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        firstTaskPrintAddresses(em);
        secondTaskPrintEmployeeInfo(em);
        thirdTaskFindEmployeesWithProjectsBetweenDate(em);
        fourthTaskFindDepartments(em);

        em.close();
        emf.close();
    }

    @SuppressWarnings("unchecked")
    private static void fourthTaskFindDepartments(EntityManager em) {
        List<Department> departments = em
                .createQuery("SELECT d from Department AS d WHERE d.employees.size > 5 " +
                        "ORDER BY d.employees.size ASC ").getResultList();

        System.out.println(departments.size());

        departments.forEach(department -> {
            System.out.printf("--%s - Manager: %s, Employees: %d\n%s\n",
                    department.getName(),
                    department.getManager().getLastName(),
                    department.getEmployees().size(),
                    department.getEmployees().stream().map(e -> String.format("***** %s %s, Hired: %s, Job title: %s",
                            e.getFirstName(), e.getLastName(), e.getHireDate(), e.getJobTitle()))
                        .collect(Collectors.joining("\n")));
        });
    }

    @SuppressWarnings("unchecked")
    private static void thirdTaskFindEmployeesWithProjectsBetweenDate(EntityManager em) {
        List<Integer> projectIds = em.createQuery("SELECT p.id FROM Project AS p " +
                "WHERE DATE_FORMAT(p.startDate, '%Y') between 2001 and 2003")
                .getResultList();

        Query employeesQuery = em.createQuery("SELECT e FROM Employee AS e " +
                "INNER JOIN e.projects AS p " +
                "WHERE p.id IN (:ids)");

        employeesQuery.setParameter("ids", projectIds);

        List<Employee> employees = employeesQuery.getResultList();

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s, Manager: %s %nProjects:%n%s",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getManager() == null ?
                            "no manager" : employee.getManager().getFirstName() + " " + employee.getManager().getLastName(),
                    employee.getProjects().stream().map(p -> String.format("--- Name: %s, Start date: %s, End date: %s",
                                                                 p.getName(),
                                                                 p.getStartDate(),
                                                                 p.getEndDate()))
                            .collect(Collectors.joining("\n"))));

        }
    }

    private static void secondTaskPrintEmployeeInfo(EntityManager em) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int employeeId = Integer.parseInt(reader.readLine());

        Employee employee = (Employee) em.createQuery("SELECT e FROM Employee AS e WHERE e.id = " + employeeId).getSingleResult();
        System.out.println(String.format("%s %s - %s, Projects: %s.",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                String.join(", ", employee.getProjects().stream()
                        .map(Project::getName)
                        .sorted()
                        .collect(Collectors.toList()))));
    }

    @SuppressWarnings("unchecked")
    private static void firstTaskPrintAddresses(EntityManager em) {
        List<Address> addresses = em
                .createQuery("SELECT DISTINCT a FROM Address AS a " +
                        "ORDER BY a.employees.size DESC , a.town.name ASC ")
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.println(String.format("%s, %s - %d employees",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size()));
        }
    }
}
