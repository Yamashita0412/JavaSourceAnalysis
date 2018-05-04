/**
 *  メイン・クラス
 *  入力されたディレクトリ以下を幅優先探索、
 *  .javaファイルの各種データをCSVファイルに出力
 *  @author Yamashita Kyonosuke 
 *  @version 1.0 
 *  
 */
package day1115;

import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args){ 
	Input in = new Input();
	String dirName = in.inputString("探索したいディレクトリ名を入力:");
	String fileName = in.inputString("出力ファイル名を入力:");
	
	try{
	    Search se = new Search(new File(dirName));
	    se.breadthFirstSearch();
	    AbstractOutPut out = new OutPutCSV(fileName,se.getQueueJavaFile());
	    out.work();
	}catch(IOException e){
	    System.out.println("エラー内容:"+e);
	}catch(NullPointerException e){
	    System.out.println("エラー内容:"+e);
	}
	
    }
}
