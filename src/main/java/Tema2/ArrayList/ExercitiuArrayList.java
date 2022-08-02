package Tema2.ArrayList;

import java.util.ArrayList;

public class ExercitiuArrayList {

    private static void printArray(ArrayList<String> list){
        System.out.print("Lista are " + list.size() + " elemente: ");

        // Parcurgem lista cu foreach
        for(String str : list){
            System.out.print(str + " ");
        }
        System.out.println("\r\n");
    }
    private static void exec(){

    }
    public static void main(String[] args) {
        exec();
    }
}
