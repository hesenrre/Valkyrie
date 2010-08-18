/**
 * GenericTag.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Demetrio Cruz
 * 
 * Author: Hesenrre (Demetrio Cruz) <hesenrre@lainsoft.org>
 *
 * Credits:
 *
 * -- Demetrio Cruz, Original Author
 * -- Israel Buitron <neoriddle@lainsoft.org>
 * Almost complete reimplementation.
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.valkyrie.form;

import javax.servlet.jsp.tagext.TagSupport;

public abstract class GenericTag extends TagSupport{
    
    /**
     * <code>id</code> tag attribute.
     */
    protected String id;

    /**
     * <code>name</code> tag attribute.
     */
    protected String name;
    
    /**
     * <code>onfocus</code> tag attribute.
     */
    protected String onfocus;

    /**
     * <code>onblur</code> tag attribute.
     */
    protected String onblur;

    /**
     * <code>onselect</code> tag attribute.
     */
    protected String onselect;

    /**
     * <code>onchange</code> tag attribute.
     */
    protected String onchange;

    /**
     * <code>onreset</code> tag attribute.
     */
    protected String onreset;

    /**
     * <code>onkeypress</code> tag attribute.
     */
    protected String onkeypress;

    /**
     * <code>onkeydown</code> tag attribute.
     */
    protected String onkeydown;

    /**
     * <code>onkeyup</code> tag attribute.
     */
    protected String onkeyup;

    /**
     * <code>onclick</code> tag attribute.
     */
    protected String onclick;

    /**
     * <code>ondblclick</code> tag attribute.
     */
    protected String ondblclick;

    /**
     * <code>onmousedown</code> tag attribute.
     */
    protected String onmousedown;

    /**
     * <code>onmouseup</code> tag attribute.
     */
    protected String onmouseup;

    /**
     * <code>onmouseover</code> tag attribute.
     */
    protected String onmouseover;

    /**
     * <code>onmousemove</code> tag attribute.
     */
    protected String onmousemove;

    /**
     * <code>onmouseout</code> tag attribute.
     */
    protected String onmouseout;
    
    /**
     * <code>cssclass</code> tag attribute.
     */
    protected String cssclass;


    /**
     * Sets <code>id</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param id New <i>id</i> attribute value.
     */
    public void setId(String id){
        this.id = isEmpty(id) ? "" : id;
    }

    /**
     * Gets <code>id</code> tag attribute.
     * @return <code>id</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getId(){
        return id;
    }


    /**
     * Sets <code>name</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param name New <i>name</i> attribute value.
     */
    public void setName(String name){
        this.name = isEmpty(name) ? "" : name;
    }
    
    /**
     * Gets <code>name</code> tag attribute.
     * @return <code>name</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getName(){
        return name;
    }


    /**
     * Sets <code>onfocus</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onfocus New <i>onfocus</i> attribute value.
     */
    public void setOnfocus(String onfocus){
	this.onfocus = isEmpty(onfocus) ? "" : onfocus;
    }

    /**
     * Gets <code>onfocus</code> tag attribute.
     * @return <code>onfocus</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnfocus(){
        return onfocus;
    }


    /**
     * Sets <code>onblur</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onblur New <i>onblur</i> attribute value.
     */
    public void setOnBlur(String onblur){
        this.onblur = isEmpty(onblur) ? "" : onblur;
    }

    /**
     * Gets <code>onblur</code> tag attribute.
     * @return <code>onblur</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnBlur(){
        return onblur;
    }


    /**
     * Sets <code>onselect</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onselect New <i>onselect</i> attribute value.
     */
    public void setOnselect(String onselect){
        this.onselect = isEmpty(onselect) ? "" : onselect;
    }

    /**
     * Gets <code>onselect</code> tag attribute.
     * @return <code>onselect</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnselect(){
        return onselect;
    }


    /**
     * Sets <code>onchange</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onchange New <i>onchange</i> attribute value.
     */
    public void setOnchange(String onchange){
        this.onchange = isEmpty(onchange) ? "" : onchange;
    }

    /**
     * Gets <code>onchange</code> tag attribute.
     * @return <code>onchange</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnchange(){
        return onchange;
    }


    /**
     * Sets <code>onclick</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onclick New <i>onclick</i> attribute value.
     */
    public void setOnclick(String onclick){
        this.onclick = isEmpty(onclick) ? "" : onclick;
    }

    /**
     * Gets <code>onclick</code> tag attribute.
     * @return <code>onclick</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnclick(){
        return onclick;
    }


    /**
     * Sets <code>ondblclick</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param ondblclick New <i>ondblclick</i> attribute value.
     */
    public void setOndblclick(String ondblclick){
        this.ondblclick = isEmpty(ondblclick) ? "" : ondblclick;
    }

    /**
     * Gets <code>ondblclick</code> tag attribute.
     * @return <code>ondblclick</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOndblclick(){
        return ondblclick;
    }


    /**
     * Sets <code>onmousedown</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onmousedown New <i>onmousedown</i> attribute value.
     */
    public void setOnmousedown(String onmousedown){
        this.onmousedown = isEmpty(onmousedown) ? "" : onmousedown;
    }

    /**
     * Gets <code>onmousedown</code> tag attribute.
     * @return <code>onmousedown</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnmousedown(){
        return onmousedown;
    }


    /**
     * Sets <code>onmouseup</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onmouseup New <i>onmouseup</i> attribute value.
     */
    public void setOnmouseup(String onmouseup){
        this.onmouseup = isEmpty(onmouseup) ? "" : onmouseup;
    }

    /**
     * Gets <code>onmouseup</code> tag attribute.
     * @return <code>onmouseup</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnmouseup(){
        return onmouseup;
    }


    /**
     * Sets <code>onmouseover</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onmouseover New <i>onmouseover</i> attribute value.
     */
    public void setOnMouseOver(String onmouseover){
        this.onmouseover = isEmpty(onmouseover) ? "" : onmouseover;
    }

    /**
     * Gets <code>onmouseover</code> tag attribute.
     * @return <code>onmouseover</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnmouseover(){
        return onmouseover;
    }


    /**
     * Sets <code>onmousemove</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onmousemove New <i>onmousemove</i> attribute value.
     */
    public void setOnmousemove(String onmousemove){
        this.onmousemove = isEmpty(onmousemove) ? "" : onmousemove;
    }

    /**
     * Gets <code>onmousemove</code> tag attribute.
     * @return <code>onmousemove</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnmousemove(){
        return onmousemove;
    }


    /**
     * Sets <code>onmouseout</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onmouseout New <i>onmouseout</i> attribute value.
     */
    public void setOnmouseout(String onmouseout){
        this.onmouseout = isEmpty(onmouseout) ? "" : onmouseout;
    }

    /**
     * Gets <code>onmouseout</code> tag attribute.
     * @return <code>onmouseout</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnmouseout(){
        return onmouseout;
    }


    /**
     * Sets <code>onkeypress</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onkeypress New <i>onkeypress</i> attribute value.
     */
    public void setOnkeypress(String onkeypress){
        this.onkeypress = isEmpty(onkeypress) ? "" : onkeypress;
    }

    /**
     * Gets <code>onkeypress</code> tag attribute.
     * @return <code>onkeypress</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnkeypress(){
        return onkeypress;
    }


    /**
     * Sets <code>onkeydown</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onkeydown New <i>onkeydown</i> attribute value.
     */
    public void setOnkeydown(String onkeydown){
        this.onkeydown = isEmpty(onkeydown) ? "" : onkeydown;
    }

    /**
     * Gets <code>onkeydown</code> tag attribute.
     * @return <code>onkeydown</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnkeydown(){
        return onkeydown;
    }


    /** 
     * Sets <code>onkeyup</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param onkeyup New <i>onkeyup</i> attribute value.
     */
    public void setOnkeyup(String onkeyup){
        this.onkeyup = isEmpty(onkeyup) ? "" : onkeyup;
    }

    /**
     * Gets <code>onkeyup</code> tag attribute.
     * @return <code>onkeyup</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getOnkeyup(){
        return onkeyup;
    }

    /** 
     * Sets <code>cssclass</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param cssclass New <i>cssclass</i> attribute value.
     */
    public void setCssclass(String cssclass){
        this.cssclass = isEmpty(cssclass) ? "" : cssclass;
    }

    /**
     * Gets <code>cssclass</code> tag attribute.
     * @return <code>cssclass</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getCssclass(){
        return cssclass;
    }

    /**
     * Gets all attributes and their values.
     * If one attribute is not valued (null ore empty) it is not 
     * included in the list.
     * @return <code>String</code> with all valued attributes.
     */
    protected String getModifiers(){
	return 
	    (isEmpty(id)          ? "": "id=\""          + id          + "\" ") +
	    (isEmpty(name)        ? "": "name=\""        + name        + "\" ") +
	    (isEmpty(onfocus)     ? "": "onfocus=\""     + onfocus     + "\" ") +
	    (isEmpty(onblur)      ? "": "onblur=\""      + onblur      + "\" ") +
	    (isEmpty(onselect)    ? "": "onselect=\""    + onselect    + "\" ") +
	    (isEmpty(onchange)    ? "": "onchange=\""    + onchange    + "\" ") +
	    (isEmpty(onreset)     ? "": "onreset=\""     + onreset     + "\" ") +
	    (isEmpty(onkeypress)  ? "": "onkeypress=\""  + onkeypress  + "\" ") +
	    (isEmpty(onkeydown)   ? "": "onkeydown=\""   + onkeydown   + "\" ") +
	    (isEmpty(onkeyup)     ? "": "onkeyup=\""     + onkeyup     + "\" ") +
	    (isEmpty(onclick)     ? "": "onclick=\""     + onclick     + "\" ") +
	    (isEmpty(ondblclick)  ? "": "ondblclick=\""  + ondblclick  + "\" ") +
	    (isEmpty(onmousedown) ? "": "onmousedown=\"" + onmousedown + "\" ") +
	    (isEmpty(onmouseup)   ? "": "onmouseup=\""   + onmouseup   + "\" ") +
	    (isEmpty(onmouseover) ? "": "onmouseover=\"" + onmouseover + "\" ") +
	    (isEmpty(onmousemove) ? "": "onmousemove=\"" + onmousemove + "\" ") +
            (isEmpty(cssclass)    ? "": "class=\""       + cssclass    + "\" ") +
	    (isEmpty(onmouseout)  ? "": "onmouseout=\""  + onmouseout  + "\" ");
    }

    /**
     * Checks if an object is null or if a string is empty.
     * @param obj Object to check.
     * @return <code>true</code> if object is null or a string is 
     *         empty, otherwise <code>false</code>.
     */    
    protected boolean isEmpty(Object obj){
        return obj == null || (obj instanceof String && obj.toString().trim().equals(""));        
    }

    protected boolean isNumber(Object obj){
        return obj instanceof Number || obj instanceof String && obj.toString().matches("[-+]?[\\d]+([\\.]?[\\d]+)?");
    }

    public abstract int doStartTag();
    public abstract int doEndTag();
}
