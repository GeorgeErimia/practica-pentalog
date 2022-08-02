package Tema2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class ExercitiuHashMap {
    private static void printHashMap(HashMap<String, Integer> hashMap){
        // Parcurgere dupa chei -> Se va observa ca jocurile nu se afla in ordinea in care au fost adaugate
        for(String key : hashMap.keySet()){
            System.out.println("joc: " + key +" | anul: " + hashMap.get(key));
        }
    }
    public static void exec(){
        System.out.println("---------------HashMap--------------");

        // O sa stochez intr-un hashMap mai multe perechi de tipul joc video + anul aparitiei

        HashMap<String,Integer> jocuriVideo = new HashMap<>();
        jocuriVideo.put("Diablo I", 1996);
        jocuriVideo.put("World of Warcraft", 2004);
        jocuriVideo.put("Need for Speed II", 1997);
        jocuriVideo.put("Need for Speed Underground II", 2004);
        jocuriVideo.put("Need for Speed Most Wanted", 2005);
        jocuriVideo.put("Hitman I", 2000);
        jocuriVideo.put("Counter Strike 1.6", 2000);
        jocuriVideo.put("Diablo Immortal", 2022);
        jocuriVideo.put("Path of Exile", 2013);
        jocuriVideo.put("Call of Duty", 2003);
        jocuriVideo.put("Overwatch", 2016);
        jocuriVideo.put("7 Days to Die", 2013);
        jocuriVideo.put("DayZ", 2013);

        printHashMap(jocuriVideo);

        // Cauta jocuri dupa anul aparitiei
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\r\nIntroduceti anul aparitiei pe care doriti sa il cautati : ");
        int anAparitie = keyboard.nextInt();
        keyboard.nextLine();

        // Parcurgere dupa valori - nu a fost foarte eficient in cazul acesta
        // Dar am vrut sa fac si o parcurgere dupa valori
        int contor = 0;
        for(Integer an : jocuriVideo.values()){
            if(an == anAparitie)
                contor++;
        }
        if(contor == 0){
            System.out.println("Nu exista niciun joc in baza de date aparut in anul " + anAparitie);
        }
        else{
            System.out.println("Numar jocuri: " + contor + " => ");
            // Parcurgere dupa chei
            for(String key : jocuriVideo.keySet()){
                if(jocuriVideo.get(key) == anAparitie)
                    System.out.print(key + ", ");
            }
            System.out.println();
        }


        // Cauta anul aparitiei unui anumit joc

        System.out.println("Introduceti jocul caruia vreti sa stiti anul aparitiei : ");
        String joc = keyboard.nextLine();
        boolean gasit = false;
        for(String key : jocuriVideo.keySet()){
            if(key.toUpperCase().equalsIgnoreCase(joc)) {
                System.out.println(key + ": " + jocuriVideo.get(key));
                gasit = true;
            }
        }
        if(!gasit){
            System.out.println("Jocul " + joc + " nu a fost gasit!");
        }

        // Sterge un anumit joc din lista dupa numele sau
        System.out.println("\r\nIntroduceti numele unui joc pe care doriti sa il stergeti: ");
        joc = keyboard.nextLine();

        if(jocuriVideo.remove(joc) == null){
            System.out.println("Jocul nu a fost gasit...");
        }
        else{
            System.out.println("Joc eliminat cu succes");
            printHashMap(jocuriVideo);
        }
    }

    public static void main(String[] args) {
        exec();
    }
}
