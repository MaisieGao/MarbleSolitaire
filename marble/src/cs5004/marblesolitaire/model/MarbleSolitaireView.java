package cs5004.marblesolitaire.model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Class representing the view of MarbleSolitaire
 */
public class MarbleSolitaireView extends JFrame implements MarbleSolitaireViewInterface{
    private final Slots[][] slot;
    private MarbleSolitaireController controller;
    private final JLabel topLabel, downLabel;
    private final Icon marble, empty, unAvailable;
    //the fromRow and fromCol is made default to be accessible in controller
    private Integer fromRow = null;
    private Integer fromCol = null;
    
    /**
     * Construct a MarbleSolitaire game object's view
     *
     * @param string represents the title on the window of the view
     */
    public MarbleSolitaireView(String string){
        super(string);
        slot = new Slots[7][7];
        
        //set icon using image
        marble = new ImageIcon(getClass().getResource("marble.png"));
        empty = new ImageIcon(getClass().getResource("empty.png"));
        unAvailable = new ImageIcon(getClass().getResource("unAvailable.png"));

        //set JFrame
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(800,300);

        //create bigPanel(BorderLayout) and panel(GridLayout)
        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        this.add(bigPanel, BorderLayout.CENTER);
        JPanel panel = new JPanel(new GridLayout(7,7));
        bigPanel.add(panel, BorderLayout.CENTER);
        bigPanel.setBackground(Color.LIGHT_GRAY);
        bigPanel.setBorder(new EmptyBorder(5, 70, 40, 70));

        //create topLabel(All the msg) and downLabel(display the score)
        topLabel = new JLabel("Welcome to the game!");
        //make topLabel in the center
        topLabel.setHorizontalAlignment(JTextField.CENTER);
        bigPanel.add(topLabel, BorderLayout.NORTH);
        topLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
        downLabel = new JLabel("Start score: 32");
        bigPanel.add(downLabel, BorderLayout.SOUTH);
        downLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 20));

        //create slots in the panel
        for(int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                slot[row][col] = new Slots(String.format("%d %d", row, col));
                slot[row][col].addActionListener(new ActionListener() {
                    //construct an anonymous inner class to respond to slot clicked and
                    //send the move to controller
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String[] coordinates = e.getActionCommand().split(" ");
                        int row = Integer.parseInt(coordinates[0]);
                        int col = Integer.parseInt(coordinates[1]);
                        //if this is the first time click the slot, make them fromRow and fromCol,
                        //if it is not the first time, make them row and col
                        //we are only making the move after we clicked two slots
                        if (fromRow == null && fromCol == null) {
                            fromRow = row;
                            fromCol = col;
                        }
                        else {
                            // perform move operation
                            controller.actionMove(fromRow, fromCol, row, col);
                            //reset fromRow and fromCol to null
                            fromRow = row;
                            fromCol = col;
                        }
                    }
                });
                //make all the slots unavailable first
                slot[row][col].setIcon(unAvailable);
                //add all the slots to the panel
                panel.add(slot[row][col]);
            }
        }
        //make certain slots marble
        for (int row = 0; row < 7; row++) {
             for (int col = 2; col < 5; col++) {
                slot[row][col].setIcon(marble);
                slot[col][row].setIcon(marble);
             }
        }
        //make the center slot empty
        slot[3][3].setIcon(empty);
        setVisible(true);
    }

    @Override
    public void linkController(MarbleSolitaireController controller) {
        this.controller = controller;
    }
    @Override
    public void displayMessage(String string) {
        topLabel.setText(string);
    }
    @Override
    public void displayMessageGetScore(int score) {
        downLabel.setText("The current score is: " + score);
    }
    @Override
    public void fromslotIcon(int fromRow, int fromCol){
        slot[fromRow][fromCol].setIcon(empty);
    }
    @Override
    public void toSlotIcon(int toRow, int toCol) {
        slot[toRow][toCol].setIcon(marble);
    }
    @Override
    public void midSlotIcon(int midRow, int midCol) {
        slot[midRow][midCol].setIcon(empty);
    }
}

