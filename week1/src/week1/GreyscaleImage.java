package week1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GreyscaleImage {

	public static void main(String[] args) {
		
		//GrayScale obj = new GrayScale();
   GreyscaleImage.GrayScale();
	}
	public class GrayScale {
		
	}
	public static void GrayScale() {
		String Input="D:/sss.jpg";
		String Output="D:/output.jpg";
		try {
			BufferedImage in=ImageIO.read(new File(Input));
			
			int height=in.getHeight();
			int width=in.getWidth();
			
			for(int i=0;i<height;i++){
				for(int s=0;s<width;s++){
				
					 Color c=new Color(in.getRGB(s,i));
					 int red=(int)(c.getRed()*0.229);
					 int green=(int)(c.getGreen()*0.587);
					 int blue=(int)(c.getBlue()*0.114);
					 Color newColor=new Color(red+green+blue,red+green+blue,red+green+blue);
					 in.setRGB(s,i, newColor.getRGB());
				}
			
			}
			File ouptut = new File("D:/outpsut.jpg");
	         ImageIO.write(in, "jpg", ouptut);
	         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	


