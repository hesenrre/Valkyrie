/**
 * Select_Tag.java is part of Forge Project.
 *
 * Copyright 2004,2006 LainSoft Foundation, Mirna Bastida
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
 */
package org.lainsoft.valkyrie.form;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import org.lainsoft.commons.beanutils.ValidatedBean;

/**
 * TagLibrary represeting an input text area.
 *
 * @jsp.tag  name="text_area_tag"
 *           body-content="JSP"
 *           description="Input text area tag"
 */
public class Text_Area_Tag extends GenericInputTag{

    private String cols;
    private String rows;

    private String disabled;
    private String readonly;
    
    private String value;



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
                return (field_value.toString());
        }catch(NoSuchMethodException nsme){
            nsme.printStackTrace();
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
        }catch(InvocationTargetException ite){
            ite.printStackTrace();
        }catch(Exception e){
            System.out.println("ANOTHER KIND OF EXCEPTION WAS FOUND>"+e);

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
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getCols() {
	return this.cols;
    }

    public void setCols(String cols) {
	try {
	    int i = (new Integer(cols)).intValue();
	    this.cols = (i>=0 ? Integer.toString(i) : "");
	} catch(NumberFormatException e) {
	    this.cols = "";
	}
    }


    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String getRows() {
	return this.rows;
    }

    public void setRows(String rows) {
	try {
	    int i = (new Integer(rows)).intValue();
	    this.rows = (i>=0 ? Integer.toString(i) : "");
	} catch(NumberFormatException e) {
	    this.rows = "";
	}
    }



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
    public String getReadonly(){
        return readonly;
    }

    public void setReadonly(String readonly){
	boolean ro = (new Boolean(readonly)).booleanValue();
        this.readonly = !ro ? "" : Boolean.toString(ro) ;
    }


    public String getModifiers() {
	return super.getModifiers()+
	    (isEmpty(cols) ? "" : "cols=\'" + cols + "\' ") +
	    (isEmpty(rows) ? "" : "rows=\'" + rows + "\' ");
    }



    public int doStartTag(){
        try {
            String val=getValue();
            String salida=(isEmpty(val)?"</textarea>":val+"</textarea>");
            render_tag("<textarea " + this.getModifiers() + ">"+salida);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }
    
    
    
    public int doEndTag() {
        JspWriter writer = pageContext.getOut();
        try {
        	
        }catch(Exception ioe){
            ioe.printStackTrace();
        }
        return EVAL_PAGE;
    }


}
