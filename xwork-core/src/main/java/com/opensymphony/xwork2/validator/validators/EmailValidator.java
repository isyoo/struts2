/*
 * Copyright 2002-2006,2009 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensymphony.xwork2.validator.validators;


/**
 * <!-- START SNIPPET: javadoc -->
 * EmailValidator checks that a given String field, if not empty, is a valid email address.
 *
 * The regular expression used to validate that the string is an email address is:
 *
 * <pre>
 * \\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b
 * </pre>
 *
 * You can also specify expression, caseSensitive and trim params as a OGNL expression, see the example below.
 * <!-- END SNIPPET: javadoc -->
 * 
 * 
 * <!-- START SNIPPET: parameters -->
 * <ul>
 * 		<li>fieldName - The field name this validator is validating. Required if using Plain-Validator Syntax otherwise not required</li>
 * </ul>
 * <!-- END SNIPPET: parameters -->
 *
 * <!-- START SNIPPET: parameters-warning -->
 * Do not use ${expression}, ${caseSensitive} and ${trim} as an expression as this will turn into infinitive loop!
 * <!-- END SNIPPET: parameters-warning -->
 * 
 * <pre>
 * <!-- START SNIPPET: example -->
 *     &lt;!-- Plain Validator Syntax --&gt;
 *     &lt;validators&gt;
 *         &lt;validator type="email"&gt;
 *             &lt;param name="fieldName"&gt;myEmail&lt;/param&gt;
 *             &lt;message&gt;Must provide a valid email&lt;/message&gt;
 *         &lt;/validator&gt;
 *     &lt;/validators&gt;
 *     
 *     &lt;!-- Field Validator Syntax --&gt;
 *     &lt;field name="myEmail"&gt;
 *        &lt;field-validator type="email"&gt;
 *           &lt;message&gt;Must provide a valid email&lt;/message&gt;
 *        &lt;/field-validator&gt;
 *     &lt;/field&gt;
 *
 *     &lt;!-- Field Validator Syntax with expressions --&gt;
 *     &lt;field name="myEmail"&gt;
 *        &lt;field-validator type="email"&gt;
 *           &lt;param name="parse"&gt;true&lt;/param&gt;*
 *           &lt;param name="expression"&gt;${emailPattern}&lt;/param&gt; &lt;!-- will be evaluated as: String getEmailPattern() --&gt;
 *           &lt;param name="caseSensitive"&gt;${emailCaseSensitive}&lt;/param&gt; &lt;!-- will be evaluated as: boolean getEmailCaseSensitive() --&gt;
 *           &lt;param name="trim"&gt;${trimEmail}&lt;/param&gt; &lt;!-- will be evaluated as: boolean getTrimEmail() --&gt;
 *           &lt;message&gt;Must provide a valid email&lt;/message&gt;
 *        &lt;/field-validator&gt;
 *     &lt;/field&gt;
 * <!-- END SNIPPET: example -->
 * </pre>
 *
 * @author jhouse
 * @author tm_jee
 * @version $Date$ $Id$
 */
public class EmailValidator extends RegexFieldValidator {

	// see XW-371 
    public static final String emailAddressPattern =
    	"\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b";

    public EmailValidator() {
        setExpression(emailAddressPattern);
        setCaseSensitive("false");
    }

}
