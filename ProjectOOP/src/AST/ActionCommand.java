package AST;

import ErrorExcep.EvalError;
import java.util.Map;

public class ActionCommand implements Statement{
    private Command action;

    public ActionCommand(Command command){
        if(command.equals(Command.done) || command.equals(Command.relocate)) this.action = command;
    }
    public void prettyPrint(StringBuilder s) {
        if(action.equals(Command.done)) s.append("done");
        else s.append("relocate");
    }

    public boolean eval(Map<String, Long> bindings){
        if(action.equals(Command.done)){ // done command
            return false;
        }else{ // relocate command

        }
        return true;
    }
}
