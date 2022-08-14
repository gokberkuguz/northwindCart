package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.productRequests.CreateProductRequest;
import com.etiya.northwind.business.requests.productRequests.UpdateProductRequest;
import com.etiya.northwind.business.responses.pages.PageDataResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    Result add(CreateProductRequest createProductRequest);
    Result update(UpdateProductRequest updateProductRequest);
    Result delete(int productId);
    DataResult<List<ProductListResponse>> getAll();
    DataResult<ProductListResponse> getById(int productId);

    PageDataResponse<ProductListResponse> getByPage(int pageNumber, int orderAmountInPage);

    PageDataResponse<ProductListResponse> getByPageWithSorting(int pageNumber, int orderAmountInPage, String fieldName, boolean isAsc);

    Product findById(int productId);

}
