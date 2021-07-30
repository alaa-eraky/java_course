package Titanic;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainTitanic {

    public static void main(String[] args) throws IOException {

        Table table = TablesawTitanic.loadDataFromCSV("src/main/resources/data/titanic.csv");
        System.out.println(table);

        String tableStructure = TablesawTitanic.getDataInfoStructure(table);
        System.out.println(tableStructure);

        String tableSummary = TablesawTitanic.getDataSummary(table);
        System.out.println(tableSummary);

        Table newTable = TablesawTitanic.mapTextColumnToNumber(table);
        System.out.println(newTable);

        //XChart

        List xValues =  table.column(1).asList();
        List yValues =  table.column(4).asList();

        CategoryChart chart = new CategoryChartBuilder().width(600).height(500).title("Titanic").xAxisTitle("X").yAxisTitle("Y").build();

        chart.addSeries("Titanic",xValues,yValues);
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        new SwingWrapper<>(chart).displayChart();

        Table DataTest = TablesawTitanic.loadDataFromCSV("src/main/resources/data/titanic_test.csv");
        Table DataTrain = TablesawTitanic.loadDataFromCSV("src/main/resources/data/titanic_train.csv");
        // Both tables must have the same number of rows to concatenate them so there is an error.
        var TableJoined = DataTrain.concat(DataTest);
        System.out.println(TableJoined);
    }

}

