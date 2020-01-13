package game.zombie;

import java.awt.Graphics;
import java.awt.Point;

public interface ZombieView
{
    /**
     * TODO: javadoc
     * @param g
     * @param lifePercentage
     * @param cordinates
     * @param run
     */
    public void paint(Graphics g, int lifePercentage, Point cordinates, boolean run);
}