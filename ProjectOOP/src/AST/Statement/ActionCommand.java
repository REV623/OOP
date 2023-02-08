package AST.Statement;

import AST.ENUM.Command;
import java.util.Map;

public class ActionCommand implements Statement {
    private Command action;

    public ActionCommand(Command command){
        if(command.equals(Command.done) || command.equals(Command.relocate)) this.action = command;
    }
    public void prettyPrint(StringBuilder s) {
        s.append(this.action);
    }

    public boolean eval(Map<String, Double> bindings){
        if(action.equals(Command.done)){ // done command
            return false;
        }else{ // relocate command

        }
        return true;
    }
}
