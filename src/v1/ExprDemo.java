package v1;

import operators.BinaryOperator;
import operators.UnaryOperator;

import static v1.Expr.*;

public class ExprDemo {

    public static void main(String[] args) {
        // 3 * (-4) + x
        Expr expr =
            new BinaryExpr(
                BinaryOperator.PLUS,
                new BinaryExpr(
                    BinaryOperator.TIMES,
                    new IntLiteral(3),
                    new UnaryExpr(
                        UnaryOperator.MINUS,
                        new IntLiteral(4)
                    )
                ),
                new Variable("x")
            );

        System.out.println(expr);
    }
}
