package chap_array;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/03
 */
public class MaxOfArray {

    static int maxOf(int [] array) {
        int max = array[0];
        for ( int i = 0; i < array.length; i++ ) {
            if ( array[i] > max ) {
                max = array[i];
            }
        }

        return max;
    }

    public static void main ( String[] args ) {
        int [] heights = {173,172,187,167};
        System.out.println ("최고 키는 " + MaxOfArray.maxOf ( heights ) + "입니다." );
    }
    /**
     *
     static void swap ( int [] array, int idx1, int idx2 ) {
     int temp = array[idx1];
     array[idx1] = array[idx2];
     array[idx2] = temp;
     }

     static int [] reverse (int [] array ) {
     for ( int i = 0; i < array.length / 2; i++ ) {
     swap ( array, i, array.length - i -1 );
     }

     return array;
     }

     public static void main ( String[] args ) {
     int [] array = {1,2,3,4,5};

     int [] result  = ReverseArray.reverse ( array );

     for ( int i = 0; i < result.length; i++ ) {
     System.out.print (result[i]);
     }
     }
     */
}
