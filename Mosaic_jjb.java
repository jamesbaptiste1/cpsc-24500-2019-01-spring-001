import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * SP19-CPSC-24500-LT1 Object-Oriented Programming
 * Programming Assignment #4: Mosaic
 * Mosaic.java
 * Purpose: Prints Random colored circles and squares 
 * with random letter in the middle of each shape.
 * 
 * 
 * @author James Baptiste
 * @version 2.0 Spring 2019
 */

class letterTile extends JPanel {
    private int red, green, blue;
    private String letter;

    //Default contructor
    letterTile() {
        super();
        SetRandomValue();
    }

    final public void SetRandomValue() {
        //Set a random value for "red, green, blue" colors
        red = GetNumberBetween(0, 255);  
        green = GetNumberBetween(0, 255);
        blue = GetNumberBetween(0, 255);

        //Randomly prints a letter for each tile
        letter = "A";
        if (GetNumberBetween(0,25) == 1) {
            letter = "B";
        }
        if (GetNumberBetween(0,25) == 2) {
            letter = "C";
        }
        if (GetNumberBetween(0,25) == 3) {
            letter = "D";
        }
        if (GetNumberBetween(0,2) == 4) {
            letter = "E";
        }
        if (GetNumberBetween(0,25) == 5) {
            letter = "F";
        }
        if (GetNumberBetween(0,25) == 6) {
            letter = "G";
        }
        if (GetNumberBetween(0,25) == 7) {
            letter = "H";
        }
        if (GetNumberBetween(0,25) == 8) {
            letter = "I";
        }
        if (GetNumberBetween(0,25) == 9) {
            letter = "J";
        }
        if (GetNumberBetween(0,25) == 10) {
            letter = "K";
        }
        if (GetNumberBetween(0,25) == 11) {
            letter = "L";
        }
        if (GetNumberBetween(0,25) == 12) {
            letter = "M";
        }
        if (GetNumberBetween(0,25) == 13) {
            letter = "N";
        }
        if (GetNumberBetween(0,25) == 14) {
            letter = "O";
        }
        if (GetNumberBetween(0,25) == 15) {
            letter = "P";
        }
        if (GetNumberBetween(0,25) == 16) {
            letter = "Q";
        }
        if (GetNumberBetween(0,25) == 17) {
            letter = "R";
        }
        if (GetNumberBetween(0,25) == 18) {
            letter = "S";
        }
        if (GetNumberBetween(0,25) == 19) {
            letter = "T";
        }
        if (GetNumberBetween(0,25) == 20) {
            letter = "U";
        }
        if (GetNumberBetween(0,25) == 21) {
            letter = "V";
        }
        if (GetNumberBetween(0,25) == 22) {
            letter = "W";
        }
        if (GetNumberBetween(0,25) == 23) {
            letter = "X";
        }
        if (GetNumberBetween(0,25) == 24) {
            letter = "Y";
        }
        if (GetNumberBetween(0,25) == 25) {
            letter = "Z";
        }
    }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);            
    
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            
            //sets tile colors
            g.setColor(new Color(red,green,blue));
            if (GetNumberBetween(1, 2) == 1) {
            //fills oval with color
            g.fillOval(0,0, getWidth(), getHeight());
            System.out.println("Shape: Oval, " + "Letter: " + letter + ", Color: #" + GetNumberBetween(0, 255) );
            } 
            else 
            {
            //fills Rect with color
            g.fillRect(0,0, getWidth(), getHeight());
            System.out.println("Shape: Rectangle, " + "Letter: " + letter + ", Color: #" + GetNumberBetween(0, 255));
            }
            
            //changes future setColor to print contrast in text
            g.setColor(new Color(getContrastingColor(red), getContrastingColor(green), getContrastingColor(blue)));
            final int fontSize=24;
            g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            int stringX = (panelWidth/2)-7;
            int stringY = (panelHeight/2)+10;
            g.drawString(letter,stringX,stringY);
        }
        
    //creates contrasting color
    private static int getContrastingColor(int colorIn) {
       return ((colorIn+128)%256);
    }
       
    //creates random numbers
    private static int GetNumberBetween(int min, int max) {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }
}

class MosaicFrame extends JFrame implements ActionListener {
    private ArrayList<letterTile> tileList;
    
    public MosaicFrame() {
        //sets approprate bounds of frame and closes on exit
        setBounds(200,200,700,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //creates button panel
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel,  BorderLayout.SOUTH);
       
        //creates randomize tile button
        JButton randomize = new JButton("Randomize!");
        buttonPanel.add(randomize); 
        randomize.addActionListener(this);

        //creates hide tile button
        JButton hide = new JButton("Hide!");
        buttonPanel.add(hide); 
        randomize.addActionListener(this);

        //creates letter grid panel
        JPanel letterGridPanel = new JPanel();
        contentPane.add(letterGridPanel, BorderLayout.CENTER);
        letterGridPanel.setLayout(new GridLayout(12,12));

        //Array to add tiles
        tileList = new ArrayList<letterTile>();
        for(int i=1; i<145; i++) {
            letterTile tile = new letterTile();
            letterGridPanel.add(tile);
            tileList.add(tile);
        }
    }

    public void actionPerformed(ActionEvent e) {
        //sets action to be performed and repainted 
        for (letterTile tile:tileList) {
            tile.SetRandomValue();
            repaint();
        }
    }
}
    
public class Mosaic {
    public static void main(String[] args) {
        System.out.println("Start paint***");

        //create new MosaicFrame
        MosaicFrame myMosaicFrame = new MosaicFrame();
        myMosaicFrame.setVisible(true);


    }   
}
