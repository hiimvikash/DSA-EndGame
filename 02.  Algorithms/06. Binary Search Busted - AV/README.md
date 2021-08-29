[**<h1 align="center">Binary Search - Aditya Verma</h1>**](https://youtube.com/playlist?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2)

# [**Binary Search Basic**](https://youtu.be/QNGL_t_o_QA)
![BS1](https://user-images.githubusercontent.com/71629248/131240871-ce657d2c-4880-4504-93ed-e577916ae295.png)
## BS on Ascending Order sorted array :-
```java
private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = a[mid];

            if (key > midVal)
                start = mid + 1;
            else if (key < midVal)
                end = mid - 1;
            else
                return mid; // key found
        }
        return -(start + 1);  // if key not found then -(thisVal+1) will give insertion point.
}
```
## BS on Descending Order sorted array :-
```java
private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            int midVal = a[mid];

            if (key < midVal)
                start = mid + 1;
            else if (key > midVal)
                end = mid - 1;
            else
                return mid; // key found
        }
        return -(start + 1);  // if key not found then -(thisVal+1) will give insertion point.
}
```
