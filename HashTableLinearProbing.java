// Data Structure: Hash Table with Linear Probing
// Time Complexity:
//   - Average Case (Insert/Search/Delete): O(1)
//   - Worst Case: O(n)
// Space Complexity: O(n)
// Key Idea: Resolve collisions by probing subsequent slots linearly
//
// Correctness Invariant:
// - Every key is stored in a position reachable from its hash index
//   via linear probing without skipping empty slots.

package data_structures;

public class HashTableLinearProbing {

    // Entry stored in hash table
    static class Entry {
        long key;
        String value;
        boolean isDeleted;

        Entry(long key, String value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    private final int capacity;
    private Entry[] table;

    public HashTableLinearProbing(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    private int hash(long key) {
        return (int) (key % capacity);
    }

    /**
     * Inserts a key-value pair using linear probing.
     */
    public void insert(long key, String value) {
        int index = hash(key);

        for (int i = 0; i < capacity; i++) {
            int probe = (index + i) % capacity;

            if (table[probe] == null || table[probe].isDeleted) {
                table[probe] = new Entry(key, value);
                return;
            }
        }
        throw new IllegalStateException("Hash table overflow");
    }

    /**
     * Searches for a key in the hash table.
     *
     * @return associated value, or null if not found
     */
    public String search(long key) {
        int index = hash(key);

        for (int i = 0; i < capacity; i++) {
            int probe = (index + i) % capacity;

            if (table[probe] == null) {
                return null;
            }
            if (!table[probe].isDeleted && table[probe].key == key) {
                return table[probe].value;
            }
        }
        return null;
    }

    /**
     * Deletes a key from the hash table.
     */
    public void delete(long key) {
        int index = hash(key);

        for (int i = 0; i < capacity; i++) {
            int probe = (index + i) % capacity;

            if (table[probe] == null) {
                return;
            }
            if (!table[probe].isDeleted && table[probe].key == key) {
                table[probe].isDeleted = true;
                return;
            }
        }
    }
}
