### **Step 1:** [Watch priority Queue basic explanation here.](https://youtu.be/FdObb76AmzM)

# **Implementation Using Heap**

## **VI Prerequisites:** [Comparable in PQ for generic PQ](https://youtu.be/DE835GvxZMQ)

## [**My Implementation of PQ**](./MyPriorityQueue.java)


## Output of above implementation:-

![](https://i.ibb.co/7QJtxHs/pq-output.png)
# Default Max PQ in Java
In Java 8+ you can create a max priority queue via one of these methods:

Method 1:
```java
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
``` 
Method 2:
```java
PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a); 
```
Method 3:
```java
PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b.compareTo(a));
 ```

## **NOTE:** Implementation ()s of priority Queue is totally same as heap DS function which is covered in heap DS.

## **Priority Queue --------- Heap**

1. **add() = minInsert()**
2. **peek() = getMin()**
3. **remove() = extractMin()**

### **Step 2:** [Problem Link.](https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1)

### **Step 3:** [Solution Link.](./KLargestElement.java)
