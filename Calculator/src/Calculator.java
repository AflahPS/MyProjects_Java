import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	boolean isOperatorClicked = false;
	boolean isDotPressed = false;
	String currentOperator = "null";
	String oldValue = "0";
	String newValue = "0";
	double result = 0;

	public Calculator() {

		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setBounds(100, 100, 567, 567);
		jf.getContentPane().setBackground(Color.DARK_GRAY);

		displayLabel = new JLabel();
		displayLabel.setBounds(64, 28, 435, 76);
		displayLabel.setForeground(Color.black);
		displayLabel.setBackground(Color.lightGray);
		displayLabel.setFont(new Font("Amiri", Font.PLAIN, 30));

		displayLabel.setOpaque(true);
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		jf.add(displayLabel);

		// Define 7
		sevenButton = new JButton("7");
		sevenButton.setBounds(64, 161, 57, 57);
		sevenButton.setBackground(Color.LIGHT_GRAY);
		sevenButton.setForeground(Color.DARK_GRAY);
		sevenButton.addActionListener(this);
		sevenButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(sevenButton);

		// Define 8
		eightButton = new JButton("8");
		eightButton.setBounds(159, 161, 57, 57);
		eightButton.setBackground(Color.LIGHT_GRAY);
		eightButton.setForeground(Color.DARK_GRAY);
		eightButton.addActionListener(this);
		eightButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(eightButton);

		// Define 9
		nineButton = new JButton("9");
		nineButton.setBounds(254, 161, 57, 57);
		nineButton.setBackground(Color.LIGHT_GRAY);
		nineButton.setForeground(Color.DARK_GRAY);
		nineButton.addActionListener(this);
		nineButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(nineButton);

		// Define '/'
		devideButton = new JButton("/");
		devideButton.setBounds(349, 161, 57, 57);
		devideButton.setBackground(Color.PINK);
		devideButton.addActionListener(this);
		devideButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(devideButton);

		// Define CLear
		clearButton = new JButton("C");
		clearButton.setBounds(444, 161, 57, 57);
		clearButton.setBackground(Color.white);
		clearButton.addActionListener(this);
		clearButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(clearButton);

		// Define 4
		fourButton = new JButton("4");
		fourButton.setBounds(64, 256, 57, 57);
		fourButton.setBackground(Color.LIGHT_GRAY);
		fourButton.setForeground(Color.DARK_GRAY);
		fourButton.addActionListener(this);
		fourButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(fourButton);

		// Define 5
		fiveButton = new JButton("5");
		fiveButton.setBounds(159, 256, 57, 57);
		fiveButton.setBackground(Color.LIGHT_GRAY);
		fiveButton.setForeground(Color.DARK_GRAY);
		fiveButton.addActionListener(this);
		fiveButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(fiveButton);

		// Define 6
		sixButton = new JButton("6");
		sixButton.setBounds(254, 256, 57, 57);
		sixButton.setBackground(Color.LIGHT_GRAY);
		sixButton.setForeground(Color.DARK_GRAY);
		sixButton.addActionListener(this);
		sixButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(sixButton);

		// Define x
		multiplyButton = new JButton("x");
		multiplyButton.setBounds(349, 256, 57, 57);
		multiplyButton.setBackground(Color.pink);
		multiplyButton.addActionListener(this);
		multiplyButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(multiplyButton);

		// Define Square
		squareButton = new JButton("x\u00b2");
		squareButton.setBounds(444, 256, 57, 57);
		squareButton.setBackground(Color.pink);
		squareButton.addActionListener(this);
		squareButton.setFont(new Font("Arial", Font.BOLD, 15));

		jf.add(squareButton);

		// Define 1
		oneButton = new JButton("1");
		oneButton.setBounds(64, 351, 57, 57);
		oneButton.setBackground(Color.LIGHT_GRAY);
		oneButton.setForeground(Color.DARK_GRAY);
		oneButton.addActionListener(this);
		oneButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(oneButton);

		// Define 2
		twoButton = new JButton("2");
		twoButton.setBounds(159, 351, 57, 57);
		twoButton.setBackground(Color.LIGHT_GRAY);
		twoButton.setForeground(Color.DARK_GRAY);
		twoButton.addActionListener(this);
		twoButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(twoButton);

		// Define 3
		threeButton = new JButton("3");
		threeButton.setBounds(254, 351, 57, 57);
		threeButton.setBackground(Color.LIGHT_GRAY);
		threeButton.setForeground(Color.DARK_GRAY);
		threeButton.addActionListener(this);
		threeButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(threeButton);

		// Define '-'
		minusButton = new JButton("-");
		minusButton.setBounds(349, 351, 57, 57);
		minusButton.setBackground(Color.pink);
		minusButton.addActionListener(this);
		minusButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(minusButton);

		// Define SquareRoot
		squareRootButton = new JButton("\u221ax");
		squareRootButton.setBounds(444, 351, 57, 57);
		squareRootButton.setBackground(Color.pink);
		squareRootButton.addActionListener(this);
		squareRootButton.setFont(new Font("Arial", Font.BOLD, 15));

		jf.add(squareRootButton);

		// Define dot
		dotButton = new JButton(".");
		dotButton.setBounds(64, 446, 57, 57);
		dotButton.setBackground(Color.LIGHT_GRAY);
		dotButton.setForeground(Color.DARK_GRAY);
		dotButton.addActionListener(this);
		dotButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(dotButton);

		// Define 0
		zeroButton = new JButton("0");
		zeroButton.setBounds(159, 446, 57, 57);
		zeroButton.setBackground(Color.LIGHT_GRAY);
		zeroButton.setForeground(Color.DARK_GRAY);
		zeroButton.addActionListener(this);
		zeroButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(zeroButton);

		// Define =
		equalButton = new JButton("=");
		equalButton.setBounds(254, 446, 57, 57);
		equalButton.setBackground(Color.pink);
		equalButton.addActionListener(this);
		equalButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(equalButton);

		// Define +
		plusButton = new JButton("+");
		plusButton.setBounds(349, 446, 57, 57);
		plusButton.setBackground(Color.pink);
		plusButton.addActionListener(this);
		plusButton.setFont(new Font("Arial", Font.PLAIN, 30));

		jf.add(plusButton);

		// Define OneBy
		oneByButton = new JButton("1/x");
		oneByButton.setBounds(444, 446, 57, 57);
		oneByButton.setBackground(Color.pink);
		oneByButton.addActionListener(this);
		oneByButton.setFont(new Font("Arial", Font.BOLD, 15));

		jf.add(oneByButton);

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