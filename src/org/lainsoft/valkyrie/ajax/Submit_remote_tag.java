package org.lainsoft.valkyrie.ajax;


import java.io.IOException;
import javax.servlet.jsp.JspWriter;


/**
 * TagLibrary represeting an input text field tag.
 *
 * @jsp.tag  name="submit_to_remote"
 *           description="Text field tag."
 */
public class Submit_remote_tag
    extends GenericAjaxTag{
    
    private String value;
    private String update;
    private String success;
    private String failure;
    private String complete;
    private String confirm;
    
    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String
    getValue(){
        return isEmpty(value)? "": " value=\""+value+"\"";
    }
    
    public void
    setValue(String value){
        this.value=value;
    }
    
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
    getConfirm(){
        return confirm;
    }
    
    public void
    setConfirm(String confirm){
        this.confirm= confirm;
    }

    private String
    getScriptModifiers(){
        return (isEmpty(getSuccess()) ? "" : ", onSuccess:"+getSuccess())+
            (isEmpty(getFailure()) ? "" : ", onFailure:"+getFailure())+
            (isEmpty(getComplete()) ? "" : ", complete:"+getComplete());
    }

    
    
    public int
    doStartTag(){
        try{
            JspWriter writer = pageContext.getOut();
            super.setOnclick(null);
            writer.println("<input type=\'button\' " + getValue()+" "+
                           this.getModifiers() +
                           " onClick=\""+ (isEmpty(getConfirm()) ? "" : "!confirm('"+getConfirm()+"') ? '':")+"new Ajax.Updater('"+getUpdate()+"','"+getUrl()+"',{asynchronous:true, evalScripts:true, parameters:Form.serialize(this.form)"+getScriptModifiers()+"}); return false;\""+
                           "/>");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }
    
    public int
    doEndTag(){
        return EVAL_PAGE;
    }

}
