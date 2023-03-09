package exercise_6;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DeliveryTimeCalculator {

	public static void main(String[] args) {
		double distance = 0, speed = 0, hoursLeftToStart = 0;
		String destinationZone;
		ZoneId destZoneId = null;
		
		// Getting distance, speed and time left to start journey from user.
		
		try (Scanner input = new Scanner(System.in)){
			while(destZoneId == null) {
				try {
					System.out.print("Enter distance in KM: ");
					distance = input.nextDouble();
					
					System.out.print("Enter vehicle speed in KM/Hr: ");
					speed = input.nextDouble();
					
					System.out.print("Enter number of hours left to start journey: ");
					hoursLeftToStart = input.nextDouble();
					
					
					while(destZoneId == null) {
						System.out.println(ZoneId.getAvailableZoneIds());
						System.out.println("Enter destination Timezone: ");
						destinationZone = input.next();
						try {
							destZoneId = ZoneId.of(destinationZone);
							
						}catch(DateTimeException e) {
							System.out.println("Timezone not valid. Enter correct timezone from the list");
						}
					}
				} catch(InputMismatchException e) {
					input.next(); // Skip the bad input
					System.out.println("Given input is not valid.");
				}
			}
		}
		
		
		double totalTravelTime = distance/speed;
		System.out.println("Total time taken to complete is " + totalTravelTime);
		
		
		double journeyTimeLeft = totalTravelTime;
		
		LocalDateTime now = LocalDateTime.now();
		// Setting journey start time by adding hours left to the current time
		LocalDateTime journeyStart = now.plusHours((long)hoursLeftToStart);
		MyDate journey = new MyDate(journeyStart);
		
		/*
		 *  Going through days to travel till we get the final date of travel 
		 *  where it requires less than 8 hrs of travel.
		 */
		
		while(journeyTimeLeft > 8.0) {
			if(!journey.isHoliday()) {
				double remainingForDay = journey.travelTimeForTheDay();
				journeyTimeLeft -= remainingForDay > 8.0 ? 8.0: remainingForDay;
			}
			LocalDateTime modDate = journey.date.withHour(0).withMinute(0).withSecond(0).withNano(0).plusDays(1);
			journey.setDate(modDate);
		}
		
		/*
		 *  Calculating the remaining time and assuming the driver is driving
		 *  from start of the day to reach the destination.
		 */
		
		long remainingMinutes = (long) ((journeyTimeLeft * 60) % 60);
		long remainingHours = (long) journeyTimeLeft;
		
		journey.setDate(journey.date.plusHours(remainingHours));
		journey.setDate(journey.date.plusMinutes(remainingMinutes));
		
		// Display delivery date at local time zone.
		System.out.println("Your package will be delivered by " + journey.date + " in local timezone.");
		
		String sourceZone = "Asia/Kolkata";
		ZoneId sourceZoneId = ZoneId.of(sourceZone);
		ZonedDateTime indiaZoned = journey.date.atZone(sourceZoneId);
		
		// Display delivery date at destination time zone.
		System.out.println("Your package will be delivered by " + indiaZoned.withZoneSameInstant(destZoneId) + " in desitnation timezone.");
		
	}

}



/**
 * This is a class which can be used to check if a day is holiday and 
 * the time available for traveling from any particular time of the day.
 * 
 */
class MyDate{
	LocalDateTime date;
	static List<LocalDateTime> leaveDates;
	
	static {
		leaveDates = new ArrayList<>();
		leaveDates.add(LocalDateTime.of(0, 1, 1, 0, 0));
		leaveDates.add(LocalDateTime.of(0, 8, 15, 0, 0));
		leaveDates.add(LocalDateTime.of(0, 1, 26, 0, 0));
	}
	
	/**
	 * LocalDateTime object to get date which decides if it is a holiday and 
	 * time to get remaining travel time for the day.
	 * 
	 * @param date
	 */
	MyDate(LocalDateTime date) {
		this.date = date;
	}
	
	/**
	 * Returns true if it is a public holiday or second Saturday or Sunday.
	 * 
	 * @return boolean
	 */
	boolean isHoliday() {
		
		if(isPublicHoliday() || isSecondSaturday() || isSunday()) return true;
		return false;
	}
	
	boolean isPublicHoliday() {
		
		return leaveDates.stream().anyMatch((checkDate) -> {
			if(checkDate.getDayOfMonth() == date.getDayOfMonth() && 
					checkDate.getMonth() == date.getMonth()
					) return true;
			return false;
		});
	}
	
	boolean isSecondSaturday() {
		if(date.getDayOfMonth() > 7 && date.getDayOfMonth() <= 14) {
			if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
				return true;
			}
		}
		return false;
	}
	
	boolean isSunday() {
		if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Calculates the remaining time left for the day to travel.
	 * If we check at 5:30 in the evening then the remaining time to travel will be
	 * till 12:00 that is 6.5 hrs.
	 * 
	 * @return double
	 */
	double travelTimeForTheDay() {
		LocalDateTime time = this.date;
//		LocalDateTime dayEnd = this.date.withHour(0).withMinute(0).withSecond(0).withNano(0).plusDays(1);
		double timeLeft = 24.0 - time.getHour() - time.getMinute() / 60.0;
		return timeLeft;
	}
	
	void setDate(LocalDateTime datetime) {
		this.date = datetime;
	}
}
