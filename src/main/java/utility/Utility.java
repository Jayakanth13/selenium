package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utility {

	public static  BufferedImage convertToPartialImage(TakesScreenshot takesScreenshot, String tesctcase) {
		 File screen =takesScreenshot.getScreenshotAs(OutputType.FILE);
		 BufferedImage img=null;
		try {
			  img = ImageIO.read(screen);
			img= img.getSubimage(689, 45, 526, 90);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
			 File myObj = new File("./test-output");
			
			ImageIO.write(img, "png",  new File("test-output\\screenshot"+tesctcase+".png" ));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
		return img;
	}
	
	public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
		  // The images must be the same size.
		  if (imgA.getWidth() != imgB.getWidth() || imgA.getHeight() != imgB.getHeight()) {
		    return false;
		  }

		  int width  = imgA.getWidth();
		  int height = imgA.getHeight();

		  // Loop over every pixel.
		  for (int y = 0; y < height; y++) {
		    for (int x = 0; x < width; x++) {
		      // Compare the pixels for equality.
		      if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
		        return false;
		      }
		    }
		  }

		  return true;
		}
	
}
