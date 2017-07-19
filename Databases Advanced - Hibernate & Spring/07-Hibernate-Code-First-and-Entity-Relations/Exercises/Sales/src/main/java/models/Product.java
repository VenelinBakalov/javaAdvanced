package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Venelin on 18.7.2017 г..
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private int quantity;

    @Basic(optional = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "product", targetEntity = Sale.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sale> salesOfProduct;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Sale> getSalesOfProduct() {
        return salesOfProduct;
    }

    public void setSalesOfProduct(Set<Sale> salesOfProduct) {
        this.salesOfProduct = salesOfProduct;
    }
}
