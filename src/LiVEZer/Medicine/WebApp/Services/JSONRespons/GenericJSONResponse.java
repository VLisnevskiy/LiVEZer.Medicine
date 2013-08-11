package LiVEZer.Medicine.WebApp.Services.JSONRespons;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY,
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.ANY)
public class GenericJSONResponse implements Serializable
{
    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(GenericJSONResponse.class);

    private boolean success;

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    @Override
    public final String toString()
    {
        String sRes;
        StringWriter sw = new StringWriter();
        try
        {
            JsonGenerator generator = (new JsonFactory()).createJsonGenerator(sw);
            (new ObjectMapper()).writeValue(generator, this);
            sRes = sw.toString();
        }
        catch (IOException e)
        {
            logger.error(String.format("Error in Method GenericJSONResponse.toString() %s\n%s",
                    e.getMessage(), e.getStackTrace()));
            sRes = "{\"code\":0,\"message\":\"Exception in class GenericJSONResponse\"}";
        }
        finally
        {
            try
            {
                sw.close();
            }
            catch (Exception e)
            {
            }
        }

        return sRes;
    }
}
