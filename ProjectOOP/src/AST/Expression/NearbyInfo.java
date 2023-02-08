package AST.Expression;

import AST.ENUM.Direction;
import ErrorExcep.EvalError;

import java.util.Map;

public class NearbyInfo implements Expression{
    private Direction direction;

    public NearbyInfo(Direction direction){
        this.direction = direction;
    }

    public double eval(Map<String, Double> bindings) throws EvalError {
        return 0;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("nearby ");
        s.append(this.direction);
    }
}
