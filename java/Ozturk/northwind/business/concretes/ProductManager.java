package Ozturk.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import Ozturk.northwind.business.abstracts.ProductService;
import Ozturk.northwind.core.utilities.results.DataResult;
import Ozturk.northwind.core.utilities.results.Result;
import Ozturk.northwind.core.utilities.results.SuccessDataResult;
import Ozturk.northwind.core.utilities.results.SuccessResult;
import Ozturk.northwind.dataAccess.abstracts.ProductDao;
import Ozturk.northwind.entities.concretes.Product;
import Ozturk.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

		private ProductDao productDao;
	
		@Autowired
		public ProductManager(ProductDao productDao) {
			super();
			this.productDao = productDao;
		}


		@Override
		public DataResult<List<Product>> getAll() {
		
			return new SuccessDataResult<List<Product>>(productDao.findAll(),"Ürünler Listelendi");
	}


		@Override
		public Result add(@RequestBody Product product) { //@RequestBody istenilen dataları vermeyi sağlar. productName vs gibi
			 productDao.save(product);
			return new SuccessResult("Ürün eklendi  ");
		}


		@Override
		public DataResult<Product> getByProductName(String productName) {
			
			return new SuccessDataResult<Product>(productDao.getByProductName(productName),"Data Listelendi");
		}


		@Override
		public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
			
			//business code
			
			return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),
					"Data Listelendi");
		}


		@Override
		public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
			
			return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory(productName, categoryId),
					"Data Listelendi");
		}


		@Override
		public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
			
			return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories),"Data Listelendi");
		}


		@Override
		public DataResult<List<Product>> getByProductNameContains(String productName) {
			
			return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName),
					"Data listelendi");
		}


		@Override
		public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
			
			return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName),
					"Data listelendi");
		}


		@Override
		public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {

			return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName, categoryId),
					"Data listelendi");
		}


		@Override
		public DataResult<List<Product>> getAll(int pageNo, int pageSize) { //sayfalama yapmak için
			
			Pageable pageable = PageRequest.of(pageNo-1, pageSize);
			
			return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent(),"Sayfa getirildi");
		}


		@Override
		public DataResult<List<Product>> getAllSorted() { // Z'den A'ya doğru
			 
			Sort sort = Sort.by(Sort.Direction.DESC,"productName");
			
			return new SuccessDataResult<List<Product>>(productDao.findAll(sort), "Sıralama Başarılı");
		}


		@Override
		public DataResult<List<Product>> getAllSortedUnitPrice() {
			
			Sort sort = Sort.by(Sort.Direction.ASC,"unitPrice");
			
			return new SuccessDataResult<List<Product>>(productDao.findAll(sort), "Sıralama Başarılı");
		}


		@Override
		public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {

			return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getProductWithCategoryDetails(),"Ürünler Listelendi");
		}

}
