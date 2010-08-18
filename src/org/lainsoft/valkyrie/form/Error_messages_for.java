/**
 * Error_messages_for.java is part of Forge Project.
 *
 * Copyright 2004,2005,2006 LainSoft Foundation, Demetrio Cruz
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
*/
package org.lainsoft.valkyrie.form;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.io.IOException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;
import javax.servlet.ServletException;

import org.lainsoft.commons.beanutils.ValidatedBean;

/**
 * TagLib that shows validated bean error messages for the request
 *
 * @jsp.tag    name="error_messages_for"
 *             body-content="empty"
 *             description="renders a partial, a template or text".
 */
public class Error_messages_for
    extends TagSupport{
    
    private String object_name;
    
    public void
    setObject_name(String object_name){
        this.object_name = object_name;
    }
    
    /**
     * @jsp.attribute  required="false"
     *                 rtexprvalue="true"
     */
    public String
    getObject_name(){
        return object_name == null ? "" : object_name;
    }

    public void
    setObject_names(String object_names){
        this.object_name = object_names;
    }
    
    /**
     * @jsp.attribute  required="false"
     *                 rtexprvalue="true"
     */
    public String
    getObject_names(){
        return object_name == null ? "" : object_name;
    }


    private boolean
    renderErrorForBean(ValidatedBean bean, boolean header, String name)
    throws IOException{
        JspWriter out = pageContext.getOut();
        if (header) out.println("<div class=\"errorExplanation\" id=\"errorExplanation\">");
        out.println("<h2>"+bean.errors().size()+" error"+(bean.errors().size()>1?"s":"")+" prohibited this "+name+" from being saved</h2>");
        out.println("<p>There were problems with the following fields:</p>");
        out.println("<ul>");
        out.println(getElements(bean.errors()));
        out.println("</ul>");
        return header ? !header : header;        
    }


    public int
    doStartTag(){
        List names = Arrays.asList(getObject_name().split(","));
        try{            
            boolean header = true;
            for (int i=0; i < names.size(); i++){
                Object obj = pageContext.getRequest().getAttribute(names.get(i).toString());
                if (obj != null && obj instanceof ValidatedBean){
                    ValidatedBean bean = (ValidatedBean)obj;
                    if (!bean.errors().isEmpty()){
                        header = renderErrorForBean(bean, header, names.get(i).toString());
                    }
               }
            }
            if (!header) pageContext.getOut().println("</div>");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        
        return SKIP_BODY;
    }
    

    private String
    getElements(Map errors){
        String buffer="";
        for (Iterator it = errors.keySet().iterator(); it.hasNext();){
            String field = (String) it.next();
            buffer += "<li>"+field+" "+((String[])errors.get(field))[1]+"</li>\n";
        }
        return buffer;
    }

    public int
    doEndTag(){
        return EVAL_PAGE;
    }
}
