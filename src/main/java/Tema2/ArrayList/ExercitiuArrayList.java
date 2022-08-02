package Tema2.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

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
        System.out.println("---------------ArrayList--------------");
        ArrayList<String> listOne = new ArrayList<>();
        listOne.add("George");
        listOne.add("Marius");
        listOne.add("Razvan");
        listOne.add("Mihai");
        listOne.add("Alex");


        System.out.println("   LISTA 1 \r\n");
        printArray(listOne);

        // Remove by object
        listOne.remove("Marius");
        System.out.println("A fost sters elementul \"Marius\"");
        printArray(listOne);

        // Remove by index
        listOne.remove(2);
        System.out.println("A fost sters elementul de pe pozitia 2");
        printArray(listOne);


        // Crearea listei 2 identica cu lista 1
        ArrayList<String> listTwo = new ArrayList<>(listOne);

        System.out.println("    LISTA 2 \r\n");
        printArray(listTwo);


        // FOLOSIM EQUALS PENTRU A VERIFICA DACA DOUA OBIECTE SUNT IDENTICE
        // if(listOne == listTwo) -> nu va functiona
        if(listOne.equals(listTwo)){
            System.out.println("Listele sunt identice\r\n");
        }
        else System.out.println("Listele nu sunt identice\r\n");

        //listTwo.add("Lucian");
        //System.out.println("A fost adaugat \"Lucian\" in lista 2");
        Collections.sort(listTwo);
        System.out.println("Elementele listei 2 au fost sortate in ordine alfabetica!");
        printArray(listTwo);


        if(listOne.equals(listTwo)){
            /*Pentru ca doua liste sa fie identice, acestea trebuie sa aiba aceleasi elemente,
            iar elementele sa fie pe aceeasi pozitie.
             */
            System.out.println("Listele sunt identice\r\n");
        }
        else System.out.println("Listele nu sunt identice\r\n");
    }
    public static void main(String[] args) {
        exec();
    }
}
