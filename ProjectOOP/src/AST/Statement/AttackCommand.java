package AST.Statement;

import AST.ENUM.Direction;
import AST.Expression.Expression;
import ErrorExcep.EvalError;
import java.util.Map;

public class AttackCommand implements Statement {
    private Direction direction;
    private Expression expression;

    public AttackCommand(Direction direction, Expression expression){
        this.direction = direction;
        this.expression = expression;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("shoot ");
        s.append(this.direction);
        s.append(" ");
        this.expression.prettyPrint(s);
    }

    public boolean eval(Map<String, Double> bindings) throws EvalError {
        return true;
    }
}
