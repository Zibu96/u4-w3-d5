package giovannighirardelli.exceptions;

public class NotFoundException extends RuntimeException {


    public NotFoundException(long id) {
        super("L'evento  " + id + " non è stato trovato!... O non sei stato invitato...");
    }


}
