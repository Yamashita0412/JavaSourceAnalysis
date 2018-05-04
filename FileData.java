package day1115;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.Arrays;

public class FileData {
    private File file;
    private int lineNumber=0;
    private String sourceCode="";
    private String className="";
    private String packageName="";
    private String importName="";
    DeleteSourceCode de;

    /**
     *<PRE>
     * 引数に応じたファイルデータの各種情報取得と出力
     * つぎの9つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>int getLineNumber()
     * <LI>String getClassName()
     * <LI>String getPackageName()
     * <LI>String getImportName()
     * <LI>void setFileData()
     * <LI>void setLineNumber()
     * <LI>void connectLine()
     * <LI>void setSourceCode()
     * <LI>void setNames()
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    FileData(File file){
	this.file = file;
    }

    /**
     * LineNumberを返すメソッド
     * @param none
     * @return int
     */
    int getLineNumber(){
	return this.lineNumber;
    }
    /**
     * classNameを返すメソッド
     * @param none
     * @return String
     */
    String getClassName(){
	return this.className;
    }
    /**
     * packageNameを返すメソッド
     * @param none
     * @return String
     */
    String getPackageName(){
	return this.packageName;
    }
    /**
     * importNameを返すメソッド
     * @param none
     * @return String
     */
    String getImportName(){
	return this.importName;
    }
    /**
     * fileにおける各種データを設定するメソッド
     * @param none
     * @return none
     * @exception IOException
     */
    void setFileData() throws IOException{
	setLineNumber();
	setSourceCode();
	setNames();
    }
    /**
     * lineNumberを取得するメソッド
     * @param none
     * @return none
     * @exception IOException
     */
    void setLineNumber() throws IOException{
	LineNumberReader fin = new LineNumberReader(new FileReader(file));
	String aLine;
	while(null != (aLine=fin.readLine())){
	    connectLine(aLine);
	}
	this.lineNumber=fin.getLineNumber();
    }
    /**
     * Javaのソースコードを１つのStringにまとめる
     * @param String
     * @return none
     */
    void connectLine(String aLine){
	this.de = new DeleteSourceCode(aLine);
        de.deleteBlockComment();
	de.deleteStringComment();
	de.deleteLineComment();
	this.sourceCode += de.getCode() + " ";
    }
    /**
     * SourceCodeを取得するメソッド
     * @param none
     * @return none
     */
    void setSourceCode(){
	this.de = new DeleteSourceCode(this.sourceCode);
	de.deleteBlockComment();
	this.sourceCode = de.getCode() + " ";
    }
    /**
     * 各種Nameを取得するメソッド
     * @param none
     * @return none
     */
    void setNames(){
	String[] strSplit = this.sourceCode.split("[\\s]+",0);	
       	Iterator itr = Arrays.asList(strSplit).iterator();
	while(itr.hasNext()){
	    String str = (String)itr.next();
	    if(str.equals("class"))
		this.className += de.deleteLastWord((String)itr.next());
	    
	    else if(str.equals("package"))
		this.packageName = de.deleteLastWord((String)itr.next());
	    
	    else if(str.equals("import"))
		this.importName += de.deleteLastWord((String)itr.next()); 
	}
    }
}