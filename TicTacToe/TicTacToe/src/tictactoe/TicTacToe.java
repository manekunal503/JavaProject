/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Button;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

/**
 *
 * @author bismeet
 */
public class TicTacToe extends java.awt.Frame implements ActionListener {

    static TextField arr[][];
    private TextField cell1;
    private TextField cell2;
    private TextField cell3;
    private TextField cell4;
    private TextField cell5;
    private TextField cell6;
    private TextField cell7;
    private TextField cell8;
    private TextField cell9;
    private Button reset;
    private Panel panel1;
    private static TextField status;
    static char turn = 'X';

    /**
     * Creates new form TicTac
     */
    public TicTacToe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panel1 = new java.awt.Panel();
        cell1 = new java.awt.TextField();
        cell2 = new java.awt.TextField();
        cell3 = new java.awt.TextField();
        cell4 = new java.awt.TextField();
        cell5 = new java.awt.TextField();
        cell6 = new java.awt.TextField();
        cell7 = new java.awt.TextField();
        cell8 = new java.awt.TextField();
        cell9 = new java.awt.TextField();
        status = new TextField();
//        cell1.addActionListener(this);
//        cell2.addActionListener(this);
//        cell3.addActionListener(this);
//        cell4.addActionListener(this);
//        cell5.addActionListener(this);
//        cell6.addActionListener(this);
//        cell7.addActionListener(this);
//        cell8.addActionListener(this);
//        cell9.addActionListener(this);

        reset = new Button("Reset");
        reset.addActionListener(this);
        reset.setActionCommand("reset");
        arr = new TextField[3][3];
        arr[0][0] = cell1;
        arr[0][1] = cell2;
        arr[0][2] = cell3;
        arr[1][0] = cell4;
        arr[1][1] = cell5;
        arr[1][2] = cell6;
        arr[2][0] = cell7;
        arr[2][1] = cell8;
        arr[2][2] = cell9;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                arr[i][j].addMouseListener(Move(i, j, arr[i][j]));
//                System.out.println(Arrays.toString(arr[i][j].getActionListeners()));
            }
        }

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panel1.setLayout(new java.awt.GridLayout(4, 3));

        panel1.add(cell1);
        panel1.add(cell2);
        panel1.add(cell3);
        panel1.add(cell4);

        panel1.add(cell5);
        panel1.add(cell6);
        panel1.add(cell7);
        panel1.add(cell8);
        panel1.add(cell9);
        panel1.add(reset);
        status.setEnabled(false);
        panel1.add(status);

        setSize(100, 100);

        add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }

    private static void resetBoard() {
        turn = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!arr[i][j].getText().equals("")) {
                    arr[i][j].setText("");
                }

            }
        }
        status.setText("");

    }

    private static boolean checkRow(int row, char player) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[row][i].getText().equals(String.valueOf(player))) {
                count++;

            }
        }
        return count == 3;

    }

    private static boolean checkCol(int col, char player) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i][col].getText().equals(String.valueOf(player))) {
                count++;

            }
        }
        return count == 3;

    }

    private static boolean checkDiagonal(char player) {
        int size = 3;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 3; i++) {
            if (arr[i][i].getText().equals(String.valueOf(player))) {
                count1++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (arr[i][size - i - 1].getText().equals(String.valueOf(player))) {
                count2++;

            }
        }
        return (count1 == 3 || count2 == 3);

    }

    private static boolean iscellset(int row, int col) {
        return (!arr[row][col].getText().equals(""));

    }

    private static int getStatus() {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i, 'X')) {
                return 1;
            } else if (checkCol(i, 'X')) {
                return 1;
            } else if (checkRow(i, '0')) {
                return 2;
            } else if (checkCol(i, '0')) {
                return 2;
            } else if (checkDiagonal('X')) {
                return 1;
            } else if (checkDiagonal('0')) {
                return 2;

            }

        }
        boolean boardFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].getText().equals("")) {
                    boardFull = false;

                }
            }
        }
        if (boardFull) {
            return -1;
        } else {
            return 0;
        }

    }

    public static void main(String args[]) {
        TicTacToe ticTacToe = new TicTacToe();
        java.awt.EventQueue.invokeLater(() -> {
            ticTacToe.setVisible(true);
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        if (e.getSource() == reset) {
            TicTacToe.resetBoard();
        }

    }

    MouseListener Move(int row, int col, TextField tv) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Hello world");
                if (!iscellset(row, col)) {
                    arr[row][col].setText(String.valueOf(turn));

                    if (turn == 'X') {
                        System.out.println("X");
                        tv.setText("X");
                        turn = '0';
                    } else if (turn == '0') {
                        System.out.println("0");
                        tv.setText("0");
                        turn = 'X';
                    }
                    switch (getStatus()) {
                        case -1:
                            status.setText("Draw");
//                            for (int i = 0; i < 3; i++) {
//                                for (int j = 0; j < 3; j++) {
//                                    arr[i][j].removeMouseListener(this);
//                                }
//                            }

                            break;
                        case 0:
                            System.out.println("Hello world1");
                            status.setText("Turn " + turn);

                            break;
                        default:
                            status.setText(turn + "Loses");
//                            for (int i = 0; i < 3; i++) {
//                                for (int j = 0; j < 3; j++) {
//                                    arr[i][j].removeMouseListener(this);
//                                }
//                            }

                            break;
                    }
                } else {
                    status.setText("Please choose an empty cell");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body f generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }
        };
        // System.out.println("Hello world");

    }
}
