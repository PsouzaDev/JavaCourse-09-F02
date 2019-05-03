package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditure;

	public Individual() {
		super();
	}

	public Individual(String name, Double income, Double healthExpenditure) {
		super(name, income);
		this.healthExpenditure = healthExpenditure;
	}

	public Double getHealthExpenditure() {
		return healthExpenditure;
	}

	public void setHealthExpenditure(Double healthExpenditure) {
		this.healthExpenditure = healthExpenditure;
	}

	@Override
	public Double taxPaid() {
		double taxAmount;
		double descont = healthExpenditure * 0.50;
		if (super.getIncome() < 20000) {
			taxAmount = super.getIncome() * 0.15;
		} else {
			taxAmount = super.getIncome() * 0.25;
		}
		return taxAmount- descont;
	}

}
