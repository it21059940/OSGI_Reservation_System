package mainhotelreservationproducer;

public interface HotelReservationMainProducer {

	//service provided to customers
	public String initialize();
	public int getServiceChoice();
	
	//service provided to admin
	public void viewAllReservations();
}
