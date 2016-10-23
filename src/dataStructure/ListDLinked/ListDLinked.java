package dataStructure.ListDLinked;

/**
 * Created by Jitana on 2016/10/22.
 */
public class ListDLinked<T> {

    Node head; //链表头结点
    Node tail;//链表尾结点

    private int maxSize; //最大元素个数
    private int count;//实际元素个数

    public ListDLinked() {

    }

    public ListDLinked(int maxSize) {
        this.maxSize = maxSize;
        this.count = 0;
    }

    //链表是否已满
    public boolean isFull() {
        return maxSize == count;
    }

    //链表是否为空
    public boolean isEmpty() {
        return this.count == 0;
    }

    //从头开始加

    public void addHead(T element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
            count++;
        } else {
            if (isFull()) {
                System.out.print("链表已满");
                return;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                count++;
            }

        }
    }

    //从尾部开始加
    public void addTail(T element) {
        Node newNode = new Node(element);
        if (this.head == null) {
            head = newNode;
            tail = newNode;
            count++;
        } else {
            if (isFull()) {
                System.out.print("链表已满");
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                count++;
            }
        }
    }

    //查找结点

    public Node find(T element) {
        Node temp = head;
        Node mNode = new Node(element);
        while (temp != null) {
            if (temp.equals(mNode)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //删除结点
    public void delete(T element) {
        Node mNode = find(element);
        if (mNode != null) {
            mNode.prev.next = mNode.next;
            mNode.next.prev = mNode.prev;
            count--;
        } else {
            System.out.print("要删除的元素不存在");
        }
    }

    public int size() {
        return count;
    }

    public Node findNodeByIndex(int index) {

        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
            Node current = head;
            for (int i = 0;i < count & current != null;i++,current = current.next ){
                if (index == i) {
                    return current;
                }
            }
        return null;
    }


    //插入结点
    public void insert(int index,T element) {
        Node mNode = new Node(element);
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("链表索引越界");
        }
        if (head == null) {
            head = mNode;
            tail = mNode;
        } else {
            if (index == 0) {
                addHead(element);
            } else {
                Node p = findNodeByIndex(index - 1);
                Node insert = new Node();
                insert.prev = p;
                insert.next = p.next;
                p.next.prev = insert;
                p.next = insert;
            }
        }
            count++;
    }


   class Node{
        Node next;
        Node prev;
        T data;
        public Node() {

        }
        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;

           Node node = (Node) o;

           return !(data != null ? !data.equals(node.data) : node.data != null);

       }

       @Override
       public int hashCode() {
           return data != null ? data.hashCode() : 0;
       }
   }

    public T get(int index) {
        return findNodeByIndex(index).data;
    }

    public static void main(String[] args) {
        ListDLinked<Integer> listDLinked = new ListDLinked();
        listDLinked.addTail(1);
        listDLinked.addTail(2);
        listDLinked.addTail(3);
        listDLinked.addTail(4);
        listDLinked.addHead(5);
        listDLinked.delete(2);
        for(int i = 0;i < listDLinked.size();i++){
            System.out.print(listDLinked.get(i) + " ");
        }
    }


}
