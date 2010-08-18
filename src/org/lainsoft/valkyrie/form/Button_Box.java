/**
 * Button_Box.java is part of Forge Project.
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
 * TagLibrary represeting an input button_box.
 *
 * @jsp.tag  name="button_box"
 *           description="Button tag."
 */
public class Button_Box extends GenericSelectableTag {

    /**
     * <code>disabled</code> tag attribute.
     */
    private String disabled;

    /**
     * <code>size</code> tag attribute.
     */
    private String size;

    /**
     * <code>value</code> tag attribute.
     */
    private String value;
    

    /**
     * Gets <code>disabled</code> tag attribute.
     * @return <code>disabled</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getDisabled(){
        return disabled;
    }

    /** 
     * Sets <code>disabled</code> tag attribute.
     * @param disabled New <i>disabled</i> attribute value.
     */
    public void setDisabled(String disabled){
	boolean d = (new Boolean(disabled)).booleanValue();
        this.disabled = !d ? "" : Boolean.toString(d) ;
    }


    /**
     * Gets <code>size</code> tag attribute.
     * @return <code>size</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getSize() {
	return this.size;
    }

    /** 
     * Sets <code>size</code> tag attribute.
     * @param size New <i>size</i> attribute value.
     */
    public void setSize(String size) {
	try {
	    int i = (new Integer(size)).intValue();
	    this.size = (i>=0 ? Integer.toString(i) : "");
	} catch(NumberFormatException e) {
	    this.size = "";
	}
    }


    /**
     * Gets <code>value</code> tag attribute.
     * @return <code>value</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getValue() {
	return this.value;
    }

    /** 
     * Sets <code>value</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param value New <i>value</i> attribute value.
     */
    public void setValue(String value) {
        this.value = isEmpty(value) ? "" : value;
    }


    /**
     * Gets all attributes and their values.
     * If one attribute is not valued (null ore empty) it is not 
     * included in the list.
     * @return <code>String</code> with all valued attributes.
     */
    public String getModifiers() {
	return super.getModifiers() +
	    (isEmpty(disabled) ? "" : "disabled ") +
	    (isEmpty(size)     ? "" : "size=\'"  + size  + "\' ") +
	    (isEmpty(value)    ? "" : "value=\'" + value + "\' ");
    }



    public int doStartTag(){
        JspWriter writer = pageContext.getOut();
        try{
            render_tag("<input type=\'button\' " + 
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
