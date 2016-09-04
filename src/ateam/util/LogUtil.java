package ateam.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ateam.config.AppConfig;
import ateam.dao.BihinDAO;
import ateam.dao.UserDAO;
import ateam.model.Bihin;
import ateam.model.User;

public class LogUtil {
	synchronized public static void createLogDate(String bihinID, String userID) {
		if (bihinID == null || bihinID.isEmpty() || userID == null || userID.isEmpty()) {
			return;
		}
		try {
			String basePath = AppConfig.getInstance().getBasePath();
			File file = new File(basePath + "/WEB-INF/log/log.txt");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			UserDAO userdao = UserDAO.getInstance();
			User user = userdao.getUser(userID);
			BihinDAO bihindao = BihinDAO.getInstance();
			Bihin bihin = bihindao.getBihin(bihinID);
			String status = null;
			if (bihin.getStatus() == Bihin.AVAILABLE) {
				status = "返却";
				FileWriter filewriter = new FileWriter(file, true);
				filewriter.write("操作日時:" + sdf.format(date) + "　操作:" + status + "　ユーザID:" + userID + "　ユーザ名:"
						+ user.getUserName() + "　備品ID:" + bihinID + "　備品名:" + bihin.getBihinName() + "\r\n");
				filewriter.close();
			} else {
				status = "貸出";
				FileWriter filewriter = new FileWriter(file, true);
				filewriter.write("操作日時:" + sdf.format(date) + "　操作:" + status + "　ユーザID:" + userID + "　ユーザ名:"
						+ user.getUserName() + "　備品ID:" + bihinID + "　備品名:" + bihin.getBihinName() + "　返却予定日:"
						+ bihin.getReturnDay() + "\r\n");
				filewriter.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
