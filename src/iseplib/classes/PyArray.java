package iseplib.classes;

/**This class is a way of simulating Python lists in Java.
 *
 * @author Barbatos Rex
 * @version 1.0.0 Jan 17, 2020
 *
 */
public class PyArray{
    protected String[] mainArray = new String[50000000];

    /**The constructor of the class for a non null set of elements.
     *
     * @param list The set of elements (Strings) that initializes the class
     */
    public PyArray(String[] list)  {
        int length = list.length;
        if (length>50000000) {
            length=0;
        } else {
            for (int i = 0; i < length; i++) {
                this.mainArray[i] = list[i];
            }
            this.mainArray = condenser(this.mainArray, list.length,list);
        }
    }

    /**The constructor of the class for a null list.
     *
     */
    public PyArray(){
        this.mainArray= new String[]{};
    }

    /**This method calculates the length of the PyArray.
     *
     * @return The length of the PyArray.
     */
    public int length(){
        return this.mainArray.length;
    }

    /**This method reduces the length of the list to its number of non null elements.
     *
     * @param arr The array to be condensed.
     * @param newLen The new length of the array.
     * @return The newly formed array with non null positions removed.
     */
    private String[] condenser(String[] arr,int newLen){
        int nullElements=countNullElements();
        int posInTmpArr=0;
        String[] tmp = new String[newLen-nullElements];
        for(int i=0;i<newLen;i++){
            if(arr[i]!=null) {
                tmp[posInTmpArr] = arr[i];
                posInTmpArr++;
            }
        }
        return tmp;
    }

    /**This method reduces the length of the list to its number of non null elements. Also this method can be used for external condensing.
     *
     * @param arr The array to be condensed.
     * @param newLen The new length of the array.
     * @param list The original list of values to provide the number of null elements it has.
     * @return The newly formed array with non null positions removed.
     */
    public String[] condenser(String[] arr,int newLen,String[] list){
        int posInTmpArr=0;
        String[] tmp = new String[newLen-countNullElements(list)];
        for(int i=0;i<newLen;i++){
            if(arr[i]!=null) {
                tmp[posInTmpArr] = arr[i];
                posInTmpArr++;
            }
        }
        return tmp;
    }

    /**This method inserts an item in the end of the list.
     *
     * @param str The item to be inserted.
     */
    public void append(String str) {
        if (str != null && !str.equals("")) {
            String tmp[] = new String[this.mainArray.length + 1];
            for (int i = 0; i < this.mainArray.length; i++) {
                tmp[i] = this.mainArray[i];
            }
            tmp[this.mainArray.length] = str;
            this.mainArray = tmp;
        }
    }

    /**This method prints the array in Python form: [element1,element2,...,elementn] for an n length array.
     *
     */
    public String toString() {
        if(this.mainArray.length==0){
            return "[]";
        }
        String tmp="[";
        for(int i=0;i<this.mainArray.length;i++){
            if(i+1!=this.mainArray.length) {
                tmp += this.mainArray[i] + ",";
            }
            else{
                tmp+= this.mainArray[i];
            }
        }
        return tmp+"]";
    }

    /**This method removes an item from any position of the vector.
     *
     * @param index The index of the element to be removed.
     */
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

    /**
     * This method removes the last item in the list.
     */
    public void pop() {
        String[] tmp = new String[this.mainArray.length - 1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = this.mainArray[i];
        }
        this.mainArray = tmp;
    }

    /**This method inverts the items in the vector/array.
     *
     */
    public void invert() {
        String[] tmp = new String[length()];
        for (int i = 0; i < length(); i++) {
            tmp[i] = this.mainArray[length() - i - 1];
        }
        this.mainArray = tmp;
    }

    /**This method allows to place an element in a chosen index, making all elements whose indexes are greater than it being pushed one index away.
     *
     *
     * @param vallue The element you want to insert.
     * @param index The position/index you want it to be inserted.
     *
     * Ex: {1,2,4,5} insert("3","2") -> {1,2,3,4,5}.
     */

    public void insert(String vallue, int index) {

        if (vallue != null && !vallue.equals("")) {
            String[] tmp = new String[length() + 1];
            for (int i = 0; i < index; i++) {
                tmp[i] = this.mainArray[i];
            }
            tmp[index] = vallue;
            for (int i = index + 1; i < tmp.length; i++) {
                tmp[i] = this.mainArray[i - 1];
            }
            this.mainArray = tmp;
        }
    }
        /** A simple method to sort the items/elements in the list,
     *
     */
    public void sort(){
        for(int i=0;i<length();i++){
            for(int j=i+1;j<length();j++){
                if(this.mainArray[j].compareToIgnoreCase(this.mainArray[i])>0){
                    String aux = this.mainArray[i];
                    this.mainArray[i]=this.mainArray[j];
                    this.mainArray[j]=aux;
                }
            }
        }
    }

    /**This method allows the array to assume another list.
     *
     * @param list New list to the array assume.
     */

    public void setValues(String[] list){
        this.mainArray=list;
    }

    /**This method compares the list with an array to see if the are equal.
     *
     * @param arr The array to be compared with the list.
     * @return If the  list is equal to an array, which means if every singe element is equal and is in the same position.
     */
    public boolean isEqualTo(String[] arr) {
        if (arr.length != length()) {
            return false;
        }
        try{
        for (int i = 0; i < MyMath.biggest(length(), arr.length); i++) {
            if (!arr[i].equals(this.mainArray[i])) {
                return false;
            }
        }
        return true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    /**This method compares the list with another one to see if the are equal.
     *
     * @param arr The list to be compared with the list.
     * @return If the  list is equal to another list, which means if every singe element is equal and is in the same position.
     */
    public boolean isEqualTo(PyArray arr){
        if (arr.length() != length()) {
            return false;
        }
        try{
            for (int i = 0; i < MyMath.biggest(length(), arr.length()); i++) {
                if (!arr.mainArray[i].equals(this.mainArray[i])) {
                    return false;
                }
            }
            return true;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    /**
     *
     * @return
     */
    private int countNullElements(){
        int nullElements=0;
        for(String s:this.mainArray){
            if(s==null){
                nullElements++;
            }
        }
        return nullElements;
    }
    private int countNullElements(String[] arr){
        int nullElements=0;
        for(String s:arr){
            if(s==null){
                nullElements++;
            }
        }
        return nullElements;
    }

    /**This method returns the position of an item of the list.
     *
     * @param key The item to be searched.
     * @return Returns the index of the element of the list or -1 if non existent.
     */
    public int index(String key){
        for(int i=0;i<length();i++){
            if(this.mainArray[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    public String value(int index) {
        if (length() < index || index < 0) {
            return null;
        } else {
            if(this.mainArray[index].equals("")){
                return "\"\"";
            }
            return this.mainArray[index];
        }
    }

}
