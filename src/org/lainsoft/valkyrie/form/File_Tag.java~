/**
 * File_Tag.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Israel Buitron
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.forge.view.form;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagLibrary represeting an input file_tag.
 *
 * @jsp.tag  name="file_tag"
 *           description="File tag."
 */
public class File_Tag extends GenericInputTag {

    private String accept;
    private String disabled;
    private String size;


    /**
     * Gets <code>accept</code> tag attribute.
     * @return <code>accept</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getAccept() {
	return this.accept;
    }

    /** 
     * Sets <code>accept</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param accept New <i>accept</i> attribute value.
     */
    public void setAccept(String accept) {
        this.accept = isEmpty(accept) ? "" : accept;
    }



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
     * Gets all attributes and their values.
     * If one attribute is not valued (null ore empty) it is not 
     * included in the list.
     * @return <code>String</code> with all valued attributes.
     */
    public String getModifiers() {
	return super.getModifiers() +
	    (isEmpty(accept) ? "": "accept=\'" + accept + "\' ") +
	    (isEmpty(disabled) ? "" : "disabled ") +
	    (isEmpty(size) ? "" : "size=\'" + size + "\' ");
    }


    public int doStartTag() {
        JspWriter writer = pageContext.getOut();
        try{
            render_tag("<input type=\'file\' " + 
			 this.getModifiers() +
                       ">");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }

    public int doEndTag() {
        return EVAL_PAGE;
    }
}
