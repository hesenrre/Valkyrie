package org.lainsoft.forge.view.paginate;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpServletRequest;


/**
 * TagLibrary for paginating lists. This tag provides the enviroment for
 * paging, can be used combined with next_page, prev_page, pages
 *
 * @jsp.tag    name="pages"
 *             body-content="JSP"
 *             description="Paging enviroment".
 */
public class PageNumbers
    extends TagSupport{
    
    private String action;
    private String alias;
    private String styleClass;    
    private String id;
    

    public void
    setStyleClass(String styleClass){
        this.styleClass = styleClass;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getStyleClass(){
        return styleClass;
    }
    
    public void
    setId(String id){
        this.id = id;
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
    setAction(String action){
        this.action = action;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getAction(){
        return action;
    }
    
    public void
    setAlias(String alias){
        this.alias = alias;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String
    getAlias(){
        return alias;
    }

    
    public int
    doStartTag(){
        JspWriter out = pageContext.getOut();
        boolean ajax = ((Boolean)pageContext.getAttribute(getAlias()+"_ajax")).booleanValue();
        String begining = 
            isEmpty(begining = ((HttpServletRequest)pageContext.getRequest()).getParameter(getAlias()+"_begin")) ? "1" : begining;
        
        String pages_beginning = isEmpty(pages_beginning = ((HttpServletRequest)pageContext.getRequest()).getParameter(getAlias()+"_page_begin"))
            ?  isEmpty(pages_beginning = (String)pageContext.getAttribute(getAlias()+"_page_begin")) 
               ? "0" 
               : pages_beginning
            : pages_beginning;
                
        
        try{
            Integer limit, size = null;
            if (!isEmpty(limit = (Integer)pageContext.getAttribute(getAlias()+"_limit")) 
                && !isEmpty(size = (Integer)pageContext.getAttribute(getAlias()+"_size"))){
                double pages = Math.ceil(size.doubleValue() / limit.doubleValue());
                long i = Long.parseLong(pages_beginning);
                long block = isEmpty(pageContext.getAttribute(getAlias()+"_page_blocks")) ? 0 : Long.parseLong((String)pageContext.getAttribute(getAlias()+"_page_blocks"));
                
                
                //out.println(drawActionLink((block > 0 && i - block >= -1),ajax,limit,((i-block)<=0? 0 : (i-block)),"<<"));

                for(; (block > 0 ? i < (Long.parseLong(pages_beginning) + block) : true) && i < pages; i++){
                    long begin = (i * limit.longValue()) + 1;
                    out.println( begining.equals(""+begin) 
                                 ? "<span "+(isEmpty(styleClass)
                                             ? "" 
                                             : " class=\""+getStyleClass()+"\"")+(isEmpty(id)
                                                                              ? "" 
                                                                              : " id=\""+getId()+"\"")+">"+(i+1)+"</span>" 
                                 : drawActionLink(true, ajax, limit, i, pages_beginning, (i+1)+""));
                    
                }
                //out.println(drawActionLink((block > 0 && i < pages),ajax,limit,i,">>"));
            }
            
            
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }


    private String
    drawActionLink(boolean visible, boolean ajax, Integer limit, long index, String label){
        return drawActionLink(visible,ajax,limit, index, index+"",label);
        
    }

    private String
    drawActionLink(boolean visible, boolean ajax, Integer limit, long index, String pages_beginning, String label){
        
        return visible ? "<a "+(isEmpty(styleClass)? "" : "class=\""+getStyleClass()+"\"")+(isEmpty(id)? "" : "id=\""+getId()+"\n")+" href=\""+(ajax ? "#" : "?"+getAlias()+"_begin="+((index * limit.longValue())+1)+getPageBlocks(pages_beginning))+"\""+ (ajax ? " onClick=\"new Ajax.Updater('paginate_"+getAlias()+"','"+pageContext.getAttribute(getAlias()+"_url")+"?"+getAlias()+"_begin="+((index * limit.longValue())+1)+getPageBlocks(pages_beginning)+"',{asynchronous:true, evalScripts:true}); return false;\"" : "") +">"+label+"</a>" : "";
    }


    private String
    getPageBlocks(String index){
        return isEmpty(pageContext.getAttribute(getAlias()+"_page_blocks")) ? "" : "&"+getAlias()+"_page_begin="+index;
    }


    public boolean
    isEmpty(Object o){
        return o == null || o instanceof String && o.toString().trim().equals("");
    }

}
