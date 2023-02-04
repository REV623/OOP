package AST;

import java.util.Map;

public class Number implements Expression{
    private long valLong;
    private double valDouble;

    public Number(long val){
        this.valLong = val;
    }

    public Number(double val){
        this.valDouble = val;
    }

    public long eval(Map<String, Long> bindings) {
        return valLong;
    }

    public void prettyPrint(StringBuilder s) {
        s.append(valLong);
    }
}
