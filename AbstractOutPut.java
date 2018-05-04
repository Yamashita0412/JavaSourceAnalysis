package day1115;

import java.io.IOException;
public abstract class AbstractOutPut{
    abstract void setFileOut() throws IOException;
    abstract void outPut();
    abstract void close();
    
    public void work() throws IOException{
	setFileOut();
	outPut();
	close();
    }
}