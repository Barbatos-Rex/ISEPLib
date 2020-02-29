package iseplib.testes;

import iseplib.classes.PyArray;

public class MainTeste {
    public static void main(String[] args){
        double result = 0;
        for(int n=1;n<1;n++){
            result+=Math.pow(.95,n)*Math.pow(.05,10-n);
            System.out.println("---");
            System.out.println(result);
        }
        System.out.println(1-result);
    }
}
