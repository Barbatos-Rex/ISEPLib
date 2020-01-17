package iseplib;

import iseplib.Exceptions.ArrayLengthOverflowException;
import iseplib.classes.PyArray;

public class Main {
    public static void main(String[] args) throws ArrayLengthOverflowException {

        PyArray arr = new PyArray(new String[]{"1", "2", "3"});
        arr.print();
        arr.append("4");
        arr.print();
        arr.append("5");
        arr.append("7");
        arr.append("8");
        arr.print();
        arr.invert();
        arr.print();

    }
}
