/**
 * Error_messages.java is part of Forge Project.
 *
 * Copyright 2004,2005,2006 LainSoft Foundation, Demetrio Cruz
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
*/


package org.lainsoft.forge.view.form;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;


/**
 * TagLib that shows error messages for the request
 *
 * @jsp.tag    name="error_messages"
 *             body-content="empty"
 *             description="renders a partial, a template or text".
 */
public class ErrorMessages
    extends TagSupport{
    
    private boolean js_activate = false;
    
    public void
    setJs_activate(String activate){
        this.js_activate = Boolean.valueOf(activate).booleanValue();
    }

    public void
    setJs_activate(boolean activate){
        this.js_activate = activate;
    }
    
    /**
     * @jsp.attribute  required="false"
     *                 rtexprvalue="true"
     */
    public boolean
    getJs_activate(){
        return js_activate;
    }

    private String
    getElements(Map errors){
        errors = (errors == null) ? new HashMap(): errors;
        String buffer="";
        for (Iterator it = errors.keySet().iterator(); it.hasNext();){
            String field = (String) it.next();
            buffer += "<li>"+field+" "+errors.get(field)+"</li>\n";
        }
        return buffer;
    }
    
    public int
    doStartTag(){
        
        Map errors = null;
        if (js_activate || (errors = (Map)pageContext.getRequest().getAttribute("errors")) != null){
            try{
            JspWriter out = pageContext.getOut();
            out.println("<div class=\"errorExplanation_messages\" id=\"errorExplanation_messages\""+ (js_activate ? " style=\"display:none;\"" : "") +">");
            out.println("<h2>There where problems with the folowing fields</h2>");
            out.println("<ul id=\"errors\">");
            out.println(getElements(errors));
            out.println("</ul>");
            out.println("</div>");
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return SKIP_BODY;
    }
    
    public int
    doEndTag(){
        return EVAL_PAGE;
    }
}
