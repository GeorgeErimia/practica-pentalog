package Tema2.HashMap;

import java.util.HashMap;

public class ExercitiuHashMap {
    private static void printHashMap(HashMap<String, Integer> hashMap){
        // Parcurgere dupa chei -> Se va observa ca jocurile nu se afla in ordinea in care au fost adaugate
        for(String key : hashMap.keySet()){
            System.out.println("joc: " + key +" | anul: " + hashMap.get(key));
        }
    }
    public static void exec(){
    }

    public static void main(String[] args) {
        exec();
    }
}
