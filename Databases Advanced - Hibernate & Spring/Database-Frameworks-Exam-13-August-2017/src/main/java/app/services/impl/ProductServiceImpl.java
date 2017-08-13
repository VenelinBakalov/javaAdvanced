package app.services.impl;

import app.constants.ResultMessages;
import app.dto.products.ProductImportXmlDto;
import app.entities.Branch;
import app.entities.Product;
import app.repositories.BranchRepository;
import app.repositories.ProductRepository;
import app.services.api.ProductService;
import app.utils.DTOConverter;
import app.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public String add(ProductImportXmlDto productImportXmlDto) {
        Product product = DTOConverter.convert(productImportXmlDto, Product.class);

        Branch branch = this.branchRepository.findByName(productImportXmlDto.getBranch());
        product.setBranch(branch);

        String result;
        if (DataValidator.isValid(product)) {
            this.productRepository.save(product);
            result = String.format(ResultMessages.SUCCESSFUL,
                    product.getClass().getSimpleName(),
                    product);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public List<Product> findByBranch(Branch branch) {
        return this.productRepository.findByBranch(branch);
    }
}
