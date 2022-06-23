
public class Display {

	Shapes[] shapes;

	Display(Shapes[] shapes) {

		this.shapes = shapes;

	}

	void render() {

		for (int i = 0; i < shapes.length; i++) {
			shapes[i].render();

		}
	}

}
