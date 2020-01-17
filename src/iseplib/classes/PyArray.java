package iseplib.classes;

import iseplib.Exceptions.ArrayLengthOverflowException;

public class PyArray{
    private String[] mainArray = new String[50000000];
    public PyArray(String[] list) throws ArrayLengthOverflowException {
        if (list.length > 50000000) {
            throw new ArrayLengthOverflowException("The array you tried to create exceeds the memory capacity of the array constructor!");
        } else {
            for (int i = 0; i < list.length; i++) {
                this.mainArray[i] = list[i];
            }
            this.mainArray = condenser(this.mainArray, list.length);
        }
    }
    public int length(){
        return this.mainArray.length;
    }
    public String[] condenser(String[] arr,int newLen){
        String[] tmp = new String[newLen];
        for(int i=0;i<newLen;i++){
            tmp[i]=arr[i];
        }
        return tmp;
    }
    public void append(String str){
        String tmp[] = new String[this.mainArray.length+1];
        for(int i =0;i<this.mainArray.length;i++){
            tmp[i]=this.mainArray[i];
        }
        tmp[this.mainArray.length]=str;
        this.mainArray=tmp;
    }
    public void print(){
        System.out.print("["+this.mainArray[0]);
        for(int i=1;i<this.mainArray.length;i++){
            System.out.print(","+this.mainArray[i]);
        }
        System.out.println("]");
    }
    public void pop(int index){
        String[] tmp = new String[this.mainArray.length-1];
        for(int i=0;i<index;i++){
            tmp[i]=this.mainArray[i];
        }
        for(int i=index;i<tmp.length;i++){
            tmp[i]=this.mainArray[i+1];
        }
        this.mainArray=tmp;
    }

    public void pop() {
        String[] tmp = new String[this.mainArray.length - 1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = this.mainArray[i];
        }
        this.mainArray = tmp;
    }

    public void invert() {
        String[] tmp = new String[length()];
        for (int i = 0; i < length(); i++) {
            tmp[i] = this.mainArray[length() - i - 1];
        }
        this.mainArray = tmp;
    }

    public void insert(String vallue, int index) {
        String[] tmp = new String[length() + 1];
        for (int i = 0; i < index; i++) {
            tmp[i] = this.mainArray[i];
        }
        tmp[index]=vallue;
        for(int i=index+1;i<tmp.length;i++){
            tmp[i]=this.mainArray[i-1];
        }
        this.mainArray=tmp;
    }
    private void swap(int index1){
        String aux = this.mainArray[index1];
        this.mainArray[index1]=this.mainArray[index1+1];
        this.mainArray[index1+1]=aux;
    }
    public void sort(){
        int posInArr=0;
        while(posInArr!=length()-1){
            if(this.mainArray[posInArr].compareToIgnoreCase(this.mainArray[posInArr+1])>0){
                swap(posInArr);
                posInArr=0;
            }else{
                posInArr++;
            }
        }
    }
}
