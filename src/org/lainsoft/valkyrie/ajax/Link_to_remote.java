package org.lainsoft.valkyrie.ajax;


import java.io.IOException;
import javax.servlet.jsp.JspWriter;


/**
 * TagLibrary represeting an input text area.
 *
 * @jsp.tag  name="link_to_remote"
 *           body-content="JSP"
 *           description="Input text area tag"
 */
public class Link_to_remote
    extends GenericAjaxBodyTag{

    private String update;
    private String success;
    private String failure;
    private String complete;
    private String id;
    private String ccsClass;
    private String title;
    private String style;
    private String confirm;
    

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String 
    getUpdate(){
        return update;
    }
    
    public void
    setUpdate(String update){
        this.update = update;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getSuccess(){
        return success;
    }
    
    public void
    setSuccess(String success){
        this.success = success;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getFailure(){
        return failure;
    }
    
    public void
    setFailure(String failure){
        this.failure = failure;
    }

    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getComplete(){
        return complete;
    }
    
    public void
    setComplete(String complete){
        this.complete = complete;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String 
    getId(){
        return id;
    }
    
    public void 
    setId(String id){
        this.id= id;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getCcsclass(){
        return ccsClass;
    }
    
    public void
    setCcsclass(String ccsClass){
        this.ccsClass= ccsClass;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getTitle(){
        return title;
    }
    
    public void
    setTitle(String title){
        this.title= title;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getStyle(){
        return style;
    }
    
    public void
    setStyle(String style){
        this.style= style;
    }


    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getConfirm(){
        return confirm;
    }
    
    public void
    setConfirm(String confirm){
        this.confirm= confirm;
    }
    
    private boolean
    is_empty(Object o){
        return o == null ? true : (o instanceof String && o.toString().trim().equals(""));
    }

    private String
    getModifiers(){
        return (is_empty(getId()) ? "" : "id=\""+getId()+"\"")+
            (is_empty(getCcsclass()) ? "" : "class=\""+getCcsclass()+"\"")+
            (is_empty(getTitle()) ? "" : "title=\""+getTitle()+"\"")+
            (is_empty(getStyle()) ? "" : "style=\""+getStyle()+"\"");
        
    }

    private String
    getScriptModifiers(){
        return (is_empty(getSuccess()) ? "" : ", onSuccess:"+getSuccess())+
            (is_empty(getFailure()) ? "" : ", onFailure:"+getFailure())+
            (is_empty(getComplete()) ? "" : ", complete:"+getComplete());
    }

    public int
    doStartTag(){
        try{
            JspWriter writer = pageContext.getOut();
            writer.println("<a href=\"#\""+getModifiers()+" onClick=\""+ (is_empty(getConfirm()) ? "" : "!confirm('"+getConfirm()+"') ? '':") +"new Ajax.Updater('"+getUpdate()+"','"+getUrl()+"',{asynchronous:true, evalScripts:true"+getScriptModifiers()+"}); return false;\">");
            
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return EVAL_BODY_BUFFERED;
    }
        
    
    public int
    doAfterBody(){
        JspWriter writer = getBodyContent().getEnclosingWriter();
        try{
            writer.write(getBodyContent().getString());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }

    public int 
    doEndTag() {
        JspWriter writer = pageContext.getOut();
        try {
	    writer.println("</a>");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return EVAL_PAGE;
    }

}
