package edu.neu.hibernate;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Component;

import edu.neu.bean.EncounterBean;
import edu.neu.bean.PatientBean;

@Component
public class EmailNotification {

	//public static String mailTo = "punj.a@husky.neu.edu.com";
	public static String mailFrom = "abhinavpunj@gmailcom";
	
	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	String host = "localhost";

	public boolean notifyByMail(PatientBean patient) 
	{
		EncounterBean latest = patient.getEncounterHistory().get(0);
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.user", "");
		properties.setProperty("mail.smtp.password", "");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.store.protocol", "pop3");
		properties.put("mail.transport.protocol", "smtp");
		final String username = "abhinavpunj@gmail.com";
		final String password = "DADDY2101";
		try {
			
			Session session = Session.getDefaultInstance(properties);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(patient.getEmail()));
			message.setSubject("Your recent to visit to the Hospital");
			message.setContent("Hi " + patient.getName() + ",<br>Following is your last checkup details:<br>&nbsp;&nbsp;" 
			+ "<strong>Vital Signs</strong><br/>"
			+ "Temperature: " + latest.getVitalSign().getTemp() + " F<br>"
			+ "Pulse: " + latest.getVitalSign().getPulse() + " bpm<br>"
			+ "Blood Pressure: " + latest.getVitalSign().getBloodPressure() + " mm HG<br>"
			+ "Glucose Level: " + latest.getVitalSign().getGlucose() + " mg/dL<br>"
			+ "Respiratory Rate: " + latest.getVitalSign().getRespRate() + " breaths/min<br>"
			+ "Weight: " + latest.getVitalSign().getWeight() + " lbs<br>"
			+ "Height: " + latest.getVitalSign().getHeight() + " ft<br>"
			+ "BMI: " + latest.getVitalSign().getBmi() + " mg/dL<br>",
					"text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(null, username, password);
			message.saveChanges();
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Message Send successfully");
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
		return true;
	}
}
