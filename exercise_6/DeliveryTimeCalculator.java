package exercise_6;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryTimeCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		LocalDateTime date = LocalDateTime.now();
		
		System.out.print("Enter distance in KM: ");
		double distance = input.nextDouble();
		
		System.out.print("Enter vehicle speed in KM/Hr: ");
		double speed = input.nextDouble();
		
		System.out.print("Enter number of hours left to start journey: ");
		double hoursLeftToStart = input.nextDouble();
		
		System.out.println(ZoneId.getAvailableZoneIds());
		System.out.println("Enter destination Timezone: ");
		String destinationZone = input.next();
		ZoneId destZoneId = ZoneId.of(destinationZone);
		
		double totalTravelTime = distance/speed;
		System.out.println("Total time taken to complete is " + totalTravelTime);
		
		
		double journeyTimeLeft = totalTravelTime;
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime journeyStart = now.plusHours((long)hoursLeftToStart);
		MyDate journey = new MyDate(journeyStart);
		
		while(journeyTimeLeft > 8.0) {
			if(!journey.isHoliday()) {
				double remainingForDay = journey.travelTimeForTheDay();
				journeyTimeLeft -= remainingForDay > 8.0 ? 8.0: remainingForDay;
			}
			LocalDateTime modDate = journey.date.withHour(0).withMinute(0).withSecond(0).withNano(0).plusDays(1);
			journey.setDate(modDate);
		}
		
		long remainingMinutes = (long) ((journeyTimeLeft * 60) % 60);
		long remainingHours = (long) journeyTimeLeft;
		
		journey.setDate(journey.date.plusHours(remainingHours));
		journey.setDate(journey.date.plusMinutes(remainingMinutes));
		
		System.out.println("Your package will be delivered by " + journey.date + " in local timezone.");
		
		String sourceZone = "Asia/Kolkata";
		ZoneId sourceZoneId = ZoneId.of(sourceZone);
		ZonedDateTime indiaZoned = journey.date.atZone(sourceZoneId);
		System.out.println("Your package will be delivered by " + indiaZoned.withZoneSameInstant(destZoneId) + " in desitnation timezone.");
		
	}

}


class MyDate{
	LocalDateTime date;
	static List<LocalDateTime> leaveDates;
	
	static {
		leaveDates = new ArrayList<>();
		leaveDates.add(LocalDateTime.of(0, 1, 1, 0, 0));
		leaveDates.add(LocalDateTime.of(0, 8, 15, 0, 0));
		leaveDates.add(LocalDateTime.of(0, 1, 26, 0, 0));
	}
	
	MyDate(LocalDateTime date) {
		this.date = date;
	}
	
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
