package dataStructure.HeightArray;

/**
 * Created by Jitana on 2016/10/27.
 */
public class HightArray {
    private long[] a; //ref to array a;
    private int nElems; //number of data items

    public HightArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchkey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchkey)
                break;
        if (j == nElems) {
            return false;
        } else {
            return true;
        }
    }


    public void insert(long value) {
        a[nElems] = value;  //insert it
        nElems++;   //increment size;
    }

    public boolean delete(long value) {
        int j;
        for(j = 0;j < nElems;j++)
            if(value == a[j])
                break;
        if(nElems == j)
            return false;
        else{
            for(int k = j;k < nElems;k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + "");
        }
    }

}

class HightArrayApp{
    public static void  main(String[] args) {
        int maxSize = 100;
        HightArray arr;
        arr = new HightArray(maxSize);

        arr.insert(77);
        arr.insert(67);
        arr.insert(37);
        arr.insert(17);
        arr.insert(57);
        arr.insert(87);
        arr.insert(97);
        arr.insert(27);
        arr.insert(37);

        
    }
}
