package Tema1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExercitiuRegex {
    public static void exec(){
        System.out.println("-------------REGEX------------");
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Salut, te rog sa te prezinti folosind textul \"Ma numesc ... si am ... ani\"");
        Pattern pattern = Pattern.compile("Ma numesc [a-z]+ si am \\d+ ani", Pattern.CASE_INSENSITIVE);

        String mesaj = keyboard.nextLine();

        Matcher matcher = pattern.matcher(mesaj);

        boolean matchFound = matcher.find();
        if(matchFound){
            System.out.println("DA");
        }
        else System.out.println("NU");
    }
    public static void main(String[] args) {
        exec();
    }
}
