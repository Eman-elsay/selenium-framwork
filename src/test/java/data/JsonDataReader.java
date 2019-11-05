package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonIOException;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import gherkin.deps.com.google.gson.JsonSyntaxException;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

/*public  class JsonDataReader {
	
	String firstname, lastname,emil,password ;
	

	public void jsonreader() throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{
		String filepath= System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
	File filesrc= new File(filepath);
	JsonParser parser= new JsonParser();
	JsonArray jarray= (JsonArray) parser.parse(new FileReader(filesrc));
	
	
	for(Object jasonobj: jarray)
	{
		JsonObject person = (JsonObject) jasonobj;
		firstname =((JsonArray) jasonobj).g
     	lastname =((JsonArray) jasonobj).get("lastname");
		emil =((JsonArray) jasonobj).get("emil");firstname =((JsonArray) jasonobj).get("firstname");
		password =((JsonArray) jasonobj).get("password");
		

}
*/