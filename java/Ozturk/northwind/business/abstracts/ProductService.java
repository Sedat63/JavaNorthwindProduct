package Ozturk.northwind.business.abstracts;

import java.util.List;


import Ozturk.northwind.core.utilities.results.DataResult;
import Ozturk.northwind.core.utilities.results.Result;
import Ozturk.northwind.entities.concretes.Product;
import Ozturk.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

		DataResult<List<Product>>  getAll();
		
		DataResult<List<Product>>  getAll(int pageNo, int pageSize); //sayfalama yapmak için
		
		DataResult<List<Product>>  getAllSorted(); //ürün ismine göre
		
		DataResult<List<Product>>  getAllSortedUnitPrice(); //ürün fiyatına göre
		
		Result add(Product product);
		
		DataResult<Product>  getByProductName(String productName); //getBy yazmak önemli sonra istenileni yaz.
		
		DataResult<Product>  getByProductNameAndCategoryId(String productName, int categoryId); //And ile where koşulu yazar.
		
		DataResult<List<Product>>   getByProductNameOrCategoryId(String productName, int categoryId); //Or  ile where koşulu yazar.
		
		DataResult<List<Product>>  getByCategoryIdIn(List<Integer> categories); // category id 1,2,3 gibi birden fazla olursa
		
		DataResult<List<Product>>  getByProductNameContains(String productName); //ürün ismi içeriyorsa.
		
		DataResult<List<Product>>  getByProductNameStartsWith(String productName); //ürün ismi hangi harfle başlar.
		
		
		DataResult<List<Product>>   getByNameAndCategory(String productName, int categoryId); // eşittirin sağındaki
		
		DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
