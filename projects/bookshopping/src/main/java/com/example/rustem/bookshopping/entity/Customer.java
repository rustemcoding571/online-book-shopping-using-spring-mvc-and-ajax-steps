package com.example.rustem.bookshopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Boş qoymaq olmaz")
	@Size(min = 2, message = "Minimum 2 simvol yazmaq lazımdır")
	@Size(max = 30, message = "Maksimum 30 simvol yazmaq lazımdır")
	@Column(columnDefinition = "VARCHAR(30)")
	private String name;

	@NotEmpty(message = "Boş qoymaq olmaz")
	@Size(min = 2, message = "Minimum 2 simvol yazmaq lazımdır")
	@Size(max = 200, message = "Maksimum 200 simvol yazmaq lazımdır")
	@Column(columnDefinition = "VARCHAR(200)")
	private String address;

	@NotEmpty(message = "Boş qoymaq olmaz")
	@Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}", message = "Telefonu düzgün formada yazın. Məsələn: 000-000-0000")
	@Column(columnDefinition = "VARCHAR(20)")
	@Size(max = 20, message = "Maksimum 20 simvol yazmaq lazımdır")
	private String phone;

	@NotEmpty(message = "Boş qoymaq olmaz")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Emaili düzgün formada yazın")
	@Column(columnDefinition = "VARCHAR(100)")
	@Size(max = 100, message = "Maksimum 100 simvol yazmaq lazımdır")
	private String email;

	@Column(columnDefinition = "VARCHAR(100)")
	@Size(max = 100, message = "Maksimum 100 simvol yazmaq lazımdır")
	private String note;

}
