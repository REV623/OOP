package AST;

import ErrorExcep.EvalError;
import ErrorExcep.SyntaxError;
import java.util.Map;
import java.util.Queue;

public class Plan {
    private Queue<Statement> statementQueue;

    public Plan(Queue<Statement> queue) throws SyntaxError {
        if(queue.isEmpty()) throw new SyntaxError("construction plan is empty");
        this.statementQueue = queue;
    }

    public void prettyPrint(StringBuilder s) {
        s.append("{ ");
        for (Statement statement : this.statementQueue){
            statement.prettyPrint(s);
            s.append(" ");
        }
        s.append("}\n");
    }

    public void eval(Map<String, Long> bindings) throws EvalError {
        while (!this.statementQueue.isEmpty()){
            if(!this.statementQueue.remove().eval(bindings)) break;
        }
    }
}
