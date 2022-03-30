package records;

public sealed interface Expr {

    int eval();

    record IntLiteral(int value) implements Expr {
        @Override
        public int eval() {
            return value;
        }
    }

    record Variable(String name) implements Expr {
        @Override
        public int eval() { // problematic
            return 0;
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



/*
what do we get?
- private final field & public accessor
- constructor
- equals & hashcode
- toString()
*/
