package bg.softuni.provider.data;

import bg.softuni.framework.lifecycle.component.Component;
import bg.softuni.model.product.Product;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 9.4.2017 г..
 */
@Component
public class ShopDatabase implements DataProvider {

    private Map<Integer, Product> productsById;

    public ShopDatabase() {
        this.productsById = new LinkedHashMap<>();
    }

    @Override
    public Product addProduct(int size, String name, String type) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int id = this.productsById.size() + 1;
        Product product = (Product) this.getClassByAbstractType(Product.class, type)
        .getConstructors()[0]
        .newInstance(new Object[] { id, size, name});

        this.productsById.put(
                id,
                product
        );

        return product;
    }

    @Override
    public Product getProductById(int id) {
        return this.productsById.getOrDefault(id, null);
    }

    private Class getClassByAbstractType(Class abstractType, String toType) throws ClassNotFoundException {
        String fullQualifiedName = abstractType.getName();
        String simpleName = abstractType.getSimpleName();
        String resultName =
                fullQualifiedName.replace("." + simpleName, "." + toType);

        return Class.forName(resultName);
    }
}
