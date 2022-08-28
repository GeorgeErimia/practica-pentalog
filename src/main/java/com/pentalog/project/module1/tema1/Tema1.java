package com.pentalog.project.module1.tema1;

import java.util.Scanner;

public class Tema1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String name = "";
        int age = 0;
        boolean isStudent = false;
        int studentYear = 0;

        do{
            System.out.print("Cum te numesti? : ");
            name = keyboard.nextLine();
            if(name == ""){
                System.out.println("Imi pare rau, trebuie sa introduci ceva!");
            }
        }while(name == "");

        System.out.println("Salut, " + name);

        do{
            System.out.print("Cati ani ai? : ");
            age = keyboard.nextInt();
            if(age <= 0)
                System.out.println("Nici macar nu te-ai nascut!! Incearca din nou");
        }while(age <= 0);

        if(age >= 18){
            System.out.print("Esti student (true - false)? : ");
            isStudent = keyboard.nextBoolean();
        }
        else System.out.println("Esti prea mic pentru acest chestionar. Mersi de intelegere. PA!!!");

        if(isStudent){
            do{
                System.out.print("In ce an esti? : ");
                studentYear = keyboard.nextInt();
                if(studentYear <= 0){
                    System.out.println("Nici macar nu este un an universitar! Incearca din nou!");
                }
            }while(studentYear <= 0);
        }

        switch(studentYear){
            case 1:
                System.out.println("O sa fie fain, simte-te bine! :)");
                break;
            case 2:
                System.out.println("Incepi sa te obisnuiesti, nice! :)");
                break;
            case 3:
                System.out.println("Cum merg examenele boss? Ai restante?");
                break;
            case 4:
                System.out.println("Sigur nu esti la mate-info, ca faceai 3 ani...");
                break;
            case 5:
                System.out.println("Oh god... ori repeti anul ori esti la... medicina??");
                break;
            case 6:
                System.out.println("Deja te-ai saturat, este? Medicina vietii...");
                break;
            default:
                System.out.println("Woah... Ce naiba cumetre!!!");
        }

    }
}

