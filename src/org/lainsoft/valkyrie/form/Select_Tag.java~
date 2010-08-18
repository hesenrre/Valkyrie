/**
 * Select_Tag.java is part of Forge Project.
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
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * TagLibrary represeting an input select_tag.
 *
 * @jsp.tag  name="select_tag"
 *           description="Select tag."
 */
public class Select_Tag extends BodyTagSupport {

    private String disabled;
    private String multiple;
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
     *              rtexprvalue="true"
     */
    public String getMultiple(){
        return multiple;
    }

    public void setMultiple(String multiple){
	boolean m = (new Boolean(multiple)).booleanValue();
        this.multiple = !m ? "" : Boolean.toString(m) ;
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
	return (isEmpty(disabled) ? "" : "disabled ") +
	    (isEmpty(multiple) ? "" : "multiple ") +
	    (isEmpty(size) ? "" : "size=\'" + size + "\' ");
    }



    public int doStartTag(){
        JspWriter writer = pageContext.getOut();
        try{
	    writer.print("<select " + 
			 this.getModifiers() +
			 ">");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return EVAL_BODY_BUFFERED;
    }

    public int doAfterBody() {
	return SKIP_BODY;
    }

    public int doEndTag() {
        return EVAL_PAGE;
    }

    protected boolean isEmpty(String str){
        return str==null || str.trim().equals("");
    }

}
