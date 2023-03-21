package Ozturk.northwind.business.abstracts;

import Ozturk.northwind.core.entities.User;
import Ozturk.northwind.core.utilities.results.DataResult;
import Ozturk.northwind.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	DataResult<User>findByEmail(String email);
}
