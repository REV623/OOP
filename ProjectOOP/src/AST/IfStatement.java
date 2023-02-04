package AST;

import ErrorExcep.EvalError;
import java.util.Map;

public class IfStatement implements Statement{
    private Expression condition;
    private Statement then,Else;

    public IfStatement(Expression condition, Statement then, Statement Else){
        this.condition = condition;
        this.then = then;
        this.Else = Else;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("if (");
        this.condition.prettyPrint(s);
        s.append(") then ");
        this.then.prettyPrint(s);
        s.append(" else ");
        this.Else.prettyPrint(s);
    }

    public boolean eval(Map<String, Long> bindings) throws EvalError {
        if(this.condition.eval(bindings) > 0){
            if(!this.then.eval(bindings)) return false;
        }else{
            if(!this.Else.eval(bindings)) return false;
        }
        return true;
    }
}
