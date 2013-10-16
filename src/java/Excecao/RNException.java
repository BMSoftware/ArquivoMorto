package Excecao;

/**
 *
 * @author Bruno
 */
public class RNException extends Exception{

    public RNException(){
        super();
    }
    public RNException(String message){
        super(message);
    }
    public RNException (Throwable cause){
        super(cause);
    }
    public RNException(String message, Throwable cause){
        super(message, cause);
    }
}
