package carshow.images;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ivan
 */
public class ImageUtil {
    public static byte[] validateImage(MultipartFile image, List<String> errors) {
        if (image.isEmpty()) {
            errors.add("addcontent.imageempty");
        } else if (!image.getContentType().equals("image/jpeg")) {
            errors.add("addcontent.notjpeg");
        }
        byte[] imageBytes = {};
        try {
            imageBytes = image.getBytes();
        } catch (IOException ex) {
            errors.add("addcontent.jpgerror");
        }
        return imageBytes;
    }
}
