package org.lainsoft.valkyrie.ajax;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;


/**
 * TagLibrary represeting an input text field tag.
 *
 * @jsp.tag  name="text_field_with_auto_complete"
 *           description="Text field tag."
 */
public class Text_field_with_auto_complete
    extends GenericAjaxTextTag{
    
    private String
    getRealId(){
        return (isEmpty(getObject())||isEmpty(getProperty()) ? "" : getObject()+"_"+ getProperty());
    }
    
    public int
    doStartTag(){
        try{
            super.setId(null);
            JspWriter writer = pageContext.getOut();
            writer.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" sytle=\"margin:0px;\"><tr><td sytle=\"margin:0px;\">");
            writer.println("<style>");
            writer.println("div.auto_complete {");
            writer.println("  margin:0px;");
            writer.println("  padding:0px;");
            writer.println("  overflow:auto;");
            writer.println("  height:150px;");
            //writer.println("  width: 350px;");
            writer.println("  background: #fff;");
            writer.println("}");
            writer.println("div.auto_complete ul {");
            writer.println("  border:1px solid #888;");
            writer.println("  margin:0;");
            writer.println("  padding:0;");
            writer.println("  width:100%;");
            writer.println("  list-style-type:none;");
            writer.println("}");
            writer.println("div.auto_complete ul li {");
            writer.println("  margin:0;");
            writer.println("  padding:3px;");
            writer.println("}");
            writer.println("div.auto_complete ul li.selected { ");
            writer.println("  background-color: #ffb; ");
            writer.println("}");
            writer.println("div.auto_complete ul strong.highlight { ");
            writer.println("  color: #800; ");
            writer.println("  margin:0;");
            writer.println("  padding:0;");
            writer.println("}");
            writer.println("</style><input autocomplete=\"off\" id=\""+getRealId()+"\" type=\"text\" "+getModifiers()+" /><div class=\"auto_complete\" id=\""+getRealId()+"_auto_complete\"></div><script type=\"text/javascript\">new Ajax.Autocompleter('"+getRealId()+"', '"+getRealId()+"_auto_complete', '"+getUrl()+"', {})</script>");
            writer.println("</td></tr></table>");
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
