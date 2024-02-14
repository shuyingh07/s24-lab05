package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList sortedIntList;
    private int totalAdded;

    public DelegationSortedIntList(){
        this.sortedIntList = new SortedIntList();
        this.totalAdded = 0;
    }

    @Override
    public boolean add(int num){
        boolean success = sortedIntList.add(num);
        if(success){
            totalAdded += 1;
        }
        return success;
    }

    @Override
    public boolean addAll(IntegerList list){
        boolean success = sortedIntList.addAll(list);
        if(success){
            this.totalAdded += list.size();
        }
        return success;
    }

    @Override
    public int get(int index){
        return sortedIntList.get(index);
    }

    @Override
    public boolean remove(int num){
        return sortedIntList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list){
        return sortedIntList.removeAll(list);
    }

    @Override
    public int size(){
        return sortedIntList.size();
    }

    public int getTotalAdded(){
        return this.totalAdded;
    }
}   