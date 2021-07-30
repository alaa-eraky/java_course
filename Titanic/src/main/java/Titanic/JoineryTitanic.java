package Titanic;

import joinery.DataFrame;

import java.io.IOException;

public class JoineryTitanic {

    public static void main(String[] args) {
        try {
            DataFrame<Object> df = DataFrame.readCsv("src/main/resources/data/titanic.csv")
                    .retain("pclass", "survived", "name", "sex", "age", "sibsp", "parch", "ticket", "fare", "cabin", "embarked", "boat", "body", "home.dest")
                    .groupBy(row -> row.get(0)).mean();
            df.iterrows().forEachRemaining(System.out::println);
            System.out.println("=========================================================================================");

            DataFrame<Object> describe =df.describe();
            System.out.println(describe.toString());
            System.out.println("=========================================================================================");

            DataFrame<Object> dfTrain = DataFrame.readCsv("src/main/resources/data/titanic_train.csv")
                    .retain("PassengerId", "Survived","Pclass", "Name", "Sex", "Age")
                    .groupBy(row -> row.get(0)).mean();

            DataFrame<Object> dfTest = DataFrame.readCsv("src/main/resources/data/titanic_test.csv")
                    .retain("PassengerId","Pclass", "Name", "Sex", "Age")
                    .groupBy(row -> row.get(0)).mean();

            DataFrame Newdf = dfTrain.join(dfTest);
            Newdf.iterrows().forEachRemaining(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


}
}

