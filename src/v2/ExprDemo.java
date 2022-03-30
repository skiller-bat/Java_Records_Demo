package v2;

import operators.BinaryOperator;
import operators.UnaryOperator;

import static v2.Expr.*;

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

        int result = expr.eval();
        System.out.println(result);
    }
}
