package Ozturk.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ozturk.northwind.business.abstracts.UserService;
import Ozturk.northwind.core.dataAccess.UserDao;
import Ozturk.northwind.core.entities.User;
import Ozturk.northwind.core.utilities.results.DataResult;
import Ozturk.northwind.core.utilities.results.Result;
import Ozturk.northwind.core.utilities.results.SuccessDataResult;
import Ozturk.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public Result add(User user) {
		
		userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccessDataResult<User>(userDao.findByEmail(email), "Kullanıcı Bulundu");
	}

}
