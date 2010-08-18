package org.lainsoft.forge.view.paginate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * 
 * 
 *
 * @jsp.tag    name="page_control"
 *             body-content="JSP"
 *             description="Paging enviroment".
 */
public class PaginateControl
    extends TagSupport{
    
    private String action;
    private String alias;
    private String label;
    private String icon;
    private String styleClass;
    private String id;

    private String blocks;
    private Integer limit;
    private Integer size;    
    private Map sequence;    

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
        
    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String 
    getAction(){
        return action;
    }
    
    public void
    setAction(String action){
        this.action = action;
    }
    
    /**
     * @jsp.attribute  required="true"
     *              rtexprvalue="true"
     */
    public String 
    getAlias(){
        return alias;
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
    getLabel(){
        return label;
    }
    
    public void
    setLabel(String label){
        this.label = label;
    }
    
    /**
     * @jsp.attribute  required="false"
     *              rtexprvalue="true"
     */
    public String 
    getIcon(){
        return icon;
    }
    
    public void
    setIcon(String icon){
        this.icon = icon;
    }
    
    private String
    getBlocks(){
        return isEmpty(blocks) 
            ? (blocks = (String)pageContext.getAttribute(getAlias()+"_page_blocks")) 
            : blocks;
    }

    private Integer
    getSize(){
        System.out.println("DOWNLOAD "+getAlias()+"_size = "+pageContext.getAttribute(getAlias()+"_size"));
        // return isEmpty(size)
        //             ? (size = (Integer)pageContext.getAttribute(getAlias()+"_size"))
//             : size;
        return (Integer)pageContext.getAttribute(getAlias()+"_size");
    }

    public long
    getLimit(){
        
        return (isEmpty(limit) 
           ? isEmpty(limit = (Integer)pageContext.getAttribute(getAlias()+"_limit")) 
               ? new Integer(0)
               : limit
           : limit).longValue();
    }
    
    private Integer
    getOriginalBegin(){
        Integer begin = null;
        return isEmpty(begin = (Integer)pageContext.getAttribute(getAlias()+"_begin")) ? new Integer(0) : begin;
    }

    public int
    getBegin(){
                
        
        System.out.println("action>"+action+" begin>"+getOriginalBegin());

        if (action.equalsIgnoreCase("next")){
            return getOriginalBegin().intValue()+(int)getLimit();
        }else if (action.equalsIgnoreCase("prev")){
            return getOriginalBegin().intValue()-(int)getLimit();
        }else if (action.equalsIgnoreCase("fwd")){
            return nextInSequence(getOriginalBegin().intValue())+1;
        }else if (action.equalsIgnoreCase("bwd")){
            int prev = prevInSequence(getOriginalBegin().intValue()-1);
            return prev + 1;
        }
        
        return 0;
    }


    private int
    nextInSequence(int current){        
        for(Iterator it = getSequence().keySet().iterator(); it.hasNext();){
            Integer block = (Integer)it.next();
            if (block.intValue() >= current){
                return block.intValue();
            }
        }        
        return getSize().intValue()+1;
    }
    
    private int
    prevInSequence(int current){
        ArrayList keys = new ArrayList(getSequence().keySet());
        Collections.reverse(keys);
        for(Iterator it = keys.iterator(); it.hasNext();){
            Integer block = (Integer)it.next();
            if (block.intValue() < current){
                return block.intValue();
            }
        }
        return -1;
    }

    public Map
    getSequence(){
        if (isEmpty(getBlocks()) || getLimit() <= 0 || isEmpty(getSize())) return new TreeMap();
        
        if (isEmpty(sequence)){            
            int current = 0;
            sequence = new TreeMap();
            for (int i=0; (current = (((int)getLimit() * Integer.parseInt(getBlocks())) * i)) < getSize().intValue(); i++){
                sequence.put(new Integer(current),
                             new Integer(Integer.parseInt(getBlocks()) * i));            
            }
        }
        return sequence;
    }


    public boolean
    visible(int begin){
        int prevInSeq;
        if (action.equalsIgnoreCase("bwd"))System.out.println("prev for original>"+prevInSequence(getOriginalBegin().intValue()));
        
        Integer size = isEmpty(size = (Integer)pageContext.getAttribute(getAlias()+"_size")) ? new Integer(0) : size;
        return (((begin >= 0 && action.equalsIgnoreCase("prev")) || (begin <= size.intValue() && action.equalsIgnoreCase("next"))) || (action.equalsIgnoreCase("bwd") && prevInSequence(getOriginalBegin().intValue()) > 0) || ((begin <= getSize().intValue() && action.equalsIgnoreCase("fwd"))));
    }


    
    public int
    doStartTag(){
        JspWriter out = pageContext.getOut();
        int begin = getBegin();
        System.out.println("BEGIN>"+begin);
        System.out.println("sequence>"+getSequence());
        
        System.out.println(new java.util.Date()+">TOTAL ITEMS ON THE COLLECTION>"+getSize());

        boolean ajax = ((Boolean)pageContext.getAttribute(getAlias()+"_ajax")).booleanValue();
        
        
        
        try{
            System.out.println("visible>"+visible(begin));

            if (visible(begin)){
                out.println("<a "+(isEmpty(styleClass)? "" : "class=\""+getStyleClass()+"\"")+(isEmpty(id)? "" : "id=\""+getId()+"\"")+" href=\""+(ajax ? "#" : "?"+getAlias()+"_begin="+begin+getPageBlocks((long)begin))+"\""+ (ajax ? " onClick=\"new Ajax.Updater('paginate_"+getAlias()+"','"+pageContext.getAttribute(getAlias()+"_url")+"?"+getAlias()+"_begin="+begin+getPageBlocks((long)begin)+"',{asynchronous:true, evalScripts:true}); return false;\"" : "") +">"+ (isEmpty(getIcon())? getLabel() : "<img src="+getIcon()+" title=\""+getLabel()+"\" border=\"0\">") +"</a>");
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
        return SKIP_BODY;
    }
    
    public int
    doEndTag(){
        System.out.println("##################################");

        return EVAL_PAGE;
    }
       
    private String
    getPageBlocks(long index){
        System.out.println("prev------>"+prevInSequence((int)index));        
        return isEmpty(pageContext.getAttribute(getAlias()+"_page_blocks")) ? "" : "&"+getAlias()+"_page_begin="+getSequence().get(new Integer(prevInSequence((int)index)));
    }

    private boolean
    isEmpty(Object o){
        return o == null || (o instanceof String && o.toString().trim().equals("")) || (o instanceof Map && ((Map)o).isEmpty());
    }
}
