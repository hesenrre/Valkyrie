package org.lainsoft.valkyrie.ajax;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;



/**
 * Observable TagLibrary .
 *
 * @jsp.tag  name="observe_form"
 *           body-content="JSP"
 *           description="Observe Form"
 */
public class ObserveForm
    extends GenericAjaxTag{
    
    private String form;
    private String frequency;
    private String update;
    private String on;
    

    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String 
    getForm(){
        return form;
    }

    public void
    setForm(String form){
        this.form = form;
    }
    
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String 
    getFrequency(){
        return frequency;
    }

    public void
    setFrequency(String frequency){
        this.frequency = frequency;
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
    getOn(){
        return on;
    }

    public void
    setOn(String on){
        this.on = on;
    }
    
    // new Form.Observer('topic_3', 0.25, function(element, value) {new Ajax.Updater('status', '/topics/change_status', {asynchronous:true, evalScripts:true, parameters:value})},'blur') 
    // new Form.EventObserver('topic_3', function(element, value) {new Ajax.Updater('status', '/topics/change_status', {asynchronous:true, evalScripts:true, parameters:value})}, 'blur')
    
    public int
    doStartTag(){
        try{
            JspWriter out = pageContext.getOut();
            out.println("<script type=\"text/javascript\">");
            out.println("//<![CDATA[");
            out.println("new "+(isEmpty(getFrequency()) ? "Form.EventObserver" : "Form.Observer" )+
                        "('"+getForm()+"', "+(isEmpty(getFrequency()) ? "" : getFrequency()+" ,")+
                        "function(element, value) {new Ajax.Updater('"+getUpdate()+"', '"+getUrl()+
                        "', {asynchronous:true, evalScripts:true, parameters:value})}"+ (isEmpty(getOn()) ? "" : ", 'blur'")+")");
            out.println("//]]>");
            out.println("</script>");
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    
    public int
    doEndTag(){
        return EVAL_PAGE;
    }
    
}
