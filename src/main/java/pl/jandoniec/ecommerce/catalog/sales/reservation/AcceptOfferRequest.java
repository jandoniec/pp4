package pl.jandoniec.ecommerce.catalog.sales.reservation;

public class AcceptOfferRequest {
    String firstName;
    String lastName;
    String email;

    public String getFirstName() {
        return firstName;
    }

    public AcceptOfferRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AcceptOfferRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AcceptOfferRequest setEmail(String email) {
        this.email = email;
        return this;
    }
}