/**
 * Check_Box_Tag.java is part of Forge Project.
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
 * TagLibrary represeting an input check_box_tag.
 *
 * @jsp.tag  name="check_box_tag"
 *           description="CheckBox tag."
 */
public class Check_Box_Tag extends GenericSelectableTag {

    public int doStartTag(){
        JspWriter writer = pageContext.getOut();
        try{
            render_tag("<input type=\'checkbox\' " + 
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
