package dataSturcture.ListSLink;

public class LinkedList<T> {
    public class Node{
        private T data;
        private Node next;

        public Node(){

        }

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node header;//头结点
    private Node tail;//尾节点
    private int size;//链表大小

    public LinkedList(){
        header = null;
        tail = null;
    }

    public LinkedList(T element){
        header = new Node(element,null);
        tail = header;
        size++;
    }

    // 链表长度
    public int length() {
        return size;
    }

    private Node getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node current = header;
        for (int i = 0;i < size & current != null;i++,current = current.next) {
            if (i == index) {
                return current;
            }
        }
        return null;
    }

    //返回指定位置的 值
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    //返回指定值在链表中的位置
    public int locate(T element) {
        Node current = header;
        for (int i = 0;i < size & current != null;i++,current = current.next) {
            if (current.data == element) {
                return i;
            }

        }
        return -1;
    }

    //采用头插法为链表追加节点
    public void addheader(T element) {
        header = new Node(element, header);
        if (tail == null) {
            tail = header;
        }
    }

    //采用尾插法为链表追加节点
    public void add(T element) {
        if (header == null) {
            header = new Node(element, null);
            tail = header;
        } else {
            Node newNode = new Node(element, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //为链表插入节点
    public void insert(T element,int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
            if (header == null) {
                add(element);
            } else {
                if (index == 0) {
                    addheader(element);
                } else {
                    Node prev = getNodeByIndex(index - 1);
                    prev.next = new Node(element, prev.next);
                    size++;
                }
            }



    }

    //删除index位置的节点
    public T delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node del = null;
        if (index == 0) {
            del = header;
            header = header.next;
        } else {
            Node prev = getNodeByIndex(index - 1);
            del = prev.next;
            prev.next = del.next;
            del.next = null;
        }
        size--;
        return del.data;
    }

    //清空列表
    public void clear() {
        header = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0;i < list.size;i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}
