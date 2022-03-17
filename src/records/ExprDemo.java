package records;

import static records.Expr.*;

public class ExprDemo {

    public static void main(String[] args) {
        // 3 * (-4) = -12
        Expr expr =
            new Expr.BinaryExpr(
                "*",
                new IntLiteral(3),
                new UnaryExpr(
                    "-",
                    new IntLiteral(4)
                )
            );

        System.out.println(expr);
        int result = eval(expr);
        System.out.println(result);
    }

    static int eval(Expr expr) {
        return
            switch (expr) {

                case IntLiteral literal -> literal.value();

                case UnaryExpr unary -> switch (unary.op()) {
                    case "+" -> eval(unary.expr());
                    case "-" -> -eval(unary.expr());
                    default -> throw new IllegalStateException("invalid unary operator: " + unary.op());
                };

                case BinaryExpr binary -> switch (binary.op()) {
                    case "+" -> eval(binary.left()) + eval(binary.right());
                    case "-" -> eval(binary.left()) - eval(binary.right());
                    case "*" -> eval(binary.left()) * eval(binary.right());
                    case "/" -> eval(binary.left()) / eval(binary.right());
                    default -> throw new IllegalStateException("invalid binary operator: " + binary.op());
                };
            };
    }
}

// demonstrative figure
