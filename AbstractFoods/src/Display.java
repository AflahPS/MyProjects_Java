
public class Display {
	Food[] foods;

	Display(Food[] foods) {

		this.foods = foods;

	}

	void display() {
		for (int i = 0; i < foods.length; i++) {
			foods[i].Taste();

		}

	}

}
