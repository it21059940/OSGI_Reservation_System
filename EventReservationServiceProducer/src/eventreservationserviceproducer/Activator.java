package eventreservationserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration eventReservationHelper;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Welcome to the Event Reservation and Details Service Section");
		EventReservationService eventRes = new EventReservationServiceImpl();
		eventReservationHelper = bundleContext.registerService(EventReservationService.class.getName(), eventRes, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Event Reservation sub service is stopping");
		eventReservationHelper.unregister();
	}

}
