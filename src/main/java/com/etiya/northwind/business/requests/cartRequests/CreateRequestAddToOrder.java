package com.etiya.northwind.business.requests.cartRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequestAddToOrder extends AddToOrderRequest{
    private int orderId;
    private String customerId;;
    private int cartId;

}
