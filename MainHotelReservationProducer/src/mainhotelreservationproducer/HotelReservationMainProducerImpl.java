package mainhotelreservationproducer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HotelReservationMainProducerImpl implements HotelReservationMainProducer{
	
	Scanner ob = new Scanner(System.in);
	
	@Override
	public String initialize() {
		//show welcome message to user
		String desc = "We warmly Welcome you to Lemon Holdings Hotel "
				+ "and Event Reservation System!";
		System.out.println("Please enter your name to get started:");
		String name = ob.next();
		System.out.println("Hello "+name+"!");
		return name;
		
	}

	@Override
	public int getServiceChoice() {
		System.out.println();
		System.out.println("Please select the service number you would like to get");
		System.out.println("1. Get room booking details or book a room");
		System.out.println("2. Book day out package or get details about it");
		System.out.println();
		
		int serviceNo = ob.nextInt();
		return serviceNo;
	}

	
	
	@Override
	public void viewAllReservations() {
		readRoomResData();
		readDayOutData();		
	}
	
	public void readRoomResData() {
		
		System.out.println("***********Printing Room Reservatiom Data************");
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("D:\\RoomReservation.txt"));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
        } catch (IOException e) {
        	System.out.println("Exception occured");
            e.printStackTrace();
        } finally {
           if (reader != null) {
              try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
           }
        }
		
	}

	
	public void readDayOutData() {
		System.out.println("***********Printing Day out Reservatiom Data************");
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("D:\\DayOutBookings.txt"));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
        } catch (IOException e) {
        	System.out.println("Exception occured");
            e.printStackTrace();
        } finally {
           if (reader != null) {
              try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
           }
        }
		
	}	


}
