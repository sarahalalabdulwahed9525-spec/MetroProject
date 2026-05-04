/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package riyadhmetroproject;

/**
 *
 * @author Sarah
 */
public class TicketingSystem {

    ArrayQueue<Passenger>[] machines;
    ArrayQueue<Passenger> vip;

    public TicketingSystem() {
        vip = new ArrayQueue<Passenger>();
        machines = new ArrayQueue[3];
        for (int i = 0; i < 3; i++) {
            machines[i] = new ArrayQueue<Passenger>();
        }
    }

    public void addPassengervip(int id, String name, String du) {
        Passenger p = new Passenger(id, name, du);
        vip.enqueue(p);
    }

    public void addPassenger(int num, int id, String name, String du) {
        if (num < 1 || num > 3) {
            return;
        }
        Passenger p = new Passenger(id, name, du);
        machines[num - 1].enqueue(p);

    }

    public void serveNextPassenger(int num) {
        if (num < 0 || num > 3) {
            System.out.println("Invalid machine number!");
            return;
        }
        if (num == 0) {

            if (vip.isEmpty()) {
                System.out.println("no vip ");
            } else {
                Passenger p = vip.dequeue();
                System.out.println(" now servering " + p);
            }
        }
        if (machines[num - 1].isEmpty()) {
            return;
        }
        Passenger p = machines[num - 1].dequeue();
        System.out.println(" now servering " + p);
    }

    public void peekNextPassenger(int num) {
        if (num < 0 || num > 3) {
            System.out.println("Invalid machine number!");
            return;
        }
        if (num == 0) {

            if (vip.isEmpty()) {
                System.out.println("no vip ");
            } else {
                Passenger p = vip.first();
                System.out.println(" now servering " + p);
            }
        }
        if (machines[num - 1].isEmpty()) {
            return;
        }
        Passenger p = machines[num - 1].first();
        System.out.println(" next servering " + p);
    }

    public void displayAllWaitingPassengersvip() {
        if (vip.isEmpty()) {
            return;
        }
        int n = vip.size();
        for (int i = 0; i < n; i++) {
            Passenger p = vip.dequeue();
            System.out.println(p);
            vip.enqueue(p);
        }
    }

    public void displayAllWaitingPassengers() {
        for (int i = 0; i < 3; i++) {
            if (machines[i].isEmpty()) {
                continue;
            }
            int count = machines[i].size();
            for (int j = 0; j < count; j++) {
                Passenger p = machines[i].dequeue();
                System.out.println(p);
                machines[i].enqueue(p);
            }

        }
    }

    public void waitingCount() {
        if (vip.isEmpty()) 
         System.out.println(" NO  VIP waitingCount " );
       else
             System.out.println("waitingCount " + vip.size());
            for (int i = 0; i < 3; i++) {
                System.out.println("machines " + (i + 1) + machines[i].size());
            }
        
    }

    public double averageWaitingTime() {
        int t = vip.size();
        for (int i = 0; i < 3; i++) {
            t += machines[i].size();
        }
        return t * 2 / 3;
    }
    
    public void estmies(int id,int num){
      if (num < 1 || num > 3) {
            System.out.println("Invalid machine number!");
            return;
        }
       ArrayQueue<Passenger> q =machines[num-1];
         int n= q.size();
         int position=-1;
         for (int i= 0 ;i<n;i++){
              Passenger pa = q.dequeue();
          if (pa.getTicketID() == id && position == -1) 
               position= i;
                q.enqueue(pa);
         }
         if(position==-1)
               System.out.println(" no one is here");
         else
               System.out.println(" time "+position *2);
    }
     public void estmiesvip(int id){
     
         int n= vip.size();
         int position=-1;
         for (int i= 0 ;i<n;i++){
              Passenger pa = vip.dequeue();
          if (pa.getTicketID() == id && position == -1) 
               position= i;
                vip.enqueue(pa);
         }
         if(position==-1)
               System.out.println(" no one is here");
         else
               System.out.println(" time "+position *2);
    }
      public void  movep(int id ,int nums,int numt){
            ArrayQueue<Passenger> qs =machines[nums-1];
            ArrayQueue<Passenger> qt =machines[numt-1];
            int n =qs.size();
            boolean found =false;
            for(int i=0 ;i<n;i++){
               Passenger pa = qs.dequeue();
               if(pa.getTicketID()==id&& !found){
                   qt.enqueue(pa);
                   found= true;
               }
                else
                   qs.enqueue(pa);
            }
            if (found)
                   System.out.println("  has been moved");
      }
}
