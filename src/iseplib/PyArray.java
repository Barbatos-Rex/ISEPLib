package iseplib;

public class PyArray{
    private String[] mainArray= new String[5000];
    public int length;
    public PyArray(String[] list) throws ArrayLengthOverflowException {
        if (list.length > 5000) {
            throw new ArrayLengthOverflowException("The array you tried to create exceeds the memory capacity of the array constructor!");
        } else {
            for (int i = 0; i < list.length; i++) {
                this.mainArray[i] = list[i];
            }
            this.mainArray=condenser(this.mainArray, list.length);
        }
        this.length=mainArray.length;
    }
    public String[] condenser(String[] arr,int newLen){
        String[] tmp = new String[newLen];
        for(int i=0;i<newLen;i++){
            tmp[i]=arr[i];
        }
        this.length=mainArray.length;
        return tmp;
    }
    public void append(String str){
        String tmp[] = new String[this.mainArray.length+1];
        for(int i =0;i<this.mainArray.length;i++){
            tmp[i]=this.mainArray[i];
        }
        tmp[this.mainArray.length]=str;
        this.mainArray=tmp;
        this.length=mainArray.length;
    }
    public void print(){
        System.out.print("["+this.mainArray[0]);
        for(int i=1;i<this.mainArray.length;i++){
            System.out.print(","+this.mainArray[i]);
        }
        System.out.println("]");
        this.length=mainArray.length;
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
        this.length=mainArray.length;
    }
    public void pop(){
        String[] tmp = new String[this.mainArray.length-1];
        for(int i=0;i<tmp.length;i++){
            tmp[i]=this.mainArray[i];
        }
        this.mainArray=tmp;
        this.length=mainArray.length;
    }
    public void reverse(){
        String[] tmp = new String[this.length];
        for(int i=0;i<this.length;i++){
            tmp[i]=this.mainArray[this.length-i-1];
        }
        this.mainArray=tmp;
        this.length=mainArray.length;
    }
    public void insert(String vallue, int index){
        String[] tmp = new String[this.length+1];
        for(int i=0;i<index;i++){
            tmp[i]=this.mainArray[i];
        }
        tmp[index]=vallue;
        for(int i=index+1;i<tmp.length;i++){
            tmp[i]=this.mainArray[i-1];
        }
        this.mainArray=tmp;
        this.length=mainArray.length;
    }
}
