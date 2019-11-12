package main.com.idm;




public class TimeDuration  {
	private int time; 
	public TimeDuration (int NbSeconds ) throws BadBadValueException{
		if (NbSeconds <0) {
			throw new BadBadValueException("negatif duration");
		}
		else {
			time = NbSeconds;
		}
	}
	public void setTime(int NbSeconds) {
		time = NbSeconds;
	}
	public int getTime() {
		return time;
	}
	public int getHours (int seconds) {
		int hour  = seconds/3600;		
			
		return hour;
	}
	public int getMinutes (int seconds) {
		int temptime = seconds - getHours(seconds)*3600;	
		int minutes  = temptime/60;		
		return minutes;
	}
	public int getSecondes (int seconds) {
		int temptime = seconds - getHours(seconds)*3600;		
		 temptime = temptime - getMinutes(temptime)*60;	
		
		return temptime;
	}
	
	public String toString() {
		int hour = getHours(time);
		int minutes = getMinutes(time);
		int secondes = getSecondes(time);
		
		String result ="";
		if(hour>0) {
			result = result +hour +"h ";
		}
		if(minutes>0 ||hour>0) {result = result + minutes+"mn ";};
		
		result = result + secondes+"s";
		return result;
	}

	
	
}
