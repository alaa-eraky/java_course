package Pyramid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PyramidCSVDAO {

    public List<Pyramid> readPyramidFromCsvFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Scanner scanner;
        String data;
        boolean isFirstLine = true;
        List<Pyramid> empList = new ArrayList<>();
        scanner = new Scanner(reader);
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
            if (isFirstLine)
                isFirstLine = false;
            else
                empList.add(createPyramid(data));
        }
        scanner.close();
        return empList;
    }

    public Pyramid createPyramid(String metadata) {
        String[] data = metadata.split(",", -1);
        Pyramid pyramid = new Pyramid();
        pyramid.setPharaoh(data[0]);
        pyramid.setModern_name(data[2]);
        pyramid.setSite(data[4]);
        if (data[7] != null && data[7].length() != 0)
            pyramid.setHeight(Double.parseDouble(data[7]));

        return pyramid;
    }

}
