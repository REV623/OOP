package AST.Statement;

import AST.ENUM.Command;
import AST.Expression.Expression;
import ErrorExcep.EvalError;

import java.util.Map;

public class RegionCommand implements Statement {
    private Command action;
    private Expression expression;

    public RegionCommand(Command command,Expression expression){
        if(command.equals(Command.invest) || command.equals(Command.collect)){
            this.action = command;
            this.expression = expression;
        }
    }

    public void prettyPrint(StringBuilder s) {
        s.append(this.action);
        s.append(" ");
        this.expression.prettyPrint(s);
    }

    public boolean eval(Map<String, Double> bindings) throws EvalError {
        if(action.equals(Command.invest)){ // invest command

        }else{ // collect command

        }
        return true;
    }
}
