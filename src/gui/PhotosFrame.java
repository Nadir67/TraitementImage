package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhotosFrame extends JFrame {
	private JLabel jLabelPhotos=new JLabel ("Photos");
	private JComboBox<String> jComboBoxPhotos;
	private JButton jButtonTraiter=new JButton("Traiter");
	private PannelPhoto pannelPhoto=new PannelPhoto();
	
	
	public PhotosFrame() {
		try {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
			File f=new File("photos");
			String[] images=f.list();
			jComboBoxPhotos=new JComboBox<>(images);
			String nomPhoto=(String)jComboBoxPhotos.getSelectedItem();
			BufferedImage bi=ImageIO.read(new File("photos/"+nomPhoto));
			pannelPhoto.setBi(bi);
			JPanel jPanelN=new JPanel();
			jPanelN.setLayout(new FlowLayout());
			jPanelN.add(jLabelPhotos);
			jPanelN.add(jComboBoxPhotos);
			jPanelN.add(jButtonTraiter);
			this.add(jPanelN,BorderLayout.NORTH);
			this.add(pannelPhoto,BorderLayout.CENTER);
			this.setBounds(10,10,800,600);
			this.setVisible(true);
			jComboBoxPhotos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						String nomPhoto=(String)jComboBoxPhotos.getSelectedItem();
						BufferedImage bi=ImageIO.read(new File("photos/"+nomPhoto));
						pannelPhoto.setBi(bi);
						pannelPhoto.repaint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
			jButtonTraiter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					BufferedImage bi=pannelPhoto.getBi();
					for(int i=0;i<bi.getWidth();i++)
						for(int j=0;j<bi.getHeight();j++) {
							
						
							bi.setRGB(i, j, bi.getRGB(i,j)+5);		
						}
					pannelPhoto.repaint();
			}
			});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void main(String[] args) {
		new PhotosFrame();
		
	}
	
	
	
}
