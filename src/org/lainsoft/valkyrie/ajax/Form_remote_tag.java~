package org.lainsoft.forge.view.ajax;


import java.io.IOException;
import javax.servlet.jsp.JspWriter;



/**
 * TagLibrary represeting a html <code>form</code> area.
 *
 * @jsp.tag  name="form_remote_tag"
 *           body-content="JSP"
 *           description="form ajax area tag"
 */
public class Form_remote_tag
    extends GenericAjaxBodyTag{

    private String update;
    private String success;
    private String failure;
    private String complete;
    private String name;
    private String method;
    private String id;
    
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
    getName(){
        return name;
    }
    
    public void
    setName(String name){
        this.name = name;
    }

    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getMethod(){
        return complete;
    }
    
    public void
    setMethod(String method){
        this.method = method;
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
        this.id = id;
    }


    private boolean
    is_empty(Object o){
        return o == null ? true : (o instanceof String && o.toString().trim().equals(""));
    }

    private String
    getModifiers(){
        return (is_empty(getUrl()) ? "" : " action=\""+getUrl()+"\"")+
            (is_empty(getName()) ? "" : " name=\""+getUrl()+"\"")+
            (is_empty(getId()) ? "" : " id=\""+getId()+"\"")+
            (is_empty(getMethod()) ? "" : " method=\""+getMethod()+"\"");
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
            writer.println("<form"+getModifiers()+" onSubmit=\"new Ajax.Updater('"+getUpdate()+"','"+getUrl()+"',{asynchronous:true, evalScripts:true, parameters:Form.serialize(this)"+getScriptModifiers()+"}); return false;\">");
            
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
	    writer.println("</form>");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return EVAL_PAGE;
    }

}
