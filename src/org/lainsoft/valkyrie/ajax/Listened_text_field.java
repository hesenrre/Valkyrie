package org.lainsoft.valkyrie.ajax;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;



/**
 * TagLibrary represeting a html <code>input text</code> field.
 *
 * @jsp.tag  name="listened_text_field"
 *           body-content="JSP"
 *           description="Input text tag"
 */
public class Listened_text_field
    extends GenericAjaxTextTag{


    private String update;
    private String success;
    private String failure;
    private String complete;

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


    private String
    getScriptModifiers(){
        return (is_empty(getSuccess()) ? "" : ", onSuccess:"+getSuccess())+
            (is_empty(getFailure()) ? "" : ", onFailure:"+getFailure())+
            (is_empty(getComplete()) ? "" : ", complete:"+getComplete());
    }

    public int
    doStartTag(){
        try{
            JspWriter out = pageContext.getOut();
            out.println("<input type=\"text\" "+getModifiers()+" onkeyup=\"new Ajax.Updater('"+getUpdate()+"','"+getUrl()+"',{asynchronous:true, evalScripts:true, parameters:Form.serialize(this.form)"+getScriptModifiers()+"}); return false;\">");
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
