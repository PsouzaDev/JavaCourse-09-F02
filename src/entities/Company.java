package entities;

public class Company extends TaxPayer {

	private Double numberOfEmployee;

	public Company() {
		super();
	}

	public Company(String name, Double income, Double numberOfEmployee) {
		super(name, income);
		this.numberOfEmployee = numberOfEmployee;
	}

	public Double getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Double numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	@Override
	public Double taxPaid() {
		double taxAmount;
		if (numberOfEmployee < 10) {
			taxAmount = super.getIncome() * 0.16;
		} else {
			taxAmount = super.getIncome() * 0.14;
		}
		return taxAmount;
	}
	
	
}
