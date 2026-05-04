package riyadhmetroproject;

import java.util.ArrayList;

public class StationDirectory {
    
    BSTree<Integer, Station_1> tree = new BSTree<Integer, Station_1>();
    
    public void addtod(Station_1 s) {
        tree.insert(s.getStationId(), s);
    }
    
    public Station_1 sid(int id) {
        Station_1 n = tree.search(id);
        if (n == null) {
            return null;
        } else {
            return n;
        }
    }
    
    public void rang(int low, int high) {
        tree.sr(tree.getRoot(), low, high);
    }
    
    public Station_1 Update(int id, String nename, int ne) {
        Station_1 n = tree.search(id);
        if (n == null) {
            return null;
        } else {
            n.setName(nename);
            n.setTravelTime(ne);
        }
        return tree.search(id);
    }
    
    public void rev(int id) {
        Station_1 n = tree.search(id);
        if (n != null) {
            tree.delete(id);
        }
        
    }

    public void print() {
        tree.print();
    }

    public void max() {
        System.out.print(tree.findMax());
    }

    public void min() {
        System.out.print(tree.findMin());
    }

    public boolean findid(int id) {
        Station_1 n = tree.search(id);
        if (n != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void printfs() {
        SinglyLinkedList<Station_1> list = tree.serachbyf();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Station_1 s = list.removeFirst();
                System.out.print(s.getName() + " " + s.getFacilities());
                list.addLast(s);
            }
        }
        
    }
    
    public Station_1 buesit() {
        SinglyLinkedList<Station_1> list = tree.treetolist();
        int n = list.size();
        int mas = 0;
        Station_1 s = null;
        
        for (int i = 0; i < n; i++) {
            Station_1 t = list.removeFirst();
            if (t.getPassengerCount() > mas) {
                mas = t.getPassengerCount();
                s = t;                
            }
            list.addLast(t);
        }
        return s;
    }
}
