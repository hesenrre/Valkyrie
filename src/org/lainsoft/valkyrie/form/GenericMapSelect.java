package org.lainsoft.valkyrie.form;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.jsp.JspWriter;

/**
 * TagLib that defines a zone in a jsp, and includes the portlets of the 
 * defined zone. 
 *
 * @jsp.tag    name="map-select"
 *             body-content="empty"
 *             description="html select based on maps".
 */
public class GenericMapSelect
    extends GenericTag{
    
    private Map options;
    private String selText;
    private String selected;
    private boolean sortedByContent;

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public Map
    getOptions(){
        return options;
    }

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String
    getSelText(){
        return selText;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getSelected(){
        return selected;
    }
       
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public boolean
    getSortedByContent(){
        return sortedByContent;
    }

    public void
    setOptions(Map options){
        this.options = options;
    }        
    
    public void
    setSelText(String selText){
        this.selText=selText;
    }
    
    public void
    setSelected(String selected){
        this.selected = selected;
    }

    public void
    setSortedByContent(boolean sortedByContent){
        this.sortedByContent = sortedByContent;
    }

    public int 
    doStartTag(){
        JspWriter writer = pageContext.getOut();
        try {
            writer.println("<select "+getModifiers()+">");
            if (sortedByContent)
                sortByContent();
            writer.println(optionsToString());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }
        

    public int
    doEndTag(){
        JspWriter writer = pageContext.getOut();
        try{
            writer.println("</select>");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return EVAL_PAGE;
    }

    private String
    optionsToString(){
        String buffer = "<option value=-1>"+getSelText()+"</option>";
        for (Iterator iterator = getOptions().keySet().iterator(); iterator.hasNext();){
            String key = (String)iterator.next();
            buffer += "<option value=\""+(sortedByContent?getOptions().get(key):key)+"\""+
                ((sortedByContent? getOptions().get(key).equals(selected):key.equals(selected))?" selected":"")+">"+
                (sortedByContent?key:getOptions().get(key))+"</option>\n";
        }
        return buffer;
    }

    private void
    sortByContent(){
        TreeMap buffer = new TreeMap();
        for(Iterator iterator = getOptions().keySet().iterator(); iterator.hasNext();){
            String key = (String)iterator.next();
            buffer.put(getOptions().get(key),key);
        }
        setOptions(buffer);
    }

}
