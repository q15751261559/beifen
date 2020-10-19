package 数据结构;


import java.util.Stack;

/**
 * @ClassName SeqStack
 * @Description 顺序栈
 * @Author southWind
 * @Date 2020/10/13
 **/
public final class SeqStack<T> {
    private SeqList list;
    public SeqStack(int length){
        this.list=new SeqList(length);
    }
    public SeqStack(){
        this(64);
    }
    public boolean isEmpty(){
        return this.list.isEmpty();
    }
    public void  push(T x){
        this.list.insert(x);
    }
    public T peek(){
        return (T)this.list.get(list.size()-1);
    }
    public T pop(){
        return (T)list.remove(list.size()-1);
    }

    public String tosString(){
       return this.list.tosString();
    };

    public static void main(String[] args) {
        SeqStack<String> ss1=new SeqStack<>(24);
        ss1.push("A");
        ss1.push("B");
        ss1.push("C");
        System.out.println("111");
        System.out.println("栈表的数据"+ss1.tosString());
    }
}
