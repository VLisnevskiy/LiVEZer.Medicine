package LiVEZer.Medicine.WebApp.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LiVEZer.Medicine.WebApp.Globals;
import LiVEZer.Medicine.WebApp.Services.ServiceManager;
import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;

/**
 * BaseServlet
 */
public class BaseServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Object ob = request.getParameterMap();
        System.out.println(ob);
        String method = request.getParameter(Globals.Method);
        String data = request.getParameter(Globals.Data);
        Write(response, ServiceManager.Do(method, data));
    }

    private void Write(HttpServletResponse response, JSONResponse json)
            throws IOException
    {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toString());
    }
}