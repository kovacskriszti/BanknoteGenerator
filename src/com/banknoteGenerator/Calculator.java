package com.banknoteGenerator;
// Se importan libraria pentru LinkedList, care va ajuta la adaugarea succesiva a bancnotelor
import java.util.LinkedList;

// Clasa care are rolul sa transforme numarul aleator de tip int intr-un array de bancnote pentru a fi desenate
public class Calculator {
    // Suma care trebuie reprezentata
    private int value;
    // Lista temporara in care sunt stocate bancnotele inainte de a fi convertite intr-un array clasic. S-a preferat aceasta metoda datorita posibilitatii de alocare dinamica a intrarilor in lista.
    private LinkedList<Banknote> banknotes = new LinkedList<>();
// Constructorul care atribuie valoarea in variabila clasei.
    public Calculator(int pValue)
    {
        value=pValue;
    } // end constructor

    // O functie care apeleaza metoda de calcul si care converteste LinkedList-ul obtinut in array clasic
    public Banknote[] getBanknotes()
    {
        // Se genereaza lista de bancnote
        addBanknotesIntoList();
        // Lista este convertita in array de Banknote
        return banknotes.toArray(new Banknote[banknotes.size()]);
    } // end getBanknotes

    // O functie care apeleaza succesiv 3 metode, cate o metoda pentru fiecare tip de bancnota, respectiv 10, 5 si 1.
    private void addBanknotesIntoList()
    {
        addTens();
        addFives();
        addOnes();
    } // end addBanknotesIntoList

    // Urmeaza trei metode asemanatoare pentru adaugarea bancnotelor de 10, 5 si 1 in lista.
    private void addTens() {
        // Se apeleaza o metoda care returneaza numarul  de bancnote de un fel care sunt extrase din suma totala.
        int amount=substractAndCount(10);
        // Pentru fiecare unitate este creata bancnota cu valoarea corespunzatoare, in acest caz pentru valoarea 10.
            while(amount>0)
            {
                // Bancnota creata se adauga in lista.
                banknotes.add(new Ten());
                // Decrementarea care semnaleaza crearea unei bancnote
                amount--;
            }
    } // end addTens

    // Identic dar pentru bancnote cu valoarea 5
    private void addFives() {
        int amount=substractAndCount(5);
            while(amount>0) {
                banknotes.add(new Five());
                amount--;
            }
    } // end addFives

    // Identic dar pentru bancnote cu valoarea 1
    private void addOnes() {
        int amount=substractAndCount(1);
            while(amount>0) {
                banknotes.add(new One());
                amount--;
            }
    } // end addOnes

    // Metoda care calculeaza numarul de bancnote de un fel care intra in suma totala, si scade din total suma bancnotelor gasite.
    private int substractAndCount(int pValue)
    {
        // Numarul de bancnote gasite
        int amount=0;
        // Se executa doar daca valoarea parametrului este mai mica decat suma, totala, adica daca exista cel putin o bancnota care sa intre in total
        if(value>=pValue)
        {
            // Se calculeaza de cate ori o bancnota intra in total pentru a determina numarul de bancnote de un fel.
             amount=value/pValue;
             // Se scad din total bancnotele gasite prin inmultirea valorii si a numarului bancnotelor
            value-=amount*pValue;
        }
        // Se returneaza numarul de bancnote gasite
        return amount;
    } // end substractAndCount

} // end class