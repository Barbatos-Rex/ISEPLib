package iseplib;

public class Main {

    public static void main(String[] args) throws ArrayLengthOverflowException {
        PyArray arr = new PyArray(new String[]{"1","2","3","4"});
        arr.print();
        arr.append("3");
    }
}
