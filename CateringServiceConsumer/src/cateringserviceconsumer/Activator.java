package cateringserviceconsumer;

import cateringserviceproducer.CateringServiceProducer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {
	
	ServiceReference CateringServiceReference;
	

	public void start(BundleContext context) throws Exception {
		System.out.println("Consumer Started");
		CateringServiceReference = context.getServiceReference(CateringServiceProducer.class.getName());
		CateringServiceProducer CateringService = (CateringServiceProducer)context.getService(CateringServiceReference);
		CateringService.showIntroduction();
//		CateringService.showMenu();
//		CateringService.getServiceChoise();
		int No = CateringService.getServiceChoise();
		CateringService.showMenu();
		CateringService.calculateBill();
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Consumer Stopped");
		context.ungetService(CateringServiceReference);
	}

}
