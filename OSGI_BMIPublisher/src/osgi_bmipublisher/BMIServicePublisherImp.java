package osgi_bmipublisher;
import java.util.Scanner;

public class BMIServicePublisherImp implements BMIServicePublisher {
	Scanner sc= new Scanner(System.in);	@Override
	public double calculateBMI() {
		double height=0.0;double weight=0.0;
		
		System.out.print("Please enter your height : ");
		height = sc.nextDouble();
		System.out.print("Please enter your weight : ");
		weight = sc.nextDouble();
		double bmi= weight  / (height * height) * 703;
		System.out.println("Your bmi  value is "+ bmi);
		return bmi;
	}

}
