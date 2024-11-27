package kevin.service.impl;

import kevin.service.Greeting;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "guest")
@XmlAccessorType(XmlAccessType.NONE)
public class GreetingXml implements Greeting {
    @XmlAttribute
    private int guestId = 0;

    @XmlElement
    private String guestName = "";

    @XmlElement
    private String message = "";

    @Override
    public int getGuestId() {
        return guestId;
    }

    @Override
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    @Override
    public String getGuestName() {
        return guestName;
    }

    @Override
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public GreetingXml() {
        super();
    }

    public GreetingXml(int guestId, String guestName, String message) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.message = message;
    }
}
