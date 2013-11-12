package LiVEZer.Medicine.WebApp.Services.JSONResponse;

public class Error extends JSONResponse
{
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;

    public int getCode()
    {
        return code;
    }

    /**
     * @param code
     *            - Code: 0 - No such method.
     *            1 - Can't execute method.
     *            2 - Can't access.
     **/
    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
