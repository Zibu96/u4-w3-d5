package giovannighirardelli.exceptions;

public class NotFoundExceptionStr extends RuntimeException {

    public NotFoundExceptionStr(String id) {
        super("L'oggetto  " + id + " non è stato trovato!");
    }
}
