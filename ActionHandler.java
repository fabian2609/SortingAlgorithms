package SortAlgo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sum.kern.Bildschirm;

public class ActionHandler implements ActionListener{

		
	public void actionPerformed(ActionEvent e) {
		
		Bar[] barArr = createRandNum(20);

		if (e.getSource() == Gui.btnBubbleSort) {
			startSortThread(Sort.bubble);
			
		} else if (e.getSource() == Gui.btnSelectionSort) {
			
			startSortThread(Sort.selection);
			
		} else if (e.getSource() == Gui.btnInsertionSort) {
			
			startSortThread(Sort.insertion);
			
		} else if (e.getSource() == Gui.btnQuickSort) {
			startSortThread(Sort.quick);
			
		} else if (e.getSource() == Gui.btnAlle) {
			new Bildschirm(1400,1000);
			startSortThread(Sort.bubble, 100, 850);
			startSortThread(Sort.quick, 100, 400);
			startSortThread(Sort.selection, 800, 850);
			startSortThread(Sort.insertion, 800, 400);
		}
	}
	
	private void startSortThread(Sort option)
	{
		new Bildschirm(640,480);
		
		Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				new Demo(option, 50, 400);
			}
		});
		
		t1.start();
	}
	
	private void startSortThread(Sort option, int xPos, int yPos)
	{
		//Bar[] barArrCopy = new Bar[barArr.length];
		//System.arraycopy( barArr, 0, barArrCopy, 0, barArr.length );

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

			barArr[i] = new Bar(randomLength); // 5*i + 20;
		}
		
		return barArr;
	}
	
}