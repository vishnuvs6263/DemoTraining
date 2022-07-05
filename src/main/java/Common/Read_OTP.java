package Common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class Read_OTP {
	public static String searchText=null ;
	
	public static String OutlookMailReader(String username, String password, String mailFolderName,String emailSubjectContent, String emailContent, int lengthOfOTP) {

        
		//mailFolderName(Eg- "INBOX"), emailSubjectContent(Eg- Mail for OTP),emailContent(Eg- OTP is 111111), OTP length(Eg- 6)
		            String hostName = "smtp.gmail.com";//change it according to your mail

		            int messageCount;

		            int unreadMsgCount;

		            String emailSubject;

		            Message emailMessage;
		            

		            Properties sysProps = System.getProperties();

		            sysProps.setProperty("mail.store.protocol", "imaps");

		            try {

		                Session session = Session.getInstance(sysProps, null);

		                Store store = session.getStore();

		                store.connect(hostName, username, password);

		                Folder emailBox = store.getFolder(mailFolderName);

		                emailBox.open(Folder.READ_WRITE);

		                messageCount = emailBox.getMessageCount();

		                //System.out.println("Total Message Count: " + messageCount);

		                unreadMsgCount = emailBox.getUnreadMessageCount();

		               // System.out.println("Unread Emails count:" + unreadMsgCount);

		                for(int i=messageCount; i>(messageCount-unreadMsgCount); i--)

		                {

		                    emailMessage = emailBox.getMessage(i);

		                    emailSubject = emailMessage.getSubject();
		                    System.out.println(emailSubject);
		                    System.out.println(emailSubjectContent);
		                    if(emailSubject.contains(emailSubjectContent))

		                    {

		                        //System.out.println("OTP mail found");

		                        String line;

		                        StringBuffer buffer = new StringBuffer();

		                        BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));

		                        while ((line = reader.readLine()) != null) {

		                            buffer.append(line);

		                        }

		                        String messageContent=emailContent;
		                       

		                        String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));

		                        searchText = result.substring(messageContent.length(), messageContent.length()+lengthOfOTP);

		                        System.out.println("Text found : "+ searchText);

		                        emailMessage.setFlag(Flags.Flag.DELETED, true);

		                        break;

		                    }

		                    emailMessage.setFlag(Flags.Flag.DELETED, true);

		                }

		                emailBox.close(true);

		                store.close();


		            } catch (Exception mex) {

		                mex.printStackTrace();

		                System.out.println("OTP Not found ");

		            }

		            return searchText;

		        }

}