package org.sunny;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicSort {

    /**
     * 冒泡排序
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr){
        boolean flag = true;
        for (int i=0;i<arr.length & flag;i++){
            for (int j=arr.length-1;j>=i;j--){
                if (arr[j].compareTo(arr[j-1])<0){
                    T temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;

                    flag=false;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 简单选择排序
     */
    public static <T extends Comparable<? super T>> void simpleSort(T[] arr){
        for (int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i;j<arr.length;j++){
                if (arr[min].compareTo(arr[j])>0){
                    min = j;
                }
            }
            if (min!=i){
                T temp = arr[i];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    public static <T extends Comparable<? super T>> void  insertSort(T[] arr){
        for (int i=1;i<arr.length;i++){
            T temp = arr[i];
            int j ;
            for (j=i;j>0 & temp.compareTo(arr[j-1])<0;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] arr){
        for (int gap=arr.length/2;gap>=1;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                T temp = arr[i];
                int j ;
                for(j=i;j>=gap & temp.compareTo(arr[j-gap])<0;j=j-gap){
                    arr[j] = arr[j-gap];
                }

                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr,T[] tempArr,int left,int right){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(arr,tempArr,left,mid);
            mergeSort(arr,tempArr,mid+1,right);
            merge(arr,tempArr,left,mid+1,right);
        }
    }

    public static <T extends Comparable<? super T>> void merge(T[] arr,T[] tempArr,int leftPos,int rightPos,int rightEnd){
        int leftEnd = rightPos-1;
        int tempPos = leftPos;
        int num = rightEnd-leftPos+1;

        while (leftPos<=leftEnd & rightPos<=rightEnd){
            if (arr[leftPos].compareTo(arr[rightPos])<0){
                tempArr[tempPos++] = arr[leftPos++];
            }else {
                tempArr[tempPos++] = arr[rightPos++];
            }
        }
        while (leftPos<=leftEnd){
            tempArr[tempPos++] = arr[leftPos++];
        }
        while (rightPos<=rightEnd){
            tempArr[tempPos++] = arr[rightPos++];
        }

        for (int i=0;i<num;i++,rightEnd--){
            arr[rightEnd] = tempArr[rightEnd];
        }
    }

    /**
     * 快速排序
     */
    public static <T extends Comparable<? super T>> void quickSort(List<T> arr){
        if (arr.size()<=1){
            arr.stream().forEach(x->System.out.print(x+"  "));
        }

        List<T> smaller = new ArrayList<>();
        List<T> same = new ArrayList<>();
        List<T> bigger = new ArrayList<>();

        T key = arr.get(arr.size()/2);
        for (T item : arr){
            if(item.compareTo(key)<0){
                smaller.add(item);
            }else if (item.compareTo(key)>0){
                bigger.add(item);
            }else {
                same.add(item);
            }
        }

        quickSort(smaller);
        quickSort(bigger);

        arr.clear();
        arr.addAll(smaller);
        arr.addAll(same);
        arr.addAll(bigger);
    }

}
