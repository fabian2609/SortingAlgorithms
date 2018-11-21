package SortAlgo;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gui {
    static JFrame mainFrame;                                                                    //Deklaration des Frames
    static JButton btnBubbleSort, btnSelectionSort, btnInsertionSort,btnQuickSort, btnAlle;     //Deklaration der Knöpfe
    static int width = 160;                                                                     
    static int height = 235;


    /**
     * Create the application.
     */
    public Gui() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Fenster
        mainFrame = new JFrame("Sortieralgorithmen");               //Instanziisiert das Fenster und gibt im den Namen Sortieralgorithmen
        mainFrame.setSize(width, height);                           //Setzt die Größe fest
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Notwendig um das Fenster mit einem Klick auf das X zu schließen
        mainFrame.setLocationRelativeTo(null);                      //Fenster erstellt sich in der Mitte
        mainFrame.setLayout(null);                                        
        mainFrame.setResizable(false);                              //Legt fest, dass sich das Fenster in der Größe nicht anpassen kann(z.B. Vollbild)
        mainFrame.requestFocus();                                   //Setzt das Fenster in den Vordergrund

        // Button BubbleSort    
        btnBubbleSort = new JButton("Bubblesort");                  //Instanziisiert den Knopf und legt den Namen fest                    
        btnBubbleSort.setBounds(20, 15, 120, 25);                   //Setzt den Platz im Fenster(20,15) und die Größe(120,25) an
        btnBubbleSort.setVisible(true);                             //Setzt die Sichtbarkeit des Knopfes auf "true"
        btnBubbleSort.addActionListener (new ActionHandler());      //Verweist auf die Klasse ActionHandler um eine Methode auszuführen wenn der Knopf gedrückt wird
        btnBubbleSort.setBackground(new Color(128, 128, 128));      //Legt die Hintergrundfarbe des Knopfes fest
        btnBubbleSort.setFont(new Font("Arial", Font.PLAIN, 18));   //Legt die Schriftfamilie, Schriftart und Schriftgröße fest      
        btnBubbleSort.setForeground(Color.WHITE);                   //Legt die Schriftfarbe fest
        btnBubbleSort.setBorder(null);                              //Man hat keine Ränder des Knopfes
        btnBubbleSort.setFocusPainted(false);                       //Die Schrift des Knopfes hat keinen Focus in Form eines Rechtecks um die Schrift
        btnBubbleSort.addMouseListener(new MouseAdapter()           //ändert die Farbe des Buttons minimal wennn man dem Mauszeiger innerhalb der angegeben Grenzen ist
            {
                public void mouseEntered(MouseEvent evt) {
                    btnBubbleSort.setBackground(new Color(169, 169, 169));
                    btnBubbleSort.setForeground(Color.WHITE);
                }

                public void mouseExited(MouseEvent evt) {
                    btnBubbleSort.setBackground(new Color(128, 128, 128));
                    btnBubbleSort.setForeground(Color.WHITE);
                }
            });

        mainFrame.add(btnBubbleSort);                               //fügt den Knopf dem Fenster hinzu

        // Button SelectionSort
        btnSelectionSort = new JButton("Selectionsort");
        btnSelectionSort.setBounds(20, 55, 120, 25);
        btnSelectionSort.setVisible(true);
        btnSelectionSort.addActionListener (new ActionHandler());
        btnSelectionSort.setBackground(new Color(128, 128, 128));
        btnSelectionSort.setFont(new Font("Arial", Font.PLAIN, 18));
        btnSelectionSort.setForeground(Color.WHITE);
        btnSelectionSort.setBorder(null);
        btnSelectionSort.setFocusPainted(false);
        btnSelectionSort.addMouseListener(new MouseAdapter() 
            {

                public void mouseEntered(MouseEvent evt) {
                    btnSelectionSort.setBackground(new Color(169, 169, 169));
                    btnSelectionSort.setForeground(Color.WHITE);
                }

                public void mouseExited(MouseEvent evt) {
                    btnSelectionSort.setBackground(new Color(128, 128, 128));
                    btnSelectionSort.setForeground(Color.WHITE);
                }

            });

        mainFrame.add(btnSelectionSort);

        // Button Insertionsort
        btnInsertionSort = new JButton("Insertionsort");
        btnInsertionSort.setBounds(20, 95, 120, 25);
        btnInsertionSort.setVisible(true);
        btnInsertionSort.addActionListener (new ActionHandler());
        btnInsertionSort.setBackground(new Color(128, 128, 128));
        btnInsertionSort.setFont(new Font("Arial", Font.PLAIN, 18));
        btnInsertionSort.setForeground(Color.WHITE);
        btnInsertionSort.setBorder(null);
        btnInsertionSort.setFocusPainted(false);
        btnInsertionSort.addMouseListener(new MouseAdapter() 
            {

                public void mouseEntered(MouseEvent evt) {
                    btnInsertionSort.setBackground(new Color(169, 169, 169));
                    btnInsertionSort.setForeground(Color.WHITE);
                }

                public void mouseExited(MouseEvent evt) {
                    btnInsertionSort.setBackground(new Color(128, 128, 128));
                    btnInsertionSort.setForeground(Color.WHITE);
                }

            });

        mainFrame.add(btnInsertionSort);

        // Button Quicksort
        btnQuickSort = new JButton("Quicksort");
        btnQuickSort.setBounds(20, 135, 120, 25);
        btnQuickSort.setVisible(true);
        btnQuickSort.addActionListener (new ActionHandler());
        btnQuickSort.setBackground(new Color(128, 128, 128));
        btnQuickSort.setFont(new Font("Arial", Font.PLAIN, 18));
        btnQuickSort.setForeground(Color.WHITE);
        btnQuickSort.setBorder(null);
        btnQuickSort.setFocusPainted(false);
        btnQuickSort.addMouseListener(new MouseAdapter() 
            {

                public void mouseEntered(MouseEvent evt) {
                    btnQuickSort.setBackground(new Color(169, 169, 169));
                    btnQuickSort.setForeground(Color.WHITE);
                }

                public void mouseExited(MouseEvent evt) {
                    btnQuickSort.setBackground(new Color(128, 128, 128));
                    btnQuickSort.setForeground(Color.WHITE);
                }

            });

        mainFrame.add(btnQuickSort);

        // Button Alle
        btnAlle = new JButton("Alle");
        btnAlle.setBounds(20, 175, 120, 25);
        btnAlle.setVisible(true);
        btnAlle.addActionListener (new ActionHandler());
        btnAlle.setBackground(new Color(128, 128, 128));
        btnAlle.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAlle.setForeground(Color.WHITE);
        btnAlle.setBorder(null);
        btnAlle.setFocusPainted(false);
        btnAlle.addMouseListener(new MouseAdapter() 
            {

                public void mouseEntered(MouseEvent evt) {
                    btnAlle.setBackground(new Color(169, 169, 169));
                    btnAlle.setForeground(Color.WHITE);
                }

                public void mouseExited(MouseEvent evt) {
                    btnAlle.setBackground(new Color(128, 128, 128));
                    btnAlle.setForeground(Color.WHITE);
                }

            });

        mainFrame.add(btnAlle);
    }
}
