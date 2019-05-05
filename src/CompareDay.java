import java.util.Comparator;
class CompareDay implements Comparator<Day>{
	public int compare(Day o1, Day o2){
		return o1.getDay().compareTo(o2.getDay());
	}
}
