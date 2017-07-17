package study.spring.two.dto;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractJExcelView;

import jxl.write.*;
import jxl.write.biff.RowsExceededException;

public class ExcelDownloadView extends AbstractJExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			WritableWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<WebDto> list = (List<WebDto>) model.get("list");
		
		String fileName = "excel.xls";
		
		response.setHeader("Content-Disposition", "attachement: filename=\"" 
		+ java.net.URLEncoder.encode(fileName, "UTF-8") + "\"|charset-8\"");
	}
	
	private void makeExcelFile(WritableWorkbook workbook, List<WebDto> list)
		throws RowsExceededException, WriteException{
		
		// 시트 생성(시트명, 인덱스)
		WritableSheet ws = workbook.createSheet("게시물 목록", 0);
		
		setExcelTitle(ws);
		setExcelContent(ws, list);
		
	}
	
	
	// 7 쪽
	private void setExcelContent(WritableSheet ws, List<WebDto> list)
	throws RowsExceededException, WriteException{
		for(int i = 1; i < list.size()+1; i++){
			ws.addCell((new Label(0, i, list.get(i-1).getNo()+ "")));
			ws.addCell((new Label(1, i, list.get(i-1).getKor_name()+ "")));
			ws.addCell((new Label(2, i, list.get(i-1).getJumin1()+ "")));
			ws.addCell((new Label(3, i, list.get(i-1).getGender()+ "")));
			ws.addCell((new Label(4, i, list.get(i-1).getTech()+ "")));
			ws.addCell((new Label(5, i, list.get(i-1).getWork_state()+ "")));
			ws.addCell((new Label(6, i, list.get(i-1).getWork_type()+ "")));
		}
	}

	private void setExcelTitle(WritableSheet ws) throws RowsExceededException,
		WriteException{
		ws.addCell((new Label(0, 0, "번호")));
		ws.addCell((new Label(1, 0, "이름")));
		ws.addCell((new Label(2, 0, "주민번호 앞자리")));
		ws.addCell((new Label(3, 0, "성별")));
		ws.addCell((new Label(4, 0, "기술등급")));
		ws.addCell((new Label(5, 0, "상태")));
		ws.addCell((new Label(6, 0, "근무")));
	}
	
}
