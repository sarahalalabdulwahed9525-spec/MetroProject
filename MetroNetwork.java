/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package riyadhmetroproject;

/**
 *
 * @author Sarah
 */
public class MetroNetwork {
    
    
    CircularDoublyList line1;
    CircularDoublyList line2;
    CircularDoublyList line3;
    
    public MetroNetwork(){
        line1=new CircularDoublyList();
        line2=new CircularDoublyList();
        line3=new CircularDoublyList();
        
        
        line1.addLast("Makkah Road", 3);
        line1.addLast("Prince Turki", 4);
        line1.addLast("Education City", 5);
        line1.addLast("Hittin", 4);
        line1.addLast("Khurais", 6);

       
        line2.addLast("Riyadh Park", 4);
        line2.addLast("King Salman Park", 5);
        line2.addLast("Sports Boulevard", 4);
        line2.addLast("Western Ring Road", 6);

     
        line3.addLast("Riyadh Zoo", 4);
        line3.addLast("Malaz", 3);
        line3.addLast("Imam Saud University", 5);
        line3.addLast("Eastern Ring Road", 4);
        
        
    }
    public CircularDoublyList line(int num){
            switch (num) {

                case 1:
                 return line1;
                   

                case 2:
                 
                    return line2;

                case 5:
                  
                    return line3;

                default:
                     return null;
            }
    }
    public void addstatiofirst(int line,String name,int trval){
      CircularDoublyList l=  line(line);
      if(l!=null){
          l.addFirst(name, trval);
      }
    }
    public void addstatiolast(int line,String name,int trval){
      CircularDoublyList l=  line(line);
      if(l!=null){
          l.addLast(name, trval);
      }
    }
    public boolean between(int line,String name,int trval,String first,String last){
      CircularDoublyList l=  line(line);
      if(l!=null){
         return l.insertBetween(first, last, name, trval);
      }
       return false;
    }
     public boolean remve(int line,String name){
          CircularDoublyList l=  line(line);
          if(l!=null){
          return  l.remove(name);
      }
          return false; 
     }
     public void Findstation(int line,String name){
          CircularDoublyList l=  line(line);
           if(l!=null){
          Node n= l.Find(name);
          if(n!=null){
              System.out.print(n);
          }
          else
                System.out.print(" no find");
      }
     }
       public void displayForward(int line){
        CircularDoublyList l=  line(line);
        if(l!=null){
          l.displayForward();
       }
}
        public void  Displaybackward(int line){
        CircularDoublyList l=  line(line);
        if(l!=null){
          l.displayBackward();
       }
        
}
      public void printShortestRoute(int line,String name1,String name2){
             CircularDoublyList l=  line(line);
             l.printShortestRoute(name1,name2);
             
             }
      public void Duration(int line,String name1,String name2){
             CircularDoublyList l=  line(line);
             l.durationAndCount(name1,name2);
             
             }
       public void tevaltime(int line,String name){
              CircularDoublyList l=  line(line);
             Node s= l.Find(name);
             if(s!=null)
              System.out.print(s.data.getTravelTime());
              
       }
       public void coutrepas(int line){
            CircularDoublyList l=  line(line);
             l.counter();
       }
}
