package SOLID.Factory;

public class OSFactory {
    public MobileOS getInstance(String type) {
        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("ANDROID")) {
            return new Android();
        } else if (type.equalsIgnoreCase("IOS")) {
            return new IOS();
        } else if (type.equalsIgnoreCase("MICROSOFT")) {
            return new Microsoft();
        } else {
            return null;
        }
    }
}
