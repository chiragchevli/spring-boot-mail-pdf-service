package com.mailsender.subscriber;

import org.apache.logging.log4j.LogManager;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mailsender.bean.UserData;
import com.mailsender.service.GeneratePdfService;
import com.mailsender.service.SendMailService;;

@Component
public class Subscriber {

	@Autowired
	GeneratePdfService generatePdfService;
	@Autowired
	SendMailService sendMailService;

	public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Subscriber.class);

	@RabbitListener(queues = "${pdf.rabbitmq.queue}")
	public void receivedMessage(UserData data) throws Exception {

		logger.info("Received Message: " + data.toString());

		if (generatePdfService.generate(data)) {
			logger.info("Received Message: + PDF Generate ");

			if (sendMailService.sendMailWithAttachedPDF(data)) {
				logger.info("Received Message: + PDF Generate + Mail Sent ");
			}
		}
	}
}
