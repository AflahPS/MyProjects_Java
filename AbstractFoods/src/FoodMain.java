
public class FoodMain {

	public static void main(String[] args) {

		Food[] foods = new Food[2];
		foods[0] = new LimeJuice();
		foods[1] = new Biriyani();

		Display d = new Display(foods);
		d.display();

	}

}
