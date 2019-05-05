import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MyCalendarTester {

	public static void main(String[] args) {
		ViewCalendar cal = new ViewCalendar();
		Scanner scan = new Scanner(System.in);
		int currentDay = cal.getCurrentDay();
		int currentMonth = cal.getCurrentMonth();
		int currentYear = cal.getCurrentYear();
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/YYYY");
		

		
		cal.viewCalendar(currentMonth, currentYear);
		cal.viewEventByDay("09/04/2017");
	}
	
	public static void initialScreen(){
		System.out.println("Select one of the following option:\n"
				+ "[L]oad   [V]iew by   [C]reate,   [G]o to   [E]vent list   [D]elete   [Q]uit\n"
				+ "Enter your option: ");
	}

}
