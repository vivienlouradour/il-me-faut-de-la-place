package Core;

import java.io.File;
import java.net.URISyntaxException;

class ApplicationDirectoryUtilities
{
    protected static String getProgramDirectory()
    {
        if (runningFromJAR())
            return getCurrentJARDirectory();
        else
            return getCurrentProjectDirectory();
    }

    private static String getCurrentProjectDirectory()
    {
        return new File("").getAbsolutePath();
    }

    private static String getJarName()
    {
        return new File(ApplicationDirectoryUtilities.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath())
                .getName();
    }

    private static boolean runningFromJAR()
    {
        String jarName = getJarName();
        return jarName.contains(".jar");
    }

    private static String getCurrentJARDirectory()
    {
        try
        {
            return new File(ApplicationDirectoryUtilities.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParent();
        } catch (URISyntaxException exception)
        {
            exception.printStackTrace(System.out);
        }
        return null;
    }
}