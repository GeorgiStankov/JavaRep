package week1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


import java.io.IOException;

import javax.imageio.ImageIO;

public class ResizingImage {
	
	public static void resize(String input,String output,int width,int height) throws IOException{
		
		BufferedImage bf=ImageIO.read(new File(input));
		BufferedImage bfOut=new BufferedImage(width,height,bf.getType());
		
		Graphics2D g2d=bfOut.createGraphics();
		g2d.drawImage(bf,0,0,width,height,null);
		g2d.dispose();
		
		String formatName=output.substring(output.lastIndexOf(".")+1);
		ImageIO.write(bfOut,formatName, new File(output));
		
	}

	public static void main(String[] args) {
		
		String Input="D:/sss.jpg";
		String Output="D:/output.jpg";
		try{
			int scaledWidth = 1024;
            int scaledHeight = 768;
            ResizingImage.resize(Input, Output, scaledWidth, scaledHeight);
		}catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
		
}
}