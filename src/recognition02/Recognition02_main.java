package recognition02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

public class Recognition02_main {

	public static void main(String[] args) 
	{
		VisualRecognition service = new VisualRecognition("2018-03-19");
		IamOptions iamOptions = new IamOptions.Builder()
		  .apiKey("APIKEY")
		  .build();
		service.setIamCredentials(iamOptions);

		ClassifyOptions classifyOptions = null;
		try {
			classifyOptions = new ClassifyOptions.Builder()
					  .imagesFile(new File("img/Apple.jpg"))
					  .imagesFilename("Apple.jpg")
					  .threshold((float) 0.6)
					  .owners(Arrays.asList("IBM"))
					  .build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ClassifiedImages result = service.classify(classifyOptions).execute();
	    System.out.println(result);


	}

}