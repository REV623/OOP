package AST.Statement;

import AST.ENUM.Direction;
import ErrorExcep.EvalError;
import java.util.Map;

public class MoveCommand implements Statement {
    private Direction direction;

    public MoveCommand(Direction direction){
        this.direction = direction;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("move ");
        s.append(this.direction);
    }

    public boolean eval(Map<String, Double> bindings) throws EvalError {
        return true;
    }
}
