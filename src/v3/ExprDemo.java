package v3;

import operators.BinaryOperator;
import operators.UnaryOperator;

import static v3.Expr.*;

public class ExprDemo {

    public static void main(String[] args) {
        // 6 + (-1) * (9/3) = 3
        Expr expr =
            new Expr.BinaryExpr(
                BinaryOperator.PLUS,
                new IntLiteral(6),
                new BinaryExpr(
                    BinaryOperator.TIMES,
                    new UnaryExpr(
                        UnaryOperator.MINUS,
                        new IntLiteral(1)
                    ),
                    new BinaryExpr(
                        BinaryOperator.DIVIDE,
                        new IntLiteral(9),
                        new IntLiteral(3)
                    )
                )
            );

        System.out.println(expr);

        int result = eval(expr);
        System.out.println(result);
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
