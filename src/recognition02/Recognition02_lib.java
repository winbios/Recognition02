package recognition02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

public class Recognition02_lib 
{
	VisualRecognition service;
	IamOptions iamOptions;
	
	ClassifiedImages result;
	ClassifyOptions classifyOptions;
	
	public Recognition02_lib()
	{
		this.service = new VisualRecognition("2018-03-19");
		this.iamOptions = new IamOptions.Builder()
				 .apiKey("0VONSAnSGlgkIpaerDczEZE3DTnGGryg9XHCQ8BLtj-l")
				  .build();
				service.setIamCredentials(iamOptions);
				
				
	}

	public void getResult(String filename) 
	{
		classifyOptions = null;
		try {
			classifyOptions = new ClassifyOptions.Builder()
					  .imagesFile(new File(filename))
					  .threshold((float) 0.6)
					  .owners(Arrays.asList("IBM"))
					  .build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result = service.classify(classifyOptions).execute();
	    System.out.println(result);
		
	}

}
