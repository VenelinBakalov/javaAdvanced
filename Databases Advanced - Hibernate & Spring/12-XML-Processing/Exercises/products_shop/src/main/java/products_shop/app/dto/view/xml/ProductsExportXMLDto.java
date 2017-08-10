package products_shop.app.dto.view.xml;

import products_shop.app.dto.view.ProductViewDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Venelin on 9.8.2017 г..
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsExportXMLDto {

    @XmlElement(name = "product")
    private List<ProductViewDto> productViewDtos;

    public ProductsExportXMLDto() {
    }

    public List<ProductViewDto> getProductViewDtos() {
        return productViewDtos;
    }

    public void setProductViewDtos(List<ProductViewDto> productViewDtos) {
        this.productViewDtos = productViewDtos;
    }
}
