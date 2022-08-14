package com.etiya.northwind.business.requests.cartRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequestAddToOrderDetails extends AddToOrderRequest{
    private int orderId;
    private int productId;
    private int quantity;
    private double unitPrice;
}
