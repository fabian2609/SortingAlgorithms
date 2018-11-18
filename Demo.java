
import java.awt.Color;
import sum.kern.*;
import sum.werkzeuge.*;

/*
 * TODO: 
 *  - Balken Klasse --> für andere Farbe (make it Comparable)
 *  - verschiedene Algorithmen gleichzeitig (multi threading)
 *  - Anzahl an Rechenschritten berechnen
 */

public class Demo {
	
	//int[] len = { 100, 40, 70, 20, 80, 40, 120, 50, 60, 90, 10, 30 };

	Bar[] barArr;

	private int yPoint, xPoint;

	Buntstift meinStift;
	Uhr meineUhr;

	public Demo(Sort option, int xPoint, int yPoint) {

		meineUhr = new Uhr();

		meinStift = new Buntstift();

		this.yPoint = yPoint;
		this.xPoint = xPoint;

		createLengths(20);

		placeSortLable(option);

		if (option == Sort.quick)
			quickSort(barArr, 0, barArr.length-1);
		else if (option == Sort.insertion)
			insertionSort(barArr);
		else if (option == Sort.selection)
			selectionSort(barArr);
		else if (option == Sort.bubble)
			bubbleSort(barArr);

		
	}
	

	////////////////**********  INSERTION SORT **********////////////////
	
	public void insertionSort(Bar arr[]) {
		int n = arr.length;

		arr[0].setColor(Color.GREEN);

		for (int i = 1; i < n; ++i) {
			Bar[] copyArr = dublicateArray(); // new Bar[barArr.length]; System.arraycopy( barArr, 0, copyArr, 0,
												// barArr.length );

			int key = arr[i].getLength();
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j].getLength() > key) {
				arr[j + 1].setLength(arr[j].getLength());
				arr[j + 1].setColor(Color.GREEN);
				arr[j].setColor(Color.RED);
				j = j - 1;
				radiereBalken(copyArr);
				zeichneBalken(arr);
				meineUhr.warte(50);
			}
			arr[j + 1].setLength(key);
			arr[j + 1].setColor(Color.GREEN);

