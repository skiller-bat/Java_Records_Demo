package v2;

import operators.BinaryOperator;
import operators.UnaryOperator;

public sealed interface Expr {

    int eval();

    record IntLiteral(int value) implements Expr {
        @Override
        public int eval() {
            return value;
        }
    }

    record UnaryExpr(UnaryOperator op, Expr expr) implements Expr {
        @Override
        public int eval() {
            return switch (op) {
                case PLUS   -> expr.eval();
                case MINUS  -> -expr.eval();
            };
        }
    }

    record BinaryExpr(BinaryOperator op, Expr left, Expr right) implements Expr {
        @Override
        public int eval() {
            return switch (op) {
                case PLUS   -> left.eval() + right().eval();
                case MINUS  -> left.eval() - right().eval();
                case TIMES  -> left.eval() * right().eval();
                case DIVIDE -> left.eval() / right().eval();
            };
        }
    }
}
