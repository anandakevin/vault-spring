package kevin.service.impl;

import kevin.service.Greeting;

public class GreetingJson implements Greeting {
    private int guestId = 0;
    private String guestName = "";
    private String message = "";

    public GreetingJson() {
        super();
    }

    public GreetingJson(int guestId, String guestName, String message) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.message = message;
    }

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
}
