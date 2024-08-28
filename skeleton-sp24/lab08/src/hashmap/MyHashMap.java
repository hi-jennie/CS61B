package hashmap;

import java.util.*;

/**
 * A hash table-backed Map implementation.
 * <p>
 * Assumes null keys will never be inserted, and does not resize down upon remove().
 *
 * @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private int capacity;
    private double loadFactor;
    /* Instance Variables */
    private Collection<Node>[] buckets;
    private int numOfElements;
    private Set<K> keyset;

    /**
     * Constructors
     */
    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * MyHashMap constructor that creates a backing array of initialCapacity.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialCapacity initial size of backing array
     * @param loadFactor      maximum load factor
     */
    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity, double loadFactor) {
        buckets = new Collection[initialCapacity];
        for (int i = 0; i < initialCapacity; i++) {
            buckets[i] = createBucket();
        }
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.numOfElements = 0;
        this.keyset = new HashSet<>();
    }

    private int getIndex(K key, int capacity) {
        return Math.floorMod(key.hashCode(), capacity);
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed");
        }
        int index = getIndex(key, capacity);

        Collection<Node> currentBucket = buckets[index];
        for (Node node : currentBucket) {
            if (node.key.equals(key)) {
                node.value = value;
                // return 在方法有返回值的情况下返回返回值，没有就是中止方法。
                return;
            }
        }
        currentBucket.add(new Node(key, value));
        keyset.add(key);
        numOfElements++;

        // check load factor and resize
        if (numOfElements >= loadFactor * capacity) {
            resize();
        }
    }

    public void resize() {
        int newCapacity = 2 * capacity;
        Collection<Node>[] newBuckets = new Collection[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = createBucket();
        }
        for (Collection<Node> bucket : buckets) {
            for (Node node : bucket) {
                int index = getIndex(node.key, newCapacity);
                newBuckets[index].add(node);
            }
        }

        buckets = newBuckets;
        capacity = newCapacity;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed");
        }
        int index = getIndex(key, capacity);
        Collection<Node> bucket = buckets[index];
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return keyset.contains(key);
    }

    @Override
    public int size() {
        return numOfElements;
    }

    @Override
    public void clear() {
        // 为什么不直接 buckets = null;
        for (Collection<Node> bucket : buckets) {
            bucket.clear();
        }
        numOfElements = 0;
        keyset.clear();
    }

    @Override
    public Set<K> keySet() {
        return keyset;
    }

    @Override
    public V remove(K key) {
        // actually there is no need to check if this key exist cause when looping through the buckets,if return value is null
        // it represents that this key doesn't exist.
        if (key == null) {
            throw new IllegalArgumentException("key doesn't exist");
        }
        int index = getIndex(key, capacity);
        Collection<Node> bucket = buckets[index];
        V temp = null;
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                temp = node.value;
                numOfElements--;
                keyset.remove(key);
                bucket.remove(node);
                break;
            }
        }
        return temp;
    }

    @Override
    public Iterator<K> iterator() {
        return keyset.iterator();
    }

    /**
     * Returns a data structure to be a hash table bucket
     * <p>
     * The only requirements of a hash table bucket are that we can:
     * 1. Insert items (`add` method)
     * 2. Remove items (`remove` method)
     * 3. Iterate through items (`iterator` method)
     * Note that this is referring to the hash table bucket itself,
     * not the hash map itself.
     * <p>
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     * <p>
     * Override this method to use different data structures as
     * the underlying bucket type
     * <p>
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<Node>();
    }

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

}
