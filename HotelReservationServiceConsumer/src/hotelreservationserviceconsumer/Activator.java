package hotelreservationserviceconsumer;

import eventreservationserviceproducer.EventReservationService;
import java.util.ArrayList;
import java.util.Scanner;
import mainhotelreservationproducer.HotelReservationMainProducer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import roomreservationserviceproducer.RoomReservationService;

public class Activator implements BundleActivator {

	ServiceReference MainBookingServiceReference;
	ServiceReference RoomReservationServiceReference;
	ServiceReference EventReservationServiceReference;
	String customerName;
	ArrayList<CustomerFeedback> cutomerFeedback = new ArrayList<>();
	Scanner ob = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Customer Consumer Joined");
		
		//registering the services
		MainBookingServiceReference = bundleContext.getServiceReference(HotelReservationMainProducer.class.getName());
		HotelReservationMainProducer mainProducer = (HotelReservationMainProducer)bundleContext.getService(MainBookingServiceReference);
		
		RoomReservationServiceReference = bundleContext.getServiceReference(RoomReservationService.class.getName());
		RoomReservationService roomServiceProducer = (RoomReservationService)bundleContext.getService(RoomReservationServiceReference);
		
		EventReservationServiceReference = bundleContext.getServiceReference(EventReservationService.class.getName());
		EventReservationService eventServiceProducer = (EventReservationService)bundleContext.getService(EventReservationServiceReference);
		
		int loopCounter = 0;
		
		//starting to use the producer services
		customerName = mainProducer.initialize();

		while(loopCounter==0) {
			int serviceChoice; 
			serviceChoice = mainProducer.getServiceChoice();
			
			if(serviceChoice == 1) {
				//Customer choose Room reservation service
				System.out.println("Welcome to the Room Reservation Section!!");
				System.out.println("Refer the available room details and prices below");
				roomServiceProducer.getRoomDetails();
				
				System.out.println("Would you like to continue and reserve a room? Type yes");
				Scanner ob = new Scanner(System.in);
				String confirm = ob.next();
				
				if(confirm.equalsIgnoreCase("yes")) {
					roomServiceProducer.reserveRoom();
				}else {
					return;
				}
			}
			else if(serviceChoice == 2) {
				//Customer chose Event reservation service
				System.out.println("Welcome to the Event Reservation Section!!");
				System.out.println("Refer the available day out packages and prices below");
				eventServiceProducer.getDayOutPackageDetails();
				
				System.out.println("Would you like to continue and book a day out package? Type yes");
				Scanner ob = new Scanner(System.in);
				String confirm = ob.next();
				
				if(confirm.equalsIgnoreCase("yes")) {
					eventServiceProducer.bookDayOut();
				}else {
					return;
				}		
			}

			System.out.println("Would you like another service? Type Yes or No");
			if(ob.next().equalsIgnoreCase("Yes")) {
				loopCounter=0;
			}else {
				loopCounter=1;
			}
		}
	
	}
		
	

	public void stop(BundleContext bundleContext) throws Exception {
		
		//getting customer feedback upon closing
		System.out.println("Hope you had a great expeience here!Please leave a feedback");
		CustomerFeedback feedback = new CustomerFeedback();
		feedback.setName(customerName);
		System.out.println("On a scale of 1-5 how user friendly was our system?");
		feedback.setUserFriendlyRating(ob.nextInt());
		System.out.println("On a scale of 1-5 how useful was our system?");
		feedback.setUsefulnessRating(ob.nextInt());
		
		cutomerFeedback.add(feedback);
	}

}
