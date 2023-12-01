package com.jio.platform.u202124304.inventory.interfaces.rest;

import com.jio.platform.u202124304.inventory.domain.model.queries.GetProductByIdQuery;
import com.jio.platform.u202124304.inventory.domain.services.ProductCommandService;
import com.jio.platform.u202124304.inventory.domain.services.ProductQueryService;
import com.jio.platform.u202124304.inventory.interfaces.rest.resources.CreateProductResource;
import com.jio.platform.u202124304.inventory.interfaces.rest.resources.ProductResource;
import com.jio.platform.u202124304.inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import com.jio.platform.u202124304.inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/products", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Products ", description = "Products Management Endpoints")
public class ProductsController {

    public final ProductQueryService productQueryService;
    public final ProductCommandService productCommandService;

    public ProductsController(ProductQueryService productQueryService, ProductCommandService productCommandService) {
        this.productQueryService = productQueryService;
        this.productCommandService = productCommandService;
    }

    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource createProductResource) {
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(createProductResource);
        var productId = productCommandService.createProduct(createProductCommand);
        if (productId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.getProductById(getProductByIdQuery);
        if (product.isEmpty()) return ResponseEntity.badRequest().build();
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long productId) {
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.getProductById(getProductByIdQuery);
        if (product.isEmpty()) return ResponseEntity.badRequest().build();
        var courseResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(courseResource);
    }
}
