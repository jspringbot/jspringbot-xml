package org.jspringbot.keyword.xml;

import org.jspringbot.KeywordInfo;
import org.jspringbot.syntax.HighlightRobotLogger;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Component
@KeywordInfo(
        name = "Get XML Element Attribute",
        parameters = {"element", "attributeName"},
        description = "classpath:desc/GetXMLElementAttribute.txt"
)
public class GetXMLElementAttribute extends AbstractXMLKeyword {

    public static final HighlightRobotLogger LOG = HighlightRobotLogger.getLogger(GetXMLElementAttribute.class);

    @Override
    public Object execute(Object[] params) throws ParserConfigurationException, IOException, SAXException {
        Element element = (Element) params[0];
        String attributeName = String.valueOf(params[1]);

        String result = element.getAttribute(attributeName);

        LOG.createAppender()
                .appendBold("Get Element Attribute:")
                .appendProperty("Attribute", attributeName)
                .appendProperty("Result", result)
                .log();

        return result;
    }
}
