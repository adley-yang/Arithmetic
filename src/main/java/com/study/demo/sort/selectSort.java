package com.study.demo.sort;

/**
 * Project Name:Arithmetic
 * Package Name:com.study.demo.sort
 * Date:14-11-26 下午7:07
 * Copyright (c) 2014, adleyyang.cn@gmail.com All Rights Reserved.
 */
class ArraySel
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArraySel(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------

    /**
     * 选择排序：
     * 1.首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2.再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
     * 3.以此类推，直到所有元素均排序完毕
     */
    public void selectionSort()
    {
        int out, in, min;

        for(out=0; out<nElems-1; out++)   // outer loop
        {
            min = out;                     // minimum
            for(in=out+1; in<nElems; in++) // inner loop
                if(a[in] < a[min] )         // if min greater,
                    min = in;               // we have a new min
            swap(out, min);                // swap them
        }  // end for(out)
    }  // end selectionSort()
    //--------------------------------------------------------------
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArraySel
////////////////////////////////////////////////////////////////
class SelectSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        ArraySel arr;                 // reference to array
        arr = new ArraySel(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();                // display items

        arr.selectionSort();          // selection-sort them

        arr.display();                // display them again
    }  // end main()
}  // end class SelectSortApp