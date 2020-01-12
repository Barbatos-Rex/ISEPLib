package barbatos_rex;

public class Syntax {

    public static int indexOf(String[] arr,String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
    public static boolean isAParsableNumber(String str){
        try {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    public static void condenserStr(String[] ...vectors){
        for(String[] arr:vectors){
            int nElements=0;
            for (String s : arr) {
                if (s != null) {
                    nElements++;
                }
            }
            int posInArr=0;
            String[] tempVec = new String[nElements];
            for (String s : arr) {
                if (s != null) {
                    tempVec[posInArr] = s;
                    posInArr++;
                }
            }
            arr=tempVec;

        }
    }
}
