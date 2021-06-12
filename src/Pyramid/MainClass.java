package Pyramid;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class MainClass {
    public static void main(String[] arg) throws IOException {
        String filePath = "F:\\AI iti\\Java\\pyramids.csv";
        PyramidCSVDAO pyramidCSVDAO = new PyramidCSVDAO();

        try {
            List<Pyramid> pyramids = pyramidCSVDAO.readPyramidFromCsvFile(filePath);
            for (int i = 0; i < pyramids.size(); i++) {
                System.out.println(pyramids.get(i).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
