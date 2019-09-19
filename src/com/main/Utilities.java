package com.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Utilities {

    static ArrayList<Coordinates> readDataFromFile(String fileName) {

        ArrayList<Coordinates> arrayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            double x, y;

            while((line = bufferedReader.readLine()) != null) {
                x = Double.parseDouble(line.split(",")[0]);
                y = Double.parseDouble(line.split(",")[1]);
                Coordinates coordinates = new Coordinates();
                coordinates.setX(x);
                coordinates.setY(y);
                arrayList.add(coordinates);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return arrayList;
    }

    static double calculateThetaZero(double thetaZero, double thetaOne, double alpha, ArrayList<Coordinates> arrayList) {

        double sum, h;
        sum = 0;
        for(int i = 0; i < arrayList.size(); i++) {
            h = thetaZero + thetaOne * arrayList.get(i).getX();
            sum += h - arrayList.get(i).getY();
        }
        return thetaZero - (alpha / arrayList.size()) * sum;
    }

    static double calculateThetaOne(double thetaZero, double thetaOne, double alpha, ArrayList<Coordinates> arrayList) {

        double sum, h;
        sum = 0;
        for(int i = 0; i < arrayList.size(); i++) {
            h = thetaZero + thetaOne * arrayList.get(i).getX();
            sum += (h - arrayList.get(i).getY()) * arrayList.get(i).getX();
        }
        return thetaOne - (alpha / arrayList.size()) * sum;
    }

    static double calculateCostFunction(double thetaZero, double thetaOne, ArrayList<Coordinates> arrayList) {

        double sum, h;
        sum = 0;
        for(int i = 0; i < arrayList.size(); i++) {
            h = thetaZero + thetaOne * arrayList.get(i).getX();
            sum += Math.pow((h - arrayList.get(i).getY()), 2);
        }
        return 1 / (2 * (double)arrayList.size()) * sum;
    }
}
