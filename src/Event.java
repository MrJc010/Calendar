import java.text.SimpleDateFormat;

public class Event {
	private String eventName, startingTime, endingTime, content;
	public Event(String eventName, String startingTime, String endingTime, String content){
		this.eventName = eventName;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.content =  content;
	}
	public String getEventName(){
		return this.eventName;
	}
	public String getStartingTime(){
		return this.startingTime;
	}
	public String getEndingTime(){
		return this.endingTime;
	}
	public String getTimeEvent(){
		return this.startingTime + " - " + this.endingTime;
	}
	public String getEventContent(){
		return this.content;
	}
	public String toString(){
		return getTimeEvent() + " " + getEventName() + " "+ getEventContent();
	} 
	
	public int CompareTo(Event givenEvent){
		if(getTimeEvent() == null || givenEvent.getTimeEvent() == null) return 0;
		else return getTimeEvent().compareTo(givenEvent.getTimeEvent());
	}
}









