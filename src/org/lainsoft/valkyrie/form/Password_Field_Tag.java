/**
 * Password_Field_Tag.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Israel Buitron
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.valkyrie.form;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagLibrary represeting an password input field.
 *
 * @jsp.tag  name="password_field_tag"
 *           description="Password field tag."
 */
public class Password_Field_Tag extends GenericTextTag {

    public int doStartTag(){
        JspWriter writer = pageContext.getOut();
        try{
            render_tag("<input type=\'password\' " + 
			 this.getModifiers() +
			 ">");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }


    public int doEndTag() {
        return EVAL_PAGE;
    }

}
