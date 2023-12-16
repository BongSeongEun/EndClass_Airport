public class Reservation {
   private int reservationId;
   private int MemberId;
   private int FlightId;
   private String SeatSelection;

   public int getReservationId() {
      return reservationId;
   }

   public void setReservationId(int reservationId) {
      this.reservationId = reservationId;
   }

   public int getUserId() {
      return MemberId;
   }

   public void setMemberId(int MemberId) {
      this.MemberId = MemberId;
   }

   public int getFlightId() {
      return FlightId;
   }

   public void setFlightId(int FlightId) {
      this.FlightId = FlightId;
   }

   public String getSeatSelection() {
      return SeatSelection;
   }

   public void setSeatSelection(String SeatSelection) {
      this.SeatSelection = SeatSelection;
   }

}