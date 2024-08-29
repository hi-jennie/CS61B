import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    private Node header;
    private Node tailor;
    private int size;

    private class Node{
        Node pred;
        Node suc;
        T data;

        public Node(T data){
            this(data,null,null);
        }
        public Node(T data,Node pred,Node suc){
            this.pred = pred;
            this.suc = suc;
            this.data = data;
        }
    }

    public LinkedListDeque61B() {
        this.header = new Node(null);
        this.tailor = new Node(null);
        header.suc = tailor;
        tailor.pred = header;
        size = 0;

    }

    @Override
    public void addFirst(T x) {
        Node first = new Node(x,header,header.suc);
        header.suc.pred = first;
        header.suc = first;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node last = new Node(x,tailor.pred,tailor);
        tailor.pred.suc = last;
        tailor.pred = last;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node current = header;
        for (int i = 0; i < size; i++) {
            current = current.suc;
            returnList.add(current.data);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return header.suc == tailor;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        Node removedNode = header.suc;
        Node firstNode = removedNode.suc;
        header.suc = firstNode;
        firstNode.pred = header;
        size--;
        return removedNode.data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node removedNode = tailor.pred;
        Node lastNode = removedNode.pred;
        tailor.pred = lastNode;
        lastNode.suc = tailor;
        size--;
        return removedNode.data;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        Node result = header;
        // 获得正确索引的内容意味着☝应该step forward index+1；
        for (int i = 0; i < index+1; i++) {
            result = result.suc;
        }
        return result.data;
    }

    @Override
    public T getRecursive(int index) {
        return getRecursive(header.suc,index);
    }

    private T getRecursive(Node p,int index){
        if (index < 0 || index >= this.size) {
            return null;
        }
        if(index == 0){
            return p.data;
        }
        return getRecursive(p.suc,index-1);
    }
}