
public class CartridgeClass {

	String client;
	String cartridge;
	String work = "null";
	int sum = 0;

	String[] string_splitter() {
		String workparts[] = work.split("\\+");
		return workparts;
	}

	int amount_calulator() {

		String workparts[] = string_splitter();

		for (int i = 0; i < workparts.length; i++) {
			switch (workparts[i]) {
			case "R":
				sum = sum + 350;
				break;
			case "D":
				sum = sum + 200;
				break;
			case "WB":
				sum = sum + 100;
				break;
			case "DB":
				sum = sum + 100;
				break;
			case "PCR":
				sum = sum + 150;
				break;
			case "MR":
				sum = sum + 200;
				break;
			default:
				System.out.println("OOPS !!! -Invalid work");
			}
		}

		return sum;

	}
}
