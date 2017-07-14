import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Venelin on 14.7.2017 г..
 */
public class CreateObjects {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory
                        ("PersistenceUnit");

        EntityManager em = entityManagerFactory.createEntityManager();
        Employee  manager = (Employee) em
                .createQuery("SELECT e FROM Employee AS e WHERE e.id = 1")
                .getSingleResult();

        Department training = new Department();
        training.setName("Training");
        training.setManager(manager);

        Town burgas = new Town();
        burgas.setName("Burgas");

        Address addressOne = new Address();
        addressOne.setTown(burgas);
        addressOne.setText("Hope hood");


        Address addressTwo = new Address();
        addressTwo.setTown(burgas);
        addressTwo.setText("The sea");

        Address addressThree = new Address();
        addressThree.setTown(burgas);
        addressThree.setText("LiaoLin");

        Employee gosho = new Employee();
        gosho.setFirstName("Gosho");
        gosho.setLastName("Goshev");
        gosho.setMiddleName("Braat");
        gosho.setManager(manager);
        gosho.setDepartment(training);
        gosho.setJobTitle("JavaScript Dev");
        gosho.setAddress(addressOne);
        gosho.setSalary(new BigDecimal("35000"));
        Date goshoHireDate = new Date();
        gosho.setHireDate(new Timestamp(goshoHireDate.getTime()));

        Employee pesho = new Employee();
        pesho.setFirstName("Pesho");
        pesho.setLastName("Peshev");
        pesho.setMiddleName("Peshev");
        pesho.setManager(manager);
        pesho.setDepartment(training);
        pesho.setJobTitle("Java Dev");
        pesho.setAddress(addressTwo);
        pesho.setSalary(new BigDecimal("45000"));
        Date peshoHireDate = new Date();
        pesho.setHireDate(new Timestamp(peshoHireDate.getTime()));

        Employee vankata = new Employee();
        vankata.setFirstName("Vankata");
        vankata.setLastName("Vladee");
        vankata.setMiddleName("Like a boss");
        vankata.setManager(manager);
        vankata.setDepartment(training);
        vankata.setJobTitle("Java Dev Forever");
        vankata.setAddress(addressOne);
        vankata.setSalary(new BigDecimal("350000"));
        Date vankataHireDate = new Date();
        vankata.setHireDate(new Timestamp(vankataHireDate.getTime()));

        Employee lardax = new Employee();
        lardax.setFirstName("Vencho");
        lardax.setLastName("Bakalov");
        lardax.setMiddleName("LardaX");
        lardax.setManager(manager);
        lardax.setDepartment(training);
        lardax.setJobTitle("Java Dev");
        lardax.setAddress(addressOne);
        lardax.setSalary(new BigDecimal("444000"));
        Date lardaxHireDate = new Date();
        lardax.setHireDate(new Timestamp(lardaxHireDate.getTime()));

        Employee venci = new Employee();
        venci.setFirstName("Venci");
        venci.setLastName("Ne obicha");
        venci.setMiddleName("Java");
        venci.setManager(manager);
        venci.setDepartment(training);
        venci.setJobTitle("C#!!!!");
        venci.setAddress(addressThree);
        venci.setSalary(new BigDecimal("350000"));
        Date venciHireDate = new Date();
        venci.setHireDate(new Timestamp(venciHireDate.getTime()));

        em.getTransaction().begin();

        em.persist(training);
        em.persist(burgas);
        em.persist(addressOne);
        em.persist(addressTwo);
        em.persist(addressThree);
        em.persist(manager);
        em.persist(pesho);
        em.persist(gosho);
        em.persist(vankata);
        em.persist(lardax);
        em.persist(venci);

        em.getTransaction().commit();

        em.close();
        entityManagerFactory.close();
    }
}
