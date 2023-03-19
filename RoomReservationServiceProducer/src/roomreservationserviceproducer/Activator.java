package roomreservationserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration roomReservationHelper;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Welcome to the Room Reservation and Details Service Section");
		RoomReservationService roomRes = new RoomReservationServiceImpl();
		roomReservationHelper = bundleContext.registerService(RoomReservationService.class.getName(), roomRes, null);
	}
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Room Reservation sub service is stopping");
		roomReservationHelper.unregister();
	}
}
