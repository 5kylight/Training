import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

/**
 * Created by tom on 23.12.14.
 */
public class SerializePojoObject {
    public void serialize() {
      Field[] fields =  PojoExample.class.getDeclaredFields();
        ObjectOutputStream stream = null;

        try {
            stream = new ObjectOutputStream(new FileOutputStream("PojoSerialization.txt"));
            stream.writeObject(new PojoExample());
//            for(Field field : fields){
//                stream.write();
//            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(stream != null ) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
