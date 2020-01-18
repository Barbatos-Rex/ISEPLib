package iseplib.classes;

/**This class has mathematical methods.
 *
 * @author Barbatos Rex
 * @version 1.0.0 Jan 17,2020
 */
public class MyMath {
    /**This methods rounds the function to a certain float.
     *
     * @param value The original value you pretend to round.
     * @param decimalPlace The range/float value.
     * @return Returns the rounded value.
     */

    public static double round(double value, double decimalPlace){
        double tmp= value*Math.pow(10,decimalPlace);
        tmp=Math.round(tmp);
        tmp/=Math.pow(10,decimalPlace);
        return tmp;
    }

    /**Determines the absolute value of a certain number.
     *
     * @param num The number to determine the absolute value.
     * @return Returns the absolute value of the number.
     */

    public static double abs(double num){
        if(num<0){
            return -num;
        }
        return num;
    }

    /**
     * The approximated value of pi.
     */
    public static final double PI =  3.141592653589793;
    /**
     * The approximated value of euler's constant.
     */
    public static final double E = 2.7182818284590452;

    /**Determines the the value of an exponentiation.
     *
     * @param base The number to be raised.
     * @param exponent The power of the raised number.
     * @return The exponentiation value.
     */
    public static double pow(double base, int exponent){
        if(exponent==0){
            return 1;
        }
        return base* pow(base,exponent-1);
    }

    /**
     * Determines the value of an exponentiation
     * @param base The number to be raised.
     * @param exponent The power of the raised number.
     * @return The exponentiation value.
     */
    public static double pow(double base , double exponent){
        return Math.pow(base,exponent);
    }

    /**
     * The method generates the average of the vector given.
     * @param arr An array of doubles.
     * @return The average of the array.
     */
    public static double average(double[] arr){
        if (arr.length == 0) {
            return 0;
        }
        double sum=0;
        for(double number:arr){
            sum+=number;
        }
        return sum/arr.length;
    }

    /**
     * The method generates the average of the vector given.
     * @param arr An array of integers.
     * @return The average of the array.
     */
    public static double average(int[] arr){
        if (arr.length == 0) {
            return 0;
        }
        double sum=0;
        for(double number:arr){
            sum+=number;
        }
        return sum/arr.length;
    }

    /**
     * The method generates the average of the vector given.
     * @param arr An array of integers.
     * @return The average of the array.
     */
    public static double average(long[] arr){
        if (arr.length == 0) {
            return 0;
        }
        double sum=0;
        for(double number:arr){
            sum+=number;
        }
        return sum/arr.length;
    }

    /**
     * This method determines the biggest number in a sequence of numbers.
     * @param numbers A variable number of numerical type parameters.
     * @return The biggest parameter.
     */
    public static double biggest(double ...numbers){
        if(numbers.length==0){
            return 0;
        }
        double biggest=numbers[0];
        for(double num:numbers){
            if(biggest<num){
                biggest=num;
            }
        }
        return biggest;
    }

    /**This method determines the biggest number in a list/vector of numbers.
     *
     * @param arr A list of all numbers to be compared.
     * @return The biggest number in the list/array.
     */
    public static double biggestIn(double[] arr){
        if(arr.length==0){
            return 0;
        }
        double biggest=arr[0];
        for(double num:arr){
            if(biggest<num){
                biggest=num;
            }
        }
        return biggest;
    }

    /**
     This method determines the smallest number in a sequence of numbers.
     * @param numbers A variable number of numerical type parameters.
     * @return The smallest parameter.
     */

    public static double smallest(double ...numbers){
        if(numbers.length==0){
            return 0;
        }
        double smallest=numbers[0];
        for(double num:numbers){
            if(smallest>num){
                smallest=num;
            }
        }
        return smallest;
    }
    /**This method determines the smallest number in a list/vector of numbers.
     *
     * @param arr A list of all numbers to be compared.
     * @return The smallest number in the list/array.
     */
    public static double smallestIn(double[] arr){
        if(arr.length==0){
            return 0;
        }
        double smallest=arr[0];
        for(double num:arr){
            if(smallest>num){
                smallest=num;
            }
        }
        return smallest;
    }

    /**
     * This method generates a random number between 2 numbers.
     * @param min The minimal value.
     * @param max The maximal value
     * @return The random generated number.
     */
    public static int randInt(int min, int max){
        return (int)(Math.random()*(max-min)+min);
    }

    /**
     * This method computes the factorial of an integer.
     * @param x The integer to compute the factorial of.
     * @return The result of the computation of x!.
     */
    public static long factorial(int x){
        if(x==1){
            return 1;
        }
        return x* factorial(x-1);
    }
}
