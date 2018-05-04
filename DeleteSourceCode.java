package day1115;

public class DeleteSourceCode{
    private String code;
    /**
     *<PRE>
     * codeにおける該当箇所を取り除くクラス
     * つぎの5つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>String getCode()
     * <LI>String deleteLastWord(String Name)
     * <LI>void deleteStringComment()
     * <LI>void deleteLineComment()
     * <LI>void deleteBlockComment()
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    DeleteSourceCode(String code){
	this.code = code;
    }
    
    /**
     * codeのゲッター
     * @param none
     * @return String
     */
    String getCode(){
	return this.code;
    }
    /**
     * 引数の文字の最終文字を判定し、削除を行うメソッド
     * @param String
     * @return String
     */
    String deleteLastWord(String Name){
    	if(Name.endsWith("{") || Name.endsWith(";"))
	    return Name.substring(0,Name.length()-1)+" ";
	else
	    return Name.substring(0,Name.length())+" ";
    }
    
    /**
     * " " の間の文字に対して、全て削除を行うメソッド
     * @param none
     * @return none
     */
    void deleteStringComment(){
	code = code.replaceAll("\".*?[^\"]/*\"","");
    }
  
    /**
     * //以下の文に対して、全て削除を行うメソッド
     * @param none
     * @return none
     */
    void deleteLineComment(){
	code = code.replaceAll("//.*"," ");
    }
    /**
     * ブロックコメントの間の文字に対して、全て削除を行うメソッド
     * @param none
     * @return none
     */
    void deleteBlockComment(){
	code = code.replaceAll("/\\*([^/]|[^*]/)*\\*/"," ");
    }
}