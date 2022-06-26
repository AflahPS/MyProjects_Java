import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {

	JLabel displayLabel;

	JButton sevenButton;
	JButton eightButton;
	JButton nineButton;
	JButton devideButton;
	JButton clearButton;
	JButton fourButton;
	JButton fiveButton;
	JButton sixButton;
	JButton multiplyButton;
	JButton squareButton;
	JButton oneButton;
	JButton twoButton;
	JButton threeButton;
	JButton minusButton;
	JButton squareRootButton;
	JButton dotButton;
	JButton zeroButton;
	JButton equalButton;
	JButton plusButton;
	JButton oneByButton;

	JButton[] buttons = new JButton[20];
	String[] numbers = {
			"0",
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
	};

	String[][] buttonLabel = {
			{ "7", "8", "9", "/", "C" },
			{ "4", "5", "6", "x", "x\\u00b2" },
			{ "1", "2", "3", "-", "\\u221ax" },
			{ ".", "0", "=", "+", "1/x" }
	};
	JFrame jf = new JFrame();

	boolean isOperatorClicked = false;
	boolean isDotPressed = false;
	String currentOperator = "null";
	String oldValue = "0";
	String newValue = "0";
	double result = 0;
	final int SIZE = 57;
	int x = 64;
	int y = 161;
	int offset = 95;
	int fontSize =12;

	public Calculator() {

		jf.setLayout(null);
		jf.setBounds(100, 100, 567, 567);
		jf.getContentPane().setBackground(Color.DARK_GRAY);
		int row = 0;
		for (int i = 0; i < buttonLabel[0].length; ++i) {
			for (int j = 0; j < buttonLabel.length; ++j) {
				String label = buttonLabel[j][i];
				buttons[row] = new JButton(label);
				buttons[row].setBounds(x + i * offset, y + j * offset, SIZE, SIZE);
				buttons[row].setBackground(Arrays.asList(numbers).contains(label) ? Color.PINK : Color.LIGHT_GRAY);
				buttons[row].addActionListener(this);
				buttons[row].setFont(new Font("Arial", Font.PLAIN, fontSize));
				jf.add(buttons[row]);
				row++;
			}
		}

		displayLabel = new JLabel();
		displayLabel.setBounds(64, 28, 435, 76);
		displayLabel.setForeground(Color.black);
		displayLabel.setBackground(Color.lightGray);
		displayLabel.setFont(new Font("Amiri", Font.PLAIN, 30));

		displayLabel.setOpaque(true);
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		jf.add(displayLabel);

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (isOperatorClicked) {
			isDotPressed = false;
		}

		// 7
		if (e.getSource() == sevenButton) {
			if (isOperatorClicked) {
				displayLabel.setText("7");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "7");
			}
		}
		// 8
		else if (e.getSource() == eightButton) {
			if (isOperatorClicked) {
				displayLabel.setText("8");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "8");
			}
		}
		// 9
		else if (e.getSource() == nineButton) {
			if (isOperatorClicked) {
				displayLabel.setText("9");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "9");
			}
		}
		// division
		else if (e.getSource() == devideButton) {
			isOperatorClicked = true;
			currentOperator = "/";
			oldValue = displayLabel.getText();

		}
		// clear
		else if (e.getSource() == clearButton) {
			displayLabel.setText("");
			isOperatorClicked = false;
		}
		// 4
		else if (e.getSource() == fourButton) {
			if (isOperatorClicked) {
				displayLabel.setText("4");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "4");
			}
		}
		// 5
		else if (e.getSource() == fiveButton) {
			if (isOperatorClicked) {
				displayLabel.setText("5");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "5");
			}
		}
		// 6
		else if (e.getSource() == sixButton) {
			if (isOperatorClicked) {
				displayLabel.setText("6");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "6");
			}
		}
		// multiply
		else if (e.getSource() == multiplyButton) {
			isOperatorClicked = true;
			currentOperator = "x";
			oldValue = displayLabel.getText();

		}
		// Square
		else if (e.getSource() == squareButton) {
			isOperatorClicked = true;
			oldValue = displayLabel.getText();
			result = Math.pow(Float.parseFloat(oldValue), 2);
			displayLabel.setText(result + "");
			oldValue = "0";

		}
		// 1
		else if (e.getSource() == oneButton) {
			if (isOperatorClicked) {
				displayLabel.setText("1");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "1");
			}
		}
		// 2
		else if (e.getSource() == twoButton) {
			if (isOperatorClicked) {
				displayLabel.setText("2");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "2");
			}
		}
		// 3
		else if (e.getSource() == threeButton) {
			if (isOperatorClicked) {
				displayLabel.setText("3");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "3");
			}
		}
		// Subtraction
		else if (e.getSource() == minusButton) {
			isOperatorClicked = true;
			currentOperator = "-";
			oldValue = displayLabel.getText();
		}
		// SquareRoot
		else if (e.getSource() == squareRootButton) {
			isOperatorClicked = true;
			oldValue = displayLabel.getText();
			result = Math.pow(Float.parseFloat(oldValue), .5);
			displayLabel.setText(result + "");
			oldValue = "0";
		}
		// Dot
		else if (e.getSource() == dotButton) {
			if (isOperatorClicked) {
				displayLabel.setText(".");
				isDotPressed = true;
				isOperatorClicked = false;

			} else {
				if (isDotPressed == false) {
					displayLabel.setText(displayLabel.getText() + ".");
					isDotPressed = true;
				} else {
					displayLabel.setText(displayLabel.getText());
				}

			}
		}
		// Zero
		else if (e.getSource() == zeroButton) {
			if (isOperatorClicked) {
				displayLabel.setText("0");
			} else {
				if (displayLabel.getText() == "0") {
					displayLabel.setText("0");
				}

				else {
					displayLabel.setText(displayLabel.getText() + "0");
				}
			}
		}

		// Addition
		else if (e.getSource() == plusButton) {
			isOperatorClicked = true;
			currentOperator = "+";
			oldValue = displayLabel.getText();
		}
		// OneBy
		else if (e.getSource() == oneByButton) {
			isOperatorClicked = true;
			oldValue = displayLabel.getText();
			result = 1 / (Float.parseFloat(oldValue));
			displayLabel.setText(result + "");
			oldValue = "0";
		}

		// Equal
		else if (e.getSource() == equalButton) {
			if (currentOperator == "/") {
				newValue = displayLabel.getText();
				result = Float.parseFloat(oldValue) / Float.parseFloat(newValue);
				displayLabel.setText(result + "");

				oldValue = "0";
				newValue = "0";
				currentOperator = "null";
				isOperatorClicked = true;
			} else if (currentOperator == "x") {

				newValue = displayLabel.getText();
				result = Float.parseFloat(oldValue) * Float.parseFloat(newValue);
				displayLabel.setText(result + "");

				oldValue = "0";
				newValue = "0";
				currentOperator = "null";
				isOperatorClicked = true;
			} else if (currentOperator == "-") {
				newValue = displayLabel.getText();
				result = Float.parseFloat(oldValue) - Float.parseFloat(newValue);
				displayLabel.setText(result + "");

				oldValue = "0";
				newValue = "0";
				currentOperator = "null";
				isOperatorClicked = true;
			} else if (currentOperator == "+") {
				newValue = displayLabel.getText();
				result = Float.parseFloat(oldValue) + Float.parseFloat(newValue);
				displayLabel.setText(result + "");

				oldValue = "0";
				newValue = "0";
				currentOperator = "null";
				isOperatorClicked = true;

			}
		}
	}
}