package org.example;
import com.windowsazure.messaging.FcmV1Registration;
import com.windowsazure.messaging.NotificationHub;

public class Main {
    public static void main(String[] args) {
        String connectionString = "Endpoint=sb://myatt-test-ns-hub.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        String hubName = "myatt-test-hub";
        String deviceToken = "fiXYGQjxQtmnGLiu3nl14N:APA91bGI216513BEUgqxh7Ux-tg9TgkzAfCqH1m8P7J7k4NCSzCgPdHpI-r6AFgBwMRXL0DNhW8hcbBaqpDnP_A-bS-5y9ILPnY6WL80W6J_S6U4pJbdAT34p9h0Ul4RtX0lO9Fvk-lu";

        NotificationHub hub = new NotificationHub(connectionString, hubName);
        FcmV1Registration registration = new FcmV1Registration(deviceToken);
        registration.getTags().add("abhinav");

        try {
            hub.createRegistration(registration);
            System.out.println("Device registered successfully.");
        } catch (Exception e) {
            System.err.println("Error registering device: " + e.getMessage());
        }
    }
}
