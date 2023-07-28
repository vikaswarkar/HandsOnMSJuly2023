package handsonms.api.core.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    @GetMapping("/product/{productId}")
    Product getProduct(@PathVariable("productId") int productId);
}
