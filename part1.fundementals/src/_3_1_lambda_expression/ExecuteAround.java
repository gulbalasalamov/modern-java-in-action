package _3_1_lambda_expression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    public static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();

    public static void main(String[] args) throws IOException {
        //Method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);
        System.out.println("---");

        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);
        System.out.println("---");

        String twoLines = processFile((BufferedReader br ) -> br.readLine() + br.readLine());
        System.out.println(twoLines);
    }

    public static String processFileLimited() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))){
            return br.readLine();
        }
    }

    public static String processFile(BufferedReadProcessor brp) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))){
            return brp.process(br);
        }
    }
}

interface BufferedReadProcessor {
    String process (BufferedReader br) throws IOException;
}
