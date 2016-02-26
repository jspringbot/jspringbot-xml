/*
 * Copyright (c) 2012. JSpringBot. All Rights Reserved.
 *
 * See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The JSpringBot licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jspringbot.keyword.xml;

import org.jspringbot.KeywordInfo;
import org.springframework.stereotype.Component;

import javax.xml.transform.TransformerException;

@Component
@KeywordInfo(
        name = "Get XML XPath Text Contents",
        parameters = {"xpathExpression"},
        description = "classpath:desc/GetXMLXPathTextContents.txt"
)
public class GetXMLXPathTextContents extends AbstractXMLKeyword{

    @Override
    public Object execute(Object[] params) {
        try {
            return helper.getXpathTextContents(String.valueOf(params[0]));
        } catch (TransformerException e) {
            throw new IllegalArgumentException(String.format("Error while getting text content for xpath expression %s'.", params[0]));
        }
    }
}
