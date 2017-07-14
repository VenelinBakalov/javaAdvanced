import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Venelin on 14.7.2017 г..
 */
@SuppressWarnings("unchecked")
public class EmployeeQueries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<String> employeesNames = em
                .createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary > 50000").getResultList();

        employeesNames.forEach(System.out::println);

        // ORDER with query
        List<Employee> employees = em.createQuery("SELECT e FROM Employee AS e WHERE e.department.name = 'Research and Development'" +
                "ORDER BY e.salary ASC , e.firstName DESC ").getResultList();

        // ORDER with good old stream
//        employees = employees.stream().sorted((e1, e2) -> {
//            int result = e1.getSalary().compareTo(e2.getSalary());
//            if (result == 0) {
//                result = e2.getFirstName().compareTo(e1.getFirstName());
//            }
//            return result;
//        }).collect(Collectors.toList());

        for (Employee employee : employees) {
            System.out.println(String.format("%s %s from %s - $%.2f",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary()));
        }

        em.close();
        emf.close();
    }
}
