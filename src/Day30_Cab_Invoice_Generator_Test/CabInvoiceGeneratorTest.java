package Day30_Cab_Invoice_Generator_Test;

import org.junit.Assert;
import org.junit.Test;

import Day30_Cab_Invoice_Generator.CabInvoiceGenerator;
import Day30_Cab_Invoice_Generator.InvoiceSumarry;
import Day30_Cab_Invoice_Generator.Ride;

public class CabInvoiceGeneratorTest {

	@Test
	public void givenDistanceAndTimeWhenComputedShouldReturnTotalFare() {
		CabInvoiceGenerator invoice = new CabInvoiceGenerator();
		double result = invoice.calculateFare(10, 1);
		Assert.assertEquals(101, result, 0.0);
	}

	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinFare() {
		CabInvoiceGenerator invoice = new CabInvoiceGenerator();
		double result = invoice.calculateFare(0.1, 1);
		Assert.assertEquals(5, result, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnMultipleRides() {
		CabInvoiceGenerator invoice = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double totalFare = invoice.calculateFare(rides);
		Assert.assertEquals(30.0, totalFare, 0.0);
	}

	@Test
	public void invoiceGenerator_ShouldReturnInvoiceSummary() {
		CabInvoiceGenerator invoice = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double totalFare = invoice.calculateFare(rides);
		InvoiceSumarry actualInvoiceSumarry = new InvoiceSumarry(totalFare, rides.length);
		InvoiceSumarry expectedInvoiceSumarry = new InvoiceSumarry(30.0, 2);
		Assert.assertEquals(expectedInvoiceSumarry, actualInvoiceSumarry);
	}

	@Test
	public void givenUserId_shouldReturnInvoiceSummary() {
		CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
		String userId = "sunilgollapalli@gmail.com";
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceGenerator.addRides(userId, rides);
		InvoiceSumarry summary = invoiceGenerator.calculateFare(rides, "normal");
		InvoiceSumarry invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
		Assert.assertEquals(invoiceSummary, summary);
	}
}
