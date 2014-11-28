package com.study.demo.sort;

/**
 * Project Name:Arithmetic
 * Package Name:com.study.demo.sort
 * Date:14-11-28 上午10:20
 * Copyright (c) 2014, adleyyang.cn@gmail.com All Rights Reserved.
 */
class ArraySh
{
    private long[] theArray;          // ref to array theArray
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArraySh(int max)           // constructor
    {
        theArray = new long[max];      // create the array
        nElems = 0;                    // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        System.out.print("A=");
        for(int j=0; j<nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------

    /**
     * 希尔排序：（递减增量排序算法）（非稳定排序算法）
     * 1.先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。
     * 2.所有距离为d1的倍数的记录放在同一个组中。
     * 3.先在各组内进行直接插入排序；
     * 4.然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量=1(<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
     */
    public void shellSort()
    {
        int inner, outer;
        long temp;

        int h = 1;                     // find initial value of h
        while(h <= nElems/3)
            h = h*3 + 1;                // (1, 4, 13, 40, 121, ...)

        while(h>0)                     // decreasing h, until h=1
        {
            // h-sort the file
            for(outer=h; outer<nElems; outer++)
            {
                temp = theArray[outer];
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while(inner > h-1 && theArray[inner-h] >=  temp)
                {
                    theArray[inner] = theArray[inner-h];
                    inner -= h;
                }
                theArray[inner] = temp;
            }  // end for
            h = (h-1) / 3;              // decrease h
        }  // end while(h>0)
    }  // end shellSort()
//--------------------------------------------------------------
}  // end class ArraySh
////////////////////////////////////////////////////////////////
class ShellSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 10;             // array size
        ArraySh arr;
        arr = new ArraySh(maxSize);   // create the array

        for(int j=0; j<maxSize; j++)  // fill array with
        {                          // random numbers
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.display();                // display unsorted array
        arr.shellSort();              // shell sort the array
        arr.display();                // display sorted array
    }  // end main()
}  // end class ShellSortApp