package 数据结构;

import 数据结构.SinglyList;

public final class LinkedStack<T extends java.lang.Comparable> implements Stack<T> {
    private SinglyList<T> list;

    public LinkedStack(){
        this.list=new SinglyList<T>();
    }
    public boolean isEmpty(){
        return this.list.isEmpty();
    }

    public void push(T x){
        this.list.insert(0,x);
    }
    public T peek(){
        return this.list.get(0);
    }
    public T pop(){
        return this.list.remove(0);
    }

    /*public String toString(){

    }*/


}
