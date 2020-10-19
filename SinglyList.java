package 数据结构;

public class SinglyList<T extends java.lang.Comparable> extends Object  {
    public Node<T> head;
    public SinglyList()
    {
        this.head = new Node<T>();
    }
    public SinglyList(T[] values) {
        this();
        Node<T> rear = this.head;
        for (int i = 0; i < values.length; i++)
        {
            if (values[i]!=null)
            {
                rear.next = new Node<T>(values[i], null);
                rear = rear.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public T get(int i)
    {
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++) {
            p = p.next;
        }
        return (i >= 0 && p != null) ? p.data : null;
    }

    public void set(int i, T x) {
/*        if (i < 0 || i > size())
            throw new IndexOutOfBoundsException(i + "");
        if (x == null)
            throw new NullPointerException("x==null");*/
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++) {
            p.data = x;
        }

    }
    public int size() {
        int x = 0;
        Node<T> p = this.head.next;
       if (p==null)
           return -1;
       while (p!=null){
           x++;
           p=p.next;
       }
        return x;
    }

    public Node<T> insert(int i, T x) {
        if (x == null)
            throw new NullPointerException("x==null");
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        front.next = new Node<T>(x, front.next);
        return front.next;

    }

    public String toString() {
        String str = this.getClass().getName() + "(";
        for (Node<T> p = this.head.next; p != null; p = p.next)
            str += p.data.toString() + (p.next != null ? "," : "");
        return str + ")";
    }


    public Node<T> insert(T t) {
        return insert(java.lang.Integer.MAX_VALUE, t);
    }

    public T remove(int i) {
        Node<T> front = this.head;
        for (int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        if (i >= 0 && front.next != null) {
            T x = front.next.data;
            front.next = front.next.next;
            return x;
        }
        return null;

    }

    public void clear() {
        this.head.next = null;
    }

    public Node<T> search(T key) {
        Node<T> p = this.head.next;
        for (; p != null;p=p.next)
            if (key.equals( p.data))
                return p;
        return null;
    }

    public T remove(T key) {
        Node<T> front = this.head;
    while (!front.next.data.equals(key)&&front.next!=null){
        front=front.next;
    }
        if (front.next.data.equals(key)) {
            front.next = front.next.next;
            return key;
        }else return null;
    }

/*    public void reverse(SinglyList<T> list){  //第一种逆置
        Node<T> p=list.head.next,succ=null,front=null;
        while (p!=null){
            succ=p.next;
            p.next=front;
            front=p;
            p=succ;
        }
        list.head.next=front;
    }*/
    public void reverse(SinglyList<T> list){  //第二种逆置
        Node<T> p=list.head.next,q;
        list.head.next=null;
        while (p!=null){
            q=p.next;
            p.next=list.head.next;
            list.head.next=p;
            p=q;

        }
    }

    public Node<T> merge(SinglyList list2){
        Node<T> p,q,t,s;
        p=this.head.next;
        t=this.head;
        q=list2.head.next;
        s=q.next;
        if (p == null) {
            return (list2.head);
        }
        if (q == null) {
            return (this.head);
        }
        while(p!=null && q!=null){
            if (p.data.equals(q.data)) {
                p = p.next;
                q = q.next;
                t = t.next;
                if (s == null) {
                    break;
                } else {
                    s = s.next;
                }
            }else if (p.data.compareTo(q.data)>0) {
                    q.next=t.next;
                    t.next=q;
                    t=t.next;
                    q=s;
                    s=s.next;
                }else if (p.data.compareTo(q.data)<0) {
                    p=p.next;
                    t=t.next;
                }
            }
            if (p == null) {
                t.next=q;
            }
            return this.head;
        }

    public Node<T> merge1(SinglyList list2){
        Node<T> p,q,s,t;
        p=this.head.next;
        t=this.head;
        q=list2.head.next;
        s=q.next;
        if(p==null){
            return (list2.head);
        }
        if(q==null){
            return (this.head);
        }
        while (p!=null&&q!=null){
            if(p.data.equals(q.data)){
                q.next=t.next;
                t.next=q;
                t=t.next;
                q=s;
                if(s==null){
                    break;
                }
                else {
                    s = s.next;
                }
            }
            else if(p.data.compareTo(q.data)>0){
                q.next=t.next;
                t.next=q;
                t=t.next;
                q=s;
                s=s.next;
            }
            else if(p.data.compareTo(q.data)<0){
                p=p.next;
                t=t.next;
            }
        }
        if(p==null){
            t.next=q;
        }
        return this.head;
    }





}
