package Test1;

import com.github.lbovolini.mapper.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TitanicPassenger {
      private int   Passengerid;
      private double   Age;
      private double  Fare;
      private int   Sex;
      private int   sibsp;
      private int   Embarked;
      private int   Survived;

    public TitanicPassenger(int passengerid, double age, double fare, int sex, int sibsp, int embarked, int survived) {
        Passengerid = passengerid;
        Age = age;
        Fare = fare;
        Sex = sex;
        this.sibsp = sibsp;
        Embarked = embarked;
        Survived = survived;
    }

    public TitanicPassenger(String passengerid, String age, String fare, String sex, String sibsp, String embarked, String survived) {
        setPassengerid(passengerid);
        setAge(age);
        setFare(fare);
        setSex(sex);
        setSibsp(sibsp);
        setEmbarked(embarked);
        setSurvived(survived);
    }




    public static List<TitanicPassenger> getPassengersFromCSVFile(String path) throws IOException {
        List<TitanicPassenger> Passengers = new ArrayList<>();

        File file = new File(path);
        List<String> lines = Files.readAllLines(file.toPath());

        for (String line : lines){
            String[]  attributes = line.split(",");

            for (String att : attributes){
                att.trim();
            }
            Passengers.add(new TitanicPassenger(
                    attributes[0],
                    attributes[1],
                    attributes[2],
                    attributes[3],
                    attributes[4],
                    attributes[5],
                    attributes[6]
            ));


        }
        System.out.println("Loading Finish with "+ Passengers.size()+ " Records");
        return Passengers;

    }


    public int getPassengerid() {
        return Passengerid;
    }

    public void setPassengerid(String passengerid) {
        try {
            Passengerid = Integer.valueOf(passengerid);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public double getAge() {
        return Age;
    }

    public void setAge(String age) {
        try {
            Age = Double.valueOf(age);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public double getFare() {
        return Fare;
    }

    public void setFare(String fare) {
        try {
            Fare = Double.valueOf(fare);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        try {
            Sex = Integer.valueOf(sex);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getSibsp() {
        return sibsp;
    }

    public void setSibsp(String sibsp) {
        try {
            this.sibsp = Integer.valueOf(sibsp);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getEmbarked() {
        return Embarked;
    }

    public void setEmbarked(String embarked) {
        try {
            Embarked = Integer.valueOf(embarked);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getSurvived() {
        return Survived;
    }

    public void setSurvived(String survived) {
        try {
            Survived = Integer.valueOf(survived);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setPassengerid(int passengerid) {
        Passengerid = passengerid;
    }

    public void setAge(double age) {
        Age = age;
    }

    public void setFare(double fare) {
        Fare = fare;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public void setSibsp(int sibsp) {
        this.sibsp = sibsp;
    }

    public void setEmbarked(int embarked) {
        Embarked = embarked;
    }

    public void setSurvived(int survived) {
        Survived = survived;
    }
}
