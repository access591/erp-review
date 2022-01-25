package com.access.erp.controller.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.access.erp.model.IssueSlip;
import com.access.erp.model.master.ItemReturnNote;
import com.access.erp.service.IssueSlipService;
import com.access.erp.service.ItemReturnNoteService;
import com.access.erp.singleton.GlobalParameter;

@Controller
@RequestMapping("/itemreturnnote/")
public class ItemReturnNoteController {

	
	@Autowired ItemReturnNoteService itemreturnNoteservice;
	@Autowired IssueSlipService issueSlipservice;
	@Autowired GlobalParameter globalparameter;
	
	
	@GetMapping("/")
	public String itemReturnNote(Model model) {
		
		List<IssueSlip>ListIssueslip = issueSlipservice.getAllIssueSlip();
		model.addAttribute("listIssueSlip", ListIssueslip);
		
		model.addAttribute("ItemReturnNote",new ItemReturnNote() );
		
		return"layouts/Master/ItemReturnNote";
	}
	
	@PostMapping("/")
	public String additemreturnNote(@ModelAttribute("ItemReturnNote") ItemReturnNote itemReturnNote ) {
		System.out.println("testing " + itemReturnNote.getRecptDate() );
		
		itemReturnNote.setMyUser(globalparameter.getMyUser()) ;
		itemReturnNote.setCompany(globalparameter.getCompany());
		itemReturnNote.setFyyear(globalparameter.getFyYear());

		System.out.println("testing :" + itemReturnNote.getListItemReturnNoteDetail().get(0).getRemarks());

		
		itemreturnNoteservice.addItemReturnNote(itemReturnNote) ;
		
		
		return"redirect:/itemreturnnote/";
	}
	
	
	@GetMapping("/list")
	public String itemReturnNoteList(Model model) {
		
		System.out.println("item return list controllerr");
		
		List<ItemReturnNote> itemReturnNoteList= itemreturnNoteservice.getAllItemReturnNote();
		
		System.out.println("itemReturnNoteList size : " +itemReturnNoteList.size());
		if (itemReturnNoteList != null) {
			model.addAttribute("itemReturnNoteList", itemReturnNoteList);
		}
		return "layouts/listview/listofItemReturnNote";
	}
	
	@GetMapping("/edit/{id}")
	public String editItemReturnNote(@PathVariable("id") String ReceiptNo,Model model) {
		
		System.out.println("edit controller ");
		ItemReturnNote itemReturnNote = itemreturnNoteservice.editItemReturnNote(ReceiptNo).get(); 
		
		System.out.println("parent record : " + itemReturnNote.getReceiptNo());
		//System.out.println("child record : " + itemReturnNote.getListItemReturnNoteDetail().size());
         model.addAttribute("itemReturnNote", itemReturnNote);
		
		
		return"layouts/editview/editItemReturnNote";
	}
	
	
	@GetMapping("/delete/{id")
	public String deleteItemReturnNote(@PathVariable("id") String ReceiptNo,Model model) {
		
		itemreturnNoteservice.deleteItemReturnNote(ReceiptNo);
		return "redirect:/itemreturnnote/list";
	}
	
	
}
