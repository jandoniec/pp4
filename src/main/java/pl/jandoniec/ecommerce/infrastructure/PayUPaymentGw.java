package pl.jandoniec.ecommerce.infrastructure;

import pl.jandoniec.ecommerce.catalog.sales.payment.PaymentDetails;
import pl.jandoniec.ecommerce.catalog.sales.payment.PaymentGateway;
import pl.jandoniec.ecommerce.catalog.sales.payment.RegisterPaymentRequest;

public class PayUPaymentGw implements PaymentGateway {
    @Override

    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest){
        return null;
    }
}