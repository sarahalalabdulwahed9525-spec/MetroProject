/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package riyadhmetroproject;

public class MaintenanceSystem {

    heap<Integer, MaintenanceTask> heapmax = new heap(10);

    public void submitTask(int id, String des, int pri) {
        MaintenanceTask task = new MaintenanceTask(id, des, pri);
        heapmax.insert(pri, task);
        System.out.println(" sumbit task" + task);
    }

    public void assignNextTask() {
        AHNode<Integer, MaintenanceTask> task = heapmax.removemax();
        if (task == null) {
            System.out.println(" no task");
        } else {
            System.out.println(" assign one " + task.getValue());
        }
    }

    public void viewMostCritical() {
        AHNode<Integer, MaintenanceTask> task = heapmax.getMax();
        if (task == null) {
            System.out.println(" no task");
        } else {
            System.out.println(" most one " + task.getValue());
        }
    }

    public void displayAllPendingTasks() {

        AHNode<Integer, MaintenanceTask>[] task = heapmax.COPY();
        if (task != null) {
            for (int i = 0; i < task.length; i++) {
                System.out.println(task[i].getValue());
            }
        }
    }

    public void updatePriority(int id, int num) {
        heap<Integer, MaintenanceTask> temp = new heap(heapmax.size() + 1);
        AHNode<Integer, MaintenanceTask> task = new AHNode();
        for (int i = 0; i < heapmax.size(); i++) {
            if (heapmax.getMax().getValue().getId() == id) {
                task = heapmax.getMax();
                heapmax.removemax();
            } else {
                AHNode<Integer, MaintenanceTask> obj = heapmax.removemax();
                temp.insert(obj.getKey(), obj.getValue());
            }

        }
        for (int i = 0; i < temp.size(); i++) {
            AHNode<Integer, MaintenanceTask> obj = temp.removemax();
            heapmax.insert(obj.getKey(), obj.getValue());
        }
        if (task != null) {
            task.setKey(num);
            heapmax.insert(task.getKey(), task.getValue());
        }
    }

    public void printperp() {
        int c = 0;
        int h = 0;
        int m = 0;
        int l = 0;
        AHNode<Integer, MaintenanceTask>[] task = heapmax.COPY();
        for (int i = 0; i < task.length; i++) {
            MaintenanceTask t = task[i].getValue();
            int p = t.getPriority();

            switch (p) {
                case 4:
                    c++;
                    break;
                case 3:
                    h++;
                    break;

                case 2:
                    m++;
                    break;

                case 1:
                    c++;
                    break;
            }

        }
        System.out.println(c + " ");
        System.out.println(h + " ");
        System.out.println(m + " ");
        System.out.println(l + " ");
    }
     public void Escalate(){
         int n=heapmax.size();
       MaintenanceTask[]t= new   MaintenanceTask[n];
       for(int i=0;i<n;i++) {
           t[i]= heapmax.removemax().getValue();
       }   
      for(int j=0 ;j<n;j++){
          if(t[j].getPriority()<4){
              t[j].setPriority(t[j].getPriority()+1);
          }
            heapmax.insert(t[j].getPriority(), t[j]);
      }   
     }
      public void assignNextTaskmul(int mul) {
          for(int i=0;i<mul;i++){
         AHNode<Integer, MaintenanceTask> task = heapmax.removemax();
        if (task == null) {
            System.out.println(" no task");
        } else {
            System.out.println(" assign one " + task.getValue());
        }
      }
      }
}
//    public void updatePriority(int id ,int num){
//      boolean ok =  heapmax.updateKey(id, num);
//      if(ok)
//           System.out.println(" has been updeate");
//      else 
//          System.out.println(" no");
//        
//    }