			radiereBalken(copyArr);
			zeichneBalken(arr);
			meineUhr.warte(50);
		}
	}
	
	
	////////////////**********  SELECTION SORT **********////////////////

	public void selectionSort(Bar[] arr) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			Bar[] copyArr = dublicateArray();

			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				// copyArr = dublicateArray();
				arr[j].setColor(Color.BLUE);
				if (arr[j].getLength() < arr[min_idx].getLength()) {
					arr[min_idx].setColor(Color.BLACK);
					min_idx = j;
					arr[j].setColor(Color.RED);

				}
				radiereBalken(copyArr);
				zeichneBalken(arr);
				meineUhr.warte(50);

				if (arr[j].getColor() == Color.BLUE)
					arr[j].setColor(Color.BLACK);
			}

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx].getLength();
			arr[min_idx].setLength(arr[i].getLength());
			arr[i].setLength(temp);
			arr[min_idx].setColor(Color.BLACK);
			arr[i].setColor(Color.GREEN);

			if (i == n - 2)
				arr[arr.length - 1].setColor(Color.GREEN);

			radiereBalken(copyArr);
			zeichneBalken(arr);
			meineUhr.warte(50);
		}
	}

	
	////////////////**********  BUBBLE SORT **********////////////////
	
	public void bubbleSort(Bar[] arr) {
		Bar[] copyArr = dublicateArray();

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < n - i - 1; j++) {
				copyArr = dublicateArray();
				arr[j + 1].setColor(Color.RED);
				if (arr[j].getLength() > arr[j + 1].getLength()) {
					// swap temp and arr[i]
					int temp = arr[j].getLength();
					arr[j].setLength(arr[j + 1].getLength());
					arr[j + 1].setLength(temp);

				}
				arr[j].setColor(Color.BLACK);
				radiereBalken(copyArr);
				zeichneBalken(arr);
				meineUhr.warte(50);
			}

			arr[n - i - 1].setColor(Color.GREEN);

			if (i == n - 2)
				arr[0].setColor(Color.GREEN);

			radiereBalken(copyArr);
			zeichneBalken(arr);
			meineUhr.warte(50);
		}

	}
	
	
	////////////////**********  QUICK SORT **********////////////////

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	int partition(Bar[] arr, int low, int high) {
		
		Bar[] copyArr = dublicateArray();
		
		int pivot = arr[high].getLength();
		arr[high].setColor(Color.RED);
		
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			
			
			
			
			// If current element is smaller than or
			// equal to pivot
			if (arr[j].getLength() <= pivot) {
				copyArr = dublicateArray();
				i++;
				
				arr[j].setColor(Color.BLUE);
				arr[i].setColor(Color.CYAN);
				
				// swap arr[i] and arr[j]
				int temp = arr[i].getLength();
				arr[i].setLength(arr[j].getLength());
				arr[j].setLength(temp);
				
				radiereBalken(copyArr);
				zeichneBalken(arr);
				meineUhr.warte(200);
			}
			
			
			
			arr[j].setColor(Color.BLACK);
			if (i >= low)
				arr[i].setColor(Color.BLACK);
		}
		copyArr = dublicateArray();
		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1].getLength();
		arr[i + 1].setLength(arr[high].getLength()); 
		arr[high].setLength(temp);
		arr[high].setColor(Color.BLACK);
		
		radiereBalken(copyArr);
		zeichneBalken(arr);
		meineUhr.warte(50);

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	public void quickSort(Bar[] arr, int low, int high) {
		
		Bar[] copyArr = dublicateArray();
		
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);
			
			arr[pi].setColor(Color.GREEN);
			
			// Recursively sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			
			quickSort(arr, pi + 1, high);
		} else {
			if (low == high)
				arr[low].setColor(Color.GREEN);
		}
		
		radiereBalken(copyArr);
		zeichneBalken(arr);
		meineUhr.warte(50);
	}

	
	
	
	////////////////**********  Graphics **********////////////////
	
	public void zeichneBalken(Bar[] drawArr) {
		meinStift.normal();

		meinStift.setzeFuellmuster(1);

		// int yPoint = 400;

		for (int i = drawArr.length - 1; i >= 0; i--) {
			int width = 20;
			int height = (int) drawArr[i].getLength();

			meinStift.bewegeBis(xPoint + (25 * i), yPoint - height);

			meinStift.setzeFarbe(drawArr[i].getColor());

			meinStift.zeichneRechteck(width, height);

		}
	}

	public void radiereBalken(Bar[] copy) {
		meinStift.setzeFuellmuster(1);

		meinStift.radiere();

		// int yPoint = 400;

		for (int i = copy.length - 1; i >= 0; i--) {
			int width = 20;
			int height = (int) copy[i].getLength();

			meinStift.bewegeBis(xPoint + (25 * i), yPoint - height);

			meinStift.zeichneRechteck(width, height);

		}
	}
	
	public void placeSortLable(Sort option)
	{
		meinStift.bewegeBis(xPoint+200, yPoint-350);
		meinStift.setzeSchriftGroesse(40);
		
		if (option == Sort.quick)
			meinStift.schreibeText("Quicksort");
		else if (option == Sort.insertion)
			meinStift.schreibeText("Insertionsort");
		else if (option == Sort.selection)
			meinStift.schreibeText("Selectionsort");
		else if (option == Sort.bubble)
			meinStift.schreibeText("Bubblesort");
		
	}
	
	
	////////////////**********  Side Tasks **********////////////////

	public void createLengths(int size) {
		barArr = new Bar[size];

		for (int i = 0; i < size; i++) {
			int randomLength = (int) (Math.random() * 300 + 10);

			barArr[i] = new Bar(randomLength); // 5*i + 20;
		}
	}

	public Bar[] dublicateArray() {
		Bar[] clonedArr = new Bar[barArr.length];
		for (int i = 0; i < barArr.length; i++) {
			clonedArr[i] = new Bar(barArr[i].getLength());
		}

		return clonedArr;
	}
	
}

