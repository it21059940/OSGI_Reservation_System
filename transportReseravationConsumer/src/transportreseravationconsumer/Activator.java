package transportreseravationconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import transportreseravationpublisher.TransportReservation;

public class Activator implements BundleActivator {

	ServiceReference TransportReservationReference;
	
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Transport reservation Consumer Started");		
		TransportReservationReference = bundleContext.getServiceReference(TransportReservation.class.getName());
		TransportReservation transportReserve = (TransportReservation)bundleContext.getService(TransportReservationReference);

		//int userChoice;
		transportReserve.dislayVehiclePackageDetails();
		transportReserve.vehiclePackageSelection();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Exiting transport reservation");
	}

}
