package org.lainsoft.forge.view.scriptaculous;

//import org.lainsoft.forge.view.form.GenericTag;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

/**
 * TagLibrary represeting an input text field tag.
 *
 * @jsp.tag  name="sortable_element"
 *           description="Scriptaculous sortable tag."
 */
public class SortableElement
    extends TagSupport{
    
    public String containers;
    public String element;
    public String handle;
    public String url;
    private String update;
    private boolean scroll;
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String 
    getContainers(){
        return containers;
    }

    public void
    setContainers(String containers){
        this.containers = containers;
    }

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String 
    getElement(){
        return element;
    }

    public void
    setElement(String element){
        this.element =  element;
    }

    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String 
    getHandle(){
        return handle;
    }

    public void
    setHandle(String handle){
        this.handle =  handle;
    }

    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */ 
    
    public String
    getUrl(){
        return url;
    }
    
    public void
    setUrl(String url){
        this.url = parseURL(url);
    }

    public void
    setScroll(boolean scroll){
        this.scroll = scroll;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */ 
    public boolean
    getScroll(){
        return scroll;
    }
    
    private String
    parseURL(String url){
        List deteminants = null;
        String gfs_path = (gfs_path = (String)pageContext.getServletContext().getAttribute("_gfs_alias_path")) == null ? "" : gfs_path;
        return (url == null || (deteminants = Arrays.asList(url.trim().split("[\\s]{0,}=>[\\s]{0,}"))).size() <= 1) ? url :
            (deteminants.get(0).equals(":action")) ? ((HttpServletRequest)pageContext.getRequest()).getContextPath()+gfs_path +"/"+ deteminants.get(1) : "";
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String 
    getUpdate(){
        return isEmpty(update) ? "" : update;
    }
    
    public void
    setUpdate(String update){
        this.update = update;
    }
    
    
        

    // <script type="text/javascript">
//  // <![CDATA[
//    Sortable.create("firstlist",
//      {dropOnEmpty:true,containment:["firstlist","secondlist"],constraint:false});
//    Sortable.create("secondlist",
//      {onUpdate:function(){new Ajax.Updater('list-info', 'http://localhost:8080/multi/flow/Search', {asynchronous:true, evalScripts:true, onComplete:function(request){new Effect.Highlight("secondlist",{});}, parameters:Sortable.serialize("secondlist")})}, dropOnEmpty:true,handle:'handle',containment:["firstlist","secondlist"],constraint:false});
//  // ]]>
//  </script>   

    public int
    doStartTag(){
        try{
            JspWriter writer = pageContext.getOut();
            writer.println("<script type=\"text/javascript\">");
            writer.println("// <![CDATA[");
            writer.println(generateListener());
            writer.println("// ]]>");
            writer.println("</script>");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        
        return SKIP_BODY;
    }
    
    public String
    generateListener(){
        String buffer = "";
        buffer += "try{";
        buffer += "Sortable.destroy(\""+element+"\");\n";
        buffer += scroll ? "Position.includeScrollOffsets = true;\n" : "";
        buffer += "Sortable.create(\""+element+"\",";
        buffer += "{"+ (isEmpty(url)? "" : "onUpdate:function(){new Ajax.Updater('"+getUpdate()+"', '"+getUrl()+"', {asynchronous:true, evalScripts:true, onComplete:function(request){new Effect.Highlight(\""+element+"\",{});}, parameters:Sortable.serialize(\""+element+"\")})},")+(scroll ? " scroll:true, " :"")+" dropOnEmpty:true,"+(isEmpty(handle) ? "" : "handle:'"+handle+"',")+ (isEmpty(containers) ? "":"containment:["+containers+"],")+"constraint:false});";
        buffer += "}catch(exception){}";
        return buffer;
    }

    public int
    doEndTag(){
        return EVAL_PAGE;
    }

    protected boolean isEmpty(Object obj){
        return obj == null || (obj instanceof String && obj.toString().trim().equals(""));        
    }
    
}
