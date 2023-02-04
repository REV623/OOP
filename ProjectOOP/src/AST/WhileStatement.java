package AST;

import ErrorExcep.EvalError;
import java.util.Map;

public class WhileStatement implements Statement{
    private Expression condition;
    private Statement statement;

    public WhileStatement(Expression condition, Statement statement){
        this.condition = condition;
        this.statement = statement;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("while ( ");
        this.condition.prettyPrint(s);
        s.append(" ) ");
        this.statement.prettyPrint(s);
    }

    public boolean eval(Map<String, Long> bindings) throws EvalError {
        long e = this.condition.eval(bindings);
        for (int counter = 0; counter < 10000 && e > 0; counter++) {
            if(!this.statement.eval(bindings)) return false;
            e = this.condition.eval(bindings);
        }
        return true;
    }
}
