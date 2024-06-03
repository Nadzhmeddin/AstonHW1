package homework.exceptions;

public class IndexGreaterSizeException extends Exception{


    public IndexGreaterSizeException(int a, int b) {
        super("Index greater size. Your index : " + a + " " + "Your size : " + b);
    }
}
