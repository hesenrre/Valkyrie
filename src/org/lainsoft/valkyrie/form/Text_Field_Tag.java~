/**
 * Text_Field_Tag.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Israel Buitron
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.forge.view.form;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagLibrary represeting an input text field tag.
 *
 * @jsp.tag  name="text_field_tag"
 *           description="Text field tag."
 */
public class Text_Field_Tag extends GenericTextTag {

    /**
     * <code>maxlength</code> tag attribute.
     */
    private String maxlength;

    /**
     * <code>readonly</code> tag attribute.
     */
    private String readonly;


    /** 
     * Sets <code>readonly</code> tag attribute.
     * @param readonly New <i>readonly</i> attribute value.
     */
    public void setReadonly(String readonly) {
	boolean ro = (new Boolean(readonly)).booleanValue();
	this.readonly = !ro ? "" : Boolean.toString(ro);
    }

    /**
     * Gets <code>readonly</code> tag attribute.
     * @return <code>readonly</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getReadonly() {
	return this.readonly;
    }


    /** 
     * Sets <code>maxlength</code> tag attribute.
     * @param maxlength New <i>maxlength</i> attribute value.
     */
    public void setMaxlength(String maxlength) {
	try {
	    int i = (new Integer(maxlength)).intValue();
	    this.maxlength = (i>=0 ? Integer.toString(i) : "");
	} catch(NumberFormatException e) {
	    this.maxlength = "";
	}
    }
    
    /**
     * Gets <code>maxlength</code> tag attribute.
     * @return <code>maxlength</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getMaxlength() {
	return this.maxlength;
    }



    /**
     * Gets all attributes and their values.
     * If one attribute is not valued (null ore empty) it is not 
     * included in the list.
     * @return <code>String</code> with all valued attributes.
     */
    public String getModifiers() {
	return super.getModifiers() +
	    (isEmpty(readonly)  ? "" : "readonly ") +
	    (isEmpty(maxlength) ? "" : "maxlength=\'" + maxlength + "\' ");
    }


    public int doStartTag(){
        try{
            render_tag("<input type=\'text\' " + 
                       this.getModifiers() +
                       "/>");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }


    public int doEndTag() {
        return EVAL_PAGE;
    }
}
