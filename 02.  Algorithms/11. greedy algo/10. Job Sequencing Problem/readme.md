## [Job Sequencing Problem](https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1)
- [Video Reference](https://youtu.be/zPtI8q9gvX8)

```java
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        // 1. Sort According to decreasing profit
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job a, Job b){
                if(a.profit < b.profit) return 1;
                else if(a.profit == b.profit) return 0;
                return -1;
            }
        });
        
        // 2. Find number of slot
        int numSlots = 0;
        for(int i = 0; i<n; i++){
            numSlots = Math.max(numSlots, arr[i].deadline);
        }
        
        // 3. make slot
        Pair slot[] = new Pair[numSlots];
        
        // 4. Traverse Job and schedule job
        int jobDone = 0;
        int totalProfit = 0;
        
        for(Job jb: arr){
            // we r doing from last coz if in future a job come with less deadline then the slot will be available
            for(int i = jb.deadline-1; i>=0; i--){
                if(slot[i] == null){
                    jobDone++;
                    slot[i] = new Pair(jb.id, jb.profit);
                    totalProfit+=jb.profit;
                    break;
                }
            }
            
        }
        
        // 5. if u want to print job sequence then itterate in slot[] and print slot[i].jobid
        
        return new int[]{jobDone, totalProfit};
    }
}
class Pair{
    int jobid;
    int profit;
    
    public Pair(int i, int p){
        jobid = i;
        profit = p;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
```