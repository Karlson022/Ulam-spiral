import java.awt.*;
import java.awt.event.*;

public class Main extends Frame{
    public static void main(String[] args) {
        new Main();
        
    }

    public Main(){
        super();
        setSize( 1080,1080);
        setVisible(true);
        addComponentListener(new ComponentAdapter(){
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);

        //środek okna, punkt wyjścia
        int x = getWidth()/2;
        int y = getHeight()/2;
        
        int liczba = 1; //nr pixela do zamalowania
        int kierunek = 0; //zmiana kierunku (switch)
        int counter = 0; //sekwencja przed switchem max 2
        int sekwencja = 1; //ile razy wykona się przejscie z rysowaniem
        int n = 1; //odległość miedzy liczbami (jeden pixel)
        int z = 0; //licznik wykonań

       
        //wykonuje się do zapełnienia okna
        while(z != ((getWidth()*getHeight())*10)){
        switch(kierunek){
            case 0:
            //sekwencja rysowania i przesuniecia
                for(int i = 1; i <= sekwencja; i++){
                    if(czyPierwsza(liczba)){
                        g.drawLine(x, y, x, y);
                    }
                    x+=n; //przejscie w prawo
                    liczba++;
                }
                counter++;
                break;
            case 1:
                for(int i = 1; i <= sekwencja; i++){
                    if(czyPierwsza(liczba)){
                        g.drawLine(x, y, x, y);
                    }
                    y-=n; //przejscie w góre
                    liczba++;
                }
                counter++;
                break;
            case 2:
                for(int i = 1; i <= sekwencja; i++){
                    if(czyPierwsza(liczba)){
                        g.drawLine(x, y, x, y);
                    }
                    x-=n; //przejscie w lewo
                    liczba++;
                }
                counter++;
                break;
            case 3:
                for(int i = 1; i <= sekwencja; i++){
                    if(czyPierwsza(liczba)){
                        g.drawLine(x, y, x, y);
                    }
                    y+=n; //przescie w dół
                    liczba++;
                }
                counter++;
                break;
        }

        //licznik przed dodaniem kolejnej sekwencji
        if(counter == 2){
            sekwencja++;
            counter = 0;
        }
        //zmiana switcha 
        kierunek++;
        if(kierunek == 4){
            kierunek = 0;
        }
        z++;
    }  
}
    //sprawdzamy czy liczba jest pierwsza
    static boolean czyPierwsza(int x){ 
        if(x < 2){
            return false;
        }
        for (int i = 2; i <= x/2; i++) {  
            if (x % i == 0) {  
                return false;  
            }  
        }
        return true; 
    }
}

