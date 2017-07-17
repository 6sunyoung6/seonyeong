
package study.spring.two.exel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import study.spring.two.dto.WebVo;

public class WebExcelWriter {

	public void xlsxWiter(List<WebVo> list){
		
		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 워크 시트 생성
		XSSFSheet sheet = workbook.createSheet();
		// 행생성
		XSSFRow row = sheet.createRow(0);
		// 셀 생성
		XSSFCell cell;
		
		// 헤더 정보 구성
		cell = row.createCell(0);
		cell.setCellValue("번호");
		
		cell = row.createCell(1);
		cell.setCellValue("이름");
		
		cell = row.createCell(2);
		cell.setCellValue("주민등록번호 앞자리");
		
		cell = row.createCell(3);
		cell.setCellValue("성별");
		
		cell = row.createCell(4);
		cell.setCellValue("기술등급");
		
		cell = row.createCell(5);
		cell.setCellValue("상태");
		
		cell = row.createCell(6);
		cell.setCellValue("근무");
		
		// 리스트의 size만큼 row를 생성
		WebVo vo;
		for(int rowIdx=0; rowIdx < list.size(); rowIdx++) {
			vo = list.get(rowIdx);
			
			// 행 생성
			row = sheet.createRow(rowIdx+1);
			
			cell = row.createCell(0);
			cell.setCellValue(vo.getNo());
			
			cell = row.createCell(1);
			cell.setCellValue(vo.getKor_name());
			
			cell = row.createCell(2);
			cell.setCellValue(vo.getJumin1());
			
			cell = row.createCell(3);
			cell.setCellValue(vo.getGender());
			
			cell = row.createCell(4);
			cell.setCellValue(vo.getTech());
			
			cell = row.createCell(5);
			cell.setCellValue(vo.getWork_state());
			
			cell = row.createCell(6);
			cell.setCellValue(vo.getWork_type());
			
		}
		
		// 입력된 내용 파일로 쓰기
		File file = new File("C:\\execel\\testWrite.xlsx");
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
