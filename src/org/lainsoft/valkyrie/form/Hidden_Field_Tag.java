/**
 * Hidden_Field_Tag.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Israel Buitron
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.valkyrie.form;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import org.lainsoft.commons.beanutils.ValidatedBean;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;


/**
 * TagLibrary represeting an input select_tag.
 *
 * @jsp.tag  name="hidden_field_tag"
 *           description="Hidden field tag."
 */
public class Hidden_Field_Tag extends GenericInputTag {
    
    Log log = LogFactory.getLog(Hidden_Field_Tag.class);

    /**
     * <code>value</code> tag attribute.
     */
    private String value;
    
    /**
     * Gets <code>value</code> tag attribute.
     * @return <code>value</code> tag attribute value.
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getValue() {
        log.debug("IN getvalue()");

        ValidatedBean bean = (ValidatedBean)pageContext.getRequest().getAttribute(getObject());
        log.debug("Bean obtained>"+bean);

        Object field_value = null;
        try{
            if (bean != null && !super.isEmpty(field_value = bean.get(getProperty())))
                return field_value.toString();            
        }catch(NoSuchMethodException nsme){
            nsme.printStackTrace();
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
        }catch(InvocationTargetException ite){
            ite.printStackTrace();
        }
	return this.value;
    }


    /**
     * Sets <code>value</code> tag attribute.
     * If the new value is empty the attribute is assigned a new 
     * <code>String</code>, if not the attribute is assigned 
     * the new value.
     * @param id New <i>value</i> attribute value.
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
    protected String getModifiers() {
	return super.getModifiers() +
	    (isEmpty(getValue()) ? "": "value=\'" + getValue() + "\' ");
    }

    public int doStartTag(){
        log.debug("STARTING TAG");

        JspWriter writer = pageContext.getOut();
        try{
            render_tag("<input type=\'hidden\' " + 
			 this.getModifiers() +
			 ">");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        log.debug("ENDING TAG");

        return SKIP_BODY;
    }

    public int doEndTag() {
        return EVAL_PAGE;
    }
}
