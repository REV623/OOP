package AST.Expression;

import ErrorExcep.EvalError;

import java.util.Map;

public class OpponentInfo implements Expression{
    public OpponentInfo() {};

    public double eval(Map<String, Double> bindings) throws EvalError {
        return 0;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("opponent");
    }
}
