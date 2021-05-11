package hash_table;

/**
 * 메모 - 해쉬 충돌 방지 기업 중 하나인 Chaining 기법을 사용해서 충돌을 방지를 구현한다.
 *
 * @CreateBy: Bloo
 * @Date: 2021/05/11
 */
public class MyHash2 {

    Slot[] hashTable;

    public MyHash2 ( int size ) {
        this.hashTable = new Slot[size];
    }

    static class Slot {

        String key;
        String value;
        Slot next;

        public Slot ( String key, String value ) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc ( String key ) {
        return ( int ) ( key.charAt(0) ) % this.hashTable.length;
    }

    public void saveNewValue ( String key, String value ) {
        int address = this.hashFunc(key);

        if ( hashTable[address] != null ) {
            Slot findSlot = hashTable[address];
            Slot prevSlot = hashTable[address];

            while ( findSlot != null ) {
                if ( findSlot.key == key ) {
                    findSlot.value = value;
                } else {
                    prevSlot = findSlot;
                    findSlot = prevSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            hashTable[address] = new Slot(key, value);
        }
    }

    public String searchValue ( String key ) {
        int address = hashFunc(key);

        if ( hashTable[address] != null ) {
            Slot findSlot = hashTable[address];
            while ( findSlot != null ) {
                if ( findSlot.key == key ) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main ( String[] args ) {
        MyHash2 myHash2 = new MyHash2(20);
        myHash2.saveNewValue("David", "010-1234-1234");
        myHash2.saveNewValue("Dany", "010-3494-3482");
        myHash2.saveNewValue("Doby", "010-2938-3948");
        myHash2.saveNewValue("Sophi", "010-9584-2939");

        System.out.println(myHash2.searchValue("David"));
    }
}
