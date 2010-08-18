/**
 * TextTag.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Israel Buitron
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.valkyrie.form;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.jsp.tagext.TagSupport;
import org.lainsoft.commons.beanutils.ValidatedBean;

/**
 * TagLibrary represeting an abstract generic text tag.
 */
public abstract class GenericTextTag extends GenericInputTag {

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
    private String format;
    

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
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getFormat() {
	return this.format;
    }

    public void setFormat(String format) {
	this.format = format;
    }
    

    /**
     * Gets <code>value</code> tag attribute.
     * @return <code>value</code> tag attribute value.
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getValue(){
        ValidatedBean bean = (ValidatedBean)pageContext.getRequest().getAttribute(getObject());
        Object field_value = null;
         try{             
             if (bean != null && !super.isEmpty(field_value = bean.get(getProperty())))
                 return (field_value instanceof Date 
                    ?  new SimpleDateFormat(isEmpty(format)?"MMddyyyy":format).format((Date)field_value) 
                    : (field_value instanceof Number && !isEmpty(format) ? new DecimalFormat(format).format(((Number)field_value).doubleValue()) : field_value.toString()));
         }catch(NoSuchMethodException nsme){
             nsme.printStackTrace();
         }catch(IllegalAccessException iae){
             iae.printStackTrace();
         }catch(InvocationTargetException ite){
             ite.printStackTrace();
         }catch(Exception e){
             System.out.println("A OTHER KIND OF EXCEPTION WAS FOUND>"+e);

         }
        
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
	    (isEmpty(disabled)   ? "" : "disabled ") +
	    (isEmpty(size)       ? "" : "size=\'"  + size       + "\' ") +
	    (isEmpty(getValue()) ? "" : "value=\'" + getValue() + "\' ");
    }
}
