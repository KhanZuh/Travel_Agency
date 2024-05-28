public class TravelAgent {

    public void makeBooking(Bookable bookable, Customer customer){
        if(bookable.hasCapacity() && customer.canAfford(bookable.getPrice()))bookable.book(customer);
    }

    // in order to cancel booking the customer would have had sufficient funds therefore a booking would have been processed
    // to cancel booking check if customer has a booking and then cancel it
    public void cancelBooking(Bookable bookable, Customer customer){
        if(bookable.hasBooking(customer))
            bookable.cancel(customer);
    }
}
