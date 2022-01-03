import gameIF.Response;

public class ResponseImp implements Response {
  private boolean status;
  private String message;

  public ResponseImp(boolean status, String message) {
    this.status = status;
    this.message = message;
  }

  public boolean getStatus() {
    return status;
  }

  public String getMessage()  {
    return message;
  }

}