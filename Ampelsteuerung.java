import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/*
 * Mit dieser Fernbedienung kann man eine echte Hue-Lampe steuern oder 
 * eine simulierte Hue-Lampe
 */
public class Ampelsteuerung {

    // Attribute
    Ampel ampel; // Referenz zur Ampel
    
    int zustand;  // 1: rot, 2: rotgelb, 3: gruen, 4: gelb  
  

    // Konstruktor
    public Ampelsteuerung()
    {
        ampel = new Ampel();
        zustand = 1;
        ampel.setRot(true);
        ampel.setGelb(false);
        ampel.setGruen(false);
        
    }
    
    public void umschalten()
    {
        if (zustand == 1)
        {
            zustand = 2;
            setRotGelb();
        }
        else if (zustand == 2)
        {
            zustand = 3;
            setGruen();
        }
        else if (zustand == 3)
        {
            zustand = 4;
            setGelb();
        }
        else if( zustand == 4)
        {
            zustand = 1;
            setRot();
        }
    }

    
    public void setRot()
    {
        zustand = 1;
        ampel.setRot(true);
        ampel.setGelb(false);
        ampel.setGruen(false);
    }
     public void setRotGelb()
    {
        zustand = 2;
        ampel.setRot(true);
        ampel.setGelb(true);
        ampel.setGruen(false);
    }
     public void setGruen()
    {
        zustand = 3;
        ampel.setRot(false);
        ampel.setGelb(false);
        ampel.setGruen(true);
    }
    public void setGelb()
    {
        zustand = 4;
        ampel.setRot(false);
        ampel.setGelb(true);
        ampel.setGruen(false);
    }
   
    
    
    // Methoden
    /*
     * Diese Methode wird aufgerufen, wenn der an-Button gedrückt wurde
     */
    @FXML
    void rot(ActionEvent event) {
        setRot();
    }

    /*
     * Diese Methode wird aufgerufen, wenn der aus-Button gedrückt wurde
     */
    @FXML
    void gelb(ActionEvent event) {
        setGelb();
    }

    /*
     * Diese Methode wird aufgerufen, wenn der minus-Button gedrückt wurde
     */
    @FXML
    void gruen(ActionEvent event) {
        setGruen();

    }

    /*
     * Diese Methode wird aufgerufen, wenn der plus-Button gedrückt wurde
     */
    @FXML
    void umschalten(ActionEvent event) {        
        umschalten();
    }

    /*
     * Diese Methode wird aufgerufen, wenn die Oberfläche erstellt worden ist
     */
    @FXML
    void initialize() {
        
    }
}
