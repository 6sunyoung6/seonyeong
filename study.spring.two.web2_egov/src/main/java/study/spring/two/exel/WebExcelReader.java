
package study.spring.two.exel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import study.spring.two.dto.WebDto;
import study.spring.two.dto.WebVo;

@Service
public class WebExcelReader {

	/**
	 * XLSX 파일을 분석하여 List<WebVO> 객체로 반환
	 * @param filePath
	 * @return
	 */
	
	public List<WebVo> xlsxToCustomerVoList(String filePath){
		
		// 반환할 객체를 생성
		List<WebVo> list = new ArrayList<WebVo>();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			fis = new FileInputStream(filePath);
			// HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
			workbook = new XSSFWorkbook(fis);
			
			// 탐색에 사용할 sheet, Row, Cell 객체
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;
			WebVo vo;
			
			// sheet  탐색 for문
			for(int sheetIndex =0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++){
				// 현재 Sheet 반환
				curSheet = workbook.getSheetAt(sheetIndex);
				// row 탐색 for문
				for(int rowIndex =0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++){
					// row 0은 헤더정보 이기 때문에 무시
					if(rowIndex != 0){
						// 현재 row 반환
						curRow = curSheet.getRow(rowIndex);
						vo = new WebVo();
						String value;
						
						//row의 첫번째 cell 값이 비어있지 않은 경우 만 cell 탐색
						if(!"".equals(curRow.getCell(0).getStringCellValue())){
							
							// cell 탐색 for문
							for(int cellIndex =0; cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++){
								curCell = curRow.getCell(cellIndex);
								
								if(true) {
									value = "";
									// cell 스타일이 다르더라도 String 으로 반환 받음
									switch (curCell.getCellType()) {
									case HSSFCell.CELL_TYPE_FORMULA:
										value = curCell.getCellFormula();
										break;
									case HSSFCell.CELL_TYPE_NUMERIC:
										value = curCell.getNumericCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_STRING:
										value = curCell.getStringCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_BLANK:
										value = curCell.getBooleanCellValue() + "";
										break;
									case HSSFCell.CELL_TYPE_ERROR:
										value = curCell.getErrorCellString() + "";
										break;
									default:
										value = new String();
										break;
									}
									
									// 현재 colum index에 따라서 vo에 입력
									switch (cellIndex) {
									case 0: // 번호
										vo.setNo(value);
										break;
										
									case 1: // 이름
										vo.setKor_name(value);
										break;
										
									case 2:	// 주민번호 앞자리
										vo.setJumin1(value);
										break;
										
									case 3:
										vo.setGender(value);
										break;
										
									case 4:
										vo.setTech(value);
										break;
										
									case 5:
										vo.setWork_state(value);
										break;
										
									case 6:
										vo.setWork_type(value);
										break;

									default:
										break;
									}
								}
							}
							//  cell 탐색 이후 vo 추가
							list.add(vo);
						}
					}
				}
			}		
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		////////////// 디비에 insert
		/*
		  
		 */
		
		return list;
	}
}




//public class WebExcelReader {
//
//	/**
//	 * XLSX 파일을 분석하여 List<WebVO> 객체로 반환
//	 * @param filePath
//	 * @return
//	 */
//
//	public List<WebDto> xlsxToCustomerVoList(String filePath){
//
//		// 반환할 객체를 생성
//		List<WebDto> list = new ArrayList<WebDto>();
//		
//		FileInputStream fis = null;
//		XSSFWorkbook workbook = null;
//		
//		try {
//			fis = new FileInputStream(filePath);
//			// HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
//			workbook = new XSSFWorkbook(fis);
//			
//			// 탐색에 사용할 sheet, Row, Cell 객체
//			XSSFSheet curSheet;
//			XSSFRow curRow;
//			XSSFCell curCell;
//			WebDto dto;
//			
//			// sheet  탐색 for문
//			for(int sheetIndex =0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++){
//				// 현재 Sheet 반환
//				curSheet = workbook.getSheetAt(sheetIndex);
//				// row 탐색 for문
//				for(int rowIndex =0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++){
//					// row 0은 헤더정보 이기 때문에 무시
//					if(rowIndex != 0){
//						// 현재 row 반환
//						curRow = curSheet.getRow(rowIndex);
//						dto = new WebDto();
//						String value;
//						
//						//row의 첫번째 cell 값이 비어있지 않은 경우 만 cell 탐색
//						if(!"".equals(curRow.getCell(0).getStringCellValue())){
//							
//							// cell 탐색 for문
//							for(int cellIndex =0; cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++){
//								curCell = curRow.getCell(cellIndex);
//								
//								if(true) {
//									value = "";
//									// cell 스타일이 다르더라도 String 으로 반환 받음
//									switch (curCell.getCellType()) {
//									case HSSFCell.CELL_TYPE_FORMULA:
//										value = curCell.getCellFormula();
//										break;
//									case HSSFCell.CELL_TYPE_NUMERIC:
//										value = curCell.getNumericCellValue() + "";
//										break;
//									case HSSFCell.CELL_TYPE_STRING:
//										value = curCell.getStringCellValue() + "";
//										break;
//									case HSSFCell.CELL_TYPE_BLANK:
//										value = curCell.getBooleanCellValue() + "";
//										break;
//									case HSSFCell.CELL_TYPE_ERROR:
//										value = curCell.getErrorCellString() + "";
//										break;
//									default:
//										value = new String();
//										break;
//									}
//									
//									// 현재 colum index에 따라서 vo에 입력
//									switch (cellIndex) {
//									case 0: // 번호
//										dto.setNo(value);
//										break;
//										
//									case 1: // 이름
//										dto.setKor_name(value);
//										break;
//										
//									case 2:	// 주민번호 앞자리
//										dto.setJumin1(value);
//										break;
//										
//									case 3:
//										dto.setGender(value);
//										break;
//										
//									case 4:
//										dto.setTech(value);
//										break;
//										
//									case 5:
//										dto.setWork_state(value);
//										break;
//										
//									case 6:
//										dto.setWork_type(value);
//										break;
//
//									default:
//										break;
//									}
//								}
//							}
//							//  cell 탐색 이후 vo 추가
//							list.add(dto);
//						}
//					}
//				}
//			}		
//		} catch (FileNotFoundException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} 
//		
//		return list;
//	}
//}
