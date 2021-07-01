package com.banknoteGenerator;

// Clasa care deseneaza bancnotele
public class DrawManager {
    // Trei proprietati pentru stocarea bancnotelor si a pozitiei in care sa fie desenate orizontal si vertical.
    private Banknote[] banknotes;
    private int horizontal=0;
    private int vertical=0;

    // Constructorul primeste lista de bancnote.
    public DrawManager(Banknote[] pBanknotes)
    {
        // Bancnotele sunt atribuite proprietatii clasei.
        banknotes = pBanknotes;
        // Este apelata functia care va desena bancnotele din lista primita.
        startDrawing();
    } // end constructor

    // Functia care deseneaza bancnotele
    private   void startDrawing()
    {
        // Se parcurge lista de bancnote
        for(int i=0; i<banknotes.length; i++)
        {
            // Folosind conceptul de polimorfism, functia draw a fiecarei clase deseneaza cate o bancnota la pozitiile orizontal si vertical indicate.
            banknotes[i].draw(horizontal, vertical);
            // Se inainteaza cu pozitia pentru urmatoarea desenare.
            horizontal++;
            // Daca se schimba tipul bancnotei, orizontalul se reia de la 0 iar verticalul creste.
            if(isNewLine(i))
            {
                vertical++;
                horizontal=0;
            }
        }
    } // end startDrawing

    // O functie care verifica daca bancnota curenta si cea urmatoare sunt identice ca valoare. In caz ca ele sunt diferite functia returneaza true iar mai sus se schimba coordonata verticala si se reseteaza  cea orizontala.
    private boolean isNewLine(int iIndex)
    {
        if(iIndex+1<banknotes.length)
        {
            if(banknotes[iIndex].getValue()!=banknotes[iIndex+1].getValue())
                return true;
        }
        return false;
    }

} // end class