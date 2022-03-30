package v3;

import operators.BinaryOperator;
import operators.UnaryOperator;

public sealed interface Expr {

    record IntLiteral(int value) implements Expr {}

    record UnaryExpr(UnaryOperator op, Expr expr) implements Expr {}

    record BinaryExpr(BinaryOperator op, Expr left, Expr right) implements Expr {}
}
