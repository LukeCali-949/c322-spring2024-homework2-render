package iu.edu.lukemeng.c322spring2024homework2.repository;



import iu.edu.lukemeng.c322spring2024homework2.model.Guitar;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


@Component
public class InventoryRepository {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "guitars_database.txt";



    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public boolean addGuitar(Guitar guitarData) throws IOException {
        Path path = Paths.get(DATABASE_NAME);
        String data = guitarData.getSerialNumber() + "," + guitarData.getPrice() + "," + guitarData.getBuilder() + "," + guitarData.getModel()+ "," + guitarData.getType()+"," + guitarData.getBackWood()+"," + guitarData.getTopWood();
        appendToFile(path, data + NEW_LINE);
        return true;
    }

    public Guitar getGuitar(String serialNumber) throws IOException {

        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);


        for(String line : data){
            String[] words = line.split(",");

            String strPrice = words[1];

            double price = Double.parseDouble(strPrice);

            if(words[0].equals(serialNumber)){
                Guitar guitar = new Guitar(words[0], price, words[2], words[3], words[4], words[5], words[6]);
                return guitar;
            }


        }
        return null;
    }

    public List<Guitar> search(Guitar searched) throws IOException {
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);

        List<Guitar> result = new ArrayList<>();

        for(String line : data){
            String[] words = line.split(",");

            String strPrice = words[1];

            double price = Double.parseDouble(strPrice);

            Guitar guitar = new Guitar(words[0], price, words[2], words[3], words[4], words[5], words[6]);

            String builder = guitar.getBuilder();
            if ((builder != null) && (!builder.isEmpty()) &&
                    (!builder.equals(guitar.getBuilder())))
                continue;
            String model = guitar.getModel();
            if ((model != null) && (!model.isEmpty()) &&
                    (!model.equals(guitar.getModel())))
                continue;
            String type = guitar.getType();
            if ((type != null) && (!type.isEmpty()) &&
                    (!type.equals(guitar.getType())))
                continue;
            String backWood = guitar.getBackWood();
            if ((backWood != null) && (!backWood.isEmpty()) &&
                    (!backWood.equals(guitar.getBackWood())))
                continue;
            String topWood = guitar.getTopWood();
            if ((topWood != null) && (!topWood.isEmpty()) &&
                    (!topWood.equals(guitar.getTopWood())))
                continue;
            result.add(guitar);

        }

        return result;
    }




}

