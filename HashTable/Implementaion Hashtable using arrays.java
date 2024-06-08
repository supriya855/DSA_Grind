public class HashTable {
    private int size;
    private String[] keys;
    private String[] values;

    public HashTable(int size) {
        this.size = size;
        keys = new String[size];
        values = new String[size];
    }

    private int hash(String key) {
        // Simple hash function to map key to index
        return Math.abs(key.hashCode()) % size;
    }

    public void put(String key, String value) {
        int index = hash(key);
        keys[index] = key;
        values[index] = value;
    }

    public String get(String key) {
        int index = hash(key);
        return values[index];
    }

    public boolean containsKey(String key) {
        int index = hash(key);
        return keys[index] != null && keys[index].equals(key);
    }

    public void remove(String key) {
        int index = hash(key);
        keys[index] = null;
        values[index] = null;
    }

    public static void main(String[] args) {
        // Example usage of the HashTable class
        HashTable table = new HashTable(10);

        // Insert key-value pairs
        table.put("John", "Doe");
        table.put("Jane", "Smith");
        table.put("Alice", "Johnson");

        // Retrieve values
        System.out.println("Value for key 'John': " + table.get("John")); // Output: Doe
        System.out.println("Value for key 'Jane': " + table.get("Jane")); // Output: Smith
        System.out.println("Value for key 'Alice': " + table.get("Alice")); // Output: Johnson

        // Check if keys exist
        System.out.println("Contains key 'John': " + table.containsKey("John")); // Output: true
        System.out.println("Contains key 'Bob': " + table.containsKey("Bob")); // Output: false

        // Remove a key-value pair
        table.remove("Jane");
        System.out.println("Value for key 'Jane' after removal: " + table.get("Jane")); // Output: null
        System.out.println("Contains key 'Jane' after removal: " + table.containsKey("Jane")); // Output: false
    }
}
