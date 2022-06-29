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

	String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	String[][] buttonLabel = { { "7", "4", "1", "." }, { "8", "5", "2", "0" }, { "9", "6", "3", "=" },
			{ "/", "x", "-", "+" }, { "C", "x\u00b2", "\u221ax", "1/x" } };

	HashMap<String, JButton> buttonDict = new HashMap<>();

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
	int numberFontSize = 25;
	int operatorFontSize = 15;

	public Calculator() {

		jf.setLayout(null);
		jf.setBounds(100, 100, 567, 567);
		jf.getContentPane().setBackground(Color.DARK_GRAY);

		for (int i = 0; i < buttonLabel.length; ++i) {
			for (int j = 0; j < buttonLabel[0].length; ++j) {
				JButton temp = new JButton(buttonLabel[i][j]);
				temp.setBounds(x + i * offset, y + j * offset, SIZE, SIZE);
				temp.setBackground(Arrays.asList(numbers).contains(buttonLabel[i][j]) ? Color.PINK : Color.LIGHT_GRAY);
				temp.addActionListener(this);
				temp.setFont(Arrays.asList(numbers).contains(buttonLabel[i][j]) ? new Font( "Arial", Font.PLAIN, numberFontSize) :new Font( "Arial", Font.PLAIN, operatorFontSize));
				jf.add(temp);
				buttonDict.put(buttonLabel[i][j], temp);
			}

		}

		if (isOperatorClicked) {
			isDotPressed = false;
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
		for (int i = 0; i < buttonLabel.length; ++i) {
			for (int j = 0; j < buttonLabel[0].length; ++j) {

				// check if operator;

				if (e.getSource() == buttonDict.get(buttonLabel[i][j]) && e.getSource() == buttonDict.get("0")) {
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
					
					System.out.println(displayLabel.getText());
					break;
				}

				if (e.getSource() == buttonDict.get(buttonLabel[i][j])
						&& Arrays.asList(numbers).contains(buttonLabel[i][j]) && e.getSource() != buttonDict.get("0")) {
					if (isOperatorClicked) {
						displayLabel.setText(buttonLabel[i][j]);
						isOperatorClicked = false;
					} else {
						displayLabel.setText(displayLabel.getText() + buttonLabel[i][j]);
					}
					
					break;
				}
				if (e.getSource() == buttonDict.get("/")) {
					isOperatorClicked = true;
					currentOperator = "/";
					oldValue = displayLabel.getText();
				} else if (e.getSource() == buttonDict.get("x")) {
					isOperatorClicked = true;
					currentOperator = "x";
					oldValue = displayLabel.getText();
					
				} else if (e.getSource() == buttonDict.get("-")) {
					isOperatorClicked = true;
					currentOperator = "-";
					oldValue = displayLabel.getText();
				} else if (e.getSource() == buttonDict.get("+")) {
					isOperatorClicked = true;
					currentOperator = "+";
					oldValue = displayLabel.getText();
				} else if (e.getSource() == buttonDict.get("C")) {
					isOperatorClicked = false;
					isDotPressed=false;
					displayLabel.setText("");
				}

				else if (e.getSource() == buttonDict.get("x\u00b2")) {
					isOperatorClicked = true;
					oldValue = displayLabel.getText();
					result = Math.pow(Float.parseFloat(oldValue),2);
					displayLabel.setText(result + "");
					oldValue = "0";
					break;
				} else if (e.getSource() == buttonDict.get("\u221ax")) {
					isOperatorClicked = true;
					oldValue = displayLabel.getText();
					result = Math.pow(Float.parseFloat(oldValue), .5);
					displayLabel.setText(result + "");
					oldValue = "0";
					break;
				} else if (e.getSource() == buttonDict.get(".")) {
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
					break;
				} else if (e.getSource() == buttonDict.get("1/x")) {
					isOperatorClicked = true;
					oldValue = displayLabel.getText();
					result =(1 / (Float.parseFloat(oldValue)));
					result=Math.floor(result*1e4)/1e4;
					displayLabel.setText(result + "");
					oldValue = "0";
					break;
				} else if (e.getSource() == buttonDict.get("=")) {
					if (currentOperator == "/") {
						newValue = displayLabel.getText();
						result = Float.parseFloat(oldValue) / Float.parseFloat(newValue);
						result=Math.floor(result*1e4)/1e4;
						displayLabel.setText(result + "");

						oldValue = "0";
						newValue = "0";
						currentOperator = "null";
						isOperatorClicked = true;
					} else if (currentOperator == "x") {

						newValue = displayLabel.getText();
						result = Float.parseFloat(oldValue) * Float.parseFloat(newValue);
						result=Math.floor(result*1e4)/1e4;
						displayLabel.setText(result + "");

						oldValue = "0";
						newValue = "0";
						currentOperator = "null";
						isOperatorClicked = true;
					} else if (currentOperator == "-") {
						newValue = displayLabel.getText();
						result = Float.parseFloat(oldValue) - Float.parseFloat(newValue);
						result=Math.floor(result*1e4)/1e4;
						displayLabel.setText(result + "");

						oldValue = "0";
						newValue = "0";
						currentOperator = "null";
						isOperatorClicked = true;
					} else if (currentOperator == "+") {
						newValue = displayLabel.getText();
						result = Float.parseFloat(oldValue) + Float.parseFloat(newValue);
						result=Math.floor(result*1e4)/1e4;
						displayLabel.setText(result + "");

						oldValue = "0";
						newValue = "0";
						currentOperator = "null";
						isOperatorClicked = true;

					}
				}

			}

		}

	}
}