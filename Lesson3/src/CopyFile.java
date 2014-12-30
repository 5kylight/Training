import java.io.*;

/**
 * Created by tom on 30.12.14.
 */
public class CopyFile {
    public void copyFile(String Path){
        FileOutputStream outputStream = null;

        try (FileInputStream stream = new FileInputStream(new File(Path))) {
            outputStream = new FileOutputStream(new File(Path+"copy"));
            byte[] buffer = new byte[1024];
            int length;
            while((length = stream.read(buffer))> 0){
                outputStream.write(buffer,0,length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if( outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

    }
}
