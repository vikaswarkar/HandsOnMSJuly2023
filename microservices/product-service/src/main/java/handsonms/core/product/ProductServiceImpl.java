package handsonms.core.product;

import handsonms.api.core.product.Product;
import handsonms.api.core.product.ProductService;
import handsonms.util.InvalidInputException;
import handsonms.util.NotFoundException;
import handsonms.util.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductServiceImpl implements ProductService {

    final ServiceUtil serviceUtil;

    @Autowired
    ProductServiceImpl(ServiceUtil serviceUtil){
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Product getProduct(int productId) {
        log.debug("/product return the found product for producetId:{}", productId);
        if (productId < 1 ) throw new InvalidInputException("Invalid ProductId " + productId);
        if (productId == 13) throw new NotFoundException("No product found for productId " + productId);
        return new Product(productId, "name-"+ productId, 123, serviceUtil.getServiceAddress());
    }
}
