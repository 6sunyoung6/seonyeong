package study.spring.two.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import study.spring.two.dao.WebDao;
import study.spring.two.dto.WebDto;

public class ExcelFileUpload {

	// 엑셀 파일 업로드
	public void excelFileUpload(MultipartHttpServletRequest mReq){
		String uploadPath = "d:/upload2/";
		File dir = new File(uploadPath);
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		Iterator<String> iter = mReq.getFileNames();
		while(iter.hasNext()){
			String uploadFileName = iter.next();
			MultipartFile mFile = mReq.getFile(uploadFileName);
			String fileName = mFile.getOriginalFilename();
			if(fileName != null && !fileName.equals("")){
				File file = null;
				try{
					file = new File(uploadFileName + fileName);
					mFile.transferTo(file);
					
					// Excel 파일 읽기
					List<WebDto> list = null;
					list = readExcelFile(file);
					
					// DB insert
					for(int i = 0; i <list.size(); i++){
//						WebDao.insertExcel(list.get(i));
					}
				}catch(Exception e){
					e.printStackTrace();
				} finally {
					if(file != null && file.exists()){
						file.delete();
					}
				}
			}
			
		}
	}
	
	private List<WebDto> readExcelFile(File file) throws IOException, BiffException{
		List<WebDto> list = new ArrayList<WebDto>();
		WebDto webDto = null;
		Workbook book = Workbook.getWorkbook(file);
		
		Sheet sheet = book.getSheet(0);
		int rowCount = sheet.getRows();
		
		for(int row =1; row < rowCount; row++){
			webDto = new WebDto();
			
			Cell c1 = sheet.getCell(0, row);
			Cell c2 = sheet.getCell(1, row);
			Cell c3 = sheet.getCell(2, row);
			Cell c4 = sheet.getCell(3, row);
			Cell c5 = sheet.getCell(4, row);
			Cell c6 = sheet.getCell(5, row);
			Cell c7 = sheet.getCell(6, row);
			
			int no = c1.getColumn();
			String kor_name = c2.getContents();
			String jumin1 = c3.getContents();
			String gender = c4.getContents();
			String tech = c5.getContents();
			String work_state = c6.getContents();
			String work_type = c7.getContents();
			
			webDto.setNo(no);
			webDto.setKor_name(kor_name);
			webDto.setJumin1(jumin1);
			webDto.setGender(gender);
			webDto.setTech(tech);
			webDto.setWork_state(work_state);
			webDto.setWork_type(work_type);
			
			list.add(webDto);
		}
		book.close();
		return list;
	}
}
