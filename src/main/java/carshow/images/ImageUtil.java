package carshow.images;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ivan
 */
public class ImageUtil {
    public static byte[] validateImage(MultipartFile image, List<String> errors) {
        if (image.isEmpty()) {
            errors.add("addcontent.imageempty");
        } else if (!image.getContentType().split("/")[0].equals("image")) {
            errors.add("addcontent.notimage");
        }
        byte[] imageBytes = {};
        try {
            imageBytes = image.getBytes();
            try (InputStream is = new ByteArrayInputStream(imageBytes)) {
            	try {
            		ImageIO.read(is).toString();
            	} catch (Exception ex) { 
            		handleActuallyNotImage(errors);
            	}
            }
        } catch (IOException ex) {
            errors.add("addcontent.image.error");
        }
        return imageBytes;
    }
    
    private static void handleActuallyNotImage(List<String> errors) {
    	errors.add("addcontent.notimage");
    }
}
