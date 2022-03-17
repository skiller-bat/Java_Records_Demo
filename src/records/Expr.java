package records;

public sealed interface Expr {

    record IntLiteral(int value) implements Expr {}
//    record Variable(String name) implements Expr {}   // yes!
    record UnaryExpr(String op, Expr expr) implements Expr {}
    record BinaryExpr(String op, Expr left, Expr right) implements Expr {}
}

// PlusExpr, TimesExpr, etc.? option, but no
// op as Enum? YES!

// make body non-empty? yes


/*
what do we get?
- private final field & public accessor
- constructor
- equals & hashcode
- toString()
*/