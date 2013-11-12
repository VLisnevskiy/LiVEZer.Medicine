package LiVEZer.Medicine.WebApp.Services.JSONResponse;

public class Collection extends JSONResponse
{
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Object data;
    private int total;

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }
}
