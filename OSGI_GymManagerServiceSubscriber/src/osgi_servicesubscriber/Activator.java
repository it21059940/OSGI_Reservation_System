package osgi_servicesubscriber;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.service.ServicePublish;

import osgi_bmipublisher.BMIServicePublisher;

public class Activator implements BundleActivator {

	ServiceReference<?> serviceReference;
	ServiceReference<?> serviceReference1;
	Scanner sc = new Scanner(System.in);
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		
		serviceReference1 = context.getServiceReference(BMIServicePublisher.class.getName());
		BMIServicePublisher bmiServicePublisher = (BMIServicePublisher)context.getService(serviceReference1);
		
		System.out.print("Press 1 to register member and 2 to calculate your BMI : ");
		int c = sc.nextInt();
		System.out.println();
		if(c == 1) {
			servicePublish.showMenu();
			int choice = servicePublish.getSelectedMenuItem();
			servicePublish.executeMenu(choice);
		}else {
			bmiServicePublisher.calculateBMI();		
			
		}
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Subscriber Service");
		context.ungetService(serviceReference);
		context.ungetService(serviceReference1);
	}

}
