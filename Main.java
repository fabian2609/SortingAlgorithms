package Version2;
import java.awt.EventQueue;
/**
 * @author Julian Schmitt
 * @version 21.11.2018
 */
public class Main {
	/**
     * Startet das Programm
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() 
            {
                public void run() 
                {
                    try {
                        Gui window = new Gui();
                        window.mainFrame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        
        
    }

}
