package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PannelPhoto extends JPanel{
	private BufferedImage bi;
	@Override
	public void paint(Graphics g) {
		g.drawImage(bi, 0, 0,this.getWidth(),this.getHeight(), null );
		
	
	}
	public BufferedImage getBi() {
		return bi;
	}
	public void setBi(BufferedImage bi) {
		this.bi = bi;
	}

}
