
public class ShapesMain {

	public static void main(String[] args) {
		Shapes[] shapes = new Shapes[3];
		shapes[0] = new Triangle();
		shapes[1] = new Square();
		shapes[2] = new Pentagon();

		Display d = new Display(shapes);
			d.render();
	}
}
