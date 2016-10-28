
import java.util.Random;
/**
 *
 * @author massimiliano
 */
public class ArrayUtil {
    /**
     * Costruisco un array contenente valori casuali
     * length --> lunghezza dell'array
     * n --> numero di valori casuali possibili
     * return --> un array contenente length numeri casuali compresi tra 0 e n-1
     */
    public static int[] randomIntArray(int length, int n)
    {
        int[] a = new int[length];
        Random generator = new Random();
        
        for (int i = 0; i < a.length; i++)
            a[i] = generator.nextInt(n);
        
        return a;
    }
    
    /**
     * Stampo tutti gli elementi di un array.
     * a --> array da stampare
     */
    public static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
