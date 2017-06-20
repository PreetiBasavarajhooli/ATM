import java.text.NumberFormat;
import java.util.Scanner;

class BankAccount {
	String type;
	double balance;
	double rate;

	void setType(String accounttype) {

		type = accounttype;
	}

	void setBalance(double accountbalance) {

		balance = accountbalance;
	}

	void setRate(double accountrate) {

		rate = accountrate;
	}

	void deposit(double deposit) {

		balance += deposit;
	}

	void withdraw(double wit) {

		balance -= wit;
	}

	String getType() {

		return type;
	}

	double getBalance() {

		return balance;
	}

	double getRate() {

		return rate;
	}

}

public class ATM {

	public static void main(String[] args) {

		BankAccount checking = new BankAccount();
		checking.setType("Checking");
		checking.setBalance(0.00);
		checking.setRate(0.00);

		BankAccount savings = new BankAccount();
		savings.setType("Savings");
		savings.setBalance(0.00);
		savings.setRate(2.00);

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		Scanner input = new Scanner(System.in);

		boolean session = true;

		while (session) {

			System.out.print("========================\n" + "ATM Menu: \n \n" + "1. Deposit Money  \n"
					+ "2. Withdraw Money \n" + "3. Transfer Funds \n" + "4. Check Account Balance\n"
					+ "5. End Session\n" + "========================\n" + "\nEnter selection: ");

			int selection = input.nextInt();
			switch (selection) {

			// case 1 will handle depositing the money

			case 1:
				System.out.print("Enter (1) for Savings or (2) for Checking: ");
				int depAccount = input.nextInt();

				if (depAccount == 1) {

					System.out.println(
							"\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

					System.out.println("How much money would you like to deposit?");
					double deposit = input.nextDouble();

					savings.deposit(deposit);

					System.out
							.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");

				}

				else if (depAccount == 2) {

					System.out.println(
							"\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

					System.out.println("How much money would you like to deposit?");
					double deposit = input.nextDouble();

					checking.deposit(deposit);

					System.out.println("\nChecking balance is now: " + formatter.format(checking.getBalance()) + "\n");

				}

				break;

			// case 2 handles the withdrawal of money

			case 2:
				System.out.print("\nEnter (1) for Savings or (2) for Checking: ");
				int witAccount = input.nextInt(); // Keeps track of which account
												// to withdraw from

				if (witAccount == 1) {

					System.out.println(
							"\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

					System.out.println("How much money would you like to withdraw?");
					double withdraw = input.nextDouble();

					savings.withdraw(withdraw);

					System.out
							.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");

				}

				else if (witAccount == 2) {

					System.out.println(
							"\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

					System.out.println("How much money would you like to withdraw?");
					double withdraw = input.nextDouble();

					checking.withdraw(withdraw);

					System.out.println(
							"\nYour Checking balance is now: " + formatter.format(checking.getBalance()) + "\n");

				}

				break;

			// case 3 will the transfer of funds

			case 3:
				System.out.print(
						"\nFrom which account do you wish to transfer funds from?, (1) for Savings or (2) for Checking: ");
				int tranAccount = input.nextInt();

				if (tranAccount == 1) {

					System.out.println(
							"\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

					System.out.print("How much money do you wish to transfer from Savings to Checking?: ");
					double tranAmount = input.nextDouble();

					savings.withdraw(tranAmount);
					checking.deposit(tranAmount);

					System.out.println("\nYou successfully transferred " + formatter.format(tranAmount)
							+ " from Savings to Checking");

					System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
					System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");

				}

				else if (tranAccount == 2) {

					System.out.println(
							"\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

					System.out.print("How much money do you wish to transfer from Checking to Saving?: ");
					double tranAmount = input.nextDouble();

					checking.withdraw(tranAmount);
					savings.deposit(tranAmount);

					System.out.println("\nYou successfully transferred " + formatter.format(tranAmount)
							+ " from Checking to Savings");

					System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
					System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");

				}

				break;

			// case 4 simply outputs the balances of both Checking and Savings
			// accounts

			case 4:
				System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
				System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");

				break;

			// case 5 breaks out of the (while) loop when the user is finished
			// using the ATM

			case 5:
				session = false;

				break;

			}

		}

		System.out.println("\nThank you for banking with us!\n");

	}

}