import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
public class Day {
	private Date day;
	private TreeSet<Event> events;
	private SimpleDateFormat formatFull = new SimpleDateFormat("MM/dd/YYY");
	private SimpleDateFormat formatMY = new SimpleDateFormat("MM/YYY");
	public Day(String day) throws ParseException{
		this.day = formatFull.parse(day);
		this.events = new TreeSet<Event>(new CompareEvent());
	}
	public Date getDay(){
		return this.day;
	}
	public void addEvent(Event event){
		events.add(event);
	}
	public String fullDay(){
		return formatFull.format(this.day);
	}
	public String formatMY(){
		return formatMY.format(this.day);
	}
	public String eventOfDay(){
		String event = "";
		for(Event e : events){
			event += e.toString();
		}
		return event;
	}
	public int CompareTo(Day givenDay){
		if(fullDay() == null || givenDay.fullDay() == null) return 0;
		else return fullDay().compareTo(givenDay.fullDay());
	}
	
	public String toString(){
		return fullDay() + "\n" + eventOfDay();
	}
	
}
