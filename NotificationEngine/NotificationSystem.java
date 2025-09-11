package NotificationEngine;
import java.util.*;

// Notification & decorators

interface INotification{
    String getContent();
}

// Concrete Notification: simple text notification.
class SimpleNotification implements INotification{
    private String text;

    public SimpleNotification(String msg){
        this.text=msg;
    }

    @Override
    public String getContent(){
        return text;
    }
}

//Abstract Decorator: wraps a Notification object.
abstract class INotificationDecorator implements INotification{
    protected INotification notification;

    public INotificationDecorator(INotification n){
        this.notification=n;
    }
}

//Decorator to ad a timestamp to the content
class TimestampDecorator extends INotificationDecorator{
    public TimestampDecorator(INotification n){
        super(n);
    }

    @Override
    public String getContent(){
        return "[2025-09-05 21:30:00]"+notification.getContent();
    }
}

// Decorator to append a signature to the content.
class SignatureDecorator extends INotificationDecorator{
    private String signature;

    public SignatureDecorator(INotification n,String sig){
        super(n);
        this.signature=sig;
    }

    @Override
    public String getContent(){
        return notification.getContent()+"\n-- "+signature+"\n\n";
    }
}

//Override Pattern Components
public class NotificationSystem {
    
}
