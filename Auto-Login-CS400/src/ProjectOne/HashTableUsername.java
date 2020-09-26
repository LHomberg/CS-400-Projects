package ProjectOne;
//////////////////////////////////////CS400 File Header Information//////////////////////////////////////////
//Project Name: P01																							//
//File Name: HashTableMap.java																				//
//Name: Aabha Mishra																						//
//Email: amishr36@wisc.edu																					//
//TA: Na Li																								//
//Lecturer: Prof. Florian Heimerl																			//																//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTableUsername<KeyTye, ValueType> implements MapADT<KeyTye, ValueType> {

/**
* Private nested class used internally to implement linked lists.
*/
	private class EntryNode<KeyType, ValueType> {
		KeyType website; // key
		ValueType username; // value

		public EntryNode(KeyType key, ValueType value) {
			this.website = key;
			this.username = value;
		}

		public KeyType getKey() {
			return this.website;
		}

		public ValueType getValue() {
			return this.username;
		}
	}

	private LinkedList<EntryNode<KeyTye, ValueType>>[] table;
		int size = 0;

// Capacity of current hash table
	private int capacity;

/**
* Create a hash table with an initial size of 10.
*/
	public HashTableUsername() {
		this.capacity = 10;
		this.table = new LinkedList[this.capacity];

}

/**
* Create a hash table with a specified initial size.
* 
* @param capacity - specified size of table.
*/
	public HashTableUsername(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("Error : Illegal table size");

		this.capacity = capacity;
		this.table = new LinkedList[this.capacity];
	}

/**
* Add a key-value pair to the hash table
* 
* @param key   - key that acts as the key of the entry
* @param value - password to the key that acts as the value of the key
* @return false when the method is passed a key that is already in hash table
* @return true after successfully storing a new key-value pair
*/
@Override
	public boolean put(KeyTye key, ValueType value) {

	if (key == null) {
		throw new NoSuchElementException("The table key cannot be null");
	}

// Since list is not null, the key entry already exists.
	if (this.containsKey(key)) {
		System.out.println("This key already has a corresponding value");
		return false;
	}

// Add new EntryNode at the head of the list to contain the new pair
	int index = hash(key, this.capacity);

	EntryNode<KeyTye, ValueType> entry = new EntryNode<KeyTye, ValueType>(key, value);

	if (this.table[index] == null) {
		this.table[index] = new LinkedList<EntryNode<KeyTye, ValueType>>();
	}

	this.table[index].addFirst(entry);
	size++;
	resize();
	return true;

	}

/**
* @param key - the key associated with the password to be retrieved
* @return password - the value to be retrieved
* @throws NoSuchElementException when presented with a key not in the table
*/

	public ValueType get(KeyTye key) throws NoSuchElementException {

		int index = hash(key, this.capacity);
		EntryNode<KeyTye, ValueType> entry = table[index].getFirst();
		if (entry.getKey().equals(key))
			return entry.getValue();

		for (int i = 0; i < table[index].size(); i++) {
			if (table[index].get(i).getKey().equals(key))
				return table[index].get(i).getValue();

			table[index].iterator().next();
		}

		throw new NoSuchElementException("No key with the entered name present");
	}

/**
* Returns the number of key-value pairs stored in the hash table
* 
* @return size - size of the hash table
*/
	public int size() {
		return this.size;
	}

/**
* @param website - the key to be looked up
* @return false if there is no such key present in the table
* @return true if the key is present in the table
*/
	public boolean containsKey(KeyTye key) {
		int index = hash(key, this.capacity);

		if (table[index] == null) {
			return false;
		}

		for (int i = 0; i < table[index].size(); i++) {
			if (table[index].get(i).getKey().equals(key))
				return true;
		}
		return false;
	}

/**
* Removes key-value pair associated with entered key from the hash table
* 
* @param key
* @return password - reference to the value associated with the key that is
*         being removed
*/
	public ValueType remove(KeyTye key) {

		if (!this.containsKey(key)) {
			System.out.println("No such key exists in the database");
			return null;
		}

		int index = hash(key, this.capacity);

		for (int i = 0; i < table[index].size(); i++) {
			if (table[index].get(i).getKey().equals(key)) {
				EntryNode<KeyTye, ValueType> removed = new EntryNode<KeyTye, ValueType>(table[index].get(i).getKey(),
						table[index].get(i).getValue());
				table[index].remove();
				return removed.getValue();

			}
		}

		return null;
	}

/**
* Clears the hash table
*/
	public void clear() {

		LinkedList<EntryNode<KeyTye, ValueType>>[] newTable = new LinkedList[capacity];
		this.table = newTable;
		this.size = 0;
	}

/**
* Generates a hash for the entered key
* 
* @param key - to be hashed
* @return the hash value of key
*/
	public int hash(KeyTye key, int capacity) {
		return (Math.abs(key.hashCode())) % capacity;
	}

/**
* Creates a new hash table with double the initial capacity Transfers contents
* of old table into the new table by rehashing
*/
	private void resize() {

		if (this.size >= 0.8 * capacity) {

			int oldCapacity = this.capacity;
			LinkedList<EntryNode<KeyTye, ValueType>>[] oldTable = this.table;

			this.capacity = this.capacity * 2;
			this.clear();

			EntryNode<KeyTye, ValueType> entry;

			for (int index = 0; index < oldCapacity; index++) {
				if (oldTable[index] != null) {
					for (int i = 0; i < oldTable[index].size(); i++) {

						entry = oldTable[index].get(i);
						this.put(entry.getKey(), entry.getValue());
					}
				}
			
			}
		}
	}
}