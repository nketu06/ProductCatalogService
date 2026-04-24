package com.example.ProductCatalogService.controllers;


import com.example.ProductCatalogService.dtos.CategoryDto;
import com.example.ProductCatalogService.dtos.ProductDto;
import com.example.ProductCatalogService.models.Category;
import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.repository.ProductRepo;
import com.example.ProductCatalogService.services.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean(name = "storageProductService")
    private IProductService productService;

    @MockitoBean
    private ProductRepo productRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void Test_get_all_products_with_ok_product_service() throws Exception {

        // Arrange
        Product product = new Product();
        product.setId(1L);
        product.setTitle("title");
        product.setDescription("description");
        product.setCategory(new Category());

        when(productService.getAllProducts()).thenReturn(List.of(product));


        ProductDto productDto = new ProductDto();
        productDto.setTitle("title");
        productDto.setDescription("description");
        productDto.setId(1L);
        productDto.setCategory(new CategoryDto());

        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(productDto);

        String expectedResponse = objectMapper.writeValueAsString(productDtoList);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk()) //assert status
                .andExpect(content().string(expectedResponse)); //assert body
    }

}
