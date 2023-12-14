public class Reservation {
	private int reservationId;
	private String MemberId;
	private int FlightId;
	private int SeatSelection;

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getUserId() {
		return MemberId;
	}

	public void setMemberId(String MemberId) {
		this.MemberId = MemberId;
	}

	public int getFlightId() {
		return FlightId;
	}

	public void setFlightId(int FlightId) {
		this.FlightId = FlightId;
	}

	public int getSeatSelection() {
		return SeatSelection;
	}

	public void setSeatSelection(int SeatSelection) {
		this.SeatSelection = SeatSelection;
	}

	


}