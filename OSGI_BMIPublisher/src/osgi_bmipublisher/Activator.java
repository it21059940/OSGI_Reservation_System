package osgi_bmipublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {


	ServiceRegistration publishServiceRegistration;
	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("----- Publisher Start");
		BMIServicePublisherImp publishService = new BMIServicePublisherImp();
		publishServiceRegistration = bundleContext.registerService(BMIServicePublisher.class.getName(),publishService,null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("------ Publisher Stoped");
		publishServiceRegistration.unregister();
	}
}
