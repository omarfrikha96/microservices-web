package com.omarfr.microservices.product.controler;

import com.omarfr.microservices.product.dto.ProductRequest;
import com.omarfr.microservices.product.dto.ProductResponse;
import com.omarfr.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
