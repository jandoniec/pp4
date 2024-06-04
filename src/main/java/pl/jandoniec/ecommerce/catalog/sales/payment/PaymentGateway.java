package pl.jandoniec.ecommerce.catalog.sales.payment;

public interface PaymentGateway {
    PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest);
}