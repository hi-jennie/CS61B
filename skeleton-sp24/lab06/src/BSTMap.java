import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private final Set<K> keySet;
    private Entry root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
        keySet = new TreeSet<>();
    }

    public static void main(String[] args) {
        BSTMap<String, Integer> bst = new BSTMap<>();
        bst.put("Jennie", 2);
        bst.put("Jennie", 3);
        bst.put("Rustin",4);
        bst.put("Rustin",5);
        bst.put("Rus",7);
        System.out.println(bst.get("Jennie"));
        System.out.println(bst.getEntry("Rustin").val);
        System.out.println(bst.get("Rus"));
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map already contains the specified key, replaces the key's mapping
     * with the value specified.
     */
    @Override
    public void put(K key, V value) {
        root = put(root,key,value);
    }

    // helper function
    private Entry put(Entry entry, K key, V val) {
        if (entry == null) {
            entry = new Entry(key, val);
            size++;
            keySet.add(key);
            return entry;
        }
        int cmp = key.compareTo(entry.key);
        if (cmp < 0) {
            // if we use this statement "put(entry.left, key, val);" directly ,we can't connect  the new entry with its parent.
            entry.left = put(entry.left, key, val);
        } else if (cmp > 0) {
            entry.right = put(entry.right, key, val); // Fixed this line
        } else {
            entry.val = val;
        }
        return entry;
    }

    @Override
    public V get(K key) {
        if (containsKey(key)) {
            return getEntry(key).val;
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return keySet.contains(key);
    }

    // helper function
    private Entry getEntry(K key) {
        return getEntry(root, key);
    }

    private Entry getEntry(Entry entry, K key) {
        if (entry == null) {
            return null;
        }
        int cmp = key.compareTo(entry.key);
        if (cmp < 0) {
            return getEntry(entry.left, key);
        } else if (cmp > 0) {
            return getEntry(entry.right, key);
        } else {
            return entry;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return keySet;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    // prints out your BSTMap in order of increasing Key.
    public void printInOrder() {
        Stack<Entry> stack = new Stack<>();
        Entry current  = root;
        while(current != null||!stack.isEmpty()){
            while(current !=null){
                stack.push(current);
                current = current.left;
            }
            System.out.println(current.val);
            current = current.right;
        }
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map already contains the specified key, replaces the key's mapping
     * with the value specified.
     */
    // We strongly recommend you create helper methods to facilitate your implementation
    // (specifically, recursive helper methods are strongly encouraged).
    private class Entry {
        private K key;
        private V val;
        private Entry left;
        private Entry right;

        /**
         * Stores KEY as the key in this key-value pair, VAL as the value, and
         * NEXT as the next node in the linked list.
         */
        Entry(K k, V v) {
            this.key = k;
            this.val = v;
        }
    }


}