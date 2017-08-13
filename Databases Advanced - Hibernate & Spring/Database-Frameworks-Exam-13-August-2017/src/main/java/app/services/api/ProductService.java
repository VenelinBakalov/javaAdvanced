package app.services.api;

import app.dto.products.ProductImportXmlDto;
import app.entities.Branch;
import app.entities.Product;

import java.util.List;

public interface ProductService {

    String add(ProductImportXmlDto productImportXmlDto);
    List<Product> findByBranch(Branch branch);

}
