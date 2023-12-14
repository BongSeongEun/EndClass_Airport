public class Reservation {
	private int reservationId;
	private String userId;
	private int airplaneId;
	private int rseat;

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(int airplaneId) {
		this.airplaneId = airplaneId;
	}

	public int getRseat() {
		return rseat;
	}

	public void setRseat(int rseat) {
		this.rseat = rseat;
	}
}