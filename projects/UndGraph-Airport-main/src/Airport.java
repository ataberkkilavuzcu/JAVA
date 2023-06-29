
public class Airport {
	
	private char city;
	private static boolean loading = false, running = true;
	private static int realTime, stateChangeTime, flightTime;

	
	public Airport(char city) {
		this.city = city;
	}

	public char getCity() {
		return city;
	}

	public void setCity(char city) {
		this.city = city;
	}
	public static int getrealTime() {
		return realTime;
	}
	
	public static int getStateChangeTime() {
		return stateChangeTime;
	}

	public static void setStateChangeTime(int stateChangeTime) {
		Airport.stateChangeTime = stateChangeTime;
	}

	public static int getFlightTime() {
		return flightTime;
	}

	public static void setFlightTime(int flightTime) {
		Airport.flightTime = flightTime;
	}

	public static void currentStatus(int source, int destination) {
		
		if(source == destination) {
			return;
		}
		if(loading && source != destination) {
	//		System.out.println(realTime);
			while(realTime % stateChangeTime != 0  && source != destination) {
				realTime++;
			}
			if(realTime % stateChangeTime == 0 && source != destination) {
				loading = false;
				running = true;
			}
		}
		if(running && source != destination) {
	//		System.out.println(realTime);
			realTime += flightTime;
			running = false;
			loading = true;
		}
		
		
	}
	public String toString() {
		return Integer.toString(realTime);
	}


}
