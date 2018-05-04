package day1115;

import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Arrays;

public class Search{
    private Queue<File> queue=new ArrayDeque<File>();
    private Queue<File> queueJavaFile=new ArrayDeque<File>();
    File dir; 

    /**
     *<PRE>
     * メソッド名に応じた探索を行い出力をする
     * つぎの2つのメソッドを持つ。
     *</PRE>
     *<OL>
     * <LI>void breadthFirstSearch()
     * <LI>Queue<File> getQueueJavaFile()
     *</OL>
     *@author Yamashita Kyonosuke
     *@version 1.0
     */
    Search(File dir) throws IOException{
	this.dir = dir;
	this.queue.add(dir);
    }
    
    Queue<File> getQueueJavaFile(){
	return this.queueJavaFile;
    }
    /**
     *引数とされた名前のディレクトリ以下の.javaファイルを幅優先探索する.
     *@param none
     *@return none
     */
    void breadthFirstSearch () throws IOException{
	File[] dirFilelist = queue.poll().listFiles();
	Iterator itr = Arrays.asList(dirFilelist).iterator();
	
	// D/~.java判定
	while(itr.hasNext()){
	    File file = (File) itr.next();
	    if(file.isDirectory()){
		queue.add(file);
	    }
	    else if (file.getName().matches(".*.java")){
		queueJavaFile.add(file);
	    }
	}
	// queueにディレクトリが残っていれば再帰
	if(queue.peek() != null)
	    breadthFirstSearch();
    }
}