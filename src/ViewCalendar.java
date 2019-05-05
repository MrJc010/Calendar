import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TreeSet;

public class ViewCalendar { 
	private static final Calendar calendar = Calendar.getInstance();
	private  final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YYY");
	public TreeSet<Day> dayHasEvents;
	public ViewCalendar(){
		dayHasEvents = new TreeSet<Day>(new CompareDay());
	}
	public void addDayHasEvent(Day day){
		dayHasEvents.add(day);
	}
	public void addDayAndEvent(Day day, Event event){
		if(dayHasEvents.contains(day)){
			day.addEvent(event);
		} else{
			day.addEvent(event);
			dayHasEvents.add(day);
		}
	}
	public TreeSet<Day> getDayEvents(){
		return dayHasEvents;
	}
	public String allDayEvent(){
		String days = "";
		for(Day d : dayHasEvents){
			days += d.toString();
		}
		return days;
	}
	public void viewEventByDay(String givenDay){
		String e=null;
		for(Day d : dayHasEvents){
			if(d.fullDay().equals(givenDay)){
				e+= d.toString()+"\n";
			}
		}
		if(e == null){
			e = givenDay + " Has No Event";
		}
		System.out.println(e);
	}
	public void viewEventbyMonth(int month, int year){
		String m = String.format("%02d%04d", month,year);
		String[] months = {
				"","January", "February", "March","April", "May", "June","July", "August", "September","October", "November", "December"};
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (month == 2 && isLeapYear(year)) days[month] = 29;
		System.out.println("   " + months[month] + " " + year);
		System.out.println(" S  M Tu  W Th  F  S");
		int d = day(month, 1, year);
		for (int i = 0; i < d; i++)
			System.out.print("   ");
		for (int i = 1; i <= days[month]; i++) {
			for(Day day: dayHasEvents){
				if(day.formatMY().equals(m)){
					System.out.printf("{" +"%2d" + "}",i);
				}
			}
			System.out.printf("%2d ", i);
			if (((i + d) % 7 == 0) || (i == days[month]))
				System.out.println();
		}
	}
	public void deleteAllEvent(){
		dayHasEvents.clear();
	}
	public void deleteEventByDay(String day){
		for(Day d: dayHasEvents){
			if(d.fullDay().equals(day)){
				dayHasEvents.remove(d);
			}
		}
	}
	public int getCurrentDay(){
		return  calendar.get(Calendar.DATE);
	}
	public static int getCurrentMonth(){
		return calendar.get(Calendar.MONTH) + 1;
	}
	public static int getCurrentYear(){
		return calendar.get(Calendar.YEAR);
	}
	public static int day(int month, int day, int year) {
		int y = year - (14 - month) / 12;
		int x = y + y/4 - y/100 + y/400;
		int m = month + 12 * ((14 - month) / 12) - 2;
		int d = (day + x + (31*m)/12) % 7;
		return d;
	}
	public static boolean isLeapYear(int year) {
		if  ((year % 4 == 0) && (year % 100 != 0)) return true;
		if  (year % 400 == 0) return true;
		return false;
	}
	public static void viewCalendar(int month, int year){
		int dayOfWeek = calendar.get(Calendar.DAY_OF_MONTH);
		String[] months = {
				"","January", "February", "March","April", "May", "June","July", "August", "September","October", "November", "December"};
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (month == 2 && isLeapYear(year)) days[month] = 29;
		System.out.println("   " + months[month] + " " + year);
		System.out.println(" S  M Tu  W Th  F  S");
		int d = day(month, 1, year);
		for (int i = 0; i < d; i++)
			System.out.print("   ");
		for (int i = 1; i <= days[month]; i++) {
			if(dayOfWeek == i && year == getCurrentYear() && month == getCurrentMonth()){
				System.out.printf("[" +"%2d" + "]",i);
			}else{
				System.out.printf("%2d ", i);
			}
			if (((i + d) % 7 == 0) || (i == days[month]))
				System.out.println();
		}
	}

}

