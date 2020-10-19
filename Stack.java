package 数据结构;

/**
 * @ClassName Stack
 * @Description TODO
 * @Author apple
 * @Date 2020/10/17
 **/
public interface Stack<T> {
    public abstract boolean isEmpty();
    public abstract void push(T x);
    public abstract T peek();
    public abstract T pop();
}
