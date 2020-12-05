package clinic.Service.Implements;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import clinic.repository.AccountRepository;
import clinic.Account;
import clinic.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account add(Account account) {
		return accountRepository.save(account);
	}
	
	@Override
	public Account update(Account account) {
		if(checkAccount(account.getId())) {
			return accountRepository.save(account);
		}
		return null;
	}
	
	private boolean checkAccount(int idacc) {
		Account existedD = accountRepository.findById(idacc).orElse(null);
		if(existedD == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Account> AccList() {
		// TODO Auto-generated method stub
		List<Account> ds = accountRepository.findAll();
		return ds;
	}

	@Override
	public Account searchAccountByID(int idacc) {
		// TODO Auto-generated method stub
		Account acc = accountRepository.findById(idacc).orElse(null);
		return acc;
	}

	@Override
	public boolean deleteAccountById(int idacc) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(checkAccount(idacc)) {
			accountRepository.deleteById(idacc);
			result = true;
		}
		return result;
	}
}
