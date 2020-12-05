package clinic.Service;
import java.util.List;
import clinic.Account;
public interface AccountService {
	
	public Account add(Account account);
	
	public Account update(Account account);
	
	public List<Account> AccList();
	
	public Account searchAccountByID(int idac);
	
	public boolean deleteAccountById(int idac);
}
