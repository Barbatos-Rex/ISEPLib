package iseplib.classes;

public class MyMath {
    public static double round(double vallue, double decimalPlace){
        double tmp= vallue*Math.pow(10,decimalPlace);
        tmp=Math.round(tmp);
        tmp/=Math.pow(10,decimalPlace);
        return tmp;
    }



    public static double abs(double num){
        if(num<0){
            return -num;
        }
        return num;
    }


    public static final double PI =  3.141592653589793;
    public static final double E = 2.7182818284590452;





    private static double pow(double base, int exponent){
        if(exponent==0){
            return 1;
        }
        return base* pow(base,exponent-1);
    }


    public static double media(double[] arr){
        if (arr.length == 0) {
            return 0;
        }
        double sum=0;
        for(double number:arr){
            sum+=number;
        }
        return sum/arr.length;
    }
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
    public static int randInt(int min, int max){
        return (int)(Math.random()*(max-min)+min);
    }

    public static long factorial(int x){
        if(x==1){
            return 1;
        }
        return x* factorial(x-1);
    }
}
