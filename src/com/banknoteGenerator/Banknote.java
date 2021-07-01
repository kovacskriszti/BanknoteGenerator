package com.banknoteGenerator;

// O clasa pentru reprezentarea bancnotelor
public class Banknote {
    // Valoarea bancnotei
    protected  int value;
    // Culoarea pentru a fi desenata
    protected  String  color;

    // Un constructor gol.
    public Banknote() { } // end constructor

    // Doua metode pentru setarea culorii si a valorii care vor fi folosite de clasele mostenitoare
    protected void setColor(String pColor)
    {
        color=pColor;
    }

    protected void setValue(int pValue)
    {
        value=pValue;
    }

    // Metoda pentru returnarea valorii
    public int getValue() { return value; }

    // Metoda care va desena bancnota
    public void draw(int horizontalPosition, int verticalPosition)
    {
        // Este creat un patrat (nu am gasit dreptunghi in fisierele puse la dispozitie)
        Square sqr=new Square();
        // Este schimbata culoarea. Desi aici variabila pentru culoare e goala, clasele mostenitoare vor seta in constructor culoarea in functie de valoare
        sqr.changeColor(color);
        // Sunt apelate doua functii definite mai jos, in cadrul carora metodele moveRight si moveDown ale clasei Square sunt apelate pentru a deplasa patratul si a crea asezarea in fereastra.
        setHorizontalPosition(sqr, horizontalPosition);
        setVerticalPosition(sqr, verticalPosition);
        // Patratul este afisat.
        sqr.makeVisible();
    }

    // Cele doua functii de mai jos sunt aproape identice, una deplasand patratul in dreapta iar cealalta in jos.
    protected void setVerticalPosition(Square sqrReference, int pos)
    {
        // pos e exprimat in numere intregi relativ la coltul din stanga sus. De exemplu, numarul 2 vertical inseamna al treilea rand de sus in jos.
        // For-ul impinge patratul in dreapta sau in jos de cate ori este nevoie pentru a ajunge la pos.
        for(int i=0; i<pos; i++)
        {
            // Functie este apelata de doua ori pentru a nu suprapune patratele.
            sqrReference.moveDown();
            sqrReference.moveDown();
        }
    }

    // Acelas lucru ca mai sus
    protected void setHorizontalPosition(Square sqrReference, int pos)
    {
        for(int i=0; i<pos; i++)
        {
            sqrReference.moveRight();
            sqrReference.moveRight();
        }
    }

    // Clasele mostenitoare Ten, Five si One numai sunt comentate, ele facand doar atribuirile pentru value si collor.

} // end class