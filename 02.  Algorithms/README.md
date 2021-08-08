# **DataStructures-And-Algorithms**

## **Data Structures :-**

### **Data Structures is a way of storing/organising data in the memory, in such a way that access, management and modification become efficient.**

## **Algorithms:-**

### **Algorithms is any approach you use to perform operations on data (like searching, sorting, traversing, ..Etc.).**

<hr>

## [This Folder](./) is the continuation of [01. DataStructures](../01.%20DataStructures) to proceed with Algorithm part, so the approach will be that we will follow the [DSA sheet by LoveBabbar](https://docs.google.com/spreadsheets/d/1xMmQhRGXovrudJM4gix0P18-PJ7TpKNEjp6I26Ckp9E/edit#gid=1655163686) and in the process of solving Qs we will also buid up the concept of algorithms in proper sequence and moreover our DataStructures will also get revised because algorithm is something which we apply on data structures.

# **TimeComplexity**

- # Weightage of Algos
  ## 1 < log N < sqrt(N) < N < N log N < N<sup>2</sup> < 2<sup>N</sup> < 3<sup>N</sup> < N !
- # 10<sup>8</sup> Operation rule
  ![](https://codeforces.com/predownloaded/83/0d/830da2701ec5d3baacbea1af54eb16a4021abf6b.jpg)

# What is O(Log N) ?

## Log N in Mathematics :-

- In mathematics log has a default base as 10. e.g., log<sub>10</sub> 100
- Find value of log 1000 ?
  - log<sub>10</sub> 1000 = x
  - 10<sup>x</sup> = 1000
  - x=2
    So log 1000 = 3 because base is 10.
- Find value of log<sub>2</sub> 8 ?
  - log<sub>2</sub> 8 = x
  - 2<sup>x</sup> = 8 **OR** log 8 / log 2
  - x = 3

## Log N in Computer :-

- In CS log has a default base as 2. e.g., log<sub>2</sub> 8

## O(log N) basically means times goes up linearly while N goes up exponentially.

- **1sec to compute 2elements...log<sub>2</sub> 2 = x ...2<sup>x</sup>=2**
- **2sec to compute 4elements...log<sub>2</sub> 4 = x ...2<sup>x</sup>=4**
- **3sec to compute 8elements...log<sub>2</sub> 8 = x ...2<sup>x</sup>=8**

![](https://i.ibb.co/nPzw2nY/image.png)
![](https://i.ibb.co/xCH9sSC/image.png)
# Difference between (Subset/Powerset)**VS** (Subsequence) **VS** (Substring/SubArray)

- ## **(Powerset/Subset) -** Any possible set of elements from parent Set is called subset there is no restriction of same directions. So subsequence of any parentSet is also Subset/powerSet.
    - **e.g. arr[]={1, 2, 3, 4, 5, 6, 7}--->**
    - {1, 3, 5, 7} or {1, 5, 3, 7} or {7, 1, 3, 5} etc... **any one can be opt for subset.** 
    - {1, 4, 6, 7} or {1, 6, 7, 4} or {7, 6, 4, 1} etc... **any one can be opt for subset.**
    - {1, 2, 3} or {2, 1, 3} or {3, 2, 1} etc.. **any one can be opt for subset.**
    - etc.......
- ## **(Subsequence) -** Elements should be in one direction. Not neccesary to include adjacent elements i.e., gaps are possible between elements.
  - **e.g. arr[]={1, 2, 3, 4, 5, 6, 7}--->{1, 3, 5, 7}, {1, 4, 6, 7}...e.t.c**

- ## **(Substring/SubArray/Power Set) -** No gaps are possible between elements. Continuous elements should be there.
  - **e.g. arr[]={1, 2, 3, 4, 5, 6, 7}--->{1, 2}, {1, 2, 3}, {4, 5, 6}, {6, 7}...e.t.c**
