package day1115;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Arrays;


public class OutPutCSV extends AbstractOutPut {
    final String SEP = System.getProperty("line.separator");
    private String setOut="絶対パス,ファイル名,行数,クラス名,パッケージ宣言,importクラス名"+SEP;
    private Queue<File> queueJavaFile;
    PrintWriter pw;
    FileData fileData;

    /**
     *<PRE>
     * 引数に応じたcsvファイルを作成
     * ファイルにおける各種データについて出力
     * つぎの3つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>void setFileOut()
     * <LI>void outPut()
     * <LI>void close()
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    OutPutCSV(String name,Queue<File> queueJavaFile) throws IOException{
	this.pw = new PrintWriter(new BufferedWriter(new FileWriter(name+".csv")));
	this.queueJavaFile = queueJavaFile;
    }
    
    /**
     * 引数とされたファイルの出力準備をする
     * @param File
     * @return none
     */
    void setFileOut () throws IOException{
	
	Iterator itr = this.queueJavaFile.iterator();
	while(itr.hasNext()){
	    File file =(File) itr.next();
	    this.fileData = new FileData(file);
	    fileData.setFileData();
	    
	    this.setOut += file.getAbsolutePath()+",";
	    this.setOut += file.getName()+",";
	    this.setOut += fileData.getLineNumber()+",";
	    this.setOut += fileData.getClassName()+",";
	    this.setOut += fileData.getPackageName()+",";
	    this.setOut += fileData.getImportName()+",";
	    this.setOut += this.SEP;
	}
    }

    /**
     * CSVファイルに出力する
     * @param none
     * @return none
     */
    void outPut(){
	pw.println(this.setOut);
    }
    
    /**
     * CSVファイルに書込を終了する
     * @param none
     * @return none
     */
    void close(){
	pw.close();
    }

}