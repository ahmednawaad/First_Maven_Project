package Test1;

import joinery.DataFrame;
import org.knowm.xchart.*;
import org.knowm.xchart.style.colors.ChartColor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("Started");

        //titanic.csv

        List<TitanicPassenger> passengers = new ArrayList<>();
        passengers =TitanicPassenger.getPassengersFromCSVFile("titanic.csv");


        //xchart
        Map<Integer, Long> groupBySex = passengers.stream().collect(Collectors.groupingBy(TitanicPassenger::getSex,Collectors.counting()));
        System.out.println(groupBySex);

        // Create ChartPie
        PieChart chart1 = new PieChartBuilder().width (800).height (600).title ("Males to Females Ratio").build ();
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120)};
//        chart1.getStyler().setSeriesColors(sliceColors);
        // Series
        chart1.addSeries("Male", groupBySex.get(0));
        chart1.addSeries("Females", groupBySex.get(1));
        // Show it
        new SwingWrapper(chart1).displayChart();

        //histogram
        List<Double> fare = passengers.stream().map(TitanicPassenger::getFare).collect(Collectors.toList());
        System.out.println(fare);

        CategoryChart chart2 = new CategoryChartBuilder().width(800).height(600).title("Fare Histogram").xAxisTitle("Fares").yAxisTitle("Count").build();
        Histogram histogram = new Histogram(fare,10);
        chart2.addSeries("FareHistogram",histogram.getxAxisData(),histogram.getxAxisData());
        new SwingWrapper(chart2).displayChart();



     
    }
}
