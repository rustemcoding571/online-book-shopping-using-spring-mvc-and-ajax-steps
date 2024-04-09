package com.example.rustem.bookshopping.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.rustem.bookshopping.entity.BasketBook;
import com.example.rustem.bookshopping.entity.Customer;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	private Integer id;
	private String note;
	@NotEmpty(message = "Boş qoymaq olmaz!")
	@Size(min = 2, message = "Sifarişin adını doğru daxil edin min 2")
	@Size(max = 50, message = "Sifarişin adını doğru daxil edin max 20")
	private String name;
	@NotNull(message = "boş qoymaq olmaz ")
	@Min(value = 1_0, message = "Sifarişin qiymətini doğru daxil edin:min 10")
	@Max(value = 10_000, message = "Sifarişin qiymətini doğru daxil edin:min 10000")
	private Double totalPrice;
	private Timestamp register;
	private Customer customer;
	private List<BasketBook> basketBooks;
	private String username;

	public Integer getId() {
		return id;
	}

	public String getNote() {
		return note;
	}

	public String getName() {
		return name;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public Timestamp getRegister() {
		return register;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<BasketBook> getBasketBooks() {
		if (basketBooks == null) {
			basketBooks = new ArrayList<BasketBook>();
		}
		return basketBooks;
	}

	public String getUsername() {
		return username;
	}

}
