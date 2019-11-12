package main.com.idm;

public class Competitor {
	private final String RFID;
	private TimeDuration time ;
	
	public Competitor(String RFID, TimeDuration time) {
		this.RFID = RFID;
		this.time = time;
	}
	public Competitor(String RFID ) {
		this.RFID = RFID;
	}
	public TimeDuration getTime() {
		return time;
	}
	public void setTime(TimeDuration time) {
		this.time = time;
	}
	
	public int getTimeSecondes () {
	return	time.getTime();
	}
	public String getRFD() {
		return RFID;
	}
	

}
