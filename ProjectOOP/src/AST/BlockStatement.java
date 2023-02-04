package AST;

import ErrorExcep.EvalError;
import java.util.Map;
import java.util.Queue;

public class BlockStatement implements Statement {
    private Queue<Statement> statementQueue;

    public BlockStatement(Queue<Statement> queue){
        this.statementQueue = queue;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("{ ");
        for (Statement statement : this.statementQueue){
            statement.prettyPrint(s);
            s.append(" ");
        }
        s.append("}");
    }

    public boolean eval(Map<String, Long> bindings) throws EvalError {
        while (!this.statementQueue.isEmpty()){
            if(!this.statementQueue.remove().eval(bindings)) return false;
        }
        return true;
    }
}
