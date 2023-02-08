package AST.Expression;

import java.util.Map;

public class Number implements Expression {
    private final long valLong;

    public Number(long val){
        this.valLong = val;
    }

    public double eval(Map<String, Double> bindings) {
        return valLong;
    }

    public void prettyPrint(StringBuilder s) {
        s.append(valLong);
    }
}
