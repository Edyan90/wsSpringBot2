package epicode.wsSpringBot2.exceptions;

public class BadRequestEx extends RuntimeException {
    public BadRequestEx(String msg) {
        super(msg);
    }
}
