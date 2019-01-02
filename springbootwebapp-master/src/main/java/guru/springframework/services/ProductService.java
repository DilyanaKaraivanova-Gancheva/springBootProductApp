package guru.springframework.services;


import guru.springframework.domain.Product;
import org.apache.coyote.http2.Stream;

import java.nio.file.Path;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    Iterable<Product> deleteProductById(Integer id);
//    String getImageEncoded(Product product);
}
