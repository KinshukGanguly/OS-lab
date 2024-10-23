class Process
{     int id;
      int at;
      int bt;
      int ct;
      int wt;
      int tat;
    
   public Process(int i,int a, int b)
   {
    id=i;
    at=a;
    bt=b;
   }
   
   public static void sjf(Process p[],int n)
   {
     int currentTime = 0;
     int completed = 0;
     boolean[] isComplete = new boolean[n];
     
     while(completed < n)
     {  int shortest = -1;
        int minBurst = 9999;
        
        for(int i=0;i<n;i++)
        {
        if(p[i].at<=currentTime && (!isComplete[i]) && p[i].bt<minBurst)
        {shortest=i;
         minBurst=p[i].bt;
         }//if
        }//for
        
        if(shortest ==-1)
        {currentTime++;
         continue;
        }
        
        currentTime+=p[shortest].bt;
        p[shortest].ct=currentTime;
        p[shortest].tat=p[shortest].ct-p[shortest].at;
        p[shortest].wt=p[shortest].tat -p[shortest].bt;
        isComplete[shortest]=true;
        completed++;    
     
     
     }//while 
   
   
   }//sjf()

    public static void main(String args[])
    {    int n = 4;
         Process[] p =new Process[n];
         
         p[0] = new Process(1,0,6);
         p[1] = new Process(2,0,2);
         p[2] = new Process(3,0,8);
         p[3] = new Process(4,0,3);
         double avg_wt=0;
         double avg_tat=0;
                  
         sjf(p,n);
         for (int i=0; i<n;i++)
         {  System.out.println("For process-"+(i+1)+" arrival time="+p[i].at+" burst time="+p[i].bt+" completion time="+p[i].ct+" turn around time="+p[i].tat+" waiting time="+p[i].wt);
         avg_wt+=p[i].wt;
         avg_tat+=p[i].tat;
         
         
         }//for
         
         System.out.println("Average turn around time="+(avg_tat/n)+"Average waiting time="+(avg_wt/n));

    }//main 
}//class Process
