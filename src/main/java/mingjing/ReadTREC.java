package mingjing;

import org.terrier.indexing.*;
import org.terrier.utility.TagSet;
import java.util.Arrays;

public class ReadTREC
{
	public static void main(String[] args)
	{
		String[] listOfFiles = new String[]{
			 "/path/to/one/TREC/G00.gz"
		};
		Collection c = new TRECCollection(Arrays.asList(listOfFiles), TagSet.TREC_DOC_TAGS, null, null);
		while(c.nextDocument())
		{
			Document d = c.getDocument();
			StringBuilder docB = new StringBuilder();
			while(! d.endOfDocument()) 
			{
				String t = d.getNextTerm();
				if (t == null) continue;
				docB.append(t);
				docB.append(' ');
			}
			String doc = docB.toString();
			//call your shingling code here.
			System.out.println(d.getProperty("docno") + " => " + doc);
		}

	}


}
