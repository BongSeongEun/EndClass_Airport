public class Flight {
	private int airplaneId;
	private String airline;
	private String source;
	private String destination;
	private String time;
	private int seat;
	private double price;
	private int selectedseat_num;

	public int getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(int airplaneId) {
		this.airplaneId = airplaneId;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airlineId) {
		this.airline = airlineId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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
