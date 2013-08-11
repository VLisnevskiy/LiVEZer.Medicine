package LiVEZer.Medicine.WebApp.Services.Methods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LiVEZer.Medicine.WebApp.Services.JSONRespons.GenericJSONResponse;

public interface IServiceMethod
{
    public GenericJSONResponse doMethod(HttpServletRequest request, HttpServletResponse response);
}
