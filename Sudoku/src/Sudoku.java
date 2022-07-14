import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Sudoku implements ActionListener {

    JFrame frame= new JFrame("SUDOKU");
    JTextField[] buttons = new JTextField[9];
    JButton solveButton= new JButton("SOLVE");
    JButton resetButton= new JButton("RESET");
    JLabel label= new JLabel("WELCOME TO SUDOKU SOLVER");
    

    String[][] fieldLabel ={
        {"11","12","13"},
        {"21","22","23"},
        {"31","32","33"}
    };

    int[][] enteredNums ={
        {0,0,0},
        {0,0,0},
        {0,0,0}
    };
    String[][] solvedArray={
        {"11","12","13"},
        {"21","22","23"},
        {"31","32","33"}
    };
     HashMap<String,JTextField> fieldLabelDict = new HashMap<>();

    public void sudokuSolver(int[][] solverArray) {
        solverArray = this.enteredNums;
        for(int i=0;i<solverArray.length;i++){
            for (int j=0;j<solverArray[0].length;j++){
                if(solverArray[i][j]==0){
                    if(solverArray[i][0]!=1 && solverArray[i][1]!=1 && solverArray[i][2]!=1 
                        && solverArray[0][j]!=1 && solverArray[1][j]!=1 && solverArray[2][j]!=1){
                        solverArray[i][j]=1;
                        continue;
                    }else if(solverArray[i][0]!=2 && solverArray[i][1]!=2 && solverArray[i][2]!=2 
                        && solverArray[0][j]!=2 && solverArray[1][j]!=2 && solverArray[2][j]!=2){
                        solverArray[i][j]=2;
                        continue;
                    }else if(solverArray[i][0]!=3 && solverArray[i][1]!=3 && solverArray[i][2]!=3 
                        && solverArray[0][j]!=3 && solverArray[1][j]!=3 && solverArray[2][j]!=3){
                        solverArray[i][j]=3;
                        continue;
                    }
                }
            }
        }
        for(int i=0;i<solverArray.length;i++){
            for (int j=0;j<solverArray[0].length;j++){
                this.solvedArray[i][j]=String.valueOf(solverArray[i][j]);
            }
        }
    }
    public Sudoku(){
        frame.setBounds(100,100,500,500);
        frame.setLayout(null);
        frame.setForeground(Color.DARK_GRAY);

        label.setBounds(50, 25, 400, 50);
        label.setFont(new Font("Arial",Font.PLAIN,20));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.DARK_GRAY);
        label.setBackground(new Color(0xcc99ff));
        label.setOpaque(true);
        frame.add(label);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                JTextField temp= new JTextField("0");
                temp.setLocation((j+1)*100,(i+1)*100);
                temp.setSize(100,100);
                temp.setFont(new Font("Arial",Font.BOLD,25));
                temp.setHorizontalAlignment(JTextField.CENTER);
                temp.setBackground(new Color(0xccccff));
                temp.setForeground(Color.DARK_GRAY);
                temp.addActionListener(this);
                frame.add(temp);
                fieldLabelDict.put(fieldLabel[i][j], temp);
            }
        }
        solveButton.setLocation(75,425);
        solveButton.setSize(150,40);
        solveButton.setBackground(Color.LIGHT_GRAY);
        solveButton.addActionListener(this);
        frame.add(solveButton);
        resetButton.setLocation(275,425);
        resetButton.setSize(150,40);
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.addActionListener(this);
        frame.add(resetButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        
        new Sudoku();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==solveButton){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(Integer.parseInt(fieldLabelDict.get(fieldLabel[i][j]).getText())>3 
                || Integer.parseInt(fieldLabelDict.get(fieldLabel[i][j]).getText())<0){
                    fieldLabelDict.get(fieldLabel[i][j]).setText("1-3");
                    continue;
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                enteredNums[i][j] = Integer.parseInt(fieldLabelDict.get(fieldLabel[i][j]).getText());
            }
        }
        sudokuSolver(enteredNums);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                fieldLabelDict.get(fieldLabel[i][j]).setText(solvedArray[i][j]);
                }
            }
        label.setText("CONGRATULATION !!!");
        }
        else if (e.getSource()==resetButton){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    fieldLabelDict.get(fieldLabel[i][j]).setText("0");
                }
            }
            label.setText("WELCOME TO SUDOKU SOLVER");
        }
    }
}
