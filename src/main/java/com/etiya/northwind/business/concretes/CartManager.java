package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.cartRequests.*;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.exceptions.BusinessException;
import com.etiya.northwind.core.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.*;
import com.etiya.northwind.dataAccess.abstracts.CartProductRepository;
import com.etiya.northwind.dataAccess.abstracts.CartRepository;
import com.etiya.northwind.dataAccess.abstracts.OrderDetailsRepository;
import com.etiya.northwind.dataAccess.abstracts.OrderRepository;
import com.etiya.northwind.entities.concretes.Cart;
import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartManager implements CartService {
    private CartRepository cartRepository;
    private ModelMapperService modelMapperService;
    private CartProductRepository cartProductRepository;
    private CustomerService customerService;
    private OrderRepository orderRepository;
    private OrderDetailsRepository orderDetailsRepository;
    private ProductService productService;

    @Autowired
    public CartManager(CartRepository cartRepository, ModelMapperService modelMapperService
            , CartProductRepository cartProductRepository, CustomerService customerService
            , OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository
    ,ProductService productService) {
        this.cartRepository = cartRepository;
        this.modelMapperService = modelMapperService;
        this.cartProductRepository = cartProductRepository;
        this.customerService = customerService;
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.productService =productService;
    }

    @Override
    public Result add(CreateCartRequest createCartRequest) {

        Cart cart = new Cart();
        cart.setCustomer(this.customerService.findById(createCartRequest.getCustomerId()));
        cartRepository.save(cart);

        return new SuccessResult();

    }


    @Override
    public Result update(UpdateCartRequest updateCartRequest) {
        Cart cart = this.modelMapperService.forRequest().map(updateCartRequest, Cart.class);
        this.cartRepository.save(cart);
        return new SuccessResult();
    }

    @Override
    public Result delete(int cartId) {
        checkIfCartIdExists(cartId);

        this.cartRepository.deleteById(cartId);

        return new SuccessResult();
    }

    @Override
    public DataResult<List<CartListResponse>> getAll() {
        List<Cart> result = this.cartRepository.findAll();
        List<CartListResponse> responses = result.stream().map(cart -> this.modelMapperService.forResponse()
                .map(cart, CartListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CartListResponse>>(responses);
    }

    @Override
    public DataResult<CartListResponse> getById(int cartId) {
        CartListResponse response = new CartListResponse();
        if (this.cartRepository.existsById(cartId)) {
            Cart cart = this.cartRepository.findById(cartId).get();
            response = modelMapperService.forResponse().map(cart, CartListResponse.class);
            return new SuccessDataResult<CartListResponse>(response);
        } else {
            System.out.println("Geçersiz Sepet Id");
            return new ErrorDataResult<CartListResponse>(response);
        }
    }

    public void addToOrder(CreateRequestAddToOrder createRequestAddToOrder, CreateRequestAddToOrderDetails createRequestAddToOrderDetails) {


        Order order = new Order();
        order.setOrderId(createRequestAddToOrder.getOrderId());
        order.setCustomer(this.customerService.findById(createRequestAddToOrder.getCustomerId()));
        this.orderRepository.save(order);


        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(createRequestAddToOrderDetails.getOrderId());
        orderDetails.setProduct(this.productService.findById(createRequestAddToOrderDetails.getProductId()));
        orderDetails.setQuantity(createRequestAddToOrderDetails.getQuantity());
        orderDetails.setUnitPrice(createRequestAddToOrderDetails.getUnitPrice());
        this.orderDetailsRepository.save(orderDetails);


    }

    public void deleteFromCart(CreateRequestAddToOrder createRequestAddToOrder){
        this.cartRepository.deleteById(createRequestAddToOrder.getCartId());
        this.cartProductRepository.deleteCartWithCartId(createRequestAddToOrder.getCartId());
    }

    private void checkIfCartIdExists(int cartId){

        if (!this.cartRepository.existsById(cartId)){
            throw new BusinessException("Invalid CartId");
        }
    }
}
