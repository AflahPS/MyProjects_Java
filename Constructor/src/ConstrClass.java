
public class ConstrClass {

	int a = 200, b = 50, sum;

	int calc1(int a, int b) {
		a = this.a;
		b = this.b;

		int sum = a + b;
		System.out.println("Calc1() returned: " + sum);
		return sum;
	}

	int calc2(int a, int b) {
		sum = a + b;
		System.out.println("Calc2() returned: " + sum);
		return sum;

	}

	ConstrClass(int a, int b) {

		System.out.println("Values passed into Contructor is are "+a+"\t"+b);

	}

}
