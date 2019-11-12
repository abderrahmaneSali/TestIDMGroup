package main.com.idm;
  
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

 
public class RaceResults {
// i think that set is the best choice because the RFID is unique so Competetor is unique
	private  Set<Competitor> competitors;
	public RaceResults ( ) {//HashSet is the best structure in performance
		this.competitors = new HashSet<Competitor>();
	}
	public RaceResults ( Set<Competitor> competitors ) {
		this.competitors = competitors;
	}
	
	
	public Set<Competitor> getCompetitors() {
		return competitors;
	}


	public void setCompetitors(Set<Competitor> competitors) {
		this.competitors = competitors;
	}


	public void onNewResult(String tagNumber, TimeDuration resultTime) {
		competitors.add(new Competitor(tagNumber, resultTime));
		
	}
	
	public void printResults() {
		
		 List<Competitor> list = new ArrayList<Competitor>(competitors); 
	   List<Competitor> sorted =  list.stream().sorted(Comparator.comparingInt(Competitor::getTimeSecondes)).collect(Collectors.toList());
	   sorted.stream() .forEach((item)->{
	    	 if(sorted.indexOf(item)==0) {
	    		 System.out.print("Winner ");
	    	 }
	     System.out.println( "#"+(sorted.indexOf(item)+1) + " Tag number " +item.getRFD() +" : "+ item.getTime().toString());
	     });;
		
	}
	
	public static void main (String args[]) {
		/*My solution include implementing of Competitor, 
		  so that we can add more informations about him, name, age,...
		store them in data base 
		
		*I added a function in Competetor class called  getTimeSecondes 
		*to get the duration in secondes and sort them by using sort function*/
		RaceResults race = new RaceResults();
		try {
			race.onNewResult("1",new TimeDuration(122));
			race.onNewResult("2",new TimeDuration(182));
			race.onNewResult("4",new TimeDuration(192));
			race.onNewResult("8",new TimeDuration(112));
			race.onNewResult("5",new TimeDuration(1122));			
			//race.onNewResult("5",new TimeDuration(-1122));		
		} catch (BadBadValueException e) {
			System.out.println(e);
		}
		race.printResults();
		
	}
}
