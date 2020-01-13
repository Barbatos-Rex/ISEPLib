package barbatos_rex;

import java.lang.NumberFormatException;

public class PyVariable {
    private String stringValue = null;
    private int intValue = 0;
    private double doubleValue = 0.0;
    private long longValue = 0;
    public String myType = null;


    public PyVariable(String value, String type) throws ObjectConstructionFailedException {
        type = type.toLowerCase();
        switch (type) {
            case "int":
                if (Syntax.isInt(value)) {
                    this.intValue = Integer.parseInt(value);
                } else {
                    throw new NumberFormatException("The String cannot be converted to int");
                }
                break;
            case "double":
                if (Syntax.isAParsableNumber(value)) {
                    this.doubleValue = Double.parseDouble(value);
                } else {
                    throw new NumberFormatException("The String cannot be converted to double");
                }
                break;
            case "long":
                if (Syntax.isInt(value)) {
                    this.longValue = Long.parseLong(value);
                } else {
                    throw new NumberFormatException("The String cannot be converted to long");
                }
                break;
            case "string":
                this.stringValue = value;
                break;
            default:
                throw new ObjectConstructionFailedException("Chosen type is invalid (Either not implemented or invalid, really wtf!)");
        }
        this.myType = type;
    }

    public void status() throws ObjectConstructionFailedException {
        System.out.println("My type: " + this.myType);
        switch (this.myType) {
            case "int":
                System.out.println("My value: " + this.intValue);
                break;
            case "double":
                System.out.println("My value: " + this.doubleValue);
                break;
            case "long":
                System.out.println("My value: " + this.longValue);
                break;
            case "string":
                System.out.println("My value: " + this.stringValue);
                break;
            default:
                throw new ObjectConstructionFailedException("null type detected");
        }

    }

    public void changeType(String newType) {


    }
}
