package Titanic;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TablesawTitanic {

    public static Table loadDataFromCSV() throws IOException {
        Table titanicData = Table.read().csv("src/main/resources/data/titanic.csv");
        return titanicData;
    }

    public static String getDataInfoStructure(Table data) {
        Table dataStructure = data.structure();
        return dataStructure.toString();
    }

    public static String getDataSummary(Table data) {
        Table summary = data.summary();
        return summary.toString();
    }

    public static Table mapTextColumnToNumber(Table data) {
        NumberColumn mappedGenderColumn = null;
        StringColumn gender = (StringColumn) data.column("Sex");
        List<Number> mappedGenderValues = new ArrayList<Number>();
        for (String v : gender) {
            if ((v != null) && (v.equals("female"))) {
                mappedGenderValues.add(1);
            } else {
                mappedGenderValues.add(0);
            }
        }
        mappedGenderColumn = DoubleColumn.create("gender", mappedGenderValues);
        data.addColumns(mappedGenderColumn);
        return data;
    }
}

