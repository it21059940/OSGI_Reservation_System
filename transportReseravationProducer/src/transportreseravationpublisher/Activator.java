package transportreseravationpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration transportReservationHelper;
	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Transport Reservation Publisher Started");
		TransportReservation transport = new TransportReservationImpl();
		transportReservationHelper = bundleContext.registerService(TransportReservation.class.getName(), transport, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Exiting Transport Reservayion service");
	}

}
