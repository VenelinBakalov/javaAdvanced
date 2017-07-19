import models.Customer;
import models.Product;
import models.Sale;
import models.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venelin on 18.7.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sales");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer = new Customer();
        Sale sale = new Sale();
        Product product = new Product();
        StoreLocation location = new StoreLocation();


        product.setName("Kraden telefon");
        product.setPrice(BigDecimal.valueOf(50));
        product.setQuantity(1);
        Set<Sale> sales = new HashSet<>();
        sales.add(sale);
        product.setSalesOfProduct(sales);

        location.setLocationName("Bitaka");
        location.setSalesInStore(sales);

        customer.setName("Hasan");
        customer.setCreditCardNumber("ASDfsdQWERTY");
        customer.setSalesForCustomer(sales);

        sale.setProduct(product);
        sale.setCustomer(customer);
        sale.setStoreLocation(location);
        sale.setDate(new Date());

        em.persist(product);
        em.persist(sale);
        em.persist(customer);
        em.persist(location);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
