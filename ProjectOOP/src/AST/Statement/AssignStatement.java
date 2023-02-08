package AST.Statement;

import AST.Expression.*;
import ErrorExcep.EvalError;
import java.util.Map;

public class AssignStatement implements Statement {
    private Identifier variable;
    private Expression expression;

    public AssignStatement(Identifier variable, Expression expression){
        this.variable = variable;
        this.expression = expression;
    }

    public void prettyPrint(StringBuilder s) {
        this.variable.prettyPrint(s);
        s.append(" = ");
        this.expression.prettyPrint(s);
    }

    public boolean eval(Map<String, Double> bindings) throws EvalError {
        String var = this.variable.getName();
        String[] specialVar = {"rows","cols","currow","curcol","budget","deposit","int","maxdeposit","random"};
        for(String sv : specialVar){
            if(var.equals(sv)) return true;
        }
        bindings.put(var, this.expression.eval(bindings));
        return true;
    }
}
