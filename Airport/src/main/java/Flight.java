public class Flight {
	private int flightId;
	private String airline;
	private String departureairport;
	private String arrivalairport;
	private String time;
	private int seat;
	private double price;
	private int selectedseat_num;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airlineId) {
		this.airline = airlineId;
	}

	public String getDepartureairport() {
		return departureairport;
	}

	public void setDepartureairport(String departureairport) {
		this.departureairport = departureairport;
	}

	public String getArrivalairport() {
		return arrivalairport;
	}

	public void setArrivalairport(String arrivalairport) {
		this.arrivalairport = arrivalairport;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSelectedseat_num() {
		return selectedseat_num;
	}

	public void setSelectedseat_num(int selectedseat_num) {
		this.selectedseat_num = selectedseat_num;
	}
}
