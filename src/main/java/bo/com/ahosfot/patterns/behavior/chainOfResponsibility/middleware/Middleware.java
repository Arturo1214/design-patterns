package bo.com.ahosfot.patterns.behavior.chainOfResponsibility.middleware;

public abstract class Middleware {

    private Middleware nextMiddleware;

    /**
     * Builds chains of middleware objects.
     */
    public static Middleware link(Middleware firstMiddleware, Middleware... chain) {
        Middleware head = firstMiddleware;
        for (Middleware nexInChain : chain) {
            head.nextMiddleware = nexInChain;
            head = nexInChain;
        }
        return firstMiddleware;
    }

    /**
     * Subclasses will implement this method with concrete checks.
     */
    public abstract boolean check(String email, String password);

    /**
     * Runs check on the next object in chain or ends traversing if we're in
     * last object in chain.
     */
    protected boolean checkNext(String email, String password) {
        if (nextMiddleware == null) {
            return true;
        }
        return nextMiddleware.check(email, password);
    }

}
