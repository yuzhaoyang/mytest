package leetcode;

public class QuickSort {

    public static void quickSort(int[] arr,int start,int end){
        // 递归结束条件：start大等于end的时候
        if (start>=end){
            return;
        }

        // 得到基准元素位置
        int pivot=parttion(arr,start,end);


        // 根据基准元素，分成两部分递归排序
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);

    }

    private static int parttion(int[] arr, int start, int end) {

        // 取第一个位置的元素作为基准元素
        int pivot=arr[start];
        int left=start;
        int right=end;

        while (left!=right){

            //控制right指针比较并左移
            while (left<right&&arr[right]>pivot){
                right--;
            }

            //控制left指针比较并右移
            while (left<right&&arr[left]<=pivot){
                left++;
            }


            //交换left和right指向的元素
            if(left<right){

                int t=arr[left];
                arr[left]=arr[right];
                arr[right]=t;
            }


        }

        //pivot和指针重合点交换
        int t=arr[left];
        arr[left]=arr[start];
        arr[start]=t;

        return -1;
    }
}
