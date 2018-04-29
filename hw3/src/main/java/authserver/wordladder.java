package authserver;
import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class wordladder {
    public static String alphabet ="abcdefghijklmnopqrstuvwxyz";  //in order to find neighbor words
    String filename=null;
    String word1=null;
    String word2=null;
    public Set<String>dict=new HashSet<String>();
    public wordladder(String filename,String word1,String word2)
    {
        this.filename=filename;
        this.word1=word1.toLowerCase();
        this.word2=word2.toLowerCase();
    }
    public  void set_prop(String filename,String word1,String word2)
    {
        this.filename=filename;
        this.word1=word1.toLowerCase();
        this.word2=word2.toLowerCase();
    }
    public boolean isIsinput_valid(){
        if(dict.contains(word1)&&dict.contains(word2)){return true;}
        else {return false;}
    }
    public boolean read_dict(){
        File dictionary=new File(filename);
        try {
            FileInputStream fis = new FileInputStream(dictionary);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String word=null;
            while((word=br.readLine())!=null){
                dict.add(word);
            }
            br.close();
            return true;
        }
        catch (FileNotFoundException e1)
        {
            return false;
        }
        catch (IOException e2)
        {
            System.out.println("file not found");
            return false;
        }
    }
    public Stack<String>wl_stack(){
        Set<String>used_words=new HashSet<String>();        // store used words
        Queue<Stack<String>>wlstack_queue = new LinkedBlockingQueue<Stack<String>>();  //store temp wl stack
        Stack<String>single_wl = new Stack<String>();    //stack uesd to store wl
        Stack<String>temp1 = new Stack<String>();
        Stack<String>temp2 = new Stack<String>();


        single_wl.push(word2);
        used_words.add(word2);
        wlstack_queue.add(single_wl);        //firstly make a wl only contains word2, add it to the queue
        while(!wlstack_queue.isEmpty())
        {
            temp1 = (Stack<String>)wlstack_queue.peek().clone();    //when generate one-character away word, keep top word not changing
            wlstack_queue.poll();
            String wl_topword=temp1.peek();
            int wordsize=wl_topword.length();
            for(int i=0;i<wordsize;++i)
            {
                for(int j=0;j<alphabet.length();++j)
                {
                    temp2 = (Stack<String>)temp1.clone();
                    String newword=null;
                    if(i== wordsize-1)
                    {
                        newword=wl_topword.substring(0,i)+alphabet.substring(j,j+1);
                    }
                    else{
                        newword=wl_topword.substring(0,i)+alphabet.substring(j,j+1)+wl_topword.substring(i+1);
                    }
                    if(dict.contains(newword)){
                        if(newword.equals(word1)){
                            temp2.push(word1);
                            return temp2;
                        }
                        else if(!used_words.contains(newword)){
                            used_words.add(newword);
                            temp2.push(newword);
                            wlstack_queue.add(temp2);
                        }

                    }
                }
            }
        }
        Stack<String>no_wl=new Stack<String>();
        no_wl.push("No word ladder.");
        return no_wl;
    }
    public String print_wl(Stack<String>wl){
        String temp;
        String output="";
        int size=wl.size();
        for(int i=0;i<size;++i){
            temp=wl.peek();
            output=temp+" "+output;
            wl.pop();
        }
        System.out.println("word ladder from "+word1+" to "+word2+" is :");
        System.out.println(output);
        return output;
    }
}