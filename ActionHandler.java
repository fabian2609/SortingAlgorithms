package Version2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sum.kern.*;
/**
 * @author  Julian Schmitt & Fabian Menn
 * @version 21.11.2018
 */
public class ActionHandler implements ActionListener{  
    private Stift meinStift;
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Gui.btnBubbleSort) {
            
            startSortThread(Sort.bubble,640,480);
            
        } else if (e.getSource() == Gui.btnSelectionSort) {
            
            startSortThread(Sort.selection,640,480);
            
        } else if (e.getSource() == Gui.btnInsertionSort) {
            
            startSortThread(Sort.insertion,640,480);
            
        } else if (e.getSource() == Gui.btnQuickSort) {
            
            startSortThread(Sort.quick,640,480);
            
        } else if (e.getSource() == Gui.btnAlle) {
            new Bildschirm(1400,1000);
            startSortThreadAll(Sort.bubble, 100, 850);
            startSortThreadAll(Sort.quick, 100, 400);
            startSortThreadAll(Sort.selection, 800, 850);
            startSortThreadAll(Sort.insertion, 800, 400);
            
        }
    }
    
    private void startSortThread(Sort option, int width, int height)
    {
        new Bildschirm(width,height);
        meinStift = new Stift();
        meinStift.normal();
        meinStift.bewegeBis(width/10,height/10);
        meinStift.schreibeText("Hallo");
        
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                new Demo(option, width/10, height-80);
            }
        });
        
        t1.start();
    }
    
    private void startSortThreadAll(Sort option, int xPos, int yPos)
    {
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                new Demo(option, xPos, yPos);
            }
        });
        
        t1.start();
    }
    
    public Bar[] createRandNum(int size) {
        Bar[] barArr = new Bar[size];

        for (int i = 0; i < size; i++) {
            int randomLength = (int) (Math.random() * 300 + 10);

            barArr[i] = new Bar(randomLength);
        }
        
        return barArr;
    }
    
}
