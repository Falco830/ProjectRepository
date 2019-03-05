package plant.genetic.algorithm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.sampled.Line;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Representation2D extends JApplet {
    final static int maxCharHeight = 15;
    final static int minFontSize = 6;

    final static Color bg = Color.white;
    final static Color fg = Color.black;
    final static Color red = Color.red;
    final static Color white = Color.white;

    final static BasicStroke stroke = new BasicStroke(2.0f);
    final static BasicStroke wideStroke = new BasicStroke(8.0f);

    final static float dash1[] = {10.0f};
    final static BasicStroke dashed = new BasicStroke(1.0f, 
                                                      BasicStroke.CAP_BUTT, 
                                                      BasicStroke.JOIN_MITER, 
                                                      10.0f, dash1, 0.0f);
    static Graphics2D g2;
    static Graphics g;
    
    int gridGlobalWidth;
    int gridGlobalHeight;
    
    
    static JFrame f;
    Dimension totalSize;
    FontMetrics fontMetrics;
    JApplet applet;
    
  	static HashMap<String,ArrayList<BranchNode>> gradiant = new HashMap<String,ArrayList<BranchNode>>();
    
    
    static Point[] positions;	//Position and starting point of EACH SEED
    static int lineListSize;   //Area and size (not literal size) of Tree
    
    static public Double petreeDish;
    //static int generation = 1;
    static Seed seed;
    

    public void init() {
        //Initialize drawing colors
        setBackground(bg);
        setForeground(fg);
    }

    FontMetrics pickFont(Graphics2D g2,
                         String longString,
                         int xSpace) {
        boolean fontFits = false;
        Font font = g2.getFont();
        FontMetrics fontMetrics = g2.getFontMetrics();
        int size = font.getSize();
        String name = font.getName();
        int style = font.getStyle();

        while ( !fontFits ) {
            if ( (fontMetrics.getHeight() <= maxCharHeight)
                 && (fontMetrics.stringWidth(longString) <= xSpace) ) {
                fontFits = true;
            }
            else {
                if ( size <= minFontSize ) {
                    fontFits = true;
                }
                else {
                    g2.setFont(font = new Font(name,
                                               style,
                                               --size));
                    fontMetrics = g2.getFontMetrics();
                }
            }
        }

        return fontMetrics;
    }

    public void paint(Graphics g) {
    	this.g = g;
        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getSize();
        
        int gridWidth = d.width / 6;
        int gridHeight = d.height / 2;
        gridGlobalWidth = d.width;
        gridGlobalHeight = d.height;

        System.out.println("GRID HEGIHT " + gridGlobalWidth);
        System.out.println("GRID WIDTH " + gridGlobalHeight);

        fontMetrics = pickFont(g2, "Filled and Stroked GeneralPath",
                               gridWidth);

        Color fg3D = Color.lightGray;

        g2.setPaint(fg3D);
        g2.setPaint(fg);
        g2.setStroke(stroke);
        g2.setPaint(red);
        g2.fill(new Rectangle2D.Double(0, 0, d.width, d.height));
        g2.setBackground(white);
        g2.setStroke(wideStroke);
        g2.setPaint(white);
        petreeDish = new Ellipse2D.Double(20, 20, d.width-100, d.height-100);
        createGradiant(d);
        g2.draw(petreeDish);
        paintSeedPositions(g);
        
        paintToolBar(g);        
        paintLines();
        drawGeneration();
        drawScore();
    }
    
    public void createGradiant(Dimension d) {
    	 
        int startingWidthGrad = 30;
        int startingHeightGrad = 30;
        String gradkey = 0 + ", " + 0;
        for(int i = 0; i < (d.height); i++) {
        	g2.setStroke(stroke);
    		//g2.drawLine(0, startingHeightGrad, d.width, startingHeightGrad);
        	for(int j = 0; j < (d.width); j++) {
        		gradiant.put(gradkey, new ArrayList<BranchNode>());
        		gradkey = startingWidthGrad + ", " + startingHeightGrad;
        		//g2.drawLine(startingWidthGrad, 0, startingWidthGrad, d.height);
        		startingWidthGrad +=30;
        	}
        	startingWidthGrad = 0;
        	startingHeightGrad += 30;
        }
    }

    public void paintLines() {    	
    	//while(PeetreeDishStart.seedList != null) {
    	//g2 = (Graphics2D) g;
    	int seedNum = 1;
	    	//for(Seed seed:PeetreeDishStart.seedList) {
    		for(int i = 0; i < PeetreeDishStart.seedList.size(); i++) {
	    		//while(seed.getLineList() != null) {
	    		int lineNum = 1;
	    		//System.out.println("Seed: " + seedNum++);
	    		//System.out.println("Line List: " + PeetreeDishStart.seedList.get(i).getLineList());
		    		//for(Line2D line: seed.getLineList()) {
	    			for(int j = 0; j < PeetreeDishStart.seedList.get(i).getLineList().size(); j++) {
		    			//g2.setColor(Color.black);
		    			//System.out.println("Paint: " + lineNum++);
	    			  	/*for(int k = 0; k < positions.length; k++) {
	    			    	if(PeetreeDishStart.seedList.get(i).initialx == positions[k].getX()) {
	    			    		for(int z = 1; z < 5; z++) {
	    			    			int chooseColor = k%z;
	    				    		*/
	    				    		//if(chooseColor == 0) {
	    					    	switch((i+1)) {
	    					    		case 1:
	    					    			g2.setColor(Color.YELLOW);
	    					    			break;
	    					    		case 2:
	    					    			g2.setColor(Color.BLUE);
	    					    			break;
	    					    		case 3:
	    					    			g2.setColor(Color.BLACK);
	    					    			break;
	    					    		case 4:
	    					    			g2.setColor(Color.GREEN);
	    					    			break;
	    					    		case 5:
	    					    			g2.setColor(Color.GRAY);
	    					    			break;
	    					    	}
	    				    		//}
	    			    		//}
	    			    	//}
	    		    	//}
		        		g2.draw(PeetreeDishStart.seedList.get(i).getLineList().get(j));
		        		//applet.revalidate();
		        		//applet.
		        		//applet.add(g2);
		        		//f.repaint();
		        	}
	    		//}
	    	}
    	//}
    }
    
    public void paintToolBar(Graphics g) {	
    	Graphics2D g2 = (Graphics2D) g;
    	Dimension d = getSize();
    	/*
    	g2.setStroke(stroke);
        g2.setColor(Color.BLUE);

		
        g2.fill(new Rectangle2D.Double(d.width-200, d.height-100, d.width-(d.width-200), d.height-(d.height-100)));
       
        Font font = new Font(null, 0, 30);
        g2.setFont(font);
        g2.setColor(Color.green);
        g2.drawString("Start ", d.width-150, d.height-50);
        
        

        
        
        font = new Font(null, 0, 10);
        g2.setFont(font);
        */
        //drawScore();
      
    }
    public void drawGeneration() {
    	Dimension d = getSize();
    	Font font = new Font(null, 0, 30);
        g2.setFont(font);
        g2.setColor(Color.yellow);
        g2.drawString("Generation: " + PeetreeDishStart.generation, 5, d.height - 50);    
    }
    
    public void drawScore() {
    		Dimension d = getSize();
    		//System.out.println("Drawing Score... ");
    		//int seedNum = 1;
    		for(int i = 0; i < PeetreeDishStart.seedList.size(); i++) {
	    		//int lineNum = 1;
	    		for(int j = 0; j < PeetreeDishStart.seedList.get(i).getLineList().size(); j++) {
	    				Font font = new Font(null, 0, 10);
	    		        g2.setFont(font);
	    				g2.setColor(Color.white);
		        		g2.drawString("Seed " + (i+1) + " Score: " + PeetreeDishStart.seedList.get(i).getLineList().size(), 5, d.height - (10 * i));
		        		//f.repaint();
		        }
	    		//lineNum = 0;
	    	}
    		/*
    	  for(int i = 0; i < positions.length; i++) {
          	g2.setColor(Color.white);
          	int score = 0;
          	if(seed.getLineList() == null) {
          		score = 0;
          	}else {
          		score = seed.getLineList().size();
          	}
          	
          	g2.drawString("Score: " + score, 5, d.height - (10 * i));  
          }*/
    }
    
    public void paintSeedPositions(Graphics g) {
    	g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getSize();
        g2.setStroke(stroke);
        Point center = new Point();
        center.setLocation(petreeDish.x,petreeDish.y);
        positions = DrawCirclePoints(5, (petreeDish.width/2), center);  
        int num = 0;
        for(Point s: positions) {
        	num++;
        	g2.draw(new Ellipse2D.Double((s.x), (s.y), d.width-(d.width-40), d.height-(d.height-40)));
        	Font font = new Font(null, 0, 30);
            g2.setFont(font);
        	g2.drawString(""+ num, s.x + (d.width-(d.width-20))/2, s.y + (d.height-(d.height-60))/2);
        	
        }
    }
    public Point[] returnPositions() {
    	return positions;
    }
    
    public Point[] DrawCirclePoints(int points, double radius, Point center)
    {
    	
    	Point[] pointPositions = new Point[points];
    	Dimension d = getSize();
    	
        double slice = 2 * Math.PI / points;
        for (int i = 0; i < points; i++)
        {
            double angle = slice * i;
            int newX = (int)(center.x + (petreeDish.width/2 -(petreeDish.width-100)) * Math.cos(angle));
            int newY = (int)(center.y + (petreeDish.height/2 -(petreeDish.height-100)) * Math.sin(angle));
            newX += petreeDish.width/2-20;
            newY += petreeDish.height/2-20;
            Point p = new Point(newX, newY);
            pointPositions[i] = p;
        }
        return pointPositions;
    }
    
    static Line2D lineBranch;
    //static Line2D line;
    public Line2D leafGrowth(int prevx, int prevy, int nextx, int nexty) {
    	lineBranch = new Line2D.Double(prevx, prevy, nextx, nexty);
    	return lineBranch;
  
    	//g2.setColor(Color.black);   	
    	//System.out.println("CurrentNode: " + seed.currentNode.x + " " + seed.currentNode.y +" "+sd.nextx +" "+ sd.nexty);   	
    }
    
	public Line2D drawPotentialLine(int sx, int sy, int ex, int ey) {
		Line2D l1 = new Line2D.Float(sx, sy, ex, ey);
		
		return l1;
		
	}
    
	 
    public void createJFrame() {
        f = new JFrame("ShapesDemo2D");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        
        applet = new Representation2D();
        f.getContentPane().add("Center", applet);
        //f.repaint();
        applet.init();
       

        f.pack();
        f.setSize(new Dimension(550,550));
        f.setVisible(true);
    }
	
	 public static void main(String s[]) {
		 Representation2D rep = new Representation2D();
		 rep.createJFrame();
	
	 }
	 
}



