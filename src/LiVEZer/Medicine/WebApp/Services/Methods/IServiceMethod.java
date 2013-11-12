package LiVEZer.Medicine.WebApp.Services.Methods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LiVEZer.Medicine.WebApp.Services.JSONResponse.JSONResponse;

public interface IServiceMethod
{
    public JSONResponse doMethod(HttpServletRequest request, HttpServletResponse response);
}
