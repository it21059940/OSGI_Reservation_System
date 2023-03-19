package roomreservationserviceproducer;

public interface RoomReservationService {
	
	//service provided to customers
	public void getRoomDetails();
	public void reserveRoom();
	
	//service provided to admins
	public void updateDetails();

}
