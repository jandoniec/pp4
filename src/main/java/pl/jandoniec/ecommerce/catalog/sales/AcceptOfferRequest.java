package pl.jandoniec.ecommerce.catalog.sales;

public class AcceptOfferRequest {

    String firstname;
    String lastname;
    String email;

    public String firstname() {
        return firstname;
    }

    public String lastname() {
        return lastname;
    }

    public String email() {
        return email;
    }

    public AcceptOfferRequest setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public AcceptOfferRequest setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public AcceptOfferRequest setEmail(String email) {
        this.email = email;
        return this;
    }

}
