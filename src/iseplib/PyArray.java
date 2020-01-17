package iseplib;

public class PyArray{
    private String[] mainArray= new String[5000];
    public PyArray(String[] list) throws ArrayLengthOverflowException {
        if (list.length > 5000) {
            throw new ArrayLengthOverflowException("The array you tried to create exceeds the memory capacity of the array constructor!");
        } else {
            for (int i = 0; i < list.length; i++) {
                this.mainArray[i] = list[i];
            }
            this.mainArray=condenser(this.mainArray, list.length);
        }
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
}
