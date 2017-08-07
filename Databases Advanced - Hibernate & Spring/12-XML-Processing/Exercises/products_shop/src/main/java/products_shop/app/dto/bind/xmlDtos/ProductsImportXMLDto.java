package products_shop.app.dto.bind.xmlDtos;

import products_shop.app.dto.bind.add.ProductAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Venelin on 7.8.2017 г..
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsImportXMLDto {

    @XmlElement(name = "product")
    private List<ProductAddDto> productAddDtos;

    public ProductsImportXMLDto() {
    }

    public List<ProductAddDto> getProductAddDtos() {
        return productAddDtos;
    }

    public void setProductAddDtos(List<ProductAddDto> productAddDtos) {
        this.productAddDtos = productAddDtos;
    }
}
