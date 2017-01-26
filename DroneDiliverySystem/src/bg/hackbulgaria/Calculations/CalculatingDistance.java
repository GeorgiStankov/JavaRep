package bg.hackbulgaria.Calculations;

import bg.hackbulgaria.Coordinates.Coordinates;

public class CalculatingDistance {

	public static double Distance(Coordinates whCoords,Coordinates orderCoords) {
		int whX=whCoords.getX();
		int whY=whCoords.getY();
		int targetX=orderCoords.getX();
		int targetY=orderCoords.getY();
		
		return Math.sqrt( Math.pow(targetX - whX, 2) + Math.pow(targetY - whY, 2) );
	}
}
