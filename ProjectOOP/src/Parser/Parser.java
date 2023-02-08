package Parser;

import AST.Node;
import ErrorExcep.SyntaxError;

public interface Parser {
    Node parse() throws SyntaxError;
}
