package com.banknoteGenerator;
// Se importa libraria care genereaza numere random
import java.util.Random;

public class RandomNumbers {
    // Clasa care va genera numere aleatoare intre 10 si 60
    // proprietatile clasei sunt numarul minim si cel maxim
    private static final int MIN=1;
    private static final int MAX=60;

    // o functie statica care sa returneze un numar din intervalul definit prin intermediul proprietatilor
    public static int getRandom()
    {
        // Se instantiaza clasa din libraria java care genereaza numere aleatoare
        Random rand=new Random();
        // Este generat si returnat un numar aleator din interval
        return rand.nextInt(MAX-MIN)+MIN;
    }

} // end class