# **[295. Find Median from Data Stream](https://leetcode.com/problems/largest-rectangle-in-histogram/)**
# My Intution : - PQ
```java
class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxPq;
    PriorityQueue<Integer> minPq;
    public MedianFinder() {
        maxPq=new PriorityQueue<>(Collections.reverseOrder());
        minPq=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxPq.isEmpty()||num<=maxPq.peek())
            maxPq.add(num);
        else
            minPq.add(num);
        
        if(maxPq.size()>minPq.size()+1) minPq.add(maxPq.remove());// when there is Muchmore elements in MaxHeap than in minHeap.
        else if(minPq.size()>maxPq.size()) maxPq.add(minPq.remove());
    }
    
    public double findMedian() {
        if(maxPq.size()==minPq.size()) return (maxPq.peek()+minPq.peek())/2.0; // if even no. of elements
        return maxPq.peek(); // odd
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
```
## **[Video Reference](https://youtu.be/Yv2jzDzYlp8)**