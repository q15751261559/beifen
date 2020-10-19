package 数据结构;

/**
 * @ClassName Comparable
 * @Description TODO
 * @Author 86139
 * @Date 2020/10/19
 **/

public interface Comparable<T> {
    public abstract int compareTo(T obj);
}
final class Integer extends Number implements Comparable<Integer>
{
    public int compareTo(Integer iobj)
    {
        return this.intValue() <iobj.intValue() ?-1:(this.intValue()==iobj.intValue()?0:1);
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

}
