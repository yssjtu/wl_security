package authserver;

import java.util.*;

public class output {
    public static void main(String []args){
        Scanner s=new Scanner(System.in);
        while(true)
        {
            System.out.println("input filename: ");
            String input_filename=s.nextLine();
            System.out.println("input word1: ");
            String input_word1=s.nextLine();
            System.out.println("input word2: (exit! to exit)");
            String input_word2=s.nextLine();
            if(input_word2.equals("exit!")){return;}
            if(input_word1.length()!=input_word2.length()){
                System.out.println("invalid input word ");
                continue;

            }
            wordladder test_wl = new wordladder(input_filename, input_word1, input_word2);
            if (test_wl.read_dict()) {
                if (!test_wl.isIsinput_valid()) {
                    System.out.println("invalid word");
                    continue;
                }
                Stack<String> wl = test_wl.wl_stack();
                test_wl.print_wl(wl);
            } else {
                System.out.println("can't read dict.");
            }
        }
    }
}

