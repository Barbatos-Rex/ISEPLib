package barbatos_rex;
import java.lang.NumberFormatException;

public class PyVariable {
    private String stringValue = null;
    private int intValue =0;
    private double doubleValue=0.0;
    private long longValue= 0;
    private String myType= null;


    public PyVariable(String value, String type){
        type = type.toLowerCase();
        switch(type){
            case "int":
                if(Syntax.isInt(value)){
                    this.intValue=Integer.parseInt(value);
                }else{
                    throw new NumberFormatException("The String cannot be converted to int");
                }
                break;
            case "double":
                if(Syntax.isAParsableNumber(value)){
                    this.doubleValue=Double.parseDouble(value);
                }else {
                    throw new NumberFormatException("The String cannot be converted to double");
                }
                break;
            case "long":
                if(Syntax.isInt(value)){
                    this.longValue=Long.parseLong(value);
                }else{
                    throw new NumberFormatException("The String cannot be converted to long");
                }
                break;
            case "string":
                    this.stringValue=value;
                break;
            default:
                throw new ClassFormatError("Chosen type is invalid (Either not implemented or not valid, realy wtf!)");
        }

    }





}
