package model;

public class UnsysnchBankTest {
	public static final int NACCOUNTS = 2;
	public static final double INNITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		Bank b = new Bank(NACCOUNTS, INNITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunable r = new TransferRunable(b, i, INNITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}

}
