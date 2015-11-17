package in.ideal.user.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import in.ideal.user.models.UserNames;

/**
 * Created by Siva on 20-10-2015.
 */
public class XMLPullParserHandler{
    List<UserNames> userNames;
    private UserNames username;
    private String text;

    public XMLPullParserHandler() {
        userNames = new ArrayList<UserNames>();
    }

    public List<UserNames> getUserNames() {
        return userNames;
    }

    public List<UserNames> parse(InputStream is) {
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("username")) {
                            // create a new instance of employee
                            username = new UserNames();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("username")) {
                            // add employee object to list
                            userNames.add(username);
                        } else if (tagname.equalsIgnoreCase("name")) {
                            username.setName(text);
                        }  else if (tagname.equalsIgnoreCase("bloodGroup")) {
                           username.setBloodGroup(text);
                          }
                        else if (tagname.equalsIgnoreCase("phoneNumber")) {
                            username.setPhoneNmuber(text);
                        } else if (tagname.equalsIgnoreCase("area")) {
                            username.setLocation(text);
                        } else if (tagname.equalsIgnoreCase("location")) {
                            username.setArea(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userNames;
    }
}
