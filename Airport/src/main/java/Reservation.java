public class Reservation {
    private int reservationId;
    private int userId;
    private int ticketId;
    private String rseat;
    
    
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	
	public String getRseat() {
		return rseat;
	}
	public void setRseat(String rseat) {
		this.rseat = rseat;
	}
}