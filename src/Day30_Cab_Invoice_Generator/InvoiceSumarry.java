package Day30_Cab_Invoice_Generator;

public class InvoiceSumarry {

	public double totalFare;
	public int length;

	public InvoiceSumarry(double totalFare, int length) {
		this.totalFare = totalFare;
		this.length = length;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InvoiceSumarry that = (InvoiceSumarry) o;
		return Double.compare(that.totalFare, totalFare) == 0 && length == that.length;
	}
}
