/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package riyadhmetroproject;

public class heap<Key extends Comparable<Key>, E extends Comparable<E>> {

  private AHNode<Integer,MaintenanceTask>[] a;
    private int size;
    private int maxsize;

   
    public heap(int k) {
        maxsize = k;
        a = new AHNode[maxsize];
        size = -1;
    }

    public boolean isEmpty() { return size == -1; }
    public int size() { return size + 1; }

    private int left(int p) { return 2 * p + 1; }
    private int right(int p) { return 2 * p + 2; }
    private int parent(int p) { return (p - 1) / 2; }
    private boolean hasLeft(int p) { return left(p) <= size; }
    private boolean hasRight(int p) { return right(p) <= size; }

    
    private boolean greater(AHNode<Integer, MaintenanceTask> x, AHNode<Integer, MaintenanceTask> y) {
        return x.getValue().compareTo(y.getValue()) > 0;
    }

    public void insert(Integer key, MaintenanceTask value) {
        if (size + 1 >= maxsize) return;
        size++;
        a[size] = new AHNode<>(key, value);
        upheap(size);
    }

    private void upheap(int p) {
        while (p > 0) {
            int pp = parent(p);
            if (!greater(a[p], a[pp])) break;
            AHNode<Integer, MaintenanceTask> temp = a[p];
            a[p] = a[pp];
            a[pp] = temp;
            p = pp;
        }
    }

    private void downheap(int p) {
        while (hasLeft(p)) {
            int lp = left(p);
            int m = lp;
            if (hasRight(p)) {
                int rp = right(p);
                if (greater(a[rp], a[lp])) m = rp;
            }
            if (greater(a[p], a[m])) break;
            AHNode<Integer, MaintenanceTask> temp = a[p];
            a[p] = a[m];
            a[m] = temp;
            p = m;
        }
    }

    
    public AHNode<Integer, MaintenanceTask> getMax() {
        if (isEmpty()) return null;
        return a[0];
    }

    
    public AHNode<Integer, MaintenanceTask> removemax() {
        if (isEmpty()) return null;
       AHNode<Integer, MaintenanceTask> max = a[0];
        a[0] = a[size];
        size--;
        if (!isEmpty()) downheap(0);
        return max;
    }
    
      public AHNode<Key, E>[] COPY() {
        if (isEmpty()) return null;
        int n= size+1;
        heap temp =new heap(n);
        for(int i=0;i<size;i++){
            temp.insert(a[i].getKey(), a[i].getValue());
        }
         AHNode<Key, E>[] as= new AHNode[n];
           for(int i=0;i<n;i++){
            as[i]=temp.removemax();
        }
           return as;
      }
    
//    public boolean updateKey(int id,int Newper) {
//        for (int i = 0; i <= size; i++) {
//            if (a[i].getKey().equals(id)) {
//             ((MaintenanceTask )a[i].getValue()).setPriority(Newper);
//                upheap(i);
//                downheap(i);
//                return true;
//            }
//        }
//        return false;
//    }
    }


//    public void bubble_up() {
//        int index = size();
//        int parent = index / 2;
//
//        while (index > 1 &&  ){
//            AHNode<Integer,MaintenanceTask>  swap = heap[index];
//            heap[index] = heap[parent];
//            heap[parent] = swap;
//            index = parent;
//            parent = index / 2;
//
//        }
//
//    }
//
//    public MaintenanceTask removeMax() {
//
//        if (size == 0) {
//            System.out.println("no elements!");
//            return null;
//        }
//        if (size == 1) {
//            MaintenanceTask max = heap[1];
//            size--;
//            return max;
//        }
//        MaintenanceTask Max = heap[1];
//
//        heap[1] = heap[size()];
//        size--;
//
//        if (size > 1) {
//            bubble_down(1);
//        }
//        return Max;
//    }
//
//    public void bubble_down(int i) {
//        int L = i * 2;
//        int R = i * 2 + 1;
//        int lagest = i;
//        if (L <= size() && great(heap[L], heap[lagest])) {
//            lagest = L;
//        }
//        if (R <= size() && great(heap[R], heap[lagest])) {
//            lagest = R;
//        }
//        if (lagest != i) {
//            MaintenanceTask swap = heap[i];
//            heap[i] = heap[lagest];
//            heap[lagest] = swap;
//        }
//        if (lagest != i) {
//            bubble_down(lagest);
//        }
//
//    }
//
//    //=====================================
//    public MaintenanceTask max() {
//        return heap[1];
//    }
//
//    public MaintenanceTask[] COPY() {
//        if (size == 0) {
//            return new MaintenanceTask[0];
//        }
//
//        heap tem = new heap(size + 1);
//
//        for (int i = 1; i <= size(); i++) {
//            if (heap[i] != null) {
//                tem.insert(heap[i]);
//            }
//        }
//
//        MaintenanceTask[] arr = new MaintenanceTask[tem.size];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = tem.removeMax();
//        }
//
//        return arr;
//
//    }
//
//    public boolean updatePriority(int id, int num) {
//        if (size == 0) {
//            return false;
//        }
//
//        MaintenanceTask[] task = COPY();
//        boolean found = false;
//        for (int i = 0; i < task.length; i++) {
//            if (task[i].getId() == id) {
//                task[i].setPriority(num);
//                found = true;
//            }
//        }
//            if (!found) {
//                return false;
//            }
//        size =0;
//          for (int j = 0; j< task.length; j++){
//              insert(task[j]);
//          }
//             return true;
//        }
//    }
//
