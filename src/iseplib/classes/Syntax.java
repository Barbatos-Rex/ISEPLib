package iseplib.classes;

/**This class intends to be a place to store methods that help with Java Syntax.
 * @author Barbatos Rex
 * @version 1.0.0 Jan 17, 2020
 *
 */
public class Syntax {
    /**
     * This method allows to search an item on the array, returning the first appearance.
     * @param arr The array/vector in which to be search.
     * @param key The item/key to search.
     * @return The position the key is in the array
     */
    public static int indexOf(String[] arr,String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
    public static boolean isInt(String num){
        boolean flag1=isAParsableNumber(num);
        boolean flag2=true;
        for(int i=0;i<num.length();i++){
            if (num.charAt(i) == ',') {
                flag2 = false;
                break;
            }
        }
        return flag1 && flag2;
    }

    /**This methods verifies if a given string can be converted/parsed to a numerical value.
     *
     * @param str The String to be parsed.
     * @return Returns true if the String can be parsed and false if not.
     */
    public static boolean isAParsableNumber(String str){
        try {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    /**A multi-vector unidimensional array condenser.
     *
     * @param vectors A variable number of arrays to be condensed.
     */
    public static void condenserStr(String[] ...vectors) {
        if (vectors.length != 0) {
            for (String[] arr : vectors) {
                int nElements = 0;
                for (String s : arr) {
                    if (s != null) {
                        nElements++;
                    }
                }
                int posInArr = 0;
                String[] tempVec = new String[nElements];
                for (String s : arr) {
                    if (s != null) {
                        tempVec[posInArr] = s;
                        posInArr++;
                    }
                }
                arr = tempVec;
            }
        }
    }

    /**Generates a simple matrix with the vector's items and its indexes.
     *
     * @param arr The vector to be generate the table.
     * @return Returns the table created.
     */
    public static String[][] tableCreator(String[] arr) {
        String[][] tab = new String[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            tab[i][0] = Integer.toString(i);
            tab[i][1] = arr[i];
        }
        return tab;
    }

    /**Genrates a vector of integers with a vector of Strings.
     *
     * @param arr The array of Strings.
     * @return Returns the array of integers.
     */
    public static int[] stringToIntArr(String[] arr) {
        int[] nArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = Integer.parseInt(arr[i]);
        }
        return nArr;
    }
}

