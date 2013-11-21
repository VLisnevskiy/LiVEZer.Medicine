package LiVEZer.Medicine.WebApp;

public final class DBTools
{
    public static String EscapeSQL(Object obj)
    {
        String sRes = null;
        if (obj instanceof String)
        {
            sRes = appendQuotes((String) obj);
        }

        return sRes;
    }

    private static String removeWildcard(String s)
    {
        String sRes = s.replaceAll("'", "")
                .replaceAll(";", "")
                .replaceAll("--", "")
                .replaceAll("/*", "");
        return sRes;
    }

    private static String appendQuotes(String s)
    {
        return String.format("'%s'", removeWildcard(s));
    }
}
