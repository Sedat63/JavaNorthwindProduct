package Ozturk.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Ozturk.northwind.business.abstracts.ProductService;
import Ozturk.northwind.core.utilities.results.DataResult;
import Ozturk.northwind.core.utilities.results.Result;
import Ozturk.northwind.entities.concretes.Product;
import Ozturk.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

	
		private ProductService productService; // Api isteği önce business'e iletir ordan geçerse DataAccese gider.
	
		 @Autowired
		public ProductsController(ProductService productService) {
			super();
			this.productService = productService;
		}

		@GetMapping("/getall")
		public DataResult<List<Product>> getAll(){
			
			return productService.getAll();
			
		}
		
		@PostMapping("/add")
		public Result add(Product product) {
			
			return productService.add(product);
		}
		
		@GetMapping("/getByProductName")
		public DataResult<Product> getByProductName(@RequestParam String productName){
			
			return productService.getByProductName(productName);
		}
		
		@GetMapping("/getByNameAndCategoryId")
		public DataResult<Product>  getByProductNameAndCategoryId(@RequestParam("productName") String productName,  
				@RequestParam("categoryId") int categoryId){
			
			return productService.getByProductNameAndCategoryId(productName, categoryId);
		}
		
		@GetMapping("/getByProductNameContains")
		public DataResult<List<Product>>  getByProductNameContains(@RequestParam String productName){
			
			return productService.getByProductNameContains(productName);
		}
		
		@GetMapping("/getAllByPage")
		DataResult<List<Product>>  getAll(int pageNo, int pageSize){
			
			return productService.getAll(pageNo, pageSize);
					
		}
		
		@GetMapping("/getAllSortedDesc")
		public DataResult<List<Product>> getAllSorted() {
			
			return productService.getAllSorted();
		}
		
		@GetMapping("/getAllSortedAsc")
		public DataResult<List<Product>> getAllSortedUnitPrice(){
		
			return productService.getAllSortedUnitPrice();
			
		}
		
		@GetMapping("/getProductWithCategoryDetails")
		public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
			
			return productService.getProductWithCategoryDetails();
			
		}
		 
}
