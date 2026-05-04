package riyadhmetroproject;

public class CircularDoublyList {

    private Node head;
  private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    
    public void addFirst(String name, int travelTime) {
        Node n = new Node(new Station(name, travelTime, 2, "Parking, Restrooms", "Wheelchair access, Elevators", 40000, "05:00 - 23:30", 1));

        if (isEmpty()) {
            head = n;
            n.next = n;
            n.prev = n;
        } else {
            Node tail = head.prev;    
           
            n.next = head;
            n.prev = tail;

          
            tail.next = n;
            head.prev = n;

          
            head = n;
        }

        size++;
    }

   
    public void addLast(String name, int travelTime) {
        if (isEmpty()) {
            addFirst(name, travelTime);
            return;
        }
        Node tail = head.prev;
        Node n = new Node(new Station(name, travelTime, 2, "Parking, Restrooms", "Wheelchair access, Elevators", 40000, "05:00 - 23:30", 1));

        n.next = head;
        n.prev = tail;

        tail.next = n;
        head.prev = n;

        size++;
    }

   
    public boolean insertBetween(String beforeName, String afterName,
                                 String newName, int travelTime) {
        if (isEmpty()||this.size<2) return false;

        Node curr = head;
        for (int i = 0; i < size; i++) {
            String currName = curr.data.getName();
            String nextName = curr.next.data.getName();

            if (currName.equalsIgnoreCase(beforeName) &&
                nextName.equalsIgnoreCase(afterName)) {

                Node n = new Node(new Station(newName, travelTime, 2, "Parking, Restrooms", "Wheelchair access, Elevators", 40000, "05:00 - 23:30", 1));

               
                n.next = curr.next;
                n.prev = curr;

                curr.next.prev = n;
                curr.next = n;

                size++;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

   
    public boolean remove(String name) {
        if (isEmpty()) return false;

        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.data.getName().equalsIgnoreCase(name)) {

                    if (size == 1) {
                    head = null;
                    size = 0;
                    return true;
                }

                 curr.prev.next = curr.next;
                curr.next.prev = curr.prev;

                    if (curr == head) {
                    head = curr.next;
                }

                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

      public Node Find(String name) {
     if(size==0){
         return null;
     }
      Node curr = head;
      for(int i=0; i<size;i++){
          if(curr.data.getName().equalsIgnoreCase(name)){
              return curr;
          }
          curr=curr.next;
}
   return null;   
}
    public void   displayForward(){
         if(size==0){
         return ;
     }
      Node curr = head;
      for(int i=0; i<size;i++){
          System.out.print(curr.data);
          curr=curr.next;
      }
    }
    public void   displayBackward(){
         if(size==0){
         return ;
     }
      Node curr = head.prev;
      for(int i=0; i<size;i++){
          System.out.print(curr.data);
          curr=curr.prev;
      }
    }
    public int count() {
        return size;
    }
    public void printShortestRoute(String startName, String endName){
      Node s=  Find(startName);
      Node e=  Find(endName);
      if (s == null || e == null) {
        System.out.println("Station not found!");
        return;
    }
      int timeA=0;
      String pathA=s.data.getName();
      Node bs=s;
      while(bs!=e){
           if(bs.next==e)
            timeA+=bs.next.data.getTravelTime();
           else
            timeA+=bs.next.data.getTravelTime()+2; 
           
             bs=bs.next;
          pathA+= " -"+bs.data.getName();
      }
      
      int timeb=0;
      String pathb=e.data.getName();
      Node be=e;
        while(be!=s){
           if(bs.prev==s)
            timeb+=be.prev.data.getTravelTime();
           else
            timeb+=be.prev.data.getTravelTime()+2; 
           
             be=be.prev;
          pathb+= " -"+be.data.getName();
      }
        if(timeA<timeb){
               System.out.println(timeA);
           System.out.println(pathA);
        }
        if(timeb<timeA){
               System.out.println(timeb);
           System.out.println(pathb);
        }
        else
             System.out.println(pathb + pathA +" are eugle");
        
    }
    public void durationAndCount(String startName, String endName){
         Node s = Find(startName);
         Node e = Find(endName);
         int count=0;
         int duration=0;
          if (s == null || e == null) {
        System.out.println("Station not found!");
        return;
    }
          Node curr= s;
          while(curr!=e){
              duration+=curr.data.getTravelTime();
              count++;
              curr=curr.next;
          }
          System.out.println(count+" count"+" duration"+ duration);
    }
    public void counter(){
        Node s= head;
        for(int i=0;i<size;i++){
             System.out.println(s.data.getName()+" "+s.data.getCounterpass());
             s=s.next;
        }
    }
}




//public void printShortestRoute(String startName, String endName) {
//
//    Node s = find(startName);
//    Node e = find(endName);
//
//    if (s == null || e == null) {
//        System.out.println("Station not found!");
//        return;
//    }
//
//  
//    int timeF = 0;
//    String pathF = s.data.getName();
//    Node currF = s;
//
//    while (currF != e) {
//
//            if ( currF.next== e)
//            timeF += currF.next.data.getTravelTime();      
//        else
//            timeF += currF.next.data.getTravelTime() + 2; 
//
//        currF =currF.next;
//        pathF += " -> " + currF.data.getName();
//    }
//
//    int timeB = 0;
//    String pathB = s.data.getName();
//    Node currB = s;
//
//    while (currB != e) {
//
//        
//        if ( currB.prev == e)
//            timeB +=  currB.prev.data.getTravelTime();      
//        else
//            timeB += currB.prev.data.getTravelTime() + 2;  
//
//        currB = currB.prev;
//        pathB += " -> " + currB.data.getName();
//    }
//
//    
//    System.out.println("\n===== SHORTEST ROUTE =====");
//    if (timeF <= timeB) {
//        System.out.println("Path: " + pathF);
//        System.out.println("Total Time: " + timeF + " minutes");
//    } else {
//        System.out.println("Path: " + pathB);
//        System.out.println("Total Time: " + timeB + " minutes");
//    }
//}
//
//  
//   public void durationAndCount(String startName, String endName) {
//
//    Node s = find(startName);
//    Node e = find(endName);
//
//    if (s == null || e == null) {
//        System.out.println("Station not found!");
//        return;
//    }
//
//    int time = 0;
//    int count = 0;
//
//    Node curr = s;
//
//    while (curr != e) {
//        time += curr.data.getTravelTime() + 2; 
//        count++;                              
//        curr = curr.next;
//    }
//
//    System.out.println("Stations Between = " + count);
//    System.out.println("Total Duration = " + time + " minutes");
//}
//
//    
//    }
//
//   
//    

