package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of tax payers: ");
		int numberOfTaxPayer = sc.nextInt();

		List<TaxPayer> list = new ArrayList<TaxPayer>();

		for (int i = 0; i < numberOfTaxPayer; i++) {

			System.out.println("Tax payer #" + (i + 1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double income = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditure = sc.nextDouble();
				list.add(new Individual(name, income, healthExpenditure));
			} else {
				System.out.print("Number of employees: ");
				double numberOfEmployee = sc.nextDouble();
				list.add(new Company(name, income, numberOfEmployee));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID:");

		for (TaxPayer c : list) {
			System.out.println(c.getName() + ": $ " + String.format("%.2f", c.taxPaid()));
		}

		double sum = 0;
		for (TaxPayer c : list) {
			sum += c.taxPaid();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

		sc.close();

	}

}
