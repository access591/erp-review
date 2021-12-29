package com.access.erp.reportCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.access.erp.model.master.City;
import com.access.erp.model.master.Country;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.State;
import com.access.erp.repo.CityRepo;
import com.access.erp.repo.CountryRepo;
import com.access.erp.repo.EmployeeRepo;
import com.access.erp.repo.PartyMasterRepo;
import com.access.erp.repo.StateRepo;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class partyDetailReport {

	@Autowired
	PartyMasterRepo partyMasterRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	CityRepo cityRepo;
	@Autowired
	StateRepo stateRepo;
	@Autowired
	CountryRepo countryRepo;

	public void createPartyDetailReport(HttpServletResponse response, HttpServletRequest request) throws IOException {

		String partyCode = "EBS-0003";

		String cityCode = "A";
		String employeeCode = "EMP-01";

		PartyMaster partyMaster = partyMasterRepo.findById(partyCode).get();

		Country country = countryRepo.findById(partyMaster.getCountryCode()).get();

		City city = cityRepo.findById(partyMaster.getCityCode()).get();

		State state = stateRepo.findById(partyMaster.getStateCode()).get();

		System.out.println("Country : " + country.getCountryName());

		System.out.println("State : " + state.getStateName());

		System.out.println("City : " + city.getCityName());

		Employee employee = employeeRepo.findById(partyMaster.getRepCode()).get();

		String reportFileName = "partyDetail";

		String sourceFileName = request.getSession().getServletContext()
				.getRealPath("resources/" + reportFileName + ".jrxml");
		try {

			JasperCompileManager.compileReportToFile(sourceFileName);

			sourceFileName = request.getSession().getServletContext()
					.getRealPath("/resources/" + reportFileName + ".jasper");
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("partyCode", partyMaster.getPartyCode());
			
			if(partyMaster.getCustType().equals("S")) {
				parameters.put("custType", "Supplier");
			}
		
			parameters.put("partyName", partyMaster.getPartyName());
			
		
			parameters.put("partyAddr1", partyMaster.getPartyAddr1());	
			
			parameters.put("pthruCode", partyMaster.getPthruCode());

			parameters.put("repCode", partyMaster.getRepCode());
			parameters.put("partyMobNo", partyMaster.getPartyMobNo());
			parameters.put("partySstDate", partyMaster.getPartySstDate());
			parameters.put("repName",employee.getEmpName());

			parameters.put("cityCode", partyMaster.getCityCode());
			parameters.put("stateCode", partyMaster.getStateCode());
			parameters.put("countryCode", partyMaster.getCountryCode());
			parameters.put("partyFax", partyMaster.getPartyFax());
			parameters.put("partyEmail", partyMaster.getPartyEmail());

			parameters.put("city.cityName", city.getCityName());
			parameters.put("country.countryName", country.getCountryName());
			parameters.put("state.stateName", state.getStateName());

			parameters.put("gstNo", partyMaster.getGstNo());
			parameters.put("pinCode", partyMaster.getPinCode());

			parameters.put("taxpayerTradeName", partyMaster.getTaxpayerTradeName());

			parameters.put("taxpayerLegalName", partyMaster.getTaxpayerLegalName());
			parameters.put("fillingDate", partyMaster.getFillingDate());
			
			//{partyTypCode
			parameters.put("partyTypCode", "-");
			parameters.put("partyMobNo","-");

			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

			if (jasperPrint != null) {
				byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				response.reset();
				response.setContentType("application/pdf");
				response.setHeader("Cache-Control", "no-store");
				response.setHeader("Cache-Control", "private");
				response.setHeader("Pragma", "no-store");
				response.setContentLength(pdfReport.length);

				response.getOutputStream().write(pdfReport);
				response.getOutputStream().flush();
				response.getOutputStream().close();

			}
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	}

