package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DisplayWormHole extends JFrame {

    private static final long serialVersionUID = 1L;

    public DisplayWormHole() {
        setTitle("Worm Hole Corbonate Acidizing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(Grid[][] tab, int Size) {
        add(new CustomComponents(tab, Size));
        pack();
        // enforces the minimum size of both frame and component        
        setMinimumSize(getSize());
        setVisible(true);
    }
}

class CustomComponents extends JComponent {

    private static final long serialVersionUID = 1L;
    private Grid tab[][];
    int Size;
    public CustomComponents(Grid[][] tab, int Size) {
    	super();
    	this.tab = tab;
    	this.Size = Size;
    }
    @Override
    public Dimension getMinimumSize() {
        return new Dimension(200, 200);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(520, 520);
    }

    @Override
    public void paintComponent(Graphics g) {
    	int margin = 10;
        Dimension dim = getSize();
        super.paintComponent(g);
        int w = dim.width - 2*margin;
        int h = dim.height - 2*margin;
        for(int i = 0; i < Size; i++) {
        	for(int j = 0; j < Size;j++){
        		if(tab[i][j].getFillRatio() == 1 ) {
        			g.setColor(Color.black);
        		} else if (tab[i][j].getFillRatio() >= 0.8 && tab[i][j].getFillRatio() < 1){
        			g.setColor(Color.red);
        		} else if (tab[i][j].getFillRatio() >= 0.6  && tab[i][j].getFillRatio() < 0.8) {
        			g.setColor(Color.orange);
        		} else if (tab[i][j].getFillRatio() >= 0.4 && tab[i][j].getFillRatio() < 0.6) {
        			g.setColor(Color.yellow);
        		} else if (tab[i][j].getFillRatio() >= 0.2 && tab[i][j].getFillRatio() < 0.4) {
        			g.setColor(Color.green);
        		} else if (tab[i][j].getFillRatio() >= 0.1 && tab[i][j].getFillRatio() < 0.2) {
        			g.setColor(Color.gray);
        		} else {
        			g.setColor(Color.blue);
        		}
	            g.fillRect(margin+(w/Size)*i, margin+(h/Size)*j, (w)/Size, (h)/Size);
	      
	        }
        }
        
    }
}