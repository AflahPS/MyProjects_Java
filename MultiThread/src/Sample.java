
public class Sample extends Thread {

	int a;

	Sample(int a) {
		this.a = a;
		{
		}

	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
//For Checking the variation
			if (i == 1) {
				this.print123();
			} else if (i == 3) {
				this.printabc();
			} else if (i == 5) {
				this.printsum();
			}
//Print function
			System.out.println("Thread " + i + "Object " + a);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
// Additional functions
	public void print123() {
		System.out.println("123");
	}

	public void printabc() {
		System.out.println("abcsca");
	}

	public void printsum() {
		int sum = 13346 + 564 * 44;
		System.out.println("Sum is " + sum);
	}
}
