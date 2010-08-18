/**
 * Image_Tag.java is part of Forge Project.
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
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagLibrary represeting an input image_tag.
 *
 * @jsp.tag  name="image_tag"
 *           description="Image tag."
 */
public class Image_Tag extends GenericInputTag {

    /**
     * <code>align</code> tag attribute.
     */
    private String align;

    /**
     * <code>alt</code> tag attribute.
     */
    private String alt;

    /**
     * <code>disabled</code> tag attribute.
     */
    private String disabled;

    /**
     * <code>size</code> tag attribute.
     */
    private String size;

    /**
     * <code>src</code> tag attribute.
     */
    private String src;

    /**
     * <code>value</code> tag attribute.
     */
    private String value;


    /**
     * Gets <code>align</code> tag attribute.
     * @return <code>align</code> tag attribute value.
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String getAlign() {
	return this.align;
    }

    /** 
     * Sets <code>align</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param align New <i>align</i> attribute value.
     */
    public void setAlign(String align) {
        this.align = isEmpty(align) ? "" : align;
    }


    /**
     * Gets <code>alt</code> tag attribute.
     * @return <code>alt</code> tag attribute value.
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String getAlt() {
	return this.alt;
    }

    /** 
     * Sets <code>alt</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param alt New <i>alt</i> attribute value.
     */
    public void setAlt(String alt) {
        this.alt = isEmpty(alt) ? "" : alt;
    }



    /**
     * Gets <code>src</code> tag attribute.
     * @return <code>src</code> tag attribute value.
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String getSrc() {
	return this.src;
    }

    /** 
     * Sets <code>src</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param src New <i>src</i> attribute value.
     */
    public void setSrc(String src) {
        this.src = isEmpty(src) ? "" : src.trim();
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
	    (isEmpty(src) ? "" : "src=\'" + src + "\' ") +
	    (isEmpty(alt) ? "" : "alt=\'" + alt + "\' ") +
	    (isEmpty(align) ? "": "align=\'" + align + "\' ") +
	    (isEmpty(disabled) ? "" : "disabled ") +
	    (isEmpty(size) ? "" : "size=\'" + size + "\' ") +
	    (isEmpty(value) ? "": "value=\'" + value + "\' ");
    }


    public int doStartTag(){
        JspWriter writer = pageContext.getOut();
        try{
            render_tag("<input type=\'image\' " + 
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
