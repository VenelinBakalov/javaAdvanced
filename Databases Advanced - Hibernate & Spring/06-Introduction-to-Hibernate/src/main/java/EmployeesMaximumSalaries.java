import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Venelin on 15.7.2017 г..
 */
public class EmployeesMaximumSalaries {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Object[]> results = em.createQuery("SELECT e.department.name, MAX(e.salary) AS max_salary FROM Employee AS e " +
                "GROUP BY e.department " +
                "HAVING MAX(e.salary) < 30000 OR MAX(e.salary) > 70000").getResultList();

        results.forEach(department -> {
            System.out.printf("%s - %s\n",
                    department[0],
                    department[1]);
        });

        /*
        Alternative solution - getting the needed departments and the printing results using Stream API

        List<Department> departments = em
                .createQuery("SELECT d FROM Department AS d INNER JOIN d.employees AS e " +
                        "GROUP BY d HAVING MAX (e.salary) < 30000 OR MAX (e.salary) > 70000")
                .getResultList();



        departments.forEach(d -> {
            System.out.printf("%s - %.2f\n",
                    d.getName(),
                    d.getEmployees()
                        .stream()
                        .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
                        .limit(1)
                        .map(Employee::getSalary)
                        .findFirst().get());
        });

                 */


        em.close();
        emf.close();
    }

//      Native query
//    SELECT d.name, MAX(e.salary) AS max
//    FROM departments as d
//    INNER JOIN employees AS e ON d.department_id = e.department_id
//    GROUP BY d.name
//    HAVING max < 30000 || max > 70000;

}
