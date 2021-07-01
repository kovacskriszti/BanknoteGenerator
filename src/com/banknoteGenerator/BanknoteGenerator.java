package com.banknoteGenerator;

public class BanknoteGenerator {

   public static void   main(String[] args)
    {
        // Sunt instantiate obiectele claselor  din care este compusa aplicatia
        // se genereaza un numar aleator stocat intr-o variabila int
 int value=RandomNumbers.getRandom();
 // Pentru verificare se poate vedea in consola numarul generat
System.out.println("The represented number is "+value);
// Este creat  un array de bancnote pentru a fi desenate pe baza numarului generat anterior
        Banknote[] banknotes = new Calculator(value).getBanknotes();
        // Array-ul de bancnote este trimis unui obiect care le deseneaza
        new DrawManager(banknotes);
    } // end of main


} // end of class