package pl.jandoniec.ecommerce.catalog.sales.reservation;


import java.util.HashMap;
import java.util.Optional;

public class ReservationRepository {
    public  ReservationRepository(){
        this.reservations=new HashMap<>();
    }

    HashMap<String, Reservation> reservations;


    public Optional<Reservation> load(String reservationId){

        return Optional.of(reservations.get(reservationId));
    }
    public void add(Reservation reservation){
        reservations.put(reservation.getId(),reservation);


    }
}