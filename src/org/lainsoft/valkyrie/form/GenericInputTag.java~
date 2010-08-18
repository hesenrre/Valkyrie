/**
 * GenericTag.java is part of Forge Project.
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
import org.lainsoft.commons.beanutils.ValidatedBean;

/**
 * TagLibrary represeting an abstract generic input tag.
 */
public abstract class GenericInputTag extends GenericTag {

    private String style;

    /**
     * <code>object</code> tag attribute.
     */
    private String object;

    /**
     * <code>property</code> tag attribute.
     */
    private String property;
    
    /**
     * <code>cssclass</code> tag attribute.
     */
    private String cssclass;
    
    /** 
     * Sets <code>object</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param object New <i>object</i> attribute value.
     */
    public void setObject(String object){
        this.object = isEmpty(object) ? "" : object;
    }

    /**
     * Gets <code>object</code> tag attribute.
     * @return <code>object</code> tag attribute value.
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String getObject(){
        return object;
    }


    /** 
     * Sets <code>property</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param property New <i>property</i> attribute value.
     */
    public void setProperty(String property){
        this.property = isEmpty(property) ? "" : property;
    }

    /**
     * Gets <code>property</code> tag attribute.
     * @return <code>property</code> tag attribute value.
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String getProperty(){
        return property;
    }


    /** 
     * Sets <code>style</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param cssclass New <i>style</i> attribute value.
     */
    public void setCssclass(String cssclass){
	this.cssclass = isEmpty(cssclass) ? "" : cssclass;
    }


    /**
     * Gets <code>style</code> tag attribute.
     * @return <code>style</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getCssclass(){
        return cssclass;
    }


    public void setStyle(String style){
        this.style = isEmpty(style) ? "" : style;
    }


    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getStyle(){
        return style;
    }    


    /**
     * Gets all attributes and their values.
     * If one attribute is not valued (null ore empty) it is not 
     * included in the list.
     * @return <code>String</code> with all valued attributes.
     */
    protected String getModifiers(){
	return 
 	    (isEmpty(object)||isEmpty(property) ? "": "name=\'" + object + "[" + property + "]\' ") +
	    super.getModifiers() + 
	    (isEmpty(cssclass) ? "": "class=\'" + cssclass + "\' ")+
            (isEmpty(style) ? "": "style=\'" + style + "\' ");
    }

    public void
    render_tag(String content)
        throws IOException{
        ValidatedBean bean = (ValidatedBean) pageContext.getRequest().getAttribute(getObject());
        boolean error = false;
        JspWriter writer = pageContext.getOut();        
        if (error = (bean != null && bean.errors().containsKey(getProperty())))
            writer.println("<div id=\"fieldWithError\">");
        
        writer.println(content);
        
        if (error)
            writer.println("</div>");
        
    }
}
