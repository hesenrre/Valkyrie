/**
 * Render.java is part of Forge Project.
 *
 * Copyright 2004,2005,2006 LainSoft Foundation, Demetrio Cruz
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
*/
package org.lainsoft.forge.view.customize;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;
import javax.servlet.ServletException;


/**
 * TagLib that defines a zone in a jsp, and includes the portlets of the 
 * defined zone. 
 *
 * @jsp.tag    name="render"
 *             body-content="empty"
 *             description="renders a partial, a template or text".
 */
public class Render
    extends TagSupport{
    
    public int
    doStartTag (){
        JspWriter out = pageContext.getOut();
        try{
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
            out.println("PathInfo>"+request.getPathInfo());
            out.println("ServletPath>"+request.getServletPath());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }        
        return SKIP_BODY;
    }
    
    public int
    doEndTag(){
        return EVAL_PAGE;
    }
}
