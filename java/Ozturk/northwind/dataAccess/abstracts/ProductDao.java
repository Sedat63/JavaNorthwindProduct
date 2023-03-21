package Ozturk.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Ozturk.northwind.entities.concretes.Product;
import Ozturk.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> { // interface interface'i extends eder.

		Product  getByProductName(String productName); //getBy yazmak önemli sonra istenileni yaz.
		
		Product  getByProductNameAndCategory_CategoryId(String productName, int categoryId); //And ile where koşulu yazar.
		
		List<Product>  getByProductNameOrCategory(String productName, int categoryId); //Or  ile where koşulu yazar.
		
		List<Product> getByCategoryIn(List<Integer> categories); // category id 1,2,3 gibi birden fazla olursa
		
		List<Product>  getByProductNameContains(String productName); //ürün ismi içeriyorsa.
		
		List<Product>  getByProductNameStartsWith(String productName); //ürün ismi hangi harfle başlar.
		
		
		@Query("From Product where productName=:productName and  category.categoryId=:categoryId")
		List<Product>  getByNameAndCategory(String productName, int categoryId); // eşittirin sağındaki
		
		@Query("Select new Ozturk.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName ) "
				+ "From Category c Inner Join c.products p") //
		List<ProductWithCategoryDto> getProductWithCategoryDetails();
		
		//select p.product_id,p.product_name, c.category_name,p.unit_price from products p inner join categories c 
		//on p.category_id =c.category_id
		
}
