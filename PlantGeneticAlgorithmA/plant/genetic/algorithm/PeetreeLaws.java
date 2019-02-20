package plant.genetic.algorithm;

import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Line2D;

public class PeetreeLaws {

	//If leaf WOULD collide with other leaf or branch, then leaf IS NOT ALLOWED
	//TO GROW.
	int startx;
	int starty;
	int endx;
	int endy;
	
	
	public PeetreeLaws(int startx, int starty, int endx, int endy) {
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
	}
	
	public boolean breaksLaw(Representation2D rep) {
		//Representation2D rep = new Representation2D();
		PeetreeDishStart everySeed = new PeetreeDishStart();
		
		Line2D pl = rep.drawPotentialLine(startx, starty, endx, endy);
		
		for(int i = 0; i < everySeed.seedList.size(); i++) {
			if(everySeed.seedList.get(i).getLineList() == null) {
				if(!rep.petreeDish.contains(startx, starty, endx, endy)) {
					//System.out.println("broke peetree law");
					return true;
				}
				return false;
			}
			
			
			
			for(int j = 0; j < everySeed.seedList.get(i).getLineList().size();j++) {
					//Area area1 = new Area(pl);
					//area1.intersect(new Area(everySeed.seedList.get(i).getLineList().get(j)));
				//System.out.println("BROKEA: " + everySeed.seedList.get(i).getLineList().get(j).getX1() + " " +  everySeed.seedList.get(i).getLineList().get(j).getX2() +  " " +  everySeed.seedList.get(i).getLineList().get(j).getY1() + " " + everySeed.seedList.get(i).getLineList().get(j).getY2());
				//System.out.println("BROKEB: " + pl.getX1() + " " + pl.getX2() +  " " +  pl.getY1() + " " + pl.getY2());
					//if(pl.intersectsLine(everySeed.seedList.get(i).getLineList().get(j).getX1(), everySeed.seedList.get(i).getLineList().get(j).getY1(), everySeed.seedList.get(i).getLineList().get(j).getX2(), everySeed.seedList.get(i).getLineList().get(j).getY2())){
				   //if(!area1.isEmpty()) {
					//if(Line2D.linesIntersect(everySeed.seedList.get(i).getLineList().get(j).getX1(), everySeed.seedList.get(i).getLineList().get(j).getX2(), everySeed.seedList.get(i).getLineList().get(j).getY1(), everySeed.seedList.get(i).getLineList().get(j).getY2(), pl.getX1(), pl.getX2(), pl.getY1(), pl.getY2())){//(everySeed.seedList.get(i).getLineList().get(j))){
				Point p1 = new Point();
				p1.setLocation(pl.getX1(), pl.getY1());
				Point q1 = new Point();
				q1.setLocation(pl.getX2(), pl.getY2());
				Point p2 = new Point();
				p2.setLocation(everySeed.seedList.get(i).getLineList().get(j).getX1(), everySeed.seedList.get(i).getLineList().get(j).getY1());
				Point q2 = new Point();
				q2.setLocation(everySeed.seedList.get(i).getLineList().get(j).getX2(), everySeed.seedList.get(i).getLineList().get(j).getY2());
				
				
				if(doIntersect(p1, q1, p2, q2)) {
					if((pl.getX1() == everySeed.seedList.get(i).getLineList().get(j).getX2()) &&  pl.getY1() == everySeed.seedList.get(i).getLineList().get(j).getY2()) {
						//System.out.println("branch DID NOT BREAK law ");
						//return false;
						continue;
					}
					
					//
					if((pl.getX1() == everySeed.seedList.get(i).getLineList().get(j).getX1() &&  pl.getY1() == everySeed.seedList.get(i).getLineList().get(j).getY1()) && (pl.getX2() != everySeed.seedList.get(i).getLineList().get(j).getX2() &&  pl.getY2() != everySeed.seedList.get(i).getLineList().get(j).getY2())){
						//System.out.println("branch DID NOT BREAK law ");
						continue;
					}
					if(!rep.petreeDish.intersects(startx, starty, endx, endy)) {
						//System.out.println("broke peetree law");
						return true;
					}
					//System.out.println("broke branch law ");
					//System.out.println("BROKEC: " + everySeed.seedList.get(i).getLineList().get(j).getX1() + " " +  everySeed.seedList.get(i).getLineList().get(j).getX2() +  " " +  everySeed.seedList.get(i).getLineList().get(j).getY1() + " " + everySeed.seedList.get(i).getLineList().get(j).getY2());
					//System.out.println("BROKED: " + pl.getX1() + " " + pl.getX2() +  " " +  pl.getY1() + " " + pl.getY2());
					return true;
				}
			}			
		}
		//System.out.println("h: " + rep.petreeDish.height + " w: " + rep.petreeDish.width);
		//System.out.println("endx: " + endx + " endy " + endy);
		
		if(!rep.petreeDish.intersects(startx, starty, endx, endy)) {
			//System.out.println("broke peetree law");
			return true;
		}
		/*
		if(rep.petreeDish.intersects(startx, starty, endx, endy)) {
			
		}*/
		//if line crosses a branch or the peetree dish, kill (Breaks Law)
		
		return false;
	}
	
	boolean onSegment(Point p, Point q, Point r) 
	{ 
	    if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) && 
	        q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) 
	       return true; 
	  
	    return false; 
	} 
	
	int orientation(Point p, Point q, Point r) 
	{ 
	    // See https://www.geeksforgeeks.org/orientation-3-ordered-points/ 
	    // for details of below formula. 
	    int val = (q.y - p.y) * (r.x - q.x) - 
	              (q.x - p.x) * (r.y - q.y); 
	  
	    if (val == 0) return 0;  // colinear 
	  
	    return (val > 0)? 1: 2; // clock or counterclock wise 
	} 
	
	public boolean doIntersect(Point p1, Point q1, Point p2, Point q2) 
	{ 
	    // Find the four orientations needed for general and 
	    // special cases 
	    int o1 = orientation(p1, q1, p2); 
	    int o2 = orientation(p1, q1, q2); 
	    int o3 = orientation(p2, q2, p1); 
	    int o4 = orientation(p2, q2, q1); 
	  
	    // General case 
	    if (o1 != o2 && o3 != o4) 
	        return true; 
	  
	    // Special Cases 
	    // p1, q1 and p2 are colinear and p2 lies on segment p1q1 
	    if (o1 == 0 && onSegment(p1, p2, q1)) return true; 
	  
	    // p1, q1 and q2 are colinear and q2 lies on segment p1q1 
	    if (o2 == 0 && onSegment(p1, q2, q1)) return true; 
	  
	    // p2, q2 and p1 are colinear and p1 lies on segment p2q2 
	    if (o3 == 0 && onSegment(p2, p1, q2)) return true; 
	  
	     // p2, q2 and q1 are colinear and q1 lies on segment p2q2 
	    if (o4 == 0 && onSegment(p2, q1, q2)) return true; 
	  
	    return false; // Doesn't fall in any of the above cases 
	} 
}
