package records;

import static records.Expr.*;

public class ExprDemo {

    public static void main(String[] args) {
        // 3 * (-4) = -12
        Expr expr =
            new Expr.BinaryExpr(
                BinaryOperator.TIMES,
                new IntLiteral(3),
                new UnaryExpr(
                    UnaryOperator.MINUS,
                    new IntLiteral(4)
                )
            );

        System.out.println(expr);

        int resultMethod = expr.eval();
        System.out.println(resultMethod);

        int resultFunction = eval(expr);
        System.out.println(resultFunction);
    }

    static int eval(Expr expr) {
        return switch (expr) {

                case IntLiteral literal -> literal.value();

                case UnaryExpr unary -> switch (unary.op()) {
                    case PLUS   -> eval(unary.expr());
                    case MINUS  -> -eval(unary.expr());
                };

                case BinaryExpr binary -> switch (binary.op()) {
                    case PLUS   -> eval(binary.left()) + eval(binary.right());
                    case MINUS  -> eval(binary.left()) - eval(binary.right());
                    case TIMES  -> eval(binary.left()) * eval(binary.right());
                    case DIVIDE -> eval(binary.left()) / eval(binary.right());
                };
            };
    }
}

// demonstrative figure
