package hash_table;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/11
 */
public class MyHash {

    private Slot[] hashTable;

    public MyHash ( int size ) {
        this.hashTable = new Slot[size];
    }

    static class Slot {

        String value;

        public Slot ( String value ) {
            this.value = value;
        }
    }

    public int hashFunc ( String key ) {
        return ( int ) ( key.charAt(0) ) % this.hashTable.length;
    }

    public void saveNewValue ( String key, String value ) {
        int address = this.hashFunc(key);
        if ( this.hashTable[address] != null ) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
    }

    public String searchValue (String key) {
        int address = this.hashFunc(key);

        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main ( String[] args ) {
        MyHash myHash = new MyHash(20);
        myHash.saveNewValue("David", "010-2222-3333");
        myHash.saveNewValue("Mapi", "010-1234-1234");
        myHash.saveNewValue("Tom", "010-3842-2394");

        System.out.println(myHash.searchValue("David"));
    }
}
