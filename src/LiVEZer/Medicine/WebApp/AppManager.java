package LiVEZer.Medicine.WebApp;

public final class AppManager
{
    private static AppManager instance;

    public static AppManager GetInstance()
    {
        if (instance == null)
        {
            synchronized (AppManager.class)
            {
                instance = new AppManager();
            }
        }
        return instance;
    }

    private AppManager()
    {
    }
}
