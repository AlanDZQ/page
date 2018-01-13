import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    static public void main(String[] args) throws IOException {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        String currentTime = dateFormat.format(date);
        File file = new File("message.txt");
        FileWriter fileWritter = new FileWriter(file.getName(), true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(currentTime);
        System.out.print(file.exists()+currentTime);
        bufferWritter.close();

    }
}
