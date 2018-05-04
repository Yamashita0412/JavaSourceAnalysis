package day1115;
import java.io.*;

public class Input{
    private String prompt;
    private final String ERROR_INPUT_INTEGER="入力値は実数ではありません。";
    private final String ERROR_INPUT_DOUBLE="入力値は実数ではありません。";
    private final String ERROR_INPUT="エラー：入力に誤りがあります。";
    private void setPrompt(String prompt){
	this.prompt=prompt;
    }
    
    private String input() throws IOException{
	String line;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	line = reader.readLine();
	return line;
    }
    public int inputInteger(String prompt){
	this.setPrompt(prompt);
	System.out.println(this.prompt);
	try{
	    String value =this.input();
	    int n=Integer.parseInt(value);
	    return n;
	}catch(Exception s){
	    System.out.println(ERROR_INPUT_INTEGER);
	    return this.inputInteger(prompt);
	}
    }
    public double inputDouble(String prompt){
	this.setPrompt(prompt);
	System.out.println(this.prompt);
	try{
	    String value =this.input();
	    double n=Double.parseDouble(value);
	    return n;
	}catch(Exception s){
	    System.out.println(ERROR_INPUT_DOUBLE);
	    return this.inputDouble(prompt);
	}
    }
    public String inputString(String prompt){
	this.setPrompt(prompt);
	System.out.println(this.prompt);
	try{
	    String n = this.input();
	    return n;
	}catch(Exception s){
	    System.out.println(ERROR_INPUT);
	    return this.inputString(prompt);
	}
    }
    
}