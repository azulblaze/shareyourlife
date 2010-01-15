package com.zhelazhela.util;


import org.apache.commons.lang.StringUtils;
public class AgentUtil {
    
    public String getSpecifiedTextWithEndTag(String originalString,String endTag){
    	int index = originalString.indexOf(endTag);
    	if(index>-1){
    		return originalString.substring(0,index);
    	}
    	return null;
    }

    public ParsedText getSpecifiedText(String originalString, String beginTag,
            String endTag) {

        ParsedText ps = new ParsedText();
        int beginIndex = 0;
        String temp = originalString;
        String specifiedText = null;
        String remainText = null;

        // get specified text according to begin tag and end tag
        specifiedText = StringUtils.substringBetween(temp, beginTag, endTag);
	if( specifiedText == null )
		return null;

        beginIndex = StringUtils.indexOf(temp, beginTag, 0);
        if (specifiedText != null) {
            beginIndex = beginIndex + specifiedText.length()
                    + beginTag.length() + endTag.length();
            specifiedText = specifiedText.trim();
        }

        temp = temp.substring(beginIndex, temp.length());
        remainText = temp;

        ps.setResultText(specifiedText);
        ps.setRemainText(remainText);

        return ps;
    }
    
    public ParsedText getSpecifiedText( String originalString, String tag ){
    	
    	ParsedText ps = new ParsedText();
    	
    	int iStart = StringUtils.indexOf(originalString, tag);
    	if( iStart == -1 )
    		return null;
    	
    	ps.setRemainText( StringUtils.substring(originalString, iStart+tag.length()) );
    	
    	return ps;
    }
    
    public ParsedText getSpecifiedText(String oString, String tag, String start, String end){
    	
    	ParsedText ps = this.getSpecifiedText(oString, tag);
    	if(ps != null ){
    		ps = this.getSpecifiedText(ps.getRemainText(), start, end);
    	}
    	
    	return ps;
    	
    }

    public static String platStr(String src){
    	if(src!=null){
    		src=src.replaceAll("[\\[|\\]|\"]", "");
    	}
    	return src;
    }

}
