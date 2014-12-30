/**
 * Created by tom on 30.12.14.
 */
public class XMLSerialization {
    public static void main(String[] Args){
        PersonLang person = new PersonLang("1","2","3","4","5","6","7");
        PojoSerializationXML serializationXML = new PojoSerializationXML();
        //serializationXML.serialize(person);
        PersonLang newPerson = (PersonLang) serializationXML.deserialize();
        System.out.print(newPerson.getFirstname());
        person.setAccountStatus("12");
    }
}
