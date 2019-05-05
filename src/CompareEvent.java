import java.util.Comparator;
class CompareEvent implements Comparator<Event>{
	public int compare(Event o1, Event o2) {
		return o1.getTimeEvent().compareTo(o2.getTimeEvent());
	}
}

