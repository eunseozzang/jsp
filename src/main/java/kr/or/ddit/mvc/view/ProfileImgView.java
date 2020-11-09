package kr.or.ddit.mvc.view;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class ProfileImgView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		FileInputStream fis = new FileInputStream((String) model.get("filepath"));
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		// 읽을것이 없을 때 까지
		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}

		fis.close();
		// 응답이 안간게 있으면 마지막으로 보내기
		sos.flush();
		sos.close();
		
	}
}
