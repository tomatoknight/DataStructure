package dataStructure.OrderedArray;

/**
 * Created by Jitana on 2016/10/24.
 */
public class OrderedArray {
    private long[] a; //ref to array a
    private int nElems; // number of data items


    public OrderedArray(int max) {
        a = new long[max]; // create array
        nElems = 0;

    }

    public int size() {
        return nElems;
    }

    //binary search
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn; //found it
            else if(lowerBound > upperBound)
                return nElems; // can't find it
            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; //it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            }
        } // end while
    }

    public void insert(long value) {
        int j;

        // find where it goes
        for (j = 0; j < nElems;j++) {
            if (a[j] > value) {
                break;
            }
        }

        for (int k = nElems;k > j;k--) // move bigger ones up
             a[k] = a[k - 1];
        a[j] = value;   //insert it
        nElems++;




    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false; // can' find it;
        } else {
            for (int k = j;k < nElems;k++)
                a[k] = a[k + 1];
            nElems--;   //decrement size
            return true;
        }
    }

    public void display() {
        for(int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}
///////////////////////////////////////////////////////////////

class OrededApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrderedArray arr;
        arr = new OrderedArray(maxSize);
        arr.insert(48);
        arr.insert(12);
        arr.insert(48);
        arr.insert(86);
        arr.insert(75);
        arr.insert(20);
        arr.insert(45);
        arr.insert(76);

        arr.display();

        arr.delete(20);

        arr.display();

        System.out.print(arr.find(45));
    }

}
