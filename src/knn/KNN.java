/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * source : https://github.com/wihoho/KNN/blob/master/src/knn.java
 */
package knn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dika
 */
public class KNN {

    static public List<variabel> dataTraining = new ArrayList<>();
    //data uji
    static double uX1;
    static double uX2;

    /**
     * @param args the command line arguments
     */
    //menambah data uji
    static void tambahData(int i, String name, double x1, double x2, String kelas, double uX1, double uX2) {
        dataTraining.add(new variabel(i + 1, name, x1, x2, kelas));
        dataTraining.get(dataTraining.size() - 1).setJarak(uX1, uX2);
    }

    static void shortDataTraining() {
        List<variabel> tData = new ArrayList<>();
        tData = dataTraining;
        for (int i = 0; i < tData.size(); i++) {
            for (int j = 0; j < tData.size(); j++) {
                variabel cTemp = tData.get(i);
                if (cTemp.jarak < tData.get(j).jarak) {
                    variabel tTemp = tData.get(j);
                    tData.set(i, tTemp);
                    tData.set(j, cTemp);
                }
            }
        }
//        for (int i = 0; i < tData.size(); i++) {
//            System.out.println(tData.get(i).name+" : "+tData.get(i).x1+" : "+tData.get(i).x2+" : "+tData.get(i).kelas+" : "+tData.get(i).jarak);
//        }
        int jumKelasJ = 0;
        int jumKelasB = 0;
        for (int i = 0; i < 3; i++) {
            if (tData.get(i).kelas == "J") {
                jumKelasJ++;
            } else {
                jumKelasB++;
            }
        }
        String hasil = jumKelasJ > jumKelasB ? "J" : "B";
        System.out.println("Hasil dari data uji " + uX1 + " dan " + uX2 + " adalah masuk ke kelas :  " + hasil);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // TODO code application logic here
        //data training
        double[] asam = {8, 4, 4, 7, 5, 6};
        double[] kekuatan = {4, 5, 6, 7, 6, 5};
        String[] kelas = {"B", "J", "J", "B", "J", "B"};
        //data uji
        uX1 = 8;
        uX2 = 8;
        //input data to array data training
        for (int i = 0; i < asam.length; i++) {
            tambahData(i + 1, "T" + (i + 1), asam[i], kekuatan[i], kelas[i], uX1, uX2);
        }

        for (int i = 0; i < dataTraining.size(); i++) {
            System.out.println(dataTraining.get(i).name + " : " + dataTraining.get(i).x1 + " : " + dataTraining.get(i).x2 + " : " + dataTraining.get(i).kelas + " : " + dataTraining.get(i).jarak);
        }
        System.out.println("Nomor urut sudah di short. ");
        shortDataTraining();
    }
}

class variabel {

    String name;
    double x1;
    double x2;
    String kelas;
    double jarak;
    int no_urut;

    variabel(int i, String name, double a, double b, String c) {
        this.no_urut = i;
        this.name = name;
        this.x1 = a;
        this.x2 = b;
        this.kelas = c;
    }

    void setJarak(double nX1, double nX2) {
        this.jarak = Math.sqrt(Math.pow(nX1 - x1, 2) + Math.pow(nX2 - x2, 2));
    }

    void tampilData() {
    }

    double geJarak() {
        return this.jarak;
    }

    void setUrut(int u) {
        this.no_urut = u;
    }

    int getUrut() {
        return this.no_urut;
    }

    variabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    double getx1() {
        return this.x1;
    }
}
