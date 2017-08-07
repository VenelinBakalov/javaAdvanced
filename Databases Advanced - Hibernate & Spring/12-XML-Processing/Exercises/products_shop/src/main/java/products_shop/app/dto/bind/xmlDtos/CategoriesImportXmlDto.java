package products_shop.app.dto.bind.xmlDtos;

import products_shop.app.dto.bind.add.CategoryAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Venelin on 7.8.2017 г..
 */
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesImportXmlDto {

    @XmlElement(name = "category")
    private List<CategoryAddDto> categoryAddDtos;

    public CategoriesImportXmlDto() {
    }

    public List<CategoryAddDto> getCategoryAddDtos() {
        return categoryAddDtos;
    }

    public void setCategoryAddDtos(List<CategoryAddDto> categoryAddDtos) {
        this.categoryAddDtos = categoryAddDtos;
    }
}
