package com.co.istad.piseth.spring_web_mvc.mapper;

import com.co.istad.piseth.spring_web_mvc.domain.Category;
import com.co.istad.piseth.spring_web_mvc.domain.Product;
import com.co.istad.piseth.spring_web_mvc.dto.PatchProductRequest;
import com.co.istad.piseth.spring_web_mvc.dto.ProductResponse;
import com.co.istad.piseth.spring_web_mvc.dto.UpdateProductRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "available", target = "isAvailable")
    @Mapping(source = "category.name", target = "categoryName")
    ProductResponse toProductResponse(Product product);

    @BeanMapping(ignoreByDefault = true)
//    @Mapping(target = "category", source = "category")
//    @Mapping(target = "code", ignore = true)
//    @Mapping(target = "available", ignore = true)
    void updateProductRequestToProduct(UpdateProductRequest request, @MappingTarget Product product, Category category);

    @BeanMapping(ignoreByDefault = true, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", source = "request.name")
    void patchProductRequestToProduct(PatchProductRequest request, @MappingTarget Product product, Category category);
}
