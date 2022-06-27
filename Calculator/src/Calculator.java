import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {

	JLabel displayLabel;

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
			{ "4", "5", "6", "x", "x\u00b2" },
			{ "1", "2", "3", "-", "x\u221ax" },
			{ ".", "0", "=", "+", "1/x" }
	};
	
	HashMap<String, String> buttonDict = new HashMap<>();
	
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
	int fontSize =22;

	public Calculator() {

		jf.setLayout(null);
		jf.setBounds(100, 100, 567, 567);
		jf.getContentPane().setBackground(Color.DARK_GRAY);
		
		buttonDict.put("sevenButton",buttonLabel[0][0]);
		buttonDict.put("eightButton",buttonLabel[0][1]);
		buttonDict.put("nineButton",buttonLabel[0][2]);
		buttonDict.put("devideButton",buttonLabel[0][3]);
		buttonDict.put("clearutton",buttonLabel[0][4]);
		buttonDict.put("fourButton",buttonLabel[1][0]);
		buttonDict.put("fiveButton",buttonLabel[1][1]);
		buttonDict.put("sixButton",buttonLabel[1][2]);
		buttonDict.put("multiplyButton",buttonLabel[1][3]);
		buttonDict.put("squareButton",buttonLabel[1][4]);
		buttonDict.put("oneButton",buttonLabel[2][0]);
		buttonDict.put("twoButton",buttonLabel[2][1]);
		buttonDict.put("threeButton",buttonLabel[2][2]);
		buttonDict.put("minusButton",buttonLabel[2][3]);
		buttonDict.put("squareRootButton",buttonLabel[2][4]);
		buttonDict.put("dotButton",buttonLabel[3][0]);
		buttonDict.put("zeroButton",buttonLabel[3][1]);
		buttonDict.put("equalButton",buttonLabel[3][2]);
		buttonDict.put("plusButton",buttonLabel[3][3]);
		buttonDict.put("oneByButton",buttonLabel[3][4]);
				
		
		
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
		
		for (int i=1;i<10;i++) {
			if (e.getSource() ==i+"" )
				if (isOperatorClicked) {
					displayLabel.setText(""+i);
					isOperatorClicked = false;
				} else {
					displayLabel.setText(displayLabel.getText() + i);
				}
		}
		
		
		if (e.getSource() == buttonDict.get("sevenButton"));
			if (isOperatorClicked) {
				displayLabel.setText("7");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "7");
			}
			
		if (e.getSource() == buttonDict.get("eightButton"));
			if (isOperatorClicked) {
				displayLabel.setText("8");
				isOperatorClicked = false;
			} else {
				displayLabel.setText(displayLabel.getText() + "8");
			}

		
		// division
		 if (e.getSource() == buttonDict.get("devideButton")) {
			isOperatorClicked = true;
			currentOperator = "/";
			oldValue = displayLabel.getText();

		}
		// clear
		else if (e.getSource() == buttonDict.get("clearButton")){
			displayLabel.setText("");
			isOperatorClicked = false;
		}
		
		// multiply
		else if (e.getSource() == buttonDict.get("multiplyButton")) {
			isOperatorClicked = true;
			currentOperator = "x";
			oldValue = displayLabel.getText();

		}
		// Square
		else if (e.getSource() == buttonDict.get("squareButton")) {
			isOperatorClicked = true;
			oldValue = displayLabel.getText();
			result = Math.pow(Float.parseFloat(oldValue), 2);
			displayLabel.setText(result + "");
			oldValue = "0";

		}
		
		// Subtraction
		else if (e.getSource() == buttonDict.get("minusButton")) {
			isOperatorClicked = true;
			currentOperator = "-";
			oldValue = displayLabel.getText();
		}
		// SquareRoot
		else if (e.getSource() == buttonDict.get("squareRootButton")) {
			isOperatorClicked = true;
			oldValue = displayLabel.getText();
			result = Math.pow(Float.parseFloat(oldValue), .5);
			displayLabel.setText(result + "");
			oldValue = "0";
		}
		// Dot
		else if (e.getSource() == buttonDict.get("dotButton")) {
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
		else if (e.getSource() == buttonDict.get("zeroButton")) {
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
		else if (e.getSource() == buttonDict.get("plusButton")) {
			isOperatorClicked = true;
			currentOperator = "+";
			oldValue = displayLabel.getText();
		}
		// OneBy
		else if (e.getSource() == buttonDict.get("oneByButton")) {
			isOperatorClicked = true;
			oldValue = displayLabel.getText();
			result = 1 / (Float.parseFloat(oldValue));
			displayLabel.setText(result + "");
			oldValue = "0";
		}

		// Equal
		else if (e.getSource() == buttonDict.get("equalButton")) {
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