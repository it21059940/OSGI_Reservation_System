package cateringserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration CateringServicerManager;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Welcome to the Catering Main Service");
		CateringServiceProducer CateringRes = new CateringServiceProducerIMPL();
		CateringServicerManager = context.registerService(CateringServiceProducer.class.getName(),CateringRes,null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Catering Service Stopped");
		CateringServicerManager.unregister();
	}

}
