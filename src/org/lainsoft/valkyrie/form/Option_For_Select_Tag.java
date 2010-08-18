/**
 * Option_For_Select_Tag.java is part of Forge Project.
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
 * TagLibrary represeting an input option_for_select_tag.
 *
 * @jsp.tag  name="option_for_select_tag"
 *           description="Option tag."
 */
public class Option_For_Select_Tag extends GenericTag {

    private String disabled;
    private String value;
    private String label;
    private String size;


    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getDisabled(){
        return disabled;
    }

    public void setDisabled(String disabled){
	boolean d = (new Boolean(disabled)).booleanValue();
        this.disabled = !d ? "" : Boolean.toString(d) ;
    }


    /**
     * @jsp.attribute  required="false"
     *              rtexprlabel="true"
     */
    public String getLabel() {
	return this.label;
    }

    public void setLabel(String label) {
        this.label = isEmpty(label) ? "" : label;
    }


    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getValue() {
	return this.value;
    }

    public void setValue(String value) {
        this.value = isEmpty(value) ? "" : value;
    }


    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getSize() {
	return this.size;
    }

    public void setSize(String size) {
	try {
	    int i = (new Integer(size)).intValue();
	    this.size = (i>=0 ? Integer.toString(i) : "");
	} catch(NumberFormatException e) {
	    this.size = "";
	}
    }



    public String getModifiers() {
	return super.getModifiers() +
	    (isEmpty(disabled) ? "" : "disabled ") +
	    (isEmpty(size) ? "" : "size=\'" + size + "\' ");
    }



    public int doStartTag(){
        JspWriter writer = pageContext.getOut();
        try{
	    writer.print("<option " + 
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
