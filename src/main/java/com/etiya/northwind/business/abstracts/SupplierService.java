package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.supplierRequests.CreateSupplierRequest;
import com.etiya.northwind.business.requests.supplierRequests.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.pages.PageDataResponse;
import com.etiya.northwind.business.responses.pages.PageParameterResponseSorting;
import com.etiya.northwind.business.responses.pages.PageParametersResponse;
import com.etiya.northwind.business.responses.pages.TempPageDataResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface SupplierService {
    Result add(CreateSupplierRequest createSupplierRequest);
    Result update(UpdateSupplierRequest updateSupplierRequest);
    Result delete(int supplierId);
    DataResult<List<SupplierListResponse>> getAll();
    DataResult<SupplierListResponse> getById(int supplierId);

    PageDataResponse<SupplierListResponse> getByPage(int pageNumber, int supplierAmountInPage);

    DataResult<TempPageDataResponse<SupplierListResponse>> getByPage(PageParametersResponse parametersResponse);

    PageDataResponse<SupplierListResponse> getByPageWithSorting(int pageNumber, int supplierAmountInPage, String fieldName, boolean isAsc);

    DataResult<TempPageDataResponse<SupplierListResponse>> getByPageWithSorting(PageParameterResponseSorting parameterResponseSorting);

}
