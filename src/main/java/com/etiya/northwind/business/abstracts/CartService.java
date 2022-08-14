package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.cartRequests.CreateCartRequest;
import com.etiya.northwind.business.requests.cartRequests.CreateRequestAddToOrder;
import com.etiya.northwind.business.requests.cartRequests.CreateRequestAddToOrderDetails;
import com.etiya.northwind.business.requests.cartRequests.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface CartService {

    Result add(CreateCartRequest createCartRequest);

    void addToOrder(CreateRequestAddToOrder createRequestAddToOrder, CreateRequestAddToOrderDetails createRequestAddToOrderDetails);
    void deleteFromCart(CreateRequestAddToOrder createRequestAddToOrder);

    Result update(UpdateCartRequest updateCartRequest);

    Result delete(int cartId);

    DataResult<List<CartListResponse>> getAll();

    DataResult<CartListResponse> getById(int cartId);


}
