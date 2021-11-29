package Day30_Cab_Invoice_Generator;

public class CabInvoiceGenerator {

	private static final double COST_PER_KM = 10.0;
	private static final int COST_PER_TIME = 1;
	private static final int MINIMUM_FARE = 5;

	private RideRepository rideRepository;

	public double calculateFare(double distance, double time) {
		double calculate_Fare = (distance * COST_PER_KM) + (time * COST_PER_TIME);
		if (calculate_Fare < MINIMUM_FARE) {
			return MINIMUM_FARE;
		} else
			return calculate_Fare;
	}

	public double calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	public CabInvoiceGenerator() {
		this.rideRepository = new RideRepository();
	}

	public InvoiceSumarry calculateFare(Ride[] rides, String type) {

		double totalFare = 0;
		if (type == "normal") {
			for (Ride ride : rides) {
				totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
			}
			return new InvoiceSumarry(totalFare, rides.length);
		} else {
			for (Ride ride : rides) {
				totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
			}
			return new InvoiceSumarry(totalFare, rides.length);
		}
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRide(userId, rides);
	}

	public InvoiceSumarry getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId), "normal");
	}

}
