package hoteladminserviceconsumer;

import java.util.HashMap;
import java.util.Scanner;
import mainhotelreservationproducer.HotelReservationMainProducer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import roomreservationserviceproducer.RoomReservationService;

public class Activator implements BundleActivator {

	ServiceReference RoomServiceAdminReference;
	ServiceReference ReservationAdminReference;
	HashMap<String,Integer> rating = new HashMap<>();

	Scanner ob = new Scanner(System.in);
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Admin consumer started");
		
		RoomServiceAdminReference = bundleContext.getServiceReference(RoomReservationService.class.getName());
		RoomReservationService roomres = (RoomReservationService)bundleContext.getService(RoomServiceAdminReference);
	
		ReservationAdminReference = bundleContext.getServiceReference(HotelReservationMainProducer.class.getName());
		HotelReservationMainProducer mainProducer = (HotelReservationMainProducer)bundleContext.getService(ReservationAdminReference);
		
		System.out.println("Welcome to the Admin Service Section!!");
		
		int loopCounter = 0;

		while(loopCounter==0) {
			System.out.println("Enter the task you would like to proceed with:");
			System.out.println("1. Update Room Prices");
			System.out.println("2. View all Reservations");
			
			int choice = ob.nextInt();
			if(choice == 1) {
				roomres.updateDetails();
			}else {
				mainProducer.viewAllReservations();
			}
			System.out.println("Would you like to continue?");
			if(ob.next().equalsIgnoreCase("Yes")) {
				loopCounter=0;
			}else {
				loopCounter=1;
			}
		}	
	}
	
	
	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Good bye!Please rate your experience");
		
		System.out.println("Enter the admin ID:");
		String ID = ob.next();
		System.out.println("On the scale of 1-5 how much would you rate your experience today?");
		Integer rate = ob.nextInt();
		
		rating.put(ID, rate);
	}

}
