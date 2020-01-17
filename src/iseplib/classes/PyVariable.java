package iseplib.classes;

import iseplib.Exceptions.ObjectConstructionFailedException;

import java.lang.NumberFormatException;
import java.util.InputMismatchException;

public class PyVariable {
    private char charValue;
    private int intValue = 0;
    private double doubleValue = 0.0;
    private long longValue = 0;
    public String myType = null;
    public String myValue = null;


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
            case "char":
                this.charValue = value.charAt(0);
                break;
            default:
                throw new ObjectConstructionFailedException("Chosen type is invalid (Either not implemented or invalid, really wtf!)");
        }
        this.myType = type;
        this.myValue = value;
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
            case "char":
                System.out.println("My value: " + this.charValue);
                break;
            default:
                throw new ObjectConstructionFailedException("null type detected");
        }

    }

    public void changeType(String newType) throws ObjectConstructionFailedException {
        switch (newType.toLowerCase()) {
            case "int":
            case "double":
            case "long":
            case "char":
                this.myType = newType.toLowerCase();
                break;
            default:
                throw new ObjectConstructionFailedException("Chosen type is invalid (Either not implemented or invalid, really wtf!)");
        }
    }

    public void assignValue(String newValue) throws ObjectConstructionFailedException {
        switch (this.myType) {
            case "int":
                if (Syntax.isInt(newValue)) {
                    this.intValue = Integer.parseInt(newValue);
                } else {
                    throw new InputMismatchException("String given cannot be converted to int");
                }
                break;
            case "double":
                if (Syntax.isAParsableNumber(newValue)) {
                    this.doubleValue = Double.parseDouble(newValue);
                } else {
                    throw new InputMismatchException("String given cannot be converted to double");
                }
                break;
            case "long":
                if (Syntax.isInt(newValue)) {
                    this.intValue = Integer.parseInt(newValue);
                } else {
                    throw new InputMismatchException("String given cannot be converted to long");
                }
                break;
            case "char":
                try {
                    this.charValue = newValue.charAt(0);
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("String could not be converted to char");
                }
                break;
            default:
                throw new ObjectConstructionFailedException("Null type detected.");
        }
    }
}
