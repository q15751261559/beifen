package southWind.connent;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * @ClassName TextThread
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class TxtThread implements Runnable {
    private JLabel txtLabel;

    public void setTxtLabel(JLabel txtLabel) {
        this.txtLabel = txtLabel;
    }

    @Override
    public void run() {
        try {
            while (true){
                InputStream in;
                BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("C:\\java\\格言.txt")));
                String str="";
                while((str=br.readLine())!=null){
                    txtLabel.setText(str);
                    Thread.sleep(1000);
                }
            }
        }catch (Exception e){

        }

    }
}
