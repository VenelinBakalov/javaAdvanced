package products_shop.app.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewDto {
    @Expose
    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @XmlAttribute(name = "price")
    private BigDecimal price;

    @Expose
    @SerializedName("seller")
    private String sellerFullName;

    @XmlElement(name = "date")
    private Date date;

    public ProductViewDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public void setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
