package SortAlgo;
import java.awt.EventQueue;


public class Main {

	/**
     * Launch the application.
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
