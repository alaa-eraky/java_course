package Titanic;

import tech.tablesaw.api.Table;

import java.io.IOException;

public class MainTitanic {

    public static void main(String[] args) throws IOException {
        Table table = TablesawTitanic.loadDataFromCSV();
        System.out.println(table);

        String tableStructure = TablesawTitanic.getDataInfoStructure(table);
        System.out.println(tableStructure);

        String tableSummary = TablesawTitanic.getDataSummary(table);
        System.out.println(tableSummary);

        Table newTable = TablesawTitanic.mapTextColumnToNumber(table);
        System.out.println(newTable);
    }
}
