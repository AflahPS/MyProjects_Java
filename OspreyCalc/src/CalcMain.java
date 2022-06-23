import java.util.Scanner;

public class CalcMain {

	public static void main(String arr[]) {

		Scanner input = new Scanner(System.in);

		System.out.println("How much cartridge you want to enter : \t");

		int no_cart = input.nextInt();

		CartridgeClass[] cartridge = new CartridgeClass[no_cart];

		for (int i = 0; i < no_cart; i++) {

			cartridge[i] = new CartridgeClass();

			System.out.println("Please enter the cartridge-" + (i + 1) + " details\n");

			System.out.println("Client name : \t");

			String client_in = input.nextLine();

			System.out.println("Cartridge name (eg:88a): \t\n");

			String cartridge_in = input.nextLine();

			System.out.println("Work done:\n" + "R-Refill Toner\n" + "D-Drum change\n" + "WB-Wiper blade change\n"
					+ "DB-Doctor blade change\n" + "PCR-PCR change\n" + "MR-Magnetic Roller change\n"
					+ "  (eg:R+D): \t\n");

			String work_in = input.nextLine();

			cartridge[i].client = client_in;
			cartridge[i].cartridge = cartridge_in;
			cartridge[i].work = work_in;

			System.out.println("Total amout for cartridge-" 
					+ (i + 1) +": "+cartridge[i].client + " "+ cartridge[i].cartridge
					+ " is RS " 
					+ cartridge[i].amount_calulator());
		}

	}
}
