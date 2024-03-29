package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.GameModel;
import Model.Player;

public class mapPanel extends JPanel {
	public BufferedImage map;
	private GameModel model;

	public mapPanel(GameModel model) {
		// Load Images
		this.model = model;
		try {
			map = ImageIO.read(new File("src/Images/csulbMap.png"));
		} catch (IOException e) {
			System.err.println("Image not found");
			System.exit(1);
		}
		this.setPreferredSize(new Dimension(map.getWidth(), map.getHeight()));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(map, 0, 0, this); // paints the image of the map onto the
										// background

		ArrayList<Player> playerList = model.getPlayerList();
		// draw Rectangle2D.Double
		// Draw player 1
		g.setFont(new Font("TimesRoman", Font.BOLD, 50));
		g.setColor(Color.MAGENTA);
		g.drawString(playerList.get(0).getName(), (int) (model.getPlayerCoordinate(playerList.get(0)).getX()),
				(int) (model.getPlayerCoordinate(playerList.get(0)).getY()));
		// Draw player 2
		g.setColor(Color.BLUE);
		g.drawString(playerList.get(1).getName(), (int) model.getPlayerCoordinate(playerList.get(1)).getX(),
				(int) model.getPlayerCoordinate(playerList.get(1)).getY() - 35);
		// Draw player 3
		g.setColor(Color.ORANGE);
		g.drawString(playerList.get(2).getName(), (int) model.getPlayerCoordinate(playerList.get(2)).getX(),
				(int) model.getPlayerCoordinate(playerList.get(2)).getY() - 70);
	}

}
