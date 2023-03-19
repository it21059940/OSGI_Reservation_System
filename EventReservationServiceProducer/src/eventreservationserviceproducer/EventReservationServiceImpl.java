package eventreservationserviceproducer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EventReservationServiceImpl implements EventReservationService{
	
	@Override
	public void getDayOutPackageDetails() {
		System.out.println("Our currently avaiable Day Out Packages:-");
		System.out.println("Package Name                 Price(less than 10)       Price(more than 10)");
		System.out.println("*************************************************************************");
		System.out.println("1.Paintballing Package      -  3500/= per head           2500/= per head ");
		System.out.println("2.A hike with guide         -  4000/= per head           3000/= per head ");
		System.out.println("3.Lunch and DJ by the pool  -  5000/= per head           4000/= per head ");
		System.out.println("4.WaterPark Package         -  6000/= per head           5000/= per head ");
		System.out.println("*************************************************************************");
		System.out.println("Note - Taxes may be added");
		
	}

	@Override
	public void bookDayOut() {
		Scanner ob = new Scanner(System.in);
		ArrayList currentDetails = new ArrayList();
		int PckgNo = 0,PplNo = 0;
		
		try {
			//emptying the list
			currentDetails.removeAll(currentDetails);
			
			System.out.println("Please enter the Day Out package you wish to book:");
			PckgNo = ob.nextInt();
			currentDetails.add(PckgNo);
			if(PckgNo!= 1 &&PckgNo!= 2 &&PckgNo!= 3 &&PckgNo!= 4) {
				System.out.println("Invalid Package No! Please enter package number:");
				PckgNo = ob.nextInt();
			}
			
			System.out.println("Please enter the number of people:");
			PplNo = ob.nextInt();
			currentDetails.add(PplNo);
			
			System.out.println("Please enter you name:");
			String name = ob.next();
			currentDetails.add(name);
			
			System.out.println("Enter the date of booking:");
			String date = ob.next();
			currentDetails.add(date);
			
			System.out.println("Please enter your contact number/email address:");
			String contact = ob.next();
			currentDetails.add(contact);
			
		}catch(InputMismatchException e) {
			System.out.println("Wrong input type!");
		}catch(Exception e) {
			System.out.println("An exception occured!");
		}finally {
			calculatePayment(PckgNo,PplNo);
			
			System.out.println("Would you like to confirm the booking? Type Yes");
			String confirm = ob.next();
			if(confirm.equalsIgnoreCase("Yes")) {
				try {
					storeBooking(currentDetails);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	public void calculatePayment(int packageNo,int participantNo) {
		
		float amount1;
		float finalAmount;
		double advance;
		
		if(packageNo==1) {
			if(participantNo<=10) {
				amount1 = 3500*participantNo;
				finalAmount = ((10/100)*amount1)+amount1;
				advance = finalAmount/2.0;
				printPaymentSummary(amount1,finalAmount,advance);
			}
			else {
				amount1 = 2500*participantNo;
				finalAmount = ((10/100)*amount1)+amount1;
				advance = finalAmount/2.0;
				printPaymentSummary(amount1,finalAmount,advance);
			}
		}
		else if(packageNo==2) {
			if(participantNo<=10) {
				amount1 = 4000*participantNo;
				finalAmount = ((10/100)*amount1)+amount1;
				advance = finalAmount/2.0;
				printPaymentSummary(amount1,finalAmount,advance);
			}
			else {
				amount1 = 3000*participantNo;
				finalAmount = ((10/100)*amount1)+amount1;
				advance = finalAmount/2.0;
				printPaymentSummary(amount1,finalAmount,advance);
			}
		}
		else if(packageNo==3) {
			if(participantNo<=10) {
				amount1 = 5000*participantNo;
				finalAmount = ((10/100)*amount1)+amount1;
				advance = finalAmount/2.0;
				printPaymentSummary(amount1,finalAmount,advance);
			}
			else {
				amount1 = 4000*participantNo;
				finalAmount = ((10/100)*amount1)+amount1;
				advance = finalAmount/2.0;
				printPaymentSummary(amount1,finalAmount,advance);
			}
		}
		else if(packageNo==4) {
			if(participantNo<=10) {
				amount1 = 6000*participantNo;
				finalAmount = ((10/100)*amount1)+amount1;
				advance = finalAmount/2.0;
				printPaymentSummary(amount1,finalAmount,advance);
			}
			else {
				amount1 = 5000*participantNo;
				finalAmount = ((10/100)*amount1)+amount1;
				advance = finalAmount/2.0;
				printPaymentSummary(amount1,finalAmount,advance);
			}
		}				
	}
	
	public void printPaymentSummary(float amt1,float amt2,double amt3) {
		System.out.println("**********Payment Summary************");
		System.out.println("Initial Total          - "+amt1+"/=");
		System.out.println("Final Total with Taxes -"+amt2+"/=");
		System.out.println("Note-50% advance should be payed at reservation");
		System.out.println("Advance Payable        -"+amt3+"/=");
	}

	public void storeBooking(ArrayList details) throws Exception {
		//NOTE - file will be created in the D drive(D drive needs to have permission to create files)
		try {
			String path ="D:\\DayOutBookings.txt";	
			File file = new File(path);
			boolean created = file.createNewFile();
			file.setWritable(true);
			if (created) {
			    System.out.println("Saved!");
			} else {
			    System.out.println("Saved!");
			}
			    
			writeToFile(path,details);    
		} catch (IOException e) {
			    System.out.println("Error creating file: " + e.getMessage());
		}
		
	}
	
	public void writeToFile(String path,ArrayList details) {
		 
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
			 writer.newLine();
	         writer.write("***************************************");
			 writer.newLine();
	         writer.write("Name : "+details.get(2));
	         writer.newLine();
	         writer.write("Package No : "+details.get(0));
	         writer.newLine();
	         writer.write("Date : "+details.get(3));
	         writer.newLine();
	         writer.write("Num of participants : "+details.get(1));
	         writer.newLine();
	         writer.write("Contact : "+details.get(4));
	     } catch (IOException e) {
	            System.err.println("Error writing to file " + path);
	            e.printStackTrace();
	     }
	   
	}

}
