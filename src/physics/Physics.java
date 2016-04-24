package physics;

import celestial.Celestial;
import celestial.Planet;
import ship.Ship;

/**
 * Has static method to update planets' coordinations.
 */
public class Physics {
   public static void planetaryOrbit(final Celestial sun, Planet planet) {
      double dTheta = 2 * Math.PI / planet.getPeriodInMS()
            * Constants.TIME_INTERVAL;
      planet.setAngleToSun((planet.getAngleToSun() + dTheta) % (2 * Math.PI));
      // update (x,y) coordinate
      int newX, newY;
      newX = (int)(sun.getX()
            + planet.getDistanceToSun() * Math.cos(planet.getAngleToSun()));
      newY = (int)(sun.getY()
            + planet.getDistanceToSun() * Math.sin(planet.getAngleToSun()));
      planet.setCoordinate(newX, newY);
   }

   public static void shipFlight(Ship ship) {}
}
