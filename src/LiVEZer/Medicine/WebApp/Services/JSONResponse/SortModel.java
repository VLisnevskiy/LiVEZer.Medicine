package LiVEZer.Medicine.WebApp.Services.JSONResponse;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class SortModel extends JSONResponse
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private int page;
    private int size;

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
}
