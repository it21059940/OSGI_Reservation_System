package mainhotelreservationproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration hotelReservationManager;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Welcome to the Hotel Reservation Main Service");
		HotelReservationMainProducer hotelRes = new HotelReservationMainProducerImpl();
		hotelReservationManager = bundleContext.registerService(HotelReservationMainProducer.class.getName(), hotelRes, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hotel Reservation Main Service Stopping");
		hotelReservationManager.unregister();
	}

}
