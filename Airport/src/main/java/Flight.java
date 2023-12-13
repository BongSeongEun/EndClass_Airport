public class Flight {
    private int ticketId;
    
    private String airlineId;
    private String source;
    private String destination;
    private String time;
    private String seat;
    private double price;
    
    
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int flightId) {
		this.ticketId = flightId;
	}
	
	
	public String getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
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
	
	
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
