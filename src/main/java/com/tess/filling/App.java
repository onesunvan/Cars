package com.tess.filling;

import com.tess.entities.Car;
import com.tess.repositories.CarRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ivan
 */
public class App {

    public static void main(String[] args) throws IOException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("jpa-repositories.xml");
        CarRepository carRepository = appContext.getBean(CarRepository.class);
        final File folder = new File("C:\\Users\\ivan\\Desktop\\carPictures");
        List<byte[]> files = listFilesForFolder(folder);
        List<String> carModels = Arrays.asList("kalina", "balina", "vasdvsa", "asdfsadf", "fgfdfgfd", "dfgsdfgds");
        List<String> carBrands = Arrays.asList("lada", "bm", "sadfsad", "asdf", "gfdgfdf", "dsfdsaf");
        for (int i = 0; i < 30000; i++) {
            byte[] image = files.get((int)(Math.random() * files.size()));
            int price = (int)(Math.random() * 10000) + 201;
            String model = carModels.get((int)(Math.random() * carModels.size()));
            String brand = carBrands.get((int)(Math.random() * carBrands.size()));
            Car car = new Car(brand, model, price, image);
            carRepository.save(car);
        }
        
    }

    public static List<byte[]> listFilesForFolder(final File folder) throws IOException {
        List<byte[]> files = new LinkedList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                Path path = Paths.get("C:\\Users\\ivan\\Desktop\\carPictures\\" + fileEntry.getName());
                byte[] data = Files.readAllBytes(path);
                files.add(data);
            }
        }
        return files;
    }

}
