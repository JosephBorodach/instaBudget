package edu.yu.cs.com1320.project;

/**
 * Creates a category for the user to allocate money to
 * @author Sam Shulman
 */
public class Category implements Comparable<Category> {

    private String name;
    private double allocated;

    private int priorityLevel;

    public Category(String name, double allocated, int priorityLevel) {
        this.name = name;
        this.allocated = allocated;
        this.priorityLevel = priorityLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAllocated() {
        return allocated;
    }

    public void setAllocated(double allocated) {
        this.allocated = allocated;
    }

    public boolean hasFunds(){
        return allocated > 0;
    }

    @Override
    public int compareTo(Category o) {
        if (this.priorityLevel > o.priorityLevel){
            return 1;
        } else if (this.priorityLevel < o.priorityLevel) {
            return -1;
        }
        return 0;
    }
}
