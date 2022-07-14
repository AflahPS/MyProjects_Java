import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Sudoku implements ActionListener {

    JFrame frame= new JFrame("SUDOKU");
    JTextField[] buttons = new JTextField[9];
    JButton playButton= new JButton("PLAY");

    String[][] fieldLabel ={
        {"11","12","13"},
        {"21","22","23"},
        {"31","32","33"}
    };

    String[][] enteredNums ={
        {"0","0","0"},
        {"0","0","0"},
        {"0","0","0"}
    };
    String[][] solvedArray;
    
    HashMap<String,JTextField> fieldLabelDict = new HashMap<>();

    public void sudokuSolver(String[][] solverArray) {
        solverArray = this.enteredNums;
        for(int i=0;i<solverArray.length;i++){
            for (int j=0;j<solverArray[0].length;j++){
                if(solverArray[i][j]=="0"){
                    if(solverArray[i][0]!="1" && solverArray[i][1]!="1" && solverArray[i][2]!="1"
                        && solverArray[0][j]!="1" && solverArray[1][j]!="1" && solverArray[2][j]!="1"){
                        
                            solverArray[i][j]="1";
                            continue;
                    }
                    }else if(solverArray[i][0]!="2" && solverArray[i][1]!="2" && solverArray[i][2]!="2"
                        && solverArray[0][j]!="2" && solverArray[1][j]!="2" && solverArray[2][j]!="2"){
                        
                            solverArray[i][j]="2";
                            continue;
                    
                    }else if(solverArray[i][0]!="3" && solverArray[i][1]!="3" && solverArray[i][2]!="3"
                        && solverArray[0][j]!="3" && solverArray[1][j]!="3" && solverArray[2][j]!="3"){
                        
                            solverArray[i][j]="3";
                            continue;

                    }
                }
            }
            this.solvedArray=solverArray;
        }

    


    public Sudoku(){
        frame.setBounds(100,100,500,500);
        frame.setLayout(null);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                JTextField temp= new JTextField("0");
                temp.setLocation((j+1)*100,(i+1)*100);
                temp.setSize(100,100);
                temp.setFont(new Font("Arial",Font.BOLD,25));
                temp.addActionListener(this);
                frame.add(temp);
                fieldLabelDict.put(fieldLabel[i][j], temp);
            }
        }
        playButton.setLocation(175,425);
        playButton.setSize(150,40);
        playButton.addActionListener(this);
        frame.add(playButton);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        
        new Sudoku();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==playButton){
        playButton.setBackground(Color.green);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                enteredNums[i][j] = fieldLabelDict.get(fieldLabel[i][j]).getText();
                
            }
        }
        sudokuSolver(enteredNums);
       
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                fieldLabelDict.get(fieldLabel[i][j]).setText(solvedArray[i][j]);
                
                }
            }
        }
    }
}
