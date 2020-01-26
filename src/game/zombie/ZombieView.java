package game.zombie;

import java.awt.Graphics;
import java.awt.Point;

public interface ZombieView
{
    public void paint(Graphics g, int lifePercentage, Point cordinates, boolean run);
}