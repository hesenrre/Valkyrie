/**
 * Content_for_layout.java is part of Forge Project.
 *
 * Copyright 2004,2005 LainSoft Foundation, Demetrio Cruz
 *
 * You may distribute under the terms of either the GNU General Public
 * License or the Artistic License, as specified in the README file.
 *
*/
package org.lainsoft.valkyrie.customize;


import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;
import javax.servlet.ServletException;


/**
 * TagLib that defines a zone in a jsp, and includes the portlets of the 
 * defined zone. 
 *
 * @jsp.tag    name="content_for_layout"
 *             body-content="empty"
 *             description="Includes content for the layout".
 */
public class Content_for_layout
    extends TagSupport{
    
    public int
    doStartTag (){
        Map content = (content = (Map)pageContext.getRequest().getAttribute("content_for_layout")) == null ? new TreeMap() : content;
        
        if (content.containsKey("text")){
            try{
                JspWriter out = pageContext.getOut();
                out.println(content.get("text"));
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }else if(content.containsKey("template")){
            try{
                pageContext.include((String)content.get("template"));
            }catch(ServletException se){
                se.printStackTrace();
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
