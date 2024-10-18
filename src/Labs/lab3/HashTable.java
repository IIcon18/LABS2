package Labs.lab3;

import java.util.LinkedList;

public class HashTable <K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    private LinkedList<Entry<K, V>>[] table;


    public HashTable() {
        table = new LinkedList[10];
        size = 0;
    }

    private int hash(Object key) {
        return (key == null) ? 0 : (key.hashCode() & 0x7fffffff) % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            table[index] = bucket;
        }
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
        if (size >= table.length * DEFAULT_LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        if (bucket == null) {
            return null;
        }
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        if (bucket == null) {
            return;
        }
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    private void resize() {
        LinkedList<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[table.length * 2];
        for (LinkedList<Entry<K, V>> list : oldTable) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
                }
            }
        }
        sb.replace(sb.length() - 2, sb.length(), "}");
        return sb.toString();
    }

}