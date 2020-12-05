package clinic.Controller;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clinic.Account;
import clinic.Service.AccountService;


@RestController
@RequestMapping(path ="/accounts", produces = "application/json")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping(value="/account/{id}")
	public ResponseEntity<?> searchAccountById(@PathVariable("id") int idacc){
		Account d = accountService.searchAccountByID(idacc);
		if(d != null) {
			return new ResponseEntity<>(d,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("khong tim duoc!", HttpStatus.SEE_OTHER);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addAccount(@RequestBody Account account){
		Account addD = accountService.add(account);
		if(addD != null) {
			return new ResponseEntity<>(account, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Them moi 1 acc khong thanh cong!", HttpStatus.SEE_OTHER);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateAccount(@RequestBody Account account){
		Account updateD = accountService.update(account);
		if(updateD != null) {
			return new ResponseEntity<>(account, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Sua thong tin account khong thanh cong!", HttpStatus.SEE_OTHER);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("id") int idacc){
		boolean result = accountService.deleteAccountById(idacc);
		if(result) {
			return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Delete Account unsucessfully!", HttpStatus.SEE_OTHER);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> accountList(){
		List<Account> dtrList = accountService.AccList();
		logger.info("danh sach acc: {}", dtrList);
		return new ResponseEntity<>(dtrList, HttpStatus.OK);
//		if(dtrList.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			
//		}
//		else {
//			return new ResponseEntity<>(dtrList, HttpStatus.OK);
//		}
	}
	
}
